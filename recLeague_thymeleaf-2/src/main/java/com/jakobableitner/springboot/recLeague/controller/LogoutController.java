package com.jakobableitner.springboot.recLeague.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	// create a mapping for "/hello"
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}








