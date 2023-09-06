package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Справочник.БанковскиеСчета")
public class BankAccount extends BaseCatalog{
    @Column(name = "Банк")
    private String bank;

    @Column(name = "БанкДляРасчетов")
    private String bankForCalculations;

    @Column(name = "ВалютаСчета")
    private String currency;

    @Column(name = "ВидСчета")
    private String accountType;

    @Column(name = "ДатаЗакрытияСчета")
    private Date closeDate;

    @Column(name = "ДатаОткрытияСчета")
    private Date openDate;

    @Column(name = "МесяцПрописью")
    private BigDecimal monthInWords;

    @Column(name = "Назначение")
    private String purpose;

    @Column(name = "НомерИДатаРазрешения")
    private String numberAndDateOfResolution;

    @Column(name = "НомерСчета")
    private String number;

    @Column(name = "РеквизитыПлательщикаИлиПолучателя")
    private String payerOrReceiverDetails;

    @Column(name = "СуммаБез00Копеек")
    private BigDecimal amountWithout00Copecks;

    @Column(name = "ЮрФизЛицо")
    private String legalEntity;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankForCalculations() {
        return bankForCalculations;
    }

    public void setBankForCalculations(String bankForCalculations) {
        this.bankForCalculations = bankForCalculations;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public BigDecimal getMonthInWords() {
        return monthInWords;
    }

    public void setMonthInWords(BigDecimal monthInWords) {
        this.monthInWords = monthInWords;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNumberAndDateOfResolution() {
        return numberAndDateOfResolution;
    }

    public void setNumberAndDateOfResolution(String numberAndDateOfResolution) {
        this.numberAndDateOfResolution = numberAndDateOfResolution;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPayerOrReceiverDetails() {
        return payerOrReceiverDetails;
    }

    public void setPayerOrReceiverDetails(String payerOrReceiverDetails) {
        this.payerOrReceiverDetails = payerOrReceiverDetails;
    }

    public BigDecimal getAmountWithout00Copecks() {
        return amountWithout00Copecks;
    }

    public void setAmountWithout00Copecks(BigDecimal amountWithout00Copecks) {
        this.amountWithout00Copecks = amountWithout00Copecks;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }
}
