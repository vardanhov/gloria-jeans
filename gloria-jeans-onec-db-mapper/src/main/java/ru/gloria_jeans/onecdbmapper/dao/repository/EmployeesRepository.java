package ru.gloria_jeans.onecdbmapper.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gloria_jeans.onecdbmapper.dao.model.Employee;

import java.util.List;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByBaseAndFired(String base, int fired);
    Employee findOneByBaseAndId(String base, String iddoc);
    Employee findOneById(String id);
    List<Employee> findByBaseAndFiredAndNameNotContaining(String base, int fired, String decret);
}
