package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BeepType {
    None(0),
    Success(1),
    Warning(2),
    Error(3);

    private int beepType;

    BeepType(int beepType) {
        this.beepType = beepType;
    }

    @JsonValue
    public int getBeepType() {
        return beepType;
    }
}
