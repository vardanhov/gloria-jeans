package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.MovingDocumentItem;
import ru.gloria_jeans.onecdbmapper.dao.model.ProductInfo;
import ru.gloria_jeans.receiving.dao.model.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductMapper {
    public static Product map(ProductInfo item) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setBarcode(item.getBarcode().trim());
        product.setIdd(item.getIdd().trim());
        product.setIddAnalog(item.getIddAnalog());
        product.setVendorCode(item.getVendorCode().trim());
        product.setBaseUnit(item.getBaseUnit());
        product.setWeight(item.isWeight());
        product.setKindOf(item.getKind());
        product.setKindOfProduct(item.getProductKind());
        product.setModelCode(item.getModelCode());
        product.setPmmCode(item.getPmmCode());
        product.setMinBalance(item.getMinBalance());
        product.setExcludeFromPrice(item.isExcludeFromPrice());
        product.setGtdNumber(item.getGtdNumber());
        product.setMainUnit(item.getMainUnit());
        product.setMainProperty(item.getMainProperty());
        product.setNdsRate(item.getNdsRate());
        product.setNpRate(item.getNppRate());
        product.setCountryOfOrigin(item.getCountryOfOrigin());
        product.setProductGroup(item.getProductGroup());
        product.setComment(item.getComment());
        product.setFullName(item.getFullName());
        product.setMarkTypeCode(item.getMarkTypeCode());
        product.setOriginalId(item.getId());
        return product;
    }

    public static Product map(MovingDocumentItem item) {
        Product product = map(item.getProduct());
        product.setBarcodeBox(item.getBarcodeBox().trim());
        product.setLineNumber(item.getIddocLinenumberIdentity().getLineNo());
        product.setQuantity(item.getQuantity().intValue());
        product.setQuantityFact(0);
        product.setMarks(item.getListMarks().trim());
        product.setPrice(item.getPrice());
        product.setWithoutMarks(item.getWithoutMarks().intValue());
        product.setOriginalIddoc(item.getIddocLinenumberIdentity().getIdDoc());
        product.setSum(item.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact())));
        return product;
    }
}
