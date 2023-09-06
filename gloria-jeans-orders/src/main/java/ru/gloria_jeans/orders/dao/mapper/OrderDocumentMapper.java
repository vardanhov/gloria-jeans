package ru.gloria_jeans.orders.dao.mapper;

import org.apache.commons.lang3.StringUtils;
import ru.gloria_jeans.core.v1.orders.model.response.OrderDocumentItemModel;
import ru.gloria_jeans.core.v1.orders.model.response.OrderDocumentModel;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocumentItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class OrderDocumentMapper {
    public static OrderDocumentModel map(OrderDocument orderDocument, String status) {
        OrderDocumentModel orderDocumentModel = new OrderDocumentModel();
        orderDocumentModel.setIdd(orderDocument.getJournal().getIdd());
        orderDocumentModel.setDk(orderDocument.getDk());
        orderDocumentModel.setOrderNumber(orderDocument.getOrderNumber());
        orderDocumentModel.setBuyer(StringUtils.substringBefore(orderDocument.getBuyer(), ";"));
        orderDocumentModel.setWarehouse(orderDocument.getWarehouse());
        orderDocumentModel.setCollectorName(orderDocument.getCollectorName());
        orderDocumentModel.setShippingType(orderDocument.getShippingType());
        orderDocumentModel.setStatusOrder(status);
        orderDocumentModel.setPayType(orderDocument.getPayType());
        orderDocumentModel.setWarehouseSender(orderDocument.getWarehouseSender());
        orderDocumentModel.setWarehouseTransit(orderDocument.getWarehouseTransit());
        orderDocumentModel.setBayerAddress(orderDocument.getBayerAddress());
        orderDocumentModel.setShippingMethod(orderDocument.getShippingMethod());
        orderDocumentModel.setOrderId(orderDocument.getOrderId());
        orderDocumentModel.setDop(orderDocument.getDop());
        orderDocumentModel.setPmm(orderDocument.getJournal().getPmm());
        orderDocumentModel.setDocumentDate(orderDocument.getDateCreated());
        List<OrderDocumentItemModel> orderDocumentItemModels = orderDocument.getItems().stream()
                .filter(Objects::nonNull)
                .map(OrderDocumentMapper::map)
                .collect(Collectors.toList());
        orderDocumentModel.setOrderDocumentItemModels(orderDocumentItemModels);
        return orderDocumentModel;
    }

    public static OrderDocumentItemModel map(OrderDocumentItem orderDocumentItem) {
        OrderDocumentItemModel orderDocumentItemModel = new OrderDocumentItemModel();
        orderDocumentItemModel.setItem(orderDocumentItem.getItem());
        orderDocumentItemModel.setProductName(orderDocumentItem.getProductInfo().getFullName());
        orderDocumentItemModel.setQuantity(orderDocumentItem.getQuantity().intValue());
        orderDocumentItemModel.setQuantityFact(orderDocumentItem.getQuantityFact().intValue());
        orderDocumentItemModel.setQuantityDiff(orderDocumentItem.getQuantity().intValue() - orderDocumentItem.getQuantityFact().intValue());
        orderDocumentItemModel.setPrice(orderDocumentItem.getPrice().intValue());
        orderDocumentItemModel.setSum(orderDocumentItem.getSum().intValue());
        orderDocumentItemModel.setListMarks(orderDocumentItem.getListMarks());
        return orderDocumentItemModel;
    }
}

