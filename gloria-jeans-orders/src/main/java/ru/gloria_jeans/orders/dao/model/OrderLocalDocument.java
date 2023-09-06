package ru.gloria_jeans.orders.dao.model;

import ru.gloria_jeans.orders.dao.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Cacheable(false)
@Table(name = "warehouse_documents_orders")
public class OrderLocalDocument implements Serializable {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "idd")
    private String idd;

    @Column(name = "id_doc")
    private String idDoc;

    @Column(name = "dk")
    private String dk;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "buyer_name")
    private String buyer;

    @Column(name = "warehouse")
    private String warehouse;

    @Column(name = "firm")
    private String firm;

    @Column(name = "collector_name")
    private String collectorName;

    @Column(name = "shipping_type")
    private String shippingType;

    @Column(name = "status_order")
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus statusOrder;

    @Column(name = "pay_type")
    private String payType;

    @Column(name = "warehouse_sender")
    private String warehouseSender;

    @Column(name = "warehouse_transit")
    private String warehouseTransit;

    @Column(name = "buyer_address")
    private String buyerAddress;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "dop")
    private String dop;

    @Column(name = "gift_certificate")
    private String giftCertificate;

    @Column(name = "tk")
    private String tk;

    @Column(name = "pvz")
    private String pvz;

    @Column(name = "cash")
    private BigDecimal cash;

    @Column(name = "external_credit")
    private BigDecimal externalCredit;

    @Column(name = "internal_credit")
    private BigDecimal internalCredit;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "quantity_fact")
    private BigDecimal quantityFact;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "edit_time")
    private String editTime;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "time_doc")
    private String timeDoc;

    @Column(name = "comment")
    private String comment;
    
    @Column(name = "document_open_date")
    private LocalDateTime documentOpenDate;

    @Column(name = "current_user_id")
    private String currentUserId;

    @Column(name = "id_doc_def")
    private String iddocdef;

    @OneToMany(mappedBy = "orderLocalDocument")
    private Set<OrderItem> orderItems;

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public OrderStatus getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(OrderStatus statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getWarehouseSender() {
        return warehouseSender;
    }

    public void setWarehouseSender(String warehouseSender) {
        this.warehouseSender = warehouseSender;
    }

    public String getWarehouseTransit() {
        return warehouseTransit;
    }

    public void setWarehouseTransit(String warehouseTransit) {
        this.warehouseTransit = warehouseTransit;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    public String getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(String giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getPvz() {
        return pvz;
    }

    public void setPvz(String pvz) {
        this.pvz = pvz;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getExternalCredit() {
        return externalCredit;
    }

    public void setExternalCredit(BigDecimal externalCredit) {
        this.externalCredit = externalCredit;
    }

    public BigDecimal getInternalCredit() {
        return internalCredit;
    }

    public void setInternalCredit(BigDecimal internalCredit) {
        this.internalCredit = internalCredit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(BigDecimal quantityFact) {
        this.quantityFact = quantityFact;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTimeDoc() {
        return timeDoc;
    }

    public void setTimeDoc(String timeDoc) {
        this.timeDoc = timeDoc;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDocumentOpenDate() {
        return documentOpenDate;
    }

    public void setDocumentOpenDate(LocalDateTime documentOpenDate) {
        this.documentOpenDate = documentOpenDate;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDk() {
        return dk;
    }

    public void setDk(String dk) {
        this.dk = dk;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getIddocdef() {
        return iddocdef;
    }

    public void setIddocdef(String iddocdef) {
        this.iddocdef = iddocdef;
    }
}
