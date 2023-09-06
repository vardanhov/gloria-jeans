package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TextAlign {
    Left(1),
    Right(2),
    Center(3),
    Justify(4),
    Start(5),
    End(6);

    private int textAlign;

    TextAlign(int textAlign) {
        this.textAlign = textAlign;
    }

    @JsonValue
    public int getTextAlign() {
        return textAlign;
    }
}
