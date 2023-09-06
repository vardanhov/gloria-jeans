package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCollectOrdersMenuOrderDataContext extends InternetOrderCollectOrdersContentOrderDataContext {
    private String confirmAssemblyOrderButton = Strings.EMPTY;
    private String quantityPackagesButton = Strings.EMPTY;

    public String getConfirmAssemblyOrderButton() {
        return confirmAssemblyOrderButton;
    }

    public void setConfirmAssemblyOrderButton(String confirmAssemblyOrderButton) {
        this.confirmAssemblyOrderButton = confirmAssemblyOrderButton;
    }

    public String getQuantityPackagesButton() {
        return quantityPackagesButton;
    }

    public void setQuantityPackagesButton(String quantityPackagesButton) {
        this.quantityPackagesButton = quantityPackagesButton;
    }
}
