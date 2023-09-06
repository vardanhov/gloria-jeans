package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gloria_jeans.onecdbmapper.dao.model.Tnved;

import java.util.List;

public interface TnvedRepository extends CrudRepository<Tnved, Long> {
    List<Tnved> findByCodeIn(List<String> idds);
}
