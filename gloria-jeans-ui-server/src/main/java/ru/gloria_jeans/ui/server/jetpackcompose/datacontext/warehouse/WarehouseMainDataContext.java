package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.warehouse;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarehouseMainDataContext extends DataContext {
    private String supplyButtonLabel;
    private String exportButtonLabel;
    private String itemInformationButtonLabel;
    private String inventoryButtonLabel;
    private String internetOrderButtonLabel;

    public String getSupplyButtonLabel() {
        return supplyButtonLabel;
    }

    public void setSupplyButtonLabel(String supplyButtonLabel) {
        this.supplyButtonLabel = supplyButtonLabel;
    }

    public String getExportButtonLabel() {
        return exportButtonLabel;
    }

    public void setExportButtonLabel(String exportButtonLabel) {
        this.exportButtonLabel = exportButtonLabel;
    }

    public String getItemInformationButtonLabel() {
        return itemInformationButtonLabel;
    }

    public void setItemInformationButtonLabel(String itemInformationButtonLabel) {
        this.itemInformationButtonLabel = itemInformationButtonLabel;
    }

    public String getInventoryButtonLabel() {
        return inventoryButtonLabel;
    }

    public void setInventoryButtonLabel(String inventoryButtonLabel) {
        this.inventoryButtonLabel = inventoryButtonLabel;
    }

    public String getInternetOrderButtonLabel() {
        return internetOrderButtonLabel;
    }

    public void setInternetOrderButtonLabel(String internetOrderButtonLabel) {
        this.internetOrderButtonLabel = internetOrderButtonLabel;
    }
}
