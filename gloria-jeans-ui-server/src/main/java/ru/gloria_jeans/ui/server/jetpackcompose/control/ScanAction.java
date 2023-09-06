package ru.gloria_jeans.ui.server.jetpackcompose.control;

public class ScanAction extends Composable {
    private String actionUri;
    private BindingProperty callbackData = new BindingProperty();

    public ScanAction(String actionUri) {
        this.actionUri = actionUri;
    }

    public String getActionUri() {
        return actionUri;
    }

    public void setActionUri(String actionUri) {
        this.actionUri = actionUri;
    }

    public BindingProperty getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(BindingProperty callbackData) {
        this.callbackData = callbackData;
    }
}
