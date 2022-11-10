package com.cintrix_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cintrix_1.entities.User;
import com.cintrix_1.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// http://localhost:8083/Cintrix/
	
//	@RequestMapping("/showIndex")
//	public String showIndexPage() {
//		
//		return "welcome";
//	}
	
	@RequestMapping("/showReg")
	public String showRegistration() {
		
		return "userReg";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		
		return "login";
	}
	
	// http://localhost:8083/Cintrix/saveReg
	@PostMapping("/saveReg")
	public String registerUser(@ModelAttribute("user") User u, Model model) {
		
		userService.saveUser(u);
		
		model.addAttribute("msg", "User Registration Successful!");
		
		return "login";
	}

	@PostMapping("/verifyLogin")
	public String verifyCredentials(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {

		User user = userService.findByUserEmail(email);
		
		if(user != null) {
			
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				
				model.addAttribute("msg", "Login successful!");
				
				return "newLead";
			}
			else {
				
				model.addAttribute("msg", "Invalid username or password!");
				
				return "login";
			}
		}
		else {
			
			model.addAttribute("msg", "Invalid username or password!");
			
			return "login";
		}
	}
}
