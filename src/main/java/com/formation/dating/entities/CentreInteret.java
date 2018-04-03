package com.formation.dating.entities;

import javax.persistence.Entity;

@Entity
public class CentreInteret {

	private Long Id;
	private String fumeur;
	private String alcool;
	private String sport;
	private String loisir;
	
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
