package com.centraledachat.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_Employe;
	
	private String Nom;

    private String Prenom;
    
    private String Email;
    
    private String Mot_de_Passe;
    
  
    private String passwordConfirm;
    
    private String role;
    
	/*
	 * @ManyToMany private Set<Role> roles;
	 */
    
    
    public Employe(String email2, String password, String name, String surname, String repassword) {
		this.Email = email2;
		this.Mot_de_Passe = password;
		this.Nom = name;
		this.Prenom = surname;
		this.passwordConfirm = repassword;
	}

	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
        return id_Employe;
    }

    public void setId(Long id) {
        this.id_Employe = id;
    }

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getMot_de_Passe() {
		return Mot_de_Passe;
	}

	public void setMot_de_Passe(String mot_de_Passe) {
		this.Mot_de_Passe = mot_de_Passe;
	}
	
	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	/*
	 * public Set<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<Role> roles) { this.roles = roles; }
	 */

}
