package In.NIT.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import In.NIT.Entity.BillingRecord;
import In.NIT.Entity.Employee;
import In.NIT.Entity.SubscriptionPlan;
import In.NIT.Repo.BillingRecordRepository;
import In.NIT.Repo.EmployeeRepository;
import In.NIT.Repo.SubscriptionPlanRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BillingService {

	private final EmployeeRepository employeeRepository;
    private final SubscriptionPlanRepository planRepository;
    private final BillingRecordRepository billingRepository;

    public List<BillingRecord> generateMonthlyBilling(int monthsUsed) {
        List<Employee> employees = employeeRepository.findAll();
        List<BillingRecord> billingRecords = new ArrayList<>();

        for (Employee employee : employees) {
        	try {
                SubscriptionPlan plan = planRepository.findById(employee.getAssignedPlanId())
                    .orElseThrow(() -> new RuntimeException("Plan not found for employee ID: " + employee.getId()));

                double amount = plan.getPricePerEmployeePerMonth() * monthsUsed;

                BillingRecord record = new BillingRecord(
                    UUID.randomUUID().toString(),
                    employee.getId(),
                    plan.getId(),
                    monthsUsed,
                    amount,
                    LocalDate.now()
                );

                billingRecords.add(record);

            } catch (Exception e) {
                System.err.println("Error processing employee ID: " + employee.getId());
                e.printStackTrace(); // Show full error in terminal
            }
        }
        return billingRepository.saveAll(billingRecords);
    }
}
