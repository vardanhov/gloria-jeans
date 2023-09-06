package ru.gloria_jeans.receiving.model.enums;

public enum ObjectTypeFromBarcode {
    UNKNOWN(""),
    BOX("30"),
    PRODUCT("46"),
    LOT("46"),
    DOCUMENT("AA");

    ObjectTypeFromBarcode(String objectTypeFromBarcode) {
        this.objectTypeFromBarcode = objectTypeFromBarcode;
    }

    private String objectTypeFromBarcode;

    public String getObjectTypeFromBarcode() {
        return objectTypeFromBarcode;
    }

    public void setObjectTypeFromBarcode(String objectTypeFromBarcode) {
        this.objectTypeFromBarcode = objectTypeFromBarcode;
    }
}
