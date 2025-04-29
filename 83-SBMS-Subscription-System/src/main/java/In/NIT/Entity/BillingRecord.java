package In.NIT.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "billing_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingRecord {

	@Id
    private String id;
    private String employeeId;
    private String planId;
    private int monthsUsed;
    private double totalAmount;
    private LocalDate billingDate;
}
