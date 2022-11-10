package com.cintrix_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cintrix_1.dto.PrintBill;
import com.cintrix_1.entities.Billing;
import com.cintrix_1.entities.Contact;
import com.cintrix_1.services.BillingService;
import com.cintrix_1.services.ContactService;
import com.cintrix_1.util.PDFGenerator;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@GetMapping("/generateBill")
	public String showBillingPage(@RequestParam("id") int id, Model model) {
		
		Contact contact = contactService.findContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "generateBill";
	}
	
	@PostMapping("/saveBill")
	public String saveBillingDetails(PrintBill bill, Model model) {
				
			Billing b = new Billing();
			
			b.setFirstName(bill.getFirstName());
			b.setLastName(bill.getLastName());
			b.setEmail(bill.getEmail());
			b.setMobile(bill.getMobile());
			b.setCity(bill.getCity());
			b.setProduct(bill.getProduct());
			b.setQuantity(bill.getQuantity());
			b.setPrice(bill.getPrice());
			
			String filePath = "E:\\PSA SpringBoot Programs\\cintrix_1\\bills\\bill"+"_"+bill.getFirstName()+"_"+bill.getLastName()+".pdf";
			
			billingService.saveBillDetails(b);
			
			pdfGenerator.generateItinerary(bill, filePath);
			
			model.addAttribute("msg", "Bill generated successfully!");
			
			model.addAttribute("bill", b);
			
			return "billingInfo";
	}
	
	@GetMapping("listAllBills")
	public String getAllBills(Model model) {
		
		List<Billing> bills = billingService.findAllBills();
		
		model.addAttribute("bills", bills);
		
		return "listBills";
	}
	
	@GetMapping("/billingInfoPage")
	public String getBillingInfo(@RequestParam("id") int id, Model model) {
		
		Billing bill = billingService.findBillById(id);
		
		model.addAttribute("bill", bill);
		
		return "billingInfo";
	}
	
	@GetMapping("/searchBill")
	public String viewBillingPage() {
		
		return "findBill";
	}
	
	@PostMapping("/getBillingInfo")
	public String getBillingDetails(@RequestParam("mobile") String mobile, Model model) {
		
		Billing bill = billingService.findBillByMobile(mobile);
		
		if(bill != null) {
			
			model.addAttribute("bill", bill);
			
			return "billingInfo";
		}
		else {
			
			model.addAttribute("msg", "No record found!");
			
			return "findBill";
		}
	}
	
//	@GetMapping("/printBill")
//	public String printBillingPage(PrintBill bill, Model model) {
//		
//		String filePath = "E:\\PSA SpringBoot Programs\\cintrix_1\\bills\\bill"+bill.getId()+".pdf";
//		
//		pdfGenerator.generateItinerary(bill, filePath);
//		
//		return "listBills";
//	}
}
