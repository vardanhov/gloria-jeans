package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class OrderListModel extends BaseResponse {

    private List<OrderModel> orderModels;

    public OrderListModel() {
    }

    public OrderListModel(List<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }

    public List<OrderModel> getOrderModels() {
        return orderModels;
    }

    public void setOrderModels(List<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }
}
