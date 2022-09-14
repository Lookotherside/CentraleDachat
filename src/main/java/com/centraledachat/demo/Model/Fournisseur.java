package com.centraledachat.demo.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Fournisseur {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Fournisseur;
	
	private String societe;
	
	private String civilite;
	
	private String Nom;
	
	private String Prenom;
	
	private String Email;
	
	private String Adresse;
	
	private Date DateAdhesion;
	
	private String statut;
	
	private Long Id_Employe;
	
	private String password;

    @Transient
    private String passwordConfirm;
    
    @ManyToMany
    private Set<Role> roles;

	public Fournisseur(String name, String surname, String email2) {
		this.Nom = name;
		this.Prenom = surname;
		this.Email = email2;
	}

	public Fournisseur() {
		// TODO Auto-generated constructor stub
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

	public Date getDateAdhesion() {
		return DateAdhesion;
	}

	public void setDateAdhesion(Date dateAdhesion) {
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
	
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

	public Long getId_Fournisseur() {
		return Id_Fournisseur;
	}

	public void setId_Fournisseur(Long id_Fournisseur) {
		Id_Fournisseur = id_Fournisseur;
	}
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
