package ru.gloria_jeans.onecdbmapper.dao.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "Справочник.Сотрудники")
public class Employee extends BaseCatalog {
    @Column(name = "IDD")
    private String idd;

    @Column(name = "База")
    private String base;

    @Column(name = "Уволен")
    private int fired;

//    @Column(name = "Должность")
//    private String position;

    @Column(name = "ИНН")
    private String inn;

    @Column(name = "ПаспортныеДанные")
    private String idCard;

    @Column(name = "DESCR")
    private String name;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "Должность", referencedColumnName = "ID", insertable = false, updatable = false)
    private Position position;

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getFired() {
        return fired;
    }

    public void setFired(int fired) {
        this.fired = fired;
    }

//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
