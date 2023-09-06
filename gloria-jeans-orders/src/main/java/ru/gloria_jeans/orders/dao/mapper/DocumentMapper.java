package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.orders.dao.enums.OrderStatus;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DocumentMapper {

    public static OrderLocalDocument map(OrderDocument orderDocument, String userId, String firm, OrderStatus statusOrder) {
        OrderLocalDocument document = new OrderLocalDocument();
        document.setId(UUID.randomUUID());
        document.setIdd(orderDocument.getJournal().getIdd());
        document.setIdDoc(orderDocument.getIdDoc());
        document.setBuyer(orderDocument.getBuyer());
        document.setDateCreated(orderDocument.getDateCreated());
        document.setOrderNumber(orderDocument.getOrderNumber());
        document.setOrderId(orderDocument.getOrderId());
        document.setCurrentUserId(userId);
        document.setDocumentOpenDate(LocalDateTime.now());
        document.setWarehouse(orderDocument.getWarehouse());
        document.setFirm(firm);
        document.setShippingType(orderDocument.getShippingType());
        document.setShippingMethod(orderDocument.getShippingMethod());
        document.setStatusOrder(statusOrder);
        document.setPayType(orderDocument.getPayType());
        document.setWarehouseSender(orderDocument.getWarehouseSender());
        document.setWarehouseTransit(orderDocument.getWarehouseTransit());
        document.setBuyerAddress(orderDocument.getBayerAddress());
        document.setDop(orderDocument.getDop());
        document.setGiftCertificate(orderDocument.getGiftCertificate());
        document.setTk(orderDocument.getTk());
        document.setPvz(orderDocument.getPvz());
        document.setCash(orderDocument.getCash());
        document.setExternalCredit(orderDocument.getExternalCredit());
        document.setInternalCredit(orderDocument.getInternalCredit());
        document.setQuantity(orderDocument.getQuantity());
        document.setQuantityFact(BigDecimal.valueOf(0));
        document.setSum(BigDecimal.valueOf(0));
        document.setEditTime(orderDocument.getEditTime());
        document.setTimeDoc(orderDocument.getTimeDoc());
        document.setComment(orderDocument.getComment());
        document.setDk(orderDocument.getDk());
        document.setIddocdef(String.valueOf(orderDocument.getJournal().getIdocdef()));
        return document;
    }

}
