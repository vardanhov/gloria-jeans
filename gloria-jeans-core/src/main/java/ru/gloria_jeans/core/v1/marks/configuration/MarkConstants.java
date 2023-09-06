package ru.gloria_jeans.core.v1.marks.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("marks.constants")
public class MarkConstants {
    private String retailIdd;
    private String continentIdd;
    private String ecommerceIdd;
    private String kazakhstanIdd;
    private String retailTin;
    private String continentTin;
    private String warehousesTin;
    private String ecommerceTin;
    private String kazakhstanTin;
    private String retailRrc;
    private String continentRrc;
    private String warehouseRrc;
    private String retailEdm;
    private String continentEdm;
    private String warehousesEdm;

    public String getRetailIdd() {
        return retailIdd;
    }

    public void setRetailIdd(String retailIdd) {
        this.retailIdd = retailIdd;
    }

    public String getContinentIdd() {
        return continentIdd;
    }

    public void setContinentIdd(String continentIdd) {
        this.continentIdd = continentIdd;
    }

    public String getEcommerceIdd() {
        return ecommerceIdd;
    }

    public void setEcommerceIdd(String ecommerceIdd) {
        this.ecommerceIdd = ecommerceIdd;
    }

    public String getKazakhstanIdd() {
        return kazakhstanIdd;
    }

    public void setKazakhstanIdd(String kazakhstanIdd) {
        this.kazakhstanIdd = kazakhstanIdd;
    }

    public String getRetailTin() {
        return retailTin;
    }

    public void setRetailTin(String retailTin) {
        this.retailTin = retailTin;
    }

    public String getContinentTin() {
        return continentTin;
    }

    public void setContinentTin(String continentTin) {
        this.continentTin = continentTin;
    }

    public String getWarehousesTin() {
        return warehousesTin;
    }

    public void setWarehousesTin(String warehousesTin) {
        this.warehousesTin = warehousesTin;
    }

    public String getEcommerceTin() {
        return ecommerceTin;
    }

    public void setEcommerceTin(String ecommerceTin) {
        this.ecommerceTin = ecommerceTin;
    }

    public String getKazakhstanTin() {
        return kazakhstanTin;
    }

    public void setKazakhstanTin(String kazakhstanTin) {
        this.kazakhstanTin = kazakhstanTin;
    }

    public String getRetailRrc() {
        return retailRrc;
    }

    public void setRetailRrc(String retailRrc) {
        this.retailRrc = retailRrc;
    }

    public String getContinentRrc() {
        return continentRrc;
    }

    public void setContinentRrc(String continentRrc) {
        this.continentRrc = continentRrc;
    }

    public String getWarehouseRrc() {
        return warehouseRrc;
    }

    public void setWarehouseRrc(String warehouseRrc) {
        this.warehouseRrc = warehouseRrc;
    }

    public String getRetailEdm() {
        return retailEdm;
    }

    public void setRetailEdm(String retailEdm) {
        this.retailEdm = retailEdm;
    }

    public String getContinentEdm() {
        return continentEdm;
    }

    public void setContinentEdm(String continentEdm) {
        this.continentEdm = continentEdm;
    }

    public String getWarehousesEdm() {
        return warehousesEdm;
    }

    public void setWarehousesEdm(String warehousesEdm) {
        this.warehousesEdm = warehousesEdm;
    }
}
