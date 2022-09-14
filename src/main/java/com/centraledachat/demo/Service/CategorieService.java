package com.centraledachat.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centraledachat.demo.Model.Categorie;
import com.centraledachat.demo.Model.CategorieRepository;
import lombok.Data;

@Data
@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository er;
	
	public Optional<Categorie> getCategorie(final Long id){
		return er.findById(id);
	}
	
	public Iterable<Categorie> getAllCategories(){
		return er.findAll();
	}
	
	public void deleteCategorie(final Long id) {
		er.deleteById(id);
	}
	
	public void insertCategorie(Categorie categorie) {
		er.save(categorie);
	}
}
