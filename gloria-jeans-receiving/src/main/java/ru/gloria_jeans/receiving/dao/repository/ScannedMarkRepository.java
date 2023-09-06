package ru.gloria_jeans.receiving.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.receiving.dao.model.ScannedMark;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScannedMarkRepository extends CrudRepository<ScannedMark, UUID> {
    long countByScannedMarkAndIsValidMark(String scannedMark, Boolean validMark);
    List<ScannedMark> findAll();

    void deleteAllByBarcodeBox(String barcodeBox);

    List<ScannedMark> findAllByProductId(UUID productId);

    void deleteScannedMarkByProductIdIn(List<UUID> productId);
}
