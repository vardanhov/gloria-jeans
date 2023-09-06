package ru.gloria_jeans.core.v1.receiving.models.request;

import java.io.Serializable;

public class AcceptanceBox implements Serializable {
    private String barcodeBox;
    private String idd;

    public AcceptanceBox() {
    }

    public AcceptanceBox(String barcodeBox, String idd) {
        this.barcodeBox = barcodeBox;
        this.idd = idd;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }
}
