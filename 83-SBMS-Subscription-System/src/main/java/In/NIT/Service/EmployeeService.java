package In.NIT.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import In.NIT.Entity.Employee;
import In.NIT.Repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

    // Save new employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    // Update employee
    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        existing.setName(updatedEmployee.getName());
        existing.setPosition(updatedEmployee.getPosition());
        existing.setTeam(updatedEmployee.getTeam());
        return employeeRepository.save(existing);
    }

    // Delete employee
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
