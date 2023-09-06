package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.MismatchDocument;
import ru.gloria_jeans.receiving.dao.model.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MismatchDocumentMapper {
    public static MismatchDocument map(Document document, String iddoc, AcceptanceDocument acceptanceDocument) {
        MismatchDocument mismatchDocument = new MismatchDocument();
        mismatchDocument.setIddoc(iddoc);
        mismatchDocument.setWarehouse(document.getWarehouse());
        mismatchDocument.setWarehouseRecipient(document.getWarehouseReceiver());
        mismatchDocument.setFirmRecipient(document.getFirmRecipient());
        mismatchDocument.setComment(document.getDocumentComment());
        mismatchDocument.setCreatedAt(new Date());
        mismatchDocument.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        mismatchDocument.setDocBasis(
                Utils.build13Ref(
                        acceptanceDocument.getJournal().getIdocdef(),
                        acceptanceDocument.getIddoc()
                )
        );
        mismatchDocument.setDocumentTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        mismatchDocument.setDifferenceSum(BigDecimal.ZERO);
        return mismatchDocument;
    }
}
