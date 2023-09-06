package ru.gloria_jeans.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.component.*;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.onecdbmapper.dao.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OnecService {
    private final OrderDocumentRepository orderDocumentRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final FirmRepository firmRepository;
    private final PriceComponent priceComponent;
    private final VatComponent vatComponent;
    private final JournalRepository journalRepository;
    private final OrderClosureDocumentRepository orderClosureDocumentRepository;
    private final ReceiptRepository receiptRepository;
    private final OnecSystemComponent onecSystemComponent;
    private final MovingReasonRepository movingReasonRepository;
    private final CurrencyComponent currencyComponent;
    private final OnecSrcdocComponent onecSrcdocComponent;
    private final StockBalanceTMCRepository stockBalanceTMCRepository;
    private final StockBalanceTMCItemRepository stockBalanceTMCItemRepository;
    private final EmployeesRepository employeesRepository;
    private final OnecConstantRepository onecConstantRepository;
    private final WriteOffDocumentRepository writeOffDocumentRepository;
    private final OrderDocumentItemRepository orderDocumentItemRepository;
    private final DnLockComponent dnLockComponent;

    @Autowired
    public OnecService(
            OrderDocumentRepository orderDocumentRepository,
            ProductRepository productRepository,
            WarehouseRepository warehouseRepository,
            FirmRepository firmRepository,
            PriceComponent priceComponent,
            VatComponent vatComponent,
            JournalRepository journalRepository,
            OrderClosureDocumentRepository orderClosureDocumentRepository,
            ReceiptRepository receiptRepository,
            OnecSystemComponent onecSystemComponent,
            MovingReasonRepository movingReasonRepository,
            CurrencyComponent currencyComponent,
            OnecSrcdocComponent onecSrcdocComponent, StockBalanceTMCRepository stockBalanceTMCRepository,
            StockBalanceTMCItemRepository stockBalanceTMCItemRepository,
            EmployeesRepository employeesRepository,
            OnecConstantRepository onecConstantRepository,
            WriteOffDocumentRepository writeOffDocumentRepository,
            OrderDocumentItemRepository orderDocumentItemRepository,
            DnLockComponent dnLockComponent
    ) {
        this.orderDocumentRepository = orderDocumentRepository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.firmRepository = firmRepository;
        this.priceComponent = priceComponent;
        this.vatComponent = vatComponent;
        this.journalRepository = journalRepository;
        this.orderClosureDocumentRepository = orderClosureDocumentRepository;
        this.receiptRepository = receiptRepository;
        this.onecSystemComponent = onecSystemComponent;
        this.movingReasonRepository = movingReasonRepository;
        this.currencyComponent = currencyComponent;
        this.onecSrcdocComponent = onecSrcdocComponent;
        this.stockBalanceTMCRepository = stockBalanceTMCRepository;
        this.stockBalanceTMCItemRepository = stockBalanceTMCItemRepository;
        this.employeesRepository = employeesRepository;
        this.onecConstantRepository = onecConstantRepository;
        this.writeOffDocumentRepository = writeOffDocumentRepository;
        this.orderDocumentItemRepository = orderDocumentItemRepository;
        this.dnLockComponent = dnLockComponent;
    }

    public OrderDocument getOrderDocumentByOrderNumber(String orderNumber) {
        return orderDocumentRepository.findOneByOrderNumber(orderNumber);
    }

    public void updateOrderDocument(OrderDocument orderDocument) {
        orderDocumentRepository.save(orderDocument);
    }

    @Transactional
    public OrderDocument getOrderByOrderNumber(String orderNumber) {
        return orderDocumentRepository.findOneByOrderNumber(orderNumber);
    }

    public List<OrderDocument> getOrdersForDeliveryByStatusOrder(String statusOrder) {
        return orderDocumentRepository.findAllByStatusOrder(statusOrder);
    }

    public List<OrderDocument> getOrdersForDeliveryByStatusOrderAndTk(String statusOrder, String tk) {
        return orderDocumentRepository.findAllByStatusOrderAndTk(statusOrder, tk);
    }

    public OrderDocument getOrderByIdd(String idd) {
        return orderDocumentRepository.findOneByJournal_Idd(idd);
    }

    public String getWarehouseName(String id) {
        Warehouse warehouse = warehouseRepository.findOneById(id);

        if (Objects.nonNull(warehouse)) {
            return warehouse.getName();
        } else {
            return "";
        }
    }

    public ProductInfo searchProduct(String search) {
        return productRepository.findOneByIddOrBarcodeOrVendorCode(search, search, search);
    }

    public Firm getFirmByWarehouse(String iddoc) {
        Warehouse warehouse = warehouseRepository.findOneById(iddoc);
        return firmRepository.findOneById(warehouse.getBranch());
    }

    public BigDecimal getPrice(String productInfoId, Date documentDate) {
        return priceComponent.getPrice(productInfoId, documentDate);
    }

    public BigDecimal getVat(String productInfoId, Date documentDate) {
        return vatComponent.getVat(productInfoId, documentDate);
    }

    public Journal getJournal(String idDoc) {
        return journalRepository.findOneByIdoc(idDoc);
    }

    public void addJournal(Journal journal) {
        journalRepository.save(journal);
        dnLockComponent.deleteDnLock(journal.getDocno(), journal.getDnprefix());
    }

    public void saveOrderClosureDocument(OrderClosureDocument orderClosureDocument) {
        orderClosureDocumentRepository.save(orderClosureDocument);
    }

    public List<OrderClosureDocument> findOrderClosureDocumentByBasisContaining(String idDoc) {
        return orderClosureDocumentRepository.findByDocBasisContaining(idDoc);
    }

    public MovingReason getMovingReasonByCode(String code) {
        return movingReasonRepository.findOneByCode(code);
    }

    public Currency getCurrency() {
        return currencyComponent.getCurrentCurrency();
    }

    public String getNewIdDoc() {
        return onecSystemComponent.getIddoc();
    }

    public Integer getTableIdByEntityName(String entityName) {
        return onecSystemComponent.getDatabaseTableId(entityName);
    }

    public String getDocBasis(Integer id, String docId) {
        return Utils.build13Ref(id, docId);
    }

    public void createReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    public List<OrderDocument> getOrderDocumentsByOrderNumberList(List<String> orderNumbers) {
        return orderDocumentRepository.findAllByOrderNumberIn(orderNumbers);
    }

    public void updateStockBalanceTMC(List<StockBalanceTMC> stockBalanceTMCs) {
        stockBalanceTMCRepository.saveAll(stockBalanceTMCs);
    }

    public void writeStockBalanceTMCItems(
            List<StockBalanceTMCItem> stockBalanceTMCItems,
            Date documentDate
    ) {
        for (StockBalanceTMCItem stockBalanceTMCItem : stockBalanceTMCItems) {
            stockBalanceTMCItemRepository.writeDocAct(
                    stockBalanceTMCItem.getIddocLinenumberIdentity().getIdDoc(),
                    stockBalanceTMCItem.getIddocLinenumberIdentity().getLineNo(),
                    stockBalanceTMCItem.getIddocLinenumberIdentity().getActno(),
                    stockBalanceTMCItem.getDebkred(),
                    stockBalanceTMCItem.getFirm(),
                    stockBalanceTMCItem.getItem(),
                    stockBalanceTMCItem.getWarehouse(),
                    stockBalanceTMCItem.getQuantity(),
                    stockBalanceTMCItem.getOperationCode(),
                    stockBalanceTMCItem.getSum(),
                    documentDate,
                    java.sql.Date.valueOf(LocalDate.now()),
                    1,
                    1
            );
        }
    }

    public Journal getJournalByIddoc(String iddoc) {
        return journalRepository.findOneByIdoc(iddoc);
    }

    public void updateJournal(Journal journal) {
        journalRepository.save(journal);
    }

    public void movePeriod(Journal journal) throws Exception {
        onecSystemComponent.movePosition(journal);
    }

    public OrderDocument getOrderByBarcode(String search) {
        return orderDocumentRepository.findOneByJournal_Idd(search);
    }

    public Employee getEmployeeById(String id) {
        return employeesRepository.findOneById(id);
    }

    public Warehouse getWarehouseById(String id) {
        return warehouseRepository.findOneById(id);
    }

    public List<OrderDocument> getOrdersByShippingMethodAndStatusOrderNotIn(List<String> shippingMethod, List<String> statusOrder) {
        return orderDocumentRepository.findAllByShippingMethodInAndStatusOrderNotIn(shippingMethod, statusOrder);
    }

    public List<Employee> findNotFiredAndNotMaternityLeaveEmployees(int fired, String notContainingWord) {
        return employeesRepository.findByBaseAndFiredAndNameNotContaining(onecConstantRepository.findOneByIdAndObjIdOrderByDateDesc(
                Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("IDD").getID()),
                "     0   "
        ).getValue(), fired, notContainingWord);
    }

    public void addOnecSrcDoc(Journal childJournal, Integer parentIdDocDef, String parentIdDoc) {
        onecSrcdocComponent.addSrcDoc(childJournal, parentIdDocDef, parentIdDoc);
    }

    public OrderClosureDocument getOrderClosureDocumentByDocBasis(String idd) {
        return orderClosureDocumentRepository.findOneByDocBasis(idd);
    }

    public void addWriteOffDocument(WriteOffDocument writeOffDocument) {
        writeOffDocumentRepository.save(writeOffDocument);
    }

    public Receipt getReceiptByDocBasis(String iddocdef, String iddoc) {
        return receiptRepository.findOneByDocBasis(
                String.format(
                        "%s%s",
                        iddocdef,
                        iddoc
                )
        );
    }

    public Journal getReceiptJournalByIdd(String idd) {
        return journalRepository.findJournalByIdd(idd);
    }

    public void saveOrderDocument(OrderDocument orderDocument) {
        orderDocumentRepository.save(orderDocument);
    }

    public void saveOrderDocumentItem(List<OrderDocumentItem> orderDocumentItems) {
        orderDocumentItemRepository.saveAll(orderDocumentItems);
    }

    public List<OrderDocumentItem> findOrderDocumentItemByIdd(String idd) {
        return orderDocumentItemRepository.findByProductInfoIdd(idd);
    }

    public Receipt findReceiptDocBasisContainingAndByJournalIdd(String idDoc, String idd) {
        return receiptRepository.findByDocBasisContainingAndJournal_Idd(idDoc, idd);
    }
}
