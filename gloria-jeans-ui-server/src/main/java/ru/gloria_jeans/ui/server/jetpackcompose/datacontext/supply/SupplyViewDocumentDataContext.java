package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyViewDocumentDataContext extends SupplySearchDocumentDataContext {
    private String selectedDocumentIdd = StringUtils.EMPTY;
    private String quantityBox = StringUtils.EMPTY;
    private String quantity = StringUtils.EMPTY;
    private String type = StringUtils.EMPTY;
    private String status = StringUtils.EMPTY;
    private String docDate = StringUtils.EMPTY;
    private String acceptBy = StringUtils.EMPTY;
    private String from = StringUtils.EMPTY;
    private String senderText = StringUtils.EMPTY;
    private String acceptedBoxText = StringUtils.EMPTY;
    private String unitText = StringUtils.EMPTY;
    private String supplyButtonText = StringUtils.EMPTY;
    private String confidentialAcceptanceButtonText = StringUtils.EMPTY;
    private String removeFromHoldingButtonText = StringUtils.EMPTY;
    private String printingPackingListButtonText = StringUtils.EMPTY;
    private String printingTrade13ButtonText = StringUtils.EMPTY;
    private String printingTrade13ButtonTextPlan = StringUtils.EMPTY;
    private String comment = StringUtils.EMPTY;

    public String getSelectedDocumentIdd() {
        return selectedDocumentIdd;
    }

    public void setSelectedDocumentIdd(String selectedDocumentIdd) {
        this.selectedDocumentIdd = selectedDocumentIdd;
    }

    public String getQuantityBox() {
        return quantityBox;
    }

    public void setQuantityBox(String quantityBox) {
        this.quantityBox = quantityBox;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(String acceptBy) {
        this.acceptBy = acceptBy;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSenderText() {
        return senderText;
    }

    public void setSenderText(String senderText) {
        this.senderText = senderText;
    }

    public String getAcceptedBoxText() {
        return acceptedBoxText;
    }

    public void setAcceptedBoxText(String acceptedBoxText) {
        this.acceptedBoxText = acceptedBoxText;
    }

    public String getUnitText() {
        return unitText;
    }

    public void setUnitText(String unitText) {
        this.unitText = unitText;
    }

    public String getFrom() {
        return from;
    }

    public String getSupplyButtonText() {
        return supplyButtonText;
    }

    public void setSupplyButtonText(String supplyButtonText) {
        this.supplyButtonText = supplyButtonText;
    }

    public String getConfidentialAcceptanceButtonText() {
        return confidentialAcceptanceButtonText;
    }

    public void setConfidentialAcceptanceButtonText(String confidentialAcceptanceButtonText) {
        this.confidentialAcceptanceButtonText = confidentialAcceptanceButtonText;
    }

    public String getRemoveFromHoldingButtonText() {
        return removeFromHoldingButtonText;
    }

    public void setRemoveFromHoldingButtonText(String removeFromHoldingButtonText) {
        this.removeFromHoldingButtonText = removeFromHoldingButtonText;
    }

    public String getPrintingPackingListButtonText() {
        return printingPackingListButtonText;
    }

    public void setPrintingPackingListButtonText(String printingPackingListButtonText) {
        this.printingPackingListButtonText = printingPackingListButtonText;
    }

    public String getPrintingTrade13ButtonText() {
        return printingTrade13ButtonText;
    }

    public void setPrintingTrade13ButtonText(String printingTrade13ButtonText) {
        this.printingTrade13ButtonText = printingTrade13ButtonText;
    }

    public String getPrintingTrade13ButtonTextPlan() {
        return printingTrade13ButtonTextPlan;
    }

    public void setPrintingTrade13ButtonTextPlan(String printingTrade13ButtonTextPlan) {
        this.printingTrade13ButtonTextPlan = printingTrade13ButtonTextPlan;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
