package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderAcceptClickAndCollectConfirmDataContext extends InternetOrderSearchDataContext {
    private String confirmLabel = Strings.EMPTY;
    private String acceptButton = Strings.EMPTY;
    private String cancelButton = Strings.EMPTY;

    public String getConfirmLabel() {
        return confirmLabel;
    }

    public void setConfirmLabel(String confirmLabel) {
        this.confirmLabel = confirmLabel;
    }

    public String getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(String acceptButton) {
        this.acceptButton = acceptButton;
    }

    public String getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(String cancelButton) {
        this.cancelButton = cancelButton;
    }
}
