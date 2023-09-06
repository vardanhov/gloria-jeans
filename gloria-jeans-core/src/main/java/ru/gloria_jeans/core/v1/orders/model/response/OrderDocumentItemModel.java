package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.UUID;

public class OrderDocumentItemModel extends BaseResponse {
    private UUID id;
    private String idd;
    private String item;
    private Integer quantity;
    private Integer quantityFact;
    private Integer quantityDiff;
    private Integer price;
    private Integer sum;
    private Boolean isMarksOk;
    private String listMarks;
    private String productName;
    private Boolean isMark;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(Integer quantityFact) {
        this.quantityFact = quantityFact;
    }

    public Integer getQuantityDiff() {
        return quantityDiff;
    }

    public void setQuantityDiff(Integer quantityDiff) {
        this.quantityDiff = quantityDiff;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getListMarks() {
        return listMarks;
    }

    public void setListMarks(String listMarks) {
        this.listMarks = listMarks;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean getIsMark() {
        return isMark;
    }

    public void setIsMark(Boolean isMark) {
        this.isMark = isMark;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getMarksOk() {
        return isMarksOk;
    }

    public void setMarksOk(Boolean marksOk) {
        isMarksOk = marksOk;
    }

    public Boolean getMark() {
        return isMark;
    }

    public void setMark(Boolean mark) {
        isMark = mark;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }
}
