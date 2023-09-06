package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.orders.enums.OrderType;

import java.util.Date;

public class OrderModel extends BaseResponse {
    private String orderNumber;
    private OrderType shippingType;
    private Date orderDate;
    private String transportCompany;
    private String customerFullName;
    private String orderStatus;
    private String shippingMethod;

    public OrderModel() {
    }

    public OrderModel(String orderNumber, OrderType shippingType, Date orderDate, String transportCompany, String customerFullName, String orderStatus, String shippingMethod) {
        this.orderNumber = orderNumber;
        this.shippingType = shippingType;
        this.orderDate = orderDate;
        this.transportCompany = transportCompany;
        this.customerFullName = customerFullName;
        this.orderStatus = orderStatus;
        this.shippingMethod = shippingMethod;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getShippingType() {
        return shippingType;
    }

    public void setShippingType(OrderType shippingType) {
        this.shippingType = shippingType;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
