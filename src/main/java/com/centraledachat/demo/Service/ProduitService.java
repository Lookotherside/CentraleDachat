package com.centraledachat.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centraledachat.demo.Model.Produit;
import com.centraledachat.demo.Model.ProduitRepository;

import lombok.Data;

@Data
@Service
public class ProduitService {
	
	@Autowired
	private ProduitRepository pr;
	
	
	public Optional<Produit> getProduit(final Long id){
		return pr.findById(id);
	}
	
	public Iterable<Produit> getAllProduits(){
		return pr.findAll();
	}
	
	public void deleteProduit(final Long id) {
		pr.deleteById(id);
	}
	
	public void insertProduit(Produit produit) {
		pr.save(produit);
	}
	
	
}
