package ru.gloria_jeans.onecdbmapper.mdparser.stream;

public enum tagSTGTY {
    INVALID(0x0),
    STORAGE( 0x1),
    STREAM(0x2),
    LOCKBYTES(0x3),
    PROPERTY(0x4),
    ROOT(0x5);

    private int value;

    tagSTGTY(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static tagSTGTY valueOf(int value) {
        for (tagSTGTY type : tagSTGTY.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return null;
    }
}
