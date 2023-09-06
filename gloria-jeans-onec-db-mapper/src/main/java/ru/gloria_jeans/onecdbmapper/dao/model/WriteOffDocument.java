package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.Списание")
public class WriteOffDocument implements Serializable {
    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "Общий")
    private BigDecimal common;

    @Column(name = "ВидСписания")
    private String writeOffType;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "ВремяРедактирования")
    private String timeEdited;

    @Column(name = "ДатаСоздания")
    private Date dateCreated;

    @Column(name = "ВремяДокум")
    private String timeDoc;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "IDDOC",
            referencedColumnName = "IDDOC"
    )
    private List<WriteOffDocumentItem> items;

    @OneToOne(mappedBy = "writeOffDocument")
    private Journal journal;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public BigDecimal getCommon() {
        return common;
    }

    public void setCommon(BigDecimal common) {
        this.common = common;
    }

    public String getWriteOffType() {
        return writeOffType;
    }

    public void setWriteOffType(String writeOffType) {
        this.writeOffType = writeOffType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
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

    public List<WriteOffDocumentItem> getItems() {
        return items;
    }

    public void setItems(List<WriteOffDocumentItem> items) {
        this.items = items;
    }
}
