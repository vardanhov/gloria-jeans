package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.MismatchDocumentItem;

@Repository
public interface MismatchDocumentItemRepository extends CrudRepository<MismatchDocumentItem, String> {
}
