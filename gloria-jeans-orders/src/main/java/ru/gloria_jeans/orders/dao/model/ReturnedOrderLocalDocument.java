package ru.gloria_jeans.orders.dao.model;

import ru.gloria_jeans.orders.dao.enums.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "warehouse_returned_orders")
public class ReturnedOrderLocalDocument {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "idd")
    private String idd;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "shipping_type")
    private String shippingType;

    @Column(name = "status_order")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus statusOrder;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "tk")
    private String tk;

    @Column(name = "buyer_name")
    private String buyer;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public OrderStatus getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(OrderStatus statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
