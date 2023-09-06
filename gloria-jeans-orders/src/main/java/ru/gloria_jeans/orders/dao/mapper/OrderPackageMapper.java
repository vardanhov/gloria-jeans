package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.enums.PackageIdd;
import ru.gloria_jeans.core.v1.orders.model.response.OrderPackageItemModel;
import ru.gloria_jeans.core.v1.orders.model.response.OrderPackageModel;
import ru.gloria_jeans.orders.dao.model.OrderPackage;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderPackageMapper {

    public static OrderPackage map(PackageIdd packageIdd, String orderNumber, BigDecimal quantity) {
        OrderPackage orderPackage = new OrderPackage();
        orderPackage.setId(UUID.randomUUID());
        orderPackage.setOrderNumber(orderNumber);
        orderPackage.setPackageIdd(packageIdd.getIdd());
        orderPackage.setPackageQuantity(quantity);
        return orderPackage;
    }

    public static OrderPackage map (OrderPackageItemModel orderPackageItemModel, String orderNumber) {
        OrderPackage orderPackage = new OrderPackage();
        orderPackage.setOrderNumber(orderNumber);
        orderPackage.setPackageIdd(orderPackageItemModel.getIdd());
        orderPackage.setPackageQuantity(BigDecimal.valueOf(Long.parseLong(orderPackageItemModel.getQuantity())));
        return orderPackage;
    }
}
