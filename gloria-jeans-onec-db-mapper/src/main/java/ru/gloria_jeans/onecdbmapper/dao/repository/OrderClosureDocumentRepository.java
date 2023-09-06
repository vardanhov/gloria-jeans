package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderClosureDocument;

import java.util.List;

@Repository
public interface OrderClosureDocumentRepository extends CrudRepository<OrderClosureDocument, String> {
    OrderClosureDocument findOneByIdDoc(String idDoc);
    OrderClosureDocument findOneByDocBasis(String docBasis);
    List<OrderClosureDocument> findByDocBasisContaining(String idDoc);

}
