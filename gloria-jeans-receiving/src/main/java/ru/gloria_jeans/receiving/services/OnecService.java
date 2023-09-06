package ru.gloria_jeans.receiving.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.component.*;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.onecdbmapper.dao.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class OnecService {
    private final MovingDocumentRepository movingDocumentRepository;
    private final AcceptanceDocumentRepository acceptanceDocumentRepository;
    private final AcceptanceDocumentItemRepository acceptanceDocumentItemRepository;
    private final ProductRepository productRepository;
    private final LotRepository lotRepository;
    private final JournalRepository journalRepository;
    private final MismatchDocumentRepository mismatchDocumentRepository;
    private final MismatchDocumentItemRepository mismatchDocumentItemRepository;
    private final PackageErrorContentsDocumentRepository packageErrorContentsDocumentRepository;
    private final PackageErrorContentsDocumentItemRepository packageErrorContentsDocumentItemRepository;
    private final StockBalanceTMCRepository stockBalanceTMCRepository;
    private final StockBalanceTMCItemRepository stockBalanceTMCItemRepository;
    private final JournalComponent journalComponent;
    private final OnecSrcdocComponent onecSrcdocComponent;
    private final PriceComponent priceComponent;
    private final VatComponent vatComponent;
    private final MovingReasonRepository movingReasonRepository;
    private final WarehouseRepository warehouseRepository;
    private final EmployeeComponent employeeComponent;
    private final CurrencyComponent currencyComponent;
    private final StoreComponent storeComponent;
    private final FirmRepository firmRepository;
    private final TnvedRepository tnvedRepository;
    private final OnecSystemComponent onecSystemComponent;

    @Autowired
    public OnecService(
            MovingDocumentRepository movingDocumentRepository,
            AcceptanceDocumentRepository acceptanceDocumentRepository,
            AcceptanceDocumentItemRepository acceptanceDocumentItemRepository,
            ProductRepository productRepository,
            LotRepository lotRepository,
            JournalRepository journalRepository,
            JournalComponent journalComponent,
            MismatchDocumentRepository mismatchDocumentRepository,
            MismatchDocumentItemRepository mismatchDocumentItemRepository,
            PackageErrorContentsDocumentRepository packageErrorContentsDocumentRepository,
            PackageErrorContentsDocumentItemRepository packageErrorContentsDocumentItemRepository,
            StockBalanceTMCRepository stockBalanceTMCRepository,
            StockBalanceTMCItemRepository stockBalanceTMCItemRepository,
            OnecSrcdocComponent onecSrcdocComponent,
            PriceComponent priceComponent,
            VatComponent vatComponent,
            MovingReasonRepository movingReasonRepository,
            WarehouseRepository warehouseRepository,
            EmployeeComponent employeeComponent,
            CurrencyComponent currencyComponent,
            StoreComponent storeComponent,
            FirmRepository firmRepository,
            TnvedRepository tnvedRepository,
            OnecSystemComponent onecSystemComponent
    ) {
        this.movingDocumentRepository = movingDocumentRepository;
        this.acceptanceDocumentRepository = acceptanceDocumentRepository;
        this.acceptanceDocumentItemRepository = acceptanceDocumentItemRepository;
        this.productRepository = productRepository;
        this.lotRepository = lotRepository;
        this.journalRepository = journalRepository;
        this.journalComponent = journalComponent;
        this.mismatchDocumentRepository = mismatchDocumentRepository;
        this.mismatchDocumentItemRepository = mismatchDocumentItemRepository;
        this.packageErrorContentsDocumentRepository = packageErrorContentsDocumentRepository;
        this.packageErrorContentsDocumentItemRepository = packageErrorContentsDocumentItemRepository;
        this.stockBalanceTMCRepository = stockBalanceTMCRepository;
        this.stockBalanceTMCItemRepository = stockBalanceTMCItemRepository;
        this.onecSrcdocComponent = onecSrcdocComponent;
        this.priceComponent = priceComponent;
        this.vatComponent = vatComponent;
        this.movingReasonRepository = movingReasonRepository;
        this.warehouseRepository = warehouseRepository;
        this.employeeComponent = employeeComponent;
        this.currencyComponent = currencyComponent;
        this.storeComponent = storeComponent;
        this.firmRepository = firmRepository;
        this.tnvedRepository = tnvedRepository;
        this.onecSystemComponent = onecSystemComponent;
    }

    public Set<MovingDocument> getMovingDocuments(String barcodeBox) {
        return movingDocumentRepository.findByItems_BarcodeBox(barcodeBox);
    }

    public MovingDocument getMovingDocument(String id) {
        return movingDocumentRepository.findOneByJournal_Idd(id);
    }

    public Set<MovingDocument> getMovingDocumentsByDocumentBarcode(String documentBarcode) {
        return movingDocumentRepository.findByJournal_Idd(documentBarcode);
    }

    public MovingDocumentListing getMovingDocumentListingByDocumentBarcode(String documentBarcode, String warehouseId) {
        return movingDocumentRepository.findListingByJournal_IddAndMovingDocument_warehouseReceiver(onecSrcdocComponent.getPartOfParentValForMovingDocument(), documentBarcode, warehouseId);
    }

    public List<MovingDocumentListing> getMovingDocumentsByDocumentNumber(String documentNumber, String warehouseId) {
        return movingDocumentRepository.findListingByJournal_DocnoAndMovingDocument_warehouseReceiver(onecSrcdocComponent.getPartOfParentValForMovingDocument(), documentNumber, warehouseId);
    }

    public Set<MovingDocument> findMovingDocumentsByDocumentNumber(String documentNumber) {
        return movingDocumentRepository.findByJournal_Docno(documentNumber);
    }

    public List<MovingDocumentListing> findMovingDocumentListings(
            String dateFrom,
            String dateTo,
            String warehouseReceiver
    ) {
        return movingDocumentRepository.findListingByDateCreatedBetweenAndMovingDocument_warehouseReceiver(onecSrcdocComponent.getPartOfParentValForMovingDocument(), dateFrom, dateTo, warehouseReceiver);
    }

    public Set<AcceptanceDocument> getAcceptanceDocuments(String barcodeBox) {
        return acceptanceDocumentRepository.findByItems_BarcodeBox(barcodeBox);
    }

    public AcceptanceDocument getAcceptanceDocument(String id) {
        return acceptanceDocumentRepository.findOneByJournal_Idd(id);
    }

    public ProductInfo getProductByBarcode(String barcode) {
        return productRepository.findOneByBarcode(barcode);
    }

    public ProductInfo getProductByVendorCode(String vendorCode) {
        return productRepository.findOneByVendorCode(vendorCode);
    }

    public ProductInfo getProductByIdd(String idd) {
        return productRepository.findOneByIdd(idd);
    }

    public List<ProductInfo> getProductsByIdd(List<String> ids) {
        return productRepository.findOneByIddIn(ids);
    }

    public ProductInfo searchProduct(String search) {
        return productRepository.findOneByIddOrBarcodeOrVendorCode(
                search,
                search,
                search
        );
    }

    public void updateAcceptanceDocument(AcceptanceDocument acceptanceDocument) {
        acceptanceDocumentRepository.save(acceptanceDocument);
    }

    public void updateAcceptanceDocumentItems(List<AcceptanceDocumentItem> items) {
        acceptanceDocumentItemRepository.saveAll(items);
    }

    public boolean existBox(String barcodeBox) {
        return !movingDocumentRepository.findByItems_BarcodeBox(barcodeBox).isEmpty();
    }

    public Set<Lot> getLotItems(String lotId) {
        return lotRepository.findByParentExt(lotId);
    }

    public List<Lot> getLotItems(List<String> lotIds) {
        return lotRepository.findByParentExtIn(lotIds);
    }

    public Journal setReferencesJournal(Journal journal, String documentType) {
        return journalComponent.setReferences(journal, documentType);
    }

    public void updateJournal(Journal journal) {
        journalRepository.save(journal);
    }

    public void updateMismatchDocument(MismatchDocument mismatchDocument) {
        mismatchDocumentRepository.save(mismatchDocument);
    }

    public void updateMismatchDocumentItems(List<MismatchDocumentItem> items) {
        mismatchDocumentItemRepository.saveAll(items);
    }

    public void updatePackageErrorContentsDocument(PackageErrorContentsDocument packageErrorContentsDocument) {
        packageErrorContentsDocumentRepository.save(packageErrorContentsDocument);
    }

    public void updatePackageErrorContentsDocumentItems(List<PackageErrorContentsDocumentItem> items) {
        packageErrorContentsDocumentItemRepository.saveAll(items);
    }

    public StockBalanceTMC getExistStockBalanceTMC(Date period, String firmId, String warehouseId, String itemId) {
        return stockBalanceTMCRepository.findOneByStockBalanceTMCEmbeddedId_PeriodAndStockBalanceTMCEmbeddedId_FirmAndStockBalanceTMCEmbeddedId_WarehouseAndStockBalanceTMCEmbeddedId_Item(
                period,
                firmId,
                warehouseId,
                itemId
        );
    }

    public void updateStockBalanceTMC(List<StockBalanceTMC> stockBalanceTMCs) {
        stockBalanceTMCRepository.saveAll(stockBalanceTMCs);
    }

    public void updateStockBalanceTMCItem(List<StockBalanceTMCItem> stockBalanceTMCItems) {
        stockBalanceTMCItemRepository.saveAll(stockBalanceTMCItems);
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

    public BigDecimal getPrice(String productInfoId, Date documentDate) {
        return priceComponent.getPrice(productInfoId, documentDate);
    }

    public BigDecimal getVat(String productInfoId, Date documentDate) {
        return vatComponent.getVat(productInfoId, documentDate);
    }

    public void addOnecSrcDoc(Journal childJournal, Integer parentIdDocDef, String parentIdDoc) {
        onecSrcdocComponent.addSrcDoc(childJournal, parentIdDocDef, parentIdDoc);
    }

    public MovingReason getMovingReasonById(String id) {
        return movingReasonRepository.findOneById(id);
    }

    public List<KeyValue> getAllMovingReasonLikeKeyValue() {
        return movingReasonRepository.findAllKeyValue();
    }

    public String getWarehouseName(String id) {
        Warehouse warehouse = warehouseRepository.findOneById(id);

        if (Objects.nonNull(warehouse)) {
            return warehouse.getName();
        } else {
            return "";
        }
    }

    public List<Employee> getListEmployees() {
        return employeeComponent.getAllEmployeesOfThisStore();
    }

    public Date getDateTimeFromDateTimeIdDoc(String dateTimeIdDoc) throws Exception {
        return journalComponent.getDateTimeFromDateTimeIdDoc(dateTimeIdDoc);
    }

    public Currency getCurrency() {
        return currencyComponent.getCurrentCurrency();
    }

    public Employee getEmployee(String iddoc) {
        return employeeComponent.getEmployeeByIddoc(iddoc);
    }

    public String getStoreIdd() {
        return storeComponent.getStoreIdd();
    }

    public Warehouse getCurrentStore() {
        return storeComponent.getCurrentStore();
    }

    public Firm getFirm(String iddoc) {
        return firmRepository.findOneById(iddoc);
    }

    public Firm getFirmByWarehouse(String iddoc) {
        Warehouse warehouse = warehouseRepository.findOneById(iddoc);
        return firmRepository.findOneById(warehouse.getBranch());
    }

    public Warehouse getWarehouse(String id) {
        return warehouseRepository.findOneById(id);
    }

    public List<Tnved> getTnveds(List<String> productIdds) {
        return tnvedRepository.findByCodeIn(productIdds);
    }

    public String generateGuidWithDate(String sbisIdd) {
        LocalDateTime dateTime = LocalDateTime.now();
        sbisIdd = sbisIdd.replaceAll("-", "");
        String year = String.valueOf(dateTime.getYear()).substring(2,3);
        String day = Utils.convertToBase36(String.valueOf(dateTime.getDayOfMonth())).trim();
        String month = Utils.convertToBase36(String.valueOf(dateTime.getMonth().getValue())).trim();
        return sbisIdd + year + month + day;
    }

    public void updateMovingDocument(MovingDocument movingDocument) {
        movingDocumentRepository.save(movingDocument);
    }

    public void movePeriod(Journal journal) throws Exception {
        onecSystemComponent.movePosition(journal);
    }

    public Journal getJournalByIddoc(String iddoc) {
        return journalRepository.findOneByIdoc(iddoc);
    }

    public void updateJournalsAsDelete(List<String> iddocs) {
        List<Journal> journals = journalRepository.findByIdocIn(iddocs);

        for (Journal journal : journals) {
            journal.setIsmark(1);
        }

        journalRepository.saveAll(journals);
    }
}
