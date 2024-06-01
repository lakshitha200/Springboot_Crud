package MongoDB.example.MongoDBdemo.Repository;

import MongoDB.example.MongoDBdemo.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Long> {
    }
