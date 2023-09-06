package ru.gloria_jeans.ui.server.jetpackcompose.control;

import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

public class Spacer extends Composable {
    private ElementType elementType = ElementType.Spacer;

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @Override
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }
}
