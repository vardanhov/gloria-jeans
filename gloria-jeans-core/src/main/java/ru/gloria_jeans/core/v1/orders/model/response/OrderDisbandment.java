package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class OrderDisbandment extends BaseResponse {
    private String screenText;

    private List<String> idDoc;

    public OrderDisbandment() {
    }

    public OrderDisbandment(String screenText) {
        this.screenText = screenText;
    }

    public String getScreenText() {
        return screenText;
    }

    public void setScreenText(String screenText) {
        this.screenText = screenText;
    }

    public List<String> getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(List<String> idDoc) {
        this.idDoc = idDoc;
    }
}
