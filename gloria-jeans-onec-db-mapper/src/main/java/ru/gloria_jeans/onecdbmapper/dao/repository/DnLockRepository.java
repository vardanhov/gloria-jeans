package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.DnLock;
import ru.gloria_jeans.onecdbmapper.dao.model.DnLockIdentificator;

import java.util.List;

@Repository
public interface DnLockRepository extends CrudRepository<DnLock, DnLockIdentificator> {
    List<DnLock> findByDnLockIdentificator_Dnprefix(String dnprefix);
}
