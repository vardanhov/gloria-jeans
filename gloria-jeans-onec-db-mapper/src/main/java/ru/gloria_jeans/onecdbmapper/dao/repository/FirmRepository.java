package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Firm;

@Repository
public interface FirmRepository extends CrudRepository<Firm, Long> {
    Firm findOneById(String iddoc);
}
