package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Lot;

import java.util.List;
import java.util.Set;

@Repository
public interface LotRepository extends CrudRepository<Lot, String> {
    Set<Lot> findByParentExt(String parentExt);
    List<Lot> findByParentExtIn(List<String> parentExt);
}
