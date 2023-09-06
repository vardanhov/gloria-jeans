package ru.gloria_jeans.receiving.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.receiving.dao.model.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductISRepository extends CrudRepository<Product, UUID> {
    Product findOneByBarcode(String barcode);
    Product findOneByPmmCode(String pmmCode);
    Product findOneByVendorCode(String vendorCode);
    Product findOneByIddAndDocumentIddAndBarcodeBoxAndLineNumber(
            String idd,
            String documentIdd,
            String barcodeBox,
            Integer lineNumber
    );
    List<Product> findByBarcode(String barcode);
    List<Product> findByBarcodeBoxAndMarksLike(String barcodeBox, String mark);
    List<Product> findByVendorCode(String vendorCode);
    List<Product> findByIdd(String idd);
    List<Product> findByIddAndDocumentIddAndBarcodeBox(String idd, String documentIdd, String barcodeBox);
    List<Product> findByBarcodeBoxAndIddOrBarcodeBoxAndBarcodeOrBarcodeBoxAndVendorCode(String barcodeBoxF, String idd, String barcodeBoxS, String barcode, String barcodeBoxT, String vendorCode);
    Product findFirstByDocumentIddOrderByLineNumberDesc(String documentIdd);
    List<Product> findByBarcodeBoxAndQuantityGreaterThan(String barcodeBox, int quantity);
    List<Product> findByBarcodeBoxAndQuantityLessThan(String barcodeBox, int quantity);
    List<Product> findByBarcodeBox(String barcodeBox);
    List<Product> findByDocumentIdd(String documentIdd);
}
