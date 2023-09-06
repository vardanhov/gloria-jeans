package ru.gloria_jeans.ui.server.jetpackcompose.modifier;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ClipShape;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Shape {
    private ClipShape clipShape;
    private Integer percent;

    public Shape(ClipShape clipShape) {
        this.clipShape = clipShape;
        this.percent = 0;
    }
    public Shape(ClipShape clipShape, Integer percent) {
        this.clipShape = clipShape;
        this.percent = percent;
    }

    public ClipShape getClipShape() {
        return clipShape;
    }

    public void setClipShape(ClipShape clipShape) {
        this.clipShape = clipShape;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
}
