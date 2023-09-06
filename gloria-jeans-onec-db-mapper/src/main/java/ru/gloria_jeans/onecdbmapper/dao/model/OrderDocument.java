package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.Заказ")
public class OrderDocument implements Serializable {

    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "ДК")
    private String dk;

    @Column(name = "НомерЗаказа")
    private String orderNumber;

    @Column(name = "Покупатель")
    private String buyer;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "Собрал")
    private String collectorName;

    @Column(name = "СпособДоставки")
    private String shippingType;

    @Column(name = "СтатусЗаказа")
    private String statusOrder;

    @Column(name = "ТипОплаты")
    private String payType;

    @Column(name = "СкладОтправитель")
    private String warehouseSender;

    @Column(name = "СкладТранзитный")
    private String warehouseTransit;

    @Column(name = "АдресПокупателя")
    private String bayerAddress;

    @Column(name = "СпособОтгрузки")
    private String shippingMethod;

    @Column(name = "ИДЗаказа")
    private String orderId;

    @Column(name = "Доп")
    private String dop;

    @Column(name = "ПодарочныйСертификат")
    private String giftCertificate;

    @Column(name = "ТК")
    private String tk;

    @Column(name = "ПВЗ")
    private String pvz;

    @Column(name = "Наличные")
    private BigDecimal cash;

    @Column(name = "КредитВнешний")
    private BigDecimal externalCredit;

    @Column(name = "КредитВнутренний")
    private BigDecimal internalCredit;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "КоличествоФакт")
    private BigDecimal quantityFact;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "ВремяРедактирования")
    private String editTime;

    @Column(name = "ДатаСоздания")
    private Date dateCreated;

    @Column(name = "ВремяДокум")
    private String timeDoc;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<OrderDocumentItem> items;

    @OneToOne(mappedBy = "orderDocument")
    private Journal journal;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "СтатусЗаказа",referencedColumnName = "ID", insertable = false, updatable = false)
    private OrderStatusDocument status;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getDk() {
        return dk;
    }

    public void setDk(String dk) {
        this.dk = dk;
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

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
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

    public String getBayerAddress() {
        return bayerAddress;
    }

    public void setBayerAddress(String bayerAddress) {
        this.bayerAddress = bayerAddress;
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

    public List<OrderDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<OrderDocumentItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public OrderStatusDocument getStatus() {
        return status;
    }

    public void setStatus(OrderStatusDocument status) {
        this.status = status;
    }
}
