package ru.gloria_jeans.orders.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.orders.dao.model.ScannedMark;

import java.util.UUID;

public interface ScannedMarkRepository extends CrudRepository<ScannedMark, UUID> {

    long countByScannedMarkAndIsValidMark(String scannedMark, Boolean validMark);

    ScannedMark findByOrderItemIdAndDataMatrix(UUID uuid, String dataMatrix);

    void deleteByScannedMark(String scannedMark);

}
