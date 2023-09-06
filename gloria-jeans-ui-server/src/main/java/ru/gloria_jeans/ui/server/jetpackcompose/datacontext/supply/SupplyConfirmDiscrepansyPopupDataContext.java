package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyConfirmDiscrepansyPopupDataContext extends SupplyConfirmDiscrepancyDataContext {
    private String headerTitleText = Strings.EMPTY;
    private String messageText = Strings.EMPTY;
    private String saveButtonText = Strings.EMPTY;
    private String closeButtonText = Strings.EMPTY;
    private String productNameLabel = Strings.EMPTY;
    private String selectedProductName = Strings.EMPTY;

    public String getHeaderTitleText() {
        return headerTitleText;
    }

    public void setHeaderTitleText(String headerTitleText) {
        this.headerTitleText = headerTitleText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSaveButtonText() {
        return saveButtonText;
    }

    public void setSaveButtonText(String saveButtonText) {
        this.saveButtonText = saveButtonText;
    }

    public String getCloseButtonText() {
        return closeButtonText;
    }

    public void setCloseButtonText(String closeButtonText) {
        this.closeButtonText = closeButtonText;
    }

    public String getProductNameLabel() {
        return productNameLabel;
    }

    public void setProductNameLabel(String productNameLabel) {
        this.productNameLabel = productNameLabel;
    }

    public String getSelectedProductName() {
        return selectedProductName;
    }

    public void setSelectedProductName(String selectedProductName) {
        this.selectedProductName = selectedProductName;
    }
}
