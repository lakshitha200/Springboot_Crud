package com.exampleCrud.exampleDemo01.service.impl;

import com.exampleCrud.exampleDemo01.model.Employee;
import com.exampleCrud.exampleDemo01.repository.EmployeeRepsitory;
import com.exampleCrud.exampleDemo01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepsitory employeeRepsitory;

    //save employee in database
    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepsitory.save(employee);
    }

    //get all employee form database
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepsitory.findAll();
    }

    //get employee using id
    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee =  employeeRepsitory.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else {
            throw new RuntimeException();
        }
    }

    //update employee
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepsitory.findById(id).orElseThrow(
                ()-> new RuntimeException()
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save
        employeeRepsitory.save(existingEmployee);
        return existingEmployee;
    }

    //delete employee
    @Override
    public void deleteEmployee(long id) {
        //check
        employeeRepsitory.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        employeeRepsitory.deleteById(id);
    }
}
