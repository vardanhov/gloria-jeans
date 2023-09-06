package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Icon {
    Plus(0),
    Minus(1),
    Search(2),
    Burger(3),
    Column(4),
    Refresh(5),
    Back(6);

    private int icon;

    Icon(int icon) {
        this.icon = icon;
    }

    @JsonValue
    public int getIcon() {
        return icon;
    }
}
