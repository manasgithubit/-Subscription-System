package In.NIT.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import In.NIT.Enums.PlanAssignmentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "subscription_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPlan {

	@Id
    private String id;
    private String name;
    private double pricePerEmployeePerMonth;
    private PlanAssignmentType assignmentType;
}
