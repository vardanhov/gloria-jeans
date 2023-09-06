package ru.gloria_jeans.orders.dao.mapper;

import com.google.common.base.Strings;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocumentItem;
import ru.gloria_jeans.onecdbmapper.dao.model.ProductInfo;
import ru.gloria_jeans.orders.dao.model.OrderItem;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemMapper {
    public static OrderItem map(OrderDocumentItem product,
                                String documentIdd) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(UUID.randomUUID());
        orderItem.setIdd(product.getProductInfo().getIdd());
        orderItem.setFullName(product.getProductInfo().getFullName());
        orderItem.setQuantityFact(0);
        orderItem.setQuantity(product.getQuantity().intValue());
        orderItem.setBarcode(product.getProductInfo().getBarcode());
        orderItem.setVendorCode(product.getProductInfo().getVendorCode());
        orderItem.setDocumentIdd(documentIdd);
        orderItem.setIdDoc(product.getIddocLinenumberIdentity().getIdDoc());
        orderItem.setLineNumberIdentity(product.getIddocLinenumberIdentity().getLineNo());
        orderItem.setPrice(product.getPrice());
        orderItem.setWeight(product.getProductInfo().isWeight());
        orderItem.setBaseUnit(product.getProductInfo().getBaseUnit());
        orderItem.setKindOf(product.getProductInfo().getKind());
        orderItem.setKindOfProduct(product.getProductInfo().getProductKind());
        orderItem.setModelCode(product.getProductInfo().getModelCode());
        orderItem.setPmmCode(product.getProductInfo().getPmmCode());
        orderItem.setMinBalance(product.getProductInfo().getMinBalance());
        orderItem.setExcludeFromPrice(product.getProductInfo().isExcludeFromPrice());
        orderItem.setGtdNumber(product.getProductInfo().getGtdNumber());
        orderItem.setMainUnit(product.getProductInfo().getMainUnit());
        orderItem.setMainProperty(product.getProductInfo().getMainProperty());
        orderItem.setNdsRate(product.getProductInfo().getNdsRate());
        orderItem.setNpRate(product.getProductInfo().getNdsRate());
        orderItem.setCountryOfOrigin(product.getProductInfo().getCountryOfOrigin());
        orderItem.setProductGroup(product.getProductInfo().getProductGroup());
        orderItem.setMarkTypeCode(product.getProductInfo().getMarkTypeCode());
        orderItem.setSum(BigDecimal.valueOf(orderItem.getQuantityFact()).multiply(orderItem.getPrice()));
        orderItem.setIddAnalog(product.getProductInfo().getIddAnalog());
        orderItem.setOriginalId(product.getItem());
        if (!Strings.isNullOrEmpty(product.getProductInfo().getMarkTypeCode())) {
            orderItem.setMark(true);
        } else {
            orderItem.setMark(false);
        }
        orderItem.setMarks("");
        return orderItem;
    }

    public static OrderItem map(ProductInfo item,
                                String documentIdd) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(UUID.randomUUID());
        orderItem.setBarcode(item.getBarcode().trim());
        orderItem.setIdd(item.getIdd().trim());
        orderItem.setIddAnalog(item.getIddAnalog());
        orderItem.setVendorCode(item.getVendorCode().trim());
        orderItem.setBaseUnit(item.getBaseUnit());
        orderItem.setWeight(item.isWeight());
        orderItem.setKindOf(item.getKind());
        orderItem.setKindOfProduct(item.getProductKind());
        orderItem.setModelCode(item.getModelCode());
        orderItem.setPmmCode(item.getPmmCode());
        orderItem.setMinBalance(item.getMinBalance());
        orderItem.setExcludeFromPrice(item.isExcludeFromPrice());
        orderItem.setGtdNumber(item.getGtdNumber());
        orderItem.setMainUnit(item.getMainUnit());
        orderItem.setMainProperty(item.getMainProperty());
        orderItem.setNdsRate(item.getNdsRate());
        orderItem.setNpRate(item.getNppRate());
        orderItem.setCountryOfOrigin(item.getCountryOfOrigin());
        orderItem.setProductGroup(item.getProductGroup());
        orderItem.setComment(item.getComment());
        orderItem.setFullName(item.getFullName());
        orderItem.setMarkTypeCode(item.getMarkTypeCode());
        orderItem.setOriginalId(item.getId());
        orderItem.setIdDoc(documentIdd);
        orderItem.setLineNumberIdentity(1);
        if (!Strings.isNullOrEmpty(item.getMarkTypeCode())) {
            orderItem.setMark(true);
        } else {
            orderItem.setMark(false);
        }
        orderItem.setMarks("");
        return orderItem;
    }
}
