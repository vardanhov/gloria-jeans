package ru.gloria_jeans.orders.dao.model;

public class ReceiptOrdersList {

    private String orderNumber;
    private String orderDate;

    public ReceiptOrdersList() {
    }

    public ReceiptOrdersList(String orderNumber, String orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
