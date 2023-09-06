package ru.gloria_jeans.core.v1.orders.enums;

public enum ScannedDocumentStatus {

    WAITING_SCAN("Waiting for scan"),
    SCANNED("Scanned"),
    SUCCESS("Success");

    private final String value;

    ScannedDocumentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getScannedDocumentStatus(String scanStatus) {
        if (scanStatus.equals("Waiting for scan")) {
            return "warehouse.internet.order.document.status.delivery.waiting_scan";
        } else if (scanStatus.equals("Scanned")) {
            return "warehouse.internet.order.document.status.delivery.scanned";
        }
        return "";
    }
}
