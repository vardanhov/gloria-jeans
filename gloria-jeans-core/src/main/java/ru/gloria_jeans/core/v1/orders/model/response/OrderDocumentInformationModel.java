package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class OrderDocumentInformationModel extends BaseResponse {

    private List<OrderDocumentModel> orderDocumentModelList;

    public List<OrderDocumentModel> getOrderDocumentModelList() {
        return orderDocumentModelList;
    }

    public void setOrderDocumentModelList(List<OrderDocumentModel> orderDocumentModelList) {
        this.orderDocumentModelList = orderDocumentModelList;
    }
}
