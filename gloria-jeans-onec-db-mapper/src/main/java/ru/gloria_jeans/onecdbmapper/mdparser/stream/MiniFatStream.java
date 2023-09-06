package ru.gloria_jeans.onecdbmapper.mdparser.stream;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class MiniFatStream {
    private CompoundHeader m_header;
    private FatStream Fat;
    private DirectoryEntry Root;
    private long m_position;
    private ByteBuffer mr;
    private final long DIFSECT = 0xFFFFFFFCL;
    private final long FATSECT = 0xFFFFFFFDL;
    private final long ENDOFCHAIN = 0xFFFFFFFEL;
    private final long FREESECT = 0xFFFFFFFFL;
    private ByteBuffer dmr;
    private byte[] b64 = new byte[64];
    private byte[] b4 = new byte[4];
    private byte[] b512 = new byte[512];

    public MiniFatStream(CompoundHeader header, FatStream FATs, DirectoryEntry RootEntry) throws Exception {
        m_header = header;
        Fat = FATs;
        Root = RootEntry;
        parce();
    }

    private void parce() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Fat.setPosition(m_header.getSectMiniFatStart());

        while (true) {
            long poz = Fat.getPosition();
            long vvv = Fat.gethValue();
            outputStream.write(Fat.getvValue());

            if (vvv == poz) {
                throw new Exception("Зацикливание потока ");
            }

            if (vvv == ENDOFCHAIN || vvv == FREESECT) {
                break;
            }

            Fat.setPosition(Fat.gethValue());
        }

        mr = ByteBuffer.allocate(outputStream.toByteArray().length);
        mr.put(outputStream.toByteArray());

        outputStream = new ByteArrayOutputStream();
        Fat.setPosition(Root.getM_sectStart());

        while (true) {
            long poz = Fat.getPosition();
            long vvv = Fat.gethValue();

            outputStream.write(Fat.getvValue());

            if (vvv == poz) {
                throw new Exception("Зацикливание потока ");
            }

            if (vvv == ENDOFCHAIN || vvv == FREESECT) {
                break;
            }

            Fat.setPosition(Fat.gethValue());
        }

        dmr = ByteBuffer.allocate(outputStream.toByteArray().length);
        dmr.put(outputStream.toByteArray());
    }

    public long getPosition() {
        return m_position;
    }

    public void setPosition(long position) throws Exception {
        if (m_position > 128 * m_header.getCsectMiniFat()) {
            throw new Exception("Указан недопустимый индекс Position. Длина потока меньше чем указанный индекс");
        }

        this.m_position = position;
    }

    public long gethValue() {
        mr.position((int)m_position * 4);
        mr.get(b4, (int)m_position * 4, b4.length);
        return OnecConverter.getUnsignedInt(b4);
    }

    public void sethValue(long value) {
        b4 = ByteBuffer.allocate(4).putLong(value).array();
        mr.position((int)m_position * 4);
        mr.put(b4, 0, 4);
        //Теперь надо найти куда это писать в файле..
        long z = Math.abs(m_position / 128);
        Fat.setPosition(m_header.getSectMiniFatStart());

        for (int i = 0; i < z; i++) {
            Fat.setPosition(Fat.gethValue());
        }

        long zz = m_position - (z * 128);
        b512 = Fat.getvValue();

        for (int i = 0; i < b4.length; i++) {
            b512[(int)zz + i] = b4[i];
        }

        Fat.setvValue(b512);
    }

    public byte[] getvValue() {
        dmr.position((int)m_position * 64);
        dmr.get(b64, 0, 64);
        return b64;
    }

    public void setvValue(byte[] value) {
        dmr.position((int)m_position * 64);
        dmr.put(value, 0, 64);
        //Теперь надо найти куда это писать в файле..
        long z = Math.abs(m_position / 8);
        Fat.setPosition(m_header.getSectMiniFatStart());

        for (int i = 0; i < z; i++) {
            Fat.setPosition(Fat.gethValue());
        }

        long zz = m_position - (z * 8);
        b512 = Fat.getvValue();

        for (int i = 0; i < value.length; i++) {
            b512[(int)zz + i] = value[i];
        }

        Fat.setvValue(b512);
    }

    public long getLength() {
        return m_header.getCsectMiniFat() * 128;
    }
}
