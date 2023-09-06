package ru.gloria_jeans.receiving.dao.mapper;

import com.google.common.base.Strings;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentModelType;
import ru.gloria_jeans.core.v1.receiving.models.response.MovingDocumentModel;
import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocumentItem;
import ru.gloria_jeans.receiving.dao.model.Document;
import ru.gloria_jeans.receiving.dao.model.OpenLot;
import ru.gloria_jeans.receiving.dao.model.Product;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MovingDocumentModelMapper {
    public static MovingDocumentModel map(AcceptanceDocument acceptanceDocument) {
        return map(acceptanceDocument, null);
    }

    public static MovingDocumentModel map(AcceptanceDocument acceptanceDocument, MovingDocumentModelType type) {
        return map(acceptanceDocument, type, null);
    }

    public static MovingDocumentModel map(AcceptanceDocument acceptanceDocument, MovingDocumentModelType type, String lotId) {
        MovingDocumentModel movingDocumentModel = new MovingDocumentModel();
        movingDocumentModel.setId(acceptanceDocument.getJournal().getIdd());
        movingDocumentModel.setLotId(lotId);
        movingDocumentModel.setStatus(acceptanceDocument.getMovingDocument().getStatus().toString());

        if (Objects.nonNull(acceptanceDocument.getDateCreated())) {
            movingDocumentModel.setCreatedDate(acceptanceDocument.getDateCreated());
        }

        movingDocumentModel.setCount(String.format(
                "%s/%s",
                acceptanceDocument.getItems().size(),
                acceptanceDocument.getFactQuantity()
        ));

        for (AcceptanceDocumentItem acceptanceDocumentItem : acceptanceDocument.getItems()) {
            movingDocumentModel.getProductModels().add(
                    ProductModelMapper.map(
                            acceptanceDocumentItem.getProductInfo(),
                            acceptanceDocumentItem.getQuantityDoc().intValue(),
                            acceptanceDocumentItem.getFactQuantity().intValue()
                    )
            );
        }

        movingDocumentModel.setType(type);
        return movingDocumentModel;
    }

    public static MovingDocumentModel map(Document document, String barcodeBox) {
        return map(document, barcodeBox, null);
    }

    //продукт
    public static MovingDocumentModel map(Document document, String barcodeBox, MovingDocumentModelType type) {
        MovingDocumentModel movingDocumentModel = new MovingDocumentModel();
        movingDocumentModel.setId(document.getIdd());
        movingDocumentModel.setType(type);
        movingDocumentModel.setLotId(null);

        movingDocumentModel.setStatus(document.getStatus().toString());
        movingDocumentModel.setCreatedDate(Date.from(document.getCreatedAt()));

        List<Product> products = document
                .getProducts()
                .parallelStream()
                .filter(x -> x.getBarcodeBox().trim().equals(barcodeBox.trim()))
                .sorted(Comparator.comparing(Product::getFullName, Comparator.naturalOrder()))
                .collect(Collectors.toList());

        for (Product product : products) {
            movingDocumentModel.getProductModels().add(
                    ProductModelMapper.map(
                            product,
                            product.getQuantity(),
                            product.getQuantityFact()
                    )
            );
        }

        Set<Product> productList = Set.copyOf(products);

        movingDocumentModel.setCount(String.format(
                "%s/%s",
                productList
                        .parallelStream()
                        .mapToInt(Product::getQuantity)
                        .sum(),
                productList
                        .parallelStream()
                        .mapToInt(Product::getQuantityFact)
                        .sum()
        ));
        movingDocumentModel.setQuantity(
                String.valueOf(
                        productList
                                .parallelStream()
                                .mapToInt(Product::getQuantity)
                                .sum()
                )
        );
        movingDocumentModel.setQuantityFact(
                String.valueOf(
                        productList
                                .parallelStream()
                                .mapToInt(Product::getQuantityFact)
                                .sum()
                )
        );
        movingDocumentModel.setQuantityDiff(String.valueOf(productList.parallelStream()
                .mapToInt(Product::getQuantityFact)
                .sum() - productList
                .parallelStream()
                .mapToInt(Product::getQuantity)
                .sum()));
        return movingDocumentModel;
    }

    public static MovingDocumentModel map(Document document, String barcodeBox, MovingDocumentModelType type, String lotIdd) {
        return map(document, barcodeBox, type, lotIdd, null);
    }

    //set OpenLots
    public static MovingDocumentModel map(
            Document document,
            String barcodeBox,
            MovingDocumentModelType type,
            String lotIdd,
            Integer lineNumberLot
    ) {
        MovingDocumentModel movingDocumentModel = new MovingDocumentModel();
        movingDocumentModel.setId(document.getIdd());
        movingDocumentModel.setType(type);
        movingDocumentModel.setLotId(lotIdd);
        movingDocumentModel.setStatus(document.getStatus().toString());
        movingDocumentModel.setCreatedDate(Date.from(document.getCreatedAt()));

        if (!Strings.isNullOrEmpty(String.valueOf(lineNumberLot))) {
            movingDocumentModel.setLineNumberLot(String.valueOf(lineNumberLot));
        }
        List<Product> products = document
                .getProducts()
                .parallelStream()
                .filter(x -> x.getBarcodeBox().trim().equals(barcodeBox.trim()))
                .sorted(Comparator.comparingInt(Product::getLineNumber))
                .collect(Collectors.toList());

        for (Product product : products) {
            movingDocumentModel.getProductModels().add(
                    ProductModelMapper.map(
                            product,
                            product.getQuantity(),
                            product.getQuantityFact()
                    )
            );
        }
        movingDocumentModel.setLotName(
                document.getProducts()
                        .parallelStream()
                        .filter(x -> x.getIdd().trim().equals(lotIdd.trim()))
                        .map(Product::getFullName)
                        .findFirst()
                        .orElse(null)

        );
        List<OpenLot> openLots = document.getProducts()
                .parallelStream()
                .filter(e -> e.getIdd().equals(movingDocumentModel.getLotId()) && e.getLineNumber().equals(lineNumberLot))
                .flatMap(x -> x.getProductsIntoLot().parallelStream())
                .collect(Collectors.toList());
        movingDocumentModel.setCount(String.format(
                "%s/%s",
                openLots
                        .parallelStream()
                        .mapToInt(OpenLot::getQuantity)
                        .sum(),
                openLots
                        .parallelStream()
                        .mapToInt(OpenLot::getFactQuantity)
                        .sum()
        ));
        movingDocumentModel.setQuantity(
                String.valueOf(
                        openLots
                                .parallelStream()
                                .mapToInt(OpenLot::getQuantity)
                                .sum()
                )
        );
        movingDocumentModel.setQuantityFact(
                String.valueOf(
                        openLots
                                .parallelStream()
                                .mapToInt(OpenLot::getFactQuantity)
                                .sum()
                )
        );
        movingDocumentModel.setQuantityDiff(String.valueOf(openLots.parallelStream()
                .mapToInt(OpenLot::getFactQuantity)
                .sum() - openLots
                .parallelStream()
                .mapToInt(OpenLot::getQuantity)
                .sum()));
        return movingDocumentModel;
    }
}
