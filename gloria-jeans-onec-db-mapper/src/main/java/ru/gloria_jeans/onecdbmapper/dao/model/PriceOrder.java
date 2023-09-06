package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="Документ.ПриказПоЦенам")
public class PriceOrder implements Serializable {
    @Id
    @Column(name = "IDDOC")
    private String iddoc;

    @Column(name = "Распродажа")
    private Integer sale;

    @Column(name = "УстановитьСнятьРаспродажу")
    private Integer installUninstallSale;

    @Column(name = "ТипУстЦены")
    private Integer priceType;

    @Column(name = "ТипЦеныPF")
    private String priceTypePF;

    @Column(name = "ВремяРедактирования")
    private String updatedTime;

    @Column(name = "ДатаСоздания")
    private Date createdDate;

    @Column(name = "ВремяДокум")
    private String timeDocument;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "priceOrder")
//    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<PriceOrderItem> items;

    public String getIddoc() {
        return iddoc;
    }

    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getInstallUninstallSale() {
        return installUninstallSale;
    }

    public void setInstallUninstallSale(Integer installUninstallSale) {
        this.installUninstallSale = installUninstallSale;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTimeDocument() {
        return timeDocument;
    }

    public void setTimeDocument(String timeDocument) {
        this.timeDocument = timeDocument;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<PriceOrderItem> getItems() {
        return items;
    }

    public void setItems(List<PriceOrderItem> items) {
        this.items = items;
    }

    public String getPriceTypePF() {
        return priceTypePF;
    }

    public void setPriceTypePF(String priceTypePF) {
        this.priceTypePF = priceTypePF;
    }
}
