package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.StockBalanceTMC;
import ru.gloria_jeans.onecdbmapper.dao.model.StockBalanceTMCEmbeddedId;

import java.math.BigDecimal;
import java.util.Date;

public class StockBalanceTMCMapper {
    public static StockBalanceTMC map(
            String firm,
            String warehouse,
            BigDecimal quantity,
            String item,
            Date period) {
        StockBalanceTMC stockBalanceTMC = new StockBalanceTMC();
        stockBalanceTMC.setStockBalanceTMCEmbeddedId(new StockBalanceTMCEmbeddedId());
        stockBalanceTMC.setPeriod(period);
        stockBalanceTMC.setFirm(firm);
        stockBalanceTMC.setWarehouse(warehouse);
        stockBalanceTMC.setQuantity(quantity);
        stockBalanceTMC.setItem(item);
        return stockBalanceTMC;
    }
}
