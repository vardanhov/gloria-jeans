package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.ReceiptItem;
import ru.gloria_jeans.orders.dao.model.OrderItem;

import java.math.BigDecimal;

public class ReceiptItemMapper {

    public static ReceiptItem map(OrderItem orderItem) {
        ReceiptItem receiptItem = new ReceiptItem();
        IddocLinenumberIdentity iddocLinenumberIdentity = new IddocLinenumberIdentity();
        iddocLinenumberIdentity.setIdDoc(orderItem.getIdDoc());
        iddocLinenumberIdentity.setLineNo(orderItem.getLineNumberIdentity());
        receiptItem.setIddocLinenumberIdentity(iddocLinenumberIdentity);
        receiptItem.setBarcode(orderItem.getBarcode());
        receiptItem.setItem(orderItem.getOriginalId());
        receiptItem.setQuantity(BigDecimal.valueOf(orderItem.getQuantityFact()));
        receiptItem.setUnit("  VXTE   ");
        receiptItem.setCoefficient(BigDecimal.ONE);
        receiptItem.setPrice(orderItem.getPrice());
        receiptItem.setSum(orderItem.getSum());
        receiptItem.setPercentageDiscount(BigDecimal.ZERO);
        receiptItem.setDiscountAmount(BigDecimal.ZERO);
        receiptItem.setDiscountCode(BigDecimal.ZERO);
        receiptItem.setDiscountPrice(orderItem.getPrice());
        receiptItem.setListMarks(orderItem.getMarks());
        receiptItem.setNds(BigDecimal.valueOf(10));
        receiptItem.setPriceType("  ");
        return receiptItem;
    }
}
