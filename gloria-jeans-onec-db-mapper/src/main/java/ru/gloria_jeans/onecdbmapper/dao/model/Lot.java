package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "Справочник.СоставЛота")
public class Lot extends BaseCatalog {
    @Column(name = "PARENTEXT")
    private String parentExt;

    @Column(name = "Товар")
    private String product;

    @Column(name ="Количество")
    private Integer quantity;

    @Column(name = "IDD")
    private String idd;

    @OneToOne(optional = false)
    @JoinColumn(name = "Товар", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductInfo productInfo;

    @OneToOne(optional = false)
    @JoinColumn(name = "PARENTEXT", referencedColumnName = "ID", insertable = false, updatable = false)
    private ProductInfo parentProduct;

    public String getParentExt() {
        return parentExt;
    }

    public void setParentExt(String parentExt) {
        this.parentExt = parentExt;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public ProductInfo getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(ProductInfo parentProduct) {
        this.parentProduct = parentProduct;
    }
}
