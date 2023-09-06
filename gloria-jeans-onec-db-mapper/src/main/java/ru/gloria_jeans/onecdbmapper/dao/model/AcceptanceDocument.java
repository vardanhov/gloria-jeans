package ru.gloria_jeans.onecdbmapper.dao.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.ПриемныйАкт")
public class AcceptanceDocument implements Serializable {
    @Id
    @Column(name = "IDDOC")
    private String iddoc;

    @Column(name = "ДокОснование")
    private String docBasis;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "ФирмаПолучатель")
    private String recipientCompany;

    @Column(name = "СкладПолучатель")
    private String recipientWarehouse;

    @Column(name = "Принял")
    private String acceptedBy;

    @Column(name = "Оформил")
    private String createdBy;

    @Column(name = "Основание")
    private String basis;

    @Column(name = "НомерТрансфера")
    private Integer transferNumber;

    @Column(name = "КоличествоФакт")
    private Integer factQuantity;

    @Column(name = "Сумма")
    private Integer sum;

    @Column(name = "ВремяРедактирования")
    private String timeEdited;

    @Column(name = "ДатаСоздания")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name = "ВремяДокум")
    private String timeDoc;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<AcceptanceDocumentItem> items;

    @OneToOne(mappedBy = "acceptanceDocument")
    private Journal journal;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "ДокОснование", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private MovingDocument movingDocument;

    public String getIddoc() {
        return iddoc;
    }

    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }

    public String getDocBasis() {
        return docBasis;
    }

    public void setDocBasis(String docBasis) {
        this.docBasis = docBasis;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getRecipientCompany() {
        return recipientCompany;
    }

    public void setRecipientCompany(String recipientCompany) {
        this.recipientCompany = recipientCompany;
    }

    public String getRecipientWarehouse() {
        return recipientWarehouse;
    }

    public void setRecipientWarehouse(String recipientWarehouse) {
        this.recipientWarehouse = recipientWarehouse;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public Integer getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(Integer transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Integer getFactQuantity() {
        return factQuantity;
    }

    public void setFactQuantity(Integer factQuantity) {
        this.factQuantity = factQuantity;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
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

    public List<AcceptanceDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<AcceptanceDocumentItem> items) {
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
