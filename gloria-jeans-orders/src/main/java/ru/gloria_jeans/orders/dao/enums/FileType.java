package ru.gloria_jeans.orders.dao.enums;

public enum FileType {

    STICKER("sticker"),
    PACKING_LIST("packing_list"),
    INLAY("inlay"),
    RECEIPT("receipt");

    public final String value;

    FileType(String value) {
        this.value = value;
    }


}
