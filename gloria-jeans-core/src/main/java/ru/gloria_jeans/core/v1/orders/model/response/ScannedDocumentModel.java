package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.Date;

public class ScannedDocumentModel extends BaseResponse {

    private String orderNumber;

    private Date dateCreated;

    private String orderType;

    private String errorText;

    private String orderStatus;

    private String shippingMethod;

    private String tk;

    public ScannedDocumentModel() {
    }

    public ScannedDocumentModel(String orderNumber, Date dateCreated, String orderType, String errorText, String scanStatus, String shippingMethod, String tk) {
        this.orderNumber = orderNumber;
        this.dateCreated = dateCreated;
        this.orderType = orderType;
        this.errorText = errorText;
        this.orderStatus = scanStatus;
        this.shippingMethod = shippingMethod;
        this.tk = tk;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }
}
