package ru.gloria_jeans.ui.server.services;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.common.RestUtils;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentStatus;
import ru.gloria_jeans.core.v1.receiving.models.request.*;
import ru.gloria_jeans.core.v1.receiving.models.response.*;
import ru.gloria_jeans.ui.server.component.LocaleComponent;

import java.util.List;
import java.util.Objects;

@Service
public class ReceivingService {
    public Logger logger = LoggerFactory.getLogger("ReceivingService");
    private final String receivingUrl;
    private final RestUtils restUtils;
    private final LocaleComponent localeComponent;

    @Autowired
    public ReceivingService(
            @Value("${services.receiving}") String receivingUrl,
            RestUtils restUtils,
            LocaleComponent localeComponent
    ) {
        this.restUtils = restUtils;
        this.receivingUrl = receivingUrl;
        this.localeComponent = localeComponent;
    }

    public ViewDocumentModel getDocument(String idd) throws Exception {
        ViewDocumentModel response = restUtils.get(
                String.format("%s/%s/%s", receivingUrl, "document", idd),
                ViewDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public List<DocumentResultSearchModel> findDocuments(
            String documentBarcode,
            String dateFrom,
            String dateTo,
            List<MovingDocumentStatus> statuses
    ) throws Exception {
        DocumentResultSearchListModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        receivingUrl,
                        "document/search"
                ),
                new SearchingDocuments(documentBarcode.replace("\n", ""), dateFrom, dateTo, statuses),
                DocumentResultSearchListModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response.getDocumentResultSearchModels();
    }

    public MovingDocumentModel acceptanceBox(String barcodeBox, String idd) throws Exception {
        MovingDocumentModel response = restUtils.post(
                String.format("%s/%s", receivingUrl, "box/acceptance"),
                new AcceptanceBox(barcodeBox.replace("\n", ""), idd),
                MovingDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public MovingDocumentModel acceptanceProduct(
            String documentIdd,
            String barcodeBox,
            String handleSearch,
            String scannedSearch,
            Boolean notCountQuantityLot,
            Integer lineNumber
    ) throws Exception {
        if (Objects.nonNull(handleSearch)) {
            handleSearch = handleSearch.replace("\n", "").toUpperCase();
        }

        if (Objects.nonNull(scannedSearch)) {
            scannedSearch = scannedSearch.toUpperCase();
        }

        MovingDocumentModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        receivingUrl,
                        "product/acceptance"
                ),
                new AcceptanceProduct(documentIdd, barcodeBox, handleSearch, scannedSearch, notCountQuantityLot, lineNumber),
                MovingDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public MovingDocumentModel acceptanceProductIntoLot(
            String documentIdd,
            String barcodeBox,
            String handleSearch,
            String scannedSearch,
            String lotIdd,
            String lineNumberLot
    ) throws Exception {
        if (Objects.nonNull(handleSearch)) {
            handleSearch = handleSearch.replace("\n", "").toUpperCase();
        }

        if (Objects.nonNull(scannedSearch)) {
            scannedSearch = scannedSearch.toUpperCase();
        }

        MovingDocumentModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        receivingUrl,
                        "lot/acceptance"
                ),
                new AcceptanceLot(documentIdd, barcodeBox, handleSearch, scannedSearch, lotIdd, lineNumberLot),
                MovingDocumentModel.class
        );


        if (response.getResponseException() && response.getResponseMessage().equals("warehouse.supply.search.goods.open.lot.error")) {
            throw new Exception(response.getResponseMessage());
        } else if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public ConfirmDiscrepancyModel confirmDiscrepancy(String idd) throws Exception {
        try {
            ConfirmDiscrepancyModel response = restUtils.get(
                    String.format("%s/%s/%s", receivingUrl, "discrepancy/confirm", idd),
                    ConfirmDiscrepancyModel.class
            );

            if (response.getResponseException()) {
                logger.error(response.getResponseMessage());
                throw new Exception(localeComponent.locale(response.getResponseMessage()));
            } else {
                return response;
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw new Exception(exception.getMessage());
        }
    }

    public void confirmAcceptanceDelivery(String idd, String acceptBy, String createdBy, String comment) throws Exception {
        try {
            BaseResponse response = restUtils.post(
                    String.format("%s/%s", receivingUrl, "deliver/acceptance"),
                    new AcceptanceDocument(idd, acceptBy, createdBy, comment),
                    ConfirmDiscrepancyModel.class
            );

            if (response.getResponseException()) {
                logger.error(response.getResponseMessage());
                throw new Exception(localeComponent.locale(response.getResponseMessage()));
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw new Exception(localeComponent.locale(exception.getMessage()));
        }
    }

    public MovingDocumentModel updateProductOrLot(String lotId, String id, String quantityFact, String lineNumberLot) throws Exception {
        MovingDocumentModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        receivingUrl,
                        "product_lot/update"
                ),
                new UpdateProductOrLot(lotId, id, quantityFact, lineNumberLot),
                MovingDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public MovingDocumentModel deleteProductOrLot(String lotId, String id) throws Exception {
        MovingDocumentModel response = null;
        if (!Strings.isNullOrEmpty(lotId))
            response = restUtils.get(
                    String.format(
                            "%s/%s/%s",
                            receivingUrl,
                            "lot/delete",
                            id
                    ),
                    MovingDocumentModel.class
            );
        else
            response = restUtils.get(
                    String.format(
                            "%s/%s/%s",
                            receivingUrl,
                            "product/delete",
                            id
                    ),
                    MovingDocumentModel.class
            );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public ProductModel getProduct(String id) throws Exception {
        ProductModel response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        receivingUrl,
                        "product",
                        id
                ),
                ProductModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public ProductModel getOpenLot(String id) throws Exception {
        ProductModel response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        receivingUrl,
                        "lot",
                        id
                ),
                ProductModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public boolean existBox(String barcodeProduct) throws Exception {
        ExistBox response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        receivingUrl,
                        "box/exist",
                        barcodeProduct
                ),
                ExistBox.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response.getExistBox();
    }

    public EmployeeListModel getEmployeeList() throws Exception {
        EmployeeListModel response = restUtils.get(String.format(
                "%s/%s",
                receivingUrl,
                "/employees/list"
        ), EmployeeListModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }

    public MovingDocumentModel clearFactAllProductsOrLots(String barcodeBox, String lotId, String lineNumberLot) throws Exception {
        MovingDocumentModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        receivingUrl,
                        "product_lot/clear_fact_all"
                ),
                new ClearFactAllProductsOrLots(barcodeBox, lotId, lineNumberLot),
                MovingDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(response.getResponseMessage());
        }

        return response;
    }
}
