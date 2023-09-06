package ru.gloria_jeans.orders.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.orders.dao.model.ReturnedOrderLocalDocument;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReturnedOrderDocumentRepository extends CrudRepository<ReturnedOrderLocalDocument, UUID> {
    ReturnedOrderLocalDocument findByOrderNumber(String orderNumber);
    List<ReturnedOrderLocalDocument> findAll();
}
