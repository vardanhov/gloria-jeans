package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.TextFieldKeyboardType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextField extends Composable {
    private BindingProperty value = new BindingProperty();
    private BindingProperty placeholder;
    private Boolean singleLine;
    private BindingProperty label;
    private Boolean autoFocus = true;
    private TextFieldKeyboardType keyboardType = TextFieldKeyboardType.Text;

    public Boolean getSingleLine() {
        return singleLine;
    }

    public void setSingleLine(Boolean singleLine) {
        this.singleLine = singleLine;
    }

    public TextField() {
        this.setElementType(ElementType.TextField);
    }

    public BindingProperty getValue() {
        return value;
    }

    public void setValue(BindingProperty value) {
        this.value = value;
    }

    public BindingProperty getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(BindingProperty placeholder) {
        this.placeholder = placeholder;
    }

    public BindingProperty getLabel() {
        return label;
    }

    public void setLabel(BindingProperty label) {
        this.label = label;
    }

    public Boolean getAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(Boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    public TextFieldKeyboardType getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(TextFieldKeyboardType keyboardType) {
        this.keyboardType = keyboardType;
    }
}
