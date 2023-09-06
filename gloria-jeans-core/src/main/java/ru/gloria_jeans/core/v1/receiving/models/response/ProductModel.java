package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.math.BigDecimal;

public class ProductModel extends BaseResponse {
    private String id;
    private String name;
    private String vendorCode;
    private Integer countPlan = 0;
    private Integer countFact = 0;
    private Integer countDiff = 0;
    private Integer countDiffProductsIntoLot = -1;
    private String serialNumber;
    private boolean isMark;
    private boolean isLot;
    private String barcode;
    private boolean isScannedMark;
    private BigDecimal price;
    private Integer lineNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Integer getCountPlan() {
        return countPlan;
    }

    public void setCountPlan(Integer countPlan) {
        this.countPlan = countPlan;
    }

    public Integer getCountFact() {
        return countFact;
    }

    public void setCountFact(Integer countFact) {
        this.countFact = countFact;
    }

    public Integer getCountDiff() {
        return countDiff;
    }

    public void setCountDiff(Integer countDiff) {
        this.countDiff = countDiff;
    }

    public Integer getCountDiffProductsIntoLot() {
        return countDiffProductsIntoLot;
    }

    public void setCountDiffProductsIntoLot(Integer countDiffProductsIntoLot) {
        this.countDiffProductsIntoLot = countDiffProductsIntoLot;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isMark() {
        return isMark;
    }

    public void setMark(boolean mark) {
        isMark = mark;
    }

    public boolean isLot() {
        return isLot;
    }

    public void setLot(boolean lot) {
        isLot = lot;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean isScannedMark() {
        return isScannedMark;
    }

    public void setScannedMark(boolean scannedMark) {
        isScannedMark = scannedMark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
