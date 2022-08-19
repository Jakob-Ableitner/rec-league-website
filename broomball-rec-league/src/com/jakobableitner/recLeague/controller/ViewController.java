package com.jakobableitner.recLeague.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class ViewController {
		
		@GetMapping("/home")
		public String home(Model theModel) {
			
			return "home_page";
		}
}
