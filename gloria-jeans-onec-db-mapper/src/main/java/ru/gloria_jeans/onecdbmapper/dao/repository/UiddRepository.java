package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Uidd;

@Repository
public interface UiddRepository extends CrudRepository<Uidd, String> {
    @Query(
            value = "if (exists(select * from sys.tables where name = 'UIDD' and type = 'U')) begin select right('0000000' + LTrim(idd), 7) + right('0000000000' + LTrim(str(uidd + 1, 10)),10) as uidd from UIDD (updlock) update UIDD set uidd = uidd + 1 end else select '-1' as uidd",
            nativeQuery = true
    )
    Uidd getUidd();
    @Query(
            value = "UPDATE _1sconst set VALUE = cast((cast(VALUE as bigint)+1) as varchar(25)) where ID = ?2 and [OBJID] = 0; select RIGHT('0000000' + idd_c.VALUE, 7) + RIGHT('0000000000' + uid_c.VALUE, 10) AS uidd from _1sconst as uid_c join _1sconst as idd_c on idd_c.ID = ?1 and idd_c.[OBJID] = 0 where uid_c.ID = ?2 and uid_c.[OBJID] = 0",
            nativeQuery = true
    )
    Uidd getIdd(String idd, String uidd);
}
