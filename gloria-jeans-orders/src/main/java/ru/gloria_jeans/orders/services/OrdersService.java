package ru.gloria_jeans.orders.services;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.core.v1.marks.services.MarksService;
import ru.gloria_jeans.core.v1.orders.enums.*;
import ru.gloria_jeans.core.v1.orders.model.response.*;
import ru.gloria_jeans.core.v1.receiving.models.response.EmployeeModel;
import ru.gloria_jeans.core.v1.utils.BarcodeHelper;
import ru.gloria_jeans.onecdbmapper.dao.component.CurrencyComponent;
import ru.gloria_jeans.onecdbmapper.dao.component.JournalComponent;
import ru.gloria_jeans.onecdbmapper.dao.component.OnecSystemComponent;
import ru.gloria_jeans.onecdbmapper.dao.enums.ProductType;
import ru.gloria_jeans.onecdbmapper.dao.enums.ShippingMethod;
import ru.gloria_jeans.onecdbmapper.dao.model.Currency;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.orders.dao.enums.OrderStatus;
import ru.gloria_jeans.orders.dao.mapper.*;
import ru.gloria_jeans.orders.dao.model.*;
import ru.gloria_jeans.orders.exception.ExceptionWithParameters;
import ru.gloria_jeans.orders.utils.OrderNumberHelper;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    public Logger logger = LoggerFactory.getLogger("OrdersService");
    private final String serverMarksUrl;
    private final String serverMarksAuthorizationUrl;
    private final String username;
    private final String password;
    private final OnecService onecService;
    private final DatabaseService databaseService;
    private final MarksService marksService;
    private final IddGeneratingService iddGeneratingService;
    private final JournalComponent journalComponent;
    private final OnecSystemComponent onecSystemComponent;
    private final CurrencyComponent currencyComponent;
    private final PrintService printService;

    @Autowired
    public OrdersService(
            @Value("${marks.server.url}") String serverMarksUrl,
            @Value("${marks.server.authorization.url}") String serverMarksAuthorizationUrl,
            @Value("${marks.server.authorization.username}") String username,
            @Value("${marks.server.authorization.password}") String password,
            OnecService onecService,
            DatabaseService databaseService,
            MarksService marksService,
            IddGeneratingService iddGeneratingService,
            JournalComponent journalComponent,
            OnecSystemComponent onecSystemComponent,
            CurrencyComponent currencyComponent,
            PrintService printService
    ) {
        this.serverMarksUrl = serverMarksUrl;
        this.serverMarksAuthorizationUrl = serverMarksAuthorizationUrl;
        this.username = username;
        this.password = password;
        this.onecService = onecService;
        this.databaseService = databaseService;
        this.marksService = marksService;
        this.iddGeneratingService = iddGeneratingService;
        this.journalComponent = journalComponent;
        this.onecSystemComponent = onecSystemComponent;
        this.currencyComponent = currencyComponent;
        this.printService = printService;
    }

    @Transactional
    public OrderListModel getAllOrders() throws Exception {
        logger.info("Getting all orders");
        OrderListModel orderListModel = new OrderListModel();
        List<OrderDocument> orders = onecService.getOrdersByShippingMethodAndStatusOrderNotIn(
                Arrays.asList(
                        ShippingMethod.SHIP_FROM_STORE.getValue(),
                        ShippingMethod.RESERVE.getValue()
                ),
                Arrays.asList(
                        OrderStatus.TO_DISBANDED.getOnecId(),
                        OrderStatus.READY_FOR_DELIVERY.getOnecId(),
                        OrderStatus.FITTING.getOnecId()
                )
        );
        OrderLocalDocument document;
        List<OrderModel> orderModels = new ArrayList<>();

        if (orders.size() > 0) {
            for (OrderDocument orderDocument : orders) {
                document = databaseService.findOrderDocumentByOrderNumber(orderDocument.getOrderNumber());
                orderModels.add(
                        OrderModelMapper.map(
                                orderDocument,
                                Objects.nonNull(document) ? document.getStatusOrder().getLocale() : getStatusFrom1c(orderDocument).getLocale()
                        )
                );
            }

            orderListModel.setOrderModels(orderModels);
        } else {
            logger.info("Order documents not found");
            throw new Exception("warehouse.internet.order.document.status.delivery.order.not_found_all_orders");
        }

        logger.info("Found: '{}' order documents", orders.size());
        return orderListModel;
    }


    public ScannedDocumentListModel getOrdersForDelivery(String tk) throws Exception {
        logger.info("Getting orders for delivery");
        ScannedDocumentListModel scannedDocumentListModel = new ScannedDocumentListModel();
        List<OrderLocalDocument> orders;
        Set<ScannedDocumentModel> scannedDocuments;
        if (!Strings.isNullOrEmpty(tk)) {
            orders = databaseService.getOrdersForDeliveryByStatusOrderAndTk(OrderStatus.READY_FOR_DELIVERY, tk)
                    .parallelStream()
                    .filter(e -> ShippingMethod.getName(e.getShippingMethod()).equals(ShippingMethod.SHIP_FROM_STORE.getName()))
                    .collect(Collectors.toList());
            logger.info("Found: '{}' order documents by tk - '{}'", orders.size(), tk);
            scannedDocuments = databaseService.findAllScannedDocumentsInStatusAndTk(ScannedDocumentStatus.SCANNED.getValue(), tk).parallelStream()
                    .map(ScannedDocumentModelMapper::map)
                    .collect(Collectors.toSet());
        } else {
            logger.error("Transport company is empty");
            throw new Exception("warehouse.internet.order.courier.delivery.tk.error");
        }

        logger.info("Found: '{}' scanned documents by status scanned", scannedDocuments.size());

        if (orders.size() > 0) {
            for (OrderLocalDocument orderDocument : orders) {
                if (Objects.isNull(onecService.getReceiptByDocBasis(orderDocument.getIddocdef(), orderDocument.getIdDoc())) && Objects.isNull(databaseService.findScannedDocumentByOrderNumber(orderDocument.getOrderNumber()))) {
                    scannedDocuments.add(ScannedDocumentModelMapper.map(orderDocument));
                }
            }
        }

        if (scannedDocuments.size() == 0) {
            logger.info("Not found documents for view in list");
            throw new Exception("warehouse.internet.order.courier.delivery.not.found.documents");
        }

        List<ScannedDocumentModel> scannedDocumentModels = new ArrayList<>(scannedDocuments);
        scannedDocumentModels.sort(Comparator.comparing(ScannedDocumentModel::getOrderStatus));
        scannedDocumentListModel.setScannedDocumentModels(scannedDocumentModels);
        return scannedDocumentListModel;
    }

    @Transactional
    public OrderDocumentModel getOrderDocument(String orderNumber, String userId, Boolean updateUserId) throws Exception {
        OrderLocalDocument document;
        OrderDocument orderDocument;
        List<OrderItem> orderItems;
        OrderDocumentModel orderDocumentModel;
        document = databaseService.findOrderDocumentByOrderNumber(orderNumber);
        orderDocument = onecService.getOrderDocumentByOrderNumber(orderNumber);

        if (Objects.isNull(orderDocument)) {
            logger.info("Document not found in oneC db");
            throw new Exception("warehouse.internet.order.document.status.delivery.order.not_found");
        } else {
            orderDocumentModel = OrderDocumentModelMapper.map(orderDocument);
        }

        if (Objects.isNull(document)) {
            logger.info("Document with orderNumber: '{}' not found in localBase", orderNumber);
            String firm = onecService.getFirmByWarehouse(orderDocument.getWarehouse()).getId();

            if (Objects.isNull(firm)) {
                logger.info("Firm not found in OneC");
                throw new Exception("product.firm.not.found");
            }

            databaseService.addDocument(DocumentMapper.map(orderDocument, userId, firm, OrderStatus.IN_WORK));
            logger.info("Document with orderNumber: '{}' and currentUserId: '{}' created", orderNumber, userId);
        } else {
            List<OrderItem> orderItemsForUpdateDocument = databaseService.getOrderItemsByIdDoc(document.getIdDoc());
            document.setQuantityFact(
                    BigDecimal.valueOf(orderItemsForUpdateDocument.parallelStream()
                            .mapToInt(OrderItem::getQuantityFact)
                            .sum())
            );
            document.setSum(
                    orderItemsForUpdateDocument.parallelStream()
                            .map(OrderItem::getSum)
                            .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            logger.info("Document: '{}' updated with quantityFact: '{}' and sum: '{}' with userId: '{}'",
                    orderNumber,
                    document.getQuantityFact(),
                    document.getSum(),
                    document.getCurrentUserId());

            if (Strings.isNullOrEmpty(userId)) {
                logger.info("Not get current userId from device. UserId value: '{}'. Now set default value 'emptyUserId'", userId);
                userId = "emptyUserId";
            }

            if (!updateUserId && !Strings.isNullOrEmpty(document.getCurrentUserId())) {
                if (!document.getCurrentUserId().equals(userId)) {
                    orderDocumentModel.setCurrentUserId(userId);
                    logger.info("UserId who use document: '{}' not equals currentUserId: '{}'", document.getCurrentUserId(), userId);
                    return orderDocumentModel;
                } else {
                    logger.info("UserId in document equals currentUserId");
                }
            } else {
                document.setCurrentUserId(userId);
                logger.info("UserId: '{}' updated in document", userId);
            }
        }

        String documentIdDoc = orderDocument.getIdDoc();
        orderItems = databaseService.getOrderItemsByIdDoc(documentIdDoc);
        String documentIdd = databaseService.findOrderDocumentByOrderNumber(orderNumber).getIdd();

        if (orderItems.size() == 0) {
            orderItems = orderDocument.getItems()
                    .parallelStream()
                    .map(e -> OrderItemMapper.map(e, documentIdd)).collect(Collectors.toList());
            databaseService.saveOrderItemsList(orderItems);
        }

        var items = orderItems
                .parallelStream()
                .map(OrderProductModelMapper::map)
                .sorted(Comparator.comparing(OrderDocumentItemModel::getId))
                .collect(Collectors.toList());

        orderDocumentModel.setOrderDocumentItemModels(items);

        return orderDocumentModel;
    }

    @Transactional
    public OrderDocumentModel acceptanceOrderItem(
            String orderNumber,
            String handleSearch,
            String scannedSearch,
            String currentItemOrder
    ) throws Exception {
        OrderLocalDocument document = databaseService.findOrderDocumentByOrderNumber(orderNumber);
        OrderDocument orderDocument = onecService.getOrderDocumentByOrderNumber(orderNumber);
        OrderDocumentModel orderDocumentModel = new OrderDocumentModel();
        String search = Strings.isNullOrEmpty(handleSearch) ? scannedSearch : handleSearch.trim();
        List<OrderItem> orderItems = databaseService.searchProductsInOrder(orderDocument.getJournal().getIdd(),
                search.length() >= 31 ? BarcodeHelper.getBarcodeFromDatamatrix(search) : search
        );

        if (Objects.isNull(document)) {
            logger.info("Document not found in local base");
            throw new Exception("warehouse.internet.order.document.acceptanceProduct.exception.document_not_found");
        }
        if (orderItems.size() == 0) {
            orderItems = databaseService.getProductsByMark(
                    search.length() >= 31 ? BarcodeHelper.getMarkFromDatamatrix(search) : search
            );
        }
        if (orderItems.size() == 0) {
            ProductInfo productInfo = onecService.searchProduct(search.length() >= 31 ? BarcodeHelper.getBarcodeFromDatamatrix(search) : search);

            if (Objects.isNull(productInfo)) {
                logger.info("Accepting product not found product.");
                throw new Exception("screen.warehouse.supply.lot.search.product.error.product_not_found");
            } else {

                if (productInfo.getProductKind().equals(ProductType.LOT.getValue())) {
                    logger.info("Order contains a lot");
                    throw new Exception("warehouse.internet.order.collect.orders.not.equals.lot");
                }
                OrderItem orderItem = OrderItemMapper.map(productInfo, orderDocument.getIdDoc());
                orderItem.setDocumentIdd(document.getIdd());
                orderItem.setQuantityFact(0);
                orderItem.setQuantity(0);
                orderItem.setSum(BigDecimal.ZERO);
                orderItem.setMarks("");

                try {
                    orderItem.setPrice(onecService.getPrice(productInfo.getId(), Date.from(document.getDateCreated().toInstant())));
                } catch (Exception exception) {
                    logger.info(
                            "Service didn't find price for this product id:'{}', idd:'{}', vendor code:'{}', name:'{}'.",
                            productInfo.getId(),
                            orderItem.getIdd(),
                            orderItem.getVendorCode(),
                            productInfo.getFullName(),
                            exception
                    );
                    throw new Exception("screen.warehouse.supply.acceptance.product.price_not_set", exception);
                }
                try {
                    orderItem.setVat(onecService.getVat(productInfo.getId(), Date.from(document.getDateCreated().toInstant())));
                } catch (Exception exception) {
                    logger.info(
                            "Service didn't find VAT for this product id:'{}', idd:'{}', vendor code:'{}', name:'{}'.",
                            productInfo.getId(),
                            orderItem.getIdd(),
                            orderItem.getVendorCode(),
                            productInfo.getFullName(),
                            exception
                    );
                    throw new Exception("screen.warehouse.supply.acceptance.product.vat_not_set", exception);
                }

                if (orderItems.size() == 0) {
                    logger.info("Product not found");
                    throw new Exception("warehouse.internet.order.collect.orders.content.product.not.found");
                }

                orderItems.add(orderItem);

                if (Objects.isNull(orderItem.getPrice())) {
                    logger.info("Order item with idd {} has null price", orderItem.getIdd());
                    throw new Exception("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.acceptance.error");
                }
                databaseService.updateOrderItem(orderItem);
                logger.info("Accepting product found in 1C '{}' product info.", orderItems.size());
            }
        }
        if (
                (!Strings.isNullOrEmpty(orderItems.get(0).getMarkTypeCode().trim()) && !orderItems.get(0).getMarkTypeCode().startsWith("0000")) &&
                        !ProductType.LOT.getValue().equals(orderItems.get(0).getKindOfProduct())
        ) {
            //PRODUCT WITH MARK
            if (
                    Strings.isNullOrEmpty(search) || search.length() <= 31 && (
                            search.equals(orderItems.get(0).getIdd())
                    )
            ) {
                OrderDocumentItemModel orderDocumentItemModel = OrderProductModelMapper.map(orderItems.get(0));
                orderDocumentModel.getOrderDocumentItemModels().add(orderDocumentItemModel);

                return orderDocumentModel;

            } else if (search.length() < 31) {
                logger.info("Product has mark. You need scan mark for add product in order");
                throw new Exception("warehouse.supply.recalculation.box.screen.message.need_scanned_mark");
            } else if (!BarcodeHelper.getBarcodeFromDatamatrix(search).equals(orderItems.get(0).getBarcode())) {
                logger.info("Mark doesn't apply to the product");
                throw new Exception("warehouse.supply.recalculation.box.screen.error.message.mark_does_not_apply_to_the_product");
            } else if (databaseService.isExistScannedMark(BarcodeHelper.getMarkFromDatamatrix(search))) {
                logger.info("Mark is exist");
                throw new Exception("warehouse.supply.recalculation.box.screen.error.message.mark_is_exist");
            } else {
                ScannedMark scannedMark = new ScannedMark();
                scannedMark.setScannedMark(BarcodeHelper.getMarkFromDatamatrix(search));
                scannedMark.setOrderItemId(orderItems.get(0).getId());
                scannedMark.setDataMatrix(BarcodeHelper.clearDatamatrix(search));
                String message = marksService.validate(
                        BarcodeHelper.clearDatamatrix(search),
                        "",
//                        onecService.getStoreIdd(),
                        onecService.getFirmByWarehouse(document.getWarehouse()).getIdd(),
                        serverMarksUrl,
                        serverMarksAuthorizationUrl,
                        username,
                        password
                );

                if (message.equals("OK")) {
                    OrderItem orderItem = orderItems
                            .parallelStream()
                            .filter(x -> x.getScannedMarks().size() < 10)
                            .findFirst()
                            .orElse(null);

                    if (Objects.nonNull(orderItem)) {
                        orderItem.setQuantityFact(orderItem.getQuantityFact() + 1);
                        orderItem.setSum(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantityFact())));
                        orderItem.getScannedMarks().add(scannedMark);
                        orderItem.setMarks(Objects.nonNull(orderItem.getMarks()) ? orderItem.getMarks().concat(BarcodeHelper.getMarkFromDatamatrix(search)) : BarcodeHelper.getMarkFromDatamatrix(search));
                    } else {
                        OrderItem lastProduct = orderItems.get(orderItems.size() - 1);
                        orderItem = lastProduct.clone();
                        orderItem.setId(UUID.randomUUID());
                        orderItem.setQuantity(lastProduct.getQuantity() - 10);
                        orderItem.setQuantityFact(1);
                        orderItem.setMarks(BarcodeHelper.getMarkFromDatamatrix(search));
                        orderItem.setScannedMarks(List.of(scannedMark));
                        orderItems.add(orderItem);
                        lastProduct.setQuantity(10);
                        databaseService.updateOrderItem(lastProduct);
                    }

                    if (orderItem.getQuantityFact() > orderItem.getQuantity()) {
                        logger.info("Updating order item fail. QuantityFact can not be more quantity plan");
                        throw new Exception("warehouse.supply.box.menu.screen.button.label.change_quantity.fail");
                    }

                    if (Strings.isNullOrEmpty(currentItemOrder) || currentItemOrder.equals(orderItem.getId().toString())) {
                        databaseService.updateOrderItem(orderItem);
                    } else {
                        orderItem.setQuantityFact(orderItem.getQuantityFact() - 1);
                        logger.info("Scan order item not in current order view screen. Added item aborted");
                        throw new Exception("warehouse.internet.order.collect.orders.by.images.not.acceptance.product");
                    }
                    scannedMark.setValidMark(true);
                    scannedMark.setNumber(orderItem.getQuantityFact());
                    databaseService.updateScannedMark(scannedMark);
                } else {
                    ScannedMark markForCheckValid = databaseService.findMarkByOrderItemId(orderItems.get(0).getId(), scannedSearch);

                    if (Objects.isNull(markForCheckValid)) {
                        scannedMark.setValidMark(false);
                        OrderItem orderItem = orderItems.get(0);

                        if (orderItem.getQuantityFact() > 0) {
                            orderItem.setQuantityFact(orderItem.getQuantityFact() - 1);
                        }

                        scannedMark.setNumber(orderItems.get(0).getQuantityFact() + 1);
                        scannedMark.setErrorMessage(message);
                        databaseService.updateOrderItem(orderItem);
                        databaseService.updateScannedMark(scannedMark);
                    }
                    throw new Exception(message);
                }
            }
        }
        if (Strings.isNullOrEmpty(orderItems.get(0).getMarkTypeCode()) && orderItems.size() != 0) {
            logger.info("Accepting product found in local db '{}' products.", orderItems.size());
            OrderItem order = orderItems.get(0);

            if (order.getQuantityFact() + 1 > order.getQuantity()) {
                OrderItem orderItem = orderItems.parallelStream()
                        .filter(e -> e.getQuantityFact() < e.getQuantity())
                        .findFirst().orElse(null);

                if (Objects.nonNull(orderItem)) {
                    order = orderItem;
                } else {
                    logger.info("Updating order item fail. QuantityFact can not be more quantity plan");
                    throw new Exception("warehouse.supply.box.menu.screen.button.label.change_quantity.fail");
                }
            }

            if (!Strings.isNullOrEmpty(currentItemOrder) && orderItems.size() > 1) {
                OrderItem orderItem = orderItems.parallelStream()
                        .filter(e -> e.getId().equals(UUID.fromString(currentItemOrder)))
                        .findFirst()
                        .orElse(null);

                if (Objects.nonNull(orderItem)) {
                    order = orderItem;
                }
            }

            order.setQuantityFact(order.getQuantityFact() + 1);
            orderItems.clear();
            orderItems.add(order);

            if (Strings.isNullOrEmpty(currentItemOrder) || currentItemOrder.equals(order.getId().toString())) {
                databaseService.updateOrderItem(order);
            } else {
                order.setQuantityFact(order.getQuantityFact() - 1);
                logger.info("Scan order item not in current order view screen. Added item aborted");
                throw new Exception("warehouse.internet.order.collect.orders.by.images.not.acceptance.product");
            }
        }

        orderDocumentModel.setOrderDocumentItemModels(orderItems
                .parallelStream()
                .map(OrderProductModelMapper::map).collect(Collectors.toList()));
        return orderDocumentModel;
    }

    public List<EmployeeModel> getListOfEmployees() {
        logger.info("Getting employees list");
        return onecService.findNotFiredAndNotMaternityLeaveEmployees(0, "Декрет")
                .parallelStream()
                .filter(Objects::nonNull)
                .map(x -> {
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.setId(x.getId());
                    employeeModel.setIdd(x.getIdd());
                    employeeModel.setFio(x.getName().trim());

                    if (x.getPosition() != null) {
                        employeeModel.setPosition(x.getPosition().getName().trim());
                    }

                    return employeeModel;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDocumentModel findOrder(String barcode) throws Exception {
        logger.info("Searching order by barcode:'{}'.", barcode);
        OrderDocument orderDocument;

        if (barcode.length() == 17) {
            orderDocument = onecService.getOrderByIdd(barcode);
        } else if (barcode.length() == 12) {
            orderDocument = onecService.getOrderByOrderNumber(barcode.substring(2));
        } else if (barcode.length() == 10) {
            orderDocument = onecService.getOrderByOrderNumber(barcode);
        } else {
            logger.info("Incorrect number of barcode symbols: '{}'", barcode);
            throw new Exception("warehouse.internet.order.information.about.order.barcode.error");
        }

        OrderDocumentModel orderDocumentModel;

        if (Objects.nonNull(orderDocument)) {
            String status = getStatusFrom1c(orderDocument).getLocale();
            orderDocumentModel = OrderDocumentMapper.map(orderDocument, status);
            orderDocumentModel.setWarehouse(onecService.getWarehouseName(orderDocument.getWarehouse()));
        } else {
            logger.info("Order not found by '{}'", barcode);
            throw new Exception("warehouse.internet.order.document.status.delivery.order.not_found");
        }

        return orderDocumentModel;
    }

    public OrderDocumentModel clearFactPosition(String orderItemId) throws Exception {
        logger.info("Clearing fact position in order item: '{}'", orderItemId);
        OrderDocumentModel orderDocumentModel = new OrderDocumentModel();
        OrderItem orderItem = databaseService.findOrderItemById(UUID.fromString(orderItemId));

        if (Objects.isNull(orderItem)) {
            logger.info("Order item not found in local base");
            throw new Exception("warehouse.internet.order.document.status.delivery.order.item.not_found");
        }

        orderItem.setQuantityFact(0);

        if (!orderItem.getMark() && !Strings.isNullOrEmpty(orderItem.getMarks())) {
            orderItem.setMarks("");
        }
        if (orderItem.getMark()) {
            orderItem.getScannedMarks().clear();
            databaseService.deleteMark(orderItem.getMarks());
            orderItem.setMarks("");
        }

        databaseService.updateOrderItem(orderItem);
        List<OrderItem> orderItems = databaseService.getOrderItemsByIdDoc(orderItem.getIdDoc());
        orderDocumentModel.setOrderDocumentItemModels(orderItems
                .parallelStream()
                .map(OrderProductModelMapper::map).collect(Collectors.toList()));
        logger.info("Clearing fact position in order item: '{}' success", orderItemId);
        return orderDocumentModel;
    }

    public OrderDocumentItemModel getOrderProduct(String id) {
        logger.info("Getting order item with id: '{}'", id);

        return OrderProductModelMapper.map(
                databaseService.findOrderItemById(UUID.fromString(id)));
    }

    public OrderDocumentItemModel updateOrderItem(String orderItemId, String quantityFact) throws Exception {
        logger.info("Updating quantity fact to: '{}' in order item: '{}'", quantityFact, orderItemId);
        OrderItem orderItem = databaseService.findOrderItemById(UUID.fromString(orderItemId));

        if (orderItem.getMark()) {
            logger.info("Can not update quantity fact in marked order item");
            throw new Exception("warehouse.supply.product.error_message_has_mark");
        }
        if (Integer.parseInt(quantityFact) > orderItem.getQuantity()) {
            logger.info("Updating order item fail. QuantityFact can not be more quantity plan");
            throw new Exception("warehouse.supply.box.menu.screen.button.label.change_quantity.fail");
        }

        orderItem.setQuantityFact(Integer.valueOf(quantityFact));
        databaseService.updateOrderItem(orderItem);
        logger.info("Updating quantity fact to: '{}' in order item: '{}' success", quantityFact, orderItemId);

        return OrderProductModelMapper.map(orderItem);
    }

    public OrderDocumentModel deleteOrderItem(String orderItemId) {
        logger.info("Deleting order item with id: '{}'", orderItemId);
        OrderDocumentModel orderDocumentModel = new OrderDocumentModel();
        OrderItem orderItem = databaseService.findOrderItemById(UUID.fromString(orderItemId));
        databaseService.deleteOrderItem(UUID.fromString(orderItemId));
        List<OrderItem> orderItems = databaseService.getOrderItemsByIdDoc(orderItem.getIdDoc());
        orderDocumentModel.setOrderDocumentItemModels(orderItems
                .parallelStream()
                .map(OrderProductModelMapper::map).collect(Collectors.toList()));
        logger.info("Deleting order item with id: '{}' success", orderItemId);

        return orderDocumentModel;
    }

    public CheckAcceptanceDocument checkAcceptanceDocument(CheckAcceptanceDocument checkAcceptanceDocument) {
        OrderLocalDocument document = databaseService.findOrderDocumentByOrderNumber(checkAcceptanceDocument.getDocumentNumber());
        List<OrderItem> orderItems = databaseService.getOrderItemsByIdDoc(document.getIdDoc());
        List<OrderItem> ordersWithMismatch = orderItems.parallelStream()
                .filter(e -> !Objects.equals(e.getQuantityFact(), e.getQuantity()))
                .collect(Collectors.toList());
        int mismatchQuantityFactCheck = ordersWithMismatch.parallelStream()
                .filter(e -> {
                    return Strings.isNullOrEmpty(e.getMarks());
                })
                .mapToInt(OrderItem::getQuantity)
                .sum();
        boolean isProblem = false;

        for (OrderItem orderItem : orderItems) {
            if (Strings.isNullOrEmpty(orderItem.getMarks()) && !Objects.equals(orderItem.getQuantity(), orderItem.getQuantityFact())) {
                isProblem = true;
                break;
            }
        }
        if (isProblem) {
            logger.info(
                    "Acceptance document number: '{}' has been: '{}' mismatch",
                    checkAcceptanceDocument.getDocumentNumber(),
                    mismatchQuantityFactCheck
            );
            checkAcceptanceDocument.setCheckResult(true);
        } else {
            logger.info(
                    "Acceptance document number: '{}' has no mismatch",
                    checkAcceptanceDocument.getDocumentNumber()
            );
            checkAcceptanceDocument.setCheckResult(false);
        }

        return checkAcceptanceDocument;
    }


    @Transactional
    public OrderDocumentAcceptance confirmationDocument(String orderNumber, String employeeId, String orderDateFormat) throws Exception {
        logger.info("Start acceptance document number: '{}'", orderNumber);
        OrderDocument orderDocument = onecService.getOrderDocumentByOrderNumber(orderNumber);
        List<String> idDocs = new ArrayList<>();
        WriteOffDocument writeOffDocument;
        OrderDocumentAcceptance orderDocumentAcceptance = new OrderDocumentAcceptance();
        OrderLocalDocument document = databaseService.findOrderDocumentByOrderNumber(orderNumber);
        List<OrderItem> orderItems = databaseService.getOrderItemsByIdDoc(document.getIdDoc());
        List<OrderPackage> orderPackage = databaseService.findAllPackageByOrderNumber(orderNumber);

        if (!orderPackage.isEmpty()) {
            if (
                    orderPackage.parallelStream()
                            .mapToInt(e -> e.getPackageQuantity().intValue())
                            .sum() > 0
            ) {
                writeOffDocument = createWriteOffDocument(orderNumber);
                logger.info("WriteOff document created with idDoc: '{}' success", writeOffDocument.getIdDoc());
                writeStockBalance(writeOffDocument, document);
                Journal journal = onecService.getJournalByIddoc(writeOffDocument.getIdDoc());
                journal.setPmm(0);
                onecService.addJournal(journal);
                idDocs.add(writeOffDocument.getIdDoc());
                onecService.addOnecSrcDoc(journal, orderDocument.getJournal().getIdocdef(), orderDocument.getIdDoc());
                logger.info(
                        "Created 1SCRDOC row with childJournal idDoc: '{}', parentIdDocRef: '{}' and parentIdDoc: '{}'",
                        journal.getIdoc(),
                        orderDocument.getJournal().getIdocdef(),
                        orderDocument.getIdDoc()
                );

            }
        } else {
            logger.info(
                    "Not found rows for packages in local base by document orderNumber: '{}'",
                    orderNumber
            );
            throw new Exception("warehouse.internet.order.collect.orders.packages.not_fount_package");
        }

        logger.info("Acceptance document number: '{}' no has mismatch", orderNumber);

        if (!Strings.isNullOrEmpty(employeeId)) {
            orderDocument.setCollectorName(employeeId);
            document.setCollectorName(employeeId);
        }

        orderDocument.setStatusOrder(OrderStatus.READY_FOR_DELIVERY.getOnecId());
        logger.info("Update document in oneC by idDoc: '{}'", orderDocument.getIdDoc());
        onecService.updateOrderDocument(orderDocument);
        logger.info("Update document items");
        List<OrderDocumentItem> orderItemsForUpdate = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            List<OrderDocumentItem> orderDocumentItem = onecService.findOrderDocumentItemByIdd(orderItem.getIdd());
            OrderDocumentItem documentItem;

            if (orderDocumentItem.size() < 2) {
                documentItem = orderDocumentItem.get(0);
            } else {
                documentItem = orderDocumentItem.parallelStream()
                        .filter(e -> e.getIddocLinenumberIdentity().getLineNo().equals(orderItem.getLineNumberIdentity()))
                        .collect(Collectors.toList()).get(0);
            }

            documentItem.setQuantityFact(BigDecimal.valueOf(orderItem.getQuantityFact()));

            if (orderItem.getQuantityFact() == 0) {
                documentItem.setListMarks(orderItem.getMarks());
                documentItem.setSum(BigDecimal.ZERO);
            } else {
                documentItem.setSum(orderItem.getSum().multiply(orderItem.getPrice()));
            }

            orderItemsForUpdate.add(documentItem);
        }

        onecService.saveOrderDocumentItem(orderItemsForUpdate);
        Journal journal = onecService.getJournal(orderDocument.getIdDoc());
        journal.setPmm(0);
        onecService.addJournal(journal);
        document.setStatusOrder(OrderStatus.READY_FOR_DELIVERY);
        document.setCollectorName(orderDocument.getCollectorName());
        databaseService.addDocument(document);
        logger.info("Document with idd: '{}', updated with status order: '3'", document.getIdd());
        orderDocumentAcceptance.setMismatchQuantityFactCheck(0);
        Employee employee = onecService.getEmployeeById(orderDocument.getCollectorName());
        logger.info("'{}' was chosen like collector for order with number - '{}'", employee.getName(), orderDocument.getOrderNumber());
        Warehouse warehouse = onecService.getWarehouseById(orderDocument.getWarehouse());
        boolean shippingSFS = ShippingMethod.getName(orderDocument.getShippingMethod()).equals(ShippingMethod.SHIP_FROM_STORE.getName());

        if (ShippingMethod.getName(orderDocument.getShippingMethod()).equals(ShippingMethod.RESERVE.getName())) {
            logger.info("Start mapping PackingListModel");
            PackingListModel packingListModel = PackingListModelMapper.map(orderDocument, orderItems, employee.getName(), warehouse);
            logger.info("Start method createPackingList method");
            printService.createPackingList(packingListModel);
        }
        if (shippingSFS) {
            logger.info("Start mapping StickerModel");
            StickerModel stickerModel = StickerModelMapper.map(orderDocument, warehouse);
            logger.info("Start calling createSticker method");
            printService.createSticker(stickerModel);
        }
        if (shippingSFS && orderItems.parallelStream().anyMatch(e -> e.getQuantityFact() > 0)) {
            printService.createBuyerInlay(
                    BuyerInlayModelMapper.map(
                            document,
                            orderDocument.getBuyer().split(";"),
                            new SimpleDateFormat(orderDateFormat).format(document.getDateCreated())
                    )
            );
        }

        deletePackages(orderNumber);
        orderDocumentAcceptance.setMovePeriodIdDocs(idDocs);

        return orderDocumentAcceptance;
    }

    public void deletePackages(String orderNumber) {
        databaseService.deletePackages(orderNumber);
    }

    @Transactional
    public OrderDisbandment orderDisbandment(String barcode) throws Exception {
        logger.info(
                "Disbandment order by order barcode:'{}'.",
                barcode
        );
        OrderDocument orderDocument = onecService.getOrderByOrderNumber(barcode);

        if (Objects.isNull(orderDocument)) {
            logger.info("Order document not found by barcode: '{}'", barcode);
            throw new Exception("warehouse.internet.order.disbandment.error.order_document_not_found");
        }
        if (Strings.isNullOrEmpty(barcode)) {
            logger.info("Empty input line: '{}'", barcode);
            throw new Exception("warehouse.internet.order.disbandment.error.barcode_is_null_or_empty");
        }

        List<String> idDocList = new ArrayList<>();
        Integer tableId = onecService.getTableIdByEntityName("Документ.Заказ");

        if (Objects.isNull(tableId)) {
            logger.info("Can not find table Id");
            throw new Exception("warehouse.internet.order.disbandment.error.find.table");
        }

        String baseDocumentIdd = OrderNumberHelper.getSaleReceiptWithIdOrder(barcode);
        Receipt saleReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), baseDocumentIdd);

        if (Objects.isNull(saleReceipt)) {
            baseDocumentIdd = OrderNumberHelper.getSaleReceiptWithoutIdOrder(barcode);
            saleReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), baseDocumentIdd);
        }

        OrderDisbandment orderDisbandment = new OrderDisbandment();

        if (Objects.nonNull(saleReceipt)) {
            logger.info("Impossible to disband the order, there is a Sales receipt with idd: '{}'", saleReceipt.getJournal().getIdd());
            orderDisbandment.setScreenText("warehouse.internet.order.disbandment.order.unable.disband.sale.receipt.text");
            return orderDisbandment;
        }

        baseDocumentIdd = OrderNumberHelper.getReturnReceiptWithIdOrder(barcode);
        Journal returnReceipt = onecService.getReceiptJournalByIdd(baseDocumentIdd);

        if (Objects.isNull(returnReceipt)) {
            baseDocumentIdd = OrderNumberHelper.getReturnReceiptWithoutIdOrder(barcode);
            returnReceipt = onecService.getReceiptJournalByIdd(baseDocumentIdd);
        }
        if (Objects.nonNull(returnReceipt)) {
            logger.info("Impossible to disband the order, there is a Return receipt with idd: '{}'", returnReceipt.getIdd());
            orderDisbandment.setScreenText("warehouse.internet.order.disbandment.order.unable.disband.return.receipt.text");
            return orderDisbandment;
        }

        String docBasisDisbanded = onecService.getDocBasis(tableId, orderDocument.getIdDoc());

        if (!Objects.isNull(onecService.getOrderClosureDocumentByDocBasis(docBasisDisbanded))) {
            logger.info("Order has already been disband");
            throw new Exception("warehouse.internet.order.disbandment.order.unable.was.disband.text");
        }
        if (!"     2   ".equals(orderDocument.getStatusOrder())) {
            logger.info("Order document has no 'no active' status. Current status: '{}'", orderDocument.getStatusOrder());
            throw new Exception("warehouse.internet.order.disbandment.error.incorrect_status");
        }

        String idDoc = onecService.getNewIdDoc();

        if (Strings.isNullOrEmpty(idDoc)) {
            logger.info("IdDoc is null or empty");
            throw new Exception("warehouse.internet.order.disbandment.error.iddoc");
        }

        String docBasis = onecService.getDocBasis(tableId, orderDocument.getIdDoc());

        if (Strings.isNullOrEmpty(docBasis)) {
            logger.info("Can no get docBasis document");
            throw new Exception("warehouse.internet.order.disbandment.error.doc_basis");
        }

        String movingReasonId = onecService.getMovingReasonByCode("36").getId();

        if (Strings.isNullOrEmpty(movingReasonId)) {
            logger.info("Can not get moving document id");
            throw new Exception("warehouse.internet.order.document.order.disbandment.find.moving.document.error");
        }

        Currency currency = onecService.getCurrency();

        if (Objects.isNull(currency)) {
            logger.info("Currency is null");
            throw new Exception("warehouse.internet.order.disbandment.error.currency");
        }

        String currencyId = currency.getId();

        if (Strings.isNullOrEmpty(currencyId)) {
            logger.info("Currency id is null or empty");
            throw new Exception("warehouse.internet.order.disbandment.error.currency.id");
        }

        String rate = currency.getRate();

        if (Strings.isNullOrEmpty(rate)) {
            logger.info("Rate is null or empty");
            throw new Exception("warehouse.internet.order.disbandment.error.rate");
        }

        String coefficient = currency.getMultiplicity();

        if (Strings.isNullOrEmpty(coefficient)) {
            logger.info("Coefficient is null or empty");
            throw new Exception("warehouse.internet.order.disbandment.error.coefficient");
        }

        String idd = iddGeneratingService.getNewIdd();

        if (Strings.isNullOrEmpty(idd)) {
            logger.info("Idd is null or empty");
            throw new Exception("warehouse.internet.order.disbandment.error.idd");
        }

        List<OrderClosureDocument> orderClosureDocuments = onecService.findOrderClosureDocumentByBasisContaining(
                orderDocument.getIdDoc()
        );

        if (orderClosureDocuments.size() > 0) {
            logger.info("Closure document is already created");
            throw new Exception("warehouse.internet.order.disbandment.error.closure_document");
        }

        Journal journal = JournalMapper.map(idd, idDoc, orderDocument.getJournal().getFirm(), 0);
        journal.setPmm(0);
        journal.setAuthor(orderDocument.getJournal().getAuthor());
        journal = journalComponent.setReferences(journal, "ЗакрытиеЗаказа");
        logger.info("Journal with type: '{}' created", "ЗакрытиеЗаказа");

        if (Objects.nonNull(journal)) {
            idDocList.add(journal.getIdoc());
        } else {
            logger.info("Can not create journal for closure document");
            throw new Exception("warehouse.internet.order.disbandment.error.journal");
        }

        OrderClosureDocument orderClosureDocument = OrderClosureDocumentMapper.map(
                orderDocument,
                idDoc,
                docBasis,
                currencyId,
                rate,
                coefficient,
                journal
        );
        journal.setOrderClosureDocument(orderClosureDocument);
        onecService.saveOrderClosureDocument(orderClosureDocument);
        logger.info("Created Journal for OrderClosureDocument with idDoc: '{}'", journal.getIdoc());
        onecService.addOnecSrcDoc(journal, orderDocument.getJournal().getIdocdef(), orderDocument.getIdDoc());
        logger.info(
                "Created 1SCRDOC row with childJournal idDoc: '{}', parentIdDocRef: '{}' and parentIdDoc: '{}'",
                journal.getIdoc(),
                orderDocument.getJournal().getIdocdef(),
                orderDocument.getIdDoc()
        );
        orderDisbandment.setScreenText("warehouse.internet.order.disbandment.order.text");
        orderDisbandment.setIdDoc(idDocList);

        return orderDisbandment;
    }

    @Transactional
    public OrderAcceptanceDeliveryDocument acceptanceDeliveryDocument(String handleSearch, String scannedSearch) throws Exception {
        OrderAcceptanceDeliveryDocument orderAcceptanceDeliveryDocument = new OrderAcceptanceDeliveryDocument();
        OrderDocument orderDocument;

        if (!Strings.isNullOrEmpty(handleSearch)) {
            logger.info("Try to found order document with handleSearch: '{}'", handleSearch);

            if (handleSearch.length() == 10 || handleSearch.length() == 12) {
                orderDocument = onecService.getOrderDocumentByOrderNumber(handleSearch.length() == 12 ? handleSearch.substring(2) : handleSearch);
            } else {
                logger.info("Incorrect number of barcode symbols: '{}'", handleSearch);
                throw new Exception("warehouse.internet.order.information.about.order.barcode.error");
            }
        } else {
            logger.info("Try to found order document with scannedSearch: '{}'", scannedSearch);
            orderDocument = onecService.getOrderDocumentByOrderNumber(scannedSearch);
        }

        if (Objects.nonNull(orderDocument)) {
            if (ShippingMethod.getName(orderDocument.getShippingMethod()).equals(ShippingMethod.SHIP_FROM_STORE.getName()) && orderDocument.getStatusOrder().equals(OrderStatus.READY_FOR_DELIVERY.getOnecId()) && (orderDocument.getJournal().getPmm() == 0 || orderDocument.getJournal().getPmm() == 5)) {
                //todo ReceiptByDocBasis
                if (Objects.isNull(onecService.getReceiptByDocBasis(String.valueOf(orderDocument.getJournal().getIdocdef()), orderDocument.getIdDoc()))) {
                    ScannedDocument scannedDocument = ScannedDocumentMapper.map(orderDocument);
                    scannedDocument.setOrderStatus(ScannedDocumentStatus.SCANNED.getValue());
                    databaseService.saveScannedDocument(scannedDocument);
                    logger.info("Scanned document saved with order number: '{}'", scannedDocument.getOrderNumber());
                } else {
                    logger.info("The order has already been issued to the courier");
                    throw new Exception("warehouse.internet.order.document.status.delivery.order.already.issued");
                }
            } else if (!ShippingMethod.getName(orderDocument.getShippingMethod()).equals(ShippingMethod.SHIP_FROM_STORE.getName())) {
                logger.info("The order is not SFS");
                throw new Exception("warehouse.internet.order.document.status.delivery.order.not_sfs");
            } else if (!orderDocument.getStatusOrder().equals(OrderStatus.READY_FOR_DELIVERY.getOnecId())) {
                logger.info("The order is not in the Confirmed status");
                throw new Exception("warehouse.internet.order.document.status.delivery.order.not_confirmed_status");
            } else if (!(orderDocument.getJournal().getPmm() == 0 || orderDocument.getJournal().getPmm() == 5)) {
                logger.info("Unloading PMM is not 0 and not 5");
                throw new Exception("warehouse.internet.order.document.status.delivery.order.uploading.pmm_not_0_or_5_status");
            }
        } else {
            logger.info("Order document not found in oneC Db");
            throw new Exception("warehouse.internet.order.document.status.delivery.order.not_found");
        }

        return orderAcceptanceDeliveryDocument;
    }

    @Transactional
    public OrderFinishIssuingOrders finishIssuingOrders(String transportCompany) throws Exception {
        logger.info("finishing issuing orders for transport company - {}", transportCompany);
        OrderFinishIssuingOrders orderFinishIssuingOrders = new OrderFinishIssuingOrders();
        List<String> receiptIdDoc = new ArrayList<>();
        List<ScannedDocument> orderNumberScannedList = (Strings.isNullOrEmpty(transportCompany) ? databaseService.findAllScannedDocumentsInStatus(ScannedDocumentStatus.SCANNED.getValue()) : databaseService.findAllScannedDocumentsInStatusAndTk(ScannedDocumentStatus.SCANNED.getValue(), transportCompany)).parallelStream()
                .filter(s -> !s.getOrderStatus().equals(ScannedDocumentStatus.SUCCESS.getValue()))
                .collect(Collectors.toList());
        logger.info("Find '{}' scanned documents by transport company - '{}'", orderNumberScannedList.size(), transportCompany);
        List<OrderDocument> orderOrderDocuments = onecService.getOrderDocumentsByOrderNumberList
                (
                        orderNumberScannedList.parallelStream()
                                .filter(e -> !e.getOrderStatus().equals(ScannedDocumentStatus.SUCCESS.getValue()))
                                .map(ScannedDocument::getOrderNumber)
                                .collect(Collectors.toList())
                );
        logger.info("Find '{}' order documents by order number list ", orderOrderDocuments.size());

        if (orderOrderDocuments.size() == 0) {
            logger.info("No scanned orders for issuing");
            throw new Exception("warehouse.internet.order.document.finish_issuing_orders.exception.no_scanned_orders");
        }

        //Создание чека и журнала для каждого документа
        for (OrderDocument orderDocument : orderOrderDocuments) {
            logger.info("Creating receipt and journal for order document: '{}'", orderDocument.getOrderNumber());
            String journalIdd;

            if (Strings.isNullOrEmpty(orderDocument.getOrderId())) {
                journalIdd = OrderNumberHelper.getSaleReceiptWithoutIdOrder(orderDocument.getOrderNumber());
            } else {
                journalIdd = OrderNumberHelper.getSaleReceiptWithIdOrder(orderDocument.getOrderNumber());
            }

            String journalIdDoc = createReceiptAndJournal(orderDocument, Boolean.FALSE, journalIdd);
            receiptIdDoc.add(journalIdDoc);
            onecService.addOnecSrcDoc(onecService.getJournal(journalIdDoc), orderDocument.getJournal().getIdocdef(), orderDocument.getIdDoc());
            logger.info(
                    "Created 1SCRDOC row with childJournal idDoc: '{}', parentIdDocRef: '{}' and parentIdDoc: '{}'",
                    journalIdDoc,
                    orderDocument.getJournal().getIdocdef(),
                    orderDocument.getIdDoc()
            );
            Journal journal = orderDocument.getJournal();
            journal.setPmm(1);
            onecService.addJournal(journal);
        }

        for (ScannedDocument scannedDocument : orderNumberScannedList) {
            scannedDocument.setOrderStatus(ScannedDocumentStatus.SUCCESS.getValue());
            databaseService.saveScannedDocument(scannedDocument);
            logger.info("Scanned document idd: '{}' updated with order status: '{}'", scannedDocument.getIdd(), ScannedDocumentStatus.SUCCESS.getValue());
        }

        orderFinishIssuingOrders.setIssuedOrders(orderNumberScannedList.parallelStream()
                .map(ScannedDocument::getOrderNumber)
                .collect(Collectors.toList()));
        orderFinishIssuingOrders.setOrdersIdDoc(receiptIdDoc);
        logger.info("Order idDoc list for update move period has: '{}' positions", receiptIdDoc.size());

        List<ReceiptOrdersList> ordersList = orderNumberScannedList.parallelStream()
                .map(e -> new ReceiptOrdersList(e.getOrderNumber(),
                        new SimpleDateFormat("dd.MM.yyyy").format(e.getDateCreated())
                ))
                .collect(Collectors.toList());
        Warehouse warehouse = onecService.getWarehouseById(orderOrderDocuments.get(0).getWarehouse());
        ReceiptOrdersModel receiptOrdersModel = ReceiptOrdersModelMapper.map(
                String.valueOf(receiptIdDoc.size()),
                ordersList,
                transportCompany,
                String.format(
                        "%s %s",
                warehouse.getName().trim(),
                warehouse.getAddress().trim()
        )
        );
        printService.createReceiptIssuingOrders(receiptOrdersModel);

        return orderFinishIssuingOrders;
    }

    @Transactional
    public String createReceiptAndJournal(OrderDocument orderDocument, Boolean isReturn, String receiptIdd) throws Exception {
        String idd = iddGeneratingService.getNewIdd();
        logger.info("Creating receipt and journal for order document with number = '{}'", orderDocument.getOrderNumber());

        if (Objects.isNull(idd)) {
            logger.info("Idd generator not return new Idd");
            throw new Exception("idd.generate.error");
        }

        String idDoc = onecSystemComponent.getIddoc();
        OrderLocalDocument document = databaseService.findOrderDocumentByOrderNumber(orderDocument.getOrderNumber().trim());

        if (Objects.isNull(document)) {
            logger.info("Document with OrderNumber: '{}' not fount in local db", orderDocument.getOrderNumber().trim());
            throw new Exception("warehouse.internet.order.document.finish_issuing_orders.exception.document_not_found");
        }

        Journal journal = JournalMapper.map(receiptIdd, idDoc, document.getFirm(), 1);
        journal = journalComponent.setReferences(journal, "ЧекККМ");
        journal.setPmm(1);
        logger.info("Receipt journal created with idd: '{}', and idDoc: '{}'", journal.getIdd(), journal.getIdoc());
        onecService.addJournal(journal);
        Receipt receipt = ReceiptMapped.map(
                orderDocument,
                document,
                journal,
                currencyComponent.getCurrentCurrency(),
                orderDocument.getJournal().getIdd()
        );
        List<OrderItem> orderItems = databaseService.getOrderItemsByDocumentIdd(document.getIdd());
        receipt.setItems(
                orderItems
                        .parallelStream()
                        .map(ReceiptItemMapper::map)
                        .collect(Collectors.toList())
        );

        if (isReturn) {
            receipt.setOperationType("   3DH   ");
        }

        onecService.createReceipt(receipt);
        logger.info("Receipt for order number: '{}' created", orderDocument.getOrderNumber());
        receipt.setJournal(journal);
        writeStockBalance(receipt, document, isReturn);
        orderDocument.getJournal().setPmm(1);
        onecService.updateOrderDocument(orderDocument);

        return receipt.getIdDoc();
    }

    @Transactional
    public void writeStockBalance(
            Receipt receipt,
            OrderLocalDocument orderLocalDocument,
            boolean isReturned
    ) throws Exception {
        List<StockBalanceTMC> stockBalanceTMCs = new ArrayList<>();
        List<StockBalanceTMCItem> stockBalanceTMCItems = new ArrayList<>();
        int actionNumber = 1;

        if (Objects.isNull(orderLocalDocument.getOrderItems())) {
            logger.info("Document idd: '{}' order items is empty", orderLocalDocument.getIdd());
            throw new Exception("No items in orderLocalDocument");
        }
        for (OrderItem orderItem : orderLocalDocument.getOrderItems()
                .parallelStream()
                .filter(x -> x.getQuantityFact() > 0)
                .collect(Collectors.toList())
        ) {
            stockBalanceTMCs.add(
                    StockBalanceTMCMapper.map(
                            orderLocalDocument.getFirm(),
                            orderLocalDocument.getWarehouse(),
                            BigDecimal.valueOf(orderItem.getQuantityFact()),
                            orderItem.getOriginalId(),
                            receipt.getDateCreated()
                    )
            );
            stockBalanceTMCItems.add(
                    StockBalanceTMCItemMapper.map(
                            0,
                            actionNumber,
                            receipt.getIdDoc(),
                            orderLocalDocument.getWarehouse(),
                            orderLocalDocument.getFirm(),
                            orderItem.getOriginalId(),
                            BigDecimal.valueOf(orderItem.getQuantityFact()),
                            orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantityFact())),
                            "50",
                            isReturned ? 0 : 1
                    )
            );
            actionNumber++;
        }

        receipt.getJournal().setActcnt(stockBalanceTMCItems.size());
        onecService.updateStockBalanceTMC(stockBalanceTMCs);
        onecService.writeStockBalanceTMCItems(stockBalanceTMCItems, receipt.getDateCreated());
        logger.info("Write stock balance for receipt with idDoc: '{}' success", receipt.getIdDoc());
    }

    public void movePeriods(List<String> idDocs) throws Exception {
        logger.info("Start move periods");

        for (String idDoc : idDocs) {
            movePeriod(idDoc);
        }
    }

    @Transactional
    public void movePeriod(String idDoc) throws Exception {
        Journal journal = onecService.getJournalByIddoc(idDoc);

        if (Objects.nonNull(journal)) {
            journal.setClosed(1);
            onecService.updateJournal(journal);
            onecService.movePeriod(journal);
            logger.info("Move Period moved period for IdDOC: '{}'", idDoc);
        }
    }

    @Transactional
    public List<OrderModel> returnOrder(String handleSearch, String scannedSearch) throws ExceptionWithParameters, Exception {
        logger.info("Returning order search order by handleSearch:'{}' or scannedSearch:'{}'", handleSearch, scannedSearch);
        String statusForException;
        String receiptStatusException = "";

        if (Strings.isNullOrEmpty(handleSearch) && Strings.isNullOrEmpty(scannedSearch)) {
            logger.info("Returning order return all local documents.");
            return getAllLocalReturnOrders();
        }

        String search = Strings.isNullOrEmpty(handleSearch) ? scannedSearch : handleSearch;
        OrderDocument orderDocument = onecService.getOrderByBarcode(search);

        if (Objects.isNull(orderDocument)) {
            orderDocument = onecService.getOrderDocumentByOrderNumber(search);
        }

        if (Objects.isNull(orderDocument)) {
            logger.info("Returning order not found document.");
            throw new ExceptionWithParameters("warehouse.internet.order.return.order.screen.error.massage.returning_order_not_found_document");
        }

        if (Objects.nonNull(databaseService.findByOrderNumber(orderDocument.getOrderNumber().trim()))) {
            logger.info("Order this number '{}' has already been scanned and added to db", orderDocument.getOrderNumber().trim());
            throw new ExceptionWithParameters("warehouse.internet.order.return.order.screen.error.massage.already.scanned");
        }
        orderDocument.setOrderNumber(orderDocument.getOrderNumber().trim());
        Receipt saleReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getSaleReceiptWithoutIdOrder(orderDocument.getOrderNumber()));

        if (Objects.isNull(saleReceipt)) {
            logger.info("Sale Receipt with idd: '{}' not found", OrderNumberHelper.getSaleReceiptWithoutIdOrder(orderDocument.getOrderNumber()));
            saleReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getSaleReceiptWithIdOrder(orderDocument.getOrderNumber()));
        }

        //TODO refactoring OrderNumberHelper.getReturnReceiptWithIdOrder and Without
        if (Objects.nonNull(saleReceipt)) {
            logger.info("Sale Receipt found with idd: '{}'", saleReceipt.getJournal().getIdd());
            Receipt returnReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getReturnReceiptWithIdOrder(orderDocument.getOrderNumber()));

            if (Objects.isNull(returnReceipt)) {
                logger.info("Return Receipt  with idd: '{}' not found", OrderNumberHelper.getReturnReceiptWithIdOrder(orderDocument.getOrderNumber()));
                returnReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getReturnReceiptWithoutIdOrder(orderDocument.getOrderNumber()));
            }

            if (Objects.nonNull(returnReceipt)) {
                logger.info("Receipt with idDoc: '{}' and type 'return' is already exist", saleReceipt.getJournal().getIdd());
                throw new ExceptionWithParameters("warehouse.internet.order.return.order.screen.error.massage.this_order_already_has_a_return_receipt");
            } else {
                OrderLocalDocument orderLocalDocument = databaseService.findOrderDocumentByOrderNumber(orderDocument.getOrderNumber());

                if (Objects.isNull(orderLocalDocument)) {
                    acceptLocalDocument(orderDocument, OrderStatus.READY_FOR_DELIVERY);
                    logger.info("Document in local base not found. Creating done");
                }

                OrderStatus status = getStatusFrom1c(orderDocument);
                databaseService.saveReturnOrder(ReturnOrderMapper.map(orderDocument, status));
                logger.info("Order for return with orderNumber: '{}' was added to local base", orderDocument.getOrderNumber());
                return getAllLocalReturnOrders();
            }
        } else {
            logger.info("Sale receipt not found for order with number - '{}'", orderDocument.getOrderNumber());
            statusForException = "warehouse.internet.order.document.status.in_work";

            if (orderDocument.getStatusOrder().equals(OrderStatus.READY_FOR_DELIVERY.getOnecId())) {
                logger.info("Order document in 'confirm' status");
                statusForException = "warehouse.internet.order.document.status.confirm";
            } else if (orderDocument.getStatusOrder().equals(OrderStatus.TO_DISBANDED.getOnecId())) {
                logger.info("Order document in 'not active' status");
                statusForException = "warehouse.internet.order.document.status.not_active";
                receiptStatusException = "warehouse.internet.order.return.order.screen.error.massage.without_receipt_sale";
            }

            List<String> params = new ArrayList<>();
            params.add(orderDocument.getOrderNumber().trim());
            params.add(statusForException);
            params.add(receiptStatusException);
            throw new ExceptionWithParameters("warehouse.internet.order.return.order.screen.error.massage.this_order_has_not_been_issued_or_does_not_exist", params);
        }
    }

    private List<OrderModel> getAllLocalReturnOrders() {
        List<OrderModel> returnOrders = databaseService.getAllReturnedOrders()
                .parallelStream()
                .map(OrderModelMapper::map)
                .collect(Collectors.toList());
        logger.info("Return '{}' local returned orders", returnOrders.size());

        return returnOrders;
    }

    @Transactional
    public List<String> returnOrderComplete() throws Exception {
        logger.info("Order returning complete started.");
        List<ReturnedOrderLocalDocument> returnedOrderLocalDocuments = databaseService.getAllReturnedOrders();
        logger.info("Order returning complete found '{}' local orders.", returnedOrderLocalDocuments.size());
        List<OrderDocument> orderOrderDocuments = onecService.getOrderDocumentsByOrderNumberList(
                returnedOrderLocalDocuments
                        .parallelStream()
                        .map(ReturnedOrderLocalDocument::getOrderNumber)
                        .collect(Collectors.toList())
        );
        logger.info("Order returning complete found '{}' orders from 1c.", orderOrderDocuments.size());
        List<String> iddocs = new ArrayList<>();

        for (OrderDocument orderDocument : orderOrderDocuments) {
            String journalIdDoc = createReceiptAndJournal(orderDocument, Boolean.TRUE, OrderNumberHelper.getReturnReceiptWithIdOrder(orderDocument.getOrderNumber()));
            iddocs.add(journalIdDoc);
            onecService.addOnecSrcDoc(onecService.getJournal(journalIdDoc), orderDocument.getJournal().getIdocdef(), orderDocument.getIdDoc());
            logger.info(
                    "Created 1SCRDOC row with childJournal idDoc: '{}', parentIdDocRef: '{}' and parentIdDoc: '{}'",
                    journalIdDoc,
                    orderDocument.getJournal().getIdocdef(),
                    orderDocument.getIdDoc()
            );
        }
        List<ReceiptOrdersList> ordersList = orderOrderDocuments.parallelStream()
                .map(e -> new ReceiptOrdersList(e.getOrderNumber(),
                        new SimpleDateFormat("dd.MM.yyyy").format(e.getDateCreated())
                ))
                .collect(Collectors.toList());

        Warehouse warehouse = onecService.getWarehouseById(orderOrderDocuments.get(0).getWarehouse());
        ReceiptOrdersModel receiptOrdersModel = ReceiptOrdersModelMapper.map(
                String.valueOf(orderOrderDocuments.size()),
                ordersList,
                orderOrderDocuments.stream().findFirst().get().getTk().trim(),
                String.format(
                        "%s %s",
                        warehouse.getName().trim(),
                        warehouse.getAddress().trim()
                ));

        printService.createReceiptReturnOrders(receiptOrdersModel);

        databaseService.clearAllReturn();

        return iddocs;
    }

    public OrderPackageModel changePackages(OrderPackageModel packagesCount) throws Exception {
        logger.info("Try to change count of packages in: '{}' order", packagesCount.getOrderNumber());
        List<OrderPackage> orderPackages = databaseService.findAllPackageByOrderNumber(packagesCount.getOrderNumber());

        if (orderPackages.size() == 0) {
            for (OrderPackageItemModel orderPackageItemModel : packagesCount.getPackagesList()) {
                orderPackages.add(OrderPackageMapper.map(orderPackageItemModel, packagesCount.getOrderNumber()));
            }
            databaseService.saveAllPackage(orderPackages);
            logger.info("Order packages not found by orderNumber: '{}'. \nNow packages created with small: '{}', medium: '{}' and large: '{}'",
                    packagesCount.getOrderNumber(),
                    0,
                    0,
                    0
            );
        } else {
            for (OrderPackageItemModel orderPackageItemModel : packagesCount.getPackagesList()) {
                OrderPackage orderPackage = databaseService.findByOrderNumberAndIdd(packagesCount.getOrderNumber(), orderPackageItemModel.getIdd());

                if (Objects.isNull(orderPackage)) {
                    logger.info("Order package with orderNumber: '{}' and idd: '{}' not found", packagesCount.getOrderNumber(), orderPackageItemModel.getIdd());
                    throw new Exception("warehouse.internet.order.collect.orders.packages.not_fount_package");
                }
                if (!orderPackageItemModel.getQuantity().equals(orderPackage.getPackageQuantity().toString())) {
                    orderPackage.setPackageQuantity(BigDecimal.valueOf(Long.parseLong(orderPackageItemModel.getQuantity())));
                    databaseService.savePackage(orderPackage);
                    logger.info("Order package update quantity to: '{}' success", orderPackage.getPackageQuantity());
                }
            }

            packagesCount.getPackagesList().sort(Comparator.comparing(OrderPackageItemModel::getLineNo));
            logger.info("Order packages updated with small: '{}', medium: '{}' and large: '{}' in orderNumber: '{}'",
                    packagesCount.getPackagesList().get(0).getQuantity(),
                    packagesCount.getPackagesList().get(1).getQuantity(),
                    packagesCount.getPackagesList().get(2).getQuantity(),
                    packagesCount.getOrderNumber()
            );
        }
        packagesCount.getPackagesList().sort(Comparator.comparing(OrderPackageItemModel::getLineNo));

        return packagesCount;
    }

    public OrderPackageModel getOrderPackagesCount(String orderNumber) throws Exception {
        logger.info("Try to get count of order packages by: '{}' order", orderNumber);
        List<OrderPackage> orderPackages = databaseService.findAllPackageByOrderNumber(orderNumber);
        OrderLocalDocument orderLocalDocument = databaseService.findOrderDocumentByOrderNumber(orderNumber);

        if (Objects.isNull(orderLocalDocument)) {
            logger.info("Current orderNumber is not contained in any order");
            throw new Exception("warehouse.internet.order.collect.orders.packages.not_fount_orderNumber");
        }
        if (orderPackages.size() == 0) {
            orderPackages = new ArrayList<>();

            for (PackageIdd packageIdd : PackageIdd.values()) {
                orderPackages.add(OrderPackageMapper.map(packageIdd, orderNumber, BigDecimal.ZERO));
            }
            databaseService.saveAllPackage(orderPackages);
            logger.info("Order packages not found by orderNumber: '{}'. \nNow packages created with small: '0', medium: '0' and large: '0'", orderNumber);
        }

        logger.info("Order package row return: '{}' small, '{}' medium and '{}' large packages", 0, 0, 0);
        //orderPackage.getPackageSmall(), orderPackage.getPackageMedium(), orderPackage.getPackageLarge());

        return new OrderPackageModel(
                orderNumber,
                orderPackages.parallelStream()
                        .map(OrderPackageItemModelMapper::map)
                        .sorted(Comparator.comparing(OrderPackageItemModel::getLineNo))
                        .collect(Collectors.toList())
        );
    }

    @Transactional
    public WriteOffDocument createWriteOffDocument(String orderNumber) throws Exception {
        logger.info("Try to create WriteOff document for packages for orderNumber: '{}'", orderNumber);
        String idd = iddGeneratingService.getNewIdd();

        if (Objects.isNull(idd)) {
            logger.info("Idd generator not return new Idd");
            throw new Exception("idd.generate.error");
        }

        logger.info("Try to create IdDoc");
        String idDoc = onecSystemComponent.getIddoc();

        if (Objects.isNull(idDoc)) {
            logger.info("IdDoc generator not return new IdDoc");
            throw new Exception("idDoc.generate.error");
        }

        OrderLocalDocument orderLocalDocument = databaseService.findOrderDocumentByOrderNumber(orderNumber);
        OrderDocument orderDocument = onecService.getOrderDocumentByOrderNumber(orderNumber);

        if (Objects.isNull(orderDocument)) {
            logger.info("Order document with orderNumber: '{}' not found in oneC", orderNumber);
            throw new Exception("warehouse.internet.order.document.finish_issuing_orders.exception.document_not_found_in_onec");
        }

        logger.info("OrderDocument found with: '{}'", orderDocument.getIdDoc());

        if (Objects.isNull(orderLocalDocument)) {
            logger.info("Order document with orderNumber: '{}' not found in local base", orderNumber);
            throw new Exception("warehouse.internet.order.document.finish_issuing_orders.exception.document_not_found");
        }

        logger.info("OrderLocalDocument found with: '{}'", orderLocalDocument.getIdd());
        logger.info("Start creating WriteOffDocument journal");
        Journal journal = JournalMapper.map(idd, idDoc, orderLocalDocument.getFirm(), 1);
        logger.info("Continue creating WriteOffDocument journal with journalComponent.setReferences service");
        journal = journalComponent.setReferences(journal, "Списание");
        logger.info("WriteOffDocument journal created with idd: '{}', and idDoc: '{}'", journal.getIdd(), journal.getIdoc());
        onecService.addJournal(journal);
        WriteOffDocument writeOffDocument = WriteOffDocumentMapper.map(idDoc, orderDocument);
        List<WriteOffDocumentItem> writeOffDocumentItemList = getPackageModel(idDoc, orderDocument);
        writeOffDocument.setItems(writeOffDocumentItemList);
        onecService.addWriteOffDocument(writeOffDocument);
        logger.info("WriteOff document created bu orderNumber: '{}' and idDoc: '{}'", orderDocument.getOrderNumber(), idDoc);

        return writeOffDocument;
    }

    public List<WriteOffDocumentItem> getPackageModel(String idDoc, OrderDocument orderDocument) {
        logger.info("Creating package model for WriteOff document items");
        List<WriteOffDocumentItem> writeOffDocumentItemList = new ArrayList<>();
        List<OrderPackage> orderPackages = databaseService.findAllPackageByOrderNumber(orderDocument.getOrderNumber());

        for (OrderPackage orderPackage : orderPackages) {
            if (orderPackage.getPackageQuantity().intValue() > 0) {
                ProductInfo productInfo = onecService.searchProduct(orderPackage.getPackageIdd());
                BigDecimal price = onecService.getPrice(productInfo.getId(), Date.from(Instant.now()));
                writeOffDocumentItemList.add(WriteOffDocumentItemMapper.map(orderPackage, idDoc, orderDocument, productInfo, price));
            }
        }

        return writeOffDocumentItemList;
    }

    @Transactional
    public void writeStockBalance(WriteOffDocument writeOffDocument, OrderLocalDocument orderDocument) throws Exception {
        logger.info("Start create write stock balance for order document: '{}' with writeOff document: '{}'",
                orderDocument.getOrderNumber(),
                writeOffDocument.getIdDoc()
        );
        List<StockBalanceTMC> stockBalanceTMCs = new ArrayList<>();
        List<StockBalanceTMCItem> stockBalanceTMCItems = new ArrayList<>();
        List<OrderPackage> orderPackages = databaseService.findAllPackageByOrderNumber(orderDocument.getOrderNumber());

        if (orderPackages.isEmpty()) {
            logger.info("Not found rows for packages in local base by document orderNumber: '{}'", orderDocument.getOrderNumber());
            throw new Exception("warehouse.internet.order.collect.orders.packages.not_fount_package");
        }

        int actionNumber = 1;

        for (OrderPackage orderPackage : orderPackages.parallelStream()
                .filter(x -> x.getPackageQuantity().intValue() > 0)
                .collect(Collectors.toList())
        ) {
            ProductInfo productInfo = onecService.searchProduct(orderPackage.getPackageIdd());

            if (Objects.isNull(productInfo)) {
                logger.info("Not found information about packages in oneC");
                throw new Exception("warehouse.internet.order.collect.orders.packages.not_fount_package_in_onec");
            }

            BigDecimal price = onecService.getPrice(productInfo.getId(), Date.from(Instant.now()));

            if (Objects.isNull(price)) {
                logger.info("Not found information about price for packages in oneC");
                throw new Exception("product.information.price.not.found.error");
            }

            stockBalanceTMCs.add(
                    StockBalanceTMCMapper.map(
                            orderDocument.getFirm(),
                            orderDocument.getWarehouse(),
                            BigDecimal.valueOf(orderPackage.getPackageQuantity().intValue()),
                            productInfo.getId(),
                            writeOffDocument.getDateCreated()
                    )
            );
            stockBalanceTMCItems.add(
                    StockBalanceTMCItemMapper.map(
                            Arrays.stream(PackageIdd.values()).parallel().filter(e -> e.getIdd().equals(orderPackage.getPackageIdd()))
                                    .map(PackageIdd::getLineNo).findFirst().orElse(0),
                            actionNumber,
                            writeOffDocument.getIdDoc(),
                            orderDocument.getWarehouse(),
                            orderDocument.getFirm(),
                            productInfo.getId(),
                            BigDecimal.valueOf(orderPackage.getPackageQuantity().intValue()),
                            price.multiply(orderPackage.getPackageQuantity()),
                            "01",
                            1
                    )
            );
            actionNumber++;
        }
        logger.info("Created stockBalanceTMCs list with: '{}' rows and StockBalanceTMCItems with: '{}' rows",
                stockBalanceTMCs.size(),
                stockBalanceTMCItems.size()
        );
        onecService.updateStockBalanceTMC(stockBalanceTMCs);
        onecService.writeStockBalanceTMCItems(stockBalanceTMCItems, writeOffDocument.getDateCreated());
    }

    @Transactional
    public void acceptLocalDocument(OrderDocument orderDocument, OrderStatus statusOrder) throws Exception {
        logger.info(
                "Creating local document  with orderNumber: '{}' and with statusOrder: '{}', because he is not found in local base",
                orderDocument.getOrderNumber(),
                statusOrder
        );

        String firm = onecService.getFirmByWarehouse(orderDocument.getWarehouse()).getId();

        if (Objects.isNull(firm)) {
            logger.info("Firm not found in OneC");
            throw new Exception("product.firm.not.found");
        }

        OrderLocalDocument orderLocalDocument = DocumentMapper.map(orderDocument, "", firm, statusOrder);
        orderLocalDocument.setQuantityFact(orderDocument.getQuantityFact());
        orderLocalDocument.setSum(orderDocument.getSum());
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderDocumentItem orderDocumentItem : orderDocument.getItems()) {
            OrderItem orderItem = OrderItemMapper.map(orderDocumentItem, orderDocument.getJournal().getIdd());
            orderItem.setQuantityFact(orderDocumentItem.getQuantityFact().intValue());
            orderItem.setSum(orderDocumentItem.getSum());
            orderItems.add(orderItem);
        }

        databaseService.addDocument(orderLocalDocument);
        logger.info(
                "Saved local document from orderNumber: '{}'",
                orderLocalDocument.getOrderNumber()
        );
        databaseService.saveOrderItemsList(orderItems);
        logger.info(
                "Saved '{}' order items for orderNumber: '{}'",
                orderItems.size(),
                orderLocalDocument.getOrderNumber()
        );
    }

    @Transactional
    public void reasonAbsence(String documentIdd, String orderItemId, ReasonAbsence reason) throws Exception {
        logger.info(
                "Set reason absence for product with orderId:'{}', productId:'{}', reason:'{}'.",
                documentIdd,
                orderItemId,
                reason
        );

        OrderItem orderItem = databaseService.findOrderItemByIdAndDocumentIdd(
                UUID.fromString(orderItemId),
                documentIdd
        );

        if (Objects.isNull(orderItem)) {
            logger.info("Product not found in local DB.");
            throw new Exception("warehouse.internet.order.item.reason.absence.product_not_found");
        }

        orderItem.setMarks(reason.getValue());
        databaseService.updateOrderItem(orderItem);
    }

    public OrderViewPositionModel getOrderViewPosition(String orderItemId, String documentIdd) throws Exception {
        logger.info("Start getting order view position");
        OrderViewPositionModel orderViewPositionModel;
        OrderLocalDocument orderLocalDocument = databaseService.getDocumentByIdd(documentIdd);

        if (Objects.isNull(orderLocalDocument)) {
            logger.info("Local document by idd: '{}' not found", documentIdd);
        }

        boolean userCanEnter = false;

        for (OrderItem orderItem : orderLocalDocument.getOrderItems()) {
            if (!Objects.equals(orderItem.getQuantity(), orderItem.getQuantityFact())) {
                userCanEnter = true;
                break;
            }
        }

        OrderItem orderItem;

        if (!Strings.isNullOrEmpty(orderItemId)) {
            orderItem = databaseService.findOrderItemByIdAndDocumentIdd(
                    UUID.fromString(orderItemId),
                    documentIdd
            );
        } else {
            orderItem = orderLocalDocument.getOrderItems().parallelStream()
                    .min(Comparator.comparing(OrderItem::getId))
                    .orElse(null);
        }
        if (Objects.isNull(orderItem)) {
            logger.info("Can not find orderItem in local db");
            throw new Exception("product.information.error");
        }

        ProductInfo productInfo = onecService.searchProduct(orderItem.getBarcode());

        if (Objects.isNull(productInfo)) {
            logger.info("Can not find orderItem in OneC");
            throw new Exception("product.information.error");
        }

        orderViewPositionModel = OrderViewPositionModelMapper.map(orderItem, productInfo.getBarcode(), userCanEnter);
        setLinksForOrderViewPositionModel(orderViewPositionModel, documentIdd);

        for (ReasonAbsence reason : ReasonAbsence.values()) {
            if (reason.getValue().equals(orderItem.getMarks())) {
                orderViewPositionModel.setShowReasonForAbsence(true);
                logger.info("Order item with absence");
                break;
            }
        }

        return orderViewPositionModel;
    }

    private OrderViewPositionModel setLinksForOrderViewPositionModel(OrderViewPositionModel orderViewPositionModel,
                                                                     String documentIdd) throws Exception {
        logger.info(
                "Start set links for buttons for order view position for orderItem id: '{}' in document idd: '{}'",
                orderViewPositionModel.getId(),
                documentIdd
        );
        List<String> orderItems = databaseService.getItemsInOrder(documentIdd)
                .parallelStream()
                .map(OrderItemListing::getId)
                .sorted()
                .collect(Collectors.toList());
        logger.info("Order item return: '{}' string rows from local db", orderItems.size());
        OrderItem orderItem = databaseService.findOrderItemByIdAndDocumentIdd(
                UUID.fromString(orderViewPositionModel.getId()),
                documentIdd
        );

        if (Objects.isNull(orderItem)) {
            logger.info("Can not find orderItem in local db");
            throw new Exception("product.information.error");
        }

        logger.info("Current order item with: '{}' id", orderItem.getId());
        orderItems.parallelStream()
                .filter(item -> item.equals(orderItem.getId().toString()))
                .findFirst()
                .ifPresent(matchedItem -> {
                    int index = orderItems.indexOf(matchedItem);

                    if (index - 1 >= 0) {
                        orderViewPositionModel.setLinkForward(orderItems.get(index - 1));
                    }
                    if (index + 1 <= orderItems.size() - 1) {
                        orderViewPositionModel.setLinkBack(orderItems.get(index + 1));
                    }
                });
        logger.info(
                "For linkBack set: '{}' id and for linkForward set: '{}' id. NULL is ok value",
                orderViewPositionModel.getLinkBack(),
                orderViewPositionModel.getLinkForward()
        );

        return orderViewPositionModel;
    }

    OrderStatus getStatusFrom1c(OrderDocument orderDocument) {
        OrderStatus status = null;

        switch (orderDocument.getStatusOrder().trim()) {
            case "1":
                status = OrderStatus.NEW;
                break;
            case "2":
                List<OrderClosureDocument> orderClosureDocuments = onecService.findOrderClosureDocumentByBasisContaining(
                        orderDocument.getIdDoc()
                );

                if (orderClosureDocuments.size() > 0) {
                    status = OrderStatus.DISBANDED;
                } else {
                    status = OrderStatus.TO_DISBANDED;
                }

                break;
            case "3":
                if (
                        (orderDocument.getJournal().getPmm() == 0)
                                || (orderDocument.getJournal().getPmm() == 5
                                && (orderDocument.getQuantity().intValue() < orderDocument.getQuantityFact().intValue()))
                ) {
                    status = OrderStatus.READY_FOR_DELIVERY;
                }

                if (orderDocument.getJournal().getPmm() == 1) {
                    Receipt saleReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getSaleReceiptWithoutIdOrder(orderDocument.getOrderNumber()));
                    Receipt returnReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getReturnReceiptWithoutIdOrder(orderDocument.getOrderNumber()));

                    if (Objects.isNull(saleReceipt)) {
                        saleReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getSaleReceiptWithIdOrder(orderDocument.getOrderNumber().trim()));
                    }
                    if (Objects.nonNull(saleReceipt)) {
                        status = OrderStatus.ISSUED_TO_COURIER;
                    }
                    if (Objects.isNull(returnReceipt)) {
                        returnReceipt = onecService.findReceiptDocBasisContainingAndByJournalIdd(orderDocument.getIdDoc(), OrderNumberHelper.getReturnReceiptWithoutIdOrder(orderDocument.getOrderNumber()));
                    }
                    if (Objects.nonNull(returnReceipt)) {
                        status = OrderStatus.RETURNED_TK;
                    }
                }
                break;
            case "4":
                status = OrderStatus.IN_WORK;
                break;
        }

        return status;
    }
}
