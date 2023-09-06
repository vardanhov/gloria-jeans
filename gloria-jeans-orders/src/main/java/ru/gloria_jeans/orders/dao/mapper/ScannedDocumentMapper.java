package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.enums.ScannedDocumentStatus;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;
import ru.gloria_jeans.orders.dao.model.ScannedDocument;

public class ScannedDocumentMapper {

    public static ScannedDocument map(OrderDocument orderDocument) {
        ScannedDocument scannedDocument = new ScannedDocument();
        scannedDocument.setIdd(orderDocument.getJournal().getIdd());
        scannedDocument.setOrderNumber(orderDocument.getOrderNumber().trim());
        scannedDocument.setDateCreated(orderDocument.getDateCreated());
        scannedDocument.setOrderType("Delivery");
        scannedDocument.setErrorText("");
        scannedDocument.setTk(orderDocument.getTk());
        scannedDocument.setOrderStatus(ScannedDocumentStatus.WAITING_SCAN.getValue());
        scannedDocument.setShippingMethod(orderDocument.getShippingMethod());
        return scannedDocument;
    }
}
