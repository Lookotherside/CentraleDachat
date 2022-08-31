package com.centraledachat.demo.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	
	
@GetMapping("/")
public String getHome(Model model){
	model.addAttribute("Blog", "just a text");
	return "index";
	
}
	
	
}