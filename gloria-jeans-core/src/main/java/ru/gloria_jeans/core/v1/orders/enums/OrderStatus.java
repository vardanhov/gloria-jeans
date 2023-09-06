package ru.gloria_jeans.core.v1.orders.enums;

public enum OrderStatus {
    NEW(
            "     1   ",
            "warehouse.internet.order.document.status.new"
    ),
    DISBANDED(
            "     2   ",
            "warehouse.internet.order.document.status.disbanded"
    ),
    TO_DISBANDED(
            "     2   ",
            "warehouse.internet.order.document.status.to_disband"
    ),
    READY_FOR_DELIVERY(
            "     3   ",
            "warehouse.internet.order.document.status.ready_for_delivery"
    ),
    ISSUED_TO_COURIER(
            "     3   ",
            "warehouse.internet.order.document.status.issued_to_courier"
    ),
    RETURNED_TK(
            "     3   ",
            "warehouse.internet.order.document.status.returned_tk"
    ),
    IN_WORK(
            "     4   ",
            "warehouse.internet.order.document.status.in_work"
    ),
    FITTING(
            "     5   ",
            "warehouse.internet.order.document.status.fitting"
    ),
    NOT_ACTIVE(
            "     2   ",
            "warehouse.internet.order.document.status.not_active"
    ),
    CONFIRMED(
            "     3   ",
            "warehouse.internet.order.document.status.confirm"
    );

    private String onecId;
    private String locale;

    OrderStatus(String onecId, String locale) {
        this.onecId = onecId;
        this.locale = locale;
    }

    public String getOnecId() {
        return onecId;
    }

    public void setOnecId(String onecId) {
        this.onecId = onecId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
