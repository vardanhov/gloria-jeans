package ru.gloria_jeans.orders.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.orders.enums.ReasonAbsence;
import ru.gloria_jeans.core.v1.orders.model.request.*;
import ru.gloria_jeans.core.v1.orders.model.response.*;
import ru.gloria_jeans.core.v1.receiving.models.response.EmployeeListModel;
import ru.gloria_jeans.orders.exception.ExceptionWithParameters;
import ru.gloria_jeans.orders.services.OrdersService;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    private static final Logger logger = LoggerFactory.getLogger(OrdersController.class.getSimpleName());
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(
            path = "/collect/orders",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderListModel getCollectOrders() {
        OrderListModel response = new OrderListModel();

        try {
            response = ordersService.getAllOrders();
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getCollectOrders", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/collect/orders/for/delivery",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ScannedDocumentListModel getCollectOrdersForDelivery(
            @RequestParam(required = false) String tk
    ) {
        ScannedDocumentListModel response = new ScannedDocumentListModel();

        try {
            response = ordersService.getOrdersForDelivery(tk);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getCollectOrders", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/content/order/{documentNumber}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public OrderDocumentModel getOrderDocument(
            @PathVariable String documentNumber,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "updateUserId", required = false) Boolean updateUserId
    ) {
        OrderDocumentModel response = new OrderDocumentModel();

        try {
            response = ordersService.getOrderDocument(documentNumber, userId, updateUserId);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getContentOrder", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/employees/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public EmployeeListModel getEmployeeList() {
        EmployeeListModel response = new EmployeeListModel();

        try {
            response.setEmployeeModels(ordersService.getListOfEmployees());
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getListOfEmployees", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/order/search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentModel searchOrder(
            @RequestBody SearchingOrder searchingOrder
    ) {
        OrderDocumentModel response = new OrderDocumentModel();

        try {
            response = ordersService.findOrder(
                    searchingOrder.getOrderBarcode()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("searchOrder", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/acceptance/item",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentModel acceptanceProduct(
            @RequestBody AcceptanceOrderItem acceptanceOrderItem
    ) {
        OrderDocumentModel response = new OrderDocumentModel();

        try {
            response = ordersService.acceptanceOrderItem(
                    acceptanceOrderItem.getOrderNumber(),
                    acceptanceOrderItem.getHandleSearch(),
                    acceptanceOrderItem.getScannedSearch(),
                    acceptanceOrderItem.getCurrentItemOrder()
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
            path = "/clear/fact_position",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentModel clearFactPosition(
            @RequestBody String orderItemId
    ) {
        OrderDocumentModel response = new OrderDocumentModel();

        try {
            response = ordersService.clearFactPosition(orderItemId
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("clearFactPosition", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "get/order/model/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentItemModel getProduct(
            @PathVariable String id
    ) {
        OrderDocumentItemModel response = new OrderDocumentItemModel();

        try {
            response = ordersService.getOrderProduct(id);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getProduct", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/order/item/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentItemModel updateOrderItem(
            @RequestBody UpdateOrderItem updateOrderItem
    ) {
        OrderDocumentItemModel response = new OrderDocumentItemModel();

        try {
            response = ordersService.updateOrderItem(
                    updateOrderItem.getOrderItemId(),
                    updateOrderItem.getQuantityFact()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("updateOrderItem", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/orderItem/delete/{orderItemId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentModel deleteProduct(
            @PathVariable String orderItemId
    ) {
        OrderDocumentModel response = new OrderDocumentModel();

        try {
            response = ordersService.deleteOrderItem(orderItemId);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("deleteProduct", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/document/confirmation",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDocumentAcceptance acceptanceDocument(
            @RequestBody ConfirmationDocumentModel confirmationDocumentModel
    ) {
        OrderDocumentAcceptance response = new OrderDocumentAcceptance();

        try {
            response = ordersService.confirmationDocument(
                    confirmationDocumentModel.getOrderNumber(),
                    confirmationDocumentModel.getCollectorFullName(),
                    confirmationDocumentModel.getOrderDateFormat());
            if (Objects.nonNull(response.getMovePeriodIdDocs())) {
                ordersService.movePeriods(response.getMovePeriodIdDocs());
            }
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("acceptanceDocument", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/order/disbandment",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderDisbandment orderDisbandment(
            @RequestBody SearchingOrder searchingOrder
    ) {
        OrderDisbandment response = new OrderDisbandment();

        try {
            response = ordersService.orderDisbandment(searchingOrder.getOrderBarcode());
            if (Objects.nonNull(response.getIdDoc())) {
                ordersService.movePeriods(response.getIdDoc());
            }
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("orderDisbandment", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/document/confirmation/delivery",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderAcceptanceDeliveryDocument acceptanceDeliveryDocument(
            @RequestBody AcceptanceDeliveryDocument acceptanceDeliveryDocument
    ) {
        OrderAcceptanceDeliveryDocument response = new OrderAcceptanceDeliveryDocument();

        try {
            response = ordersService.acceptanceDeliveryDocument(
                    acceptanceDeliveryDocument.getHandleSearch(),
                    acceptanceDeliveryDocument.getScannedSearch()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("confirmationDeliveryDocument", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/finish/issuing/orders",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderFinishIssuingOrders finishIssuingOrders(
            @RequestParam(required = false) String tk
    ) {
        OrderFinishIssuingOrders response = new OrderFinishIssuingOrders();

        try {
            response = ordersService.finishIssuingOrders(tk);
            if (Objects.nonNull(response.getOrdersIdDoc())) {
                ordersService.movePeriods(response.getOrdersIdDoc());
            }
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("finishIssuingOrders", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/order/return",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ReturnOrderDocumentListModel returnOrder(
            @RequestBody OrderSearchModel orderSearchModel
    ) {
        ReturnOrderDocumentListModel response = new ReturnOrderDocumentListModel();

        try {
            response.setOrderModels(
                    ordersService.returnOrder(
                            orderSearchModel.getHandleSearch(),
                            orderSearchModel.getScannedSearch()
                    )
            );
            response.setResponseException(false);
        } catch (ExceptionWithParameters exception) {
            logger.error("returnOrder", exception);
            response.setResponseMessage(exception.getMessage());
            response.setExceptionParameters(exception.getParameters());
            response.setResponseException(true);
        } catch (Exception exception) {
            logger.error("returnOrder", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/order/return/complete",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponse returnOrderComplete() {
        BaseResponse response = new BaseResponse();

        try {
            List<String> idDocs = ordersService.returnOrderComplete();
            if (Objects.nonNull(idDocs)) {
                ordersService.movePeriods(idDocs);
            }
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("returnOrder", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/finish/issuing/orders/get/package/{orderNumber}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderPackageModel getPackage(
            @PathVariable String orderNumber
    ) {
        OrderPackageModel response = new OrderPackageModel();

        try {
            response = ordersService.getOrderPackagesCount(orderNumber);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getPackage", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }
        return response;
    }

    @RequestMapping(
            path = "/finish/issuing/orders/save/package/{orderNumber}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderPackageModel savePackage(
            @RequestBody OrderPackageModel orderPackages

    ) {
        OrderPackageModel response = new OrderPackageModel();

        try {
            response = ordersService.changePackages(orderPackages);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("savePackage", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }
        return response;
    }

    @RequestMapping(
            path = "/reason/absence/{documentIdd}/{orderItemId}/{reason}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public BaseResponse reasonAbsence(
            @PathVariable String documentIdd,
            @PathVariable String orderItemId,
            @PathVariable ReasonAbsence reason
    ) {
        OrderPackageModel response = new OrderPackageModel();

        try {
            ordersService.reasonAbsence(documentIdd, orderItemId, reason);
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("reasonAbsence", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }

        return response;
    }

    @RequestMapping(
            path = "/order/item/view",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public OrderViewPositionModel getOrderViewPosition(
            @RequestBody ViewPositionModel viewPosition
    ) {
        OrderViewPositionModel response = new OrderViewPositionModel();

        try {
            response = ordersService.getOrderViewPosition(
                    viewPosition.getOrderId(),
                    viewPosition.getDocumentIdd()
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("getOrderViewPosition", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }
        return response;
    }

    @RequestMapping(
            path = "/order/acceptance/check",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CheckAcceptanceDocument checkAcceptanceDocument(
            @RequestBody CheckAcceptanceDocument checkAcceptanceDocument
    ) {
        CheckAcceptanceDocument response = new CheckAcceptanceDocument();

        try {
            response = ordersService.checkAcceptanceDocument(
                    checkAcceptanceDocument
            );
            response.setResponseException(false);
        } catch (Exception exception) {
            logger.error("checkAcceptanceDocument", exception);
            response.setResponseMessage(exception.getMessage());
            response.setResponseException(true);
        }
        return response;
    }
}
