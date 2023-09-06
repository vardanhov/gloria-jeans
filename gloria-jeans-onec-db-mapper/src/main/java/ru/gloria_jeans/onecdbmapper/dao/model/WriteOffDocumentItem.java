package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.Списание")
public class WriteOffDocumentItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "Сотрудник")
    private String employee;

    @Column(name = "Товар")
    private String product;

    @Column(name = "Ед_изм")
    private String unit;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "Цена")
    private BigDecimal price;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @OneToOne(optional = false)
    @JoinColumn(name = "Товар", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductInfo productInfo;

    public IddocLinenumberIdentity getIddocLinenumberIdentity() {
        return iddocLinenumberIdentity;
    }

    public void setIddocLinenumberIdentity(IddocLinenumberIdentity iddocLinenumberIdentity) {
        this.iddocLinenumberIdentity = iddocLinenumberIdentity;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
