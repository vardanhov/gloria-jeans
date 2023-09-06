package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Справочник.Склады")
public class Warehouse extends BaseCatalog {
    @Column(name = "DESCR")
    private String name;

    @Column(name = "IDD")
    private String idd;

    @Column(name = "IDDБазы")
    private String dbIdd;

    @Column(name = "Адрес")
    private String address;

    @Column(name = "КатегорияЦен")
    private String priceCategory;

    @Column(name = "МОЛ")
    private String mol;

    @Column(name = "Назначение")
    private String destination;

    @Column(name = "НомерСекции")
    private String numberOfSection;

    @Column(name = "ОблагаетсяЕНВД")
    private String taxedEnvd;

    @Column(name = "РозничныйСклад")
    private String retailWarehouse;

    @Column(name = "Статус")
    private String status;

    @Column(name = "Телефон")
    private String phone;

    @Column(name = "Филиал")
    private String branch;

    @Column(name = "ПолучаетТоварУ")
    private String gettingProductFrom;

    @Column(name = "ТранзитныйСклад")
    private String transitWarehouse;

    @Column(name = "Гео")
    private String geo;

    @Column(name = "Метро")
    private String subway;

    @Column(name = "CODE")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getDbIdd() {
        return dbIdd;
    }

    public void setDbIdd(String dbIdd) {
        this.dbIdd = dbIdd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getMol() {
        return mol;
    }

    public void setMol(String mol) {
        this.mol = mol;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumberOfSection() {
        return numberOfSection;
    }

    public void setNumberOfSection(String numberOfSection) {
        this.numberOfSection = numberOfSection;
    }

    public String getTaxedEnvd() {
        return taxedEnvd;
    }

    public void setTaxedEnvd(String taxedEnvd) {
        this.taxedEnvd = taxedEnvd;
    }

    public String getRetailWarehouse() {
        return retailWarehouse;
    }

    public void setRetailWarehouse(String retailWarehouse) {
        this.retailWarehouse = retailWarehouse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGettingProductFrom() {
        return gettingProductFrom;
    }

    public void setGettingProductFrom(String gettingProductFrom) {
        this.gettingProductFrom = gettingProductFrom;
    }

    public String getTransitWarehouse() {
        return transitWarehouse;
    }

    public void setTransitWarehouse(String transitWarehouse) {
        this.transitWarehouse = transitWarehouse;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
