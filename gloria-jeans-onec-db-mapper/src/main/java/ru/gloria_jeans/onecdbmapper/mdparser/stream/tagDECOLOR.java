package ru.gloria_jeans.onecdbmapper.mdparser.stream;

public enum tagDECOLOR {
    DE_RED(0x0),
    DE_BLACK(0x1);
    private int value;

    tagDECOLOR(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static tagDECOLOR valueOf(int value) {
        for (tagDECOLOR type : tagDECOLOR.values()) {
            if (type.value == value) {
                return type;
            }
        }

        return null;
    }
}
