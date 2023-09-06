package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentModelType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovingDocumentModel extends BaseResponse {
    private String id;
    private String lotId;
    private String lotName;
    private String number;
    private String status;
    private Date createdDate;
    private String documentReason;
    private String reason;
    private String barcode;
    private String count;
    private List<ProductModel> productModels = new ArrayList<>();
    private MovingDocumentModelType type;
    private String quantity;
    private String quantityFact;
    private String quantityDiff;
    private String lineNumberLot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDocumentReason() {
        return documentReason;
    }

    public void setDocumentReason(String documentReason) {
        this.documentReason = documentReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<ProductModel> getProductModels() {
        return productModels;
    }

    public void setProductModels(List<ProductModel> productModels) {
        this.productModels = productModels;
    }

    public MovingDocumentModelType getType() {
        return type;
    }

    public void setType(MovingDocumentModelType type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(String quantityFact) {
        this.quantityFact = quantityFact;
    }

    public String getQuantityDiff() {
        return quantityDiff;
    }

    public void setQuantityDiff(String quantityDiff) {
        this.quantityDiff = quantityDiff;
    }

    public String getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(String lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }
}
