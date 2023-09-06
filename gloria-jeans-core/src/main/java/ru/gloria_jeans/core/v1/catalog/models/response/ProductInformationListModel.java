package ru.gloria_jeans.core.v1.catalog.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class ProductInformationListModel extends BaseResponse {
    private List <ProductInformationModel> productInformationModels;

    public List<ProductInformationModel> getProductInformationModels() {
        return productInformationModels;
    }

    public void setProductInformationModels(List<ProductInformationModel> productInformationModels) {
        this.productInformationModels = productInformationModels;
    }
}
