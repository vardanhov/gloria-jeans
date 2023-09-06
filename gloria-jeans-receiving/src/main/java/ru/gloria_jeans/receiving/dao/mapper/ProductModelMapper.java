package ru.gloria_jeans.receiving.dao.mapper;

import com.google.common.base.Strings;
import ru.gloria_jeans.core.v1.receiving.models.response.ProductModel;
import ru.gloria_jeans.onecdbmapper.dao.enums.ProductType;
import ru.gloria_jeans.onecdbmapper.dao.model.ProductInfo;
import ru.gloria_jeans.receiving.dao.model.OpenLot;
import ru.gloria_jeans.receiving.dao.model.Product;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;

public class ProductModelMapper {
    public static ProductModel map(
            ProductInfo productInfo,
            Integer quantityDoc,
            Integer factQuantity
    ) {
        ProductModel productModel = new ProductModel();
        productModel.setId(productInfo.getId());
        productModel.setName(productInfo.getFullName());
        productModel.setVendorCode(productInfo.getVendorCode());
        productModel.setCountPlan(quantityDoc);
        productModel.setCountFact(factQuantity);
        productModel.setCountDiff(factQuantity - quantityDoc);
        return productModel;
    }

    public static ProductModel map(
            Product product,
            Integer quantityDoc,
            Integer factQuantity
    ) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId().toString());
        productModel.setLot(product.getKindOfProduct().equals(ProductType.LOT.getValue()));
        productModel.setMark(!Strings.isNullOrEmpty(product.getMarkTypeCode().trim()) && !product.getMarkTypeCode().startsWith("0000"));
        productModel.setScannedMark(product.getScannedMarks().parallelStream().filter(ScannedMark::getValidMark).count() == product.getQuantityFact() && product.getQuantityFact() != 0);
        productModel.setPrice(product.getPrice());
        productModel.setName(product.getFullName());
        productModel.setVendorCode(product.getVendorCode());
        productModel.setCountPlan(quantityDoc);
        productModel.setCountFact(factQuantity);
        productModel.setCountDiff(factQuantity - quantityDoc);
        productModel.setBarcode(product.getBarcode());
        productModel.setLineNumber(product.getLineNumber());

        if (product.getProductsIntoLot().size() > 0) {
            productModel.setCountDiffProductsIntoLot(
                    product.getProductsIntoLot()
                            .parallelStream()
                            .anyMatch(x -> x.getQuantity() != x.getFactQuantity()) ? -1 : 0
            );
        }

        return productModel;
    }

    public static ProductModel map(
            Product product
    ) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId().toString());
        productModel.setLot(product.getKindOfProduct().equals(ProductType.LOT.getValue()));
        productModel.setMark(!Strings.isNullOrEmpty(product.getMarkTypeCode().trim()) && !product.getMarkTypeCode().startsWith("0000"));
        productModel.setScannedMark(product.getScannedMarks().parallelStream().filter(ScannedMark::getValidMark).count() == product.getQuantityFact() && product.getQuantityFact() != 0);
        productModel.setPrice(product.getPrice());
        productModel.setName(product.getFullName());
        productModel.setVendorCode(product.getVendorCode());
        productModel.setCountPlan(product.getQuantity());
        productModel.setCountFact(product.getQuantityFact());
        productModel.setCountDiff(product.getQuantityFact() - product.getQuantity());
        productModel.setBarcode(product.getBarcode());
        return productModel;
    }

    public static ProductModel map(OpenLot openLot) {
        ProductModel productModel = new ProductModel();
        productModel.setId(openLot.getId().toString());
        productModel.setName(openLot.getFullName());
        productModel.setPrice(openLot.getPrice());
        productModel.setVendorCode(openLot.getVendorCode());
        productModel.setCountPlan(openLot.getQuantity());
        productModel.setCountFact(openLot.getFactQuantity());
        productModel.setCountDiff(openLot.getFactQuantity() - openLot.getQuantity());
        return productModel;
    }
}
