package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.StockBalanceTMC;

import java.util.Date;
import java.util.List;

@Repository
public interface StockBalanceTMCRepository extends CrudRepository<StockBalanceTMC, Date> {
    StockBalanceTMC findOneByStockBalanceTMCEmbeddedId_PeriodAndStockBalanceTMCEmbeddedId_FirmAndStockBalanceTMCEmbeddedId_WarehouseAndStockBalanceTMCEmbeddedId_Item(Date period, String firmId, String warehouseId, String itemId);
    @Query(
            value = "EXEC _1sp_RG405_TUpdate @ItemTVP=?1",
            nativeQuery = true
    )
    void tUpdate(List<StockBalanceTMC> stockBalanceTMC);

    List<StockBalanceTMC> findByStockBalanceTMCEmbeddedIdItem(String item);
}
