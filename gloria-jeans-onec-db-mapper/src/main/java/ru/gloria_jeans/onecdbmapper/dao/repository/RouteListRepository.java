package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.onecdbmapper.dao.model.RouteList;

public interface RouteListRepository extends CrudRepository<RouteList, String> {
    RouteList findByIdDoc(String idDoc);
}
