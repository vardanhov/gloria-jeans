package ru.gloria_jeans.core.v1.orders.enums;

public enum Tk {

    CDEK("cdek"),
    PICK_POINT("pickpoint"),
    RUSSIAN_POST("russianpost");

    private final String name;

    Tk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
