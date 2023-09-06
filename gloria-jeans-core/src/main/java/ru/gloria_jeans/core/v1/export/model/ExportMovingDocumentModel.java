package ru.gloria_jeans.core.v1.export.model;

import java.util.Date;

public class ExportMovingDocumentModel {
    private String status;
    private String moving;
    private Date acceptanceDate;
    private String number;
    private Date dateCreated;
    private String purpose;
    private String consigneeWarehouse;
    private String basis;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMoving() {
        return moving;
    }

    public void setMoving(String moving) {
        this.moving = moving;
    }

    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getConsigneeWarehouse() {
        return consigneeWarehouse;
    }

    public void setConsigneeWarehouse(String consigneeWarehouse) {
        this.consigneeWarehouse = consigneeWarehouse;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
