package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

public class CheckAcceptanceDocument extends BaseResponse {
    private String documentNumber;
    private Boolean checkResult;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public CheckAcceptanceDocument() {
    }

    public CheckAcceptanceDocument(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Boolean getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Boolean checkResult) {
        this.checkResult = checkResult;
    }
}
