package com.centraledachat.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.centraledachat.demo.Model.Categorie;
import com.centraledachat.demo.Model.Employe;
import com.centraledachat.demo.Model.Produit;
import com.centraledachat.demo.Service.CategorieService;
import com.centraledachat.demo.Service.ProduitService;

@Controller
public class ProductController {
	
	int count = 0;
	 List<Produit> listProduits = new ArrayList<Produit>();
	
	@Autowired
    private ProduitService ps;
	
	@Autowired
	private CategorieService cs;
	
	@RequestMapping(value = { "/video" }, method = RequestMethod.GET)
	public String video(@ModelAttribute("employe") Employe employe,Model model){
		Iterable<Produit> it = ps.getAllProduits();
		model.addAttribute("it", it);
		model.addAttribute("titre","Vidéo");
		model.addAttribute("i",count);
		model.addAttribute("list", listProduits);
		System.out.println(listProduits);
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
	
	@RequestMapping(value = { "/addProduct" }, method = RequestMethod.GET)
	public String video(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("employe") Employe employe,Model model){
		Optional<Produit> product = ps.getProduit(id);
		Produit pr = new Produit(id);
		Long ID = product.get().getId();
		String titre = product.get().getTitre();
		String description = product.get().getDescription();
		String url = product.get().getUrl();
		int cat = product.get().getCategorie();
		pr.setId(ID);
		pr.setTitre(titre);
		pr.setDescription(description);
		pr.setUrl(url);
		pr.setCategorie(cat);
		model.addAttribute("titre","Vidéo");		
		count ++;
		model.addAttribute("i",count);		
		listProduits.add(pr);
		System.out.println(listProduits);
		return ("redirect:/video");
		
	}
	
	
	

	@RequestMapping(value = { "/addProductFournisseur" }, method = RequestMethod.GET)
	public String addProduct(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("employe") Employe employe,Model model){
		
		Iterable<Categorie> it = cs.getAllCategories();
		model.addAttribute("it",it);
		model.addAttribute("userForm", new Produit());
		return ("startbootstrap-sb-admin-2-gh-pages/addProduct.html");
		
	}
	
	@RequestMapping(value = { "/deleteProduct" }, method = RequestMethod.GET)
	public String deleteProduct(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("employe") Employe employe,Model model){
		
		Optional<Produit> product = ps.getProduit(id);
		Produit pr = new Produit(id);
		listProduits.removeIf(t -> t.getId() == id);
		count --;
		return ("redirect:/video");
		
	}
	
	@RequestMapping(value = { "/addProductFournisseur" }, method = RequestMethod.POST)
	public String adProduct(@RequestParam(value = "id", required = false) Long id,@ModelAttribute("userForm") Produit userForm,Model model){
		
		ps.insertProduit(userForm);
		
		return ("redirect:/video");
		
	}
	
	
}
