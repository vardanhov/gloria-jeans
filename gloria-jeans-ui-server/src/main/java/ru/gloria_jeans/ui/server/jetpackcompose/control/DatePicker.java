package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatePicker extends Composable {
    private TextField textField;

    public DatePicker() {
        super();
        setElementType(ElementType.DatePicker);
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }
}
