package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.model.response.OrderDocumentModel;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;

public class OrderDocumentModelMapper {

    public static OrderDocumentModel map(OrderDocument document) {
        OrderDocumentModel orderDocumentModel = new OrderDocumentModel();
        orderDocumentModel.setIdd(document.getJournal().getIdd());
        orderDocumentModel.setOrderNumber(document.getOrderNumber());
        orderDocumentModel.setDk(document.getDk());
        orderDocumentModel.setOrderId(document.getOrderId());
        return orderDocumentModel;
    }
}
