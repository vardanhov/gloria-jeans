package ru.gloria_jeans.onecdbmapper.mdparser.stream;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.nio.ByteBuffer;

public class CompoundHeader {
    private ByteBuffer inputStream;
    private long csectMiniFat;
    private long csectDifStart;
    private long csectDif;
    private long sectMiniFatStart;
    private long ulMiniSectorCutoff;
    private long signature;
    private long csectDirStart;
    private long csectFAT;
    private long ulReserved2;
    private long ulReserved1;
    private int usReserved;
    private int uMiniSectorShift;
    private int uSectorShift;
    private int uByteOrder;
    private int uDllVersion;
    private int uMinorVersion;
    private byte[] abSig;
    private byte[] clsid;

    public CompoundHeader(ByteBuffer inputStream) throws Exception {
        this.inputStream = inputStream;
        parse();
    }

    public void parse() throws Exception {
        byte[] buff2 = new byte[2];
        byte[] buff4 = new byte[4];

        abSig = new byte[8];
        clsid = new byte[16];

        inputStream.position(0);
        inputStream.get(abSig, 0, 8); //0x00
        inputStream.get(clsid, 0, 16); //0x08

        inputStream.get(buff2, 0, 2);  //0x18
        uMinorVersion = OnecConverter.getUnsignedShort(buff2);

        inputStream.get(buff2, 0, 2); //0x1A
        uDllVersion = OnecConverter.getUnsignedShort(buff2);

        inputStream.get(buff2, 0, 2); //0x1C
        uByteOrder = OnecConverter.getUnsignedShort(buff2);

        inputStream.get(buff2, 0, 2); //0x1E
        uSectorShift = OnecConverter.getUnsignedShort(buff2);

        inputStream.get(buff2, 0, 2); //0x20
        uMiniSectorShift = OnecConverter.getUnsignedShort(buff2);

        inputStream.get(buff2, 0, 2); //0x22
        usReserved = OnecConverter.getUnsignedShort(buff2);

        inputStream.get(buff4, 0, 4); //0x24
        ulReserved1 = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x28
        ulReserved2 = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x2C
        csectFAT = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x30
        csectDirStart = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x34
        signature = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x38
        ulMiniSectorCutoff = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x3C
        sectMiniFatStart = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x40
        csectMiniFat = OnecConverter.getUnsignedInt(buff4);

        inputStream.position(0x44);
        inputStream.get(buff4, 0, 4); //0x44
        csectDifStart = OnecConverter.getUnsignedInt(buff4);

        inputStream.get(buff4, 0, 4); //0x48
        csectDif = OnecConverter.getUnsignedInt(buff4);
    }

    public long getCsectMiniFat() {
        return csectMiniFat;
    }

    public void setCsectMiniFat(long csectMiniFat) {
        this.csectMiniFat = csectMiniFat;
        inputStream.position(0x40);
        inputStream.put(ByteBuffer.allocate(4).putLong(csectMiniFat).array(), 0, 4);
    }

    public long getCsectDifStart() {
        return csectDifStart;
    }

    public void setCsectDifStart(long csectDifStart) {
        this.csectDifStart = csectDifStart;
    }

    public long getCsectDif() {
        return csectDif;
    }

    public void setCsectDif(long csectDif) {
        this.csectDif = csectDif;
    }

    public long getSectMiniFatStart() {
        return sectMiniFatStart;
    }

    public void setSectMiniFatStart(long sectMiniFatStart) {
        this.sectMiniFatStart = sectMiniFatStart;
    }

    public long getUlMiniSectorCutoff() {
        return ulMiniSectorCutoff;
    }

    public void setUlMiniSectorCutoff(long ulMiniSectorCutoff) {
        this.ulMiniSectorCutoff = ulMiniSectorCutoff;
    }

    public long getSignature() {
        return signature;
    }

    public void setSignature(long signature) {
        this.signature = signature;
    }

    public long getCsectDirStart() {
        return csectDirStart;
    }

    public void setCsectDirStart(long csectDirStart) {
        this.csectDirStart = csectDirStart;
    }

    public long getCsectFAT() {
        return csectFAT;
    }

    public void setCsectFAT(long csectFAT) {
        this.csectFAT = csectFAT;
        inputStream.position(0x2C);
        inputStream.put(ByteBuffer.allocate(4).putLong(csectFAT).array(), 0, 4);
    }

    public long getUlReserved2() {
        return ulReserved2;
    }

    public void setUlReserved2(long ulReserved2) {
        this.ulReserved2 = ulReserved2;
    }

    public long getUlReserved1() {
        return ulReserved1;
    }

    public void setUlReserved1(long ulReserved1) {
        this.ulReserved1 = ulReserved1;
    }

    public int getUsReserved() {
        return usReserved;
    }

    public void setUsReserved(int usReserved) {
        this.usReserved = usReserved;
    }

    public int getuMiniSectorShift() {
        return uMiniSectorShift;
    }

    public void setuMiniSectorShift(int uMiniSectorShift) {
        this.uMiniSectorShift = uMiniSectorShift;
    }

    public int getuSectorShift() {
        return uSectorShift;
    }

    public void setuSectorShift(int uSectorShift) {
        this.uSectorShift = uSectorShift;
    }

    public int getuByteOrder() {
        return uByteOrder;
    }

    public void setuByteOrder(int uByteOrder) {
        this.uByteOrder = uByteOrder;
    }

    public int getuDllVersion() {
        return uDllVersion;
    }

    public void setuDllVersion(int uDllVersion) {
        this.uDllVersion = uDllVersion;
    }

    public int getuMinorVersion() {
        return uMinorVersion;
    }

    public void setuMinorVersion(int uMinorVersion) {
        this.uMinorVersion = uMinorVersion;
    }

    public byte[] getAbSig() {
        return abSig;
    }

    public void setAbSig(byte[] abSig) {
        this.abSig = abSig;
    }

    public byte[] getClsid() {
        return clsid;
    }

    public void setClsid(byte[] clsid) {
        this.clsid = clsid;
    }
}
