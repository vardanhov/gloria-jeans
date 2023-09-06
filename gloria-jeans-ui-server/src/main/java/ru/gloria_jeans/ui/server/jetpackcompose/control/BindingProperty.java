package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BindingProperty {
    private String value = StringUtils.EMPTY;
    private boolean selfContained;

    public BindingProperty() {
    }

    public BindingProperty(String value, boolean selfContained) {
        this.value = value;
        this.selfContained = selfContained;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelfContained() {
        return selfContained;
    }

    public void setSelfContained(boolean selfContained) {
        this.selfContained = selfContained;
    }
}
