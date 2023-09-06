package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.model.response.OrderViewPositionModel;
import ru.gloria_jeans.orders.dao.model.OrderItem;

public class OrderViewPositionModelMapper {

    public static OrderViewPositionModel map(OrderItem orderItem, String itemId, boolean userCanEnter) {
        OrderViewPositionModel orderViewPositionModel = new OrderViewPositionModel();
        orderViewPositionModel.setId(orderItem.getId().toString());
        orderViewPositionModel.setItemId(itemId);
        orderViewPositionModel.setMark(orderItem.getMark());
        orderViewPositionModel.setProductBarcode(orderItem.getBarcode());
        orderViewPositionModel.setProductPlan(orderItem.getQuantity().toString());
        orderViewPositionModel.setProductFact(orderItem.getQuantityFact().toString());
        String productDiff = String.valueOf(orderItem.getQuantityFact() - orderItem.getQuantity());
        orderViewPositionModel.setProductDiff(productDiff);
        orderViewPositionModel.setProductFullName(orderItem.getFullName());
        orderViewPositionModel.setUserCanEnter(userCanEnter);
        boolean isMarkOk = false;
        if (orderItem.getQuantityFact() > 0 && orderItem.getMarks().length() / orderItem.getQuantityFact() == 13) {
            isMarkOk = true;
        }
        orderViewPositionModel.setScannedMark(isMarkOk);
        orderViewPositionModel.setShowReasonForAbsence(false);
        return orderViewPositionModel;
    }
}
