package ru.gloria_jeans.orders.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "warehouse_package")
public class OrderPackage {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "package_idd")
    private String packageIdd;

    @Column(name = "package_quantity")
    private BigDecimal packageQuantity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPackageIdd() {
        return packageIdd;
    }

    public void setPackageIdd(String packageIdd) {
        this.packageIdd = packageIdd;
    }

    public BigDecimal getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(BigDecimal packageQuantity) {
        this.packageQuantity = packageQuantity;
    }
}
