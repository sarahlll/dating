package com.formation.dating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Apparence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotNull            
	private Integer taille;
	@NotNull
	private String couleurYeux;
	@NotNull
	private String origine;
	@NotNull
	private String couleurCheveux;
	private String typeCheveux;
	@NotNull
	private float masse;
	
	//@OneToMany
	/*private List<Utilisateur>utilisateurs;*/ //pas la peine d'avoir une 3eme table // on fait juste de l'unidirectionnelle
	
	public Apparence(Long id, Integer taille, String couleurYeux, String origine, String couleurCheveux,
			String typeCheveux, float masse) {
		super();
		Id = id;
		this.taille = taille;
		this.couleurYeux = couleurYeux;
		this.origine = origine;
		this.couleurCheveux = couleurCheveux;
		this.typeCheveux = typeCheveux;
		this.masse = masse;
	}

	public Apparence() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getTaille() {
		return taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public String getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getCouleurCheveux() {
		return couleurCheveux;
	}

	public void setCouleurCheveux(String couleurCheveux) {
		this.couleurCheveux = couleurCheveux;
	}

	public String getTypeCheveux() {
		return typeCheveux;
	}

	public void setTypeCheveux(String typeCheveux) {
		this.typeCheveux = typeCheveux;
	}

	public float getMasse() {
		return masse;
	}

	public void setMasse(float masse) {
		this.masse = masse;
	}

	
	
}
