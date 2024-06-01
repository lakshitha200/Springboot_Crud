package MongoDB.example.MongoDBdemo.Service.Impl;

import MongoDB.example.MongoDBdemo.Model.Employee;
import MongoDB.example.MongoDBdemo.Repository.EmployeeRepository;
import MongoDB.example.MongoDBdemo.Service.EmployeeService;
import MongoDB.example.MongoDBdemo.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepsitory;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //save employee in database
    @Override
    public Employee saveEmployee(Employee employee){
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
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
                RuntimeException::new
        );
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setAge(employee.getAge());
        // save
        employeeRepsitory.save(existingEmployee);
        return existingEmployee;
    }

    //delete employee
    @Override
    public void deleteEmployee(long id) {
        //check
        employeeRepsitory.findById(id).orElseThrow(RuntimeException::new);
        //delete
        employeeRepsitory.deleteById(id);
    }
}
