package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.ОшибкиКомплектации")
public class PackageErrorContentsDocument implements Serializable {
    @Id
    @Column(name = "IDDOC")
    private String iddoc;

    @Column(name = "ДокОснование")
    private String docBasis;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "ДатаТранзакции")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "ВремяТранзакции")
    private String transactionTime;

    @Column(name = "Валюта")
    private String currency;

    @Column(name = "Дата_курса")
    @Temporal(TemporalType.DATE)
    private Date currencyDate;

    @Column(name = "Курс")
    private BigDecimal rate;

    @Column(name = "Обнаруживший")
    private String discoverer;

    @Column(name = "IDDДокументаОснования")
    private String iddDocBasis;

    @Column(name = "ВремяРедактирования")
    private String updatedTime;

    @Column(name = "ДатаСоздания")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "ВремяДокум")
    private String documentTime;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<PackageErrorContentsDocumentItem> items;

    @OneToOne(mappedBy = "packageErrorContentsDocument")
    private Journal journal;

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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCurrencyDate() {
        return currencyDate;
    }

    public void setCurrencyDate(Date currencyDate) {
        this.currencyDate = currencyDate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getDiscoverer() {
        return discoverer;
    }

    public void setDiscoverer(String discoverer) {
        this.discoverer = discoverer;
    }

    public String getIddDocBasis() {
        return iddDocBasis;
    }

    public void setIddDocBasis(String iddDocBasis) {
        this.iddDocBasis = iddDocBasis;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDocumentTime() {
        return documentTime;
    }

    public void setDocumentTime(String documentTime) {
        this.documentTime = documentTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<PackageErrorContentsDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<PackageErrorContentsDocumentItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }
}
