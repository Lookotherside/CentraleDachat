package com.centraledachat.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centraledachat.demo.Model.Employe;
import com.centraledachat.demo.Model.EmployeRepository;

import lombok.Data;

@Data
@Service
public class EmployeService {
	
	@Autowired
	private EmployeRepository er;
	
	public Optional<Employe> getEmploye(final Long id){
		return er.findById(id);
	}
	
	public Iterable<Employe> getAllEmployes(){
		return er.findAll();
	}
	
	public void deleteEmploye(final Long id) {
		er.deleteById(id);
	}
	
	public void insertEmploye(Employe employe) {
		er.save(employe);
	}
}
