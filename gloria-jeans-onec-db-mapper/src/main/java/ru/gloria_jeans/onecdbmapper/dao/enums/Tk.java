package ru.gloria_jeans.onecdbmapper.dao.enums;

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
