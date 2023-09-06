package ru.gloria_jeans.onecdbmapper.dao.enums;

import com.google.common.base.Strings;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;

public enum ShippingMethod {
    DELIVERY("Доставка"),
    PICKUP("Самовывоз"),
    MAIL("Почта"),
    COLLECT("Collect"),
    RESERVE("Reserve"),
    SHIP_FROM_STORE("ShipFromStore"),
    ONLINE("ONLINE");

    private final String name;

    ShippingMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final String ENUM_NAME = "СпособОтгрузки";

    public static String getName(String value) {
        String shippingMethodName = OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(value);
        if (Strings.isNullOrEmpty(shippingMethodName)) {
            shippingMethodName = "";
        }
        return shippingMethodName;
    }

    public String getValue() {
        for (String key : OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.keySet()) {
            if (OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(key).equals(this.name)) {
                return key;
            }
        }

        return null;
    }

    public static String getValue(String name) {
        for (String key : OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.keySet()) {
            if (OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(key).equals(name)) {
                return key;
            }
        }

        return name;
    }
}
