package ru.gloria_jeans.core.v1.utils;

import com.google.common.base.Strings;

public class BarcodeHelper {
    public static String getBarcodeFromTorg13(String torg13) {
        String idd = "";

        if (torg13.length() == 24) {
            idd = Strings.padStart(torg13.substring(0, torg13.length() - 10), 17, '0');
        }

        return idd;
    }

    public static String getBarcodeFromEan13(String ean13) {
        if (ean13.length() == 13) {
            return ean13;
        } else {
            return null;
        }
    }

    public static String getBarcodeFromItf14(String itf14) {
        return itf14;
    }

    public static String getBarcodeFromDatamatrix(String datamatrix) {
        return datamatrix
                .trim()
                .substring(3, 16);
    }

    public static String getMarkFromDatamatrix(String datamatrix) {
        return datamatrix
                .trim()
                .substring(18, 31);
    }

    public static String clearDatamatrix(String datamatrix) {
        return datamatrix
                .trim()
                .substring(0, 31);
    }

    public static String getBarcodeFromCode128(String code128) {
        return code128;
    }

    public static String getBarcodeFromQrcode(String qrcode) {
        return qrcode;
    }
}
