package In.NIT.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import In.NIT.Entity.SubscriptionPlan;
import In.NIT.Repo.SubscriptionPlanRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanService {

	private final SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlan createPlan(SubscriptionPlan plan) {
        return subscriptionPlanRepository.save(plan);
    }

    public List<SubscriptionPlan> getAllPlans() {
        return subscriptionPlanRepository.findAll();
    }

    public SubscriptionPlan getPlanById(String id) {
        return subscriptionPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found with ID: " + id));
    }

    public SubscriptionPlan updatePlan(String id, SubscriptionPlan updatedPlan) {
        SubscriptionPlan existing = getPlanById(id);
        existing.setName(updatedPlan.getName());
        existing.setPricePerEmployeePerMonth(updatedPlan.getPricePerEmployeePerMonth());
        existing.setAssignmentType(updatedPlan.getAssignmentType());
        return subscriptionPlanRepository.save(existing);
    }

    public void deletePlan(String id) {
        subscriptionPlanRepository.deleteById(id);
    }
}
