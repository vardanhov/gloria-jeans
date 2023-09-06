package ru.gloria_jeans.core.v1.orders.enums;

public enum OrderType {

    EMPTY("0", "EMPTY", ""),
    CR("Reserve", "C&R", "warehouse.internet.order.type.reserve"),
    SFS("ShipFromStore", "SFS", "warehouse.internet.order.type.sfs"),
    COLLECT("Collect", "COLLECT", "warehouse.internet.order.type.collect");
    public final String shippingMethodName;

    public final String value;
    public final String locale;

    OrderType(String shippingMethodName, String value, String locale) {
        this.shippingMethodName = shippingMethodName;
        this.value = value;
        this.locale = locale;
    }

    public static OrderType getOrderType(String orderType) {
        if (orderType.equals("100")) {
            return OrderType.CR;
        } else if (orderType.equals("111")) {
            return OrderType.SFS;
        }
        return OrderType.EMPTY;
    }

    public String getValue() {
        return value;
    }

    public String getLocale() {
        return locale;
    }

    public String getShippingMethodName() {
        return shippingMethodName;
    }
}
