package ru.gloria_jeans.core.v1.receiving.models.request;

public class AcceptanceLot extends AcceptanceProduct {
    private String iddLot;
    private String lineNumberLot;

    public AcceptanceLot() {}

    public AcceptanceLot(String iddLot) {
        this.iddLot = iddLot;
    }

    public AcceptanceLot(String documentIdd, String barcodeBox, String handleSearch, String scannedSearch, String iddLot, String lineNumberLot) {
        super(documentIdd, barcodeBox, handleSearch, scannedSearch, false, null);
        this.iddLot = iddLot;
        this.lineNumberLot = lineNumberLot;
    }

    public String getIddLot() {
        return iddLot;
    }

    public void setIddLot(String iddLot) {
        this.iddLot = iddLot;
    }

    public String getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(String lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }
}
