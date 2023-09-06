package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.orders.dao.enums.OrderStatus;
import ru.gloria_jeans.orders.dao.model.ReturnedOrderLocalDocument;

import java.time.LocalDateTime;
import java.util.UUID;


public class ReturnOrderMapper {
    public static ReturnedOrderLocalDocument map(
            OrderDocument orderDocument,
            OrderStatus status
    ){
        ReturnedOrderLocalDocument returnedOrderLocalDocument = new ReturnedOrderLocalDocument();
        returnedOrderLocalDocument.setId(UUID.randomUUID());
        returnedOrderLocalDocument.setIdd(orderDocument.getJournal().getIdd());
        returnedOrderLocalDocument.setOrderNumber(orderDocument.getOrderNumber());
        returnedOrderLocalDocument.setBuyer(orderDocument.getBuyer());
        returnedOrderLocalDocument.setShippingType(orderDocument.getShippingType());
        returnedOrderLocalDocument.setShippingMethod(orderDocument.getShippingMethod());
        returnedOrderLocalDocument.setTk(orderDocument.getTk());
        returnedOrderLocalDocument.setDateCreated(orderDocument.getDateCreated());
        returnedOrderLocalDocument.setStatusOrder(status);
        return returnedOrderLocalDocument;
    }
}
