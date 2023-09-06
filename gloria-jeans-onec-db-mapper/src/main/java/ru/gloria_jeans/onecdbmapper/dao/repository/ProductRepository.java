package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.ProductInfo;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductInfo, String> {
    ProductInfo findOneByBarcode(String barcode);
    ProductInfo findOneByVendorCode(String vendorCode);
    ProductInfo findOneByPmmCode(String pmmCode);
    ProductInfo findOneByBarcodeOrVendorCode(String barcode, String vendorCode);
    ProductInfo findOneByIdd(String idd);
    List<ProductInfo> findOneByIddIn(List<String> idd);
    ProductInfo findOneByIddOrBarcodeOrVendorCode(String idd, String barcode, String vendorCode);
    List<ProductInfo> findTop50ByVendorCodeContainingIgnoreCaseAndProductKindNotContainingIgnoreCase(String vendorCode, String productKind);
    List<ProductInfo> findByModelCode(String modelCode);
}
