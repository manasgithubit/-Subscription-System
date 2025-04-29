package In.NIT.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import In.NIT.Entity.BillingRecord;
import In.NIT.Service.BillingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/billing")
@RequiredArgsConstructor
public class BillingController {

	private final BillingService billingService;

    @PostMapping
    public ResponseEntity<List<BillingRecord>> generateBilling(@RequestParam int monthsUsed) {
    	List<BillingRecord> billingRecords = billingService.generateMonthlyBilling(monthsUsed);
        return ResponseEntity.ok(billingRecords);
    }
}
