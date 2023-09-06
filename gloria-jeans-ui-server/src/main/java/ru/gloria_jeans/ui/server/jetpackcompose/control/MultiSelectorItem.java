package ru.gloria_jeans.ui.server.jetpackcompose.control;

public class MultiSelectorItem {

    private String value;
    private String text;

    public MultiSelectorItem() {
    }

    public MultiSelectorItem(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
