package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.IddocLinenumberActionnumberIdentity;
import ru.gloria_jeans.onecdbmapper.dao.model.StockBalanceTMCItem;

import java.math.BigDecimal;

public class StockBalanceTMCItemMapper {
    public static StockBalanceTMCItem map(
            Integer lineNumber,
            Integer actionNumber,
            String iddoc,
            String warehouse,
            String firm,
            String item,
            BigDecimal quantity,
            BigDecimal sum,
            String operationCode,
            int debkred
    ) {
        StockBalanceTMCItem stockBalanceTMCItem = new StockBalanceTMCItem();
        IddocLinenumberActionnumberIdentity iddocLinenumberIdentity = new IddocLinenumberActionnumberIdentity();
        iddocLinenumberIdentity.setActno(actionNumber);
        iddocLinenumberIdentity.setLineNo(lineNumber);
        iddocLinenumberIdentity.setIdDoc(iddoc);
        stockBalanceTMCItem.setIddocLinenumberIdentity(iddocLinenumberIdentity);
        stockBalanceTMCItem.setWarehouse(warehouse);
        stockBalanceTMCItem.setFirm(firm);
        stockBalanceTMCItem.setItem(item);
        stockBalanceTMCItem.setQuantity(quantity);
        stockBalanceTMCItem.setDebkred(0);
        stockBalanceTMCItem.setOperationCode(operationCode);
        stockBalanceTMCItem.setSum(sum);
        stockBalanceTMCItem.setDebkred(debkred);
        return stockBalanceTMCItem;
    }
}
