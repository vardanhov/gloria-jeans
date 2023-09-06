package ru.gloria_jeans.ui.server.jetpackcompose.modifier;

public class Shadow {
    private Integer elevation;
    private Shape shape;

    public Shadow(Integer elevation, Shape shape) {
        this.elevation = elevation;
        this.shape = shape;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
