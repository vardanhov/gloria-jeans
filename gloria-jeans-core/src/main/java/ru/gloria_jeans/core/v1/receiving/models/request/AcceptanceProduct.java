package ru.gloria_jeans.core.v1.receiving.models.request;

import java.io.Serializable;

public class AcceptanceProduct implements Serializable {
    private String documentIdd;
    private String barcodeBox;
    private String handleSearch;
    private String scannedSearch;
    private Boolean notCountQuantityLot;
    private Integer lineNumber;

    public AcceptanceProduct() {
    }

    public AcceptanceProduct(String documentIdd, String barcodeBox, String handleSearch, String scannedSearch, Boolean notCountQuantityLot, Integer lineNumber) {
        this.documentIdd = documentIdd;
        this.barcodeBox = barcodeBox;
        this.handleSearch = handleSearch;
        this.scannedSearch = scannedSearch;
        this.notCountQuantityLot = notCountQuantityLot;
        this.lineNumber = lineNumber;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getHandleSearch() {
        return handleSearch;
    }

    public void setHandleSearch(String handleSearch) {
        this.handleSearch = handleSearch;
    }

    public String getScannedSearch() {
        return scannedSearch;
    }

    public void setScannedSearch(String scannedSearch) {
        this.scannedSearch = scannedSearch;
    }

    public Boolean getNotCountQuantityLot() {
        return notCountQuantityLot;
    }

    public void setNotCountQuantityLot(Boolean notCountQuantityLot) {
        this.notCountQuantityLot = notCountQuantityLot;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
