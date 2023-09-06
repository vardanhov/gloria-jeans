package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.enums.PackageIdd;
import ru.gloria_jeans.core.v1.orders.model.response.OrderPackageItemModel;
import ru.gloria_jeans.orders.dao.model.OrderPackage;

public class OrderPackageItemModelMapper {

    public static OrderPackageItemModel map(OrderPackage orderPackage) {
        OrderPackageItemModel orderPackageItemModel = new OrderPackageItemModel();
        orderPackageItemModel.setIdd(orderPackage.getPackageIdd());
        orderPackageItemModel.setQuantity(orderPackage.getPackageQuantity().toString());
        String logoPic = "null";
        String buttonName = "null";
        Integer lineNo = null;

        if (orderPackage.getPackageIdd().equals(PackageIdd.SMALL_PACKAGE.getIdd())) {
            logoPic = PackageIdd.SMALL_PACKAGE.getLogoPic();
            buttonName = PackageIdd.SMALL_PACKAGE.getName();
            lineNo = PackageIdd.SMALL_PACKAGE.getLineNo();
        }
        if (orderPackage.getPackageIdd().equals(PackageIdd.MEDIUM_PACKAGE.getIdd())) {
            logoPic = PackageIdd.MEDIUM_PACKAGE.getLogoPic();
            buttonName = PackageIdd.MEDIUM_PACKAGE.getName();
            lineNo = PackageIdd.MEDIUM_PACKAGE.getLineNo();
        }
        if (orderPackage.getPackageIdd().equals(PackageIdd.LARGE_PACKAGE.getIdd())) {
            logoPic = PackageIdd.LARGE_PACKAGE.getLogoPic();
            buttonName = PackageIdd.LARGE_PACKAGE.getName();
            lineNo = PackageIdd.LARGE_PACKAGE.getLineNo();
        }
        orderPackageItemModel.setLogoPic(logoPic);
        orderPackageItemModel.setButtonName(buttonName);
        orderPackageItemModel.setLineNo(lineNo);
        return orderPackageItemModel;
    }
}
