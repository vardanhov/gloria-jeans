package ru.gloria_jeans.orders;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MSSQLServerContainer;
import ru.gloria_jeans.core.v1.orders.enums.ReasonAbsence;
import ru.gloria_jeans.core.v1.orders.enums.Tk;
import ru.gloria_jeans.core.v1.orders.model.request.*;
import ru.gloria_jeans.core.v1.orders.model.response.*;
import ru.gloria_jeans.onecdbmapper.dao.model.Journal;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.orders.controller.OrdersController;
import ru.gloria_jeans.orders.dao.enums.OrderStatus;
import ru.gloria_jeans.orders.dao.model.OrderItem;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;
import ru.gloria_jeans.orders.dao.repository.OrderDocumentISRepository;
import ru.gloria_jeans.orders.dao.repository.OrderItemISRepository;
import ru.gloria_jeans.orders.services.DatabaseService;
import ru.gloria_jeans.orders.services.IddGeneratingService;
import ru.gloria_jeans.orders.services.OnecService;
import ru.gloria_jeans.orders.utils.OrderNumberHelper;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@Import(value = OrdersApplicationTest.OrderApplicationTestConfiguration.class)
public class OrdersApplicationTest {
    @ClassRule
    public static MSSQLServerContainer MSSQLContainerLocal = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2019-latest")
            .acceptLicense()
            .withInitScript("db/init_local.sql");

    @ClassRule
    public static MSSQLServerContainer MSSQLContainerExternal = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2019-latest")
            .acceptLicense()
            .withInitScript("db/init_external.sql");

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        Supplier<Object> jdbcUrlSupplier = () -> String.format("%s;%s", MSSQLContainerExternal.getJdbcUrl(), "databaseName=Main");
        registry.add("spring.datasource-onec-database.jdbcUrl", jdbcUrlSupplier);
        registry.add("spring.datasource-onec-database.username", MSSQLContainerExternal::getUsername);
        registry.add("spring.datasource-onec-database.password", MSSQLContainerExternal::getPassword);

        Supplier<Object> jdbcUrlSupplierInternal = () -> String.format("%s;%s", MSSQLContainerLocal.getJdbcUrl(), "databaseName=gj_orders");
        registry.add("spring.datasource-internal-database.jdbcUrl", jdbcUrlSupplierInternal);
        registry.add("spring.datasource-internal-database.username", MSSQLContainerLocal::getUsername);
        registry.add("spring.datasource-internal-database.password", MSSQLContainerLocal::getPassword);

        try {
            String strPathToTmp = File.createTempFile("tmp", null).toPath().getParent().toString();
            Supplier<Object> pathToTmp = () -> strPathToTmp;
            registry.add("directory.printed.file:", pathToTmp);
        } catch (Exception e) {
            System.out.printf("Set property has been error %s", e.getMessage());
        }
    }

    @AfterAll
    public static void afterAll() {
        MSSQLContainerExternal.stop();
        MSSQLContainerLocal.stop();
    }

    @TestConfiguration
    public static class OrderApplicationTestConfiguration {
        @Primary
        @Bean
        public IddGeneratingService iddGeneratingServiceImpl() {
            return new IddGeneratingService("localhost") {
                @Override
                public String getNewIdd() {
                    return "9999999999990";
                }
            };
        }
    }

    @Autowired
    private OrdersController ordersController;

    @Autowired
    private OrderDocumentISRepository orderDocumentISRepository;

    @Autowired
    private OrderItemISRepository orderItemISRepository;

    @Autowired
    private OnecService onecService;

    @Autowired
    private DatabaseService databaseService;

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_orders-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testGetCollectOrders() {
        var response = ordersController.getCollectOrders();
        Assert.assertEquals(1, response.getOrderModels().parallelStream()
                .filter(x -> x.getOrderNumber().trim()
                        .equals("1025503207"))
                .collect(Collectors.toList())
                .size());
        boolean checkOrderStatus = response.getOrderModels().parallelStream()
                .map(e -> !e.getOrderStatus().equals(OrderStatus.NEW.getOnecId()))
                .findFirst()
                .isPresent();
        Assert.assertTrue(checkOrderStatus);
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_orders-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testCollectOrders() {
        List<OrderModel> orderListModel = ordersController.getCollectOrders().getOrderModels().parallelStream()
                .filter(x -> x.getOrderNumber().trim()
                        .equals("1025503207"))
                .collect(Collectors.toList());
        Assert.assertFalse(orderListModel.isEmpty());
        Assert.assertTrue(orderListModel.get(0).getOrderNumber().contains("1025503207"));
        Assert.assertEquals(OrderStatus.NEW.getLocale(), orderListModel.get(0).getOrderStatus());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/disbandment_order-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testDisbandmentOrder() {
        OrderDisbandment orderDisbandment = ordersController.orderDisbandment(new SearchingOrder("1025503207"));
        Assert.assertEquals("warehouse.internet.order.disbandment.order.unable.disband.sale.receipt.text", orderDisbandment.getScreenText());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/search_order-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testSearchOrder() {
        OrderDocumentModel searchOrder = ordersController.searchOrder(new SearchingOrder("1025503207"));
        Assert.assertNotNull(searchOrder);
        Assert.assertEquals("   73P   ", searchOrder.getShippingMethod());
        Assert.assertEquals("218F", searchOrder.getCollectorName().trim());
        Assert.assertEquals("warehouse.internet.order.document.status.in_work", searchOrder.getStatusOrder());

    }

    @Transactional
    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_collect-orders-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testGetCollectOrdersForDelivery() {
        var response = ordersController.getCollectOrdersForDelivery(Tk.CDEK.getName());
        Assert.assertEquals(1, response.getScannedDocumentModels().size());

    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_collect-orders-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_order_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testGetOrderDocument() {
        var response = ordersController.getOrderDocument("1025503207", "currentUserId", false);
        Assert.assertEquals("H0013611025503207", response.getIdd());
        Assert.assertEquals("1025503207", response.getOrderNumber().trim());
        Assert.assertEquals("currentUserId", response.getCurrentUserId());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear_position-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testClearFactPosition() {
        List<OrderItem> orderItems = (List<OrderItem>) orderItemISRepository.findAll();
        OrderItem item = orderItems.get(0);
        Assert.assertEquals(1, item.getQuantityFact().intValue());
        ordersController.clearFactPosition(item.getId().toString());
        item = ((List<OrderItem>) orderItemISRepository.findAll()).get(0);
        Assert.assertEquals(0, item.getQuantityFact().intValue());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_product-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testGetProduct() {
        OrderItem orderItem = ((List<OrderItem>) orderItemISRepository.findAll()).get(0);
        OrderDocumentItemModel orderDocumentItemModel = ordersController.getProduct(orderItem.getId().toString());
        Assert.assertEquals(2199, orderDocumentItemModel.getPrice().intValue());
        Assert.assertEquals(1, orderDocumentItemModel.getQuantityFact().intValue());
        Assert.assertEquals("SE5X", orderDocumentItemModel.getItem().trim());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/update_order_item-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testUpdateOrderItem() {
        AcceptanceOrderItem acceptanceOrderItem = new AcceptanceOrderItem();
        acceptanceOrderItem.setOrderNumber("1025503207");
        acceptanceOrderItem.setHandleSearch("BSU000192F0006");
        ordersController.acceptanceProduct(acceptanceOrderItem);
        OrderItem item = ((List<OrderItem>) orderItemISRepository.findAll()).get(0);
        UpdateOrderItem updateOrderItem = new UpdateOrderItem();
        updateOrderItem.setOrderItemId(item.getId().toString());
        updateOrderItem.setQuantityFact("1");
        Assert.assertEquals(1, item.getQuantityFact().intValue());
        ordersController.updateOrderItem(updateOrderItem);
        item = ((List<OrderItem>) orderItemISRepository.findAll()).get(0);
        Assert.assertEquals(1, item.getQuantityFact().intValue());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/update_order_item-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testDeleteProduct() {
        AcceptanceOrderItem acceptanceOrderItem = new AcceptanceOrderItem();
        acceptanceOrderItem.setOrderNumber("1025503207");
        acceptanceOrderItem.setHandleSearch("BSU000192F0006");
        ordersController.acceptanceProduct(acceptanceOrderItem);
        OrderItem item = ((List<OrderItem>) orderItemISRepository.findAll()).get(0);
        ordersController.deleteProduct(item.getId().toString());
        List<OrderItem> orderItems = (List<OrderItem>) orderItemISRepository.findAll();
        Assert.assertEquals(0, orderItems.size());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testAcceptanceDocument() {
        AcceptanceOrderItem acceptanceOrderItem = new AcceptanceOrderItem();
        acceptanceOrderItem.setOrderNumber("1025503207");
        acceptanceOrderItem.setHandleSearch("BSU000192F0006");
        ordersController.acceptanceProduct(acceptanceOrderItem);
        ordersController.acceptanceDocument(new ConfirmationDocumentModel("1025503207", "  2CR8", "10.10.2023"));
        OrderDocument orderDocument = onecService.getOrderDocumentByOrderNumber("1025503207");
        Assert.assertEquals(OrderStatus.READY_FOR_DELIVERY.getOnecId(), orderDocument.getStatusOrder());
        Journal journal = onecService.getJournal(orderDocument.getIdDoc());
        Assert.assertEquals(0, journal.getPmm());
        OrderLocalDocument orderLocalDocument = orderDocumentISRepository.findByOrderNumber("1025503207");
        Assert.assertEquals(OrderStatus.READY_FOR_DELIVERY, orderLocalDocument.getStatusOrder());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testReturnOrderWithNullHandleSearchAndScannerSearch() {
        OrderSearchModel orderSearchModel = new OrderSearchModel();
        var response = ordersController.returnOrder(orderSearchModel);
        Assert.assertNotNull(response.getResponseException());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testReturnOrderWithWrongBarcode() {
        OrderSearchModel orderSearchModel = new OrderSearchModel(null, "123");
        var response = ordersController.returnOrder(orderSearchModel);
        Assert.assertEquals(true, response.getResponseException());
        Assert.assertEquals("warehouse.internet.order.return.order.screen.error.massage.returning_order_not_found_document", response.getResponseMessage());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/return_order_with_null_receipt-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testReturnOrderWithWrongReceipt() {
        OrderSearchModel orderSearchModel = new OrderSearchModel(null, "1025503207");
        var response = ordersController.returnOrder(orderSearchModel);
        Assert.assertEquals(true, response.getResponseException());
        Assert.assertEquals("warehouse.internet.order.return.order.screen.error.massage.this_order_has_not_been_issued_or_does_not_exist", response.getResponseMessage());
    }


    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/return_order-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testCreateReturn() {
        OrderSearchModel orderSearchModel = new OrderSearchModel(null, "1025503207");
        var response = ordersController.returnOrder(orderSearchModel);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.getOrderModels().stream().findFirst().get().getOrderNumber().contains("1025503207"));
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testReasonAbsence() {

        AcceptanceOrderItem acceptanceOrderItem = new AcceptanceOrderItem();
        acceptanceOrderItem.setOrderNumber("1025503207");
        acceptanceOrderItem.setHandleSearch("BSU000192F0006");
        ordersController.acceptanceProduct(acceptanceOrderItem);
        OrderItem item = orderItemISRepository.findByDocumentIddAndIdd(
                "H0013611025503207",
                "00055550005187700"
        );

        var response = ordersController.reasonAbsence(
                item.getDocumentIdd(),
                item.getId().toString(),
                ReasonAbsence.DEFECT
        );
        Assert.assertFalse(response.getResponseException());
        item = orderItemISRepository.findByDocumentIddAndIdd(
                "H0013611025503207",
                "00055550005187700"
        );
        Assert.assertEquals(ReasonAbsence.DEFECT.getValue(), item.getMarks().trim());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_collect-orders-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testOrdersForDelivery() {
        var response = ordersController.getCollectOrdersForDelivery("cdek");
        Assert.assertEquals(
                "warehouse.internet.order.document.status.delivery.waiting_scan",
                response.getScannedDocumentModels().get(0).getOrderStatus()
        );
        Assert.assertNull(response.getResponseMessage());
        Assert.assertEquals("1025503207", response.getScannedDocumentModels().get(0).getOrderNumber());
        Assert.assertEquals(1, response.getScannedDocumentModels().size());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/get_collect-orders-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testOrdersForDeliveryWithTk() {

        var response = ordersController.getCollectOrdersForDelivery(Tk.CDEK.getName());
        Assert.assertEquals(
                "warehouse.internet.order.document.status.delivery.waiting_scan",
                response.getScannedDocumentModels().get(0).getOrderStatus()
        );
        Assert.assertNull(response.getResponseMessage());
        Assert.assertEquals("1025503207", response.getScannedDocumentModels().get(0).getOrderNumber());
        Assert.assertEquals(1, response.getScannedDocumentModels().size());
    }

    //TODO Not yet ready
    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/already_acceptance_delivery_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/already_acceptance_delivery_document-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testAlreadyAcceptanceDeliveryDocument() {
        OrderDocument orderDocument = onecService.getOrderByOrderNumber("1025503207");
        orderDocument.getJournal().setPmm(0);
        orderDocument.setStatusOrder(OrderStatus.READY_FOR_DELIVERY.getOnecId());
        onecService.saveOrderDocument(orderDocument);
        var response = ordersController.acceptanceDeliveryDocument(
                new AcceptanceDeliveryDocument(
                        "1025503207",
                        ""
                )
        );
        Assert.assertEquals(
                "warehouse.internet.order.document.status.delivery.order.already.issued",
                response.getResponseMessage()
        );
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/finish_issuing_orders-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/finish_issuing_orders-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testFinishIssuingOrders() {
        ordersController.getCollectOrders();
        OrderDocument orderDocument = onecService.getOrderByOrderNumber("1025503207");
        orderDocument.getJournal().setPmm(0);
        orderDocument.setStatusOrder(OrderStatus.READY_FOR_DELIVERY.getOnecId());
        onecService.saveOrderDocument(orderDocument);
        ordersController.acceptanceDeliveryDocument(
                new AcceptanceDeliveryDocument(
                        "1025503207",
                        ""
                )
        );
        ordersController.finishIssuingOrders(Tk.CDEK.getName());
        Journal saleReceiptJournal = onecService.getReceiptJournalByIdd(OrderNumberHelper.getSaleReceiptWithIdOrder(orderDocument.getOrderNumber()));
        var response = ordersController.getCollectOrdersForDelivery(Tk.CDEK.getName());
        Assert.assertEquals(
                "warehouse.internet.order.courier.delivery.not.found.documents",
                response.getResponseMessage()
        );
        Assert.assertNotNull(saleReceiptJournal);
        Assert.assertEquals(1, saleReceiptJournal.getPmm());
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/status_of_order.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testStatusOfOrder() {
        String orderNumber = "1024422481";
        OrderListModel responseOrderListModel = ordersController.getCollectOrders();
        Assert.assertFalse(responseOrderListModel.getResponseException());
        Assert.assertTrue(responseOrderListModel.getOrderModels().size() > 0);
        Assert.assertEquals(
                OrderStatus.NEW.getLocale(),
                responseOrderListModel.getOrderModels()
                        .parallelStream()
                        .filter(x -> x.getOrderNumber().trim().equals(orderNumber))
                        .findFirst()
                        .get()
                        .getOrderStatus()
        );
        OrderDocumentModel responseOrderDocumentModel = ordersController.getOrderDocument(
                orderNumber,
                "",
                null
        );
        Assert.assertFalse(responseOrderDocumentModel.getResponseException());
        Assert.assertEquals(
                OrderStatus.IN_WORK.getLocale(),
                orderDocumentISRepository.findByOrderNumber(orderNumber).getStatusOrder().getLocale()
        );
        responseOrderListModel = ordersController.getCollectOrders();
        Assert.assertFalse(responseOrderListModel.getResponseException());
        Assert.assertTrue(responseOrderListModel.getOrderModels().size() > 0);
        Assert.assertEquals(
                OrderStatus.IN_WORK.getLocale(),
                orderDocumentISRepository.findByOrderNumber(orderNumber).getStatusOrder().getLocale()
        );
    }

    @Test
    @Transactional
    @Sql(
            scripts = {"classpath:test_sql_scripts/confirmation_document-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/confirmation_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    public void testConfirmationDocument() {
        OrderDocumentAcceptance orderDocumentAcceptance = ordersController.acceptanceDocument(new ConfirmationDocumentModel("1023561877", "  205K   ", "10.10.2023"));
        Assert.assertFalse(orderDocumentAcceptance.getResponseException());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_double_order_item-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testAcceptingDoubleOrderItems() {
        AcceptanceOrderItem acceptanceOrderItem = new AcceptanceOrderItem();
        acceptanceOrderItem.setOrderNumber("1025503207");
        acceptanceOrderItem.setHandleSearch("BSU000192F0006");
        // Сканируем первый товар
        ordersController.acceptanceProduct(acceptanceOrderItem);
        // Сканируем второй товар
        ordersController.acceptanceProduct(acceptanceOrderItem);
        // Сканируем третий раз и ожидаем exception
        var response = ordersController.acceptanceProduct(acceptanceOrderItem);
        Assert.assertTrue(response.getResponseException());
        List<OrderItem> item = ((List<OrderItem>) orderItemISRepository.findAll());
        Assert.assertEquals(1, item.get(0).getQuantityFact().intValue());
        Assert.assertEquals(1, item.get(1).getQuantityFact().intValue());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_double_order_item-local.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-local.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "internalServiceDataSource", transactionManager = "internalServiceTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_document-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/clear-onec.sql"},
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    public void testAcceptingDoubleOrderItemsAssemblyByPictures() {
        AcceptanceOrderItem acceptanceOrderItem = new AcceptanceOrderItem();
        acceptanceOrderItem.setOrderNumber("1025503207");
        acceptanceOrderItem.setScannedSearch("BSU000192F0006");
        acceptanceOrderItem.setCurrentItemOrder("d0a14daa-9cbf-4378-8ad8-01f6cac1d71b");
        // Сканируем первый товар
        ordersController.acceptanceProduct(acceptanceOrderItem);
        // Сканируем второй товар
        acceptanceOrderItem.setCurrentItemOrder("fe6b3f0c-8245-4620-97f8-769499a61893");
        ordersController.acceptanceProduct(acceptanceOrderItem);
        // Сканируем третий раз и ожидаем exception
        var response = ordersController.acceptanceProduct(acceptanceOrderItem);
        Assert.assertTrue(response.getResponseException());
        List<OrderItem> item = ((List<OrderItem>) orderItemISRepository.findAll());
        Assert.assertEquals(1, item.get(0).getQuantityFact().intValue());
        Assert.assertEquals(1, item.get(1).getQuantityFact().intValue());
    }
}
