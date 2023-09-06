package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.ЗапретПродаж")
public class SalesBanDocument implements Serializable {

    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "Основание")
    private String basis;

    @Column(name = "Назначение")
    private String destination;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "ДатаДействия")
    private Date validityDate;

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
    private List<SalesBanDocumentItem> items;

    @OneToOne(mappedBy = "salesBanDocument")
    private Journal journal;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
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

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<SalesBanDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<SalesBanDocumentItem> items) {
        this.items = items;
    }
}
