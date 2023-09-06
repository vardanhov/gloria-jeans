package ru.gloria_jeans.core.v1.catalog.models.response;

public class ShopQuantity {
    private String shopName;
    private Integer quantity;

    public ShopQuantity() {
    }

    public ShopQuantity(String shopName, Integer quantity) {
        this.shopName = shopName;
        this.quantity = quantity;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
