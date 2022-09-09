package com.centraledachat.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adherent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Adherent;
	
	private String societe;
	
	private String civilite;
	
	private String Nom;
	
	private String Prenom;
	
	private String Email;
	
	private String Adresse;
	
	private String DateAdhesion;
	
	private String statut;
	
	private Long Id_Employe;

	public Adherent(String name, String surname, String email2) {
		this.Nom = name;
		this.Prenom = surname;
		this.Email = email2;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getDateAdhesion() {
		return DateAdhesion;
	}

	public void setDateAdhesion(String dateAdhesion) {
		DateAdhesion = dateAdhesion;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Long getId_Employe() {
		return Id_Employe;
	}

	public void setId_Employe(Long id_Employe) {
		Id_Employe = id_Employe;
	}
}
