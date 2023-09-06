package ru.gloria_jeans.onecdbmapper.dao.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ru.gloria_jeans.onecdbmapper.Utils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Журналы")
public class Journal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", insertable = false)
    private int id;

    @Column(name = "DNPREFIX")
    private String dnprefix;

    @Column(name = "Заказы")
    private int orders;

    @Column(name = "CLOSED")
    private int closed;

    @Column(name = "ПодотчетныеЛица")
    private int subcontacts;

    @Column(name = "IDD")
    private String idd;

//    @Column(name = "ДатаСоздания")
//    private Date creationDate;

    @Column(name = "ПартииОтданные")
    private int delivered;

    @Column(name = "КассаФин")
    private int cash;

//    @Column(name = "ВремяРедактирования")
//    private int editTime;

    @Column(name = "Заявки")
    private int requests;

    @Column(name = "APPCODE")
    private short appcode;

    @Column(name = "ЗаказыЗаявки")
    private int ordersRequests;

    @Column(name = "ДатаРедактирования")
    private Date editDate;

    @Column(name = "ACTCNT")
    private int actcnt;

    @Column(name = "VERSTAMP")
    private int verstamp;

    @Column(name = "РезервыТМЦ")
    private int reserves;

    @Column(name = "Автор")
    private String author;

//    @Column(name = "Комментарий")
//    private String comment;

    @Column(name = "ОстаткиТМЦ")
    private int tmc;

    @Column(name = "IDJOURNAL")
    private int idjournal;

    @Column(name = "DATE_TIME_IDDOC")
    private String dateTimeIdDoc;

    @Column(name = "Поставщики")
    private int suppliers;

    @Column(name = "ВыгрузкаPMM")
    private int pmm;

    @Column(name = "Проект")
    private String project;

//    @Column(name = "ВремяДокум")
//    private int timeDoc;

    @Column(name = "ISMARK")
    private int ismark;

    @Column(name = "Фирма")
    private String firm;

    @Column(name = "ЮрЛицо")
    private String jurPerson;

    @Column(name = "Банк")
    private int bank;

    @Column(name = "ПартииНаличие")
    private int availability;

    @Column(name = "IDDOCDEF")
    private int idocdef;

    @Column(name = "IDDOC")
    private String idoc;

    @Column(name = "DOCNO")
    private String docno;

    @Column(name = "РеализованныйТовар")
    private int realized;

    @Column(name = "Продажи")
    private int sales;

    @Column(name = "Касса")
    private int cashbox;

    @Column(name = "КнигаПродаж")
    private int salesBook;

    @Column(name = "КнигаПокупок")
    private int purchasesBook;

    @Column(name = "Последовательность.КнигаПродаж")
    private int salesBookDs;

    @Column(name = "Последовательность.КнигаПокупок")
    private int purchasesBookDs;

    @Column(name = "Последовательность.ОсновнаяПоследовательность")
    private int mainSequenceDs;

    @Column(name = "Покупатели")
    private int buyers;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private MovingDocument movingDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private AcceptanceDocument acceptanceDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private MismatchDocument mismatchDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private PackageErrorContentsDocument packageErrorContentsDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private OrderDocument orderDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private Receipt receipt;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private OrderClosureDocument orderClosureDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private WriteOffDocument writeOffDocument;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private RouteList routeList;

    @OneToOne()
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "IDDOC", referencedColumnName = "IDDOC", insertable = false, updatable = false)
    private SalesBanDocument salesBanDocument;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDnprefix() {
        return dnprefix;
    }

    public void setDnprefix(String dnprefix) {
        this.dnprefix = dnprefix;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public int getSubcontacts() {
        return subcontacts;
    }

    public void setSubcontacts(int subcontacts) {
        this.subcontacts = subcontacts;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }

    public short getAppcode() {
        return appcode;
    }

    public void setAppcode(short appcode) {
        this.appcode = appcode;
    }

    public int getOrdersRequests() {
        return ordersRequests;
    }

    public void setOrdersRequests(int ordersRequests) {
        this.ordersRequests = ordersRequests;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getActcnt() {
        return actcnt;
    }

    public void setActcnt(int actcnt) {
        this.actcnt = actcnt;
    }

    public int getVerstamp() {
        return verstamp;
    }

    public void setVerstamp(int verstamp) {
        this.verstamp = verstamp;
    }

    public int getReserves() {
        return reserves;
    }

    public void setReserves(int reserves) {
        this.reserves = reserves;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTmc() {
        return tmc;
    }

    public void setTmc(int tmc) {
        this.tmc = tmc;
    }

    public int getIdjournal() {
        return idjournal;
    }

    public void setIdjournal(int idjournal) {
        this.idjournal = idjournal;
    }

    public String getDateTimeIdDoc() {
        return dateTimeIdDoc;
    }

    public void setDateTimeIdDoc(String dateTimeIdDoc) {
        this.dateTimeIdDoc = dateTimeIdDoc;
    }

    public int getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(int suppliers) {
        this.suppliers = suppliers;
    }

    public int getPmm() {
        return pmm;
    }

    public void setPmm(int pmm) {
        this.pmm = pmm;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getIsmark() {
        return ismark;
    }

    public void setIsmark(int ismark) {
        this.ismark = ismark;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getJurPerson() {
        return jurPerson;
    }

    public void setJurPerson(String jurPerson) {
        this.jurPerson = jurPerson;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getIdocdef() {
        return idocdef;
    }

    public void setIdocdef(int idocdef) {
        this.idocdef = idocdef;
    }

    public String getIdoc() {
        return idoc;
    }

    public void setIdoc(String idoc) {
        this.idoc = idoc;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }

    public int getRealized() {
        return realized;
    }

    public void setRealized(int realized) {
        this.realized = realized;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getCashbox() {
        return cashbox;
    }

    public void setCashbox(int cashbox) {
        this.cashbox = cashbox;
    }

    public int getSalesBook() {
        return salesBook;
    }

    public void setSalesBook(int salesBook) {
        this.salesBook = salesBook;
    }

    public int getPurchasesBook() {
        return purchasesBook;
    }

    public void setPurchasesBook(int purchasesBook) {
        this.purchasesBook = purchasesBook;
    }

    public int getSalesBookDs() {
        return salesBookDs;
    }

    public void setSalesBookDs(int salesBookDs) {
        this.salesBookDs = salesBookDs;
    }

    public int getPurchasesBookDs() {
        return purchasesBookDs;
    }

    public void setPurchasesBookDs(int purchasesBookDs) {
        this.purchasesBookDs = purchasesBookDs;
    }

    public int getMainSequenceDs() {
        return mainSequenceDs;
    }

    public void setMainSequenceDs(int mainSequenceDs) {
        this.mainSequenceDs = mainSequenceDs;
    }

    public int getBuyers() {
        return buyers;
    }

    public void setBuyers(int buyers) {
        this.buyers = buyers;
    }

    public MovingDocument getMovingDocument() {
        return movingDocument;
    }

    public void setMovingDocument(MovingDocument movingDocument) {
        this.movingDocument = movingDocument;
    }

    public AcceptanceDocument getAcceptanceDocument() {
        return acceptanceDocument;
    }

    public void setAcceptanceDocument(AcceptanceDocument acceptanceDocument) {
        this.acceptanceDocument = acceptanceDocument;
    }

    public MismatchDocument getMismatchDocument() {
        return mismatchDocument;
    }

    public void setMismatchDocument(MismatchDocument mismatchDocument) {
        this.mismatchDocument = mismatchDocument;
    }

    public PackageErrorContentsDocument getPackageErrorContentsDocument() {
        return packageErrorContentsDocument;
    }

    public void setPackageErrorContentsDocument(PackageErrorContentsDocument packageErrorContentsDocument) {
        this.packageErrorContentsDocument = packageErrorContentsDocument;
    }

    public OrderDocument getOrderDocument() {
        return orderDocument;
    }

    public void setOrderDocument(OrderDocument orderDocument) {
        this.orderDocument = orderDocument;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public OrderClosureDocument getOrderClosureDocument() {
        return orderClosureDocument;
    }

    public void setOrderClosureDocument(OrderClosureDocument orderClosureDocument) {
        this.orderClosureDocument = orderClosureDocument;
    }

    public WriteOffDocument getWriteOffDocument() {
        return writeOffDocument;
    }

    public void setWriteOffDocument(WriteOffDocument writeOffDocument) {
        this.writeOffDocument = writeOffDocument;
    }

    public RouteList getRouteList() {
        return routeList;
    }

    public void setRouteList(RouteList routeList) {
        this.routeList = routeList;
    }

    public SalesBanDocument getSalesBanDocument() {
        return salesBanDocument;
    }

    public void setSalesBanDocument(SalesBanDocument salesBanDocument) {
        this.salesBanDocument = salesBanDocument;
    }

    public Date getDocDate() {
        try {
            return Utils.convertDateTimeIdDocToDate(this.dateTimeIdDoc);
        } catch (Exception ex) {
            return null;
        }
    }
}
