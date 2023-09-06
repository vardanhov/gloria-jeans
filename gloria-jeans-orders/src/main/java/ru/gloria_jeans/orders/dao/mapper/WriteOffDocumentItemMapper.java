package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.core.v1.orders.enums.PackageIdd;
import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.ProductInfo;
import ru.gloria_jeans.onecdbmapper.dao.model.WriteOffDocumentItem;
import ru.gloria_jeans.orders.dao.model.OrderPackage;

import java.math.BigDecimal;

public class WriteOffDocumentItemMapper {

    public static WriteOffDocumentItem map(OrderPackage orderPackage, String idDoc, OrderDocument orderDocument, ProductInfo productInfo, BigDecimal price) {

        WriteOffDocumentItem writeOffDocumentItem = new WriteOffDocumentItem();
        IddocLinenumberIdentity iddocLinenumberIdentity = new IddocLinenumberIdentity();
        Integer lineNo = 0;

        if (orderPackage.getPackageIdd().equals(PackageIdd.SMALL_PACKAGE.getIdd())) {
            lineNo = PackageIdd.SMALL_PACKAGE.getLineNo();
        }
        if (orderPackage.getPackageIdd().equals(PackageIdd.MEDIUM_PACKAGE.getIdd())) {
            lineNo = PackageIdd.MEDIUM_PACKAGE.getLineNo();
        }
        if (orderPackage.getPackageIdd().equals(PackageIdd.LARGE_PACKAGE.getIdd())) {
            lineNo = PackageIdd.LARGE_PACKAGE.getLineNo();
        }

        iddocLinenumberIdentity.setLineNo(lineNo);
        iddocLinenumberIdentity.setIdDoc(idDoc);
        writeOffDocumentItem.setIddocLinenumberIdentity(iddocLinenumberIdentity);
        writeOffDocumentItem.setEmployee(orderDocument.getCollectorName());
        writeOffDocumentItem.setProduct(productInfo.getId());
        writeOffDocumentItem.setUnit("     0   ");
        writeOffDocumentItem.setQuantity(orderPackage.getPackageQuantity());
        writeOffDocumentItem.setPrice(price);
        BigDecimal sum = writeOffDocumentItem.getQuantity().multiply(writeOffDocumentItem.getPrice());
        writeOffDocumentItem.setSum(sum);
        return writeOffDocumentItem;


    }

}
