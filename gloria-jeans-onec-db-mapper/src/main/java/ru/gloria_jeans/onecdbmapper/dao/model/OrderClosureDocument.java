package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.ЗакрытиеЗаказа")
public class OrderClosureDocument implements Serializable {

    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "ДокОснование")
    private String docBasis;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "Валюта")
    private String currency;

    @Column(name = "Курс")
    private BigDecimal rate;

    @Column(name = "Основание")
    private String basis;

    @Column(name = "Количество")
    private BigDecimal quantity;

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
    private List<OrderClosureDocumentItem> items;

    @OneToOne(mappedBy = "orderClosureDocument", cascade = CascadeType.ALL)
    private Journal journal;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
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

    public List<OrderClosureDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<OrderClosureDocumentItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }
}


