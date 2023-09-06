package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

public class OrderViewPositionModel extends BaseResponse {
    private String itemId;
    private String id;
    private String productFullName;
    private String productBarcode;
    private String productPlan;
    private String productFact;
    private String productDiff;
    private boolean isMark;
    private boolean isScannedMark;
    private boolean isShowReasonForAbsence;
    private String linkBack;
    private String linkForward;
    private boolean isUserCanEnter;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getProductFullName() {
        return productFullName;
    }

    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductPlan() {
        return productPlan;
    }

    public void setProductPlan(String productPlan) {
        this.productPlan = productPlan;
    }

    public String getProductFact() {
        return productFact;
    }

    public void setProductFact(String productFact) {
        this.productFact = productFact;
    }

    public String getProductDiff() {
        return productDiff;
    }

    public void setProductDiff(String productDiff) {
        this.productDiff = productDiff;
    }

    public boolean isMark() {
        return isMark;
    }

    public void setMark(boolean mark) {
        isMark = mark;
    }

    public boolean isScannedMark() {
        return isScannedMark;
    }

    public void setScannedMark(boolean scannedMark) {
        isScannedMark = scannedMark;
    }

    public boolean isShowReasonForAbsence() {
        return isShowReasonForAbsence;
    }

    public void setShowReasonForAbsence(boolean showReasonForAbsence) {
        isShowReasonForAbsence = showReasonForAbsence;
    }

    public String getLinkBack() {
        return linkBack;
    }

    public void setLinkBack(String linkBack) {
        this.linkBack = linkBack;
    }

    public String getLinkForward() {
        return linkForward;
    }

    public void setLinkForward(String linkForward) {
        this.linkForward = linkForward;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isUserCanEnter() {
        return isUserCanEnter;
    }

    public void setUserCanEnter(boolean userCanEnter) {
        isUserCanEnter = userCanEnter;
    }
}
