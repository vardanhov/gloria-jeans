package ru.gloria_jeans.receiving.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.receiving.dao.model.Document;
import ru.gloria_jeans.receiving.model.enums.DocumentType;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface DocumentISRepository extends CrudRepository<Document, UUID> {
    Document findOneByDocumentTypeAndIdd(DocumentType documentType, String idd);
    Document findOneByDocumentTypeAndProducts_BarcodeBox(DocumentType documentType, String barcodeBox);
    Set<Document> findByDocumentTypeAndIddIn(DocumentType documentType, List<String> idd);
}
