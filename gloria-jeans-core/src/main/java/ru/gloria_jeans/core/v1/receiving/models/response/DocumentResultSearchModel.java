package ru.gloria_jeans.core.v1.receiving.models.response;

import java.util.Date;

public class DocumentResultSearchModel {
    private String idd;
    private String docNumber;
    private String type;
    private Date docDate;
    private String status;
    private String totalBoxes;
    private String factBoxes;
    private String totalQuantity;
    private String factQuantity;
    private String warehouse;

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalBoxes() {
        return totalBoxes;
    }

    public void setTotalBoxes(String totalBoxes) {
        this.totalBoxes = totalBoxes;
    }

    public String getFactBoxes() {
        return factBoxes;
    }

    public void setFactBoxes(String factBoxes) {
        this.factBoxes = factBoxes;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getFactQuantity() {
        return factQuantity;
    }

    public void setFactQuantity(String factQuantity) {
        this.factQuantity = factQuantity;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
