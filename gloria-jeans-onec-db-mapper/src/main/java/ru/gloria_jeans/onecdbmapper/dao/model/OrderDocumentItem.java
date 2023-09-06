package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.Заказ")
public class OrderDocumentItem implements Serializable {

    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "Номенклатура")
    private String item;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "КоличествоФакт")
    private BigDecimal quantityFact;

    @Column(name = "Цена")
    private BigDecimal price;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "СписокМарок")
    private String listMarks;

    @Column(name = "ТипЦены")
    private String priceType;

    @Column(name = "КодСкидки")
    private BigDecimal discountCode;

    @OneToOne(optional = false)
    @JoinColumn(name = "Номенклатура", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductInfo productInfo;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(BigDecimal quantityFact) {
        this.quantityFact = quantityFact;
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

    public String getListMarks() {
        return listMarks;
    }

    public void setListMarks(String listMarks) {
        this.listMarks = listMarks;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public BigDecimal getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(BigDecimal discountCode) {
        this.discountCode = discountCode;
    }
}
