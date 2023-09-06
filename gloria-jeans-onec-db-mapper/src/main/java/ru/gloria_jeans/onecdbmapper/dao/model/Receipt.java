package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Документ.ЧекККМ")
public class Receipt implements Serializable, Cloneable {

    @Id
    @Column(name = "IDDOC")
    private String idDoc;

    @Column(name = "Валюта")
    private String currency;

    @Column(name = "ВидОперации")
    private String operationType;

    @Column(name = "ДатаЦены")
    private Date priceDate;

    @Column(name = "ДК")
    private String dk;

    @Column(name = "ДокОснование")
    private String docBasis;

    @Column(name = "Касса")
    private String cashbox;

    @Column(name = "КредитВнешний")
    private BigDecimal externalCredit;

    @Column(name = "КредитВнутренний")
    private BigDecimal internalCredit;

    @Column(name = "Курс")
    private BigDecimal course;

    @Column(name = "Модифицирован")
    private BigDecimal modified;

    @Column(name = "Наличные")
    private BigDecimal cash;

    @Column(name = "НомерЧекаККМ")
    private BigDecimal checkNumberKKM;

    @Column(name = "ПодарочныйСертификат")
    private String giftCertificate;

    @Column(name = "Получено")
    private BigDecimal received;

    @Column(name = "ПричинаВозврата")
    private String reasonReturn;

    @Column(name = "РучнойВвод")
    private BigDecimal manualInput;

    @Column(name = "Скидка")
    private String discount;

    @Column(name = "Склад")
    private String warehouse;

    @Column(name = "Сотрудник")
    private String employee;

    @Column(name = "ЧекПробитККМ")
    private BigDecimal checkPunchedKKM;

    @Column(name = "Статус")
    private BigDecimal status;

    @Column(name = "ТипКарты")
    private BigDecimal cardType;

    @Column(name = "СерийныйНомерККМ")
    private String serialNumberKKM;

    @Column(name = "СерийныйНомерФН")
    private String serialNumberFN;

    @Column(name = "НомерСмены")
    private BigDecimal shiftNumber;

    @Column(name = "НомерЧекаВСмене")
    private BigDecimal checkNumberInChange;

    @Column(name = "IDDДокументаОснования")
    private String iddBaseDocument;

    @Column(name = "Доп1")
    private String dop1;

    @Column(name = "КредитКаспи")
    private BigDecimal creditKaspi;

    @Column(name = "НаименованиеКарты")
    private String cardName;

    @Column(name = "ФП")
    private String fp;

    @Column(name = "РРН")
    private String ppn;

    @Column(name = "Мерчант")
    private String merchant;

    @Column(name = "Терминал")
    private String terminal;

    @Column(name = "РознКлиент")
    private String retailClient;

    @Column(name = "СистемаЛояльности")
    private String loyaltySystem;

    @Column(name = "Доп2")
    private String dop2;

    @Column(name = "ИДТранзакции")
    private String idTransaction;

    @Column(name = "СпособДоставки")
    private String deliveryMethod;

    @Column(name = "НомерЗаказа")
    private String orderNumber;

    @Column(name = "СпособОтгрузки")
    private String shippingMethod;

    @Column(name = "ВидЧека")
    private String checkType;

    @Column(name = "ТипОплаты")
    private String paymentType;

    @Column(name = "Количество")
    private BigDecimal quantity;

    @Column(name = "Сумма")
    private BigDecimal sum;

    @Column(name = "ВремяРедактирования")
    private String timeEdited;

    @Column(name = "ДатаСоздания")
    private Date dateCreated;

    @Column(name = "ВремяДокум")
    private String documentTime;

    @Column(name = "Комментарий")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC")
    private List<ReceiptItem> items;

    @OneToOne(mappedBy = "receipt")
    private Journal journal;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

    public String getDk() {
        return dk;
    }

    public void setDk(String dk) {
        this.dk = dk;
    }

    public String getDocBasis() {
        return docBasis;
    }

    public void setDocBasis(String docBasis) {
        this.docBasis = docBasis;
    }

    public String getCashbox() {
        return cashbox;
    }

    public void setCashbox(String cashbox) {
        this.cashbox = cashbox;
    }

    public BigDecimal getExternalCredit() {
        return externalCredit;
    }

    public void setExternalCredit(BigDecimal externalCredit) {
        this.externalCredit = externalCredit;
    }

    public BigDecimal getInternalCredit() {
        return internalCredit;
    }

    public void setInternalCredit(BigDecimal internalCredit) {
        this.internalCredit = internalCredit;
    }

    public BigDecimal getCourse() {
        return course;
    }

    public void setCourse(BigDecimal course) {
        this.course = course;
    }

    public BigDecimal getModified() {
        return modified;
    }

    public void setModified(BigDecimal modified) {
        this.modified = modified;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public BigDecimal getCheckNumberKKM() {
        return checkNumberKKM;
    }

    public void setCheckNumberKKM(BigDecimal checkNumberKKM) {
        this.checkNumberKKM = checkNumberKKM;
    }

    public String getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(String giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    public BigDecimal getReceived() {
        return received;
    }

    public void setReceived(BigDecimal received) {
        this.received = received;
    }

    public String getReasonReturn() {
        return reasonReturn;
    }

    public void setReasonReturn(String reasonReturn) {
        this.reasonReturn = reasonReturn;
    }

    public BigDecimal getManualInput() {
        return manualInput;
    }

    public void setManualInput(BigDecimal manualInput) {
        this.manualInput = manualInput;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public BigDecimal getCheckPunchedKKM() {
        return checkPunchedKKM;
    }

    public void setCheckPunchedKKM(BigDecimal checkPunchedKKM) {
        this.checkPunchedKKM = checkPunchedKKM;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public BigDecimal getCardType() {
        return cardType;
    }

    public void setCardType(BigDecimal cardType) {
        this.cardType = cardType;
    }

    public String getSerialNumberKKM() {
        return serialNumberKKM;
    }

    public void setSerialNumberKKM(String serialNumberKKM) {
        this.serialNumberKKM = serialNumberKKM;
    }

    public String getSerialNumberFN() {
        return serialNumberFN;
    }

    public void setSerialNumberFN(String serialNumberFN) {
        this.serialNumberFN = serialNumberFN;
    }

    public BigDecimal getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(BigDecimal shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public BigDecimal getCheckNumberInChange() {
        return checkNumberInChange;
    }

    public void setCheckNumberInChange(BigDecimal checkNumberInChange) {
        this.checkNumberInChange = checkNumberInChange;
    }

    public String getDop1() {
        return dop1;
    }

    public void setDop1(String dop1) {
        this.dop1 = dop1;
    }

    public BigDecimal getCreditKaspi() {
        return creditKaspi;
    }

    public void setCreditKaspi(BigDecimal creditKaspi) {
        this.creditKaspi = creditKaspi;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }

    public String getPpn() {
        return ppn;
    }

    public void setPpn(String ppn) {
        this.ppn = ppn;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getRetailClient() {
        return retailClient;
    }

    public void setRetailClient(String retailClient) {
        this.retailClient = retailClient;
    }

    public String getLoyaltySystem() {
        return loyaltySystem;
    }

    public void setLoyaltySystem(String loyaltySystem) {
        this.loyaltySystem = loyaltySystem;
    }

    public String getDop2() {
        return dop2;
    }

    public void setDop2(String dop2) {
        this.dop2 = dop2;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(String timeEdited) {
        this.timeEdited = timeEdited;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDocumentTime() {
        return documentTime;
    }

    public void setDocumentTime(String documentTime) {
        this.documentTime = documentTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ReceiptItem> items) {
        this.items = items;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public String getIddBaseDocument() {
        return iddBaseDocument;
    }

    public void setIddBaseDocument(String iddBaseDocument) {
        this.iddBaseDocument = iddBaseDocument;
    }

    @Override
    public Receipt clone() throws CloneNotSupportedException {
        return (Receipt) super.clone();
    }
}