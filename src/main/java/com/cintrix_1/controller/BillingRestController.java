package com.cintrix_1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cintrix_1.entities.Billing;
import com.cintrix_1.repositories.BillingRepository;

@RestController
@RequestMapping("/api/billings/")
public class BillingRestController {
	
	@Autowired
	private BillingRepository billingRepo;
	
	// http://localhost:8083/Cintrix/api/billings/bills

	@GetMapping("/bills")
	public List<Billing> getAllBills() {
		
		List<Billing> bills = billingRepo. findAll();
		
		return bills;
	}
	
	@PostMapping("/bills")
	public void saveBill(@RequestBody Billing b) {
		
		billingRepo.save(b);
	}
	
	@PutMapping("/bills")
	public void updateBill(@RequestBody Billing b) {
		
		billingRepo.save(b);
	}
	
	@DeleteMapping("/bills/delete/{id}")
	public void deleteBill(@PathVariable("id") int id) {
		
		billingRepo.deleteById(id);
	}
	
	// http://localhost:8083/Cintrix/api/billings/bills/2
	
	@GetMapping("/bills/{id}")
	public Billing getBillingInfo(@PathVariable("id") int id) {
		
		Optional<Billing> bills = billingRepo.findById(id);

		Billing bill = bills.get();
		
		return bill;
	}
}
