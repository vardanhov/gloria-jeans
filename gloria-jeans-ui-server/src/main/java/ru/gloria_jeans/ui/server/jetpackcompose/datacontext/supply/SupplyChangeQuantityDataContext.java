package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyChangeQuantityDataContext extends SupplyMenuProductDataContext {
    private String changeQuantityLabel = Strings.EMPTY;
    private String productPlanLabel = Strings.EMPTY;
    private String productFactLabel = Strings.EMPTY;
    private String selectedProductCountPlan = Strings.EMPTY;
    private String selectedProductCountFact = Strings.EMPTY;
    private String saveButtonText = Strings.EMPTY;
    private String closeButtonText = Strings.EMPTY;
    private String productNameLabel = Strings.EMPTY;
    private String selectedProductName = Strings.EMPTY;

    public String getChangeQuantityLabel() {
        return changeQuantityLabel;
    }

    public void setChangeQuantityLabel(String changeQuantityLabel) {
        this.changeQuantityLabel = changeQuantityLabel;
    }

    public String getProductPlanLabel() {
        return productPlanLabel;
    }

    public void setProductPlanLabel(String productPlanLabel) {
        this.productPlanLabel = productPlanLabel;
    }

    public String getProductFactLabel() {
        return productFactLabel;
    }

    public void setProductFactLabel(String productFactLabel) {
        this.productFactLabel = productFactLabel;
    }


    public String getSelectedProductCountPlan() {
        return selectedProductCountPlan;
    }

    public void setSelectedProductCountPlan(String selectedProductCountPlan) {
        this.selectedProductCountPlan = selectedProductCountPlan;
    }

    public String getSelectedProductCountFact() {
        return selectedProductCountFact;
    }

    public void setSelectedProductCountFact(String selectedProductCountFact) {
        this.selectedProductCountFact = selectedProductCountFact;
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
