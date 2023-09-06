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
@Table(name = "warehouse_open_lot")
public class OpenLot implements Serializable {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "lot_idd")
    private String lotIdd;

    @Column(name = "document_idd")
    private String documentIdd;

    @Column(name = "product_idd")
    private String productIdd;

    @Column(name = "original_id_lot")
    private String originalIdLot;

    @Column(name = "original_id")
    private String originalId;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "barcode_box")
    private String barcodeBox;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "fact_quantity")
    private Integer factQuantity;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "vat")
    private BigDecimal vat;

    @Column(name = "mark_type_code")
    private String markTypeCode;

    @Column(name = "unit")
    private String unit;

    @Column(name = "nds_rate")
    private String ndsRate;

    @Column(name = "line_number_lot")
    private Integer lineNumberLot;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "open_lot_id", referencedColumnName = "id")
    private List<ScannedMark> scannedMarks = new ArrayList<>();

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "document_idd", referencedColumnName = "document_idd", insertable = false, updatable = false),
            @JoinColumn(name = "lot_idd", referencedColumnName = "idd", insertable = false, updatable = false),
            @JoinColumn(name = "line_number_lot", referencedColumnName = "line_number", insertable = false, updatable = false)
    })
    private Product product;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLotIdd() {
        return lotIdd;
    }

    public void setLotIdd(String lotIdd) {
        this.lotIdd = lotIdd;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }

    public String getProductIdd() {
        return productIdd;
    }

    public void setProductIdd(String productIdd) {
        this.productIdd = productIdd;
    }

    public String getOriginalIdLot() {
        return originalIdLot;
    }

    public void setOriginalIdLot(String originalIdLot) {
        this.originalIdLot = originalIdLot;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Integer getFactQuantity() {
        return factQuantity;
    }

    public void setFactQuantity(Integer factQuantity) {
        this.factQuantity = factQuantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String getMarkTypeCode() {
        return markTypeCode;
    }

    public void setMarkTypeCode(String markTypeCode) {
        this.markTypeCode = markTypeCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNdsRate() {
        return ndsRate;
    }

    public void setNdsRate(String ndsRate) {
        this.ndsRate = ndsRate;
    }

    public List<ScannedMark> getScannedMarks() {
        return scannedMarks;
    }

    public void setScannedMarks(List<ScannedMark> scannedMarks) {
        this.scannedMarks = scannedMarks;
    }

    public Integer getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(Integer lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
