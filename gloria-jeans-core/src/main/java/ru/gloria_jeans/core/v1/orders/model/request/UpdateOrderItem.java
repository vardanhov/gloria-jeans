package ru.gloria_jeans.core.v1.orders.model.request;

import java.io.Serializable;

public class UpdateOrderItem implements Serializable {
    private String orderItemId;
    private String quantityFact;

    public String getOrderItemId() {
        return orderItemId;
    }

    public UpdateOrderItem() {
    }

    public UpdateOrderItem(String orderItemId, String quantityFact) {
        this.orderItemId = orderItemId;
        this.quantityFact = quantityFact;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(String quantityFact) {
        this.quantityFact = quantityFact;
    }
}
