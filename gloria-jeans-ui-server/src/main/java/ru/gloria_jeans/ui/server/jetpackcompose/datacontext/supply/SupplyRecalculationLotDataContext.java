package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyRecalculationLotDataContext extends SupplyRecalculationBoxDataContext {
    private String type = StringUtils.EMPTY;
    private String documentNumber = StringUtils.EMPTY;
    private String docDate = StringUtils.EMPTY;
    private String lotName = StringUtils.EMPTY;
    private String finish = StringUtils.EMPTY;
    private String barcodeProduct = StringUtils.EMPTY;
    private String lineNumberLot = StringUtils.EMPTY;
    private Boolean isNotCountQuantityLot = false;
    private Integer lineNumber;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getBarcodeProduct() {
        return barcodeProduct;
    }

    public void setBarcodeProduct(String barcodeProduct) {
        this.barcodeProduct = barcodeProduct;
    }

    public String getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(String lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }

    public Boolean getNotCountQuantityLot() {
        return isNotCountQuantityLot;
    }

    public void setNotCountQuantityLot(Boolean notCountQuantityLot) {
        isNotCountQuantityLot = notCountQuantityLot;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
}
