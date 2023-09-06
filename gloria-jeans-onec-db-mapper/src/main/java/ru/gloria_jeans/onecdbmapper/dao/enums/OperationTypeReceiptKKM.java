package ru.gloria_jeans.onecdbmapper.dao.enums;

import ru.gloria_jeans.onecdbmapper.OnecDbMapper;

public enum OperationTypeReceiptKKM {

    RECEIPT("Чек"),
    REFUND_RECEIPT("ЧекНаВозврат");

    private final String name;

    OperationTypeReceiptKKM(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final String ENUM_NAME = "ВидыОперацийЧекККМ";

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

}
