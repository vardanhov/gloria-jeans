package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyMenuProductDataContext extends SupplyMenuLotDataContext {
    private String selectedProductId = Strings.EMPTY;
    private String addMarkButton = Strings.EMPTY;

    public String getSelectedProductId() {
        return selectedProductId;
    }

    public void setSelectedProductId(String selectedProductId) {
        this.selectedProductId = selectedProductId;
    }

    public String getAddMarkButton() {
        return addMarkButton;
    }

    public void setAddMarkButton(String addMarkButton) {
        this.addMarkButton = addMarkButton;
    }
}
