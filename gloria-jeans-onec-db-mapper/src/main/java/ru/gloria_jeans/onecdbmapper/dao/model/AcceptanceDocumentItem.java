package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ДокументСтроки.ПриемныйАкт")
public class AcceptanceDocumentItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "Номенклатура")
    private String item;

    @Column(name = "КоличествоДок")
    private BigDecimal quantityDoc;

    @Column(name = "КоличествоФакт")
    private BigDecimal factQuantity;

    @Column(name = "Цена")
    private BigDecimal price;

    @Column(name = "ШтрихКоробки")
    private String barcodeBox;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "СписокМарок")
    private String marks;

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

    public void setItem(String article) {
        this.item = article;
    }

    public BigDecimal getQuantityDoc() {
        return quantityDoc;
    }

    public void setQuantityDoc(BigDecimal quantityDoc) {
        this.quantityDoc = quantityDoc;
    }

    public BigDecimal getFactQuantity() {
        return factQuantity;
    }

    public void setFactQuantity(BigDecimal factQuantity) {
        this.factQuantity = factQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
}
