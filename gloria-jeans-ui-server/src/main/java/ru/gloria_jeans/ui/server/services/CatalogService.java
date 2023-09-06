package ru.gloria_jeans.ui.server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.catalog.models.request.SearchingProduct;
import ru.gloria_jeans.core.v1.catalog.models.response.CityBalance;
import ru.gloria_jeans.core.v1.catalog.models.response.ProductInformationListModel;
import ru.gloria_jeans.core.v1.catalog.models.response.ProductInformationModel;
import ru.gloria_jeans.core.v1.common.RestUtils;
import ru.gloria_jeans.ui.server.component.LocaleComponent;

import java.util.List;

@Service
public class CatalogService {
    public Logger logger = LoggerFactory.getLogger("CatalogService");
    private final String receivingUrl;
    private final RestUtils restUtils;
    private final LocaleComponent localeComponent;

    @Autowired
    public CatalogService(
            @Value("${services.catalog}") String receivingUrl,
            RestUtils restUtils,
            LocaleComponent localeComponent
    ) {
        this.restUtils = restUtils;
        this.receivingUrl = receivingUrl;
        this.localeComponent = localeComponent;
    }

    public ProductInformationListModel searchProduct(String barcode) throws Exception {
        ProductInformationListModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        receivingUrl,
                        "search/product"
                ),
                new SearchingProduct(barcode),
                ProductInformationListModel.class
        );

        if (response.getResponseException()) {
            logger.error(response.getResponseMessage());
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public List<ProductInformationModel> getProductByVendorCode(String vendorCode) throws Exception {
        ProductInformationListModel response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        receivingUrl,
                        "get",
                        vendorCode
                ), ProductInformationListModel.class);
        if (response.getResponseException()) {
            logger.error(response.getResponseMessage());
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response.getProductInformationModels();
    }

    public CityBalance getCityBalance(String selectedProductIdd) throws Exception {
        CityBalance response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        receivingUrl,
                        "city/balance",
                        selectedProductIdd
                ),
                CityBalance.class
        );

        if (response.getResponseException()) {
            logger.error(response.getResponseMessage());
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }
}
