package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FontWeight {
    W100(100),
    W200(200),
    W300(300),
    W400(400),
    W500(500),
    W600(600),
    W700(700),
    W800(800),
    W900(900),
    Thin(100),
    ExtraLight(200),
    Light(300),
    Normal(400),
    Medium(500),
    SemiBold(600),
    Bold(700),
    ExtraBold(800),
    Black(900);
    private int fontWeight;

    FontWeight(int fontWeight) {
        this.fontWeight = fontWeight;
    }

    @JsonValue
    public int getFontWeight() {
        return fontWeight;
    }
}
