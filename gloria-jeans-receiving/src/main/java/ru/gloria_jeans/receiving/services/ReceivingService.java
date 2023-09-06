package ru.gloria_jeans.receiving.services;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentModelType;
import ru.gloria_jeans.core.v1.receiving.models.response.*;
import ru.gloria_jeans.core.v1.utils.BarcodeHelper;
import ru.gloria_jeans.onecdbmapper.dao.enums.ProductType;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.receiving.configuration.MarkConstantsReceiving;
import ru.gloria_jeans.receiving.dao.mapper.*;
import ru.gloria_jeans.receiving.dao.model.Document;
import ru.gloria_jeans.receiving.dao.model.OpenLot;
import ru.gloria_jeans.receiving.dao.model.Product;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;
import ru.gloria_jeans.receiving.model.marks.Mark;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class ReceivingService {
    public Logger logger = LoggerFactory.getLogger("ReceivingService");
    private final OnecService onecService;
    private final DatabaseService databaseService;
    private final MarksServiceReceiving marksServiceResiving;
    private final IddGeneratingService iddGeneratingService;
    private final MarkConstantsReceiving markConstants;
    private List<String> journalsMarksOnDelete = new ArrayList<>();

    @Autowired
    public ReceivingService(
            OnecService onecService,
            DatabaseService databaseService,
            MarksServiceReceiving marksServiceResiving,
            IddGeneratingService iddGeneratingService,
            MarkConstantsReceiving markConstants
    ) {
        this.onecService = onecService;
        this.databaseService = databaseService;
        this.marksServiceResiving = marksServiceResiving;
        this.iddGeneratingService = iddGeneratingService;
        this.markConstants = markConstants;
    }

    @Transactional
    public ViewDocumentModel getDocument(String idd) {
        logger.info("Getting document by idd:'{}'.", idd);
        MovingDocument movingDocument = onecService.getMovingDocument(idd);
        logger.info(Objects.nonNull(movingDocument) ? "Document found into 1C." : "Document not found into 1C.");
        Document localDocument = databaseService.getLocalDocumentByDocumentIdd(idd);
        logger.info(Objects.nonNull(localDocument) ? "Document found into local db." : "Document not found into local db.");
        List<ViewDocumentBoxModel> boxes = new ArrayList<>();
        Map<String, List<MovingDocumentItem>> movingDocumentBoxes = movingDocument.getItems()
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(x -> x.getBarcodeBox().trim()));
        logger.info("Document contains '{}' boxes.", movingDocumentBoxes.size());
        Map<String, List<AcceptanceDocumentItem>> acceptanceDocumentBoxes = null;
        Map<String, List<Product>> localDocumentBoxes = null;

        if (Objects.nonNull(movingDocument.getAcceptanceDocument())) {
            movingDocument.getAcceptanceDocument().setItems(
                    movingDocument.getAcceptanceDocument().getItems().parallelStream()
                            .peek(e -> e.setBarcodeBox(e.getBarcodeBox().trim())).collect(Collectors.toList())
            );
            acceptanceDocumentBoxes = movingDocument.getAcceptanceDocument().getItems()
                    .parallelStream()
                    .collect(Collectors.groupingByConcurrent(AcceptanceDocumentItem::getBarcodeBox));
        }

        if (Objects.nonNull(localDocument)) {
            localDocumentBoxes = localDocument.getProducts()
                    .parallelStream()
                    .collect(Collectors.groupingByConcurrent(Product::getBarcodeBox));
        }

        for (Map.Entry<String, List<MovingDocumentItem>> movingDocumentBox : movingDocumentBoxes.entrySet()) {
            Integer totalQuantity = movingDocumentBox.getValue()
                    .parallelStream()
                    .mapToInt(x -> x.getQuantity().intValue())
                    .sum();
            int factQuantity = 0;
            ViewDocumentBoxModel box = new ViewDocumentBoxModel();
            box.setBarcode(movingDocumentBox.getKey());
            box.setTotalQuantity(String.valueOf(totalQuantity));
            box.setBoxAccepted(false);

            if (Objects.nonNull(acceptanceDocumentBoxes) && Objects.nonNull(acceptanceDocumentBoxes.get(movingDocumentBox.getKey()))) {
                factQuantity = acceptanceDocumentBoxes.get(movingDocumentBox.getKey())
                        .parallelStream()
                        .mapToInt(x -> x.getFactQuantity().intValue())
                        .sum();
            } else if (Objects.nonNull(localDocumentBoxes) && Objects.nonNull(localDocumentBoxes.get(movingDocumentBox.getKey()))) {
                factQuantity = localDocumentBoxes.get(movingDocumentBox.getKey())
                        .parallelStream()
                        .mapToInt(Product::getQuantityFact)
                        .sum();

                for (Product product : localDocumentBoxes.get(movingDocumentBox.getKey())) {
                    if (product.getQuantity().intValue() == product.getQuantityFact().intValue()) {
                        box.setBoxAccepted(true);
                    } else {
                        box.setBoxAccepted(false);
                        break;
                    }
                }
            }

            box.setFactQuantity(String.valueOf(factQuantity));
            box.setDifferenceQuantity(Integer.toString(factQuantity - totalQuantity));
            boxes.add(box);
        }
        MovingReason movingReason = onecService.getMovingReasonById(movingDocument.getBasis());
        String movingReasonDescription = "";

        if (Objects.nonNull(movingReason)) {
            movingReasonDescription = movingReason.getDescr().trim();
        }

        ViewDocumentModel viewDocumentModel = new ViewDocumentModel();
        viewDocumentModel.setViewDocument(
                DocumentResultSearchModelMapper.map(
                        movingDocument,
                        localDocument,
                        movingReasonDescription,
                        onecService.getWarehouseName(movingDocument.getWarehouse())
                )
        );
        viewDocumentModel.setBoxes(boxes);
        return viewDocumentModel;
    }

    @Transactional
    public DocumentResultSearchListModel findDocuments(
            String searchingString,
            String dateFrom,
            String dateTo,
            List <String> selectedStatuses
    ) throws Exception {
        logger.info("Searching documents by incoming string:'{}' or dateFrom:'{}' with dateTo:'{}'.", searchingString, dateFrom, dateTo);
        List<DocumentResultSearchModel> resultSearch = new ArrayList<>();
        List<MovingDocumentListing> movingDocuments = null;
        List<KeyValue> reasons = onecService.getAllMovingReasonLikeKeyValue();
        String warehouseId = onecService.getCurrentStore().getId();
        if (!Strings.isNullOrEmpty(searchingString)) {
            MovingDocumentListing movingDocumentListing = onecService.getMovingDocumentListingByDocumentBarcode(BarcodeHelper.getBarcodeFromTorg13(searchingString), warehouseId);

            if (Objects.isNull(movingDocumentListing)) {
                movingDocumentListing = onecService.getMovingDocumentListingByDocumentBarcode(searchingString, warehouseId);
            }

            if (Objects.nonNull(movingDocumentListing)) {
                movingDocuments = List.of(movingDocumentListing);
            } else {
                movingDocuments = onecService.getMovingDocumentsByDocumentNumber(searchingString, warehouseId);
            }
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(dateFrom));
            DecimalFormat dmFormat = new DecimalFormat("00");
            String stringDateFrom = String.format(
                    "%s%s%s",
                    calendar.get(Calendar.YEAR),
                    dmFormat.format(Double.valueOf(calendar.get(Calendar.MONTH) + 1)),
                    dmFormat.format(Double.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))
            );
            calendar.setTime(formatter.parse(dateTo));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            String stringDateTo = String.format(
                    "%s%s%s",
                    calendar.get(Calendar.YEAR),
                    dmFormat.format(Double.valueOf(calendar.get(Calendar.MONTH) + 1)),
                    dmFormat.format(Double.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))
            );
            movingDocuments = onecService.findMovingDocumentListings(
                    stringDateFrom,
                    stringDateTo,
                    warehouseId
            );
            movingDocuments = new ArrayList<>(movingDocuments.parallelStream()
                    .collect(Collectors.toMap(MovingDocumentListing::getIdd, e -> e, (a, b) -> {
                        if (a.getAcceptanceDocumentIddoc() != null) {
                            return a;
                        } else {
                            return b;
                        }
                    }))
                    .values());
        }

        if (Objects.nonNull(movingDocuments) && movingDocuments.size() > 0) {
            logger.info("Searching documents founded '{}' documents.", movingDocuments.size());
            Set<Document> localDocuments = databaseService.getLocalDocumentsByDocumentIdds(
                    movingDocuments
                            .parallelStream()
                            .map(MovingDocumentListing::getIdd)
                            .collect(Collectors.toList())
            );

            for (MovingDocumentListing movingDocument : movingDocuments) {
                Document localDocument = localDocuments
                        .parallelStream()
                        .filter(x -> x.getIdd().equals(movingDocument.getIdd()))
                        .findFirst()
                        .orElse(null);
                resultSearch.add(
                        DocumentResultSearchModelMapper.map(
                                movingDocument,
                                localDocument,
                                reasons,
                                onecService.getDateTimeFromDateTimeIdDoc(movingDocument.getDateTimeIdDoc())
                        )
                );
            }
        } else {
            logger.info("Searching documents not found documents.");
        }

        if (selectedStatuses.size() == 0){
            return new DocumentResultSearchListModel(resultSearch);
        }

        List<DocumentResultSearchModel> filteredResult = new ArrayList<>();

        for (String status : selectedStatuses){
            var list = resultSearch.parallelStream()
                    .filter(x -> status.equals(x.getStatus()))
                    .collect(Collectors.toList());
            filteredResult.addAll(list);
        }

        return new DocumentResultSearchListModel(filteredResult);
    }

    @Transactional
    public MovingDocumentModel acceptanceBox(String barcodeBox, String idd) throws Exception {
        logger.info("Accepting box with barcodeBox:'{}' and document idd:'{}'", barcodeBox, idd);
        MovingDocumentModel viewModel = new MovingDocumentModel();
        Document boxByBarcode = null;
        Document boxByDocumentIdd = null;
        MovingDocument movingDocumentByIdd = null;
        AcceptanceDocument acceptanceDocumentByIdd = null;
        MovingDocument movingDocumentByBarcode = null;
        AcceptanceDocument acceptanceDocumentByBarcode = null;

        if (!Strings.isNullOrEmpty(barcodeBox)) {
            boxByBarcode = databaseService.getLocalDocumentByBarcodeBox(barcodeBox);
            Set<MovingDocument> movingDocumentsByBarcode = onecService.getMovingDocuments(barcodeBox);
            Set<AcceptanceDocument> acceptanceDocumentsByBarcode = onecService.getAcceptanceDocuments(barcodeBox);

            if (movingDocumentsByBarcode.size() > 1) {
                logger.info("Many moving documents for box: {}", barcodeBox);
                throw new Exception("screen.warehouse.supply.recalculation.box.message.error.many_moving_documents");
            }

            if (acceptanceDocumentsByBarcode.size() > 1) {
                logger.info("Many acceptance documents for box: {}", barcodeBox);
                throw new Exception("screen.warehouse.supply.recalculation.box.message.error.many_acceptance_documents");
            }

            movingDocumentByBarcode = movingDocumentsByBarcode.iterator().hasNext() ? movingDocumentsByBarcode.iterator().next() : null;
            acceptanceDocumentByBarcode = acceptanceDocumentsByBarcode.iterator().hasNext() ? acceptanceDocumentsByBarcode.iterator().next() : null;
        }

        if (!Strings.isNullOrEmpty(idd)) {
            boxByDocumentIdd = databaseService.getLocalDocumentByDocumentIdd(idd);
            movingDocumentByIdd = onecService.getMovingDocument(idd);
            acceptanceDocumentByIdd = onecService.getAcceptanceDocument(idd);
        }

        switch (
                getCase(
                        boxByBarcode,
                        movingDocumentByBarcode,
                        acceptanceDocumentByBarcode,
                        boxByDocumentIdd,
                        movingDocumentByIdd,
                        acceptanceDocumentByIdd,
                        barcodeBox,
                        idd
                )
        ) {
            //возвращаем данные по коробке на основе таблицы ниже (столбец "Приложение возвращает в ответ")
            case 1:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                viewModel = MovingDocumentModelMapper.map(
                        boxByBarcode,
                        barcodeBox
                );
                break;

            case 2:
                logger.info(
                        "Moving document has acceptance document with idd:'{}', idoc:'{}', document number:'{}'.",
                        acceptanceDocumentByBarcode.getJournal().getIdd(),
                        acceptanceDocumentByBarcode.getJournal().getIdoc(),
                        acceptanceDocumentByBarcode.getJournal().getDocno()
                );
                throw new Exception("screen.warehouse.supply.recalculation.box.message.exist_acceptance_document");

                // Создаем в БД приложения Складские операции. Поставка заготовку ПА на основе ПР.
                // Далее выводим данные по коробке из созданной заготовки ПА.
            case 3:
            case 13:
            case 14:
            case 15:
                Document document = databaseService.createLocalDocument(
                        DocumentMapper.map(
                                movingDocumentByBarcode,
                                onecService.getDateTimeFromDateTimeIdDoc(
                                        movingDocumentByBarcode.getJournal().getDateTimeIdDoc()
                                )
                        )
                );
                List<Product> products = movingDocumentByBarcode.getItems()
                        .parallelStream()
                        .filter(x -> x.getBarcodeBox().trim().equals(barcodeBox.trim()))
                        .map(ProductMapper::map)
                        .sorted(Comparator.comparing(Product::getFullName, Comparator.naturalOrder()))
                        .collect(Collectors.toList());

                for (Product product : products) {
                    product.setVat(
                            onecService.getVat(
                                    product.getOriginalId(), Date.from(document.getCreatedAt())
                            )
                    );
                }
                products = dividerProductLot(products);
                products = databaseService.createProducts(products
                        .parallelStream()
                        .map(x -> {
                            x.setDocumentIdd(document.getIdd());
                            x.setDocument(document);
                            return x;
                        })
                        .collect(Collectors.toList())
                );
                document.setProducts(Set.copyOf(products));
                viewModel = MovingDocumentModelMapper.map(
                        document,
                        barcodeBox
                );
                logger.info("Created document into internal database: {}", document);
                break;

            case 4:
                //Коробка создается излишком в текущем документе, т.е. КоличествоДок заполняется 0.
                boxByDocumentIdd.setQuantity(BigDecimal.ZERO);
                databaseService.updateDocument(boxByDocumentIdd);
                logger.info("Created document into internal database:");
                break;

            case 5:
            case 6:
                //Выводим "Коробка не найдена. Вероятно требуется выполнить обновление данных в 1с"
                // (The box was not found. You probably need to update the data in 1с)
                logger.info("AcceptanceBox box not found needs to update data in 1c");
                throw new Exception("screen.warehouse.supply.recalculation.box.message.error.box_not_found_refresh_data_in_1c");

            case 0:
            default:
                logger.info("AcceptanceBox box not found into any documents.");
                throw new Exception("screen.warehouse.supply.recalculation.box.message.error.box_not_found");
        }

        logger.info("AcceptanceBox finished with success: barcodeBox = {}, idd = {}", barcodeBox, idd);
        return viewModel;
    }

    private int getCase(
            Document boxByBarcode,
            MovingDocument movingDocumentByBarcode,
            AcceptanceDocument acceptanceDocumentByBarcode,
            Document boxByDocumentIdd,
            MovingDocument movingDocumentByIdd,
            AcceptanceDocument acceptanceDocumentByIdd,
            String barcodeBox,
            String idd
    ) {
        if (Objects.nonNull(boxByBarcode) && Strings.isNullOrEmpty(idd)) {
            return 1;
        }

        if (Objects.nonNull(acceptanceDocumentByBarcode) && Strings.isNullOrEmpty(idd)) {
            return 2;
        }

        if (Objects.nonNull(movingDocumentByBarcode) && Strings.isNullOrEmpty(idd)) {
            return 3;
        }

        if (Objects.nonNull(boxByDocumentIdd) && Strings.isNullOrEmpty(barcodeBox)) {
            return 4;
        }

        if (Objects.nonNull(acceptanceDocumentByIdd) && Strings.isNullOrEmpty(barcodeBox)) {
            return 5;
        }

        if (Objects.nonNull(movingDocumentByIdd) && Strings.isNullOrEmpty(barcodeBox)) {
            return 6;
        }

        if (Objects.nonNull(boxByBarcode) && Objects.nonNull(boxByDocumentIdd)) {
            return 7;
        }

        if (Objects.nonNull(boxByBarcode) && Objects.nonNull(acceptanceDocumentByIdd)) {
            return 8;
        }

        if (Objects.nonNull(boxByBarcode) && Objects.nonNull(movingDocumentByIdd)) {
            return 9;
        }

        if (Objects.nonNull(boxByDocumentIdd) && Objects.nonNull(acceptanceDocumentByBarcode)) {
            return 10;
        }

        if (Objects.nonNull(acceptanceDocumentByBarcode) && Objects.nonNull(acceptanceDocumentByIdd)) {
            return 11;
        }

        if (Objects.nonNull(movingDocumentByIdd) && Objects.nonNull(acceptanceDocumentByBarcode)) {
            return 12;
        }

        if (Objects.nonNull(boxByDocumentIdd) && Objects.nonNull(movingDocumentByBarcode)) {
            return 13;
        }

        if (Objects.nonNull(movingDocumentByBarcode) && Objects.nonNull(acceptanceDocumentByIdd)) {
            return 14;
        }

        if (Objects.nonNull(movingDocumentByBarcode) && Objects.nonNull(movingDocumentByIdd)) {
            return 15;
        }

        return 0;
    }

    @Transactional
    public MovingDocumentModel acceptanceProduct(
            String documentIdd,
            String barcodeBox,
            String handleSearch,
            String scannedSearch,
            Boolean notCountQuantityLot,
            Integer lineNumber
    ) throws Exception {
        logger.info(
                "Accepting product with document  idd:'{}',  barcode box:'{}', handleSearch:'{}', scannedSearch:'{}', notCountQuantityLot:'{}', lineNumber:'{}'.",
                documentIdd,
                barcodeBox,
                handleSearch,
                scannedSearch,
                notCountQuantityLot,
                lineNumber
        );
        Document document = databaseService.getLocalDocumentByDocumentIdd(documentIdd);
        String search = Strings.isNullOrEmpty(handleSearch) ? scannedSearch : handleSearch.trim();
        List<Product> products = databaseService.searchProducts(
                barcodeBox,
                search.length() >= 31 ? BarcodeHelper.getBarcodeFromDatamatrix(search) : search
        );

        if (products.size() == 0) {
            products = databaseService.getProductsByMark(
                    barcodeBox,
                    search.length() >= 31 ? BarcodeHelper.getMarkFromDatamatrix(search) : search
            );
        }

        if (products.size() == 0) {
            ProductInfo productInfo = onecService.searchProduct(search.length() >= 31 ? BarcodeHelper.getBarcodeFromDatamatrix(search) : search);

            if (Objects.isNull(productInfo)) {
                logger.info("Accepting product not found product.");
                throw new Exception("screen.warehouse.supply.lot.search.product.error.product_not_found");
            } else {
                Product product = ProductMapper.map(productInfo);
                product.setDocument(document);
                product.setDocumentIdd(document.getIdd());
                product.setBarcodeBox(barcodeBox);
                product.setQuantityFact(0);
                product.setQuantity(0);
                product.setSum(BigDecimal.ZERO);
                product.setLineNumber(databaseService.getNewLineNumberLot(documentIdd));
                product.setMarks("");

                try {
                    product.setPrice(onecService.getPrice(productInfo.getId(), Date.from(document.getCreatedAt())));
                } catch (Exception exception) {
                    logger.error(
                            "Service didn't find price for this product id:'{}', idd:'{}', vendor code:'{}', name:'{}'.",
                            productInfo.getId(),
                            product.getIdd(),
                            product.getVendorCode(),
                            productInfo.getFullName(),
                            exception
                    );
                    throw new Exception("screen.warehouse.supply.acceptance.product.price_not_set", exception);
                }

                try {
                    product.setVat(onecService.getVat(productInfo.getId(), Date.from(document.getCreatedAt())));
                } catch (Exception exception) {
                    logger.error(
                            "Service didn't find VAT for this product id:'{}', idd:'{}', vendor code:'{}', name:'{}'.",
                            productInfo.getId(),
                            product.getIdd(),
                            product.getVendorCode(),
                            productInfo.getFullName(),
                            exception
                    );
                    throw new Exception("screen.warehouse.supply.acceptance.product.vat_not_set", exception);
                }

                products.add(product);
                document.getProducts().add(product);
                databaseService.updateProduct(product);
                logger.info("Accepting product found in 1C '{}' product info.", products.size());
            }
        } else {
            logger.info("Accepting product found in local db '{}' products.", products.size());
        }

        if (
                (Strings.isNullOrEmpty(products.get(0).getMarkTypeCode().trim()) || products.get(0).getMarkTypeCode().startsWith("0000")) &&
                        !ProductType.LOT.getValue().equals(products.get(0).getKindOfProduct())
        ) {
            //PRODUCT or many equals products and not LOT
            if (products.size() > 1
                    && !ProductType.LOT.getValue().equals(products.get(0).getKindOfProduct())
            ) {
                Product product = products
                        .parallelStream()
                        .min(Comparator.comparingLong(Product::getQuantityFact))
                        .orElse(products.get(0));
                product.setQuantityFact(product.getQuantityFact() + 1);
                product.setSum(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact())));
                databaseService.updateProduct(product);
            } else {
                products.get(0).setQuantityFact(products.get(0).getQuantityFact() + 1);
                products.get(0).setSum(products.get(0).getPrice().multiply(BigDecimal.valueOf(products.get(0).getQuantityFact())));
                databaseService.updateProduct(products.get(0));
            }

            document.setFactQuantity(document.getFactQuantity() + 1);
            document = updateSumIntoDocument(document);
            databaseService.updateDocument(document);
        } else if (
                (!Strings.isNullOrEmpty(products.get(0).getMarkTypeCode().trim()) && !products.get(0).getMarkTypeCode().startsWith("0000")) &&
                        !ProductType.LOT.getValue().equals(products.get(0).getKindOfProduct())
        ) {
            //PRODUCT WITH MARK
            if (
                    Strings.isNullOrEmpty(search) || search.length() <= 31 && (
                            search.equals(products.get(0).getBarcode()) ||
                                    search.equals(products.get(0).getIdd()) ||
                                    search.equals(products.get(0).getVendorCode())
                    )
            ) {
                return MovingDocumentModelMapper.map(
                        document,
                        barcodeBox,
                        MovingDocumentModelType.SCANNED_MARK
                );
            } else if (!BarcodeHelper.getBarcodeFromDatamatrix(search).equals(products.get(0).getBarcode())) {
                throw new Exception("warehouse.supply.recalculation.box.screen.error.message.mark_does_not_apply_to_the_product");
            } else if (databaseService.isExistScannedMark(BarcodeHelper.getMarkFromDatamatrix(search))) {
                throw new Exception("warehouse.supply.recalculation.box.screen.error.message.mark_is_exist");
            } else {
                ScannedMark scannedMark = new ScannedMark();
                scannedMark.setScannedMark(BarcodeHelper.getMarkFromDatamatrix(search));
                scannedMark.setProductId(products.get(0).getId());
                scannedMark.setDataMatrix(BarcodeHelper.clearDatamatrix(search));
                scannedMark.setBarcodeBox(products.get(0).getBarcodeBox());
                String message = marksServiceResiving.validate(
                        BarcodeHelper.clearDatamatrix(search),
                        onecService.getStoreIdd(),
                        onecService.getFirmByWarehouse(document.getWarehouse()).getIdd()
                );

                if (message.equals("OK")) {
                    Product product = products
                            .parallelStream()
                            .filter(x -> x.getScannedMarks().size() < 10)
                            .findFirst()
                            .orElse(null);

                    if (Objects.nonNull(product)) {
                        product.setQuantityFact(product.getQuantityFact() + 1);
                        product.setSum(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact())));
                        product.getScannedMarks().add(scannedMark);
                        product.setMarks(Objects.nonNull(product.getMarks()) ? product.getMarks().concat(BarcodeHelper.getMarkFromDatamatrix(search)) : BarcodeHelper.getMarkFromDatamatrix(search));
                    } else {
                        Product lastProduct = products.get(products.size() - 1);
                        product = lastProduct.clone();
                        product.setId(UUID.randomUUID());
                        product.setQuantity(lastProduct.getQuantity() - 10);
                        product.setQuantityFact(1);
                        product.setMarks(BarcodeHelper.getMarkFromDatamatrix(search));
                        product.setScannedMarks(List.of(scannedMark));
                        products.add(product);
                        lastProduct.setQuantity(10);
                        document.getProducts().add(product);
                        databaseService.updateProduct(lastProduct);
                    }

                    databaseService.updateProduct(product);
                    scannedMark.setValidMark(true);
                    scannedMark.setNumber(product.getQuantityFact());
                    databaseService.updateScannedMark(scannedMark);
                } else {
                    scannedMark.setValidMark(false);
                    scannedMark.setNumber(products.get(0).getQuantityFact() + 1);
                    scannedMark.setErrorMessage(message);
                    databaseService.updateScannedMark(scannedMark);
                    throw new Exception(message);
                }

                document.setFactQuantity(document.getFactQuantity() + 1);
                document = updateSumIntoDocument(document);
                databaseService.updateDocument(document);
            }
        } else if (
                !Strings.isNullOrEmpty(products.get(0).getMarkTypeCode().trim())
                        && !products.get(0).getMarkTypeCode().startsWith("0000")
                        && ProductType.LOT.getValue().equals(products.get(0).getKindOfProduct())
        ) {
            //IGNORE ADDING LOT WITH MARK
            return MovingDocumentModelMapper.map(
                    document,
                    barcodeBox,
                    MovingDocumentModelType.MARK_LOT,
                    products.get(0).getIdd()
            );
        } else {
            //LOT

            //If opening lot by link
            if (notCountQuantityLot) {
                Product product = products
                        .parallelStream()
                        .filter(x -> x.getLineNumber().equals(lineNumber))
                        .findFirst()
                        .orElse(null);

                if (product.getQuantityFact() == 0) {
                    throw new Exception("warehouse.supply.recalculation.box.screen.error.message.quantity_fact_of_lot_equals_zero");
                }

                if (product.getProductsIntoLot().size() == 0) {
                    ProductInfo lot = onecService.getProductByIdd(product.getIdd());
                    Set<Lot> lots = onecService.getLotItems(lot.getId());
                    databaseService.updateOpenLots(
                            convertLotsToOpenLots(
                                    lots,
                                    documentIdd,
                                    barcodeBox,
                                    product.getIdd(),
                                    product.getLineNumber(),
                                    document.getCreatedAt()
                            )
                    );
                }

                return MovingDocumentModelMapper.map(
                        document,
                        barcodeBox,
                        MovingDocumentModelType.LOT,
                        product.getIdd(),
                        Objects.isNull(lineNumber) ? product.getLineNumber() : lineNumber
                );
            }

            Product product = products
                    .parallelStream()
                    .filter(x -> x.getQuantity() > x.getQuantityFact())
                    .findFirst()
                    .orElse(null);

            if (Objects.nonNull(product)) {
                product.setQuantityFact(product.getQuantityFact() + 1);
                product.setSum(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact())));
                document.setFactQuantity(document.getFactQuantity() + 1);
                document = updateSumIntoDocument(document);
                databaseService.updateDocument(document);
                List<OpenLot> openLotProducts = databaseService.getOpenLots(product.getDocumentIdd(), product.getIdd());
                ProductInfo lot = onecService.getProductByIdd(product.getIdd());
                Set<Lot> lots = onecService.getLotItems(lot.getId());
                databaseService.updateOpenLots(
                        convertLotsToOpenLots(
                                lots,
                                documentIdd,
                                barcodeBox,
                                product.getIdd(),
                                product.getLineNumber(),
                                document.getCreatedAt()
                        )
                );
                databaseService.updateOpenLots(openLotProducts);
                return MovingDocumentModelMapper.map(
                        document,
                        barcodeBox,
                        MovingDocumentModelType.LOT,
                        product.getIdd(),
                        product.getLineNumber()
                );
            } else {
                product = products
                        .parallelStream()
                        .filter(x -> x.getQuantity().equals(0) && x.getQuantityFact().equals(0))
                        .findFirst()
                        .orElse(null);

                if (Objects.nonNull(product)) {
                    product.setQuantityFact(1);
                } else {
                    product = products.get(0).clone();
                    product.setLineNumber(databaseService.getNewLineNumberLot(documentIdd));
                    product.setQuantity(0);
                    product.setQuantityFact(1);
                    product.setId(UUID.randomUUID());
                }

                product.setSum(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact())));
                ProductInfo lot = onecService.getProductByIdd(product.getIdd());
                Set<Lot> lots = onecService.getLotItems(lot.getId());
                product.setProductsIntoLot(
                        convertLotsToOpenLots(
                                lots,
                                documentIdd,
                                barcodeBox,
                                product.getIdd(),
                                product.getLineNumber(),
                                document.getCreatedAt()
                        )
                );
                databaseService.updateProduct(product);
                document.getProducts().add(product);
                document.setFactQuantity(document.getFactQuantity() + 1);
                document = updateSumIntoDocument(document);
                databaseService.updateDocument(document);
                return MovingDocumentModelMapper.map(
                        document,
                        barcodeBox,
                        MovingDocumentModelType.LOT,
                        product.getIdd(),
                        product.getLineNumber()
                );
            }
        }

        return MovingDocumentModelMapper.map(
                document,
                barcodeBox,
                MovingDocumentModelType.PRODUCT
        );
    }

    public boolean existBox(String barcodeBox) {
        return onecService.existBox(barcodeBox);
    }

    @Transactional
    public MovingDocumentModel acceptanceProductIntoLot(
            String documentIdd,
            String barcodeBox,
            String lotIdd,
            String handleSearch,
            String scannedSearch,
            String lineNumberLot
    ) throws Exception {
        logger.info(
                "Accepting product into lot with document  idd:'{}',  barcode box:'{}', idd of lot:'{}' handleSearch:'{}', scannedSearch:'{}'.",
                documentIdd,
                barcodeBox,
                lotIdd,
                handleSearch,
                scannedSearch
        );
        Document document = databaseService.getLocalDocumentByDocumentIdd(documentIdd);

        List<OpenLot> openLotProducts = databaseService.getOpenLotsByLineNumberLot(lotIdd, Integer.parseInt(lineNumberLot));

        if (Strings.isNullOrEmpty(handleSearch) && Strings.isNullOrEmpty(scannedSearch)) {
            MovingDocumentModel movingDocumentModel = MovingDocumentModelMapper.map(
                    document,
                    barcodeBox,
//                  MovingDocumentModelType.SCANNED_MARK,
                    MovingDocumentModelType.LOT,
                    lotIdd,
                    Integer.valueOf(lineNumberLot)
            );

            movingDocumentModel.setProductModels(
                    openLotProducts
                            .parallelStream()
                            .map(ProductModelMapper::map)
                            .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                            .collect(Collectors.toList())
            );
            return movingDocumentModel;
        }

        String search = Strings.isNullOrEmpty(handleSearch) ? scannedSearch : handleSearch.trim();
        OpenLot openLot = databaseService.searchOpenLot(
                search.length() >= 31 ? BarcodeHelper.getBarcodeFromDatamatrix(search) : search,
                documentIdd,
                lotIdd,
                lineNumberLot
        );

//SEARCHING BY MARK IF NEED
//        if (Objects.isNull(openLot)) {
//            openLot = databaseService.getOpenLotByMark(
//                    BarcodeHelper.getMarkFromDatamatrix(search),
//                    iddLot
//            );
//        }

        if (Objects.isNull(openLot)) {
            ProductInfo productInfo = onecService.searchProduct(search.length() >= 31 ? BarcodeHelper.getBarcodeFromDatamatrix(search) : search);

            if (Objects.isNull(productInfo)) {
                logger.info("Accepting product into lot not found product.");
                throw new Exception("screen.warehouse.supply.lot.search.product.error.product_not_found");
            } else if (lotIdd.equals(productInfo.getIdd())) {
                MovingDocumentModel movingDocumentModel = MovingDocumentModelMapper.map(
                        document,
                        barcodeBox,
                        MovingDocumentModelType.LOT,
                        lotIdd
                );
                movingDocumentModel.setProductModels(
                        openLotProducts
                                .parallelStream()
                                .map(ProductModelMapper::map)
                                .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                                .collect(Collectors.toList())
                );

                if (productInfo.getProductKind().equals(ProductType.LOT.getValue())) {
                    logger.info("Can not open child lot into parent lot. Idd info: '{}'", lotIdd);
                    throw new Exception("warehouse.supply.search.goods.open.lot.error");
                }

                return movingDocumentModel;
            } else {
                openLot = OpenLotMapper.map(
                        productInfo,
                        lotIdd,
                        documentIdd,
                        barcodeBox,
                        onecService.getPrice(productInfo.getId(), Date.from(document.getCreatedAt())),
                        onecService.getVat(productInfo.getId(), Date.from(document.getCreatedAt())),
                        Integer.parseInt(lineNumberLot)
                );

                if (productInfo.getProductKind().equals(ProductType.LOT.getValue())) {
                    logger.info("Can not open child lot into parent lot. Idd info: '{}'", lotIdd);
                    throw new Exception("warehouse.supply.search.goods.open.lot.error");
                }

                databaseService.updateLot(openLot);
                openLotProducts.add(openLot);
                logger.info("Accepting product into lot found in 1C product info.");
            }
        } else {
            logger.info("Accepting product into lot found in local db product.");
        }

        if (!Strings.isNullOrEmpty(openLot.getMarkTypeCode().trim())) {
            if (search.length() < 31) {
                MovingDocumentModel movingDocumentModel = MovingDocumentModelMapper.map(
                        document,
                        barcodeBox,
                        MovingDocumentModelType.SCANNED_MARK,
                        lotIdd
                );
                movingDocumentModel.setProductModels(
                        openLotProducts
                                .parallelStream()
                                .map(ProductModelMapper::map)
                                .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                                .collect(Collectors.toList())
                );
                return movingDocumentModel;
            } else if (!BarcodeHelper.getBarcodeFromDatamatrix(search).equals(openLot.getBarcode())) {
                throw new Exception("warehouse.supply.recalculation.box.screen.error.message.mark_does_not_apply_to_the_product");
            } else if (databaseService.isExistScannedMark(BarcodeHelper.getMarkFromDatamatrix(search))) {
                throw new Exception("warehouse.supply.recalculation.box.screen.error.message.mark_is_exist");
            } else {
                ScannedMark scannedMark = new ScannedMark();
                scannedMark.setScannedMark(BarcodeHelper.getMarkFromDatamatrix(search));
                scannedMark.setOpenLotId(openLot.getId());
                scannedMark.setDataMatrix(BarcodeHelper.clearDatamatrix(search));
                scannedMark.setBarcodeBox(openLot.getBarcodeBox());
                String message = marksServiceResiving.validate(
                        BarcodeHelper.clearDatamatrix(search),
                        onecService.getStoreIdd(),
                        onecService.getFirmByWarehouse(document.getWarehouse()).getIdd()
                );

                if (message.equals("OK")) {
                    openLot.setFactQuantity(openLot.getFactQuantity() + 1);
                    openLot.getScannedMarks().add(scannedMark);
                    databaseService.updateLot(openLot);
                    scannedMark.setValidMark(true);
                    scannedMark.setNumber(openLot.getFactQuantity());
                    databaseService.updateScannedMark(scannedMark);
                } else {
                    scannedMark.setValidMark(false);
                    scannedMark.setNumber(openLot.getFactQuantity());
                    scannedMark.setErrorMessage(message);
                    databaseService.updateScannedMark(scannedMark);
                    throw new Exception(message);
                }
            }
        } else {
            openLot.setFactQuantity(openLot.getFactQuantity() + 1);
            databaseService.updateLot(openLot);
        }

        MovingDocumentModel movingDocumentModel = MovingDocumentModelMapper.map(
                document,
                barcodeBox,
                MovingDocumentModelType.LOT,
                lotIdd,
                Integer.valueOf(lineNumberLot)
        );
        movingDocumentModel.setProductModels(
                openLotProducts
                        .parallelStream()
                        .map(ProductModelMapper::map)
                        .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                        .collect(Collectors.toList())
        );
        return movingDocumentModel;
    }

    @Transactional
    public ConfirmDiscrepancyModel confirmDiscrepancy(String idd) throws Exception {
        logger.info("Confirming discrepancy with document idd:'{}'.", idd);
        ConfirmDiscrepancyModel confirmDiscrepancyModel = new ConfirmDiscrepancyModel();
        MovingDocument movingDocument = onecService.getMovingDocument(idd);
        logger.info("Confirming discrepancy found document into 1C.");

        if (Objects.nonNull(movingDocument.getAcceptanceDocument())) {
            logger.error("Confirming discrepancy already has acceptance document.");
            throw new Exception("screen.warehouse.supply.confirm.discrepancy.message.exist_acceptance_document");
        }

        Document document = databaseService.getLocalDocumentByDocumentIdd(idd);

        if (Objects.isNull(document)) {
            logger.error("Confirming discrepancy did not have document into local DB.");
            throw new Exception("screen.warehouse.supply.confirm.discrepancy.message.local_document_not_found");
        } else {
            logger.info("Confirming discrepancy found document into local DB.");
        }

        List<OpenLot> openLots = databaseService.getOpenLotsByDocument(idd);
        confirmDiscrepancyModel.setBoxFact(
                document.getProducts()
                        .parallelStream()
                        .filter(x -> x.getQuantityFact() > 0)
                        .collect(Collectors.groupingByConcurrent(Product::getBarcodeBox))
                        .size()
        );
        confirmDiscrepancyModel.setProductFact(
                document.getProducts()
                        .parallelStream()
                        .filter(x -> x.getQuantityFact() > 0)
                        .mapToInt(Product::getQuantityFact)
                        .sum()
        );
        confirmDiscrepancyModel.setLotFact(
                document.getProducts()
                        .parallelStream()
                        .filter(x -> ProductType.LOT.getValue().equals(x.getKindOfProduct()) && x.getQuantityFact() > 0)
                        .mapToInt(Product::getQuantityFact)
                        .sum()
        );
        confirmDiscrepancyModel.setLotProductFact(
                openLots
                        .parallelStream()
                        .filter(x -> x.getFactQuantity() > 0)
                        .mapToInt(OpenLot::getFactQuantity)
                        .sum()
        );
        confirmDiscrepancyModel.setBoxPlan(
                movingDocument.getItems()
                        .parallelStream()
                        .collect(Collectors.groupingByConcurrent(MovingDocumentItem::getBarcodeBox))
                        .size()
        );
        confirmDiscrepancyModel.setBoxDifference(
                confirmDiscrepancyModel.getBoxPlan() - confirmDiscrepancyModel.getBoxFact()
        );
        confirmDiscrepancyModel.setProductPlan(
                movingDocument.getItems()
                        .parallelStream()
                        .mapToInt(x -> x.getQuantity().intValue())
                        .sum()
        );
        confirmDiscrepancyModel.setProductDifference(
                confirmDiscrepancyModel.getProductPlan() - confirmDiscrepancyModel.getProductFact()
        );
        confirmDiscrepancyModel.setLotPlan(
                movingDocument.getItems()
                        .parallelStream()
                        .filter(x -> ProductType.LOT.getValue().equals(x.getProduct().getProductKind()))
                        .mapToInt(x -> x.getQuantity().intValue())
                        .sum()
        );

        confirmDiscrepancyModel.setLotDifference(
                confirmDiscrepancyModel.getLotPlan() - confirmDiscrepancyModel.getLotFact()
        );
        List<String> lotsIdList = movingDocument.getItems()
                .parallelStream()
                .filter(x -> ProductType.LOT.getValue().equals(x.getProduct().getProductKind()))
                .map(x -> x.getProduct().getId())
                .collect(Collectors.toList());
        int quantity = 0;

        for (String lotId : lotsIdList) {
            Integer quantityPlan = onecService.getLotItems(lotId)
                    .parallelStream()
                    .mapToInt(Lot::getQuantity)
                    .sum();
            Integer currentLotQuantity = Objects.requireNonNull(movingDocument.getItems().parallelStream()
                    .filter(e -> e.getItem().equals(lotId))
                    .findFirst()
                    .orElse(null)).getQuantity().intValue();
            quantity += currentLotQuantity * quantityPlan;
        }

        confirmDiscrepancyModel.setLotProductPlan(quantity);

        confirmDiscrepancyModel.setLotProductDifference(
                confirmDiscrepancyModel.getLotProductPlan() - confirmDiscrepancyModel.getLotProductFact()
        );
        confirmDiscrepancyModel.setWarehouse(onecService.getWarehouseName(movingDocument.getWarehouse()));
        confirmDiscrepancyModel.setDocumentDate(movingDocument.getDateCreated());
        confirmDiscrepancyModel.setDocumentNumber(movingDocument.getJournal().getDocno());
        return confirmDiscrepancyModel;
    }

    @Transactional
    public List<String> confirmAcceptanceDelivery(String idd, String acceptBy, String createdBy, String comment) throws Exception {
        if (Strings.isNullOrEmpty(acceptBy)) {
            throw new Exception("screen.warehouse.supply.confirm.discrepancy.message.accept_by_is_empty");
        }

        if (Strings.isNullOrEmpty(createdBy)) {
            throw new Exception("screen.warehouse.supply.confirm.discrepancy.message.create_by_is_empty");
        }


        logger.info("Start accepting delivery with idd:'{}', acceptBy:'{}', createdBy:'{}', comment:'{}'.", idd, acceptBy, createdBy, comment);
        List<String> iddocs = new ArrayList<>();
        Document document = databaseService.getLocalDocumentByDocumentIdd(idd);
        MovingDocument movingDocument = onecService.getMovingDocument(idd);
        document.setAcceptedBy(acceptBy);
        document.setCreatedBy(createdBy);
        document.setDocumentComment(comment);
        validateMarksOfDocument(document);
        List<OpenLot> openLots = databaseService.getOpenLotsByDocument(document.getIdd());
        AcceptanceDocument acceptanceDocument = addAcceptanceDocument(document, movingDocument);
        writeStockBalance(acceptanceDocument, document, openLots);
        iddocs.add(acceptanceDocument.getJournal().getIdoc());
        Journal journal = addMismatchDocument(acceptanceDocument, document, movingDocument, acceptBy);

        if (Objects.nonNull(journal)) {
            iddocs.add(journal.getIdoc());
        }

        journal = addPackageErrorContentsDocument(acceptanceDocument.getJournal().getIdd(), document, movingDocument, openLots, acceptBy);

        if (Objects.nonNull(journal)) {
            iddocs.add(journal.getIdoc());
        }

        List<UUID> scannedMarks = document.getProducts()
                .parallelStream()
                .flatMap(x ->
                        x.getScannedMarks()
                                .parallelStream()
                                .map(ScannedMark::getId)
                )
                .collect(Collectors.toList());
        scannedMarks.addAll(
                openLots
                        .parallelStream()
                        .flatMap(x ->
                                x.getScannedMarks()
                                        .parallelStream()
                                        .map(ScannedMark::getId)
                        )
                        .collect(Collectors.toList())
        );

        databaseService.deleteScannedMark(
                scannedMarks
        );
        databaseService.deleteProducts(
                document.getProducts()
                        .parallelStream()
                        .map(Product::getId)
                        .collect(Collectors.toList())
        );
        databaseService.deleteDocument(document.getId());
        logger.info("Finish accepting delivery.");
        return iddocs;
    }

    public AcceptanceDocument addAcceptanceDocument(
            Document document,
            MovingDocument movingDocument
    ) throws Exception {
        String newIdd = iddGeneratingService.getNewIdd();

        if (Strings.isNullOrEmpty(newIdd)) {
            throw new Exception("New IDD is null or empty.");
        }

        List<Product> products = new ArrayList<>();

        for (MovingDocumentItem item :
                movingDocument.getItems()
                        .parallelStream()
                        .filter(x -> !(ProductType.LOT.getValue().equals(x.getProduct().getProductKind()) && !Strings.isNullOrEmpty(x.getProduct().getMarkTypeCode()) && !x.getProduct().getMarkTypeCode().startsWith("0000")))
                        .collect(Collectors.toList())
        ) {
            List<Product> product = document.getProducts()
                    .parallelStream()
                    .filter(x -> x.getIdd().equals(item.getProduct().getIdd()) && x.getBarcodeBox().trim().equals(item.getBarcodeBox().trim()) && x.getQuantityFact() > 0)
                    .collect(Collectors.toList());

            if (product.size() == 1) {                                      ////////////Simple product
                products.add(product.get(0));
            } else if (product.size() > 1) {                                    ////////////One product is many rows in one box
                products.add(uniteProduct(product));
            }
        }

        for (Product product :
                document.getProducts()
                        .parallelStream()
                        .filter(x -> !(ProductType.LOT.getValue().equals(x.getKindOfProduct()) &&
                                !Strings.isNullOrEmpty(x.getMarkTypeCode()) && !x.getMarkTypeCode().startsWith("0000")) && x.getQuantityFact() > 0)
                        .collect(Collectors.toList())
        ) {
            if (movingDocument.getItems().parallelStream().noneMatch(x -> x.getProduct().getIdd().equals(product.getIdd()) && x.getBarcodeBox().trim().equals(product.getBarcodeBox().trim()))) {
                products.add(product);
            }
        }

        Journal acceptanceDocumentJournal = JournalMapper.map(
                newIdd,
                onecService.getWarehouse(document.getWarehouse()).getBranch(),
                1
        );
        acceptanceDocumentJournal = onecService.setReferencesJournal(acceptanceDocumentJournal, "ПриемныйАкт");
        journalsMarksOnDelete.add(acceptanceDocumentJournal.getIdoc());
        AcceptanceDocument acceptanceDocument = AcceptanceDocumentMapper.map(
                document,
                acceptanceDocumentJournal.getIdoc()
        );
        acceptanceDocumentJournal.setActcnt(products.size());
        acceptanceDocument.setJournal(acceptanceDocumentJournal);
        acceptanceDocument.setMovingDocument(movingDocument);
        acceptanceDocumentJournal.setAcceptanceDocument(acceptanceDocument);
        String guidIdd = updateStatusMarks(document, acceptanceDocument);

        if (Strings.isNullOrEmpty(guidIdd)) {
            acceptanceDocumentJournal.setPmm(8);
        } else {
            movingDocument.setGuid(guidIdd);
            acceptanceDocumentJournal.setPmm(7);
        }

        onecService.updateMovingDocument(movingDocument);
        onecService.updateAcceptanceDocument(acceptanceDocument);
        acceptanceDocument.setItems(AcceptanceDocumentItemMapper.map(products, acceptanceDocument.getIddoc()));
        onecService.updateAcceptanceDocumentItems(acceptanceDocument.getItems());
        onecService.addOnecSrcDoc(acceptanceDocumentJournal, document.getIdocdef(), document.getIddoc());
        logger.info(
                "Service added AcceptanceDocument with idd:'{}', iddoc:'{}' and document number:'{}'.",
                acceptanceDocument.getJournal().getIdd(),
                acceptanceDocument.getIddoc(),
                acceptanceDocument.getJournal().getDocno()
        );
        return acceptanceDocument;
    }

    public Journal addMismatchDocument(
            AcceptanceDocument acceptanceDocument,
            Document document,
            MovingDocument movingDocument,
            String acceptBy
    ) {
        List<MismatchDocumentItem> items = new ArrayList<>();
        Integer lineNumber = 1;

        for (MovingDocumentItem item : movingDocument.getItems()) {
            Product product = document.getProducts()
                    .parallelStream()
                    .filter(x -> x.getIdd().trim().equals(item.getProduct().getIdd().trim()) && x.getBarcodeBox().trim().equals(item.getBarcodeBox().trim()))
                    .findFirst()
                    .orElse(null);

            if (Objects.isNull(product)) {
                BigDecimal vat = onecService.getVat(item.getProduct().getId(), Date.from(document.getCreatedAt()));
                MismatchDocumentItem mismatchDocumentItem = MismatchDocumentItemMapper.map(
                        ProductMapper.map(item),
                        acceptBy,
                        lineNumber
                );
                mismatchDocumentItem.setDifferenceCount(item.getQuantity().negate());
                mismatchDocumentItem.setDifferenceSum(item.getSum().negate());
                mismatchDocumentItem.setVatSum(
                        mismatchDocumentItem.getDifferenceSum()
                                .multiply(vat)
                                .divide(new BigDecimal(100), 2, RoundingMode.CEILING)
                                .negate()
                );
                items.add(mismatchDocumentItem);
                lineNumber++;
            } else if (product.getQuantityFact() != item.getQuantity().intValue()) {
                MismatchDocumentItem mismatchDocumentItem = MismatchDocumentItemMapper.map(
                        product,
                        acceptBy,
                        lineNumber
                );
                mismatchDocumentItem.setDifferenceCount(item.getQuantity().subtract(BigDecimal.valueOf(product.getQuantityFact())).negate());
                mismatchDocumentItem.setDifferenceSum(item.getPrice().multiply(mismatchDocumentItem.getDifferenceCount()));
                mismatchDocumentItem.setVatSum(
                        mismatchDocumentItem.getDifferenceSum()
                                .multiply(product.getVat())
                                .divide(new BigDecimal(100), 2, RoundingMode.CEILING)
                );
                items.add(mismatchDocumentItem);
                lineNumber++;
            }
        }

        for (Product product : document
                .getProducts()
                .parallelStream()
                .filter(x -> x.getQuantityFact() > 0)
                .collect(Collectors.toList())) {
            if (movingDocument.getItems().parallelStream().noneMatch(x -> x.getProduct().getIdd().trim().equals(product.getIdd().trim()))) {
                MismatchDocumentItem mismatchDocumentItem = MismatchDocumentItemMapper.map(
                        product,
                        acceptBy,
                        lineNumber
                );
                mismatchDocumentItem.setDifferenceCount(BigDecimal.valueOf(product.getQuantityFact()));
                mismatchDocumentItem.setDifferenceSum(product.getPrice().multiply(mismatchDocumentItem.getDifferenceCount()));
                mismatchDocumentItem.setVatSum(
                        mismatchDocumentItem.getDifferenceSum()
                                .multiply(product.getVat())
                                .divide(new BigDecimal(100), 2, RoundingMode.CEILING)
                );
                items.add(mismatchDocumentItem);
                lineNumber++;
            }
        }

        if (items.size() > 0) {
            Journal mismatchDocumentJournal = JournalMapper.map(
                    iddGeneratingService.getNewIdd(),
                    onecService.getWarehouse(document.getWarehouse()).getBranch()
            );
            mismatchDocumentJournal = onecService.setReferencesJournal(mismatchDocumentJournal, "АктНесоответствия");
            journalsMarksOnDelete.add(mismatchDocumentJournal.getIdoc());
            MismatchDocument mismatchDocument = MismatchDocumentMapper.map(
                    document,
                    mismatchDocumentJournal.getIdoc(),
                    acceptanceDocument
            );
            mismatchDocument.setDifferenceSum(
                    BigDecimal.valueOf(
                            items
                                    .parallelStream()
                                    .mapToInt(x -> x.getDifferenceSum().intValue())
                                    .sum()
                    )
            );
            mismatchDocument.setItems(items);

            for (MismatchDocumentItem item : items) {
                item.getIddocLinenumberIdentity().setIdDoc(mismatchDocument.getIddoc());
            }

            mismatchDocumentJournal.setActcnt(items.size());
            mismatchDocument.setJournal(mismatchDocumentJournal);
            mismatchDocumentJournal.setMismatchDocument(mismatchDocument);
            onecService.updateMismatchDocumentItems(items);
            onecService.updateMismatchDocument(mismatchDocument);
            onecService.addOnecSrcDoc(
                    mismatchDocumentJournal,
                    acceptanceDocument.getJournal().getIdocdef(),
                    acceptanceDocument.getIddoc()
            );
            logger.info(
                    "Service added MismatchDocument with idd:'{}', iddoc:'{}' and document number:'{}'.",
                    mismatchDocument.getJournal().getIdd(),
                    mismatchDocument.getIddoc(),
                    mismatchDocument.getJournal().getDocno()
            );
            return mismatchDocument.getJournal();
        } else {
            return null;
        }
    }

    public Journal addPackageErrorContentsDocument(
            String acceptanceDocumentIdd,
            Document document,
            MovingDocument movingDocument,
            List<OpenLot> openLots,
            String discoverer
    ) throws Exception {
        boolean createPackageErrorContentsDocument = false;
        ConcurrentMap<String, List<Lot>> lots = onecService.getLotItems(
                        movingDocument.getItems()
                                .parallelStream()
                                .filter(x -> ProductType.LOT.getValue().equals(x.getProduct().getProductKind()) && (Strings.isNullOrEmpty(x.getProduct().getMarkTypeCode()) || x.getProduct().getMarkTypeCode().startsWith("0000")))
                                .map(x -> x.getProduct().getId())
                                .collect(Collectors.toList())
                )
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(x -> x.getParentProduct().getIdd()));

        for (Map.Entry<String, List<Lot>> lot : lots.entrySet()) {
            long productQuantityFact = openLots
                    .parallelStream()
                    .filter(x -> x.getLotIdd().equals(lot.getKey()))
                    .mapToLong(OpenLot::getFactQuantity)
                    .sum();
            long productQuantity = lot.getValue()
                    .parallelStream()
                    .mapToLong(Lot::getQuantity)
                    .sum();

            if (productQuantityFact != productQuantity) {
                createPackageErrorContentsDocument = true;
            }
        }

        if (createPackageErrorContentsDocument) {
            Journal packageErrorContentsDocumentJournal = JournalMapper.map(
                    iddGeneratingService.getNewIdd(),
                    document.getFirmRecipient(),
                    1
            );
            packageErrorContentsDocumentJournal = onecService.setReferencesJournal(
                    packageErrorContentsDocumentJournal,
                    "ОшибкиКомплектации"
            );
            journalsMarksOnDelete.add(packageErrorContentsDocumentJournal.getIdoc());
            PackageErrorContentsDocument packageErrorContentsDocument = PackageErrorContentsDocumentMapper.map(
                    document,
                    packageErrorContentsDocumentJournal.getIdoc(),
                    acceptanceDocumentIdd,
                    onecService.getEmployee(discoverer).getName(),
                    onecService.getCurrency()
            );
            packageErrorContentsDocument.setJournal(packageErrorContentsDocumentJournal);
            packageErrorContentsDocumentJournal.setPackageErrorContentsDocument(packageErrorContentsDocument);
            List<PackageErrorContentsDocumentItem> items = new ArrayList<>();
            Integer lineNumber = 1;

            for (Map.Entry<String, List<Lot>> lot : lots.entrySet()) {
                long productQuantityFact = openLots
                        .parallelStream()
                        .filter(x -> x.getLotIdd().equals(lot.getKey()))
                        .mapToLong(OpenLot::getFactQuantity)
                        .sum();
                long productQuantity = lot.getValue()
                        .parallelStream()
                        .mapToLong(Lot::getQuantity)
                        .sum();

                if (productQuantityFact != productQuantity) {
                    for (Lot productLot : lot.getValue()) {
                        OpenLot openLot = openLots
                                .parallelStream()
                                .filter(x -> x.getLotIdd().equals(lot.getKey()) && x.getProductIdd().equals(productLot.getIdd()))
                                .findFirst()
                                .orElse(null);

                        if (Objects.nonNull(openLot) && productLot.getQuantity().intValue() != openLot.getFactQuantity().intValue()) {
                            items.add(
                                    PackageErrorContentsDocumentItemMapper.map(
                                            openLot,
                                            lineNumber,
                                            packageErrorContentsDocument.getIddoc(),
                                            onecService.getVat(
                                                    openLot.getProductIdd(),
                                                    Date.from(document.getCreatedAt())
                                            )
                                    )
                            );
                            lineNumber++;
                        }
                    }

                    for (OpenLot productOpenLot : openLots
                            .parallelStream()
                            .filter(x -> x.getLotIdd().equals(lot.getKey()))
                            .collect(Collectors.toList())
                    ) {
                        Lot productLot = lot.getValue()
                                .parallelStream()
                                .filter(x -> x.getIdd().equals(productOpenLot.getProductIdd()))
                                .findFirst()
                                .orElse(null);

                        if (Objects.isNull(productLot)) {
                            items.add(
                                    PackageErrorContentsDocumentItemMapper.map(
                                            productOpenLot,
                                            lineNumber,
                                            packageErrorContentsDocument.getIddoc(),
                                            onecService.getVat(
                                                    productOpenLot.getProductIdd(),
                                                    Date.from(document.getCreatedAt())
                                            )
                                    )
                            );
                            lineNumber++;
                        }
                    }
                }
            }

            if (items.size() > 0) {
                packageErrorContentsDocument.setItems(items);
                packageErrorContentsDocument.getJournal().setActcnt(items.size());
                onecService.updatePackageErrorContentsDocumentItems(items);
                onecService.updatePackageErrorContentsDocument(packageErrorContentsDocument);
                onecService.addOnecSrcDoc(packageErrorContentsDocumentJournal, document.getIdocdef(), document.getIddoc());
                onecService.movePeriod(packageErrorContentsDocument.getJournal());
                logger.info(
                        "Service added PackageErrorContentsDocument with idd:'{}', iddoc:'{}' and document number:'{}'.",
                        packageErrorContentsDocument.getJournal().getIdd(),
                        packageErrorContentsDocument.getIddoc(),
                        packageErrorContentsDocument.getJournal().getDocno()
                );
                return packageErrorContentsDocument.getJournal();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void writeStockBalance(AcceptanceDocument acceptanceDocument, Document document, List<OpenLot> openLots) {
        List<StockBalanceTMC> stockBalanceTMCs = new ArrayList<>();
        List<StockBalanceTMCItem> stockBalanceTMCItems = new ArrayList<>();
        int actionNumber = 1;

        for (Product product : document.getProducts()
                .parallelStream()
                .filter(x -> x.getQuantityFact() > 0 && !ProductType.LOT.getValue().equals(x.getKindOfProduct()))
                .collect(Collectors.toList())
        ) {
            stockBalanceTMCs.add(
                    StockBalanceTMCMapper.map(
                            document.getFirmRecipient(),
                            document.getWarehouse(),
                            BigDecimal.valueOf(product.getQuantityFact()),
                            product.getOriginalId(),
                            acceptanceDocument.getDateCreated()
                    )
            );
            stockBalanceTMCItems.add(
                    StockBalanceTMCItemMapper.map(
                            0,
                            actionNumber,
                            acceptanceDocument.getIddoc(),
                            document.getWarehouseReceiver(),
                            document.getFirmRecipient(),
                            product.getOriginalId(),
                            BigDecimal.valueOf(product.getQuantityFact()),
                            product.getPrice().multiply(BigDecimal.valueOf(product.getQuantityFact())),
                            "01",
                            0
                    )
            );
            actionNumber++;
        }

        for (OpenLot openLot : openLots
                .parallelStream()
                .collect(Collectors.toList())
        ) {
            stockBalanceTMCs.add(
                    StockBalanceTMCMapper.map(
                            document.getFirmRecipient(),
                            document.getWarehouse(),
                            BigDecimal.valueOf(openLot.getFactQuantity()),
                            openLot.getOriginalId(),
                            acceptanceDocument.getDateCreated()
                    )
            );
            stockBalanceTMCItems.add(
                    StockBalanceTMCItemMapper.map(
                            0,
                            actionNumber,
                            acceptanceDocument.getIddoc(),
                            document.getWarehouseReceiver(),
                            document.getFirmRecipient(),
                            openLot.getOriginalId(),
                            BigDecimal.valueOf(openLot.getQuantity()),
                            openLot.getPrice().multiply(BigDecimal.valueOf(openLot.getQuantity())),
                            "01",
                            0
                    )
            );
            actionNumber++;
        }

        acceptanceDocument.getJournal().setActcnt(stockBalanceTMCItems.size());
        onecService.updateStockBalanceTMC(stockBalanceTMCs);
        onecService.writeStockBalanceTMCItems(stockBalanceTMCItems, acceptanceDocument.getDateCreated());
    }

    public void movePeriods(List<String> iddocs) throws Exception {
        for (String iddoc : iddocs) {
            movePeriod(iddoc);
        }
    }

    @Transactional
    public void movePeriod(String iddoc) throws Exception {
        Journal journal = onecService.getJournalByIddoc(iddoc);

        if (Objects.nonNull(journal)) {
            journal.setClosed(1);
            onecService.updateJournal(journal);
            onecService.movePeriod(journal);
            logger.info("Move Period moved period for IDDOC: '{}'", iddoc);
        }
    }

    @Transactional
    public void clearFactAllProductsOrLots(String barcodeBox, String lotId, String linNumberLot) {
        if (Strings.isNullOrEmpty(lotId)) {
            List<Product> deleteProducts = databaseService.getProductsForDeleting(barcodeBox);
            databaseService.deleteBoxProducts(
                    deleteProducts
                            .parallelStream()
                            .map(Product::getId)
                            .collect(Collectors.toList())
            );
            List<Product> updateProducts = databaseService.getProductsForUpdating(barcodeBox);
            List<UUID> deletedOpenLotIds = new ArrayList<>();

            for (Product product : updateProducts) {
                product.setQuantityFact(0);
                deletedOpenLotIds.addAll(
                        product.getProductsIntoLot()
                                .parallelStream()
                                .map(OpenLot::getId)
                                .collect(Collectors.toList())
                );
                product.getProductsIntoLot().clear();
                product.getScannedMarks().clear();
            }

            databaseService.updateProducts(updateProducts);
            databaseService.deleteOpenLotsByIds(deletedOpenLotIds);
            databaseService.deleteAllMarksByBarcodeBox(barcodeBox);
        } else {
            Document document = databaseService.getLocalDocumentByBarcodeBox(barcodeBox);
            List<OpenLot> deleteOpenLots = databaseService.getOpenLotsForDeleting(document.getIdd(), lotId, Integer.valueOf(linNumberLot));
            databaseService.deleteOpenLots(deleteOpenLots
                    .parallelStream()
                    .map(OpenLot::getId)
                    .collect(Collectors.toList()));
            List<OpenLot> updateOpenLots = databaseService.getOpenLotsForUpdating(document.getIdd(), lotId, Integer.valueOf(linNumberLot));

            for (OpenLot openLot : updateOpenLots) {
                openLot.setFactQuantity(0);
            }
            databaseService.updateOpenLots(updateOpenLots);
            List<UUID> productId = databaseService.getOpenLots(document.getIdd(), lotId)
                    .parallelStream()
                    .map(OpenLot::getId)
                    .collect(Collectors.toList());
            databaseService.deleteAllMarksByLotIddIntoLot(productId);
        }
    }

    public MovingDocumentModel clearFactAllProductsOrLotsByBox(String barcodeBox, String lotId, String lineNumberLot) {
        MovingDocumentModel movingDocumentModel = null;

        clearFactAllProductsOrLots(barcodeBox, lotId, lineNumberLot);

        List<Product> products = databaseService.getProductsByBarcodeBox(barcodeBox);

        if (Strings.isNullOrEmpty(lotId)) {
            Product product = databaseService.getProductById(products.get(0).getId());
            Document document = databaseService.getLocalDocumentByDocumentIdd(product.getDocumentIdd());
            document.setFactQuantity(0L);
            document = updateSumIntoDocument(document);
            databaseService.updateDocument(document);
            movingDocumentModel = MovingDocumentModelMapper.map(
                    document,
                    barcodeBox,
                    MovingDocumentModelType.PRODUCT
            );
            movingDocumentModel.setProductModels(
                    products
                            .parallelStream()
                            .map(ProductModelMapper::map)
                            .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                            .collect(Collectors.toList())
            );

        } else {
            List<OpenLot> openLotProducts = databaseService.getOpenLotsByLineNumberLot(lotId, Integer.valueOf(lineNumberLot));
            Document document = databaseService.getLocalDocumentByDocumentIdd(openLotProducts.get(0).getDocumentIdd());
            movingDocumentModel = MovingDocumentModelMapper.map(
                    document,
                    openLotProducts.get(0).getBarcodeBox(),
                    MovingDocumentModelType.LOT,
                    lotId,
                    Integer.valueOf(lineNumberLot)
            );
            movingDocumentModel.setProductModels(
                    openLotProducts
                            .parallelStream()
                            .map(ProductModelMapper::map)
                            .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                            .collect(Collectors.toList())
            );
        }

        return movingDocumentModel;
    }

    public MovingDocumentModel updateProductOrLot(String lotId, String id, String quantityFact, String lineNumberLine) throws Exception {
        MovingDocumentModel movingDocumentModel = null;

        if (Strings.isNullOrEmpty(lotId)) {
            Product product = databaseService.getProductById(UUID.fromString(id));

            if (Objects.isNull(product)) {
                throw new Exception("warehouse.supply.find.product.error");
            }

            if (Strings.isNullOrEmpty(product.getMarkTypeCode().trim()) || product.getMarkTypeCode().startsWith("0000")) {
                updateProduct(product, Integer.parseInt(quantityFact));

                if (Integer.parseInt(quantityFact) == 0) {
                    databaseService.deleteOpenLotsByLineNumberLot(product.getDocumentIdd(), product.getIdd(), product.getLineNumber());
                }
                movingDocumentModel = MovingDocumentModelMapper.map(
                        product.getDocument(),
                        product.getBarcodeBox(),
                        MovingDocumentModelType.PRODUCT
                );
            } else {
                //Логика очистки позиции и удаления марки для маркированного товара \ лота
                if (Integer.parseInt(quantityFact) == 0) {
                    clearFactPositionProductAndDeleteMark(product);
                    movingDocumentModel = MovingDocumentModelMapper.map(
                            product.getDocument(),
                            product.getBarcodeBox(),
                            MovingDocumentModelType.PRODUCT
                    );
                } else {
                    throw new Exception("warehouse.supply.product.error_message_has_mark");
                }
            }
        } else {
            OpenLot openLot = databaseService.getOpenLotById(UUID.fromString(id));
            List<OpenLot> openLotProducts = databaseService.getOpenLotsByLineNumberLot(lotId, Integer.valueOf(lineNumberLine));

            if (Objects.isNull(openLot)) {
                throw new Exception("warehouse.supply.find.lot.error");
            }

            if (Strings.isNullOrEmpty(openLot.getMarkTypeCode().trim()) || openLot.getMarkTypeCode().startsWith("0000")) {
                updateLot(openLot, Integer.parseInt(quantityFact));
                Document document = databaseService.getLocalDocumentByDocumentIdd(openLot.getDocumentIdd());
                movingDocumentModel = MovingDocumentModelMapper.map(
                        document,
                        openLot.getBarcodeBox(),
                        MovingDocumentModelType.LOT,
                        openLot.getLotIdd(),
                        Integer.parseInt(lineNumberLine)

                );
                movingDocumentModel.setProductModels(
                        openLotProducts
                                .parallelStream()
                                .map(ProductModelMapper::map)
                                .sorted(Comparator.comparing(ProductModel::getName, Comparator.naturalOrder()))
                                .collect(Collectors.toList())
                );
            } else {
                throw new Exception("warehouse.supply.lot.error_message_has_mark");
            }
        }

        return movingDocumentModel;
    }

    @Transactional
    public void clearFactPositionProductAndDeleteMark(Product product) {
        updateProduct(product, 0);
        List<UUID> marksIdList = product.getScannedMarks()
                .parallelStream()
                .map(ScannedMark::getId)
                .collect(Collectors.toList());
        product.getScannedMarks().clear();
        product.setMarks(null);
        databaseService.deleteMarkById(marksIdList);
        databaseService.updateProduct(product);
        logger.info("Clear fact position product with mark finished");
    }

    public void updateProduct(Product product, Integer quantityFact) {
        logger.info("Updating product with id:{} set quantityFact:{}", product.getId(), quantityFact);
        List<Product> productsForDocument = databaseService.getProductsByDocumentIdd(product.getDocumentIdd());
        Document document = databaseService.getLocalDocumentByDocumentIdd(product.getDocumentIdd());
        long documentFactQuantity = quantityFact == 0 ? document.getFactQuantity() - product.getQuantityFact() : document.getFactQuantity() - (product.getQuantityFact() - quantityFact);
        document.setFactQuantity(documentFactQuantity);
        product.setQuantityFact(quantityFact);
        product.setSum(product.getPrice().multiply(BigDecimal.valueOf(quantityFact)));
        databaseService.updateProduct(product);
        document = updateSumIntoDocument(document);
        databaseService.updateDocument(document);
    }

    public void updateLot(OpenLot openLot, Integer quantityFact) {
        logger.info("Updating open lot with id:{}, lot Idd: '{}' set quantityFact:{}", openLot.getId(), openLot.getLotIdd(), quantityFact);
        openLot.setFactQuantity(quantityFact);
        databaseService.updateLot(openLot);
    }

    @Transactional
    public void deleteProduct(Product product) throws Exception {

        List<Product> productsForDocument = databaseService.getProductsByDocumentIdd(product.getDocumentIdd());

        if (Objects.isNull(product)) {
            throw new Exception("warehouse.supply.find.product.error");
        }
        Document document = databaseService.getLocalDocumentByDocumentIdd(product.getDocumentIdd());
        document.setFactQuantity(document.getFactQuantity() - product.getQuantityFact());

        if (product.getQuantity() == 0) {
            databaseService.deleteProduct(product.getId());
        }
        document = updateSumIntoDocument(document);
        databaseService.updateDocument(document);
    }

    public MovingDocumentModel deleteProductLotAndOpenLots(String id) throws Exception {

        Product product = databaseService.getProductById(UUID.fromString(id));
        var document = product.getDocument();
        var barCodeBox = product.getBarcodeBox();
        deleteProduct(product);

        return MovingDocumentModelMapper.map(
                document,
                barCodeBox,
                MovingDocumentModelType.PRODUCT
        );
    }

    @Transactional
    public void deleteLot(OpenLot openLot) throws Exception {

        if (Objects.isNull(openLot)) {
            throw new Exception("warehouse.supply.find.lot.error");
        }

        if (openLot.getQuantity() == 0) {
            databaseService.deleteLotById(openLot.getId());
        }
    }

    public void deleteMarkIntoOpenLot(OpenLot openLot) {
        List<UUID> scannedMarks = databaseService.findByOpenLotProductId(openLot.getId())
                .parallelStream()
                .map(ScannedMark::getId)
                .collect(Collectors.toList());

        // проверка наличия\удаление марки у OpenLot
        if (scannedMarks.size() > 0) {
            scannedMarks.parallelStream()
                    .forEach(m -> {
                        databaseService.deleteMarkById(scannedMarks);
                    });
        }
    }

    public void deleteAllMarksByBarcodeBox(String barcodeBox) {
        List<ScannedMark> marksList = databaseService.findAllMarks();

        if (marksList.size() > 0) {
            databaseService.deleteAllMarksByBarcodeBox(barcodeBox);
            logger.info("All Marks has success cleared");
        } else {
            logger.info("Mark list is empty");
        }
    }

    public MovingDocumentModel deleteOpenLot(String id) throws Exception {
        MovingDocumentModel movingDocumentModel = null;
        OpenLot openLot = databaseService.getOpenLotById(UUID.fromString(id));

        var documentIdd = openLot.getDocumentIdd();
        var barCodeBox = openLot.getBarcodeBox();
        var lotIdd = openLot.getLotIdd();
        var lineNumberLot = openLot.getLineNumberLot();

        deleteMarkIntoOpenLot(openLot);

        deleteLot(openLot);

        Document document = databaseService.getLocalDocumentByDocumentIdd(documentIdd);
        List<OpenLot> openLotProducts = databaseService.getOpenLotsByLineNumberLot(lotIdd, lineNumberLot);
        movingDocumentModel = MovingDocumentModelMapper.map(
                document,
                barCodeBox,
                MovingDocumentModelType.LOT,
                lotIdd
        );

        movingDocumentModel.setProductModels(
                openLotProducts
                        .parallelStream()
                        .map(ProductModelMapper::map)
                        .collect(Collectors.toList())
        );
        return movingDocumentModel;
    }


    public ProductModel getProduct(String id) {
        logger.info("Getting product with id:{}", id);
        return ProductModelMapper.map(
                databaseService.getProductById(UUID.fromString(id)));
    }

    public ProductModel getOpenLot(String id) {
        logger.info("Getting product from open lot with id:{}", id);
        return ProductModelMapper.map(databaseService.getOpenLotById(UUID.fromString(id)));
    }

    public List<EmployeeModel> getEmployees() {
        return onecService.getListEmployees()
                .parallelStream()
                .map(x -> {
                    EmployeeModel employeeModel = new EmployeeModel();
                    employeeModel.setId(x.getId());
                    employeeModel.setIdd(x.getIdd());
                    employeeModel.setFio(x.getName().trim());
                    employeeModel.setPosition(x.getPosition().getName().trim());
                    return employeeModel;
                })
                .collect(Collectors.toList());
    }

    private String updateStatusMarks(Document document, AcceptanceDocument acceptanceDocument) throws Exception {
        List<Product> markedProducts = document.getProducts()
                .parallelStream()
                .filter(x ->
                        Objects.nonNull(x.getScannedMarks()) &&
                                x.getScannedMarks().size() > 0 &&
                                x.getScannedMarks()
                                        .parallelStream()
                                        .anyMatch(ScannedMark::getValidMark)
                )
                .collect(Collectors.toList());

        String guidIdd = "";

        if (markedProducts.size() > 0) {
            Warehouse warehouse = onecService.getWarehouse(document.getWarehouse());
            Firm firm = onecService.getFirm(warehouse.getBranch());
            String marksString = markedProducts
                    .parallelStream()
                    .flatMap(x -> x.getScannedMarks()
                            .parallelStream()
                            .filter(ScannedMark::getValidMark)
                            .map(ScannedMark::getDataMatrix)
                    )
                    .collect(Collectors.joining(","));
            logger.info("Validation all marks before updating");
            String message = marksServiceResiving.validate(
                    marksString,
                    onecService.getStoreIdd(),
                    firm.getIdd()
            );

            if (!message.equals("OK")) {
                throw new Exception("Mark is not valid.");
            }

            logger.info("Updating status marks found {} products with marks", markedProducts.size());
            Warehouse warehouseRecipient = onecService.getWarehouse(document.getWarehouseReceiver());
            logger.info("Get warehouse with idd:'{}'", warehouseRecipient.getIdd());
            Firm firmRecipient = onecService.getFirm(document.getFirmRecipient());
            logger.info("Get firm recipient with idd:'{}'", firmRecipient.getIdd());
            logger.info(
                    "Updating status marks found: warehouse '{}', firm '{}', warehouse recipient '{}', firm recipient '{}'",
                    document.getWarehouse(),
                    warehouse.getBranch(),
                    document.getWarehouseReceiver(),
                    document.getFirmRecipient()
            );

            if (marksServiceResiving.isFromWarehouse(firm.getIdd()) && firmRecipient.getIdd().equals(markConstants.getRetailIdd())) {
                guidIdd = marksServiceResiving.addEdoPa(
                        "ДокОтгрИсх",
                        markConstants.getWarehousesTin(),
                        markConstants.getRetailRrc(),
                        markConstants.getRetailTin(),
                        markConstants.getRetailRrc(),
                        acceptanceDocument.getJournal().getIdd().trim(),
                        acceptanceDocument.getJournal().getDocno().trim(),
                        warehouseRecipient.getIdd().trim(),
                        markConstants.getRetailEdm(),
                        markConstants.getWarehousesEdm(),
                        "Документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)",
                        firm.getFullName1().replace("\"", "&quot;").trim(),
                        "ДОП",
                        document.getCreatedAt(),
                        acceptanceDocument.getJournal().getDocno().trim(),
                        markConstants.getRetailTin(),
                        markConstants.getWarehouseRrc(),
                        firm.getLegalAddress().replace("\"", "&quot;").trim(),
                        warehouse.getAddress().replace("\"", "&quot;").trim(),
                        markConstants.getWarehousesTin(),
                        firmRecipient.getFullName1().replace("\"", "&quot;").trim(),
                        warehouseRecipient.getAddress().replace("\"", "&quot;").trim(),
                        markConstants.getRetailRrc(),
                        firmRecipient.getLegalAddress().replace("\"", "&quot;").trim(),
                        "<ОснПер НомОсн=\"12-K/02\" ДатаОсн=\"01.02.2002\" НаимОсн=\"Договор купли-продажи\" />",
                        "<ДопСвФХЖ1 НаимОКВ=\"Российский рубль\" ОбстФормСЧФ=\"4\"/>",
                        markedProducts,
                        onecService.getTnveds(
                                markedProducts
                                        .parallelStream()
                                        .map(Product::getIdd)
                                        .collect(Collectors.toList())
                        )
                );

                if (Strings.isNullOrEmpty(guidIdd)) {
                    throw new Exception("MarksService addEdoPa return null");
                }
            } else if (marksServiceResiving.isFromWarehouse(firm.getIdd()) && firmRecipient.getIdd().equals(markConstants.getContinentIdd())) {
                guidIdd = marksServiceResiving.addEdoPa(
                        "ДокОтгрИсх",
                        markConstants.getWarehousesTin(),
                        markConstants.getContinentRrc(),
                        markConstants.getContinentTin(),
                        markConstants.getContinentRrc(),
                        acceptanceDocument.getJournal().getIdd().trim(),
                        acceptanceDocument.getJournal().getDocno().trim(),
                        warehouseRecipient.getIdd().trim(),
                        markConstants.getContinentEdm(),
                        markConstants.getWarehousesEdm(),
                        "Счет-фактура и документ об отгрузке товаров (выполнении работ), передаче имущественных прав (документ об оказании услуг)",
                        firm.getFullName1().replace("\"", "&quot;").trim(),
                        "СЧФДОП",
                        document.getCreatedAt(),
                        acceptanceDocument.getJournal().getDocno().trim(),
                        markConstants.getContinentTin(),
                        markConstants.getWarehouseRrc(),
                        firm.getLegalAddress().replace("\"", "&quot;").trim(),
                        warehouse.getAddress().replace("\"", "&quot;").trim(),
                        markConstants.getWarehousesTin(),
                        firmRecipient.getFullName1().replace("\"", "&quot;").trim(),
                        warehouseRecipient.getAddress().replace("\"", "&quot;").trim(),
                        markConstants.getContinentRrc(),
                        firmRecipient.getLegalAddress().replace("\"", "&quot;").trim(),
                        "<ОснПер НомОсн=\"GJ-CONT 2016-01\" ДатаОсн=\"16.01.2016\" НаимОсн=\"Договор купли-продажи\" />",
                        "",
                        markedProducts,
                        onecService.getTnveds(
                                markedProducts
                                        .parallelStream()
                                        .map(Product::getIdd)
                                        .collect(Collectors.toList())
                        )
                );

                if (Strings.isNullOrEmpty(guidIdd)) {
                    throw new Exception("MarksService addEdoPa return null");
                }
            } else {
                boolean success = marksServiceResiving.addMarkTransaction(
                        "NOACTION",
                        Instant.ofEpochMilli(acceptanceDocument.getDateCreated().getTime()),
                        acceptanceDocument.getJournal().getDocno(),
                        acceptanceDocument.getJournal().getIdd(),
                        markConstants.getRetailTin(),
                        markConstants.getRetailTin(),
                        warehouse.getIdd().trim(),
                        markedProducts
                                .parallelStream()
                                .flatMap(x -> x.getScannedMarks()
                                        .parallelStream()
                                        .filter(ScannedMark::getValidMark)
                                        .map(e -> {
                                            Mark mark = new Mark();
                                            mark.setPrice(x.getPrice());
                                            mark.setTax(
                                                    x.getPrice().subtract(
                                                            x.getPrice().divide(
                                                                    x.getVat().divide(new BigDecimal(100), RoundingMode.HALF_UP).add(BigDecimal.ONE),
                                                                    RoundingMode.HALF_UP
                                                            )
                                                    )
                                            );
                                            mark.setValue(e.getDataMatrix());
                                            return mark;
                                        }))
                                .collect(Collectors.toList())
                );

                if (!success) {
                    throw new Exception("MarksService addMarkTransaction return error");
                }
            }

            logger.info("Updating status marks finished.");

        } else {
            logger.info("Updating status marks not found products with mark.");
        }

        if (!Strings.isNullOrEmpty(guidIdd)) {
            return onecService.generateGuidWithDate(String.valueOf(UUID.randomUUID()));
        } else {
            return guidIdd;
        }
    }

    private void validateMarksOfDocument(Document document) throws Exception {
        List<Product> markedProducts = document
                .getProducts()
                .parallelStream()
                .filter(x ->
                        Objects.nonNull(x.getScannedMarks()) &&
                                x.getScannedMarks().size() > 0 &&
                                x.getScannedMarks().parallelStream().anyMatch(ScannedMark::getValidMark)
                )
                .collect(Collectors.toList());

        if (markedProducts.size() > 0) {
            logger.info("Validation all marks of document before updating.");
            String message = marksServiceResiving.validate(
                    markedProducts
                            .parallelStream()
                            .flatMap(x ->
                                    x.getScannedMarks()
                                            .parallelStream()
                                            .filter(ScannedMark::getValidMark)
                                            .map(ScannedMark::getDataMatrix)
                            )
                            .collect(Collectors.toList()),
                    onecService.getStoreIdd(),
                    onecService.getFirmByWarehouse(document.getWarehouse()).getIdd()
            );

            if (!message.equals("OK")) {
                logger.info("Validation all marks of document has not valid mark.");
                throw new Exception(message);
            } else {
                logger.info("Validation all marks of document, validated {} products.", markedProducts.size());
            }
        }
    }

    public Document updateSumIntoDocument(Document document) {
        Set<Product> productsFiltered = document.getProducts().parallelStream()
                .filter(x -> x.getQuantityFact() > 0).collect(Collectors.toSet());
        document.setSum(
                productsFiltered
                        .parallelStream()
                        .map(Product::getSum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        return document;
    }

    public List<Product> dividerProductLot(List<Product> products) throws CloneNotSupportedException {
        List<Product> updatedProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getKindOfProduct().equals(ProductType.LOT.getValue()) && product.getQuantity() > 1) {
                Integer quantityPlan = product.getQuantity();
                Product dividerProduct = null;
                product.setQuantity(1);

                for (int i = 1; i < quantityPlan; i++) {
                    dividerProduct = product.clone();
                    dividerProduct.setId(UUID.randomUUID());
                    dividerProduct.setLineNumber(product.getLineNumber() + 1);
                }

                updatedProducts.add(dividerProduct);
            }

            updatedProducts.add(product);
        }

        return updatedProducts;
    }

    private Product uniteProduct(List<Product> products) {
        Product firstProduct = products.get(0);
        firstProduct.setQuantity(
                products
                        .parallelStream()
                        .mapToInt(Product::getQuantity)
                        .sum()
        );
        firstProduct.setQuantityFact(
                products
                        .parallelStream()
                        .mapToInt(Product::getQuantityFact)
                        .sum()
        );
        firstProduct.setSum(
                products
                        .parallelStream()
                        .map(Product::getSum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        return firstProduct;
    }

    private List<OpenLot> convertLotsToOpenLots(
            Set<Lot> lots,
            String documentIdd,
            String barcodeBox,
            String productIdd,
            Integer productLineNumber,
            Instant documentCreatedAt
    ) {
        return lots
                .parallelStream()
                .map(x ->
                        OpenLotMapper.map(
                                x,
                                productIdd,
                                documentIdd,
                                barcodeBox,
                                onecService.getPrice(
                                        x.getProductInfo().getId(),
                                        Date.from(documentCreatedAt)
                                ),
                                onecService.getVat(
                                        x.getProductInfo().getId(),
                                        Date.from(documentCreatedAt)
                                ),
                                productLineNumber
                        )
                )
                .sorted(Comparator.comparing(OpenLot::getProductIdd))
                .collect(Collectors.toList());
    }

    public void markJournalsAsDelete() {
        logger.info("Marks on delete {} journals.", journalsMarksOnDelete.size());
        onecService.updateJournalsAsDelete(journalsMarksOnDelete);
        logger.info(
                "Have been marked on delete {} journals.",
                journalsMarksOnDelete
                        .parallelStream()
                        .map(x -> String.format("'%s'", x))
                        .collect(Collectors.joining(","))
        );
    }
}
