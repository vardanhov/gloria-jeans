package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Journal;
import ru.gloria_jeans.onecdbmapper.dao.model.JournalListing;

import java.util.List;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Long> {
    @Query(
            value = "SELECT MAX(_1SJOURN.ROW_ID) from _1SJOURN;",
            nativeQuery = true
    )
    Integer getRowIdMax();
    List<JournalListing> findByDnprefix(String dnprefix);
    Journal findOneByIdoc(String idoc);
    Journal findJournalByIdd(String idd);
    @Query(
            value = "select 1 from _1SJOURN where 0=1\nEXEC _1sp__1SJOURN_TLock",
            nativeQuery = true
    )
    Integer lockJournal();
    List<Journal> findByIdocIn(List<String> idocs);
}
