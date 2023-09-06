package ru.gloria_jeans.orders.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.orders.dao.enums.OrderStatus;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDocumentISRepository extends CrudRepository<OrderLocalDocument, UUID> {
    OrderLocalDocument findByOrderNumber(String orderNumber);
    void deleteByIdd(String idd);
    OrderLocalDocument findByIdd(String idd);
    List<OrderLocalDocument> findOrderLocalDocumentsByStatusOrder(OrderStatus status);
    List<OrderLocalDocument> findOrderLocalDocumentsByStatusOrderAndTk(OrderStatus status, String tk);
}
