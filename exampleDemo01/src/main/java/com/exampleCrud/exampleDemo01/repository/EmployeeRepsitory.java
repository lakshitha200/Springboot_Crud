package com.exampleCrud.exampleDemo01.repository;

import com.exampleCrud.exampleDemo01.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepsitory extends JpaRepository<Employee,Long> {
    //crud
}
