package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonOutLineBase extends Composable {
    public ButtonOutLineBase() {
        this.setElementType(ElementType.ButtonOutLineBase);
    }
}
