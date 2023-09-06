package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.MismatchDocumentItem;
import ru.gloria_jeans.receiving.dao.model.Product;

import java.math.BigDecimal;

public class MismatchDocumentItemMapper {
    public static MismatchDocumentItem map(Product product, String acceptBy, Integer lineNumber) {
        MismatchDocumentItem item = new MismatchDocumentItem();
        IddocLinenumberIdentity iddocLinenumberIdentity = new IddocLinenumberIdentity();
        iddocLinenumberIdentity.setLineNo(lineNumber);
        item.setIddocLinenumberIdentity(iddocLinenumberIdentity);
        item.setItem(product.getOriginalId());
        item.setBarcodeBox(product.getBarcodeBox());
        item.setPrice(product.getPrice());
        item.setApproved(acceptBy);
        item.setLookedRecipient(acceptBy);
        item.setListMarks(product.getMarks());
        item.setUnit(product.getBaseUnit());
        item.setVatSum(BigDecimal.ZERO);
        item.setDifferenceCount(BigDecimal.valueOf(product.getQuantity() - product.getQuantityFact()));
        item.setDifferenceSum(
                product.getPrice()
                        .multiply(BigDecimal.valueOf(product.getQuantity()))
                        .subtract(
                                product.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact()))
                        )
        );
        return item;
    }
}
