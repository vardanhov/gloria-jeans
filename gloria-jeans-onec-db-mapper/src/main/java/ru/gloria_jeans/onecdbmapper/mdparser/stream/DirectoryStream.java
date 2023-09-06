package ru.gloria_jeans.onecdbmapper.mdparser.stream;

import java.util.Arrays;

public class DirectoryStream {
    private CompoundHeader m_header;
    private FatStream Fat;
    private long m_position;
    private byte[] b128 = new byte[128];
    private byte[] b512 = new byte[512];


    private final long DIFSECT = 0xFFFFFFFCL;
    private final long FATSECT = 0xFFFFFFFDL;
    private final long ENDOFCHAIN = 0xFFFFFFFEL;
    private final long FREESECT = 0xFFFFFFFFL;

    public DirectoryStream(CompoundHeader header, FatStream FATs) {
        m_header = header;
        Fat = FATs;
    }

    public long getPosition() {
        return m_position;
    }

    public void setPosition(long pos) {
        m_position = pos;
    }

    public byte[] getValue() throws Exception {
        //в одном FAT блоке помещается 4 ветки
        //Вычисляем нужный нам блок в цепочке
        Fat.setPosition(m_header.getCsectDirStart());
        long dirC = Math.abs(m_position / 4);
        long mPos = m_position;

        while (dirC > 0) {
            long poz = Fat.getPosition();
            long hVal = Fat.gethValue();

            if (poz == hVal) {
                throw new Exception("Зацикливание потока");
            }

            if (hVal == FREESECT || hVal == ENDOFCHAIN) {
                throw new Exception("Ошибка Directory потока ");
            }

            if (hVal > Fat.getLength()) {
                throw new Exception("Выход за пределы длины потока");
            }

            Fat.setPosition(hVal);
            mPos = mPos - 4;
            dirC--;
        }

        b128 = Arrays.copyOfRange(Fat.getvValue(), (int)mPos * 128, (int)mPos * 128 + 128);
        return b128;
    }

    public void setValue(byte[] value) throws Exception {
        //в одном FAT блоке помещается 4 ветки
        //Вычисляем нужный нам блок в цепочке
        Fat.setPosition(m_header.getCsectDirStart());
        long dirC = Math.abs(m_position / 4);
        long mPos = m_position;

        while (dirC > 0) {
            long poz = Fat.getPosition();
            long hVal = Fat.gethValue();

            if (poz == hVal) {
                throw new Exception("Зацикливание потока");
            }

            if (hVal == FREESECT || hVal == ENDOFCHAIN) {
                throw new Exception("Ошибка Directory потока ");
            }

            if (hVal > Fat.getLength()) {
                throw new Exception("Выход за пределы длины потока");
            }

            Fat.setPosition(hVal);
            mPos = mPos - 4;
            dirC--;
        }
        b512 = Fat.getvValue();

        for (int i = 0; i < 128; i++) {
            b512[(int)mPos * 128 + i] = value[i];
        }

        Fat.setvValue(b512);
    }
}
