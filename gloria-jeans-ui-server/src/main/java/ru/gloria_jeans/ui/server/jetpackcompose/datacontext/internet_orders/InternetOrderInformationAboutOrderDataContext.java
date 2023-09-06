package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderInformationAboutOrderDataContext extends InternetOrderOrderInformationDataContext {
    private String orderLabel = Strings.EMPTY;
    private String from = Strings.EMPTY;
    private String senderLabel = Strings.EMPTY;
    private String sender = Strings.EMPTY;
    private String orderDate = Strings.EMPTY;
    private String transportCompanyLabel = Strings.EMPTY;
    private String transportCompany = Strings.EMPTY;
    private String fullNameLabel = Strings.EMPTY;
    private String fullName = Strings.EMPTY;
    private String orderStatusLabel = Strings.EMPTY;
    private String orderStatus = Strings.EMPTY;
    private String courierDeliveryButton = Strings.EMPTY;
    private String courierReturnButton = Strings.EMPTY;
    private String orderDisbandmentButton = Strings.EMPTY;
    private String orderNumber = Strings.EMPTY;

    public String getOrderLabel() {
        return orderLabel;
    }

    public void setOrderLabel(String orderLabel) {
        this.orderLabel = orderLabel;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTransportCompanyLabel() {
        return transportCompanyLabel;
    }

    public void setTransportCompanyLabel(String transportCompanyLabel) {
        this.transportCompanyLabel = transportCompanyLabel;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany;
    }

    public String getFullNameLabel() {
        return fullNameLabel;
    }

    public void setFullNameLabel(String fullNameLabel) {
        this.fullNameLabel = fullNameLabel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOrderStatusLabel() {
        return orderStatusLabel;
    }

    public void setOrderStatusLabel(String orderStatusLabel) {
        this.orderStatusLabel = orderStatusLabel;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCourierDeliveryButton() {
        return courierDeliveryButton;
    }

    public void setCourierDeliveryButton(String courierDeliveryButton) {
        this.courierDeliveryButton = courierDeliveryButton;
    }

    public String getCourierReturnButton() {
        return courierReturnButton;
    }

    public void setCourierReturnButton(String courierReturnButton) {
        this.courierReturnButton = courierReturnButton;
    }

    public String getOrderDisbandmentButton() {
        return orderDisbandmentButton;
    }

    public void setOrderDisbandmentButton(String orderDisbandmentButton) {
        this.orderDisbandmentButton = orderDisbandmentButton;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderLabel() {
        return senderLabel;
    }

    public void setSenderLabel(String senderLabel) {
        this.senderLabel = senderLabel;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
