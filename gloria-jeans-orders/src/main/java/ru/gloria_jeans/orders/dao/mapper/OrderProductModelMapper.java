package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.model.response.OrderDocumentItemModel;
import ru.gloria_jeans.orders.dao.model.OrderItem;

public class OrderProductModelMapper {
    public static OrderDocumentItemModel map(OrderItem orderItem) {
        OrderDocumentItemModel orderProductModel = new OrderDocumentItemModel();
        orderProductModel.setId(orderItem.getId());
        orderProductModel.setIdd(orderItem.getIdd());
        orderProductModel.setItem(orderItem.getOriginalId());
        orderProductModel.setSum(orderItem.getSum().intValue());
        orderProductModel.setPrice(orderItem.getPrice().intValue());
        orderProductModel.setListMarks(orderItem.getMarks());
        orderProductModel.setProductName(orderItem.getFullName());
        orderProductModel.setQuantity(orderItem.getQuantity());
        orderProductModel.setQuantityFact(orderItem.getQuantityFact());
        orderProductModel.setQuantityDiff(orderItem.getQuantityFact() - orderItem.getQuantity());
        orderProductModel.setIsMark(orderItem.getMark());
        boolean isMarkOk = false;
        if (orderItem.getQuantityFact() > 0 && orderItem.getMarks().length() / orderItem.getQuantityFact() == 13) {
            isMarkOk = true;
        }
        orderProductModel.setMarksOk(isMarkOk);

        return orderProductModel;
    }
}
