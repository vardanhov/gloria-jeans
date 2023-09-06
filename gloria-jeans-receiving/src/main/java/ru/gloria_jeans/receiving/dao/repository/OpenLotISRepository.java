package ru.gloria_jeans.receiving.dao.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.receiving.dao.model.OpenLot;

import java.util.List;
import java.util.UUID;

@Repository
public interface OpenLotISRepository extends CrudRepository<OpenLot, UUID> {
    OpenLot findByDocumentIddAndBarcodeAndLotIdd(String documentIdd, String barcode, String lotIdd);
    List<OpenLot> findByDocumentIddAndLotIdd(String documentIdd, String lotIdd);
    List<OpenLot> findByDocumentIdd(String documentIdd);
    List<OpenLot> findByProductIdd(String productIdd);
    @Query("SELECT ol FROM OpenLot ol WHERE ol.documentIdd = ?1 AND ol.lotIdd = ?2 AND ol.lineNumberLot = ?3 AND (ol.productIdd = ?4 OR ol.barcode = ?5 OR ol.vendorCode = ?6)")
    OpenLot findByDocumentIddAndLotIddAndLineNumberLotAndProductIddOrBarcodeOrVendorCode(String documentIdd, String lotIdd, Integer lineNumberLot, String productIdd, String barcode, String vendorCode);
    List<OpenLot> findByLotIddIn(List<String> lotIdd);
    List<OpenLot> findByLotIddAndLineNumberLot(String lotIdd, Integer lineNumberLot);
    @Modifying
    @Query("DELETE FROM OpenLot ol WHERE ol.documentIdd = :documentIdd AND ol.lotIdd = :lotId AND ol.lineNumberLot = :lineNumberLot")
    void deleteAllByLotIddAndLineNumberLot(@Param("documentIdd") String documentIdd, @Param("lotId") String lotId, @Param("lineNumberLot") Integer lineNumberLot);

    @Modifying
    @Query("DELETE FROM OpenLot  ol WHERE ol.id = :id")
    void deleteLotById(UUID id);

//    @Query("DELETE FROM OpenLot ol WHERE ol.id IN (:ids)")
//    void deleteAllById(List<UUID> ids);

    List<OpenLot> findByDocumentIddAndLotIddAndLineNumberLotAndQuantityLessThan(String documentIdd, String lotIdd, Integer lineNumberLot, int quantity);
    List<OpenLot> findByDocumentIddAndLotIddAndLineNumberLotAndQuantityGreaterThan(String documentIdd, String lotIdd, Integer lineNumberLot, int quantity);
}
