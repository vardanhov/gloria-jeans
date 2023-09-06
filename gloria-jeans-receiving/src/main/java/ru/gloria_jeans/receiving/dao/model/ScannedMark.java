package ru.gloria_jeans.receiving.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "warehouse_scanned_marks")
public class ScannedMark implements Serializable {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "open_lot_id")
    private UUID openLotId;

    @Column(name = "number")
    private int number;

    @Column(name = "barcode_box")
    private String barcodeBox;

    @Column(name = "mark_type_code")
    private String markTypeCode;

    @Column(name = "scanned_mark")
    private String scannedMark;

    @Column(name = "data_matrix")
    private String dataMatrix;

    @Column(name = "is_valid_mark")
    private Boolean isValidMark;

    @Column(name = "error_message")
    private String errorMessage;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getOpenLotId() {
        return openLotId;
    }

    public void setOpenLotId(UUID openLotId) {
        this.openLotId = openLotId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMarkTypeCode() {
        return markTypeCode;
    }

    public void setMarkTypeCode(String markTypeCode) {
        this.markTypeCode = markTypeCode;
    }

    public String getScannedMark() {
        return scannedMark;
    }

    public void setScannedMark(String scannedMark) {
        this.scannedMark = scannedMark;
    }

    public String getDataMatrix() {
        return dataMatrix;
    }

    public void setDataMatrix(String dataMatrix) {
        this.dataMatrix = dataMatrix;
    }

    public Boolean getValidMark() {
        return isValidMark;
    }

    public void setValidMark(Boolean validMark) {
        isValidMark = validMark;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }
}
