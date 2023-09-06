package ru.gloria_jeans.orders.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderItemListing;
import ru.gloria_jeans.orders.dao.model.OrderItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemISRepository extends CrudRepository<OrderItem, UUID> {

    List<OrderItem> findByIdDoc(String idDoc);
    List<OrderItem> findByMarksLike(String mark);
    Optional<OrderItem> findById(UUID id);
    List<OrderItem> findByDocumentIddAndIddOrDocumentIddAndBarcodeOrDocumentIddAndVendorCode(String documentIdd, String idd, String documentIddO, String barCode, String documentIddT,  String vendorCode);
    OrderItem findByDocumentIddAndIdd(String documentIdd, String idd);
    List<OrderItemListing> findOrderItemByDocumentIdd(String documentIdd);
    OrderItem findByIdAndDocumentIdd(UUID id, String documentIdd);
    void deleteAllByDocumentIdd(String documentIdd);

    List<OrderItem> findAllByDocumentIdd(String documentIdd);
}
