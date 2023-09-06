package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Справочник.Цены")
public class Price extends BaseCatalog {
    @Column(name ="PARENTEXT")
    private String parentext;

    @Column(name ="Валюта")
    private String currency;

    @Column(name ="Процент")
    private BigDecimal percentage;

    @Column(name ="ТипЦен")
    private String priceType;

    public String getParentext() {
        return parentext;
    }

    public void setParentext(String parentext) {
        this.parentext = parentext;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
}
