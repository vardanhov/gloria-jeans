package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.АктНесоответствия")
public class MismatchDocumentItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "Номенклатура")
    private String item;

    @Column(name = "РазницаКолво")
    private BigDecimal differenceCount;

    @Column(name = "Цена")
    private BigDecimal price;

    @Column(name = "РазницаСумма")
    private BigDecimal differenceSum;

    @Column(name = "Единица")
    private String unit;

    @Column(name = "ШтрихКоробки")
    private String barcodeBox;

    @Column(name = "СуммаНДС")
    private BigDecimal vatSum;

    @Column(name = "РассмотреноОтправителем")
    private String lookedRecipient;

    @Column(name = "Утверждено")
    private String approved;

    @Column(name = "СписокМарок")
    private String listMarks;

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

    public BigDecimal getDifferenceCount() {
        return differenceCount;
    }

    public void setDifferenceCount(BigDecimal differenceCount) {
        this.differenceCount = differenceCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDifferenceSum() {
        return differenceSum;
    }

    public void setDifferenceSum(BigDecimal differenceSum) {
        this.differenceSum = differenceSum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public BigDecimal getVatSum() {
        return vatSum;
    }

    public void setVatSum(BigDecimal vatSum) {
        this.vatSum = vatSum;
    }

    public String getLookedRecipient() {
        return lookedRecipient;
    }

    public void setLookedRecipient(String lookedRecipient) {
        this.lookedRecipient = lookedRecipient;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
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
}
