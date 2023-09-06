package ru.gloria_jeans.ui.server.model.table;

import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;

public class Cell {

    private String text;

    private Color textColor;

    private Color backgroundColor;

    private Color border;

    private int height;

    private int width;

    public Cell(String text, Color backgroundColor, Color border, int height, int width) {
        this.text = text;
        this.backgroundColor = backgroundColor;
        this.border = border;
        this.height = height;
        this.width = width;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorder() {
        return border;
    }

    public void setBorder(Color border) {
        this.border = border;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
