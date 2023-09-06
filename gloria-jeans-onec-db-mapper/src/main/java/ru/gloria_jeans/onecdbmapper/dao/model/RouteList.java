package ru.gloria_jeans.onecdbmapper.dao.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.МаршрутныйЛист")
public class RouteList {

    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "НомерПеремещения")
    private String receivingNumber;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "СкладПолучатель")
    private String warehouseRecipient;

    @Column(name = "КоличествоМест")
    private BigDecimal numberOfLocations;

    @Column(name = "КоличествоЕдиниц")
    private BigDecimal numberOfUnits;

    @Column(name = "ДатаПеремещения")
    private Date dateOfTransfer;

    @Column(name = "IDDПеремещения")
    private String transferIdd;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "ДокОснование")
    private String docBasis;

    @Column(name = "Пользователь")
    private String user;

    @Column(name = "СуммаРозн")
    private BigDecimal sumRetail;

    @Column(name = "ВремяРедактирования")
    private String editTime;

    @Column(name = "ДатаСоздания")
    private Date createdDate;

    @Column(name = "ВремяДокум")
    private String documentTime;

    @Column(name = "СЗТранзитныеСклады")
    private String szTransitWarehouses;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<RouteListItem> items;

    @OneToOne(mappedBy = "routeList", cascade = CascadeType.ALL)
    private Journal journal;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "ДокОснование", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private MovingDocument movingDocument;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getReceivingNumber() {
        return receivingNumber;
    }

    public void setReceivingNumber(String receivingNumber) {
        this.receivingNumber = receivingNumber;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehouseRecipient() {
        return warehouseRecipient;
    }

    public void setWarehouseRecipient(String warehouseRecipient) {
        this.warehouseRecipient = warehouseRecipient;
    }

    public BigDecimal getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setNumberOfLocations(BigDecimal numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public BigDecimal getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(BigDecimal numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Date getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(Date dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }

    public String getTransferIdd() {
        return transferIdd;
    }

    public void setTransferIdd(String transferIdd) {
        this.transferIdd = transferIdd;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getDocBasis() {
        return docBasis;
    }

    public void setDocBasis(String docBasis) {
        this.docBasis = docBasis;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigDecimal getSumRetail() {
        return sumRetail;
    }

    public void setSumRetail(BigDecimal sumRetail) {
        this.sumRetail = sumRetail;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDocumentTime() {
        return documentTime;
    }

    public void setDocumentTime(String documentTime) {
        this.documentTime = documentTime;
    }

    public String getSzTransitWarehouses() {
        return szTransitWarehouses;
    }

    public void setSzTransitWarehouses(String szTransitWarehouses) {
        this.szTransitWarehouses = szTransitWarehouses;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<RouteListItem> getItems() {
        return items;
    }

    public void setItems(List<RouteListItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public MovingDocument getMovingDocument() {
        return movingDocument;
    }

    public void setMovingDocument(MovingDocument movingDocument) {
        this.movingDocument = movingDocument;
    }
}
