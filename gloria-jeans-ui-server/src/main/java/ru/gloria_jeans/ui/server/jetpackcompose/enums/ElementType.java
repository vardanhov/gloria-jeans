package ru.gloria_jeans.ui.server.jetpackcompose.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ElementType {
    Button(0),
    IconButton(1),
    Container(2),
    Text(3),
    TextField(4),
    Divider(5),
    Spacer(6),
    Image(7),
    DatePicker(8),
    Spinner(9),
    ButtonOutLineBase(10),
    MultiSelector(11);

    private int elementType;

    ElementType(int elementType) {
        this.elementType = elementType;
    }

    @JsonValue
    public int getElementType() {
        return elementType;
    }
}
