package In.NIT.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import In.NIT.Entity.BillingRecord;

@Repository
public interface BillingRecordRepository extends MongoRepository<BillingRecord, String>{

}
