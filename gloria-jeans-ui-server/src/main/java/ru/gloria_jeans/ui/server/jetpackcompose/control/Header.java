package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header {
    private List<Composable> contents = new ArrayList<>();

    public List<Composable> getContents() {
        return contents;
    }

    public void setContents(List<Composable> contents) {
        this.contents = contents;
    }
}
