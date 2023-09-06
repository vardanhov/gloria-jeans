package ru.gloria_jeans.ui.server.jetpackcompose.enums;

public enum FontColor {
    Red(0),
    Green(1),
    Blue(2),
    Black(3),
    Yellow(4);
    private int fontColor;

    FontColor(int fontColor) {
        this.fontColor = fontColor;
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }
}
