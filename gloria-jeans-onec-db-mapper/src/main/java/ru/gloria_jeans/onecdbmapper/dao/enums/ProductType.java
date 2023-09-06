package ru.gloria_jeans.onecdbmapper.dao.enums;

import ru.gloria_jeans.onecdbmapper.OnecDbMapper;

public enum ProductType {
    PRODUCT("Товар"),
    LOT("Лот"),
    PACKAGE("Пакет"),
    SERVICE("Услуга"),
    CERTIFICATE("Сертификат");

    private String name;
    private static final String ENUM_NAME = "ВидыТоваров";

    ProductType(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String value) {
        return OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(value);
    }

    public static String getValue(String name) {
        for (String key : OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.keySet()) {
            if (OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(key).equals(name)) {
                return key;
            }
        }

        return name;
    }
    public static String getValue(ProductType productType){
        for (String key : OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.keySet()) {

            if (OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(key).equals(productType.getName())) {
                return key;
            }
        }

        return "";
    }
}
