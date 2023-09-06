package ru.gloria_jeans.onecdbmapper;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.MSSQLServerContainer;
import ru.gloria_jeans.onecdbmapper.dao.component.*;
import ru.gloria_jeans.onecdbmapper.dao.enums.ProductType;
import ru.gloria_jeans.onecdbmapper.dao.enums.BanSaleProduct;
import ru.gloria_jeans.onecdbmapper.dao.enums.ShippingMethod;
import ru.gloria_jeans.onecdbmapper.dao.model.Currency;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.onecdbmapper.dao.repository.*;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.OnecMetaData;
import ru.gloria_jeans.onecdbmapper.mdparser.stream.CompoundParser;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class RepositoryTest {
    @Value("${onec.md.path}")
    private String PATH_TO_MD_FILE;
    @ClassRule
    public static MSSQLServerContainer mssqlserver = new MSSQLServerContainer<>("mcr.microsoft.com/mssql/server:2017-latest")
            .acceptLicense()
            .withInitScript("db/init.sql");
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private JournalComponent journalComponent;
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CurrencyComponent currencyComponent;
    @Autowired
    private MovingDocumentRepository movingDocumentRepository;
    @Autowired
    private AcceptanceDocumentRepository acceptanceDocumentRepository;
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private IddocRepository iddocRepository;
    @Autowired
    private UiddRepository uiddRepository;
    @Autowired
    private MismatchDocumentRepository mismatchDocumentRepository;
    @Autowired
    private PackageErrorContentsDocumentRepository packageErrorContentsDocumentRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PriceComponent priceComponent;
    @Autowired
    private MovingReasonRepository movingReasonRepository;
    @Autowired
    private OnecSrcdocComponent onecSrcdocComponent;
    @Autowired
    private LanguageComponent languageComponent;
    @Autowired
    private EmployeeComponent employeeComponent;
    @Autowired
    private StoreComponent storeComponent;
    @Autowired
    private TnvedRepository tnvedRepository;
    @Autowired
    private OnecSystemComponent onecSystemComponent;
    @Autowired
    private StockBalanceTMCRepository stockBalanceTMCRepository;
    @Autowired
    private StockBalanceTMCItemRepository stockBalanceTMCItemRepository;
    @Autowired
    private JdbcOnecUserRepository jdbcOnecUserRepository;
    @Autowired
    private JdbcOnecSystemRepository jdbcOnecSystemRepository;
    @Autowired
    private OrderDocumentRepository orderDocumentRepository;
    @Autowired
    private OrderClosureDocumentRepository orderClosureDocumentRepository;
    @Autowired
    private OrderClosureDocumentItemRepository orderClosureDocumentItemRepository;
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private RouteListRepository routeListRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductComponent productComponent;
    @Autowired
    private SalesBanDocumentRepository salesBanDocumentRepository;
    @Autowired
    private SalesBanDocumentItemRepository salesBanDocumentItemRepository;
    @Autowired
    private DnLockComponent dnLockComponent;

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        Supplier<Object> jdbcUrlSupplier = () -> String.format("%s;%s", mssqlserver.getJdbcUrl(), "databaseName=Main");
        registry.add("spring.datasource.url",  jdbcUrlSupplier);
        registry.add("spring.datasource.username", mssqlserver::getUsername);
        registry.add("spring.datasource.password", mssqlserver::getPassword);
    }

    @AfterAll
    public static void afterAll() {
        mssqlserver.stop();
    }

    @Test
    public void testParsingMd() throws Exception {
        File file = new File(PATH_TO_MD_FILE);
        Assert.assertTrue(file.exists());
        CompoundParser compoundParser = new CompoundParser(Files.readAllBytes(file.toPath()));
        Assert.assertNotNull(compoundParser);
        byte[] bytes = compoundParser.read("Root Entry/Metadata/Main MetaData Stream");
        Assert.assertTrue(bytes.length > 0);
        byte[] copiedBytes = Arrays.copyOfRange(bytes, 7, bytes.length - 7);
        Assert.assertTrue(copiedBytes.length > 0);
        String ppp = new String(copiedBytes, Charset.forName("windows-1251"));
        Assert.assertNotEquals("", ppp);
        OnecMetaData dictionary = new OnecMetaData();
        dictionary.read(ppp);
        Assert.assertNotNull(dictionary);
    }

    @Test
    public void testNamingStrategy() {
        Iterator<Journal> journalIterator = journalRepository.findAll().iterator();
        Assert.assertTrue(journalIterator.hasNext());

        Iterator<Firm> firmIterator = firmRepository.findAll().iterator();
        Assert.assertTrue(firmIterator.hasNext());
    }

    @Test
    public void testCurrency() {
        Iterator<Currency> currencyIterator = currencyRepository.findAll().iterator();
        Assert.assertTrue(currencyIterator.hasNext());

        while (currencyIterator.hasNext()) {
            Currency currency = currencyIterator.next();
            System.out.println(currency.getRate());
            System.out.println(currency.getMultiplicity());
        }

        List<Currency> currencyList = currencyComponent.getAll();
        Assert.assertTrue(currencyList.size() > 0);

        for (Currency currency : currencyList) {
            System.out.println(currency.getRate());
            System.out.println(currency.getMultiplicity());
        }

        Currency currency = currencyComponent.getById("     1   ");
        Assert.assertNotNull(currency);

        currency = currencyComponent.getCurrentCurrency();
        Assert.assertNotNull(currency);
    }

    @Test
    @Transactional
    public void testMovingDocument() {
        Iterator<MovingDocument> movingDocumentIterator = movingDocumentRepository.findAll().iterator();
        Assert.assertTrue(movingDocumentIterator.hasNext());
        Assert.assertTrue(movingDocumentIterator.next().getItems().size() == 1);
        Assert.assertTrue(movingDocumentIterator.next().getItems().size() == 146);
    }

    @Test
    @Transactional
    public void testAcceptanceDocument() {
        Iterator<AcceptanceDocument> acceptanceDocumentIterator = acceptanceDocumentRepository.findAll().iterator();
        Assert.assertTrue(acceptanceDocumentIterator.hasNext());
        Assert.assertTrue(acceptanceDocumentIterator.next().getItems().size() == 27);
        Assert.assertTrue(acceptanceDocumentIterator.next().getItems().size() == 146);
        AcceptanceDocument acceptanceDocument = acceptanceDocumentRepository.findAll().iterator().next();
        acceptanceDocument.setDateCreated(Date.from(Instant.now()));
        acceptanceDocumentRepository.save(acceptanceDocument);
    }

    @Test
    @Transactional
    public void testEnum() {
        Iterator<AcceptanceDocument> acceptanceDocumentIterator = acceptanceDocumentRepository.findAll().iterator();
        Assert.assertTrue(acceptanceDocumentIterator.hasNext());
        AcceptanceDocument acceptanceDocument = acceptanceDocumentIterator.next();
        String value = acceptanceDocument.getItems().get(0).getProductInfo().getProductKind();
        Assert.assertNotNull(value);
        acceptanceDocument.getItems().get(0).getProductInfo().setProductKind(value);
    }

    @Test
    @Transactional
    public void testLot() {
        Iterator<Lot> lotIterator = lotRepository.findAll().iterator();
        Assert.assertTrue(lotIterator.hasNext());
        Lot lot = lotIterator.next();
        Assert.assertNotNull(lot);
        Assert.assertNotNull(lot.getProductInfo());

        Set<Lot> lots = lotRepository.findByParentExt("  38K1   ");
        Assert.assertTrue(lots.size() > 0);
    }

    @Test
    @Transactional
    public void  testGeneratingIddoc() {
        Iddoc iddocFromDb = iddocRepository.getIddoc();
        Assert.assertNotNull(iddocFromDb);
        String iddoc = onecSystemComponent.getIddoc();
        Assert.assertNotNull(iddoc);
        journalRepository.lockJournal();
        iddoc = onecSystemComponent.getIddoc();
        Assert.assertNotNull(iddoc);
    }

    @Test
    @Transactional
    public void testGeneratingIdd() {
        Uidd uidd = uiddRepository.getUidd();
        Assert.assertNotNull(uidd);
        String idd = onecSystemComponent.getIdd();
        Assert.assertNotNull(idd);
    }

    @Test
    @Transactional
    public void testInsertJournal() {
        Journal journal = new Journal();
        journal.setIdd(onecSystemComponent.getIdd());
        journal.setIdoc("BBBB");
        journal.setActcnt(0);
        journal.setAppcode((short) 1);
        journal.setAuthor("0");
        journal.setAvailability(0);
        journal.setBank(0);
        journal.setCash(0);
        journal.setCashbox(0);
        journal.setClosed(0);
        journal.setDelivered(0);
        journal.setEditDate(java.sql.Date.valueOf(LocalDate.now()));
        journal.setFirm("     0   ");
        journal.setIsmark(0);
        journal.setOrders(0);
        journal.setOrdersRequests(0);
        journal.setProject("0");
        journal.setJurPerson("0");
        journal.setMainSequenceDs(0);
        journal.setRealized(0);
        journal.setRequests(0);
        journal.setReserves(0);
        journal.setSales(0);
        journal.setSubcontacts(0);
        journal.setSuppliers(0);
        journal.setTmc(0);
        journal.setVerstamp(0);
        journal.setPmm(0);
        journal.setPurchasesBook(0);
        journal.setPurchasesBookDs(0);
        journal.setSalesBook(0);
        journal.setSalesBookDs(0);
        journal.setDateTimeIdDoc(
                String.format(
                        "%s%s %s",
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                        Utils.getOnecTime(LocalDateTime.now()),
                        "BBBB"
                )
        );

        journal = journalComponent.setReferences(journal, "ПриемныйАкт");
        journalRepository.save(journal);
        Iterable<Journal> journals =  journalRepository.findAll();
        Assert.assertTrue(journals.iterator().hasNext());
    }

    @Test
    @Transactional
    public void testMismatchDocument() {
        Iterable<MismatchDocument> mismatchDocumentIterator = mismatchDocumentRepository.findAll();
        Assert.assertTrue(mismatchDocumentIterator.iterator().hasNext());
    }

    @Test
    @Transactional
    public void testPackageErrorContentsDocument() {
        Iterable<PackageErrorContentsDocument> packageErrorContentsDocumentIterable = packageErrorContentsDocumentRepository.findAll();
        Assert.assertTrue(packageErrorContentsDocumentIterable.iterator().hasNext());
        Assert.assertEquals(1, packageErrorContentsDocumentIterable.iterator().next().getItems().size());
    }

    @Test
    @Transactional
    public void testPrice() {
        Iterable<Price> prices = priceRepository.findAll();
        Assert.assertTrue(prices.iterator().hasNext());

        BigDecimal price = priceComponent.getPrice("  D0LK   ", java.util.Date.from(Instant.now()));
        Assert.assertNotNull(price);
    }

    @Test
    public void testMovingReason() {
        MovingReason movingReason = movingReasonRepository.findOneById("     1   ");
        Assert.assertNotNull(movingReason);
    }

    @Test
    public void testMovingDocumentListing() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        List<MovingDocumentListing> movingDocumentListings = movingDocumentRepository.findListingByDateCreatedBetween(
                onecSrcdocComponent.getPartOfParentValForMovingDocument(),
                "20000101",
                "20300101z"
        );
        Assert.assertTrue(movingDocumentListings.size() > 0);
        Assert.assertNotNull(movingDocumentListings.get(0).getQuantity());
    }

    @Test
    public void testLanguage() {
        String iso639 = languageComponent.getLanguageOfCurrentStore();
        Assert.assertEquals("ru", iso639);
    }

    @Test
    public void testEmployees() {
        List<Employee> employees = employeeComponent.getAllEmployeesOfThisStore();
        Assert.assertTrue(employees.size() == 3);

        Employee employee = employeeComponent.getEmployeeByIddoc("  14GR   ");
        Assert.assertNotNull(employee);
    }

    @Test
    public void testGettingDateTimeFromDateTimeIdDoc() throws Exception {
        String dateTimeFromDateTimeIdDoc = "202302017YSXJ4 10KLU   ";
        String dateTime = "01.02.2023 13:22:52";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        java.util.Date dateTimeResult = journalComponent.getDateTimeFromDateTimeIdDoc(dateTimeFromDateTimeIdDoc);
        Assert.assertEquals(dateTimeResult, dateFormat.parse(dateTime));
    }

    @Test
    public void testTnved() {
        List<Tnved> tnveds = tnvedRepository.findByCodeIn(List.of("00044040000036898", "00044040000036899"));
        Assert.assertEquals(2,tnveds.size());
    }

    @Test
    public void testSystem() throws Exception {

        OnecSystem onecSystem = jdbcOnecSystemRepository.getFirstOnecSystem();
        Assert.assertNotNull(onecSystem);
        Date date = Utils.getBeginOfPeriod(
                onecSystem.getCurdate(),
                onecSystem.getSnapshper()
        );
        Assert.assertNotNull(date);
        Date dateNext = Utils.getNextPeriod(
                date,
                onecSystem.getSnapshper()
        );
        Assert.assertNotNull(dateNext);
        Assert.assertNotEquals(date, dateNext);
        onecSystem.setCurdate(dateNext);
        jdbcOnecSystemRepository.updateOnecSystem(onecSystem);
    }

    @Test
    public void testSystemComponent() throws Exception {
        Iterable<AcceptanceDocument> acceptanceDocuments = acceptanceDocumentRepository.findAll();
        AcceptanceDocument acceptanceDocument = acceptanceDocuments.iterator().next();
        List<Date> dates = onecSystemComponent.getPeriods(new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2023"));
        Assert.assertTrue(dates.size() > 0);
        onecSystemComponent.movePosition(acceptanceDocument.getJournal());
    }

    @Test
    public void testStockBalanceTmc() throws ParseException {
        stockBalanceTMCItemRepository.writeDocAct(
                "     T   ",
                0,
                1,
                1,
                "     T   ",
                "  D08F   ",
                "    VQ   ",
                BigDecimal.ONE,
                "04",
                BigDecimal.TEN,
                new SimpleDateFormat("dd.MM.yyyy").parse("01.02.2023"),
                new SimpleDateFormat("dd.MM.yyyy").parse("20.03.2023"),
                1,
                1
        );
    }

    @Test
    public void testOnecUser() throws Exception {
        OnecUser onecUser = jdbcOnecUserRepository.getOnecUser();
        Assert.assertNotNull(onecUser);
        onecUser.setNetchgcn(onecUser.getNetchgcn() + 1);
        jdbcOnecUserRepository.updateOnecUser(onecUser);
    }

    @Test
    public void testCurrentStore() {
        Warehouse warehouse = storeComponent.getCurrentStore();
        Assert.assertNotNull(warehouse);
        String storeIdd = storeComponent.getStoreIdd();
        Assert.assertEquals("00005550003814628", storeIdd);
    }

    @Test
    @Transactional
    public void testOrderRepositoryByOrderNumber() {
        OrderDocument orderDocument = orderDocumentRepository.findOneByOrderNumber("1023561877");
        Assert.assertNotNull(orderDocument);
        Assert.assertTrue(orderDocument.getItems().size() == 1);
        Assert.assertNotNull(orderDocument.getItems());
        Assert.assertNotNull(orderDocument.getItems().get(0).getProductInfo());
        Assert.assertNotNull(orderDocument.getStatus());
        Assert.assertNotNull(orderDocument.getJournal());
    }

    @Test
    @Transactional
    public void testOrderRepositoryByIdDoc() {
        OrderDocument orderDocument = orderDocumentRepository.findOneByIdDoc("  ZMQR   ");
        Assert.assertNotNull(orderDocument);
        Assert.assertTrue(orderDocument.getItems().size() == 1);
        Assert.assertNotNull(orderDocument.getItems());
        Assert.assertNotNull(orderDocument.getItems().get(0).getProductInfo());
        Assert.assertNotNull(orderDocument.getStatus());
        Assert.assertNotNull(orderDocument.getJournal());
        orderDocumentRepository.save(orderDocument);
    }

    @Test
    @Transactional
    public void testReceiptById() {
        Receipt receipt = receiptRepository.findOneByIddBaseDocument("R0003371019410567");
        Assert.assertNotNull(receipt);
        Assert.assertEquals(1, receipt.getItems().size());
        Assert.assertNotNull(receipt.getItems());

        List<Receipt> receipts = receiptRepository.findOneByIddBaseDocumentIn(List.of("R0003371019410567"));
        Assert.assertEquals(1, receipts.size());
    }

    @Test
    @Transactional
    public void testOrderClosureDocumentItemSave() {
        OrderClosureDocument searchedOrderClosureDocument = orderClosureDocumentRepository.findOneByIdDoc("  ZCFE   ");
        OrderClosureDocument orderClosureDocument = new OrderClosureDocument();
        orderClosureDocument.setIdDoc("  ZTQ1   ");
        orderClosureDocument.setBasis(searchedOrderClosureDocument.getBasis());
        orderClosureDocument.setComment(searchedOrderClosureDocument.getComment());
        orderClosureDocument.setWarehouse(searchedOrderClosureDocument.getWarehouse());
        orderClosureDocument.setSum(searchedOrderClosureDocument.getSum());
        orderClosureDocument.setRate(searchedOrderClosureDocument.getRate());
        orderClosureDocument.setCurrency(searchedOrderClosureDocument.getCurrency());
        orderClosureDocument.setQuantity(searchedOrderClosureDocument.getQuantity());
        orderClosureDocument.setDocBasis(searchedOrderClosureDocument.getDocBasis());
        orderClosureDocument.setDateCreated(searchedOrderClosureDocument.getDateCreated());
        orderClosureDocument.setEditTime(searchedOrderClosureDocument.getEditTime());
        orderClosureDocument.setTimeDoc(searchedOrderClosureDocument.getTimeDoc());
        List<OrderClosureDocumentItem> orderClosureDocumentItems = new ArrayList<>();
        OrderClosureDocumentItem orderClosureDocumentItem = new OrderClosureDocumentItem();
        orderClosureDocumentItem.setIddocLinenumberIdentity(new IddocLinenumberIdentity());
        orderClosureDocumentItem.getIddocLinenumberIdentity().setLineNo(1);
        orderClosureDocumentItem.getIddocLinenumberIdentity().setIdDoc("  ZTQ1   ");
        orderClosureDocumentItem.setItem("  R2MH   ");
        orderClosureDocumentItem.setUnit("  V60B   ");
        orderClosureDocumentItem.setCoefficient(new BigDecimal(1));
        orderClosureDocumentItem.setSum(new BigDecimal(5));
        orderClosureDocumentItem.setPrice(new BigDecimal(5));
        orderClosureDocumentItem.setQuantity(new BigDecimal(1));
        orderClosureDocumentItems.add(orderClosureDocumentItem);
        orderClosureDocumentItem = new OrderClosureDocumentItem();
        orderClosureDocumentItem.setIddocLinenumberIdentity(new IddocLinenumberIdentity());
        orderClosureDocumentItem.getIddocLinenumberIdentity().setLineNo(2);
        orderClosureDocumentItem.getIddocLinenumberIdentity().setIdDoc("  ZTQ1   ");
        orderClosureDocumentItem.setItem("  P68X   ");
        orderClosureDocumentItem.setUnit("  T8W7   ");
        orderClosureDocumentItem.setCoefficient(new BigDecimal(1));
        orderClosureDocumentItem.setSum(new BigDecimal(5));
        orderClosureDocumentItem.setPrice(new BigDecimal(5));
        orderClosureDocumentItem.setQuantity(new BigDecimal(1));
        orderClosureDocumentItems.add(orderClosureDocumentItem);
        orderClosureDocument.setItems(orderClosureDocumentItems);
        orderClosureDocumentRepository.save(orderClosureDocument);
        OrderClosureDocument closureDocument = orderClosureDocumentRepository.findOneByIdDoc("  ZTQ1   ");
        Assert.assertNotNull(closureDocument);
        Assert.assertFalse(closureDocument.getItems().isEmpty());
    }

    @Test
    @Transactional
    public void testFindEmployeeById() {
        Employee employee = employeesRepository.findOneById("  205K   ");
        Assert.assertNotNull(employee);
        Assert.assertEquals("00002140001792991", employee.getIdd());
        Assert.assertEquals("0001361", employee.getBase());
    }

    @Test
    public void testEmployeeByFiredAndNameNotContaining() {
        List<Employee> employee = employeesRepository.findByBaseAndFiredAndNameNotContaining("0001361", 0, "Декрет");
        Assert.assertFalse(employee.isEmpty());
        Assert.assertEquals(0, employee.get(0).getFired());
        Assert.assertFalse(employee.get(0).getName().contains("Декрет"));
    }

    @Test
    @Transactional
    public void testRouteListSave() {
        RouteList routeList = new RouteList();
        routeList.setIdDoc("  ZTQ1   ");
        routeList.setReceivingNumber("PM021");
        routeList.setWarehouse("1");
        routeList.setWarehouseRecipient("1");
        routeList.setNumberOfLocations(BigDecimal.valueOf(1));
        routeList.setNumberOfUnits(BigDecimal.valueOf(1));
        routeList.setDateOfTransfer(Date.from(Instant.now()));
        routeList.setTransferIdd("123");
        routeList.setSum(BigDecimal.valueOf(123));
        routeList.setDocBasis("     0   ");
        routeList.setUser("User");
        routeList.setSumRetail(BigDecimal.TEN);
        routeList.setEditTime("1");
        routeList.setCreatedDate(Date.from(Instant.now()));
        routeList.setDocumentTime("1");
        routeList.setSzTransitWarehouses("1");
        routeList.setComment("1");

        RouteListItem routeListItem = new RouteListItem();
        IddocLinenumberIdentity iddocLinenumberIdentity = new IddocLinenumberIdentity();
        iddocLinenumberIdentity.setIdDoc("20");
        iddocLinenumberIdentity.setLineNo(1);
        routeListItem.setIddocLinenumberIdentity(iddocLinenumberIdentity);
        routeListItem.setBarcodeSender("1");
        routeListItem.setBarcodeRecipient("1");
        routeListItem.setDateOfReceipt(Date.from(Instant.now()));
        routeListItem.setDateOfShipment(Date.from(Instant.now()));
        routeListItem.setWarehouseTransit("1");
        List<RouteListItem> list = new ArrayList<>();
        list.add(routeListItem);
        routeList.setItems(list);

        routeListRepository.save(routeList);
        RouteList routeListResult = routeListRepository.findByIdDoc("  ZTQ1   ");

        Assert.assertNotNull(routeListResult);
        Assert.assertFalse(routeListResult.getItems().isEmpty());
        Assert.assertEquals("20", routeListResult.getItems().get(0).getIddocLinenumberIdentity().getIdDoc());
    }

    @Test
    public void testShippingMethod() {
        String shippingMethod = ShippingMethod.getName("   73P   ");
        String emptyValue = ShippingMethod.getName("   0   ");
        Assert.assertEquals(ShippingMethod.SHIP_FROM_STORE.getName(), shippingMethod);
        Assert.assertNotNull(emptyValue);
    }

    @Test
    public void testProductByVendorCode(){
        String onecValue = ProductType.getValue(ProductType.LOT);
        List<ProductInfo> products = productRepository.findTop50ByVendorCodeContainingIgnoreCaseAndProductKindNotContainingIgnoreCase("GWT0", onecValue);
        Assert.assertFalse(products.size()==0);
        Assert.assertTrue(products.size()==13);
    }

    @Test
    public void testSalesBanValue() {
        Integer value = productComponent.getSalesBanValue("  2FU3   ", java.util.Date.from(Instant.now()));
        Assert.assertNotNull(value);
        Assert.assertEquals(1L, value.longValue());
    }

    @Test
    public void testSalesBanDocumentByItem() {
        SalesBanDocument salesBanDocument = salesBanDocumentRepository.findFirstByItems_ItemOrderByDateCreatedDesc("  2FU3   ");
        Assert.assertNotNull(salesBanDocument);
        Assert.assertEquals(BanSaleProduct.BAN.getValue(), salesBanDocument.getDestination());
    }

    @Test
    public void testGetFirmForCurrentStore() {
        Firm firm = storeComponent.getFirmForCurrentStore();
        Assert.assertNotNull(firm);
    }
    @Test
    public void testGet1cValueForProductTypeLot(){
        String onecValue = ProductType.getValue(ProductType.LOT);
        Assert.assertEquals("   6QO   ", onecValue);
    }

    @Test
    public void testTableId() {
        Integer result = onecSystemComponent.getDatabaseTableId("Документ.Заказ");
        Assert.assertEquals("9170", String.valueOf(result));
    }

    @Test
    public void testFormatDnLockDocNo() {
        String result = dnLockComponent.formatDnLockDocNo("РМ2089", "РМ20890123");
        Assert.assertEquals("123", result);
        result = dnLockComponent.formatDnLockDocNo("", "0000012345");
        Assert.assertEquals("12345", result);
    }
}
