package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Справочник.ПричиныПеремещений")
public class MovingReason extends BaseCatalog {

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "IDD")
    private String idd;

    @Column(name = "CODE")
    private String code;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
