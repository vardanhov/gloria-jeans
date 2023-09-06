package ru.gloria_jeans.orders.dao.model;

import java.util.List;

public class ReceiptOrdersModel {
    private String ordersCount;
    private String transportCompany;
    private String storeFullName;
    private String currentDate;
    private String currentTime;
    private List<ReceiptOrdersList> orderNumbers;

    public String getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(String ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getStoreFullName() {
        return storeFullName;
    }

    public void setStoreFullName(String storeFullName) {
        this.storeFullName = storeFullName;
    }

    public List<ReceiptOrdersList> getOrderNumbers() {
        return orderNumbers;
    }

    public void setOrderNumbers(List<ReceiptOrdersList> orderNumbers) {
        this.orderNumbers = orderNumbers;
    }
}