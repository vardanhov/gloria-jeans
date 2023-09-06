package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {
    private BindingProperty callbackData = new BindingProperty();
    private String actionUri = StringUtils.EMPTY;

    public Action() {
    }

    public Action(BindingProperty callbackData) {
        this.callbackData = callbackData;
    }

    public Action(String actionUri) {
        this.actionUri = actionUri;
    }

    public Action(BindingProperty callbackData, String actionUri) {
        this.callbackData = callbackData;
        this.actionUri = actionUri;
    }

    public BindingProperty getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(BindingProperty callbackData) {
        this.callbackData = callbackData;
    }

    public String getActionUri() {
        return actionUri;
    }

    public void setActionUri(String actionUri) {
        this.actionUri = actionUri;
    }
}
