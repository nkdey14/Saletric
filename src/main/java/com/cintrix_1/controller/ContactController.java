package com.cintrix_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cintrix_1.entities.Contact;
import com.cintrix_1.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/listAllContacts")
	public String getAllContacts(Model model) {
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
	
	@GetMapping("/contactInfoPage")
	public String showContactDetails(@RequestParam("id") int id, Model model) {
		
		Contact contact = contactService.findContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "contactInfo";
	}
	
	@GetMapping("/updateContact")
	public String getContactInfo(@RequestParam("id") int id, Model model) {
		
		Contact contact = contactService.findContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "updateContact";
	}
	
	@PostMapping("/updateContactInfo")
	public String updateContactDetails(@ModelAttribute("contact") Contact c, Model model) {
		
		contactService.saveContact(c);
		
		model.addAttribute("msg", "Contact updated successfully!");
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
	
	@GetMapping("/searchContact")
	public String viewSearchPage() {
		
		return "findContact";
	}
	
	@PostMapping("/getContactInfo")
	public String getContactDetails(@RequestParam("mobile") long mobile, Model model) {
		
		Contact contact = contactService.findContactByMobile(mobile);
		
		if(contact != null) {
			
			model.addAttribute("contact", contact);
			
			return "contactInfo";
		}else {
			
			model.addAttribute("msg", "No record found!");
			
			return "findContact";
		}
	}
}
