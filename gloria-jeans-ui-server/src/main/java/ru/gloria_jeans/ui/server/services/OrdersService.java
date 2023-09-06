package ru.gloria_jeans.ui.server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.common.RestUtils;
import ru.gloria_jeans.core.v1.orders.enums.OrderStatus;
import ru.gloria_jeans.core.v1.orders.enums.OrderType;
import ru.gloria_jeans.core.v1.orders.enums.ReasonAbsence;
import ru.gloria_jeans.core.v1.orders.model.request.*;
import ru.gloria_jeans.core.v1.orders.model.response.*;
import ru.gloria_jeans.core.v1.receiving.models.response.EmployeeListModel;
import ru.gloria_jeans.ui.server.component.LocaleComponent;

import java.util.List;
import java.util.Objects;

@Service
public class OrdersService {
    public Logger logger = LoggerFactory.getLogger("OrdersService");
    private final String ordersUrl;
    private final RestUtils restUtils;
    private final LocaleComponent localeComponent;

    @Autowired
    public OrdersService(
            @Value("${services.orders}") String ordersUrl,
            RestUtils restUtils,
            LocaleComponent localeComponent
    ) {
        this.restUtils = restUtils;
        this.ordersUrl = ordersUrl;
        this.localeComponent = localeComponent;
    }

    public List<OrderModel> getOrders() throws Exception {
        OrderListModel response = restUtils.get(
                String.format(
                        "%s/%s",
                        ordersUrl,
                        "collect/orders"
                ),
                OrderListModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response.getOrderModels();
    }

    public List<ScannedDocumentModel> getOrdersForDelivery(String tk) throws Exception {
        ScannedDocumentListModel response = restUtils.get(String.format(
                "%s/%s?tk=%s",
                ordersUrl,
                "collect/orders/for/delivery",
                tk
        ), ScannedDocumentListModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response.getScannedDocumentModels();
    }

    public OrderDocumentModel getOrderDocument(String documentNumber, String userId, Boolean updateUserId) throws Exception {
        OrderDocumentModel response = restUtils.get(String.format(
                "%s/%s/%s?userId=%s&updateUserId=%s",
                ordersUrl,
                "content/order",
                documentNumber,
                userId,
                updateUserId), OrderDocumentModel.class);
        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderModel findOrderByOrderNumber(String orderNumber) throws Exception {
        OrderModel response = restUtils.get(String.format(
                "%s/%s/%s",
                ordersUrl,
                "find/order",
                orderNumber), OrderModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public EmployeeListModel getEmployeeList() throws Exception {
        EmployeeListModel response = restUtils.get(String.format(
                "%s/%s",
                ordersUrl,
                "/employees/list"
        ), EmployeeListModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderDocumentModel acceptanceOrderItem(
            String orderNumber,
            String handleSearch,
            String scannedSearch,
            String currentItemOrder
    ) throws Exception {
        OrderDocumentModel response = restUtils.post(String.format(
                        "%s/%s",
                        ordersUrl,
                        "/acceptance/item"
                ), new AcceptanceOrderItem(orderNumber, handleSearch, scannedSearch, currentItemOrder),
                OrderDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderDocumentModel clearFactPosition(
            String orderItemId
    ) throws Exception {
        OrderDocumentModel response = restUtils.post(String.format(
                        "%s/%s",
                        ordersUrl,
                        "/clear/fact_position"
                ), orderItemId,
                OrderDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderDocumentItemModel getOrderProductModel(String orderItemId) throws Exception {
        OrderDocumentItemModel response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        ordersUrl,
                        "get/order/model",
                        orderItemId
                ),
                OrderDocumentItemModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderDocumentItemModel updateOrderItem(String orderItemId, String quantityFact) throws Exception {
        OrderDocumentItemModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        ordersUrl,
                        "order/item/update"
                ),
                new UpdateOrderItem(orderItemId, quantityFact),
                OrderDocumentItemModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public ReturnOrderDocumentListModel orderReturn(String handleSearch, String scannedSearch) throws Exception {
        ReturnOrderDocumentListModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        ordersUrl,
                        "/order/return"
                ),
                new OrderSearchModel(handleSearch, scannedSearch),
                ReturnOrderDocumentListModel.class
        );

        if (response.getResponseException()) {
            if (Objects.isNull(response.getExceptionParameters())) {
                throw new Exception(
                        localeComponent.locale(response.getResponseMessage())
                );
            } else {
                throw new Exception(
                        localeComponent.locale(response.getResponseMessage(), localeComponent.locale(response.getExceptionParameters()))
                );
            }
        }

        return response;
    }

    public OrderDisbandment orderDisbandment(String barcode) throws Exception {
        OrderDisbandment response = restUtils.post(String.format(
                        "%s/%s",
                        ordersUrl,
                        "/order/disbandment"
                ),
                new SearchingOrder(barcode),
                OrderDisbandment.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }

    public OrderDocumentModel deleteOrderItem(String orderItemId) throws Exception {
        OrderDocumentModel response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        ordersUrl,
                        "orderItem/delete",
                        orderItemId
                ),
                OrderDocumentModel.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderDocumentAcceptance confirmationDocument(String documentNumber, String collectorFullName, String orderDateFormat) throws Exception {
        OrderDocumentAcceptance response = restUtils.post(String.format(
                        "%s/%s",
                        ordersUrl,
                        "document/confirmation"
                ),
                new ConfirmationDocumentModel(
                        documentNumber,
                        collectorFullName,
                        orderDateFormat
                ),
                OrderDocumentAcceptance.class);
        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }

    public OrderAcceptanceDeliveryDocument confirmationDeliveryDocument(
            String handleSearch,
            String scannedSearch
    ) throws Exception {
        OrderAcceptanceDeliveryDocument response = restUtils.post(String.format(
                        "%s/%s",
                        ordersUrl,
                        "document/confirmation/delivery"
                ), new AcceptanceDeliveryDocument(handleSearch, scannedSearch),
                OrderAcceptanceDeliveryDocument.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderFinishIssuingOrders finishIssuingOrders(String tk) throws Exception {
        OrderFinishIssuingOrders response = restUtils.post(String.format(
                        "%s/%s?tk=%s",
                        ordersUrl,
                        "finish/issuing/orders",
                        tk
                ), new OrderFinishIssuingOrders(),
                OrderFinishIssuingOrders.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderDocumentInformationModel getOrderDocument(String barcode,
                                               String dateFrom,
                                               String dateTo,
                                               List<OrderStatus> selectedOrderStatus,
                                               List<OrderType> selectedOrderType
    ) throws Exception {
        OrderDocumentInformationModel response = restUtils.post(String.format(
                        "%s/%s",
                        ordersUrl,
                        "/order/search"
                ),
                new SearchingOrder(
                        barcode.trim(),
                        dateFrom,
                        dateTo,
                        selectedOrderType,
                        selectedOrderStatus
                ),
                OrderDocumentInformationModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }


    public void orderReturnComplete() throws Exception {
        BaseResponse response = restUtils.post(
                String.format(
                        "%s/%s",
                        ordersUrl,
                        "/order/return/complete"
                ),
                null,
                BaseResponse.class
        );

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
    }

    public OrderPackageModel getPackage(String documentNumber) throws Exception {
        var t = documentNumber;
        OrderPackageModel response = restUtils.get(
                String.format(
                        "%s/%s/%s",
                        ordersUrl,
                        "finish/issuing/orders/get/package",
                        documentNumber

                ),
                OrderPackageModel.class
        );
        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }

        return response;
    }

    public OrderPackageModel savePackages(OrderPackageModel orderPackageModel, String orderNumber) throws Exception {
        OrderPackageModel response = restUtils.post(String.format(
                        "%s/%s/%s",
                        ordersUrl,
                        "finish/issuing/orders/save/package",
                        orderNumber
                ),
                orderPackageModel,
                OrderPackageModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }

    public OrderViewPositionModel getOrderViewPosition(String itemId, String documentIdd) throws Exception {
        OrderViewPositionModel response = restUtils.post(
                String.format(
                        "%s/%s",
                        ordersUrl,
                        "/order/item/view"
                ),
                new ViewPositionModel(itemId, documentIdd),
                OrderViewPositionModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }

    public void reasonAbsence(String orderIdd, String orderItemId, ReasonAbsence reason) throws Exception {
        OrderPackageModel response = restUtils.get(String.format(
                        "%s/%s/%s/%s/%s",
                        ordersUrl,
                        "reason/absence",
                        orderIdd,
                        orderItemId,
                        reason
                ),
                OrderPackageModel.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
    }

    public CheckAcceptanceDocument checkAcceptanceDocument(String documentNumber) throws Exception {
        CheckAcceptanceDocument response = restUtils.post(
                String.format(
                        "%s/%s",
                        ordersUrl,
                        "/order/acceptance/check"
                ),
                new CheckAcceptanceDocument(documentNumber),
                CheckAcceptanceDocument.class);

        if (response.getResponseException()) {
            throw new Exception(localeComponent.locale(response.getResponseMessage()));
        }
        return response;
    }
    public void setStatusNew(String documentIdd){
        restUtils.get(
                String.format(
                        "%s/%s/%s",
                        ordersUrl,
                        "/order/status",
                        documentIdd
                ),
        Object.class);
    }
}
