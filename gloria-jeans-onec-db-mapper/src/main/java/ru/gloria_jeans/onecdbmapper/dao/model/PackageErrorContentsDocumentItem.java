package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.ОшибкиКомплектации")
public class PackageErrorContentsDocumentItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "Номенклатура")
    private String item;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "Единица")
    private String unit;

    @Column(name = "Цена")
    private BigDecimal price;

    @Column(name = "Коэффициент")
    private BigDecimal coefficient;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "СтавкаНДС")
    private BigDecimal vatRate;

    @Column(name = "НДС")
    private BigDecimal vat;

    @Column(name = "Всего")
    private BigDecimal total;

    @Column(name = "Должно")
    private BigDecimal must;

    @Column(name = "МаркиСтрока")
    private String marks;

    @Column(name = "ШКЛота")
    private String barcodeLot;

    @Column(name = "ШтрихКоробки")
    private String barcodeBox;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMust() {
        return must;
    }

    public void setMust(BigDecimal must) {
        this.must = must;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getBarcodeLot() {
        return barcodeLot;
    }

    public void setBarcodeLot(String barcodeLot) {
        this.barcodeLot = barcodeLot;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
