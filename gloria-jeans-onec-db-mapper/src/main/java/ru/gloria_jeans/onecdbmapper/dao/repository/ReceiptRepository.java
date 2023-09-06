package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Receipt;

import java.util.List;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, String> {
    Receipt findOneByIddBaseDocument(String iddBaseDocument);
    List<Receipt> findOneByIddBaseDocumentIn(List<String> iddBaseDocuments);
    Receipt findOneByIdDoc(String idDoc);
    Receipt findOneByDocBasis(String docBasis);
    Receipt findByDocBasisContainingAndJournal_Idd(String idDoc, String idd);
    boolean existsReceiptByDocBasisContainingAndJournal_Idd(String idDoc, String idd);
}
