package ru.gloria_jeans.core.v1.orders.enums;

public enum ReasonAbsence {
    DEFECT("Брак"),
    PRODUCT_NOT_FOUND("Товар не найден"),
    PROBLEM_WITH_MARK("Проблемная марка");


    private String value;

    ReasonAbsence(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
