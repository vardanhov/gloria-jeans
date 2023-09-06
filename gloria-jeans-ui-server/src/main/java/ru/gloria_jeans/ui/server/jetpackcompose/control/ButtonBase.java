package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ButtonBase extends Composable {
    public ButtonBase() {
        this.setElementType(ElementType.Button);
    }
}
