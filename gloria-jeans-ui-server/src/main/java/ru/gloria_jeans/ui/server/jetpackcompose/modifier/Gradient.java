package ru.gloria_jeans.ui.server.jetpackcompose.modifier;

import ru.gloria_jeans.ui.server.jetpackcompose.enums.GradientDirection;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.TileMode;

import java.util.List;

public class Gradient {
    private List<Color> colors;
    private Float startX;
    private Float endX;
    private GradientDirection direction;
    private TileMode tile;

    public Gradient(List<Color> colors, Float startX, Float endX, GradientDirection direction, TileMode tile) {
        this.colors = colors;
        this.startX = startX;
        this.endX = endX;
        this.direction = direction;
        this.tile = tile;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public Float getStartX() {
        return startX;
    }

    public void setStartX(Float startX) {
        this.startX = startX;
    }

    public Float getEndX() {
        return endX;
    }

    public void setEndX(Float endX) {
        this.endX = endX;
    }

    public GradientDirection getDirection() {
        return direction;
    }

    public void setDirection(GradientDirection direction) {
        this.direction = direction;
    }

    public TileMode getTile() {
        return tile;
    }

    public void setTile(TileMode tile) {
        this.tile = tile;
    }
}
