package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyRecalculationBoxDataContext extends SupplySearchDataContext {
    private String type = StringUtils.EMPTY;
    private String documentNumber = StringUtils.EMPTY;
    private String quantity = StringUtils.EMPTY;
    private String quantityFact = StringUtils.EMPTY;
    private String quantityDiff = StringUtils.EMPTY;
    private String docDate = StringUtils.EMPTY;
    private String from = StringUtils.EMPTY;
    private String label = StringUtils.EMPTY;
    private String boxLabel = StringUtils.EMPTY;
    private String acceptedPiecesLabel = StringUtils.EMPTY;
    private String quantityLabel = StringUtils.EMPTY;
    private String quantityFactLabel = StringUtils.EMPTY;
    private String quantityDiffLabel = StringUtils.EMPTY;
    private boolean showTextField;
    private boolean buttonFinish;
    private String manualInputBarcodeButtonText = StringUtils.EMPTY;
    private String changeQuantityButtonText = StringUtils.EMPTY;
    private String clearPositionFactButtonText = StringUtils.EMPTY;
    private String clearFactAllPositionButtonText = StringUtils.EMPTY;
    private String confidentialAcceptanceButtonText = StringUtils.EMPTY;
    private String deletePositionButtonText = StringUtils.EMPTY;
    private String removePositionButtonText = StringUtils.EMPTY;
    private String viewPositionImageButtonText = StringUtils.EMPTY;
    private String viewDiscrepanciesButtonText = StringUtils.EMPTY;
    private String selectedProductId = Strings.EMPTY;
    private String addMarkButton = Strings.EMPTY;
    private String handleEnterCodeText = Strings.EMPTY;
    private String codeNumberText = Strings.EMPTY;
    private String buttonSearchText = Strings.EMPTY;
    private String printingPackagingButtonText = Strings.EMPTY;
    private String textLineFirst = Strings.EMPTY;
    private String textLineSecond = Strings.EMPTY;
    private String textButton = Strings.EMPTY;
    private String selectedDocumentIdd = StringUtils.EMPTY;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(String quantityFact) {
        this.quantityFact = quantityFact;
    }

    public String getQuantityDiff() {
        return quantityDiff;
    }

    public void setQuantityDiff(String quantityDiff) {
        this.quantityDiff = quantityDiff;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBoxLabel() {
        return boxLabel;
    }

    public void setBoxLabel(String boxLabel) {
        this.boxLabel = boxLabel;
    }

    public String getAcceptedPiecesLabel() {
        return acceptedPiecesLabel;
    }

    public void setAcceptedPiecesLabel(String acceptedPiecesLabel) {
        this.acceptedPiecesLabel = acceptedPiecesLabel;
    }

    public String getQuantityLabel() {
        return quantityLabel;
    }

    public void setQuantityLabel(String quantityLabel) {
        this.quantityLabel = quantityLabel;
    }

    public String getQuantityFactLabel() {
        return quantityFactLabel;
    }

    public void setQuantityFactLabel(String quantityFactLabel) {
        this.quantityFactLabel = quantityFactLabel;
    }

    public String getQuantityDiffLabel() {
        return quantityDiffLabel;
    }

    public void setQuantityDiffLabel(String quantityDiffLabel) {
        this.quantityDiffLabel = quantityDiffLabel;
    }

    public boolean isShowTextField() {
        return showTextField;
    }

    public void setShowTextField(boolean showTextField) {
        this.showTextField = showTextField;
    }

    public String getManualInputBarcodeButtonText() {
        return manualInputBarcodeButtonText;
    }

    public void setManualInputBarcodeButtonText(String manualInputBarcodeButtonText) {
        this.manualInputBarcodeButtonText = manualInputBarcodeButtonText;
    }

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

    public String getDeletePositionButtonText() {
        return deletePositionButtonText;
    }

    public void setDeletePositionButtonText(String deletePositionButtonText) {
        this.deletePositionButtonText = deletePositionButtonText;
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

    public String getHandleEnterCodeText() {
        return handleEnterCodeText;
    }

    public void setHandleEnterCodeText(String handleEnterCodeText) {
        this.handleEnterCodeText = handleEnterCodeText;
    }

    public String getCodeNumberText() {
        return codeNumberText;
    }

    public void setCodeNumberText(String codeNumberText) {
        this.codeNumberText = codeNumberText;
    }

    public String getButtonSearchText() {
        return buttonSearchText;
    }

    public void setButtonSearchText(String buttonSearchText) {
        this.buttonSearchText = buttonSearchText;
    }

    public String getPrintingPackagingButtonText() {
        return printingPackagingButtonText;
    }

    public void setPrintingPackagingButtonText(String printingPackagingButtonText) {
        this.printingPackagingButtonText = printingPackagingButtonText;
    }

    public String getRemovePositionButtonText() {
        return removePositionButtonText;
    }

    public void setRemovePositionButtonText(String removePositionButtonText) {
        this.removePositionButtonText = removePositionButtonText;
    }

    public boolean isButtonFinish() {
        return buttonFinish;
    }

    public void setButtonFinish(boolean buttonFinish) {
        this.buttonFinish = buttonFinish;
    }

    public String getTextLineFirst() {
        return textLineFirst;
    }

    public void setTextLineFirst(String textLineFirst) {
        this.textLineFirst = textLineFirst;
    }

    public String getTextLineSecond() {
        return textLineSecond;
    }

    public void setTextLineSecond(String textLineSecond) {
        this.textLineSecond = textLineSecond;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }

    public String getSelectedDocumentIdd() {
        return selectedDocumentIdd;
    }

    public void setSelectedDocumentIdd(String selectedDocumentIdd) {
        this.selectedDocumentIdd = selectedDocumentIdd;
    }
}
