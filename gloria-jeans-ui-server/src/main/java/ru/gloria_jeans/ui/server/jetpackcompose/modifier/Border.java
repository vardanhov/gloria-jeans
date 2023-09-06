package ru.gloria_jeans.ui.server.jetpackcompose.modifier;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Border {
    private int width;
    private Color color;
    private Shape shape;

    public Border(int width, Color color) {
        this.width = width;
        this.color = color;
    }

    public Border(int width, Color color, Shape shape) {
        this.width = width;
        this.color = color;
        this.shape = shape;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
