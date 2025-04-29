package In.NIT.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import In.NIT.Entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
