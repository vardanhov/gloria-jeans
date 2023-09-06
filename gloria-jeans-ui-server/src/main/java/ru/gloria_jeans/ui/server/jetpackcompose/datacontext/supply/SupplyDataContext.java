package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyDataContext extends DataContext {
    private String label = Strings.EMPTY;
    private String labelUnderLabel = Strings.EMPTY;
    private String scanBarCodeLabel = Strings.EMPTY;
    private String boxNumberLabel = Strings.EMPTY;
    private String barcodeBox = Strings.EMPTY;
    private String barcodeBoxPlaceholder = Strings.EMPTY;
    private String buttonSearchText = Strings.EMPTY;
    private String buttonSearchDocumentText = Strings.EMPTY;
    private String yesButtonText = Strings.EMPTY;
    private String noButtonText = Strings.EMPTY;

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

    public String getScanBarCodeLabel() {
        return scanBarCodeLabel;
    }

    public void setScanBarCodeLabel(String scanBarCodeLabel) {
        this.scanBarCodeLabel = scanBarCodeLabel;
    }

    public String getBoxNumberLabel() {
        return boxNumberLabel;
    }

    public void setBoxNumberLabel(String boxNumberLabel) {
        this.boxNumberLabel = boxNumberLabel;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getBarcodeBoxPlaceholder() {
        return barcodeBoxPlaceholder;
    }

    public void setBarcodeBoxPlaceholder(String barcodeBoxPlaceholder) {
        this.barcodeBoxPlaceholder = barcodeBoxPlaceholder;
    }

    public String getButtonSearchText() {
        return buttonSearchText;
    }

    public void setButtonSearchText(String buttonSearchText) {
        this.buttonSearchText = buttonSearchText;
    }

    public String getButtonSearchDocumentText() {
        return buttonSearchDocumentText;
    }

    public void setButtonSearchDocumentText(String buttonSearchDocumentText) {
        this.buttonSearchDocumentText = buttonSearchDocumentText;
    }

    public String getYesButtonText() {
        return yesButtonText;
    }

    public void setYesButtonText(String yesButtonText) {
        this.yesButtonText = yesButtonText;
    }

    public String getNoButtonText() {
        return noButtonText;
    }

    public void setNoButtonText(String noButtonText) {
        this.noButtonText = noButtonText;
    }
}
