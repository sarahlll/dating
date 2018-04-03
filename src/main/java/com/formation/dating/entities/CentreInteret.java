package com.formation.dating.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class CentreInteret {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotNull
	private String fumeur;
	@NotNull
	private String alcool;
	@NotNull
	private String sport;
	@NotNull
	private String loisir;

	@ManyToMany(mappedBy = "centresinterets") // mapper avec le nom de l'objet corresondant (Voir dans "Multimedia")
	private List<Multimedia> multimedias;

	@ManyToMany
	private List<Utilisateur> utilisateurs;

	public CentreInteret(Long id, String fumeur, String alcool, String sport, String loisir) {
		super();
		Id = id;
		this.fumeur = fumeur;
		this.alcool = alcool;
		this.sport = sport;
		this.loisir = loisir;
	}

	public CentreInteret() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFumeur() {
		return fumeur;
	}

	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	public String getAlcool() {
		return alcool;
	}

	public void setAlcool(String alcool) {
		this.alcool = alcool;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getLoisir() {
		return loisir;
	}

	public void setLoisir(String loisir) {
		this.loisir = loisir;
	}

}
