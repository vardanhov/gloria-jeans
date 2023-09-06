package ru.gloria_jeans.core.v1.orders.model.request;

import ru.gloria_jeans.core.v1.orders.enums.OrderStatus;
import ru.gloria_jeans.core.v1.orders.enums.OrderType;

import java.io.Serializable;
import java.util.List;

public class SearchingOrder implements Serializable {
    private String orderBarcode;
    private String dateFrom;
    private String dateTo;
    private List<OrderType> selectedOrderTypes;
    private List<OrderStatus> selectedOrderStatuses;

    public SearchingOrder() {
    }

    public SearchingOrder(String orderBarcode) {
        this.orderBarcode = orderBarcode;
    }

    public SearchingOrder(String orderBarcode, String dateFrom, String dateTo, List<OrderType> selectedOrderTypes, List<OrderStatus> selectedOrderStatuses) {
        this.orderBarcode = orderBarcode;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.selectedOrderTypes = selectedOrderTypes;
        this.selectedOrderStatuses = selectedOrderStatuses;
    }

    public String getOrderBarcode() {
        return orderBarcode;
    }

    public void setOrderBarcode(String orderBarcode) {
        this.orderBarcode = orderBarcode;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public List<OrderType> getSelectedOrderTypes() {
        return selectedOrderTypes;
    }

    public void setSelectedOrderTypes(List<OrderType> selectedOrderTypes) {
        this.selectedOrderTypes = selectedOrderTypes;
    }

    public List<OrderStatus> getSelectedOrderStatuses() {
        return selectedOrderStatuses;
    }

    public void setSelectedOrderStatuses(List<OrderStatus> selectedOrderStatuses) {
        this.selectedOrderStatuses = selectedOrderStatuses;
    }
}
