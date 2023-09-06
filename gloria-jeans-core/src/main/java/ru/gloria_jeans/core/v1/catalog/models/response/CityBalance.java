package ru.gloria_jeans.core.v1.catalog.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class CityBalance extends BaseResponse {
    private String productName;
    private List<ShopQuantity> shopQuantities;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ShopQuantity> getShopQuantities() {
        return shopQuantities;
    }

    public void setShopQuantities(List<ShopQuantity> shopQuantities) {
        this.shopQuantities = shopQuantities;
    }
}
