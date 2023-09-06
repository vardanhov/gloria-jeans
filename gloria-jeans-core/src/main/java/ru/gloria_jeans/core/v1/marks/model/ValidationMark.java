package ru.gloria_jeans.core.v1.marks.model;

import java.io.Serializable;
import java.util.List;

public class ValidationMark implements Serializable {
    private List<ValidationMarkItem> Items;
    private String error;

    public List<ValidationMarkItem> getItems() {
        return Items;
    }

    public void setItems(List<ValidationMarkItem> Items) {
        this.Items = Items;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
