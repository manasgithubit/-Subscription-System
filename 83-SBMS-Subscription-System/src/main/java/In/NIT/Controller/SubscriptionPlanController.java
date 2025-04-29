package In.NIT.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import In.NIT.Entity.SubscriptionPlan;
import In.NIT.Service.SubscriptionPlanService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class SubscriptionPlanController {

	private final SubscriptionPlanService subscriptionPlanService;

    @PostMapping
    public ResponseEntity<SubscriptionPlan> create(@RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(subscriptionPlanService.createPlan(plan));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionPlan>> getAll() {
        return ResponseEntity.ok(subscriptionPlanService.getAllPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> getById(@PathVariable String id) {
        return ResponseEntity.ok(subscriptionPlanService.getPlanById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> update(@PathVariable String id, @RequestBody SubscriptionPlan plan) {
        return ResponseEntity.ok(subscriptionPlanService.updatePlan(id, plan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        subscriptionPlanService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
