package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCollectOrdersContentOrderDataContext extends DataContext {
    private String documentNumber = StringUtils.EMPTY;
    private String barcodeBox = Strings.EMPTY;
    private String barcode = Strings.EMPTY;
    private String barcodeLabel = Strings.EMPTY;
    private String searchButtonText = Strings.EMPTY;
    private String confirmAssemblyOrderButtonText = Strings.EMPTY;
    private String packageSelectionButtonText = Strings.EMPTY;
    private String employeeSelectionButtonText = Strings.EMPTY;
    private String handleSearch = Strings.EMPTY;
    private String scannedSearch = Strings.EMPTY;
    private String titleText = Strings.EMPTY;
    private String bodyText = Strings.EMPTY;
    private String continueButtonText = Strings.EMPTY;
    private String exitButtonText = Strings.EMPTY;
    private Boolean updateUserId;
    private String userId = Strings.EMPTY;
    private String changeQuantityButtonText = Strings.EMPTY;
    private String clearPositionFactButtonText = Strings.EMPTY;
    private String removePositionButtonText = Strings.EMPTY;
    private String viewPositionImageButtonText = Strings.EMPTY;
    private String addMarkButton = Strings.EMPTY;
    private String orderItemId = Strings.EMPTY;
    private String dk = Strings.EMPTY;
    private String collectorFullName = Strings.EMPTY;
    private String reasonForAbsence = Strings.EMPTY;
    private String orderIdd = Strings.EMPTY;
    private String documentIdd = Strings.EMPTY;
    private String orderItemIdd = Strings.EMPTY;
    private String viewPictureButton = Strings.EMPTY;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getBarcodeBox() {
        return barcodeBox;
    }

    public void setBarcodeBox(String barcodeBox) {
        this.barcodeBox = barcodeBox;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcodeLabel() {
        return barcodeLabel;
    }

    public void setBarcodeLabel(String barcodeLabel) {
        this.barcodeLabel = barcodeLabel;
    }

    public String getSearchButtonText() {
        return searchButtonText;
    }

    public void setSearchButtonText(String searchButtonText) {
        this.searchButtonText = searchButtonText;
    }

    public String getConfirmAssemblyOrderButtonText() {
        return confirmAssemblyOrderButtonText;
    }

    public void setConfirmAssemblyOrderButtonText(String confirmAssemblyOrderButtonText) {
        this.confirmAssemblyOrderButtonText = confirmAssemblyOrderButtonText;
    }

    public String getPackageSelectionButtonText() {
        return packageSelectionButtonText;
    }

    public void setPackageSelectionButtonText(String packageSelectionButtonText) {
        this.packageSelectionButtonText = packageSelectionButtonText;
    }

    public String getEmployeeSelectionButtonText() {
        return employeeSelectionButtonText;
    }

    public void setEmployeeSelectionButtonText(String employeeSelectionButtonText) {
        this.employeeSelectionButtonText = employeeSelectionButtonText;
    }

    public String getHandleSearch() {
        return handleSearch;
    }

    public void setHandleSearch(String handleSearch) {
        this.handleSearch = handleSearch;
    }

    public String getScannedSearch() {
        return scannedSearch;
    }

    public void setScannedSearch(String scannedSearch) {
        this.scannedSearch = scannedSearch;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getContinueButtonText() {
        return continueButtonText;
    }

    public void setContinueButtonText(String continueButtonText) {
        this.continueButtonText = continueButtonText;
    }

    public String getExitButtonText() {
        return exitButtonText;
    }

    public void setExitButtonText(String exitButtonText) {
        this.exitButtonText = exitButtonText;
    }

    public Boolean getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Boolean updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChangeQuantityButtonText() {
        return changeQuantityButtonText;
    }

    public void setChangeQuantityButtonText(String changeQuantityButtonText) {
        this.changeQuantityButtonText = changeQuantityButtonText;
    }

    public String getClearPositionFactButtonText() {
        return clearPositionFactButtonText;
    }

    public void setClearPositionFactButtonText(String clearPositionFactButtonText) {
        this.clearPositionFactButtonText = clearPositionFactButtonText;
    }

    public String getRemovePositionButtonText() {
        return removePositionButtonText;
    }

    public void setRemovePositionButtonText(String removePositionButtonText) {
        this.removePositionButtonText = removePositionButtonText;
    }

    public String getViewPositionImageButtonText() {
        return viewPositionImageButtonText;
    }

    public void setViewPositionImageButtonText(String viewPositionImageButtonText) {
        this.viewPositionImageButtonText = viewPositionImageButtonText;
    }

    public String getAddMarkButton() {
        return addMarkButton;
    }

    public void setAddMarkButton(String addMarkButton) {
        this.addMarkButton = addMarkButton;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getDk() {
        return dk;
    }

    public void setDk(String dk) {
        this.dk = dk;
    }

    public String getCollectorFullName() {
        return collectorFullName;
    }

    public void setCollectorFullName(String collectorFullName) {
        this.collectorFullName = collectorFullName;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }

    public String getOrderItemIdd() {
        return orderItemIdd;
    }

    public void setReasonForAbsence(String reasonForAbsence) {
        this.reasonForAbsence = reasonForAbsence;
    }

    public void setOrderItemIdd(String orderItemIdd) {
        this.orderItemIdd = orderItemIdd;
    }

    public String getReasonForAbsence() {
        return reasonForAbsence;
    }

    public void setReasonForAbsenceProduct(String reasonForAbsence) {
        this.reasonForAbsence = reasonForAbsence;
    }

    public String getOrderIdd() {
        return orderIdd;
    }

    public void setOrderIdd(String orderIdd) {
        this.orderIdd = orderIdd;
    }

    public String getViewPictureButton() {
        return viewPictureButton;
    }

    public void setViewPictureButton(String viewPictureButton) {
        this.viewPictureButton = viewPictureButton;
    }

}
