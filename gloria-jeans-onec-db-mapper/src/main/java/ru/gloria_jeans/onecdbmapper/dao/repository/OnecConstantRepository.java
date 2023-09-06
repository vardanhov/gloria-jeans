package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecConstant;

import java.util.Date;
import java.util.List;

@Repository
public interface OnecConstantRepository extends CrudRepository<OnecConstant, Long> {
    OnecConstant findOneByIdAndObjId(Long id, String objId);
    OnecConstant findOneByIdAndObjIdOrderByDateDesc(Long id, String objId);
    List<OnecConstant> findByIdAndObjIdAndDateBeforeOrderByDateDesc(Long id, String objId, Date date);
    List<OnecConstant> findByIdAndObjIdOrderByDateDesc(Long id, String objId);
}
