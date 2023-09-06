package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.enums.ScannedDocumentStatus;
import ru.gloria_jeans.core.v1.orders.model.response.ScannedDocumentModel;
import ru.gloria_jeans.onecdbmapper.dao.enums.ShippingMethod;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;
import ru.gloria_jeans.orders.dao.model.ScannedDocument;

public class ScannedDocumentModelMapper {

    public static ScannedDocumentModel map(OrderLocalDocument orderDocument) {
        ScannedDocumentModel scannedDocument = new ScannedDocumentModel();
        scannedDocument.setOrderNumber(orderDocument.getOrderNumber().trim());
        scannedDocument.setDateCreated(orderDocument.getDateCreated());
        scannedDocument.setOrderType("Delivery");
        scannedDocument.setTk(orderDocument.getTk());
        scannedDocument.setErrorText("");
        scannedDocument.setOrderStatus("warehouse.internet.order.document.status.delivery.waiting_scan");
        scannedDocument.setShippingMethod(ShippingMethod.getName(orderDocument.getShippingMethod()));
        return scannedDocument;
    }

    public static ScannedDocumentModel map(ScannedDocument scannedDocument) {
        ScannedDocumentModel scannedDocumentModel = new ScannedDocumentModel();
        scannedDocumentModel.setOrderNumber(scannedDocument.getOrderNumber());
        scannedDocumentModel.setDateCreated(scannedDocument.getDateCreated());
        scannedDocumentModel.setOrderType(scannedDocument.getOrderType());
        scannedDocumentModel.setErrorText(scannedDocument.getErrorText());
        scannedDocumentModel.setOrderStatus(ScannedDocumentStatus.getScannedDocumentStatus(scannedDocument.getOrderStatus()));
        scannedDocumentModel.setShippingMethod(ShippingMethod.getName(scannedDocument.getShippingMethod()));
        return scannedDocumentModel;
    }
}
