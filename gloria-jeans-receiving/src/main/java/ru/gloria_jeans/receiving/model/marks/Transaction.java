package ru.gloria_jeans.receiving.model.marks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction implements Serializable {
    @XmlElement(name = "Type")
    private String type;
    @XmlElement(name = "SubType")
    private String subType;
    @XmlElement(name = "Date")
    private String date;
    @XmlElement(name = "Number")
    private String number;
    @XmlElement(name = "IDD")
    private String idd;
    @XmlElement(name = "Src")
    private String src;
    @XmlElement(name = "Dst")
    private String dst;
    @XmlElement(name = "StoreIDD")
    private String storeIdd;

    public Transaction() {}

    public Transaction(String type, String subType, String date, String number, String idd, String src, String dst, String storeIdd) {
        this.type = type;
        this.subType = subType;
        this.date = date;
        this.number = number;
        this.idd = idd;
        this.src = src;
        this.dst = dst;
        this.storeIdd = storeIdd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getStoreIdd() {
        return storeIdd;
    }

    public void setStoreIdd(String storeIdd) {
        this.storeIdd = storeIdd;
    }
}
