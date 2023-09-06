package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.Lot;
import ru.gloria_jeans.onecdbmapper.dao.model.ProductInfo;
import ru.gloria_jeans.receiving.dao.model.OpenLot;

import java.math.BigDecimal;

public class OpenLotMapper {
    public static OpenLot map(
            Lot lot,
            String iddLot,
            String iddDocument,
            String barcodeBox,
            BigDecimal price,
            BigDecimal vat,
            Integer lineNumberLot
    ) {
        OpenLot openLot = new OpenLot();
        openLot.setLotIdd(iddLot);
        openLot.setDocumentIdd(iddDocument);
        openLot.setProductIdd(lot.getIdd());
        openLot.setBarcode(lot.getProductInfo().getBarcode());
        openLot.setBarcodeBox(barcodeBox);
        openLot.setFullName(lot.getProductInfo().getFullName());
        openLot.setVendorCode(lot.getProductInfo().getVendorCode());
        openLot.setFactQuantity(0);
        openLot.setQuantity(lot.getQuantity());
        openLot.setPrice(price);
        openLot.setVat(vat);
        openLot.setOriginalIdLot(lot.getParentExt());
        openLot.setOriginalId(lot.getProductInfo().getId());
        openLot.setMarkTypeCode(lot.getProductInfo().getMarkTypeCode());
        openLot.setUnit(lot.getProductInfo().getBaseUnit());
        openLot.setNdsRate(lot.getProductInfo().getNdsRate());
        openLot.setLineNumberLot(lineNumberLot);
        return openLot;
    }

    public static OpenLot map(
            ProductInfo productInfo,
            String iddLot,
            String iddDocument,
            String barcodeBox,
            BigDecimal price,
            BigDecimal vat,
            Integer lineNumberLot
    ) {
        OpenLot openLot = new OpenLot();
        openLot.setLotIdd(iddLot);
        openLot.setDocumentIdd(iddDocument);
        openLot.setProductIdd(productInfo.getIdd());
        openLot.setBarcode(productInfo.getBarcode());
        openLot.setBarcodeBox(barcodeBox);
        openLot.setFullName(productInfo.getFullName());
        openLot.setVendorCode(productInfo.getVendorCode());
        openLot.setFactQuantity(0);
        openLot.setQuantity(0);
        openLot.setPrice(price);
        openLot.setVat(vat);
        openLot.setOriginalId(productInfo.getId());
        openLot.setMarkTypeCode(productInfo.getMarkTypeCode());
        openLot.setUnit(productInfo.getBaseUnit());
        openLot.setNdsRate(productInfo.getNdsRate());
        openLot.setLineNumberLot(lineNumberLot);
        return openLot;
    }
}
