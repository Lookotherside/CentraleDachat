package com.centraledachat.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centraledachat.demo.Model.Adherent;
import com.centraledachat.demo.Model.AdherentRepository;
import lombok.Data;

@Data
@Service
public class AdherentService {
	
	@Autowired
	private AdherentRepository ar;
	
	public Optional<Adherent> getAdherent(final Long id){
		return ar.findById(id);
	}
	
	public Iterable<Adherent> getAllAdherents(){
		return ar.findAll();
	}
	
	public void deleteAdherent(final Long id) {
		ar.deleteById(id);
	}
	
	public void insertAdherent(Adherent adherent) {
		ar.save(adherent);
	}

}
