package ru.gloria_jeans.onecdbmapper.mdparser.stream;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DirectoryEntry implements Cloneable {
    byte[] b128;
    byte[] b64 = new byte[64];
    byte[] b2 = new byte[2];
    byte[] b4 = new byte[4];
    private String m_ab;
    private int m_cb;
    private tagSTGTY m_mse;
    private tagDECOLOR m_bflags;
    private int m_dptPropType;
    private long m_sidLeftSib;
    private long m_sidRightSib;
    private long m_sidChild;
    private byte[] m_clsId;
    private long m_dwUserFlags;
    private byte[] m_time;
    private long m_sectStart;
    private long m_ulSize;
    private Map<String, DirectoryEntry> m_childs;
    private long m_SID;
    DirectoryStream s1;

    public DirectoryEntry(DirectoryStream s, int SID) throws Exception {
        s1 = s;
        setISID(SID);
        setIchilds(new HashMap<>());
        b128 = s1.getValue();

        byte[] buff = new byte[64];
        buff = Arrays.copyOfRange(b128, 0x00, buff.length);
        m_ab = new String(buff, Charset.forName("windows-1251"));
        buff = new byte[2];
        buff = Arrays.copyOfRange(b128, 0x40, 0x40 + buff.length);
        m_cb = OnecConverter.getUnsignedShort(buff);
        m_mse = tagSTGTY.valueOf(b128[0x42]);
        m_bflags = tagDECOLOR.valueOf(b128[0x43]);
        buff = Arrays.copyOfRange(b128, 0x7C, 0x7C + buff.length);
        m_dptPropType = OnecConverter.getUnsignedShort(buff);
        buff = new byte[4];
        buff = Arrays.copyOfRange(b128, 0x44, 0x44 + buff.length);
        m_sidLeftSib = OnecConverter.getUnsignedInt(buff);
        buff = Arrays.copyOfRange(b128, 0x48, 0x48 + buff.length);
        m_sidRightSib = OnecConverter.getUnsignedInt(buff);
        buff = Arrays.copyOfRange(b128, 0x4C, 0x4C + buff.length);
        m_sidChild = OnecConverter.getUnsignedInt(buff);
        m_clsId = new byte[16];
        m_clsId = Arrays.copyOfRange(b128, 0x50, 0x50 + m_clsId.length);
        buff = Arrays.copyOfRange(b128, 0x60, 0x60 + buff.length);
        m_dwUserFlags = OnecConverter.getUnsignedInt(buff);
        m_time = new byte[16];
        m_time = Arrays.copyOfRange(b128, 0x64, 0x64 + m_time.length);
        buff = Arrays.copyOfRange(b128, 0x74, 0x74 + buff.length);
        m_sectStart = OnecConverter.getUnsignedInt(buff);
        buff = Arrays.copyOfRange(b128, 0x78, 0x78 + buff.length);
        m_ulSize = OnecConverter.getUnsignedInt(buff);
    }

    public long getISID() {
        return m_SID;
    }

    public void setISID(int value) {
        m_SID = value;
    }

    public Map<String, DirectoryEntry> getIchilds() {
        return m_childs;
    }

    public void setIchilds(HashMap<String, DirectoryEntry> value) {
        m_childs = value;
    }

    public byte[] getB128() {
        return b128;
    }

    public void setB128(byte[] b128) {
        this.b128 = b128;
    }

    public byte[] getB64() {
        return b64;
    }


    public void setB64(byte[] b64) {
        this.b64 = b64;
    }

    public byte[] getB2() {
        return b2;
    }

    public void setB2(byte[] b2) {
        this.b2 = b2;
    }

    public byte[] getB4() {
        return b4;
    }

    public void setB4(byte[] b4) {
        this.b4 = b4;
    }

    public String getM_ab() {
        return m_ab;
    }

    public void setM_ab(String m_ab) throws Exception {
        StringBuilder search = new StringBuilder();

        for (int i = 0; i < m_ab.length(); i++) {
            search.append(m_ab.charAt(i)).append('\0');
        }

        while (search.length() < 64) {
            search.append('\0');
        }

        this.m_ab = search.toString();
        s1.setPosition(getISID());
        b128 = s1.getValue();
        b64 =  this.m_ab.getBytes(Charset.forName("windows-1251"));

        for (int i = 0; i < b64.length; i++) {
            b128[i] = b64[i];
        }

        s1.setValue(b128);
    }

    public int getM_cb() {
        return m_cb;
    }

    public void setM_cb(int m_cb) throws Exception {
        this.m_cb = m_cb;
        b128 = s1.getValue();
        b2 = ByteBuffer.allocate(b2.length).putInt(m_cb).array();

        for (int i = 0; i < b2.length; i++) {
            b128[0x40 + i] = b2[i];
        }

        s1.setValue(b128);
    }

    public tagSTGTY getM_mse() {
        return m_mse;
    }

    public void setM_mse(tagSTGTY m_mse) {
        this.m_mse = m_mse;
    }

    public tagDECOLOR getM_bflags() {
        return m_bflags;
    }

    public void setM_bflags(tagDECOLOR m_bflags) throws Exception {
        this.m_bflags = m_bflags;
        b128 = s1.getValue();
        b128[0x43] = (byte) m_bflags.getValue();
        s1.setValue(b128);
    }

    public int getM_dptPropType() {
        return m_dptPropType;
    }

    public void setM_dptPropType(int m_dptPropType) throws Exception {
        this.m_sidChild = m_dptPropType;

        b4 = ByteBuffer.allocate(b4.length).putInt(m_dptPropType).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x7C + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public long getM_sidLeftSib() {
        return m_sidLeftSib;
    }

    public void setM_sidLeftSib(long m_sidLeftSib) throws Exception {
        this.m_sidLeftSib = m_sidLeftSib;
        b4 = ByteBuffer.allocate(b4.length).putLong(m_sidLeftSib).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x44 + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public long getM_sidRightSib() {
        return m_sidRightSib;
    }

    public void setM_sidRightSib(long m_sidRightSib) throws Exception {
        this.m_sidRightSib = m_sidRightSib;

        b4 = ByteBuffer.allocate(b4.length).putLong(m_sidLeftSib).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x48 + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public long getM_sidChild() {
        return m_sidChild;
    }

    public void setM_sidChild(long m_sidChild) throws Exception {
        this.m_sidChild = m_sidChild;

        b4 = ByteBuffer.allocate(b4.length).putLong(m_sidLeftSib).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x4C + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public byte[] getM_clsId() {
        return m_clsId;
    }

    public void setM_clsId(byte[] m_clsId) throws Exception {
        this.m_clsId = m_clsId;

        for (int i = 0; i < m_clsId.length; i++) {
            b128[0x50 + i] = m_clsId[i];
        }

        s1.setValue(b128);
    }

    public long getM_dwUserFlags() {
        return m_dwUserFlags;
    }

    public void setM_dwUserFlags(long m_dwUserFlags) throws Exception {
        this.m_dwUserFlags = m_dwUserFlags;

        b4 = ByteBuffer.allocate(b4.length).putLong(m_dwUserFlags).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x60 + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public byte[] getM_time() {
        return m_time;
    }

    public void setM_time(byte[] m_time) throws Exception {
        this.m_time = m_time;

        for (int i = 0; i < m_time.length; i++) {
            b128[0x64 + i] = m_time[i];
        }

        s1.setValue(b128);
    }

    public long getM_sectStart() {
        return m_sectStart;
    }

    public void setM_sectStart(long m_sectStart) throws Exception {
        this.m_sectStart = m_sectStart;

        b4 = ByteBuffer.allocate(b4.length).putLong(m_dwUserFlags).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x74 + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public long getM_ulSize() {
        return m_ulSize;
    }

    public void setM_ulSize(long m_ulSize) throws Exception {
        this.m_ulSize = m_ulSize;

        b4 = ByteBuffer.allocate(b4.length).putLong(m_dwUserFlags).array();
        b128 = s1.getValue();

        for (int i = 0; i < b4.length; i++) {
            b128[0x78 + i] = b4[i];
        }

        s1.setValue(b128);
    }

    public Map<String, DirectoryEntry> getM_childs() {
        return m_childs;
    }

    public void setM_childs(HashMap<String, DirectoryEntry> m_childs) {
        this.m_childs = m_childs;
    }

    public long getM_SID() {
        return m_SID;
    }

    public void setM_SID(int m_SID) {
        this.m_SID = m_SID;
    }

    public DirectoryStream getS1() {
        return s1;
    }

    public void setS1(DirectoryStream s1) {
        this.s1 = s1;
    }

    @Override
    protected DirectoryEntry clone() throws CloneNotSupportedException {
        return (DirectoryEntry) super.clone();
    }
}
