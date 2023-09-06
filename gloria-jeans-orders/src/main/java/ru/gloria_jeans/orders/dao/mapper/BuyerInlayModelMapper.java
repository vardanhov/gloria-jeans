package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.orders.dao.model.BuyerInlayModel;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;

public class BuyerInlayModelMapper {

    public static BuyerInlayModel map(OrderLocalDocument orderDocument, String[] namePhoneEmail, String orderDate) {
        BuyerInlayModel buyerInlayModel = new BuyerInlayModel();
        buyerInlayModel.setBuyerEmail(namePhoneEmail[2]);
        buyerInlayModel.setBuyerFullName(namePhoneEmail[0]);
        buyerInlayModel.setOrderNumber(orderDocument.getOrderNumber());
        buyerInlayModel.setBuyerPhoneNumber(namePhoneEmail[1]);
        buyerInlayModel.setDeliveryAddress(orderDocument.getBuyerAddress());
        buyerInlayModel.setOrderDate(orderDate);
        buyerInlayModel.setDocumentIdd(orderDocument.getIdd());
        return buyerInlayModel;
    }
}
