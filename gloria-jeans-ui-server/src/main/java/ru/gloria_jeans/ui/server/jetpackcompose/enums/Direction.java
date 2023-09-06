package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Direction {
    VERTICAL(0),
    HORIZONTAL(1);

    private int direction;
    Direction(int direction) {
        this.direction = direction;
    }

    @JsonValue
    public int getDirection() {
        return direction;
    }
}
