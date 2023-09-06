package ru.gloria_jeans.receiving.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.receiving.dao.model.Document;
import ru.gloria_jeans.receiving.dao.model.OpenLot;
import ru.gloria_jeans.receiving.dao.model.Product;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;
import ru.gloria_jeans.receiving.dao.repository.DocumentISRepository;
import ru.gloria_jeans.receiving.dao.repository.OpenLotISRepository;
import ru.gloria_jeans.receiving.dao.repository.ProductISRepository;
import ru.gloria_jeans.receiving.dao.repository.ScannedMarkRepository;
import ru.gloria_jeans.receiving.model.enums.DocumentType;

import java.util.*;

@Service
public class DatabaseService {
    private final DocumentISRepository documentISRepository;
    private final ProductISRepository productISRepository;
    private final OpenLotISRepository openLotISRepository;
    private final ScannedMarkRepository scannedMarkRepository;
    public Logger logger = LoggerFactory.getLogger("DataBaseService");

    @Autowired
    public DatabaseService(
            DocumentISRepository documentISRepository,
            ProductISRepository productISRepository,
            OpenLotISRepository openLotISRepository,
            ScannedMarkRepository scannedMarkRepository
    ) {
        this.documentISRepository = documentISRepository;
        this.productISRepository = productISRepository;
        this.openLotISRepository = openLotISRepository;
        this.scannedMarkRepository = scannedMarkRepository;
    }

    public Document getLocalDocumentByDocumentIdd(String idd) {
        return documentISRepository.findOneByDocumentTypeAndIdd(DocumentType.ACCEPTANCE, idd);
    }

    public Document getLocalDocumentByBarcodeBox(String barcodeBox) {
        return documentISRepository.findOneByDocumentTypeAndProducts_BarcodeBox(DocumentType.ACCEPTANCE, barcodeBox);
    }

    public Set<Document> getLocalDocumentsByDocumentIdds(List<String> idds) {
        return documentISRepository.findByDocumentTypeAndIddIn(DocumentType.ACCEPTANCE, idds);
    }

    public Document createLocalDocument(Document document) {
        Document documentFromDb = documentISRepository.findOneByDocumentTypeAndIdd(
                DocumentType.ACCEPTANCE,
                document.getIdd()
        );

        if (Objects.nonNull(documentFromDb)) {
            return documentFromDb;
        } else {
            document.setDocumentType(DocumentType.ACCEPTANCE);
            return documentISRepository.save(document);
        }
    }

    public Product getProductByBarcode(String barcode) {
        return productISRepository.findOneByBarcode(barcode);
    }

    public Product getProductByQrCode(String qrCode) {
        return productISRepository.findOneByPmmCode(qrCode);
    }

    public Product getProductByVendorCode(String vendorCode) {
        return productISRepository.findOneByVendorCode(vendorCode);
    }

    public List<Product> getProductsByBarcode(String barcode) {
        return productISRepository.findByBarcode(barcode);
    }

    public List<Product> getProductsByVendorCode(String vendorCode) {
        return productISRepository.findByVendorCode(vendorCode);
    }

    public List<Product> getProductsByIdd(String idd) {
        return productISRepository.findByIdd(idd);
    }

    public List<Product> getProductsByMark(String barcodeBox, String mark) {
        return productISRepository.findByBarcodeBoxAndMarksLike(barcodeBox, mark);
    }

    public List<Product> searchProducts(String barcodeBox, String search) {
        return productISRepository.findByBarcodeBoxAndIddOrBarcodeBoxAndBarcodeOrBarcodeBoxAndVendorCode(
                barcodeBox,
                search,
                barcodeBox,
                search,
                barcodeBox,
                search
        );
    }

    public List<Product> createProducts(List<Product> products) {
        List<Product> existProducts = new ArrayList<>();
        List<Product> newProducts = new ArrayList<>();

        for (Product product : products) {
            Product existProduct = productISRepository.findOneByIddAndDocumentIddAndBarcodeBoxAndLineNumber(
                    product.getIdd(),
                    product.getDocumentIdd(),
                    product.getBarcodeBox(),
                    product.getLineNumber()
            );

            if (Objects.nonNull(existProduct)) {
                existProducts.add(existProduct);
            } else {
                newProducts.add(product);
            }
        }

        productISRepository.saveAll(newProducts);
        existProducts.addAll(newProducts);
        return existProducts;
    }

    public void updateProduct(Product product) {
        productISRepository.save(product);
    }

    public void deleteProducts(List<UUID> ids) {
        productISRepository.deleteAllById(ids);
    }

    public void updateDocument(Document document) {
        documentISRepository.save(document);
    }

    public void deleteDocument(UUID id) {
        documentISRepository.deleteById(id);
    }

    public void updateOpenLots(List<OpenLot> openLotProducts) {
        openLotISRepository.saveAll(openLotProducts);
    }

    public OpenLot getOpenLot(String documentIdd, String productBarcode, String iddLot) {
        return openLotISRepository.findByDocumentIddAndBarcodeAndLotIdd(documentIdd,productBarcode, iddLot);
    }

    public List<OpenLot> getOpenLots(String documentIdd, String idd) {
        return openLotISRepository.findByDocumentIddAndLotIdd(documentIdd, idd);
    }

    public List<OpenLot> getOpenLotsByDocument(String documentIdd) {
        return openLotISRepository.findByDocumentIdd(documentIdd);
    }

    public OpenLot searchOpenLot(String search, String documentIdd, String lotIdd, String lineNumberLot) {
        return openLotISRepository.findByDocumentIddAndLotIddAndLineNumberLotAndProductIddOrBarcodeOrVendorCode(
                documentIdd,
                lotIdd,
                Integer.parseInt(lineNumberLot),
                search,
                search,
                search
        );
    }

    public void updateLot(OpenLot openLot) {
        openLotISRepository.save(openLot);
    }

    @Transactional
    public void deleteScannedMark(List<UUID> ids) {
        scannedMarkRepository.deleteAllById(ids);
    }
    
    public void updateScannedMark(ScannedMark scannedMark) {
        scannedMarkRepository.save(scannedMark);
    }

    public boolean isExistScannedMark(String scannedMark) {
        return scannedMarkRepository.countByScannedMarkAndIsValidMark(scannedMark, true) > 0;
    }

    public Product getProductById(UUID uuid){
        return productISRepository.findById(uuid).orElse(null);
    }

    @Transactional
    public void deleteLotById(UUID id) {
        logger.info("Deleting open lot with id:{}", id);
        openLotISRepository.deleteLotById(id);
    }

    public OpenLot getOpenLotById(UUID id) {
        return openLotISRepository.findById(id).orElse(null);
    }

    public List<OpenLot> getOpenLotsIn(List<String> lotIdd) {
        return openLotISRepository.findByLotIddIn(lotIdd);
    }
    public List<OpenLot> getOpenLotsByLineNumberLot(String lotIdd, Integer lineNumberLot) {
        return openLotISRepository.findByLotIddAndLineNumberLot(lotIdd, lineNumberLot);
    }
    public Integer getNewLineNumberLot(String documentIdd) {
        return productISRepository.findFirstByDocumentIddOrderByLineNumberDesc(documentIdd)
                .getLineNumber() + 1;
    }

    @Transactional
    public void deleteOpenLotsByLineNumberLot(String documentIdd, String lotIdd, Integer lineNumberLot) {
        logger.info("Deleting products in Lot:{}", lotIdd);
        openLotISRepository.deleteAllByLotIddAndLineNumberLot(documentIdd, lotIdd, lineNumberLot);
    }

    @Transactional
    public void deleteProduct(UUID id) {
        logger.info("Deleting product with id:{}", id);
        productISRepository.deleteById(id);
    }

    @Transactional
    public void deleteMarkById(List<UUID> marksIdList){
        scannedMarkRepository.deleteAllById(marksIdList);
    }

    public List<ScannedMark> findAllMarks() {
        return scannedMarkRepository.findAll();
    }
    @Transactional
    public void deleteAllMarksByBarcodeBox(String barcodeBox) {
        scannedMarkRepository.deleteAllByBarcodeBox(barcodeBox);
    }

    public List<Product> getProductsForUpdating(String barcodeBox) {
        return productISRepository.findByBarcodeBoxAndQuantityGreaterThan(barcodeBox, 0);
    }

    public List<Product> getProductsForDeleting(String barcodeBox) {
        return productISRepository.findByBarcodeBoxAndQuantityLessThan(barcodeBox, 1);
    }

    public List<ScannedMark> findByOpenLotProductId(UUID productId) {
        return scannedMarkRepository.findAllByProductId(productId);
    }

    public void updateProducts(List<Product> products) {
        productISRepository.saveAll(products);
    }

    @Transactional
    public void deleteBoxProducts(List<UUID> ids) {
        productISRepository.deleteAllById(ids);
    }

    public List<Product> getProductsByBarcodeBox(String barcodeBox) {
        return productISRepository.findByBarcodeBox(barcodeBox);
    }
    @Transactional
    public void deleteOpenLotsByIds(List<UUID> deletedOpenLotIds) {
        if (deletedOpenLotIds.size() > 0) {
            openLotISRepository.deleteAllById(deletedOpenLotIds);
        }
    }

    public List<OpenLot> getOpenLotsForDeleting(String documentIdd, String lotIdd, Integer lineNumberLot) {
        return openLotISRepository.findByDocumentIddAndLotIddAndLineNumberLotAndQuantityLessThan(documentIdd, lotIdd, lineNumberLot, 1);
    }
    @Transactional
    public void deleteOpenLots(List<UUID> ids) {
        openLotISRepository.deleteAllById(ids);
    }

    public List<OpenLot> getOpenLotsForUpdating(String documentIdd, String lotIdd, Integer lineNumberLot) {
        return openLotISRepository.findByDocumentIddAndLotIddAndLineNumberLotAndQuantityGreaterThan(documentIdd, lotIdd, lineNumberLot, 0);
    }

    public void deleteAllMarksByLotIddIntoLot(List<UUID> productId) {
        scannedMarkRepository.deleteScannedMarkByProductIdIn(productId);
    }

    public List<Product> getProductsByDocumentIdd(String documentIdd) {
        return productISRepository.findByDocumentIdd(documentIdd);
    }
}
