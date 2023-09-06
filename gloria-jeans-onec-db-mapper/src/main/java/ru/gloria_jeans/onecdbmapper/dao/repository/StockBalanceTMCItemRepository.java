package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.StockBalanceTMCItem;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface StockBalanceTMCItemRepository extends CrudRepository<StockBalanceTMCItem, IddocLinenumberIdentity> {
    @Query(
            value = "EXEC _1sp_RA405_WriteDocAct @IdDoc = ?1, @LineNo = ?2, @ActNo = ?3, @DebetCredit = ?4, @p0 = ?5, @p1 = ?6, @p2 = ?7, @f0 = ?8, @g0 = ?9, @g1 = ?10, @DocDate = ?11, @CurPeriod = ?12, @RepeatToTM = ?13, @SaveTurnsWithMonth = ?14\n SELECT TOP 1 1  FROM RA405",
            nativeQuery = true
    )
    Integer writeDocAct(String idDoc, Integer lineNo, Integer actNo, Integer debetCredit, String p0, String p1, String p2, BigDecimal f0, String g0, BigDecimal g1, Date docDate, Date curPeriod, Integer repeatToTM, Integer saveTurnsWithMonth);
}
