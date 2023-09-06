package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListModel extends BaseResponse {
    private List<EmployeeModel> employeeModels = new ArrayList<>();

    public List<EmployeeModel> getEmployeeModels() {
        return employeeModels;
    }

    public void setEmployeeModels(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }
}
