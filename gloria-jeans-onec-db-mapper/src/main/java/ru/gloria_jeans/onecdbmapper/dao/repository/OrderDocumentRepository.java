package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;

import java.util.List;

@Repository
public interface OrderDocumentRepository extends CrudRepository<OrderDocument, String> {
    OrderDocument findOneByOrderNumber(String orderNumber);
    OrderDocument findOneByIdDoc(String idDoc);
    OrderDocument findOneByJournal_Idd(String idd);
    List<OrderDocument> findAllByStatusOrder(String statusOrder);
    List<OrderDocument> findAllByStatusOrderAndTk(String statusOrder, String tk);
    List<OrderDocument> findAllByOrderNumberIn(List<String> orderNumbers);
    List<OrderDocument> findAllByShippingMethod(String shippingMethod);
    List<OrderDocument> findAllByShippingMethodInAndStatusOrderNotIn(List<String> shippingMethod, List<String> statusOrder);
    List<OrderDocument> findByOrderNumber(String orderNumber);
}
