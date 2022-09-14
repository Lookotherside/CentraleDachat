package com.centraledachat.demo.Service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centraledachat.demo.Model.Fournisseur;
import com.centraledachat.demo.Model.FournisseurRepository;

import lombok.Data;

@Data
@Service
public class FournisseurService {
	
	@Autowired
	private FournisseurRepository fr;
	
	public Optional<Fournisseur> getFournisseur(final Long id){
		return fr.findById(id);
	}
	
	public Iterable<Fournisseur> getAllFournisseurs(){
		return fr.findAll();
	}
	
	public void deleteFournisseur(final Long id) {
		fr.deleteById(id);
	}
	
	public void insertFournisseur(Fournisseur fournisseur) {
		fr.save(fournisseur);
	}
	
	public Fournisseur editFournisseur(Fournisseur fournisseur) {
		if (fournisseur.getId_Fournisseur() != null && !fr.existsById(fournisseur.getId_Fournisseur())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}
 
		return fr.save(fournisseur);
	}

}
