package In.NIT.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import In.NIT.Entity.SubscriptionPlan;

@Repository
public interface SubscriptionPlanRepository extends MongoRepository<SubscriptionPlan, String>{

}
