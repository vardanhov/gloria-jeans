package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocumentItem;
import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.receiving.dao.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AcceptanceDocumentItemMapper {
    public static AcceptanceDocumentItem map(Product product, String iddoc) {
        AcceptanceDocumentItem item = new AcceptanceDocumentItem();
        item.setIddocLinenumberIdentity(new IddocLinenumberIdentity());
        item.getIddocLinenumberIdentity().setIdDoc(iddoc);
        item.getIddocLinenumberIdentity().setLineNo(product.getLineNumber());

        if (Objects.nonNull(product.getSum())) {
            item.setSum(product.getSum());
        } else {
            item.setSum(BigDecimal.ZERO);
        }

        item.setItem(product.getOriginalId());
        item.setPrice(product.getPrice());
        item.setMarks(product.getMarks());
        item.setQuantityDoc(BigDecimal.valueOf(product.getQuantity()));
        item.setBarcodeBox(product.getBarcodeBox());
        item.setFactQuantity(BigDecimal.valueOf(product.getQuantityFact()));
        return item;
    }

    public static List<AcceptanceDocumentItem> map(List<Product> products, String iddoc) {
        List<AcceptanceDocumentItem> items = new ArrayList<>();

        for(Product product : products) {
            items.add(AcceptanceDocumentItemMapper.map(product, iddoc));
        }

        return items;
    }
}
