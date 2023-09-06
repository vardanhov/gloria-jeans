package ru.gloria_jeans.orders.dao.enums;

public enum PrintFormType {
    STICKER("Наклейки"),
    PACKING_LIST("Упаковочные"),
    ISSUING_RECEIPTS("Квитанции выдача"),
    RETURN_RECEIPTS("Квитанции возврат"),
    BUYER_INLAY("Вкладыш покупателя");

    public final String value;

    PrintFormType(String value) {
        this.value = value;
    }
}
