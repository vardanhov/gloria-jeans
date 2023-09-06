package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.PriceOrder;

import java.util.List;


@Repository
public interface PriceOrderRepository extends CrudRepository<PriceOrder, String> {

    List<PriceOrder> findOneByPriceTypeAndItems_Item(Integer priceType, String item);
}
