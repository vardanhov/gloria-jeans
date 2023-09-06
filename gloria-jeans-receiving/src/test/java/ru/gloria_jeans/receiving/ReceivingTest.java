package ru.gloria_jeans.receiving;

import com.google.common.io.Files;
import org.apache.commons.compress.utils.Charsets;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MSSQLServerContainer;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentModelType;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentStatus;
import ru.gloria_jeans.core.v1.receiving.models.request.AcceptanceBox;
import ru.gloria_jeans.core.v1.receiving.models.request.AcceptanceLot;
import ru.gloria_jeans.core.v1.receiving.models.request.AcceptanceProduct;
import ru.gloria_jeans.core.v1.receiving.models.request.SearchingDocuments;
import ru.gloria_jeans.core.v1.receiving.models.response.DocumentResultSearchListModel;
import ru.gloria_jeans.core.v1.receiving.models.response.MovingDocumentModel;
import ru.gloria_jeans.core.v1.receiving.models.response.ProductModel;
import ru.gloria_jeans.onecdbmapper.dao.model.Tnved;
import ru.gloria_jeans.receiving.controller.ReceivingController;
import ru.gloria_jeans.receiving.dao.model.OpenLot;
import ru.gloria_jeans.receiving.dao.model.Product;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;
import ru.gloria_jeans.receiving.dao.repository.ProductISRepository;
import ru.gloria_jeans.receiving.services.DatabaseService;
import ru.gloria_jeans.receiving.services.MarksServiceReceiving;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceivingTest {

    private String documentId;
    private String documentVendor;
    private String boxBarcode;
    private String boxBarcodeWithAcceptedDocument;
    private String productMagnet;
    private String productHandleSearch;
    private String productLotHandleSearch;
    private String dateFrom;
    private String dateTo;
    private AcceptanceProduct acceptanceProduct;

    @Autowired
    private ReceivingController receivingController;
    @Autowired
    private MarksServiceReceiving marksServiceReceiving;
    @Autowired
    private DatabaseService databaseService;

    @Before
    public void setUp() {
        documentId = "00006040002042293";
        documentVendor = "PM06040169";
        boxBarcode = "3060400003099";
        boxBarcodeWithAcceptedDocument = "3164800003313";
        productMagnet = "Магнит 03929 пластик черный \"Противокражный\" 42х48мм";
        productHandleSearch = "GKT009094F0001";
        productLotHandleSearch = "GTN002712F0015";
        dateFrom = "01.01.2000";
        dateTo = "01.01.2030";
        acceptanceProduct = new AcceptanceProduct(
                documentId,
                boxBarcode,
                productHandleSearch,
                "",
                false,
                0
        );
    }

    @ClassRule
    public static MSSQLServerContainer MSSQLContainerLocal = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2019-latest")
            .acceptLicense()
            .withInitScript("db/init_local.sql");

    @ClassRule
    public static MSSQLServerContainer mssqlserver = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2019-latest") //2019
            .acceptLicense()
            .withInitScript("db/init_external.sql");
    @Autowired
    private ProductISRepository productISRepository;

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        Supplier<Object> jdbcUrlSupplier = () -> String.format("%s;%s", mssqlserver.getJdbcUrl(), "databaseName=Main");
        registry.add("spring.datasource-onec-database.jdbcUrl", jdbcUrlSupplier);
        registry.add("spring.datasource-onec-database.username", mssqlserver::getUsername);
        registry.add("spring.datasource-onec-database.password", mssqlserver::getPassword);

        Supplier<Object> jdbcUrlSupplierInternal = () -> String.format("%s;%s", MSSQLContainerLocal.getJdbcUrl(), "databaseName=gj_warehouse");
        registry.add("spring.datasource-internal-database.jdbcUrl", jdbcUrlSupplierInternal);
        registry.add("spring.datasource-internal-database.username", MSSQLContainerLocal::getUsername);
        registry.add("spring.datasource-internal-database.password", MSSQLContainerLocal::getPassword);
    }

    @AfterAll
    public static void afterAll() {
        mssqlserver.stop();
        MSSQLContainerLocal.stop();
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/search_document-onec.sql"},
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
    public void testSearchDocument() {
        List<String> statuses = new ArrayList<>();
        SearchingDocuments searchingDocuments = new SearchingDocuments("", dateFrom, dateTo, statuses);
        DocumentResultSearchListModel request = receivingController.searchDocument(searchingDocuments);
        Assert.assertEquals(3, request.getDocumentResultSearchModels().size());
        //idd
        searchingDocuments = new SearchingDocuments(documentId, "", "", statuses);
        request = receivingController.searchDocument(searchingDocuments);
        Assert.assertEquals(1, request.getDocumentResultSearchModels().size());
        Assert.assertEquals(documentId, request.getDocumentResultSearchModels().get(0).getIdd());
        //vendor
        searchingDocuments = new SearchingDocuments(documentVendor, "", "", statuses);
        request = receivingController.searchDocument(searchingDocuments);
        Assert.assertEquals(1, request.getDocumentResultSearchModels().size());
        //barcode
        statuses.add(MovingDocumentStatus.NEW.getLocale());
        searchingDocuments = new SearchingDocuments("", dateFrom, dateTo, statuses);
        request = receivingController.searchDocument(searchingDocuments);
        Assert.assertEquals(3, request.getDocumentResultSearchModels().size());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_box-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_box-local.sql"},
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
    public void testAcceptanceBox() {
        AcceptanceBox acceptanceBox = new AcceptanceBox(boxBarcode, "");
        MovingDocumentModel request = receivingController.acceptanceBox(acceptanceBox);
        Assert.assertFalse(request.getResponseException());
        Assert.assertNotNull(request);
        Assert.assertEquals(documentId, request.getId());
        Assert.assertEquals(2, request.getProductModels().size());
        Assert.assertEquals(0, request.getProductModels().get(0).getCountFact().intValue());
        Assert.assertEquals("115.00", request.getProductModels().get(1).getPrice().toString());

        acceptanceBox = new AcceptanceBox(boxBarcodeWithAcceptedDocument, "");
        request = receivingController.acceptanceBox(acceptanceBox);
        Assert.assertTrue(request.getResponseException());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_product-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_box-local.sql"},
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
    @Transactional
    public void testAcceptanceProduct() {
        MovingDocumentModel movingDocumentModel = receivingController.acceptanceProduct(acceptanceProduct);
        Assert.assertFalse(movingDocumentModel.getResponseException());
        List<ProductModel> products = movingDocumentModel.getProductModels();
        ProductModel product = products.get(2);
        Assert.assertEquals(productHandleSearch, product.getVendorCode());
        Assert.assertEquals(MovingDocumentModelType.PRODUCT, movingDocumentModel.getType());
        Assert.assertEquals(new BigDecimal(124), product.getPrice());
        Product productFromDb = productISRepository.findById(UUID.fromString(product.getId())).get();
        Assert.assertNotNull(productFromDb);
        Assert.assertEquals(1, productFromDb.getQuantityFact().intValue());
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_product_lot-onec.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(dataSource = "onecDataSource", transactionManager = "onecTransactionManager")
    )
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_box-local.sql"},
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
    @Transactional
    public void testAcceptanceProductLot() {
        acceptanceProduct = new AcceptanceProduct(documentId, boxBarcode, productLotHandleSearch, "", false, 0);
        MovingDocumentModel movingDocumentModel = receivingController.acceptanceProduct(acceptanceProduct);
        Assert.assertFalse(movingDocumentModel.getResponseException());
        List<ProductModel> products = movingDocumentModel.getProductModels();
        ProductModel product = products.get(2);
        Assert.assertEquals(MovingDocumentModelType.LOT, movingDocumentModel.getType());
        Assert.assertTrue(product.isLot());
    }

    @Test
    public void testGenerateXmlUpd() throws Exception {
        List<Tnved> tnveds = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            String idd = String.format("00000000000%s", i);
            Product product = new Product();
            product.setSum(new BigDecimal(i * 10));
            product.setVat(new BigDecimal(i));
            product.setQuantityFact(i);
            product.setFullName(String.format("Блузка %s трикотаж черный XXS/164", i));
            product.setLineNumber(i);
            product.setPrice(new BigDecimal(i * 1000));
            product.setIdd(idd);
            product.setBarcode(idd);

            for (int j = 0; j < 9; j++) {
                ScannedMark scannedMark = new ScannedMark();
                scannedMark.setValidMark(true);
                scannedMark.setDataMatrix(String.format("%sTTT0000000%s%s", idd, i, j));
                product.getScannedMarks().add(scannedMark);
            }

            products.add(product);
            Tnved tnved = new Tnved();
            tnved.setCode(idd);
            tnved.setDescr(String.format("61062000%s", i));
            tnveds.add(tnved);
        }

        String xml = marksServiceReceiving.generateXmlUpd(
                "fileName",
                LocalDateTime.of(2023, 6, 28, 12, 19, 1),
                "receivingEdm",
                "firmEdm",
                "denominationDocument", //НаимДокОпр
                "denominationFirm", //НаименованиеФирма
                "function", //Функ
                LocalDateTime.of(2023, 6, 28, 12, 19, 1).toInstant(ZoneOffset.UTC),
                "documentNumber", //НомерСчф
                "firmTin", //ИННФирма
                "warehouseFirmRrc", //КППФирма
                "legalAddress", //АдресФирма
                "warehouseAddress", //АдресСклад
                "warehouseFirmTin", //ИННФирмаПолучатель
                "denominationReceivingFirm", //НаименованиеФирмаПолучатель
                "warehouseReceivingAddress", //АдресСкладПолучатель
                "firmReceivingRcc", //КППФирмаПолучатель
                "firmReceivingAddress",  //АдресФирмаПолучатель
                "contract", //Договор
                "commissionUtd", //КомиссионныйУПД
                products,
                tnveds
        );

        Charset charset = Charset.forName("CP1251");
        String xmlCP1251 = new String(xml.getBytes(charset), charset);
        System.out.printf("Generated XML (UTF-8):\r\n'%s'\r\n---------------END UTF-8\r\n", xml);
        System.out.printf("Generated XML (CP-1251):\r\n'%s'\r\n---------------END CP1251\r\n", xmlCP1251);

        String xmlFromFile = Files.readLines(
                        new File(Objects.requireNonNull(getClass().getClassLoader().getResource("sbis.xml")).toURI()),
                        Charsets.toCharset("cp1251")
                )
                .parallelStream()
                .collect(Collectors.joining());
        Assert.assertEquals(xmlFromFile, xmlCP1251.replace("\n", ""));
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_lot-onec.sql"},
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
    public void testAcceptanceLot() {
        receivingController.getDocument("00002780081106691");
        receivingController.acceptanceBox(new AcceptanceBox("0010803041844", ""));
        for (int i = 0; i < 4; i++) {
            //Сканируем лот
            var lot = receivingController.acceptanceProduct(
                    new AcceptanceProduct(
                            "00002780081106691",
                            "0010803041844",
                            "",
                            "4680199065330",
                            false,
                            null
                    )
            );
            //Открываем лот
            receivingController.acceptanceLot(
                    new AcceptanceLot(
                            lot.getId(),
                            "0010803041844",
                            "",
                            "",
                            lot.getLotId(),
                            lot.getLineNumberLot()
                    )
            );
            for (int z = 0; z < 3; z++) {
                //Сканируем товар в лот
                receivingController.acceptanceLot(
                        new AcceptanceLot(
                                lot.getId(),
                                "0010803041844",
                                "",
                                "4680199060151",
                                lot.getLotId(),
                                lot.getLineNumberLot()
                        )
                );
            }
        }

        List<Product> products = databaseService.getProductsByBarcode("4680199065330");
        int quantityAllLots = products.parallelStream()
                .mapToInt(Product::getQuantity)
                .sum();
        int quantityFactAllLots = products.parallelStream()
                .mapToInt(Product::getQuantityFact)
                .sum();

        List<OpenLot> openLots = databaseService.getOpenLots(
                "00002780081106691",
                "00044040000202987"
        );

        int quantityAllOpenLots = openLots.parallelStream()
                .mapToInt(OpenLot::getQuantity)
                .sum();
        int quantityFactAllOpenLots = openLots.parallelStream()
                .mapToInt(OpenLot::getFactQuantity)
                .sum();

        Assert.assertEquals(2, quantityAllLots);
        Assert.assertEquals(4, quantityFactAllLots);
        Assert.assertEquals(12, quantityAllOpenLots);
        Assert.assertEquals(12, quantityFactAllOpenLots);
    }

    @Test
    @Sql(
            scripts = {"classpath:test_sql_scripts/acceptance_lot_into_lot-onec.sql"},
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
    public void testAcceptanceLotIntoLot() {
        receivingController.getDocument("00002780081106691");
        receivingController.acceptanceBox(new AcceptanceBox("0010803041844", ""));

        //Сканируем лот
        var lot = receivingController.acceptanceProduct(
                new AcceptanceProduct(
                        "00002780081106691",
                        "0010803041844",
                        "",
                        "4680199065330",
                        false,
                        null
                )
        );
        //Открываем лот
        receivingController.acceptanceLot(
                new AcceptanceLot(
                        lot.getId(),
                        "0010803041844",
                        "",
                        "",
                        lot.getLotId(),
                        lot.getLineNumberLot()
                )
        );
        //Сканируем лот в лот
        MovingDocumentModel response = receivingController.acceptanceLot(
                new AcceptanceLot(
                        lot.getId(),
                        "0010803041844",
                        "",
                        "4680199065330",
                        lot.getLotId(),
                        lot.getLineNumberLot()
                )
        );
        Assert.assertTrue(response.getResponseException());
        Assert.assertEquals("warehouse.supply.search.goods.open.lot.error", response.getResponseMessage());
    }
}
