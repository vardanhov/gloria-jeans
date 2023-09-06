package ru.gloria_jeans.ui.server.jetpackcompose.modifier;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Background {
    private Color color;
    private Shape shape;
    private Gradient gradient;

    public Background() {}

    public Background(int red, int green, int blue, int alpha) {
        this.color = new Color(red, green, blue, alpha);
    }
    public Background(Color color) {
        this.color = color;
    }
    public Background(Gradient gradient) {
        this.gradient = gradient;
    }

    public Background(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
    }

    public Background(Gradient gradient, Shape shape) {
        this.gradient = gradient;
        this.shape = shape;
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

    public Gradient getGradient() {
        return gradient;
    }

    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }
}
