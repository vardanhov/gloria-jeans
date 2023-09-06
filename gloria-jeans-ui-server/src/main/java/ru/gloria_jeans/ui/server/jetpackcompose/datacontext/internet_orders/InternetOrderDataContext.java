package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderDataContext extends DataContext {
    private String acceptLabel;
    private String collectOrderLabel;
    private String passToCourierLabel;
    private String returnFromCourierLabel;
    private String disbandOrderLabel;
    private String orderInformationLabel;

    public String getAcceptLabel() {
        return acceptLabel;
    }

    public void setAcceptLabel(String acceptLabel) {
        this.acceptLabel = acceptLabel;
    }

    public String getCollectOrderLabel() {
        return collectOrderLabel;
    }

    public void setCollectOrderLabel(String collectOrderLabel) {
        this.collectOrderLabel = collectOrderLabel;
    }

    public String getPassToCourierLabel() {
        return passToCourierLabel;
    }

    public void setPassToCourierLabel(String passToCourierLabel) {
        this.passToCourierLabel = passToCourierLabel;
    }

    public String getReturnFromCourierLabel() {
        return returnFromCourierLabel;
    }

    public void setReturnFromCourierLabel(String returnFromCourierLabel) {
        this.returnFromCourierLabel = returnFromCourierLabel;
    }

    public String getDisbandOrderLabel() {
        return disbandOrderLabel;
    }

    public void setDisbandOrderLabel(String disbandOrderLabel) {
        this.disbandOrderLabel = disbandOrderLabel;
    }

    public String getOrderInformationLabel() {
        return orderInformationLabel;
    }

    public void setOrderInformationLabel(String orderInformationLabel) {
        this.orderInformationLabel = orderInformationLabel;
    }
}
