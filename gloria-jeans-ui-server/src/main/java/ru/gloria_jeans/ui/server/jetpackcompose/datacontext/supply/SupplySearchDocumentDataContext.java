package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplySearchDocumentDataContext extends SupplyDataContext {
    private String documentBarcode = StringUtils.EMPTY;
    private String documentNumber = StringUtils.EMPTY;
    private String documentType = StringUtils.EMPTY;
    private String documentStatus = StringUtils.EMPTY;
    private String dateFrom = StringUtils.EMPTY;
    private String dateTo = StringUtils.EMPTY;
    private String labelDateFrom = StringUtils.EMPTY;
    private String labelDateTo = StringUtils.EMPTY;
    private String sender = StringUtils.EMPTY;
    private String or = StringUtils.EMPTY;
    private String resultCountText = StringUtils.EMPTY;
    private List<String> selectedItems = new ArrayList<>();
    private String labelStatus = StringUtils.EMPTY;

    public String getDocumentBarcode() {
        return documentBarcode;
    }

    public void setDocumentBarcode(String documentBarcode) {
        this.documentBarcode = documentBarcode;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
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

    public String getLabelDateFrom() {
        return labelDateFrom;
    }

    public void setLabelDateFrom(String labelDateFrom) {
        this.labelDateFrom = labelDateFrom;
    }

    public String getLabelDateTo() {
        return labelDateTo;
    }

    public void setLabelDateTo(String labelDateTo) {
        this.labelDateTo = labelDateTo;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getOr() {
        return or;
    }

    public void setOr(String or) {
        this.or = or;
    }

    public String getResultCountText() {
        return resultCountText;
    }

    public void setResultCountText(String resultCountText) {
        this.resultCountText = resultCountText;
    }

    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public String getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }
}
