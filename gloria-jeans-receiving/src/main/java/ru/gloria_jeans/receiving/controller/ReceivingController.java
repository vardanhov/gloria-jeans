package ru.gloria_jeans.receiving.controller;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.receiving.models.request.*;
import ru.gloria_jeans.core.v1.receiving.models.response.*;
import ru.gloria_jeans.receiving.services.ReceivingService;

import java.util.List;

@RestController
@RequestMapping("/receiving")
public class ReceivingController {
    public Logger logger = LoggerFactory.getLogger("ReceivingController");
    private final ReceivingService receivingService;

    @Autowired
    public ReceivingController(ReceivingService receivingService) {
        this.receivingService = receivingService;
    }

    @RequestMapping(
            path = "/document/{idd}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public ViewDocumentModel getDocument(
            @PathVariable String idd
    ) {
        ViewDocumentModel response = new ViewDocumentModel();

        try {
            response = receivingService.getDocument(idd);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getDocument", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }
        
        return response;
    }

    @RequestMapping(
            path = "/document/search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public DocumentResultSearchListModel searchDocument(
            @RequestBody SearchingDocuments searchingDocuments
    ) {
        DocumentResultSearchListModel response = new DocumentResultSearchListModel();

        try {
            response = receivingService.findDocuments(
                    searchingDocuments.getDocumentBarcode(),
                    searchingDocuments.getDateFrom(),
                    searchingDocuments.getDateTo(),
                    searchingDocuments.getSelectedStatuses()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("searchDocument", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/box/acceptance",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MovingDocumentModel acceptanceBox(
            @RequestBody AcceptanceBox acceptanceBox
    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.acceptanceBox(acceptanceBox.getBarcodeBox(), acceptanceBox.getIdd());
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("acceptanceBox", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/product/acceptance",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MovingDocumentModel acceptanceProduct(
            @RequestBody AcceptanceProduct acceptanceProduct
    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.acceptanceProduct(
                    acceptanceProduct.getDocumentIdd(),
                    acceptanceProduct.getBarcodeBox(),
                    acceptanceProduct.getHandleSearch(),
                    acceptanceProduct.getScannedSearch(),
                    acceptanceProduct.getNotCountQuantityLot(),
                    acceptanceProduct.getLineNumber()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("acceptanceProduct", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/lot/acceptance",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MovingDocumentModel acceptanceLot(
            @RequestBody AcceptanceLot acceptanceLot
    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.acceptanceProductIntoLot(
                    acceptanceLot.getDocumentIdd(),
                    acceptanceLot.getBarcodeBox(),
                    acceptanceLot.getIddLot(),
                    acceptanceLot.getHandleSearch(),
                    acceptanceLot.getScannedSearch(),
                    acceptanceLot.getLineNumberLot()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("acceptanceLot", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/discrepancy/confirm/{idd}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public ConfirmDiscrepancyModel confirmDiscrepancy(
            @PathVariable String idd
    ) {
        ConfirmDiscrepancyModel response = new ConfirmDiscrepancyModel();

        try {
            response = receivingService.confirmDiscrepancy(idd);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("confirmDiscrepancy", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/deliver/acceptance",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse confirmAcceptanceDelivery(
            @RequestBody AcceptanceDocument acceptanceDocument
    ) {
        BaseResponse response = new BaseResponse();

        try {
            List<String> iddocs = receivingService.confirmAcceptanceDelivery(
                    acceptanceDocument.getIdd(),
                    acceptanceDocument.getAcceptBy(),
                    acceptanceDocument.getCreatedBy(),
                    acceptanceDocument.getComment()
            );
            receivingService.movePeriods(iddocs);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("confirmAcceptanceDelivery", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
            receivingService.markJournalsAsDelete();
        }

        return response;
    }

    @RequestMapping(
            path = "/lot/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public ProductModel getLot(
            @PathVariable String id
    ) {
        ProductModel response = new ProductModel();

        try {
            response = receivingService.getOpenLot(id);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getLot", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @Operation(
            description = "Обновить статус лота в приемке",
            externalDocs = @ExternalDocumentation(description = "Ссылка на документацию в Конфлюенсе",url = "https://confluence.gloria-jeans.ru/pages/viewpage.action?pageId=3572354")
    )
    @RequestMapping(
            path = "/product_lot/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MovingDocumentModel updateLot(
            @RequestBody UpdateProductOrLot updateProductOrLot
    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.updateProductOrLot(
                    updateProductOrLot.getLotId(),
                    updateProductOrLot.getId(),
                    updateProductOrLot.getQuantityFact(),
                    updateProductOrLot.getLineNumberLot()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("updateLot", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/product_lot/clear_fact_all",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MovingDocumentModel clearFactAllProductsOrLots(
            @RequestBody ClearFactAllProductsOrLots clearFactAllProductsOrLots
    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.clearFactAllProductsOrLotsByBox(
                    clearFactAllProductsOrLots.getBarcodeBox(),
                    clearFactAllProductsOrLots.getLotId(),
                    clearFactAllProductsOrLots.getLineNumberLot());
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("updateLot", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/lot/delete/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public MovingDocumentModel deleteLot(
            @PathVariable String id

    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.deleteOpenLot(id);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("deleteLot", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/product/delete/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public MovingDocumentModel deleteProduct(
            @PathVariable String id
    ) {
        MovingDocumentModel response = new MovingDocumentModel();

        try {
            response = receivingService.deleteProductLotAndOpenLots(id);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("deleteProduct", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/product/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public ProductModel getProduct(
            @PathVariable String id
    ) {
        ProductModel response = new ProductModel();

        try {
            response = receivingService.getProduct(id);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getProduct", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/box/exist/{barcodeProduct}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public ExistBox existBox(
            @PathVariable String barcodeProduct
    ) {
        ExistBox response = new ExistBox();

        try {
            response.setExistBox(receivingService.existBox(barcodeProduct));
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("existBox", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/employees/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public EmployeeListModel getListEmployee() {
        EmployeeListModel response = new EmployeeListModel();

        try {
            response.setEmployeeModels(receivingService.getEmployees());
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("existBox", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }
}
