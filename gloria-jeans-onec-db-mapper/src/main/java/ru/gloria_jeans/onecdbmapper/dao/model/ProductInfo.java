package ru.gloria_jeans.onecdbmapper.dao.model;

import ru.gloria_jeans.onecdbmapper.dao.enums.ProductType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Справочник.Номенклатура")
public class ProductInfo extends BaseCatalog {
    @Column(name = "CODE")
    private String code;

    @Column(name = "IDD")
    private String idd;

    @Column(name ="IDDАналога")
    private String iddAnalog;

    @Column(name = "Артикул")
    private String vendorCode;

    @Column(name = "БазоваяЕдиница")
    private String baseUnit;

    @Column(name = "Весовой")
    private boolean weight;

    @Column(name = "ВидНоменклатуры")
    private String kind;

    @Column(name = "ВидТовара")
    private String productKind;

    @Column(name = "КодМодели")
    private String modelCode;

    @Column(name = "КодПММ")
    private String pmmCode;

    @Column(name = "МинОстаток")
    private BigDecimal minBalance;

    @Column(name = "НеВключатьВпрайс")
    private boolean excludeFromPrice;

    @Column(name = "НомерГТД")
    private String gtdNumber;

    @Column(name = "ОсновнаяЕдиница")
    private String mainUnit;

    @Column(name = "ОсновноеСвойство")
    private String mainProperty;

    @Column(name = "СтавкаНДС")
    private String ndsRate;

    @Column(name = "СтавкаНП")
    private String nppRate;

    @Column(name = "СтранаПроисхождения")
    private String countryOfOrigin;

    @Column(name = "ШтрихКод")
    private String barcode;

    @Column(name = "ТоварГруппа")
    private String productGroup;

    @Column(name = "Комментарий")
    private String comment;

    @Column(name = "ПолнНаименование")
    private String fullName;

    @Column(name = "КодТипаМарки")
    private String markTypeCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getIddAnalog() {
        return iddAnalog;
    }

    public void setIddAnalog(String iddAnalog) {
        this.iddAnalog = iddAnalog;
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

    public boolean isWeight() {
        return weight;
    }

    public void setWeight(boolean weight) {
        this.weight = weight;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getProductKind() {
        return ProductType.getName(productKind);
    }

    public void setProductKind(String productKind) {
        this.productKind = ProductType.getValue(productKind);
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

    public boolean isExcludeFromPrice() {
        return excludeFromPrice;
    }

    public void setExcludeFromPrice(boolean excludeFromPrice) {
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

    public String getNppRate() {
        return nppRate;
    }

    public void setNppRate(String nppRate) {
        this.nppRate = nppRate;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
}
