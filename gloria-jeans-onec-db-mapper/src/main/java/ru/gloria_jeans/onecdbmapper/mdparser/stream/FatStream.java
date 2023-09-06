package ru.gloria_jeans.onecdbmapper.mdparser.stream;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class FatStream {
    private ByteBuffer s;
    private CompoundHeader m_header;
    private ByteBuffer mr;
    private long hValue;

    private final long DIFSECT = 0xFFFFFFFCL;
    private final long FATSECT = 0xFFFFFFFDL;
    private final long ENDOFCHAIN = 0xFFFFFFFEL;
    private final long FREESECT = 0xFFFFFFFFL;

    private long m_Position;
    private byte[] b4 = new byte[4];
    private byte[] b512 = new byte[512];

    public FatStream(ByteBuffer BaseStream, CompoundHeader Header) throws IOException {
        s = BaseStream;
        m_header = Header;
        m_Position = 0;
        parceStream();
    }

    private void parceStream() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] b5122 = new byte[512];

        for (int i = 0; i < 109; i++) {
            s.position(0x4C + i * 4);
            s.get(b4, 0, 4);
            s.position(((int)OnecConverter.getUnsignedInt(b4) + 1) << m_header.getuSectorShift());
            s.get(b5122, 0, b5122.length);
            outputStream.write(b5122);
        }

        if (m_header.getCsectDif() > 0) {
            s.position(((int)m_header.getCsectDifStart() + 1) << m_header.getuSectorShift());

            while (true) {
                s.get(b512, 0, b512.length);

                for (int i = 0; i < 127; i++) {
                    b4 = Arrays.copyOfRange(b512, i * 4, i * 4 + 4);
                    s.position(((int)OnecConverter.getUnsignedInt(b4) + 1) << m_header.getuSectorShift());
                    s.get(b5122, 0, b5122.length);
                    outputStream.write(b5122);
                }

                b4 = Arrays.copyOfRange(b512, 127 * 4, (127 * 4) + 4);
                long zz = OnecConverter.getUnsignedInt(b4);

                if (zz == FREESECT || zz == ENDOFCHAIN) {
                    break;
                }

                s.position((int) ((zz + 1) << m_header.getuSectorShift()));
            }
        }

        mr = ByteBuffer.allocate(outputStream.toByteArray().length);
        mr.put(outputStream.toByteArray());
    }

    public long getPosition() {
        return m_Position;
    }

    public void setPosition(long position) {
        if (position > m_header.getCsectFAT() * 128) {
            throw new IndexOutOfBoundsException("Указан недопустимый индекс. Длина потока меньше чем указанный индекс.");
        }

        this.m_Position = position;
    }

    public long gethValue() {
        mr.position((int)this.m_Position * 4);
        mr.get(b4, 0, 4);
        hValue = OnecConverter.getUnsignedInt(b4);
        return hValue;
    }

    public void sethValue(long hValue) {
        if (this.m_Position > 13952/*109 * 128*/) {
            if (m_header.getCsectDif() == 0) {
                throw new IndexOutOfBoundsException("Указан недопустимый индекс Position. Длина потока меньше чем указанный индекс");
            }

            //Сначала определим в каком блоке DIF надо искать наш сектор
            //в одном блоке DIF может поместиться 127*128 FAT секторов...
            //Индекс в шапке адресует прямо к нужному блоку , т.е. вычислять ничего по сути не надо - только прочитать данные в нужном счещении
            long DIFpos = Math.abs((m_Position - 13952 /*109 * 128*/) / 16256 /*(127 * 128)*/);
            long mmpos = m_Position - 13952 /*(128*109)*/;

            if (DIFpos > (m_header.getCsectDif() - 1)) {
                throw new IndexOutOfBoundsException("Указан недопустимый индекс Position. Длина потока меньше чем указанный индекс");
            }

            s.position(((int)m_header.getCsectDifStart() + 1) << m_header.getuSectorShift());

            while (DIFpos > 0) {
                s.get(b512, 0, b512.length);
                b4 = Arrays.copyOfRange(b512, b512.length - 4, b512.length);
                s.position(((int)OnecConverter.getUnsignedInt(b4) + 1) << m_header.getuSectorShift());
                DIFpos--;
                mmpos = mmpos - 16256 /*(127*128)*/;
            }

            s.position((int) (s.position() + (Math.abs(mmpos / 128)) * 4));
            s.get(b4, 0, 4);
            long tpos = OnecConverter.getUnsignedInt(b4);
            s.position((int) (((tpos << m_header.getuSectorShift()) + (/*1 << m_header._uSectorShift*/512)) + ((mmpos * 4) - ((Math.abs(mmpos / 128)) * 512))));
            s.put(ByteBuffer.allocate(4).putLong(hValue).array(), 0, 4);//.Read(b4, 0, 4);
        } else {
            s.position(0x4C + (int)(Math.abs(m_Position / 128)) * 4);
            s.get(b4, 0, 4);
            long tpos = OnecConverter.getUnsignedInt(b4);
            s.position((int) (((tpos << m_header.getuSectorShift()) + (/*1 << m_header._uSectorShift*/512)) + ((m_Position * 4) - ((Math.abs(m_Position / 128)) * 512))));
            s.put(ByteBuffer.allocate(4).putLong(hValue).array(), 0, 4);
        }

        mr.position((int)m_Position * 4);
        mr.putLong(hValue);
        this.hValue = hValue;
    }

    public long getLength() {
        return m_header.getCsectFAT() * 128;
    }

    public byte[] getvValue() {
        byte[] bufferBytes = new byte[512];
        s.position(((int)m_Position + 1) << m_header.getuSectorShift());
        s.get(bufferBytes, 0, bufferBytes.length);
        return bufferBytes;
    }

    public void setvValue(byte[] vValue) {
        s.position(((int)m_Position + 1) << m_header.getuSectorShift());
        s.put(vValue, 0, vValue.length);
    }
}
