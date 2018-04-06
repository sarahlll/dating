package com.formation.dating.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Utilisateur {

	@Id
	private String emailUtilisateur;
	@NotNull
	@Column(length = 50)
	private String nom;
	@NotNull
	@Column(length = 80)
	private String prenom;
	@NotBlank
	@Column(columnDefinition = "date", name = "birthday")
	private String dateDeNaissance;
	@Column(length = 100)
	private String description;
	@Column(name = "phone", length = 10)
	//@Pattern(regexp = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$", message ="{com.formation.dating.constraint.numeroTel.message}")
		private String numeroTel;
	
	private String pseudo;
	private String motDePasse;
	private String sexe;
	
	
	
	

	public Utilisateur(String sexe) {
		super();
		this.sexe = sexe;
	}
	

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	@ManyToMany
	private List<Utilisateur> favoris;
	

	//association
	@ManyToOne  //tjrs joindre @joinColumn
	@JoinColumn(name="adresse")// le name ici est le nom de la colonne de jointure // 
	private Adresse adresse;
	
	@ManyToOne  // many "utilisateur" to one "apparence"
	private Apparence apparence;
    
	@OneToMany
	private List<Photo> photos;
	
	@ManyToMany (mappedBy="utilisateurs")
	private List<CentreInteret> centreInterets;
	
	@ManyToOne
	@JoinColumn (name="situtation")
	private Situation situation;
	
	
	public List<Utilisateur> getFavoris() {
		return favoris;
	}


	public void setFavoris(List<Utilisateur> favoris) {
		this.favoris = favoris;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Apparence getApparence() {
		return apparence;
	}


	public void setApparence(Apparence apparence) {
		this.apparence = apparence;
	}


	public List<Photo> getPhotos() {
		return photos;
	}


	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}


	public List<CentreInteret> getCentreInterets() {
		return centreInterets;
	}


	public void setCentreInterets(List<CentreInteret> centreInterets) {
		this.centreInterets = centreInterets;
	}


	public Situation getSituation() {
		return situation;
	}


	public void setSituation(Situation situation) {
		this.situation = situation;
	}


	public Utilisateur(String emailUtilisateur, String nom, String prenom, String dateDeNaissance, String description,
			String numeroTel,String pseudo, String motDePasse) {
		super();
		this.emailUtilisateur = emailUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.description = description;
		this.numeroTel = numeroTel;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}

	public Utilisateur() {

	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
