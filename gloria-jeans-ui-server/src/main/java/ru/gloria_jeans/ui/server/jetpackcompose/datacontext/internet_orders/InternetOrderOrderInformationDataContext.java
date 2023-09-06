package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderOrderInformationDataContext extends InternetOrderDataContext {
    private String label = Strings.EMPTY;
    private String labelUnderLabel = Strings.EMPTY;
    private String documentNumberLabel = Strings.EMPTY;
    private String orderBarcode = Strings.EMPTY;
    private String dateFromLabel = StringUtils.EMPTY;
    private String dateToLabel = StringUtils.EMPTY;
    private String dateFrom = StringUtils.EMPTY;
    private String dateTo = StringUtils.EMPTY;
    private String orderTypeLabel = StringUtils.EMPTY;
    private String orderStatusLabel = StringUtils.EMPTY;
    private String orderType = StringUtils.EMPTY;
    private String orderStatus = StringUtils.EMPTY;
    private String searchButtonText = StringUtils.EMPTY;
    private List<String> selectedOrderTypes = new ArrayList<>();
    private List<String> selectedOrderStatus = new ArrayList<>();


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

    public String getDocumentNumberLabel() {
        return documentNumberLabel;
    }

    public void setDocumentNumberLabel(String documentNumberLabel) {
        this.documentNumberLabel = documentNumberLabel;
    }

    public String getDateFromLabel() {
        return dateFromLabel;
    }

    public void setDateFromLabel(String dateFromLabel) {
        this.dateFromLabel = dateFromLabel;
    }

    public String getDateToLabel() {
        return dateToLabel;
    }

    public void setDateToLabel(String dateToLabel) {
        this.dateToLabel = dateToLabel;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getOrderTypeLabel() {
        return orderTypeLabel;
    }

    public void setOrderTypeLabel(String orderTypeLabel) {
        this.orderTypeLabel = orderTypeLabel;
    }

    public String getOrderStatusLabel() {
        return orderStatusLabel;
    }

    public void setOrderStatusLabel(String orderStatusLabel) {
        this.orderStatusLabel = orderStatusLabel;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSearchButtonText() {
        return searchButtonText;
    }

    public void setSearchButtonText(String searchButtonText) {
        this.searchButtonText = searchButtonText;
    }

    public String getOrderBarcode() {
        return orderBarcode;
    }

    public void setOrderBarcode(String orderBarcode) {
        this.orderBarcode = orderBarcode;
    }

    public List<String> getSelectedOrderTypes() {
        return selectedOrderTypes;
    }

    public void setSelectedOrderTypes(List<String> selectedOrderTypes) {
        this.selectedOrderTypes = selectedOrderTypes;
    }

    public List<String> getSelectedOrderStatus() {
        return selectedOrderStatus;
    }

    public void setSelectedOrderStatus(List<String> selectedOrderStatus) {
        this.selectedOrderStatus = selectedOrderStatus;
    }
}
