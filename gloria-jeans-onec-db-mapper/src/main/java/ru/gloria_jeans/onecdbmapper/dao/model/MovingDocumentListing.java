package ru.gloria_jeans.onecdbmapper.dao.model;

import java.util.Date;

public interface MovingDocumentListing {
    String getIdd();
    String getDocno();
    String getDateTimeIdDoc();
    Integer getQuantity();
    Integer getQuantityPlaces();
    String getReasonId();
    String getAcceptanceDocumentIddoc();
    Integer getAcceptanceDocumentQuantityFact();
    Integer getQuantityBox();
    String getWarehouseReceiver();
    Date getDateCreated();
    Date getAcceptanceDocumentDateCreated();
}
