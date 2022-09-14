package com.centraledachat.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.centraledachat.demo.Model.Adherent;
import com.centraledachat.demo.Service.AdherentService;
import com.centraledachat.demo.Service.AdherentValidator;


@Controller
public class AdherentController {
	
	@Autowired
	AdherentService as;
	
	@Autowired
    private AdherentValidator userValidator;
	
	@GetMapping("/adherents")
    public String getAllAdherents(Model model) {
		
		Iterable<Adherent> it = as.getAllAdherents();
        model.addAttribute("it", it);
        model.addAttribute("userForm", new Adherent());

        return "startbootstrap-sb-admin-2-gh-pages/adherents.html";
    }
	
	@GetMapping("/addAdherent")
    public String addAdherent(Model model) {
		model.addAttribute("userForm", new Adherent());

        return "startbootstrap-sb-admin-2-gh-pages/addAdherent.html";
    }
	
	@PostMapping("/addAdherent")
    public String addFAdherents(@ModelAttribute("userForm") Adherent userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
            return "startbootstrap-sb-admin-2-gh-pages/addAdherent.html";
        }
		
		 as.insertAdherent(userForm);
		 Iterable<Adherent> it = as.getAllAdherents();
	        model.addAttribute("it", it);
		
        return "redirect:/adherents";
    }
	
	@GetMapping("/editAdherent")
    public String editAdherent(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Adherent userForm, BindingResult bindingResult, Model model) {
		
		/* Long id_fournisseur = Long.parseUnsignedLong(id); */
		Optional<Adherent> it = as.getAdherent(id);
		System.out.println(it.get().getSociete());
		model.addAttribute("it", it);
		/* model.addAttribute("userForm", new Fournisseur()); */
        return "startbootstrap-sb-admin-2-gh-pages/editAdherent.html";
    }
	
	@PostMapping("/editAdherent")
    public String editAdherents(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Adherent userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
            return "startbootstrap-sb-admin-2-gh-pages/editAdherent.html";
        }
		as.insertAdherent(userForm);
		
        return "redirect:/adherents";
    }
	
	@GetMapping("/deleteAdherent")
    public String deleteAdherent(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Adherent userForm, BindingResult bindingResult, Model model) {
		
		as.deleteAdherent(id);
		
        return "redirect:/adherents";
    }
}
