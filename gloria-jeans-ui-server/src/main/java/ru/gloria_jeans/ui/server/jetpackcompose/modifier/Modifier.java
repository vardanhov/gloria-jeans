package ru.gloria_jeans.ui.server.jetpackcompose.modifier;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.IntrinsicSize;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Modifier {
    private Float weight;
    private Integer width;
    private Integer height;
    private Boolean fillMaxSize;
    private Boolean fillMaxWidth;
    private Boolean fillMaxHeight;
    private Integer padding;
    private Integer paddingVertical;
    private Integer paddingHorizontal;
    private IntrinsicSize intrinsicSizeHeight;
    private IntrinsicSize intrinsicSizeWidth;
    private Background background;
    private Border border;
    private Float alpha;
    private Shape clip;
    private Integer size;
    private Offset offset;
    private Shadow shadow;

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getFillMaxSize() {
        return fillMaxSize;
    }

    public void setFillMaxSize(Boolean fillMaxSize) {
        this.fillMaxSize = fillMaxSize;
    }

    public Boolean getFillMaxWidth() {
        return fillMaxWidth;
    }

    public void setFillMaxWidth(Boolean fillMaxWidth) {
        this.fillMaxWidth = fillMaxWidth;
    }

    public Boolean getFillMaxHeight() {
        return fillMaxHeight;
    }

    public void setFillMaxHeight(Boolean fillMaxHeight) {
        this.fillMaxHeight = fillMaxHeight;
    }

    public Integer getPadding() {
        return padding;
    }

    public void setPadding(Integer padding) {
        this.padding = padding;
    }

    public Integer getPaddingVertical() {
        return paddingVertical;
    }

    public void setPaddingVertical(Integer paddingVertical) {
        this.paddingVertical = paddingVertical;
    }

    public Integer getPaddingHorizontal() {
        return paddingHorizontal;
    }

    public void setPaddingHorizontal(Integer paddingHorizontal) {
        this.paddingHorizontal = paddingHorizontal;
    }

    public IntrinsicSize getIntrinsicSizeHeight() {
        return intrinsicSizeHeight;
    }

    public void setIntrinsicSizeHeight(IntrinsicSize intrinsicSizeHeight) {
        this.intrinsicSizeHeight = intrinsicSizeHeight;
    }

    public IntrinsicSize getIntrinsicSizeWidth() {
        return intrinsicSizeWidth;
    }

    public void setIntrinsicSizeWidth(IntrinsicSize intrinsicSizeWidth) {
        this.intrinsicSizeWidth = intrinsicSizeWidth;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public Float getAlpha() {
        return alpha;
    }

    public void setAlpha(Float alpha) {
        this.alpha = alpha;
    }

    public Shape getClip() {
        return clip;
    }

    public void setClip(Shape clip) {
        this.clip = clip;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    public Shadow getShadow() {
        return shadow;
    }

    public void setShadow(Shadow shadow) {
        this.shadow = shadow;
    }
}
