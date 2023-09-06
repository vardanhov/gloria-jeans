package ru.gloria_jeans.core.v1.orders.model.response;

import java.util.List;

public class PackingListModel {
    private String orderText;
    private String orderNumber;
    private String fromText;
    private String orderDate;
    private String collectDateTimeText;
    private String collectDateTime;
    private String orderBarcode;
    private String bayerText;
    private String bayerFullName;
    private String bayerPhoneNumber;
    private String bayerEmail;
    private String storeName;
    private String storeAddress;
    private String collectorText;
    private String collectorFullName;
    private String productText;
    private String quantityText;
    private String priceText;
    private String sumText;
    private List<OrderItemModel> itemModelList;

    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFromText() {
        return fromText;
    }

    public void setFromText(String fromText) {
        this.fromText = fromText;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCollectDateTimeText() {
        return collectDateTimeText;
    }

    public void setCollectDateTimeText(String collectDateTimeText) {
        this.collectDateTimeText = collectDateTimeText;
    }

    public String getCollectDateTime() {
        return collectDateTime;
    }

    public void setCollectDateTime(String collectDateTime) {
        this.collectDateTime = collectDateTime;
    }

    public String getOrderBarcode() {
        return orderBarcode;
    }

    public void setOrderBarcode(String orderBarcode) {
        this.orderBarcode = orderBarcode;
    }

    public String getBayerText() {
        return bayerText;
    }

    public void setBayerText(String bayerText) {
        this.bayerText = bayerText;
    }

    public String getBayerFullName() {
        return bayerFullName;
    }

    public void setBayerFullName(String bayerFullName) {
        this.bayerFullName = bayerFullName;
    }

    public String getBayerPhoneNumber() {
        return bayerPhoneNumber;
    }

    public void setBayerPhoneNumber(String bayerPhoneNumber) {
        this.bayerPhoneNumber = bayerPhoneNumber;
    }

    public String getBayerEmail() {
        return bayerEmail;
    }

    public void setBayerEmail(String bayerEmail) {
        this.bayerEmail = bayerEmail;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getCollectorText() {
        return collectorText;
    }

    public void setCollectorText(String collectorText) {
        this.collectorText = collectorText;
    }

    public String getCollectorFullName() {
        return collectorFullName;
    }

    public void setCollectorFullName(String collectorFullName) {
        this.collectorFullName = collectorFullName;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public String getQuantityText() {
        return quantityText;
    }

    public void setQuantityText(String quantityText) {
        this.quantityText = quantityText;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public String getSumText() {
        return sumText;
    }

    public void setSumText(String sumText) {
        this.sumText = sumText;
    }

    public List<OrderItemModel> getItemModelList() {
        return itemModelList;
    }

    public void setItemModelList(List<OrderItemModel> itemModelList) {
        this.itemModelList = itemModelList;
    }
}
