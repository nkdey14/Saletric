package com.cintrix_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cintrix_1.dto.LeadData;
import com.cintrix_1.entities.Contact;
import com.cintrix_1.entities.Lead;
import com.cintrix_1.services.ContactService;
import com.cintrix_1.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/viewLeadPage")
	public String viewNewLeadPage() {
		
		return "newLead";
	}

	@PostMapping("/saveLead")
	public String saveLeadDetails(LeadData data, Model model) {
		
		Lead l = new Lead();
		
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		l.setCity(data.getCity());
		l.setSource(data.getSource());
		
		leadService.saveLead(l);
		
		model.addAttribute("msg", "Lead saved successfully!");
		
		model.addAttribute("lead", l);
		
		return "leadInfo";
	}
	
	@GetMapping("/listAllLeads")
	public String getAllLeads(Model model) {
		
		List<Lead> leads = leadService.findAllLeads();
		
		model.addAttribute("leads", leads);
		
		return "listLeads";
	}
	
	@GetMapping("/updateLead")
	public String updateLeadData(@RequestParam("id") int id, Model model) {
		
		Lead lead = leadService.findLeadById(id);
		
		model.addAttribute("lead", lead);
		
		return "updateLead";
	}
	
	@PostMapping("/updateLeadInfo")
	public String updateLeadDetails(@ModelAttribute("lead") Lead l, Model model) {
		
		leadService.saveLead(l);
		
		model.addAttribute("msg", "Lead details updated successfully!");
		
		List<Lead> leads = leadService.findAllLeads();
		
		model.addAttribute("leads", leads);
		
		return "listLeads";
	}
	
	@GetMapping("/deleteLead")
	public String deleteLeadData(@RequestParam("id") int id, Model model) {
		
		leadService.deleteLead(id);
		
		model.addAttribute("msg", "Lead details deleted successfully!");
		
		List<Lead> leads = leadService.findAllLeads();
		
		model.addAttribute("leads", leads);
		
		return "listLeads";
	}
	
	@GetMapping("/convertLead")
	public String convertLeadDetails(@RequestParam("id") int id, Model model) {
		
		Lead lead = leadService.findLeadById(id);
		
		Contact c = new Contact();
		
		c.setFirstName(lead.getFirstName());
		c.setLastName(lead.getLastName());
		c.setEmail(lead.getEmail());
		c.setMobile(lead.getMobile());
		c.setCity(lead.getCity());
		c.setSource(lead.getSource());
		
		contactService.saveContact(c);
		
		leadService.deleteLead(id);
		
		model.addAttribute("msg", "Contact saved successfully!");
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
	
	@GetMapping("/leadInfoPage")
	public String showLeadDetails(@RequestParam("id") int id, Model model) {
		
		Lead lead = leadService.findLeadById(id);
		
		model.addAttribute("lead", lead);
		
		return "leadInfo";
	}
}
