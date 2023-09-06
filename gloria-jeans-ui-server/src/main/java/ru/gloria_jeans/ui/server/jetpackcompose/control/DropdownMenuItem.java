package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DropdownMenuItem {
    private BindingProperty text;
    private Action clickAction;
    private Boolean enabled = true;

    public DropdownMenuItem() {
    }

    public DropdownMenuItem(BindingProperty text, Action clickAction, Boolean enabled) {
        this.text = text;
        this.clickAction = clickAction;
        this.enabled = enabled;
    }

    public DropdownMenuItem(BindingProperty text, Action clickAction) {
        this.text = text;
        this.clickAction = clickAction;
    }

    public BindingProperty getText() {
        return text;
    }

    public void setText(BindingProperty text) {
        this.text = text;
    }

    public Action getClickAction() {
        return clickAction;
    }

    public void setClickAction(Action clickAction) {
        this.clickAction = clickAction;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
