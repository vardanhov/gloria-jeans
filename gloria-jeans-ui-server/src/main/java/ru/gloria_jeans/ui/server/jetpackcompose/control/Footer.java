package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Footer {
    private List<IconButton> Actions = new ArrayList<>();
    private Composable Content;

    public List<IconButton> getActions() {
        return Actions;
    }

    public void setActions(List<IconButton> actions) {
        Actions = actions;
    }

    public Composable getContent() {
        return Content;
    }

    public void setContent(Composable content) {
        Content = content;
    }
}
