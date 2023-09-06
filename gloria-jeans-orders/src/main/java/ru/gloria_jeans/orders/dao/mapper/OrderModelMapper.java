package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.enums.OrderType;
import ru.gloria_jeans.core.v1.orders.model.response.OrderModel;
import ru.gloria_jeans.onecdbmapper.dao.enums.ShippingMethod;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;
import ru.gloria_jeans.orders.dao.model.ReturnedOrderLocalDocument;

import java.util.Objects;

public class OrderModelMapper {

    public static OrderModel map(
            OrderDocument orderDocument,
            String status
    ) {

        OrderModel orderModel = new OrderModel();
        orderModel.setOrderDate(orderDocument.getDateCreated());
        orderModel.setOrderNumber(orderDocument.getOrderNumber());
        orderModel.setOrderStatus(status);
        orderModel.setShippingType(OrderType.getOrderType(orderDocument.getShippingType()));
        orderModel.setTransportCompany(orderDocument.getTk());
        orderModel.setShippingMethod(ShippingMethod.getName(orderDocument.getShippingMethod()));
        orderModel.setCustomerFullName(orderDocument.getBuyer());
        return orderModel;
    }

    public static OrderModel map(
            ReturnedOrderLocalDocument returnedOrderLocalDocument
    ) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderDate(returnedOrderLocalDocument.getDateCreated());
        orderModel.setOrderNumber(returnedOrderLocalDocument.getOrderNumber());
        orderModel.setShippingType(OrderType.getOrderType(returnedOrderLocalDocument.getShippingType()));
        orderModel.setTransportCompany(returnedOrderLocalDocument.getTk());
        orderModel.setCustomerFullName(returnedOrderLocalDocument.getBuyer());
        orderModel.setOrderStatus(returnedOrderLocalDocument.getStatusOrder().getLocale());
        return orderModel;
    }
}
