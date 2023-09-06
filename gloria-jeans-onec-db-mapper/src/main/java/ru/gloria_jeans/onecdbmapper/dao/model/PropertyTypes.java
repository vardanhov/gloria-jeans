package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Справочник.ВидыСвойств")
public class PropertyTypes extends BaseCatalog {
    @Column(name = "Каталог")
    private String catalog;

    @Column(name = "ИдентификаторВКаталоге")
    private String idInCatalog;

    @Column(name = "Множественность")
    private BigDecimal multiple;

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getIdInCatalog() {
        return idInCatalog;
    }

    public void setIdInCatalog(String idInCatalog) {
        this.idInCatalog = idInCatalog;
    }

    public BigDecimal getMultiple() {
        return multiple;
    }

    public void setMultiple(BigDecimal multiple) {
        this.multiple = multiple;
    }
}
