package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.orders.dao.model.ReceiptOrdersModel;
import ru.gloria_jeans.orders.dao.model.ReceiptOrdersList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReceiptOrdersModelMapper {

    public static ReceiptOrdersModel map(
            String ordersCount,
            List<ReceiptOrdersList> ordersToIssues,
            String transportCompany,
            String warehouseFullName
    ) {
        ReceiptOrdersModel receiptOrdersModel = new ReceiptOrdersModel();
        receiptOrdersModel.setOrdersCount(ordersCount);
        receiptOrdersModel.setOrderNumbers(ordersToIssues);
        receiptOrdersModel.setCurrentDate(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
        receiptOrdersModel.setCurrentTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        receiptOrdersModel.setStoreFullName(warehouseFullName);
        receiptOrdersModel.setTransportCompany(transportCompany);
        return receiptOrdersModel;
    }
}