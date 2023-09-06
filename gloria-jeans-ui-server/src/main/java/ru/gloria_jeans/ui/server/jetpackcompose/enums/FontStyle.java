package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FontStyle {
    Normal(0),
    Italic(1);

    private int fontStyle;

    FontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    @JsonValue
    public int getFontStyle() {
        return fontStyle;
    }
}
