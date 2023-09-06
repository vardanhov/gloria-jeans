package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplySearchDataContext extends DataContext {
    private String iddDocument = Strings.EMPTY;
    private String iddAcceptanceDocument = Strings.EMPTY;
    private String idLot = Strings.EMPTY;
    private String barcodeBox = Strings.EMPTY;
    private String handleSearch = Strings.EMPTY;
    private String barcodeLot = Strings.EMPTY;
    private String scannedMark = Strings.EMPTY;
    private String createdAt = Strings.EMPTY;
    private String status = Strings.EMPTY;
    private String count = Strings.EMPTY;
    private String scanType = Strings.EMPTY;

    public String getIddDocument() {
        return iddDocument;
    }

    public void setIddDocument(String iddDocument) {
        this.iddDocument = iddDocument;
    }

    public String getIddAcceptanceDocument() {
        return iddAcceptanceDocument;
    }

    public void setIddAcceptanceDocument(String iddAcceptanceDocument) {
        this.iddAcceptanceDocument = iddAcceptanceDocument;
    }

    public String getIdLot() {
        return idLot;
    }

    public void setIdLot(String idLot) {
        this.idLot = idLot;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getHandleSearch() {
        return handleSearch;
    }

    public void setHandleSearch(String handleSearch) {
        this.handleSearch = handleSearch;
    }

    public String getBarcodeLot() {
        return barcodeLot;
    }

    public void setBarcodeLot(String barcodeLot) {
        this.barcodeLot = barcodeLot;
    }

    public String getScannedMark() {
        return scannedMark;
    }

    public void setScannedMark(String scannedMark) {
        this.scannedMark = scannedMark;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }
}
