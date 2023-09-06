package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SignalType {
    Success(0),
    Error(1),
    Warning(2);

    private int signalType;

    SignalType(int signalType) {
        this.signalType = signalType;
    }

    @JsonValue
    public int getSignalType() {
        return signalType;
    }
}
