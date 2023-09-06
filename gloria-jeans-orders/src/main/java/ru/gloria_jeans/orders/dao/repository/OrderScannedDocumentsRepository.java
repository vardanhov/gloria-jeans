package ru.gloria_jeans.orders.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.orders.dao.model.ScannedDocument;

import java.util.List;
import java.util.UUID;

public interface OrderScannedDocumentsRepository extends CrudRepository<ScannedDocument, UUID> {

    ScannedDocument findByOrderNumber(String orderNumber);

    List<ScannedDocument> findAllByOrderStatusIsAndTk(String status, String tk);

    List<ScannedDocument> findAllByOrderStatusIs(String status);

    List<ScannedDocument> findAllByTk(String tk);

}
