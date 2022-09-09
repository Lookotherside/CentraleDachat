package com.centraledachat.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centraledachat.demo.Model.BlogRepository;
import com.centraledachat.demo.Model.Employe;


@Controller
public class HomeController {
	
	
	
	
	@Autowired
	private BlogRepository br;
	
	/*
	 * @RequestMapping(value = { "/" }, method = RequestMethod.GET) public String
	 * getHome(Model model){
	 * 
	 * model.addAttribute("employe",new Employe()); return
	 * ("startbootstrap-sb-admin-2-gh-pages/register.html");
	 * 
	 * }
	 */
	
	
}