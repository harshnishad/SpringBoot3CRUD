package com.harshnishad.SpringCRUD;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved successfully✅";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeList) {
            Employee employee = new Employee();
            employee.setId(employeeEntity.getId());
            employee.setPhone(employeeEntity.getPhone());
            employee.setName(employeeEntity.getName());
            employee.setEmail(employeeEntity.getEmail());
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity newEmployee = employeeRepository.findById(id).get();
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setName(employee.getName());
        employeeRepository.save(newEmployee);
        return "update sucessfully";
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity newEmployee = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(newEmployee, employee);
        return employee;
    }
}
