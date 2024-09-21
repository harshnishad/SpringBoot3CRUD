package com.harshnishad.SpringCRUD;

import java.util.List;

public interface EmployeeService {
    //interface
    String createEmployee(Employee employee);

    List<Employee> readEmployees();

    boolean deleteEmployee(Long id);

    String updateEmployee(Long id,Employee employee);

    Employee getEmployeeById(Long id);
}
