package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.Date;

public class ConfirmDiscrepancyModel extends BaseResponse {
    private String documentNumber;
    private Date documentDate;
    private String warehouse;
    private Integer boxPlan;
    private Integer boxFact;
    private Integer boxDifference;
    private Integer productPlan;
    private Integer productFact;
    private Integer productDifference;
    private Integer lotPlan;
    private Integer lotFact;
    private Integer lotDifference;
    private Integer lotProductPlan;
    private Integer lotProductFact;
    private Integer lotProductDifference;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getBoxPlan() {
        return boxPlan;
    }

    public void setBoxPlan(Integer boxPlan) {
        this.boxPlan = boxPlan;
    }

    public Integer getBoxFact() {
        return boxFact;
    }

    public void setBoxFact(Integer boxFact) {
        this.boxFact = boxFact;
    }

    public Integer getBoxDifference() {
        return boxDifference;
    }

    public void setBoxDifference(Integer boxDifference) {
        this.boxDifference = boxDifference;
    }

    public Integer getProductPlan() {
        return productPlan;
    }

    public void setProductPlan(Integer productPlan) {
        this.productPlan = productPlan;
    }

    public Integer getProductFact() {
        return productFact;
    }

    public void setProductFact(Integer productFact) {
        this.productFact = productFact;
    }

    public Integer getProductDifference() {
        return productDifference;
    }

    public void setProductDifference(Integer productDifference) {
        this.productDifference = productDifference;
    }

    public Integer getLotPlan() {
        return lotPlan;
    }

    public void setLotPlan(Integer lotPlan) {
        this.lotPlan = lotPlan;
    }

    public Integer getLotFact() {
        return lotFact;
    }

    public void setLotFact(Integer lotFact) {
        this.lotFact = lotFact;
    }

    public Integer getLotDifference() {
        return lotDifference;
    }

    public void setLotDifference(Integer lotDifference) {
        this.lotDifference = lotDifference;
    }

    public Integer getLotProductPlan() {
        return lotProductPlan;
    }

    public void setLotProductPlan(Integer lotProductPlan) {
        this.lotProductPlan = lotProductPlan;
    }

    public Integer getLotProductFact() {
        return lotProductFact;
    }

    public void setLotProductFact(Integer lotProductFact) {
        this.lotProductFact = lotProductFact;
    }

    public Integer getLotProductDifference() {
        return lotProductDifference;
    }

    public void setLotProductDifference(Integer lotProductDifference) {
        this.lotProductDifference = lotProductDifference;
    }
}
