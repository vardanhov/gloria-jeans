package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocumentItem;
import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;

@Repository
public interface AcceptanceDocumentItemRepository extends CrudRepository<AcceptanceDocumentItem, IddocLinenumberIdentity> {
}
