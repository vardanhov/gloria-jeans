package ru.gloria_jeans.receiving.dao.mapper;

import com.google.common.base.Strings;
import ru.gloria_jeans.core.v1.receiving.models.response.DocumentResultSearchModel;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.receiving.dao.model.Document;
import ru.gloria_jeans.receiving.dao.model.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DocumentResultSearchModelMapper {

    private final static String lang = "ru";

    public static DocumentResultSearchModel map(
            MovingDocumentListing movingDocument,
            Document localDocument,
            List<KeyValue> reasons,
            Date createdAt
    ) {
        DocumentResultSearchModel documentResultSearchModel = new DocumentResultSearchModel();
        documentResultSearchModel.setIdd(movingDocument.getIdd());
        documentResultSearchModel.setDocNumber(movingDocument.getDocno());
        documentResultSearchModel.setDocDate(createdAt);
        String reason = reasons
                .parallelStream()
                .filter(x -> x.getKey().equals(movingDocument.getReasonId()))
                .findFirst()
                .map(KeyValue::getValue)
                .orElse(null);

        if (!Strings.isNullOrEmpty(reason)) {
            documentResultSearchModel.setType(reason.trim());
        }

        if (Objects.nonNull(localDocument)) {
            documentResultSearchModel.setStatus("warehouse.supply.result.search.document.status.in_work");
        } else if (Strings.isNullOrEmpty(movingDocument.getAcceptanceDocumentIddoc())) {
            documentResultSearchModel.setStatus("warehouse.supply.result.search.document.status.new");
        } else if (!Strings.isNullOrEmpty(movingDocument.getAcceptanceDocumentIddoc())) {
            documentResultSearchModel.setStatus("warehouse.supply.result.search.document.status.ready");
        }

        Integer factBoxes = 0, factQuantity = 0;

        if (Objects.nonNull(localDocument)) {
            factBoxes = localDocument.getProducts()
                    .parallelStream()
                    .filter(x -> x.getQuantityFact() > 0)
                    .collect(Collectors.groupingByConcurrent(Product::getBarcodeBox))
                    .size();
            factQuantity = localDocument.getProducts()
                    .parallelStream()
                    .mapToInt(Product::getQuantityFact)
                    .sum();
        } else if (!Strings.isNullOrEmpty(movingDocument.getAcceptanceDocumentIddoc())) {
            factBoxes = movingDocument.getQuantityBox();
            factQuantity = movingDocument.getAcceptanceDocumentQuantityFact();
        }

        documentResultSearchModel.setTotalBoxes(Integer.toString(movingDocument.getQuantityPlaces()));
        documentResultSearchModel.setFactBoxes(factBoxes.toString());
        documentResultSearchModel.setTotalQuantity(Integer.toString(movingDocument.getQuantity()));
        documentResultSearchModel.setFactQuantity(factQuantity.toString());
        return documentResultSearchModel;
    }

    public static DocumentResultSearchModel map(
            MovingDocument movingDocument,
            Document localDocument,
            String movingReasonDescription,
            String warehouse
    ) {
        DocumentResultSearchModel documentResultSearchModel = new DocumentResultSearchModel();
        documentResultSearchModel.setIdd(movingDocument.getJournal().getIdd());
        documentResultSearchModel.setDocNumber(movingDocument.getJournal().getDocno());
        documentResultSearchModel.setType(movingReasonDescription);
        documentResultSearchModel.setDocDate(movingDocument.getJournal().getDocDate());
        documentResultSearchModel.setWarehouse(warehouse);

        if (Objects.nonNull(localDocument)) {
            documentResultSearchModel.setStatus("warehouse.supply.result.search.document.status.in_work");
        } else if (Objects.isNull(movingDocument.getAcceptanceDocument())) {
            documentResultSearchModel.setStatus("warehouse.supply.result.search.document.status.new");
        }  else if (Objects.nonNull(movingDocument.getAcceptanceDocument())) {
            documentResultSearchModel.setStatus("warehouse.supply.result.search.document.status.ready");
        }

        Integer factBoxes = 0, factQuantity = 0;

        if (Objects.nonNull(localDocument)) {
            factBoxes = localDocument.getProducts()
                    .parallelStream()
                    .filter(x -> x.getQuantityFact() > 0)
                    .collect(Collectors.groupingByConcurrent(Product::getBarcodeBox))
                    .size();
            factQuantity = localDocument.getProducts()
                    .parallelStream()
                    .mapToInt(Product::getQuantityFact)
                    .sum();
        } else if (Objects.nonNull(movingDocument.getAcceptanceDocument())) {
            factBoxes = movingDocument.getAcceptanceDocument().getItems()
                    .parallelStream()
                    .filter(e -> e.getFactQuantity().intValue() > 0)
                    .collect(Collectors.groupingByConcurrent(AcceptanceDocumentItem::getBarcodeBox))
                    .size();
            factQuantity = movingDocument.getAcceptanceDocument().getItems()
                    .parallelStream()
                    .map(AcceptanceDocumentItem::getFactQuantity)
                    .mapToInt(BigDecimal::intValue)
                    .sum();
        }

        Integer totalBoxes = movingDocument.getItems()
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(MovingDocumentItem::getBarcodeBox))
                .size();
        documentResultSearchModel.setTotalBoxes(totalBoxes.toString());
        documentResultSearchModel.setFactBoxes(factBoxes.toString());
        documentResultSearchModel.setTotalQuantity(Integer.toString(movingDocument.getQuantity().intValue()));
        documentResultSearchModel.setFactQuantity(factQuantity.toString());
        return documentResultSearchModel;
    }
}
