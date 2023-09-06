package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.enums.WriteOffType;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.WriteOffDocument;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class WriteOffDocumentMapper {

    public static WriteOffDocument map (String idDoc,OrderDocument orderDocument) {
        WriteOffDocument writeOffDocument = new WriteOffDocument();
        writeOffDocument.setIdDoc(idDoc);
        writeOffDocument.setCommon(BigDecimal.ONE);
        writeOffDocument.setWriteOffType(WriteOffType.PACKAGE.getValue());
        writeOffDocument.setWarehouse(orderDocument.getWarehouse());
        writeOffDocument.setTimeEdited(String.valueOf(Time.valueOf(LocalTime.now())));
        writeOffDocument.setDateCreated(Date.valueOf(LocalDate.now()));
        writeOffDocument.setTimeDoc(String.valueOf(Time.valueOf(LocalTime.now())));
        writeOffDocument.setComment(orderDocument.getComment());
        return writeOffDocument;
    }

}
