package ru.gloria_jeans.core.v1.receiving.models.request;

import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentStatus;

import java.io.Serializable;
import java.util.List;

public class SearchingDocuments implements Serializable {
    private String documentBarcode;
    private String dateFrom;
    private String dateTo;
    private List<MovingDocumentStatus> selectedStatuses;

    public SearchingDocuments() {
    }

    public SearchingDocuments(String documentBarcode, String dateFrom, String dateTo, List<MovingDocumentStatus> selectedStatuses) {
        this.documentBarcode = documentBarcode;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.selectedStatuses = selectedStatuses;
    }

    public String getDocumentBarcode() {
        return documentBarcode;
    }

    public void setDocumentBarcode(String documentBarcode) {
        this.documentBarcode = documentBarcode;
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

    public List<MovingDocumentStatus> getSelectedStatuses() {
        return selectedStatuses;
    }

    public void setSelectedStatuses(List<MovingDocumentStatus> selectedStatuses) {
        this.selectedStatuses = selectedStatuses;
    }
}