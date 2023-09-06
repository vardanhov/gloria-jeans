package ru.gloria_jeans.core.v1.export.model;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.Date;

public class ExportDocumentModel extends BaseResponse {
    private Date createdAt;
    private String documentNumber;
    private String documentIdd;
    private String basis;
    private String warehouseReceiver;

    public ExportDocumentModel() {
    }

    public ExportDocumentModel(Date createdAt, String documentNumber, String documentIdd, String basis, String warehouseReceiver) {
        this.createdAt = createdAt;
        this.documentNumber = documentNumber;
        this.documentIdd = documentIdd;
        this.basis = basis;
        this.warehouseReceiver = warehouseReceiver;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getWarehouseReceiver() {
        return warehouseReceiver;
    }

    public void setWarehouseReceiver(String warehouseReceiver) {
        this.warehouseReceiver = warehouseReceiver;
    }
}
