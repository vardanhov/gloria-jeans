package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.model.Employee;
import ru.gloria_jeans.onecdbmapper.dao.repository.EmployeesRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;

import java.util.List;

@Component
public class EmployeeComponent {
    private final EmployeesRepository employeesRepository;
    private final OnecConstantRepository onecConstantRepository;

    @Autowired
    public EmployeeComponent(EmployeesRepository employeesRepository, OnecConstantRepository onecConstantRepository) {
        this.employeesRepository = employeesRepository;
        this.onecConstantRepository = onecConstantRepository;
    }

    public List<Employee> getAllEmployeesOfThisStore() {
        return employeesRepository.findByBaseAndFired(
                onecConstantRepository.findOneByIdAndObjIdOrderByDateDesc(
                        Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("IDD").getID()),
                        "     0   "
                ).getValue(),
                0
        );
    }

    public Employee getEmployeeByIddoc(String iddoc) {
        return employeesRepository.findOneByBaseAndId(
                onecConstantRepository.findOneByIdAndObjIdOrderByDateDesc(
                        Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("IDD").getID()),
                        "     0   "
                ).getValue(),
                iddoc
        );
    }
}
