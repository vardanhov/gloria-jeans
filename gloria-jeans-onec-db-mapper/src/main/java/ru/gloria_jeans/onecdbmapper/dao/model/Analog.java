package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Справочник.Аналоги")
public class Analog extends BaseCatalog {
    @Column(name = "Каталог")
    private String catalog;

    @Column(name = "ИдентификаторВКаталоге")
    private String idInCatalog;

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
}
