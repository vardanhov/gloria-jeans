package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Справочник.Банки")
public class Bank extends BaseCatalog {
    @Column(name = "ISFOLDER")
    private boolean isFolder;

    /**
     * Местонахождение
     */
    @Column(name = "Местонахождение")
    private String location;

    /**
     * КоррСчет
     */
    @Column(name = "КоррСчет")
    private String corrAccount;

    /**
     * Адрес
     */
    @Column(name = "Адрес")
    private String address;

    /**
     * Телефоны
     */
    @Column(name = "Телефоны")
    private String phones;

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCorrAccount() {
        return corrAccount;
    }

    public void setCorrAccount(String corrAccount) {
        this.corrAccount = corrAccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }
}
