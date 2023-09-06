package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderClosureDocumentItem;

@Repository
public interface OrderClosureDocumentItemRepository extends CrudRepository<OrderClosureDocumentItem, IddocLinenumberIdentity> {
}
