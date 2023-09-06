package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class ReturnOrderDocumentListModel extends BaseResponse {
    private List<OrderModel> orderModels = new ArrayList<>();

    public List<OrderModel> getOrderModels() {
        return orderModels;
    }

    public void setOrderModels(List<OrderModel> orderModels) {
        this.orderModels = orderModels;
    }
}
