package ru.gloria_jeans.onecdbmapper.mdparser.stream;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class CompoundParser {
    private ByteBuffer cFile;
    private CompoundHeader compoundHeader;
    public DirectoryEntry RootEntry;
    private FatStream FATstream;
    private MiniFatStream miniFATStream;
    private DirectoryStream DirectoryInfoStream;

    private final long DIFSECT = 0xFFFFFFFCL;
    private final long FATSECT = 0xFFFFFFFDL;
    private final long ENDOFCHAIN = 0xFFFFFFFEL;
    private final long FREESECT = 0xFFFFFFFFL;

    private byte[] free64;// = new byte[64];
    private byte[] free512;// = new byte[512];

    public CompoundParser(byte[] bytesOfFile) throws Exception {
        cFile = ByteBuffer.wrap(bytesOfFile);
        free64 = new byte[64];
        free512 = new byte[512];

        for (int i = 0; i < free64.length; i++) {
            free64[i] = (byte) 0xFF;
        }

        for (int i = 0; i < free512.length; i++) {
            free512[i] = (byte) 0xFF;
        }

        parceHeader();
    }


    private boolean parceHeader() throws Exception {
        byte[] buff = new byte[4];
        cFile.get(buff, 0, 4);

        // сигнатура файла
        if ((buff[0] & 0xFF) != 0xD0 || (buff[1] & 0xFF) != 0xCF || (buff[2] & 0xFF) != 0x11 || (buff[3] & 0xFF) != 0xE0) {
            // Это не наш файл, хрень какая то
            throw new Exception("Неверная сигнатура потока");
        }

        compoundHeader = new CompoundHeader(cFile);
        FATstream = new FatStream(cFile, compoundHeader);
        DirectoryInfoStream = new DirectoryStream(compoundHeader, FATstream);
        DirectoryInfoStream.setPosition(0);
        RootEntry = new DirectoryEntry(DirectoryInfoStream, 0);
        miniFATStream = new MiniFatStream(compoundHeader, FATstream, RootEntry);

        if (RootEntry.getM_sidChild() != FREESECT) {
            getNode(RootEntry.getM_sidChild(), RootEntry);
        }

        return true;
    }

    private void getNode(long sid, DirectoryEntry dd) throws Exception {
        DirectoryInfoStream.setPosition(sid);
        DirectoryEntry d1 = new DirectoryEntry(DirectoryInfoStream, (int)sid);
        dd.getIchilds().put(d1.getM_ab(), d1);

        if (d1.getM_sidLeftSib() != FREESECT) {
            getNode(d1.getM_sidLeftSib(), dd);
        }

        if (d1.getM_sidRightSib() != FREESECT) {
            getNode(d1.getM_sidRightSib(), dd);
        }

        if (d1.getM_sidChild() != FREESECT) {
            getNode(d1.getM_sidChild(), d1);
        }
    }


    public byte[] read(String moduleName) throws Exception {
        moduleName = moduleName.replace("Root Entry/", "");
        String[] modules = moduleName.split("/");
        DirectoryEntry myEntry = RootEntry.clone();
        String name = "";

        for (String module : modules) {
            try {
                StringBuilder search = new StringBuilder();

                for (int i = 0; i < module.length(); i++) {
                    search.append(module.charAt(i)).append('\0');
                }

                while (search.length() < 64) {
                    search.append('\0');
                }

                name = search.toString();
                myEntry = myEntry.getIchilds().get(name);
            } catch (Exception e) {
                throw new Exception("Не существует эл-та " + name + " в ветке " + myEntry.getM_ab());
            }
        }

        ByteBuffer Ob = ByteBuffer.allocate((int)myEntry.getM_ulSize());

        if (myEntry.getM_ulSize() < compoundHeader.getUlMiniSectorCutoff()) {
            long tLen = myEntry.getM_ulSize();
            long NextMiniFat;
            miniFATStream.setPosition(myEntry.getM_sectStart());

            while (true) {
                NextMiniFat = miniFATStream.gethValue();

                if (tLen > 64) {
                    Ob.put(ByteBuffer.allocate(4).putLong(miniFATStream.gethValue()).array(), 0, 64);
                } else {
                    Ob.put(ByteBuffer.allocate(4).putLong(miniFATStream.gethValue()).array(), 0, (int)tLen);
                }

                if (NextMiniFat == ENDOFCHAIN || NextMiniFat == FREESECT) {
                    break;
                }

                tLen = tLen - 64;
                miniFATStream.setPosition(miniFATStream.gethValue());
            }
        } else {
            long tLen = myEntry.getM_ulSize();
            long NextFat;
            FATstream.setPosition(myEntry.getM_sectStart());

            while (true) {
                NextFat = FATstream.gethValue();

                if (tLen > 512) {
                    Ob.put(FATstream.getvValue(), 0, 512);
                } else {
                    Ob.put(FATstream.getvValue(), 0, (int)tLen);
                }

                if (NextFat == ENDOFCHAIN || NextFat == FREESECT) {
                    break;
                }

                FATstream.setPosition(NextFat);
                tLen = tLen - 512;
            }
        }

        return Ob.array();
    }

    public void replace(String moduleName, byte[] content) throws Exception {
        moduleName = moduleName.replace("Root Entry/", "");
        String[] sss = moduleName.split("/");
        DirectoryEntry myEntry = (DirectoryEntry)RootEntry;

        for (String s1 : sss) {
            try {
                String serach = s1;

                while (serach.length() < 32) {
                    serach += '\0';
                }

                myEntry = myEntry.getIchilds().get(serach);
            } catch (Exception e) {
                throw new Exception("Не существует эл-та " + s1 + " в ветке " + myEntry.getM_ab());
            }
        }

        List<Long> oldChain = new ArrayList<>();
        List<Long> oldMiniChain = new ArrayList<>();
        ByteBuffer contentStream = ByteBuffer.wrap(content);
        //Сначала затрем старый блок

        if (myEntry.getM_ulSize() < compoundHeader.getUlMiniSectorCutoff()) {
            long NextMiniFat;
            miniFATStream.setPosition(myEntry.getM_sectStart());

            while (true) {
                NextMiniFat = miniFATStream.gethValue();
                oldMiniChain.add(NextMiniFat);
                miniFATStream.setvValue(free64);
                miniFATStream.sethValue(FREESECT);
                compoundHeader.setCsectMiniFat(compoundHeader.getCsectMiniFat() - 1);

                if (NextMiniFat == ENDOFCHAIN || NextMiniFat == FREESECT) {
                    break;
                }

                miniFATStream.setPosition(NextMiniFat);
            }
        } else {
            long NextFat;
            FATstream.setPosition(myEntry.getM_sectStart());

            while (true) {
                NextFat = FATstream.gethValue();
                oldChain.add(NextFat);
                FATstream.setvValue(free512);
                FATstream.setPosition(FREESECT);
                compoundHeader.setCsectFAT(compoundHeader.getCsectFAT() - 1);

                if (NextFat == ENDOFCHAIN || NextFat == FREESECT) {
                    break;
                }

                FATstream.setPosition(NextFat);
            }
        }

        long ulSize = content.length;
        myEntry.setM_ulSize(ulSize);

        //Теперь пишем даные заново
        if (myEntry.getM_ulSize() < compoundHeader.getUlMiniSectorCutoff()) {
            if (oldMiniChain.size() == 0) {
                miniFATStream.setPosition(miniFATStream.getLength());
                myEntry.setM_sectStart(miniFATStream.getPosition());
            } else {
                miniFATStream.setPosition(myEntry.getM_sectStart());
            }

            long tLen = myEntry.getM_ulSize();
            byte[] byff = new byte[64];
            //запихнем все что помещается на место затертых блоков MiniFat
            int indexer = 0;

            while (tLen > 0) {
                //              miniFATStream.Position = myEntry._sectStart;
                if (oldMiniChain.size() - 1 == indexer) {
                    break;
                }

                long block = oldMiniChain.get(indexer);
                miniFATStream.sethValue(oldMiniChain.get(indexer));
                contentStream.get(byff, 0, byff.length);
                miniFATStream.setvValue(byff);
                tLen = tLen - 64;
                miniFATStream.setPosition(oldMiniChain.get(indexer));
                indexer++;
            }

            if (tLen > 0) {
                while (tLen > 0) {
                    miniFATStream.sethValue(miniFATStream.getLength());
                    contentStream.get(byff, 0, byff.length);
                    miniFATStream.setvValue(byff);
                    miniFATStream.setPosition(miniFATStream.getLength());
                    tLen = tLen - 64;
                }
            }
        } else {
            long tLen = myEntry.getM_ulSize();
            //запихнем все что помещается на место затертых блоков Fat
        }

        cFile.position(0);
    }
}
