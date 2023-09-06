package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderClosureDocumentMapper {

    public static OrderClosureDocument map(
            OrderDocument orderDocument,
            String idDoc,
            String basis,
            String currencyId,
            String rate,
            String coefficient,
            Journal journal
    ) {
        OrderClosureDocument orderClosureDocument = new OrderClosureDocument();
        orderClosureDocument.setIdDoc(idDoc);
        orderClosureDocument.setDocBasis(basis);
        orderClosureDocument.setBasis("     0   ");
        orderClosureDocument.setEditTime(String.valueOf(Time.valueOf(LocalTime.now())));
        orderClosureDocument.setQuantity(orderDocument.getQuantity());
        orderClosureDocument.setSum(orderDocument.getSum());
        orderClosureDocument.setDateCreated(Date.valueOf(LocalDate.now()));
        orderClosureDocument.setTimeDoc(String.valueOf(Time.valueOf(LocalTime.now())));
        orderClosureDocument.setWarehouse(orderDocument.getWarehouse());

        if (Objects.isNull(orderDocument.getComment())) {
            orderClosureDocument.setComment("");
        } else {
            orderClosureDocument.setComment(orderDocument.getComment());
        }

        orderClosureDocument.setCurrency(currencyId);
        orderClosureDocument.setRate(new BigDecimal(rate));
        journal.setDnprefix(orderDocument.getJournal().getDnprefix());
        orderClosureDocument.setJournal(journal);
        List<OrderClosureDocumentItem> orderClosureDocumentItems = orderDocument.getItems().stream()
                .filter(Objects::nonNull)
                .map(x -> map(x, coefficient, idDoc))
                .collect(Collectors.toList());
        orderClosureDocument.setItems(orderClosureDocumentItems);
        return orderClosureDocument;
    }

    public static OrderClosureDocumentItem map(OrderDocumentItem orderDocumentItem, String coefficient, String idDoc) {
        OrderClosureDocumentItem orderClosureDocumentItem = new OrderClosureDocumentItem();
        orderClosureDocumentItem.setIddocLinenumberIdentity(new IddocLinenumberIdentity());
        orderClosureDocumentItem.getIddocLinenumberIdentity().setLineNo(orderDocumentItem.getIddocLinenumberIdentity().getLineNo());
        orderClosureDocumentItem.getIddocLinenumberIdentity().setIdDoc(idDoc);
        orderClosureDocumentItem.setItem(orderDocumentItem.getItem());
        orderClosureDocumentItem.setQuantity(orderDocumentItem.getQuantity());
        orderClosureDocumentItem.setPrice(orderDocumentItem.getPrice());
        orderClosureDocumentItem.setSum(orderDocumentItem.getSum());
        orderClosureDocumentItem.setCoefficient(new BigDecimal(coefficient));
        orderClosureDocumentItem.setUnit(orderDocumentItem.getProductInfo().getBaseUnit());
        return orderClosureDocumentItem;
    }
}
