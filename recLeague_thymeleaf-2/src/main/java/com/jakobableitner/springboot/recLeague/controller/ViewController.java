package com.jakobableitner.springboot.recLeague.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {
  @GetMapping("/admin/home")
  public String getHomePage () {
    return "home/homepage";
  }
  
  @GetMapping("/login")
  public String login () {
    return "home/login";
  }
  
}
