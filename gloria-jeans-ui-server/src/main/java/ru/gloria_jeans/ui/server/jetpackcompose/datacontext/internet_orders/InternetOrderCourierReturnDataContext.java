package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCourierReturnDataContext extends DataContext {
    private String scanLabel = Strings.EMPTY;
    private String barcodeLabel = Strings.EMPTY;
    private String finishIssuanceOrders = Strings.EMPTY;
    private String searchButtonText = Strings.EMPTY;
    private String label = Strings.EMPTY;
    private String labelUnderLabel = Strings.EMPTY;
    private String handleSearch = Strings.EMPTY;
    private String scannedSearch = Strings.EMPTY;
    private String internetOrderMenuReturnComplete = Strings.EMPTY;

    public String getScanLabel() {
        return scanLabel;
    }

    public void setScanLabel(String scanLabel) {
        this.scanLabel = scanLabel;
    }

    public String getBarcodeLabel() {
        return barcodeLabel;
    }

    public void setBarcodeLabel(String barcodeLabel) {
        this.barcodeLabel = barcodeLabel;
    }

    public String getFinishIssuanceOrders() {
        return finishIssuanceOrders;
    }

    public void setFinishIssuanceOrders(String finishIssuanceOrders) {
        this.finishIssuanceOrders = finishIssuanceOrders;
    }

    public String getSearchButtonText() {
        return searchButtonText;
    }

    public void setSearchButtonText(String searchButtonText) {
        this.searchButtonText = searchButtonText;
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

    public String getInternetOrderMenuReturnComplete() {
        return internetOrderMenuReturnComplete;
    }

    public void setInternetOrderMenuReturnComplete(String internetOrderMenuReturnComplete) {
        this.internetOrderMenuReturnComplete = internetOrderMenuReturnComplete;
    }
}
