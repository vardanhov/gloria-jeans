package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

public class ExportCollectBoxDataContext extends DataContext {
    private String documentNumber = StringUtils.EMPTY;
    private String barcodeBox = Strings.EMPTY;
    private String barcode = Strings.EMPTY;
    private String barcodeLabel = Strings.EMPTY;
    private String searchButtonText = Strings.EMPTY;
    private String createBoxButtonText = Strings.EMPTY;
    private String clearBoxButtonText = Strings.EMPTY;
    private String handleSearch = Strings.EMPTY;
    private String scannedSearch = Strings.EMPTY;
    private String titleText = Strings.EMPTY;
    private String bodyText = Strings.EMPTY;
    private String continueButtonText = Strings.EMPTY;
    private String exitButtonText = Strings.EMPTY;
    private String deleteItemButtonText = Strings.EMPTY;
    private String addMarkButton = Strings.EMPTY;
    private String label = Strings.EMPTY;
    private String labelUnderLabel = Strings.EMPTY;
    private String boxNumber = Strings.EMPTY;
    private String exportLabel = Strings.EMPTY;
    private String staticTextLabel = Strings.EMPTY;
    private String exportDate = Strings.EMPTY;
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcodeLabel() {
        return barcodeLabel;
    }

    public void setBarcodeLabel(String barcodeLabel) {
        this.barcodeLabel = barcodeLabel;
    }

    public String getSearchButtonText() {
        return searchButtonText;
    }

    public void setSearchButtonText(String searchButtonText) {
        this.searchButtonText = searchButtonText;
    }

    public String getCreateBoxButtonText() {
        return createBoxButtonText;
    }

    public void setCreateBoxButtonText(String createBoxButtonText) {
        this.createBoxButtonText = createBoxButtonText;
    }

    public String getClearBoxButtonText() {
        return clearBoxButtonText;
    }

    public void setClearBoxButtonText(String clearBoxButtonText) {
        this.clearBoxButtonText = clearBoxButtonText;
    }

    public String getHandleSearch() {
        return handleSearch;
    }

    public void setHandleSearch(String handleSearch) {
        this.handleSearch = handleSearch;
    }

    public String getScannedSearch() {
        return scannedSearch;
    }

    public void setScannedSearch(String scannedSearch) {
        this.scannedSearch = scannedSearch;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getContinueButtonText() {
        return continueButtonText;
    }

    public void setContinueButtonText(String continueButtonText) {
        this.continueButtonText = continueButtonText;
    }

    public String getExitButtonText() {
        return exitButtonText;
    }

    public void setExitButtonText(String exitButtonText) {
        this.exitButtonText = exitButtonText;
    }

    public String getDeleteItemButtonText() {
        return deleteItemButtonText;
    }

    public void setDeleteItemButtonText(String deleteItemButtonText) {
        this.deleteItemButtonText = deleteItemButtonText;
    }

    public String getAddMarkButton() {
        return addMarkButton;
    }

    public void setAddMarkButton(String addMarkButton) {
        this.addMarkButton = addMarkButton;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelUnderLabel() {
        return labelUnderLabel;
    }

    public void setLabelUnderLabel(String labelUnderLabel) {
        this.labelUnderLabel = labelUnderLabel;
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getExportLabel() {
        return exportLabel;
    }

    public void setExportLabel(String exportLabel) {
        this.exportLabel = exportLabel;
    }

    public String getStaticTextLabel() {
        return staticTextLabel;
    }

    public void setStaticTextLabel(String staticTextLabel) {
        this.staticTextLabel = staticTextLabel;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }
}
