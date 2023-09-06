package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.KeyValue;
import ru.gloria_jeans.onecdbmapper.dao.model.MovingReason;

import java.util.List;

@Repository
public interface MovingReasonRepository extends CrudRepository<MovingReason, String> {
    MovingReason findOneById(String id);
    @Query("SELECT mr.id as key, mr.descr as value FROM MovingReason mr")
    List<KeyValue> findAllKeyValue();
    MovingReason findOneByCode(String code);
}
