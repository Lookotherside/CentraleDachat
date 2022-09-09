package com.centraledachat.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centraledachat.demo.Model.Employe;

@Controller
public class ProductController {
	
	@RequestMapping(value = { "/video" }, method = RequestMethod.GET)
	public String video(@ModelAttribute("employe") Employe employe,Model model){
		model.addAttribute("titre","Vidéo");
		return ("startbootstrap-sb-admin-2-gh-pages/cards.html");
		
	}
	
	@RequestMapping(value = { "/hifi" }, method = RequestMethod.GET)
	public String hifi(Model model){
		model.addAttribute("employe",new Employe());
		model.addAttribute("titre","Hifi");
		return ("startbootstrap-sb-admin-2-gh-pages/cards.html");
		
	}
	
	@RequestMapping(value = { "/tech" }, method = RequestMethod.GET)
	public String tech(Model model){
		model.addAttribute("employe",new Employe());
		model.addAttribute("titre","Tech");
		return ("startbootstrap-sb-admin-2-gh-pages/cards.html");
		
	}
	
	
}
