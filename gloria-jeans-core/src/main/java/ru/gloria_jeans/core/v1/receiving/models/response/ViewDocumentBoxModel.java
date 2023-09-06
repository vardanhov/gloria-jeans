package ru.gloria_jeans.core.v1.receiving.models.response;

public class ViewDocumentBoxModel {
    private String barcode;
    private String factQuantity;
    private String totalQuantity;
    private String differenceQuantity;
    private Boolean boxAccepted;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getFactQuantity() {
        return factQuantity;
    }

    public void setFactQuantity(String factQuantity) {
        this.factQuantity = factQuantity;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getDifferenceQuantity() {
        return differenceQuantity;
    }

    public void setDifferenceQuantity(String differenceQuantity) {
        this.differenceQuantity = differenceQuantity;
    }

    public Boolean isBoxAccepted() {
        return boxAccepted;
    }

    public void setBoxAccepted(Boolean boxAccepted) {
        this.boxAccepted = boxAccepted;
    }
}
