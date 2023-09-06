package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocumentItem;

import java.util.List;

@Repository
public interface OrderDocumentItemRepository extends CrudRepository<OrderDocumentItem, String> {
    List<OrderDocumentItem> findByProductInfoIdd(String idd);
}
