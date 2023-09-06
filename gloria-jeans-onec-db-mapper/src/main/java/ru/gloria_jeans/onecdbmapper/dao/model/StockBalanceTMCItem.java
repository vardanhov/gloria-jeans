package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Регистр.ОстаткиТМЦ")
public class StockBalanceTMCItem implements Serializable {
    @EmbeddedId
    private IddocLinenumberActionnumberIdentity iddocLinenumberIdentity;

    @Column(name = "DEBKRED")
    private Integer debkred;

    @Column(name = "Фирма")
    private String firm;

    @Column(name = "Номенклатура")
    private String item;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "КодОперации")
    private String operationCode;

    @Column(name = "Сумма")
    private BigDecimal sum;

    public IddocLinenumberActionnumberIdentity getIddocLinenumberIdentity() {
        return iddocLinenumberIdentity;
    }

    public void setIddocLinenumberIdentity(IddocLinenumberActionnumberIdentity iddocLinenumberIdentity) {
        this.iddocLinenumberIdentity = iddocLinenumberIdentity;
    }

    public Integer getDebkred() {
        return debkred;
    }

    public void setDebkred(Integer debkred) {
        this.debkred = debkred;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
