package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInformationSearchDataContext extends DataContext {
    private String label = Strings.EMPTY;
    private String labelUnderLabel = Strings.EMPTY;
    private String barcodeLabel = Strings.EMPTY;
    private String barcode = Strings.EMPTY;
    private String searchButtonText = Strings.EMPTY;
    private String buttonSearchProductByVendorCode = Strings.EMPTY;
    private String secondTitle = Strings.EMPTY;
    private String handleSearch = Strings.EMPTY;

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

    public String getBarcodeLabel() {
        return barcodeLabel;
    }

    public void setBarcodeLabel(String barcodeLabel) {
        this.barcodeLabel = barcodeLabel;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSearchButtonText() {
        return searchButtonText;
    }

    public void setSearchButtonText(String searchButtonText) {
        this.searchButtonText = searchButtonText;
    }

    public void setButtonSearchProductByVendorCode(String buttonSearchProductByVendorCode) {
        this.buttonSearchProductByVendorCode = buttonSearchProductByVendorCode;
    }
    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getButtonSearchProductByVendorCode() {
        return buttonSearchProductByVendorCode;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public String getHandleSearch() {
        return handleSearch;
    }

    public void setHandleSearch(String handleSearch) {
        this.handleSearch = handleSearch;
    }
}