package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.AcceptanceDocument;

import java.util.Set;

@Repository
public interface AcceptanceDocumentRepository extends CrudRepository<AcceptanceDocument, String> {
    Set<AcceptanceDocument> findByItems_BarcodeBox(String barcodeBox);
    AcceptanceDocument findOneByJournal_Idd(String idd);
}
