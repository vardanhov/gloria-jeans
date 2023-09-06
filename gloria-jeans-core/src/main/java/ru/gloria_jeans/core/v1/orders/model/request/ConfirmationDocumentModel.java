package ru.gloria_jeans.core.v1.orders.model.request;

public class ConfirmationDocumentModel {

    private String orderNumber;
    private String collectorFullName;
    private String orderDateFormat;

    public ConfirmationDocumentModel() {
    }

    public ConfirmationDocumentModel(String orderNumber, String collectorFullName, String orderDateFormat) {
        this.orderNumber = orderNumber;
        this.collectorFullName = collectorFullName;
        this.orderDateFormat = orderDateFormat;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCollectorFullName() {
        return collectorFullName;
    }

    public void setCollectorFullName(String collectorFullName) {
        this.collectorFullName = collectorFullName;
    }

    public String getOrderDateFormat() {
        return orderDateFormat;
    }

    public void setOrderDateFormat(String orderDateFormat) {
        this.orderDateFormat = orderDateFormat;
    }
}
