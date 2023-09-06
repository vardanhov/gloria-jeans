package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Warehouse;

import java.util.List;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {
    Warehouse findOneById(String id);
    Warehouse findOneByDbIdd(String dbIdd);
    List<Warehouse> findByCodeIn(List<String> codes);
    Warehouse findOneByName(String name);
}
