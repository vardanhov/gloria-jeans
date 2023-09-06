package ru.gloria_jeans.receiving.dao.mapper;

import com.google.common.base.Strings;
import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocument;
import ru.gloria_jeans.receiving.dao.model.Document;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AcceptanceDocumentMapper {
    public static AcceptanceDocument map(Document document, String iddoc) {
        AcceptanceDocument acceptanceDocument = new AcceptanceDocument();
        acceptanceDocument.setIddoc(iddoc);
        acceptanceDocument.setAcceptedBy(document.getAcceptedBy());
        acceptanceDocument.setBasis("     6   "); //It gets from "Справочник.ПричиныПеремещений"
        acceptanceDocument.setComment(document.getDocumentComment());
        acceptanceDocument.setCreatedBy(document.getCreatedBy());
        acceptanceDocument.setDateCreated(Date.valueOf(LocalDate.now()));
        acceptanceDocument.setDocBasis(document.getIddoc());
        acceptanceDocument.setFactQuantity(document.getFactQuantity().intValue());
        acceptanceDocument.setRecipientCompany(document.getFirmRecipient());
        acceptanceDocument.setRecipientWarehouse(document.getFinalWarehouse());
        acceptanceDocument.setSum(document.getSum().intValue());
        acceptanceDocument.setTimeEdited(document.getUpdatedAt());
        acceptanceDocument.setWarehouse(document.getWarehouse());
        acceptanceDocument.setTimeDoc(
                DateTimeFormatter.ofPattern("HH:mm:ss")
                        .withLocale(Locale.getDefault())
                        .withZone(ZoneId.systemDefault())
                        .format(Instant.now())
        );

        if (Strings.isNullOrEmpty(document.getTradeNumber().trim())) {
            acceptanceDocument.setTransferNumber(0);
        } else {
            acceptanceDocument.setTransferNumber(Integer.valueOf(document.getTradeNumber()));
        }

        return acceptanceDocument;
    }
}
