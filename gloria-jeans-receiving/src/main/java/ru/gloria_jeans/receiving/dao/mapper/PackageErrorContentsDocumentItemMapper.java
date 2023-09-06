package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.PackageErrorContentsDocumentItem;
import ru.gloria_jeans.receiving.dao.model.OpenLot;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class PackageErrorContentsDocumentItemMapper {
    public static PackageErrorContentsDocumentItem map(
            OpenLot openLot,
            Integer lineNumber,
            String iddoc,
            BigDecimal vat
    ) {
        PackageErrorContentsDocumentItem item = new PackageErrorContentsDocumentItem();
        IddocLinenumberIdentity iddocLinenumberIdentity = new IddocLinenumberIdentity();
        iddocLinenumberIdentity.setIdDoc(iddoc);
        iddocLinenumberIdentity.setLineNo(lineNumber);
        item.setIddocLinenumberIdentity(iddocLinenumberIdentity);
        item.setItem(openLot.getOriginalId());
        item.setQuantity(BigDecimal.valueOf(openLot.getFactQuantity()));
        item.setUnit(openLot.getUnit());
        item.setPrice(openLot.getPrice());
        item.setCoefficient(BigDecimal.ZERO);
        item.setSum(openLot.getPrice().multiply(BigDecimal.valueOf(openLot.getFactQuantity())));
        item.setVatRate(vat);
        item.setVat(vat);
        item.setTotal(BigDecimal.valueOf(openLot.getQuantity()));
        item.setMust(BigDecimal.valueOf(openLot.getQuantity()));
        item.setMarks("");
        item.setBarcodeLot(openLot.getBarcode());
        item.setBarcodeBox(openLot.getBarcodeBox());

        if (openLot.getScannedMarks().size() > 0) {
            item.setMarks(
                    openLot.getScannedMarks()
                            .parallelStream()
                            .map(ScannedMark::getScannedMark)
                            .collect(Collectors.joining())
            );
        }

        return item;
    }
}
