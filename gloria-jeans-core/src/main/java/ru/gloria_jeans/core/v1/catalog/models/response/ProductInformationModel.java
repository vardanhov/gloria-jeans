package ru.gloria_jeans.core.v1.catalog.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductInformationModel extends BaseResponse {
    private String productName;
    private String priceType;
    private String price;
    private Date date;
    private String remainingGoods;
    private String vendorCode;
    private String barCode;
    private List<SizeRangeModel> sizeRange;
    private String idd;
    private Boolean hasMarks;
    private Boolean isValidMark;
    private String serialNumberOfMark;
    private String statusOfMark;
    private String totalQuantity;
    private List<SizeRangeModel> modelsBalanceList;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemainingGoods() {
        return remainingGoods;
    }

    public void setRemainingGoods(String remainingGoods) {
        this.remainingGoods = remainingGoods;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public List<SizeRangeModel> getSizeRange() {
        return sizeRange;
    }

    public void setSizeRange(List<SizeRangeModel> sizeRange) {
        this.sizeRange = sizeRange;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public Boolean getHasMarks() {
        return hasMarks;
    }

    public void setHasMarks(Boolean hasMarks) {
        this.hasMarks = hasMarks;
    }

    public Boolean getValidMark() {
        return isValidMark;
    }

    public void setValidMark(Boolean validMark) {
        isValidMark = validMark;
    }

    public String getSerialNumberOfMark() {
        return serialNumberOfMark;
    }

    public void setSerialNumberOfMark(String serialNumberOfMark) {
        this.serialNumberOfMark = serialNumberOfMark;
    }

    public String getStatusOfMark() {
        return statusOfMark;
    }

    public void setStatusOfMark(String statusOfMark) {
        this.statusOfMark = statusOfMark;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<SizeRangeModel> getModelsBalanceList() {
        return modelsBalanceList;
    }

    public void setModelsBalanceList(List<SizeRangeModel> modelsBalanceList) {
        this.modelsBalanceList = modelsBalanceList;
    }
}
