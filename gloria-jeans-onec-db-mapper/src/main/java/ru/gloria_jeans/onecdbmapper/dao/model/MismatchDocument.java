package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.АктНесоответствия")
public class MismatchDocument implements Serializable {
    @Id
    @Column(name = "IDDOC")
    private String IDDOC;

    @Column(name = "ДокОснование")
    private String docBasis;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "СкладПолучатель")
    private String warehouseRecipient;

    @Column(name = "ФирмаПолучатель")
    private String firmRecipient;

    @Column(name = "РазницаСумма")
    private BigDecimal differenceSum;

    @Column(name = "ВремяРедактирования")
    private String updatedAt;

    @Column(name ="ДатаСоздания")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name ="ВремяДокум")
    private String documentTime;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<MismatchDocumentItem> items;

    @OneToOne(mappedBy = "mismatchDocument")
    private Journal journal;

    public String getIddoc() {
        return IDDOC;
    }

    public void setIddoc(String IDDOC) {
        this.IDDOC = IDDOC;
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

    public String getWarehouseRecipient() {
        return warehouseRecipient;
    }

    public void setWarehouseRecipient(String warehouseRecipient) {
        this.warehouseRecipient = warehouseRecipient;
    }

    public String getFirmRecipient() {
        return firmRecipient;
    }

    public void setFirmRecipient(String firmRecipient) {
        this.firmRecipient = firmRecipient;
    }

    public BigDecimal getDifferenceSum() {
        return differenceSum;
    }

    public void setDifferenceSum(BigDecimal differenceSum) {
        this.differenceSum = differenceSum;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    public List<MismatchDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<MismatchDocumentItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }
}
