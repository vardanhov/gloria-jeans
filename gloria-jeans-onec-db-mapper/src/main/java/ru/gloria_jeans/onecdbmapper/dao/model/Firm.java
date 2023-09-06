package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Справочник.Фирмы")
public class Firm extends BaseCatalog {
    /**
     * ЮрЛицо
     */
    @Column(name = "ЮрЛицо")
    private String entity;

    /**
     * УпрАналитика
     */
    @Column(name = "УпрАналитика")
    private String analytics;

    /**
     * ОсновнойСчет
     */
    @Column(name = "ОсновнойСчет")
    private String mainAccount;

    /**
     * Идентификатор
     */
    @Column(name = "Идентификатор")
    private String identifier;

    /**
     * ЭлПочта
     */
    @Column(name = "ЭлПочта")
    private String email;

    /**
     * Комментарий
     */
    @Column(name = "Комментарий")
    private String comment;

    /**
     * IDD код
     */
    @Column(name = "IDD")
    private String idd;

    /**
     * Полннаименование1
     */
    @Column(name = "Полннаименование1")
    private String fullName1;

    /**
     * Руководитель
     */
    @Column(name = "Руководитель")
    private String manager;

    /**
     * Телефоны
     */
    @Column(name = "Телефоны")
    private String phones;

    /**
     * ЮридическийАдрес
     */
    @Column(name = "ЮридическийАдрес")
    private String legalAddress;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAnalytics() {
        return analytics;
    }

    public void setAnalytics(String analytics) {
        this.analytics = analytics;
    }

    public String getMainAccount() {
        return mainAccount;
    }

    public void setMainAccount(String mainAccount) {
        this.mainAccount = mainAccount;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getFullName1() {
        return fullName1;
    }

    public void setFullName1(String fullName1) {
        this.fullName1 = fullName1;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }
}
