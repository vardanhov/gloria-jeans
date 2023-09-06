package ru.gloria_jeans.receiving.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.model.Currency;
import ru.gloria_jeans.onecdbmapper.dao.model.PackageErrorContentsDocument;
import ru.gloria_jeans.receiving.dao.model.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PackageErrorContentsDocumentMapper {
    public static PackageErrorContentsDocument map(
            Document document,
            String iddoc,
            String acceptanceDocumentIdd,
            String discoverer,
            Currency currency
    ) {
        PackageErrorContentsDocument packageErrorContentsDocument = new PackageErrorContentsDocument();
        packageErrorContentsDocument.setIddoc(iddoc);
        packageErrorContentsDocument.setDocBasis(document.getIddoc());//In 1C PackageErrorContents has Moving Document like parent
        packageErrorContentsDocument.setWarehouse(document.getFinalWarehouse());
        packageErrorContentsDocument.setTransactionDate(new Date());
        packageErrorContentsDocument.setTransactionTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        packageErrorContentsDocument.setCurrency(currency.getId());
        packageErrorContentsDocument.setCurrencyDate(new Date());
        packageErrorContentsDocument.setRate(new BigDecimal(currency.getRate()));
        packageErrorContentsDocument.setDiscoverer(discoverer);
        packageErrorContentsDocument.setIddDocBasis(acceptanceDocumentIdd);
        packageErrorContentsDocument.setUpdatedTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        packageErrorContentsDocument.setCreatedAt(new Date());
        packageErrorContentsDocument.setDocumentTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        packageErrorContentsDocument.setComment(document.getDocumentComment());
        return packageErrorContentsDocument;
    }
}
