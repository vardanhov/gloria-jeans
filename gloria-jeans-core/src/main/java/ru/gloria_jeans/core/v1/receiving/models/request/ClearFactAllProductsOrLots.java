package ru.gloria_jeans.core.v1.receiving.models.request;

import java.io.Serializable;

public class ClearFactAllProductsOrLots implements Serializable {

    private String lotId;
    private String barcodeBox;

    private String lineNumberLot;

    public ClearFactAllProductsOrLots() {
    }

    public ClearFactAllProductsOrLots(String barcodeBox, String lotId, String lineNumberLot) {
        this.barcodeBox = barcodeBox;
        this.lotId = lotId;
        this.lineNumberLot = lineNumberLot;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(String lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }
}
