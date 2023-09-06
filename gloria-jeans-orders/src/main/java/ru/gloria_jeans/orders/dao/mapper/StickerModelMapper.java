package ru.gloria_jeans.orders.dao.mapper;

import org.apache.tools.ant.taskdefs.War;
import ru.gloria_jeans.core.v1.orders.model.response.StickerModel;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.Warehouse;

public class StickerModelMapper {
    public static StickerModel map(OrderDocument orderDocument, Warehouse warehouse) {
        StickerModel stickerModel = new StickerModel();
        String[] dop = orderDocument.getDop().trim().split(";", -1);
        stickerModel.setTransportCompany(dop[2]);
        stickerModel.setCarrierBarcode(!dop[3].isBlank() ? dop[3] : "GJ" + orderDocument.getOrderNumber());
        String[] buyer = orderDocument.getBuyer().split(";");
        stickerModel.setBayerFullName(buyer[0]);
        stickerModel.setBayerPhoneNumber(buyer[1]);
        stickerModel.setBayerAddress(orderDocument.getBayerAddress().trim());
        stickerModel.setOrderNumber(orderDocument.getOrderNumber());
        stickerModel.setWeight(dop[0]);
        stickerModel.setPlace("1");
        stickerModel.setFromPlace("1");
        stickerModel.setShopFullName(warehouse.getName().trim() + " " + warehouse.getAddress().trim());
        return stickerModel;
    }
}
