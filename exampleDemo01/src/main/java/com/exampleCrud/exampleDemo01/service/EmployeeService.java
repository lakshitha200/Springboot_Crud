package com.exampleCrud.exampleDemo01.service;
import com.exampleCrud.exampleDemo01.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
