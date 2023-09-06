package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Button extends ButtonBase {
    private Composable content;

    public Composable getContent() {
        return content;
    }

    public void setContent(Composable content) {
        this.content = content;
    }
}
