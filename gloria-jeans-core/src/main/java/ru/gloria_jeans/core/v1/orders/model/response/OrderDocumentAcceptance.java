package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class OrderDocumentAcceptance extends BaseResponse {
    Integer mismatchQuantityFactCheck;

    List<String> movePeriodIdDocs;

    public Integer getMismatchQuantityFactCheck() {
        return mismatchQuantityFactCheck;
    }

    public void setMismatchQuantityFactCheck(Integer mismatchQuantityFactCheck) {
        this.mismatchQuantityFactCheck = mismatchQuantityFactCheck;
    }

    public List<String> getMovePeriodIdDocs() {
        return movePeriodIdDocs;
    }

    public void setMovePeriodIdDocs(List<String> movePeriodIdDocs) {
        this.movePeriodIdDocs = movePeriodIdDocs;
    }
}
