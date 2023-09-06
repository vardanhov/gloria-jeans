package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class OrderFinishIssuingOrders extends BaseResponse {

    List<String> IssuedOrders;

    List<String> ordersIdDoc;

    public List<String> getIssuedOrders() {
        return IssuedOrders;
    }

    public void setIssuedOrders(List<String> issuedOrders) {
        IssuedOrders = issuedOrders;
    }

    public OrderFinishIssuingOrders() {
    }

    public List<String> getOrdersIdDoc() {
        return ordersIdDoc;
    }

    public void setOrdersIdDoc(List<String> ordersIdDoc) {
        this.ordersIdDoc = ordersIdDoc;
    }
}
