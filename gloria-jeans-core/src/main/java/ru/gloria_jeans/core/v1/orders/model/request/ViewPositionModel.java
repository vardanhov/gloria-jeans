package ru.gloria_jeans.core.v1.orders.model.request;

public class ViewPositionModel {

    private String orderId;
    private String documentIdd;

    public ViewPositionModel() {
    }

    public ViewPositionModel(String orderId, String documentIdd) {
        this.orderId = orderId;
        this.documentIdd = documentIdd;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }
}
