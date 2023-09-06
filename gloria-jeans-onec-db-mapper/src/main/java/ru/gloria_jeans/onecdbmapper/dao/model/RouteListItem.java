package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ДокументСтроки.МаршрутныйЛист")
public class RouteListItem {
    @EmbeddedId
    private IddocLinenumberIdentity iddocLinenumberIdentity;

    @Column(name = "ТранзитныйСклад")
    private String warehouseTransit;

    @Column(name = "ДатаПолучения")
    private Date dateOfReceipt;

    @Column(name = "ДатаОтправки")
    private Date dateOfShipment;

    @Column(name = "ШтрихкодОтправителя")
    private String barcodeSender;

    @Column(name = "ШтрихкодПолучателя")
    private String barcodeRecipient;

    public IddocLinenumberIdentity getIddocLinenumberIdentity() {
        return iddocLinenumberIdentity;
    }

    public void setIddocLinenumberIdentity(IddocLinenumberIdentity iddocLinenumberIdentity) {
        this.iddocLinenumberIdentity = iddocLinenumberIdentity;
    }

    public String getWarehouseTransit() {
        return warehouseTransit;
    }

    public void setWarehouseTransit(String warehouseTransit) {
        this.warehouseTransit = warehouseTransit;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public Date getDateOfShipment() {
        return dateOfShipment;
    }

    public void setDateOfShipment(Date dateOfShipment) {
        this.dateOfShipment = dateOfShipment;
    }

    public String getBarcodeSender() {
        return barcodeSender;
    }

    public void setBarcodeSender(String barcodeSender) {
        this.barcodeSender = barcodeSender;
    }

    public String getBarcodeRecipient() {
        return barcodeRecipient;
    }

    public void setBarcodeRecipient(String barcodeRecipient) {
        this.barcodeRecipient = barcodeRecipient;
    }
}
