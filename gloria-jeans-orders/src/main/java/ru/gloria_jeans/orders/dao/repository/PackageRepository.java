package ru.gloria_jeans.orders.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.orders.dao.model.OrderPackage;

import java.util.List;
import java.util.UUID;

public interface PackageRepository extends CrudRepository<OrderPackage, UUID> {

    List<OrderPackage> findAllByOrderNumber(String orderNumber);

    OrderPackage findByOrderNumber(String orderNumber);

    OrderPackage findByOrderNumberAndPackageIdd(String orderNumber, String idd);

    void deleteAllByOrderNumber(String orderNumber);

}
