package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.MovingDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.MovingDocumentListing;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface MovingDocumentRepository extends CrudRepository<MovingDocument, String> {
    MovingDocument findOneByJournal_Idd(String idd);
    MovingDocument findOneByItems_BarcodeBox(String barcodeBox);
    Set<MovingDocument> findByItems_BarcodeBox(String barcodeBox);
    MovingDocument findOneByItems_BarcodeBoxAndJournal_Idd(String barcodeBox, String idd);
    Set<MovingDocument> findByJournal_Idd(String idd);
    Set<MovingDocument> findByJournal_Docno(String docno);
    Set<MovingDocument> findByJournal_DocnoLike(String docno);
    long countByDateCreatedBetween(
            Date dateCreatedFrom,
            Date dateCreatedTo
    );
    Set<MovingDocument> findByDateCreatedBetween(
            Date dateCreatedFrom,
            Date dateCreatedTo
    );
    Set<MovingDocument> findByStatusAndDateCreatedAfterAndDateCreatedBefore(
            String status,
            String dateCreatedFrom,
            String dateCreatedTo
    );
    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.quantity as quantity, " +
                    "md.quantityPlaces as quantityPlaces, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.factQuantity as acceptanceDocumentQuantityFact, " +
                    "COUNT(DISTINCT adi.barcodeBox) as quantityBox " +
                    "FROM Journal j " +
                    "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
                    "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
                    "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
                    "LEFT OUTER JOIN AcceptanceDocumentItem adi on adi.iddocLinenumberIdentity.idDoc = ad.iddoc and adi.factQuantity > 0 " +
                    "WHERE j.docno = ?2 " +
                    "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.quantity, " +
                    "md.quantityPlaces, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.factQuantity "
    )
    List<MovingDocumentListing> findListingByJournal_Docno(String partOfParentVal, String docno);
    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.quantity as quantity, " +
                    "md.quantityPlaces as quantityPlaces, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.factQuantity as acceptanceDocumentQuantityFact, " +
                    "COUNT(DISTINCT adi.barcodeBox) as quantityBox " +
            "FROM Journal j " +
            "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
            "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
            "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
            "LEFT OUTER JOIN AcceptanceDocumentItem adi on adi.iddocLinenumberIdentity.idDoc = ad.iddoc and adi.factQuantity > 0 " +
            "WHERE j.idd = ?2 " +
            "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.quantity, " +
                    "md.quantityPlaces, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.factQuantity "
    )
    MovingDocumentListing findListingByJournal_Idd(String partOfParentVal, String idd);
    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.quantity as quantity, " +
                    "md.quantityPlaces as quantityPlaces, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.factQuantity as acceptanceDocumentQuantityFact, " +
                    "COUNT(DISTINCT adi.barcodeBox) as quantityBox " +
            "FROM Journal j " +
            "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
            "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
            "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
            "LEFT OUTER JOIN AcceptanceDocumentItem adi on adi.iddocLinenumberIdentity.idDoc = ad.iddoc and adi.factQuantity > 0 " +
            "WHERE j.dateTimeIdDoc BETWEEN ?2 AND ?3 " +
            "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.quantity, " +
                    "md.quantityPlaces, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.factQuantity "
    )
    List<MovingDocumentListing> findListingByDateCreatedBetween(
            String partOfParentVal,
            String dateCreatedFrom,
            String dateCreatedTo
    );

    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.quantity as quantity, " +
                    "md.quantityPlaces as quantityPlaces, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.factQuantity as acceptanceDocumentQuantityFact, " +
                    "COUNT(DISTINCT adi.barcodeBox) as quantityBox " +
                    "FROM Journal j " +
                    "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
                    "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
                    "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
                    "LEFT OUTER JOIN AcceptanceDocumentItem adi on adi.iddocLinenumberIdentity.idDoc = ad.iddoc and adi.factQuantity > 0 " +
                    "WHERE j.docno = ?2 and md.warehouseReceiver =?3 " +
                    "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.quantity, " +
                    "md.quantityPlaces, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.factQuantity "
    )
    List<MovingDocumentListing> findListingByJournal_DocnoAndMovingDocument_warehouseReceiver(
            String partOfParentVal,
            String docno,
            String warehouseReceiver
    );
    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.quantity as quantity, " +
                    "md.quantityPlaces as quantityPlaces, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.factQuantity as acceptanceDocumentQuantityFact, " +
                    "COUNT(DISTINCT adi.barcodeBox) as quantityBox " +
                    "FROM Journal j " +
                    "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
                    "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
                    "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
                    "LEFT OUTER JOIN AcceptanceDocumentItem adi on adi.iddocLinenumberIdentity.idDoc = ad.iddoc and adi.factQuantity > 0 " +
                    "WHERE j.idd = ?2 and md.warehouseReceiver =?3 " +
                    "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.quantity, " +
                    "md.quantityPlaces, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.factQuantity "
    )
    MovingDocumentListing findListingByJournal_IddAndMovingDocument_warehouseReceiver(
            String partOfParentVal,
            String idd,
            String warehouseReceiver
    );
    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.quantity as quantity, " +
                    "md.quantityPlaces as quantityPlaces, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.factQuantity as acceptanceDocumentQuantityFact, " +
                    "COUNT(DISTINCT adi.barcodeBox) as quantityBox " +
                    "FROM Journal j " +
                    "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
                    "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
                    "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
                    "LEFT OUTER JOIN AcceptanceDocumentItem adi on adi.iddocLinenumberIdentity.idDoc = ad.iddoc and adi.factQuantity > 0 " +
                    "WHERE j.dateTimeIdDoc BETWEEN ?2 AND ?3 and md.warehouseReceiver =?4 " +
                    "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.quantity, " +
                    "md.quantityPlaces, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.factQuantity "
    )
    List<MovingDocumentListing> findListingByDateCreatedBetweenAndMovingDocument_warehouseReceiver(
            String partOfParentVal,
            String dateCreatedFrom,
            String dateCreatedTo,
            String warehouseReceiver
    );

    @Query(
            "SELECT " +
                    "j.idd as idd, " +
                    "j.docno as docno," +
                    "j.dateTimeIdDoc as dateTimeIdDoc, " +
                    "md.warehouseReceiver as warehouseReceiver, " +
                    "md.dateCreated as dateCreated, " +
                    "md.basis as reasonId, " +
                    "ad.iddoc as acceptanceDocumentIddoc, " +
                    "ad.dateCreated as acceptanceDocumentDateCreated " +
                    "FROM Journal j " +
                    "INNER JOIN MovingDocument md ON md.idDoc = j.idoc " +
                    "LEFT JOIN OnecSrcdoc os ON CONCAT(?1, md.idDoc) = os.parentVal and os.mdId = 0 " +
                    "LEFT OUTER JOIN AcceptanceDocument ad on os.childId = ad.iddoc " +
                    "WHERE j.dateTimeIdDoc BETWEEN ?2 AND ?3  AND md.warehouseReceiver <>?4 " +
                    "GROUP BY " +
                    "j.idd, " +
                    "j.docno," +
                    "j.dateTimeIdDoc, " +
                    "md.warehouseReceiver, " +
                    "md.dateCreated, " +
                    "md.basis, " +
                    "ad.iddoc, " +
                    "ad.dateCreated"
    )
    List<MovingDocumentListing> findListingByNotEqualsMovingDocument_warehouseReceiver(
            String partOfParentVal,
            String dateCreatedFrom,
            String dateCreatedTo,
            String warehouseReceiver,
            Pageable pageable
    );
}
