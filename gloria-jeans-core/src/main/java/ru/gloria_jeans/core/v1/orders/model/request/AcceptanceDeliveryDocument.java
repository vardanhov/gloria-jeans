package ru.gloria_jeans.core.v1.orders.model.request;

public class AcceptanceDeliveryDocument {
    String handleSearch;
    String scannedSearch;

    public AcceptanceDeliveryDocument() {
    }

    public AcceptanceDeliveryDocument(String handleSearch, String scannedSearch) {
        this.handleSearch = handleSearch;
        this.scannedSearch = scannedSearch;
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
}
