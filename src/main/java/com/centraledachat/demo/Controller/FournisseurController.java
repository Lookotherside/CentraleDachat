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

import com.centraledachat.demo.Model.Fournisseur;
import com.centraledachat.demo.Model.User;
import com.centraledachat.demo.Service.FournisseurService;
import com.centraledachat.demo.Service.FournisseurValidator;

@Controller
public class FournisseurController {
	
	@Autowired
    private FournisseurValidator userValidator;
	
	@Autowired
    private FournisseurService fs;
	
	@GetMapping("/fournisseurs")
    public String getAllFournisseurs(Model model) {
		
		Iterable<Fournisseur> it = fs.getAllFournisseurs();
        model.addAttribute("it", it);
        model.addAttribute("userForm", new User());

        return "startbootstrap-sb-admin-2-gh-pages/tables.html";
    }
	
	@GetMapping("/addFournisseur")
    public String addFournisseur(Model model) {
		model.addAttribute("userForm", new Fournisseur());

        return "startbootstrap-sb-admin-2-gh-pages/addFournisseur.html";
    }
	
	@PostMapping("/addFournisseur")
    public String addFournisseurs(@ModelAttribute("userForm") Fournisseur userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
            return "startbootstrap-sb-admin-2-gh-pages/addFournisseur.html";
        }
		
		 fs.insertFournisseur(userForm);
		 Iterable<Fournisseur> it = fs.getAllFournisseurs();
	        model.addAttribute("it", it);
		
        return "redirect:/fournisseurs";
    }
	
	@GetMapping("/editFournisseur")
    public String editFournisseur(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Fournisseur userForm, BindingResult bindingResult, Model model) {
		
		/* Long id_fournisseur = Long.parseUnsignedLong(id); */
		Optional<Fournisseur> it = fs.getFournisseur(id);
		System.out.println(it.get().getSociete());
		model.addAttribute("it", it);
		/* model.addAttribute("userForm", new Fournisseur()); */
        return "startbootstrap-sb-admin-2-gh-pages/editFournisseur.html";
    }
	
	@PostMapping("/editFournisseur")
    public String editFournisseurs(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Fournisseur userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if (bindingResult.hasErrors()) {
            return "startbootstrap-sb-admin-2-gh-pages/addFournisseur.html";
        }
		fs.editFournisseur(userForm);
		
        return "redirect:/fournisseurs";
    }
	
	@GetMapping("/deleteFournisseur")
    public String deleteFournisseurs(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Fournisseur userForm, BindingResult bindingResult, Model model) {
		
		fs.deleteFournisseur(id);
		
        return "redirect:/fournisseurs";
    }
	
}



