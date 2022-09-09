package com.centraledachat.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.centraledachat.demo.Model.Adherent;
import com.centraledachat.demo.Model.Employe;
import com.centraledachat.demo.Model.Fournisseur;
import com.centraledachat.demo.Service.AdherentService;
import com.centraledachat.demo.Service.EmployeService;
import com.centraledachat.demo.Service.FournisseurService;

@Controller
public class AuthController {
		
@Autowired
private EmployeService es;

@Autowired
private AdherentService as;

@Autowired
private FournisseurService fs;


@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
public String signUp(Model model){
	model.addAttribute("employe",new Employe());
	return ("startbootstrap-sb-admin-2-gh-pages/adherent_index.html");
	
}



  @RequestMapping(value = { "/signup" }, method = RequestMethod.POST) 
  public String signUpp(@ModelAttribute("employe") Employe employe, Model model){
  
  String password = employe.getMot_de_Passe();
  String name = employe.getNom();
  String surname = employe.getPrenom();
  String repassword = employe.getPasswordConfirm();
  String email = employe.getEmail();
  String role = employe.getRole();
  
   if(role=="fournisseur") {
		 fs.insertFournisseur(new Fournisseur(name,surname,email)); 
  }else if(role=="employe") {
	  es.insertEmploye(new Employe(email,password,name,surname,repassword));
  }else {
		/*
		 * if(password != repassword){
		 * model.addAttribute("titre","passwords do not match"); return
		 * ("startbootstrap-sb-admin-2-gh-pages/blank.html"); }
		 */
	  as.insertAdherent(new Adherent(name,surname,email));
	  return "startbootstrap-sb-admin-2-gh-pages/adherent_index.html";
  }
  
  
	
	 
	  
	  return "startbootstrap-sb-admin-2-gh-pages/index.html";
	 
  
  }
 
	
	
}
