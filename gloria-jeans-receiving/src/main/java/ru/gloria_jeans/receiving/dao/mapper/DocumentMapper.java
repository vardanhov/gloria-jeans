package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.MovingDocument;
import ru.gloria_jeans.receiving.dao.model.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class DocumentMapper {
    public static Document map(MovingDocument movingDocument, Date createdAt) {
        return map(movingDocument, createdAt, 0L);
    }

    public static Document map(MovingDocument movingDocument, Date createdAt, Long factQuantity) {
        Document document = new Document();
        document.setId(UUID.randomUUID());
        document.setIdd(movingDocument.getJournal().getIdd());
        document.setIddoc(movingDocument.getIdDoc());
        document.setIdocdef(movingDocument.getJournal().getIdocdef());
        document.setWarehouse(movingDocument.getWarehouse());
        document.setCurrency(movingDocument.getCurrency());
        document.setReturnType(movingDocument.getReturnType());
        document.setWarehouseReceiver(movingDocument.getWarehouseReceiver());
        document.setCollectedBy(movingDocument.getCollectedBy());
        document.setCreatedBy(movingDocument.getCreatedBy());
        document.setFirmRecipient(movingDocument.getCompanyReceiver());
        document.setFinalWarehouse(movingDocument.getFinalWarehouse());
        document.setCurrencyRate(movingDocument.getCourse());
        document.setQuantityPlaces(movingDocument.getQuantityPlaces().intValue());
        document.setGround(movingDocument.getBasis());
        document.setStatus(movingDocument.getStatus());
        document.setExpectedArrival(movingDocument.getExpectedDateArrival().toInstant());
        document.setTransferNumber(movingDocument.getTransferNumber());
        document.setCorrection(movingDocument.getCorrection());
        document.setTransitWarehouse(movingDocument.getTransitWarehouse());
        document.setTradeNumber(movingDocument.getTradeNumber());
        document.setPrepayment(movingDocument.getPrepayment());
        document.setOrderStatus(movingDocument.getOrderStatus());
        document.setGuid(movingDocument.getGuid());
        document.setQuantity(movingDocument.getQuantity());
        document.setFactQuantity(factQuantity);
        document.setSum(new BigDecimal(0));
        document.setUpdatedAt(movingDocument.getTimeEdited());
        document.setDocumentComment(movingDocument.getComment());
        document.setCreatedAt(createdAt.toInstant());
        return document;
    }
}
