package ru.gloria_jeans.onecdbmapper.dao.enums;

public enum DocumentStatus {
    HELD(-1),
    NOT_HELD(0),
    MARK_AS_DELETED(1);

    private int value;
    DocumentStatus(int value) {
        this.value = value;
    }
}
