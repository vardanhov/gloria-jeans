package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.ЧекККМ")
public class ReceiptItem implements Serializable {

    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "ШтрихКод")
    private String barcode;

    @Column(name = "Номенклатура")
    private String item;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "Единица")
    private String unit;

    @Column(name = "Коэффициент")
    private BigDecimal coefficient;

    @Column(name = "Цена")
    private BigDecimal price;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "ПроцентСкидки")
    private BigDecimal percentageDiscount;

    @Column(name = "СуммаСкидки")
    private BigDecimal discountAmount;

    @Column(name = "КодСкидки")
    private BigDecimal discountCode;

    @Column(name = "НДС")
    private BigDecimal nds;

    @Column(name = "ЦенаСоСкидкой")
    private BigDecimal discountPrice;

    @Column(name = "СписокМарок")
    private String listMarks;

    @Column(name = "ТипЦены")
    private String priceType;

    public IddocLinenumberIdentity getIddocLinenumberIdentity() {
        return iddocLinenumberIdentity;
    }

    public void setIddocLinenumberIdentity(IddocLinenumberIdentity iddocLinenumberIdentity) {
        this.iddocLinenumberIdentity = iddocLinenumberIdentity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
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

    public BigDecimal getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(BigDecimal percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(BigDecimal discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getNds() {
        return nds;
    }

    public void setNds(BigDecimal nds) {
        this.nds = nds;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getListMarks() {
        return listMarks;
    }

    public void setListMarks(String listMarks) {
        this.listMarks = listMarks;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
}