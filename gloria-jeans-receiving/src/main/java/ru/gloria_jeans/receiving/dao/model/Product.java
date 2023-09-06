package ru.gloria_jeans.receiving.dao.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Cacheable(false)
@Table(name = "warehouse_products")
public class Product implements Serializable, Cloneable {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "idd")
    private String idd;

    @Column(name = "document_idd")
    private String documentIdd;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "barcode_box")
    private String barcodeBox;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "base_unit")
    private String baseUnit;

    @Column(name = "is_weight")
    private Boolean isWeight;

    @Column(name = "kind_of")
    private String kindOf;

    @Column(name = "kind_of_product")
    private String kindOfProduct;

    @Column(name = "model_code")
    private String modelCode;

    @Column(name = "pmm_code")
    private String pmmCode;

    @Column(name = "min_balance")
    private BigDecimal minBalance;

    @Column(name = "exclude_from_price")
    private Boolean excludeFromPrice;

    @Column(name = "gtd_number")
    private String gtdNumber;

    @Column(name = "main_unit")
    private String mainUnit;

    @Column(name = "main_property")
    private String mainProperty;

    @Column(name = "nds_rate")
    private String ndsRate;

    @Column(name = "np_rate")
    private String npRate;

    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    @Column(name = "product_group")
    private String productGroup;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "mark_type_code")
    private String markTypeCode;

    @Column(name = "products_comment")
    private String comment;

    @Column(name = "idd_analog")
    private String iddAnalog;

    @Column(name = "line_number")
    private Integer lineNumber;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "quantity_fact")
    private Integer quantityFact;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "vat")
    private BigDecimal vat;

    @Column(name = "marks")
    private String marks;

    @Column(name = "without_marks")
    private Integer withoutMarks;

    @Column(name = "coefficient")
    private BigDecimal coefficient;

    @Column(name = "unit")
    private String unit;

    @Column(name = "reason_return")
    private String reasonReturn;

    @Column(name = "original_id")
    private String originalId;

    @Column(name = "original_idoc")
    private String originalIddoc;

    @ManyToOne()
    @JoinColumn(name = "document_idd", referencedColumnName = "idd", insertable = false, updatable = false)
    private Document document;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private List<ScannedMark> scannedMarks = new ArrayList<>();

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<OpenLot> productsIntoLot = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public Boolean getWeight() {
        return isWeight;
    }

    public void setWeight(Boolean weight) {
        isWeight = weight;
    }

    public String getKindOf() {
        return kindOf;
    }

    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    public String getKindOfProduct() {
        return kindOfProduct;
    }

    public void setKindOfProduct(String kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getPmmCode() {
        return pmmCode;
    }

    public void setPmmCode(String pmmCode) {
        this.pmmCode = pmmCode;
    }

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }

    public Boolean getExcludeFromPrice() {
        return excludeFromPrice;
    }

    public void setExcludeFromPrice(Boolean excludeFromPrice) {
        this.excludeFromPrice = excludeFromPrice;
    }

    public String getGtdNumber() {
        return gtdNumber;
    }

    public void setGtdNumber(String gtdNumber) {
        this.gtdNumber = gtdNumber;
    }

    public String getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit;
    }

    public String getMainProperty() {
        return mainProperty;
    }

    public void setMainProperty(String mainProperty) {
        this.mainProperty = mainProperty;
    }

    public String getNdsRate() {
        return ndsRate;
    }

    public void setNdsRate(String ndsRate) {
        this.ndsRate = ndsRate;
    }

    public String getNpRate() {
        return npRate;
    }

    public void setNpRate(String npRate) {
        this.npRate = npRate;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMarkTypeCode() {
        return markTypeCode;
    }

    public void setMarkTypeCode(String markTypeCode) {
        this.markTypeCode = markTypeCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIddAnalog() {
        return iddAnalog;
    }

    public void setIddAnalog(String iddAnalog) {
        this.iddAnalog = iddAnalog;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(Integer quantityFact) {
        this.quantityFact = quantityFact;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public Integer getWithoutMarks() {
        return withoutMarks;
    }

    public void setWithoutMarks(Integer withoutMarks) {
        this.withoutMarks = withoutMarks;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReasonReturn() {
        return reasonReturn;
    }

    public void setReasonReturn(String reasonReturn) {
        this.reasonReturn = reasonReturn;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getOriginalIddoc() {
        return originalIddoc;
    }

    public void setOriginalIddoc(String originalIddoc) {
        this.originalIddoc = originalIddoc;
    }

    public List<ScannedMark> getScannedMarks() {
        return scannedMarks;
    }

    public void setScannedMarks(List<ScannedMark> scannedMarks) {
        this.scannedMarks = scannedMarks;
    }

    public Product clone() throws CloneNotSupportedException {
        return (Product)super.clone();
    }

    public List<OpenLot> getProductsIntoLot() {
        return productsIntoLot;
    }

    public void setProductsIntoLot(List<OpenLot> productsIntoLot) {
        this.productsIntoLot = productsIntoLot;
    }
}
