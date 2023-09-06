package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.Возврат")
public class MovingDocumentItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;
    @Column(name = "Номенклатура")
    private String item;
    @Column(name = "Количество")
    private BigDecimal quantity;
    @Column(name = "НомерКоробки")
    private String boxNumber;
    @Column(name = "ПричинаВозврата")
    private String reasonReturn;
    @Column(name = "Единица")
    private String unit;
    @Column(name = "Коэффициент")
    private BigDecimal coefficient;
    @Column(name = "Цена")
    private BigDecimal price;
    @Column(name = "Сумма")
    private BigDecimal sum;
    @Column(name = "ШтрихКоробки")
    private String barcodeBox;
    @Column(name = "СписокМарок")
    private String listMarks;
    @Column(name = "БезМарки")
    private BigDecimal withoutMarks;

    @OneToOne(optional = false)
    @JoinColumn(name = "Номенклатура", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductInfo productInfo;

    public IddocLinenumberIdentity getIddocLinenumberIdentity() {
        return iddocLinenumberIdentity;
    }

    public void setIddocLinenumberIdentity(IddocLinenumberIdentity iddocLinenumberIdentity) {
        this.iddocLinenumberIdentity = iddocLinenumberIdentity;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
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

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getReasonReturn() {
        return reasonReturn;
    }

    public void setReasonReturn(String reasonReturn) {
        this.reasonReturn = reasonReturn;
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

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getListMarks() {
        return listMarks;
    }

    public void setListMarks(String listMarks) {
        this.listMarks = listMarks;
    }

    public BigDecimal getWithoutMarks() {
        return withoutMarks;
    }

    public void setWithoutMarks(BigDecimal withoutMarks) {
        this.withoutMarks = withoutMarks;
    }

    public ProductInfo getProduct() {
        return productInfo;
    }

    public void setProduct(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
