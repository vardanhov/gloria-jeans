package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.model.response.OrderItemModel;
import ru.gloria_jeans.core.v1.orders.model.response.PackingListModel;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.Warehouse;
import ru.gloria_jeans.orders.dao.model.OrderItem;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PackingListModelMapper {

    public static PackingListModel map(OrderDocument orderDocument, List<OrderItem> orderItems, String collectorName, Warehouse warehouse) {
        PackingListModel packingListModel = new PackingListModel();
        packingListModel.setOrderNumber(orderDocument.getOrderNumber().trim());
        packingListModel.setOrderDate(new SimpleDateFormat("dd-MM-yyyy").format(orderDocument.getDateCreated()).concat(" ").concat(orderDocument.getTimeDoc()));
        packingListModel.setCollectDateTime(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        packingListModel.setOrderBarcode(orderDocument.getJournal().getIdd());
        String[] buyer = orderDocument.getBuyer().split(";");
        packingListModel.setBayerFullName(buyer[0].trim());
        packingListModel.setBayerPhoneNumber("+" + buyer[1].trim());
        packingListModel.setBayerEmail(buyer[2].trim());
        packingListModel.setStoreName(warehouse.getName().trim());
        packingListModel.setStoreAddress(warehouse.getAddress().trim());
        packingListModel.setCollectorFullName(collectorName.trim());
        packingListModel.setItemModelList(map(orderItems));
        return packingListModel;
    }

    public static List<OrderItemModel> map(List<OrderItem> orderItems) {
        List<OrderItemModel> itemModelList = orderItems.stream()
                .map(a -> new OrderItemModel(
                        a.getFullName(),
                        String.valueOf(a.getQuantityFact()),
                        String.valueOf(a.getPrice()),
                        String.valueOf(a.getSum())))
                .collect(Collectors.toList());

        OrderItemModel orderItemModel = new OrderItemModel("ИТОГО:",
                        String.valueOf(
                                (Integer) orderItems.stream()
                                        .mapToInt(OrderItem::getQuantityFact)
                                        .sum()),
                        String.valueOf(
                                orderItems.stream()
                                        .map(OrderItem::getSum)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add)));
        orderItemModel.setPrice("");
                itemModelList.add(orderItemModel);
        return itemModelList;
    }
}
