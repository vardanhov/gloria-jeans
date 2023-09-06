package ru.gloria_jeans.onecdbmapper.dao.model;

import ru.gloria_jeans.onecdbmapper.dao.enums.DocumentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.Возврат")
public class MovingDocument implements Serializable {
    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "ДокОснование")
    private String docOrigin;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "Валюта")
    private String currency;

    @Column(name = "ВидВозврата")
    private String returnType;

    @Column(name = "СкладПолучатель")
    private String warehouseReceiver;

    @Column(name = "Собрал")
    private String collectedBy;

    @Column(name = "Оформил")
    private String createdBy;

    @Column(name = "ФирмаПолучатель")
    private String companyReceiver;

    @Column(name = "КонечныйСклад")
    private String finalWarehouse;

    @Column(name = "Курс")
    private BigDecimal course;

    @Column(name = "КоличествоМест")
    private BigDecimal quantityPlaces;

    @Column(name = "Основание")
    private String basis;

    @Column(name = "Статус")
    private DocumentStatus status;

    @Column(name = "ОжидаемаяДатаПрихода")
    private Date expectedDateArrival;

    @Column(name = "НомерТрансфера")
    private Long transferNumber;

    @Column(name = "Корректировка")
    private String correction;

    @Column(name = "ТранзитныйСклад")
    private String transitWarehouse;

    @Column(name = "НомерТорг")
    private String tradeNumber;

    @Column(name = "Предоплата")
    private BigDecimal prepayment;

    @Column(name = "СтатусЗаказа")
    private String orderStatus;

    @Column(name = "GUID")
    private String guid;

    @Column(name = "GUID2")
    private String guidSecond;

    @Column(name = "IDDЗаказа")
    private String orderIdd;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "ВремяРедактирования")
    private String timeEdited;

    @Column(name = "ДатаСоздания")
    private Date dateCreated;

    @Column(name = "ВремяДокум")
    private String timeDoc;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<MovingDocumentItem> items;

    @OneToOne(mappedBy = "movingDocument")
    private Journal journal;

    @OneToOne(mappedBy = "movingDocument")
    private AcceptanceDocument acceptanceDocument;

    @OneToOne(mappedBy = "movingDocument")
    private RouteList routeList;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getDocOrigin() {
        return docOrigin;
    }

    public void setDocOrigin(String docOrigin) {
        this.docOrigin = docOrigin;
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

    public String getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(String collectedBy) {
        this.collectedBy = collectedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCompanyReceiver() {
        return companyReceiver;
    }

    public void setCompanyReceiver(String companyReceiver) {
        this.companyReceiver = companyReceiver;
    }

    public String getFinalWarehouse() {
        return finalWarehouse;
    }

    public void setFinalWarehouse(String finalWarehouse) {
        this.finalWarehouse = finalWarehouse;
    }

    public BigDecimal getCourse() {
        return course;
    }

    public void setCourse(BigDecimal course) {
        this.course = course;
    }

    public BigDecimal getQuantityPlaces() {
        return quantityPlaces;
    }

    public void setQuantityPlaces(BigDecimal quantityPlaces) {
        this.quantityPlaces = quantityPlaces;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public Date getExpectedDateArrival() {
        return expectedDateArrival;
    }

    public void setExpectedDateArrival(Date expectedDateArrival) {
        this.expectedDateArrival = expectedDateArrival;
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

    public String getGuidSecond() {
        return guidSecond;
    }

    public void setGuidSecond(String guidSecond) {
        this.guidSecond = guidSecond;
    }

    public String getOrderIdd() {
        return orderIdd;
    }

    public void setOrderIdd(String orderIdd) {
        this.orderIdd = orderIdd;
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

    public String getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(String timeEdited) {
        this.timeEdited = timeEdited;
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

    public List<MovingDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<MovingDocumentItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public AcceptanceDocument getAcceptanceDocument() {
        return acceptanceDocument;
    }

    public void setAcceptanceDocument(AcceptanceDocument acceptanceDocument) {
        this.acceptanceDocument = acceptanceDocument;
    }

    public RouteList getRouteList() {
        return routeList;
    }

    public void setRouteList(RouteList routeList) {
        this.routeList = routeList;
    }
}
