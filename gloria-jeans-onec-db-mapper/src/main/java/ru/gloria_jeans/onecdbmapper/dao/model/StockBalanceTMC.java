package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "РегистрИтоги.ОстаткиТМЦ")
public class StockBalanceTMC implements Serializable {
    @EmbeddedId
    private StockBalanceTMCEmbeddedId stockBalanceTMCEmbeddedId;

    @Column(name = "Количество")
    private BigDecimal quantity;

    public StockBalanceTMCEmbeddedId getStockBalanceTMCEmbeddedId() {
        return stockBalanceTMCEmbeddedId;
    }

    public void setStockBalanceTMCEmbeddedId(StockBalanceTMCEmbeddedId stockBalanceTMCEmbeddedId) {
        this.stockBalanceTMCEmbeddedId = stockBalanceTMCEmbeddedId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getPeriod() {
        return stockBalanceTMCEmbeddedId.getPeriod();
    }

    public void setPeriod(Date period) {
        this.stockBalanceTMCEmbeddedId.setPeriod(period);
    }

    public String getFirm() {
        return stockBalanceTMCEmbeddedId.getFirm();
    }

    public void setFirm(String firm) {
        this.stockBalanceTMCEmbeddedId.setFirm(firm);
    }

    public String getItem() {
        return stockBalanceTMCEmbeddedId.getItem();
    }

    public void setItem(String item) {
        this.stockBalanceTMCEmbeddedId.setItem(item);
    }

    public String getWarehouse() {
        return stockBalanceTMCEmbeddedId.getWarehouse();
    }

    public void setWarehouse(String warehouse) {
        this.stockBalanceTMCEmbeddedId.setWarehouse(warehouse);
    }
}
