package ru.gloria_jeans.receiving.dao.model;

import ru.gloria_jeans.onecdbmapper.dao.enums.DocumentStatus;
import ru.gloria_jeans.receiving.model.enums.DocumentType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "warehouse_documents")
public class Document implements Serializable {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "idd")
    private String idd;

    @Column(name = "document_grounds_id")
    private UUID documentGroundsId;

    @Column(name = "document_type")
    private DocumentType documentType;

    @Column(name = "warehouse")
    private String warehouse;

    @Column(name = "currency")
    private String currency;

    @Column(name = "return_type")
    private String returnType;

    @Column(name = "warehouse_receiver")
    private String warehouseReceiver;

    @Column(name = "final_warehouse")
    private String finalWarehouse;

    @Column(name = "currency_rate")
    private BigDecimal currencyRate;

    @Column(name = "quantity_places")
    private Integer quantityPlaces;

    @Column(name = "ground")
    private String ground;

    @Column(name = "status")
    private DocumentStatus status;

    @Column(name = "expected_arrival")
    private Instant expectedArrival;

    @Column(name = "transfer_number")
    private Long transferNumber;

    @Column(name = "correction")
    private String correction;

    @Column(name = "transit_warehouse")
    private String transitWarehouse;

    @Column(name = "trade_number")
    private String tradeNumber;

    @Column(name = "prepayment")
    private BigDecimal prepayment;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "guid")
    private String guid;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "fact_quantity")
    private Long factQuantity;

    @Column(name = "document_comment")
    private String documentComment;

    @Column(name = "collected_by")
    private String collectedBy;

    @Column(name = "accepted_by")
    private String acceptedBy;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "iddoc")
    private String iddoc;

    @Column(name = "docno")
    private String docno;

    @Column(name = "idocdef")
    private Integer idocdef;

    @Column(name = "cashbox")
    private Integer cashbox;

    @Column(name = "sales")
    private Boolean sales;

    @Column(name = "realized")
    private Boolean realized;

    @Column(name = "purchases_book")
    private Integer purchasesBook;

    @Column(name = "availability")
    private Integer availability;

    @Column(name = "jur_person")
    private String jurPerson;

    @Column(name = "firm_recipient")
    private String firmRecipient;

    @Column(name = "is_mark")
    private Integer isMark;

    @Column(name = "project")
    private String project;

    @Column(name = "suppliers")
    private Boolean suppliers;

    @Column(name = "sales_book")
    private Integer salesBook;

    @Column(name = "tmc")
    private Boolean tmc;

    @Column(name = "reserves")
    private Boolean reserves;

    @Column(name = "orders_requests")
    private Boolean ordersRequests;

    @Column(name = "app_code")
    private String appCode;

    @Column(name = "requests")
    private Boolean requests;

    @Column(name = "cash")
    private Boolean cash;

    @Column(name = "delivered")
    private Boolean delivered;

    @Column(name = "sub_contacts")
    private Boolean subContacts;

    @Column(name = "closed")
    private Boolean closed;

    @Column(name = "orders")
    private Boolean orders;

    @OneToMany(mappedBy = "document")
    private Set<Product> products;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public UUID getDocumentGroundsId() {
        return documentGroundsId;
    }

    public void setDocumentGroundsId(UUID documentGroundsId) {
        this.documentGroundsId = documentGroundsId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getWarehouseReceiver() {
        return warehouseReceiver;
    }

    public void setWarehouseReceiver(String warehouseReceiver) {
        this.warehouseReceiver = warehouseReceiver;
    }

    public String getFinalWarehouse() {
        return finalWarehouse;
    }

    public void setFinalWarehouse(String finalWarehouse) {
        this.finalWarehouse = finalWarehouse;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Integer getQuantityPlaces() {
        return quantityPlaces;
    }

    public void setQuantityPlaces(Integer quantityPlaces) {
        this.quantityPlaces = quantityPlaces;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public Instant getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(Instant expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public Long getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(Long transferNumber) {
        this.transferNumber = transferNumber;
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    public String getTransitWarehouse() {
        return transitWarehouse;
    }

    public void setTransitWarehouse(String transitWarehouse) {
        this.transitWarehouse = transitWarehouse;
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public BigDecimal getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(BigDecimal prepayment) {
        this.prepayment = prepayment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Long getFactQuantity() {
        return factQuantity;
    }

    public void setFactQuantity(Long factQuantity) {
        this.factQuantity = factQuantity;
    }

    public String getDocumentComment() {
        return documentComment;
    }

    public void setDocumentComment(String documentComment) {
        this.documentComment = documentComment;
    }

    public String getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getIddoc() {
        return iddoc;
    }

    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public Integer getIdocdef() {
        return idocdef;
    }

    public void setIdocdef(Integer idocdef) {
        this.idocdef = idocdef;
    }

    public Integer getCashbox() {
        return cashbox;
    }

    public void setCashbox(Integer cashbox) {
        this.cashbox = cashbox;
    }

    public Boolean getSales() {
        return sales;
    }

    public void setSales(Boolean sales) {
        this.sales = sales;
    }

    public Boolean getRealized() {
        return realized;
    }

    public void setRealized(Boolean realized) {
        this.realized = realized;
    }

    public Integer getPurchasesBook() {
        return purchasesBook;
    }

    public void setPurchasesBook(Integer purchasesBook) {
        this.purchasesBook = purchasesBook;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public String getJurPerson() {
        return jurPerson;
    }

    public void setJurPerson(String jurPerson) {
        this.jurPerson = jurPerson;
    }

    public String getFirmRecipient() {
        return firmRecipient;
    }

    public void setFirmRecipient(String firmRecipient) {
        this.firmRecipient = firmRecipient;
    }

    public Integer getIsMark() {
        return isMark;
    }

    public void setIsMark(Integer isMark) {
        this.isMark = isMark;
    }

    public Integer getMark() {
        return isMark;
    }

    public void setMark(Integer mark) {
        isMark = mark;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Boolean getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Boolean suppliers) {
        this.suppliers = suppliers;
    }

    public Integer getSalesBook() {
        return salesBook;
    }

    public void setSalesBook(Integer salesBook) {
        this.salesBook = salesBook;
    }

    public Boolean getTmc() {
        return tmc;
    }

    public void setTmc(Boolean tmc) {
        this.tmc = tmc;
    }

    public Boolean getReserves() {
        return reserves;
    }

    public void setReserves(Boolean reserves) {
        this.reserves = reserves;
    }

    public Boolean getOrdersRequests() {
        return ordersRequests;
    }

    public void setOrdersRequests(Boolean ordersRequests) {
        this.ordersRequests = ordersRequests;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Boolean getRequests() {
        return requests;
    }

    public void setRequests(Boolean requests) {
        this.requests = requests;
    }

    public Boolean getCash() {
        return cash;
    }

    public void setCash(Boolean cash) {
        this.cash = cash;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Boolean getSubContacts() {
        return subContacts;
    }

    public void setSubContacts(Boolean subContacts) {
        this.subContacts = subContacts;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getOrders() {
        return orders;
    }

    public void setOrders(Boolean orders) {
        this.orders = orders;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
