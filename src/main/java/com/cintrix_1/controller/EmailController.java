package com.cintrix_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cintrix_1.dto.EmailMessage;
import com.cintrix_1.util.EmailService;

@Controller
public class EmailController {
	
	// constructor based dependency injection 
	private EmailService emailService;
	
	public EmailController(EmailService emailService) {
		
		this.emailService = emailService;
	}

	@GetMapping("/sendEmail")
	public String getEmailId(@RequestParam("email") String email, Model model) {
		
		model.addAttribute("email", email);
		
		return "composeEmail";
	}
	
	@PostMapping("/triggerEmail")
	public String sendEmail(EmailMessage email, Model model) {
		
		emailService.sendSimpleEmail(email.getEmail(), email.getSubject(), email.getContent());
		
		model.addAttribute("msg", "Email sent successfully!");
		
		return "composeEmail";
	}
}
