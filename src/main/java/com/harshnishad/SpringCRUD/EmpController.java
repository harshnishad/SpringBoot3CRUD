package com.harshnishad.SpringCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {
    //List<Employee> employess = new ArrayList<>();
    //Dependency enjection

    @Autowired
    EmployeeService employeeService;
    // bar bar new keyword se obj nhi baninge kyuki bar bar call krne pr memory banegi

    @GetMapping("employee")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @PostMapping("employee")
    public String createEmployee(@RequestBody Employee emp){
        //employess.add(emp);
        return employeeService.createEmployee(emp);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
     if(employeeService.deleteEmployee(id)) return "Employee deleted👍";
     return "Employee not found 😒";
    }

    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee emp){
        return employeeService.updateEmployee(id, emp);
    }
}
