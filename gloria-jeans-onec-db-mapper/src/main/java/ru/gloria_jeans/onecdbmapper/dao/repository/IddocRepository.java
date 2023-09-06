package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Iddoc;

@Repository
public interface IddocRepository extends CrudRepository<Iddoc, String> {
    @Query(
            value = "DECLARE @id CHAR(9)\nEXEC _1sp__1SJOURN_MaxID @id OUT\nSELECT 'iddoc' = @id",
            nativeQuery = true
    )
    Iddoc getIddoc();
}
