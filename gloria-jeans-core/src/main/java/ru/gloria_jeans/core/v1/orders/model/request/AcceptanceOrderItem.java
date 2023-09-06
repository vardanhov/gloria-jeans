package ru.gloria_jeans.core.v1.orders.model.request;

public class AcceptanceOrderItem extends OrderSearchModel {
    private String orderNumber;
    private String currentItemOrder;

    public AcceptanceOrderItem() {
    }

    public AcceptanceOrderItem(String orderNumber, String handleSearch, String scannedSearch, String currentItemOrder) {
        this.orderNumber = orderNumber;
        this.setHandleSearch(handleSearch);
        this.setScannedSearch(scannedSearch);
        this.setCurrentItemOrder(currentItemOrder);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCurrentItemOrder() {
        return currentItemOrder;
    }

    public void setCurrentItemOrder(String currentItemOrder) {
        this.currentItemOrder = currentItemOrder;
    }
}
