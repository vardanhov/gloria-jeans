package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.PriceOrderItem;

public interface PriceOrderItemRepository extends CrudRepository<PriceOrderItem, IddocLinenumberIdentity> {
}
