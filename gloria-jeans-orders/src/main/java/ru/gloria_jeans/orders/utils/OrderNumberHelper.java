package ru.gloria_jeans.orders.utils;

public class OrderNumberHelper {

    public static String getSaleReceiptWithIdOrder(String barcode) {
        return "R000337".concat(barcode);
    }

    public static String getSaleReceiptWithoutIdOrder(String barcode) {
        return "R000352".concat(barcode);
    }

    public static String getReturnReceiptWithIdOrder(String barcode) {
        return "P000337".concat(barcode);
    }

    public static String getReturnReceiptWithoutIdOrder(String barcode) {
        return "P000352".concat(barcode);
    }

}
