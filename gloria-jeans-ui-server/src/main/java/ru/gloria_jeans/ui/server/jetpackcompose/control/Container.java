package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Container extends Composable {
    private List<Composable> items = new ArrayList<>();
    private ElementType elementType = ElementType.Container;
    private Direction direction = Direction.VERTICAL;
    private boolean HasScroll;
    private boolean collapse;
    private String collapseButtonText = StringUtils.EMPTY;
    private Color collapseButtonColor = new Color(0,0,0,255);

    public List<Composable> getItems() {
        return items;
    }

    public void setItems(List<Composable> items) {
        this.items = items;
    }

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isHasScroll() {
        return HasScroll;
    }

    public void setHasScroll(boolean hasScroll) {
        HasScroll = hasScroll;
    }

    public boolean isCollapse() {
        return collapse;
    }

    public void setCollapse(boolean collapse) {
        this.collapse = collapse;
    }

    public String getCollapseButtonText() {
        return collapseButtonText;
    }

    public void setCollapseButtonText(String collapseButtonText) {
        this.collapseButtonText = collapseButtonText;
    }

    public Color getCollapseButtonColor() {
        return collapseButtonColor;
    }

    public void setCollapseButtonColor(Color collapseButtonColor) {
        this.collapseButtonColor = collapseButtonColor;
    }
}
