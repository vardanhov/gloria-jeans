package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class OrderPackageModel extends BaseResponse {

    private String orderNumber;

    private List<OrderPackageItemModel> packagesList;

    public OrderPackageModel() {
    }

    public OrderPackageModel(String orderNumber, List<OrderPackageItemModel> packagesList) {
        this.orderNumber = orderNumber;
        this.packagesList = packagesList;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderPackageItemModel> getPackagesList() {
        return packagesList;
    }

    public void setPackagesList(List<OrderPackageItemModel> packagesList) {
        this.packagesList = packagesList;
    }
}
