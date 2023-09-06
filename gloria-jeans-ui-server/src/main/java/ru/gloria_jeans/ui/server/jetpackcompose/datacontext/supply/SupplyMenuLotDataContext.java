package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import org.apache.commons.lang3.StringUtils;

public class SupplyMenuLotDataContext extends SupplyRecalculationLotDataContext {
    private String changeQuantityButtonText = StringUtils.EMPTY;
    private String clearPositionFactButtonText = StringUtils.EMPTY;
    private String clearFactAllPositionButtonText = StringUtils.EMPTY;
    private String confidentialAcceptanceButtonText = StringUtils.EMPTY;
    private String removePositionButtonText = StringUtils.EMPTY;
    private String viewPositionImageButtonText = StringUtils.EMPTY;
    private String viewDiscrepanciesButtonText = StringUtils.EMPTY;

    public String getChangeQuantityButtonText() {
        return changeQuantityButtonText;
    }

    public void setChangeQuantityButtonText(String changeQuantityButtonText) {
        this.changeQuantityButtonText = changeQuantityButtonText;
    }

    public String getClearPositionFactButtonText() {
        return clearPositionFactButtonText;
    }

    public void setClearPositionFactButtonText(String clearPositionFactButtonText) {
        this.clearPositionFactButtonText = clearPositionFactButtonText;
    }

    public String getClearFactAllPositionButtonText() {
        return clearFactAllPositionButtonText;
    }

    public void setClearFactAllPositionButtonText(String clearFactAllPositionButtonText) {
        this.clearFactAllPositionButtonText = clearFactAllPositionButtonText;
    }

    public String getConfidentialAcceptanceButtonText() {
        return confidentialAcceptanceButtonText;
    }

    public void setConfidentialAcceptanceButtonText(String confidentialAcceptanceButtonText) {
        this.confidentialAcceptanceButtonText = confidentialAcceptanceButtonText;
    }

    public String getRemovePositionButtonText() {
        return removePositionButtonText;
    }

    public void setRemovePositionButtonText(String removePositionButtonText) {
        this.removePositionButtonText = removePositionButtonText;
    }

    public String getViewPositionImageButtonText() {
        return viewPositionImageButtonText;
    }

    public void setViewPositionImageButtonText(String viewPositionImageButtonText) {
        this.viewPositionImageButtonText = viewPositionImageButtonText;
    }

    public String getViewDiscrepanciesButtonText() {
        return viewDiscrepanciesButtonText;
    }

    public void setViewDiscrepanciesButtonText(String viewDiscrepanciesButtonText) {
        this.viewDiscrepanciesButtonText = viewDiscrepanciesButtonText;
    }

}
