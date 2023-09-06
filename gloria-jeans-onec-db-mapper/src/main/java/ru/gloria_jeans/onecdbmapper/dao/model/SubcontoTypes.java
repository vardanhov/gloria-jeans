package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Справочник.ВидыСубконто")
public class SubcontoTypes extends BaseCatalog {
    @Column(name = "ТипЗначенияТорг")
    private String type;

    @Column(name = "ТипЗначенияБух")
    private String typeBuh;

    @Column(name = "Идентификатор")
    private String identifier;

    @Column(name = "ИдРеквизита")
    private String requisiteId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeBuh() {
        return typeBuh;
    }

    public void setTypeBuh(String typeBuh) {
        this.typeBuh = typeBuh;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getRequisiteId() {
        return requisiteId;
    }

    public void setRequisiteId(String requisiteId) {
        this.requisiteId = requisiteId;
    }
}
