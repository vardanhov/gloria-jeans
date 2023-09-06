package ru.gloria_jeans.onecdbmapper.dao.enums;

import ru.gloria_jeans.onecdbmapper.OnecDbMapper;

public enum WriteOffType {

    PACKAGE("Пакеты"),
    UNIFORM("Спецодежда");

    private final String name;

    WriteOffType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final String ENUM_NAME = "ВидСписания";

    public static String getName(String value) {
        return OnecDbMapper.getOnecMetadata().Enums.get(ENUM_NAME).DbToIdentVals.get(value);
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
