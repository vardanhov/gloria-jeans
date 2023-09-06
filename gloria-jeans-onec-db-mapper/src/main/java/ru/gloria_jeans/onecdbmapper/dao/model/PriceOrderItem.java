package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name ="ДокументСтроки.ПриказПоЦенам")
public class PriceOrderItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "Товар")
    private String item;

    @Column(name = "ПродЦена")
    private BigDecimal priceProduction;

    @Column(name = "УчЦена")
    private BigDecimal priceDiscount;

    @Column(name = "Скидка")
    private BigDecimal discount;

    @ManyToOne()
    @JoinColumn(name = "Товар", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductInfo productInfo;

    @ManyToOne()
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private PriceOrder priceOrder;

    public IddocLinenumberIdentity getIddocLinenumberIdentity() {
        return iddocLinenumberIdentity;
    }

    public void setIddocLinenumberIdentity(IddocLinenumberIdentity iddocLinenumberIdentity) {
        this.iddocLinenumberIdentity = iddocLinenumberIdentity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getPriceProduction() {
        return priceProduction;
    }

    public void setPriceProduction(BigDecimal priceProduction) {
        this.priceProduction = priceProduction;
    }

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(BigDecimal priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public PriceOrder getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(PriceOrder priceOrder) {
        this.priceOrder = priceOrder;
    }
}
