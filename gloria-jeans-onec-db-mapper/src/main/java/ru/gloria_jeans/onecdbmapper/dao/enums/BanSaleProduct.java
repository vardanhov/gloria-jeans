package ru.gloria_jeans.onecdbmapper.dao.enums;

public enum BanSaleProduct {
    BAN("Запретить продажу рознице"),
    ALLOW("Разрешить продажу рознице");

    private String value;

    BanSaleProduct(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
