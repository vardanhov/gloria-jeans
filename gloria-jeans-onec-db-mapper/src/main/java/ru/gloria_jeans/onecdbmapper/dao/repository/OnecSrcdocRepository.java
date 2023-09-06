package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecSrcdoc;

@Repository
public interface OnecSrcdocRepository extends CrudRepository<OnecSrcdoc, Long> {
}
