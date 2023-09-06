package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.SalesBanDocument;

@Repository
public interface SalesBanDocumentRepository extends CrudRepository<SalesBanDocument, String> {
    SalesBanDocument findFirstByItems_ItemOrderByDateCreatedDesc(String item);
}
