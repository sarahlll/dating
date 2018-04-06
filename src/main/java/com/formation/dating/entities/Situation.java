package com.formation.dating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Situation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String statutPerso;
	private String statutPro;
	private String nbreEnfant;
	private String orientation;

	public Situation( String statutPerso, String statutPro, String nbreEnfant, String orientation) {
		super();
		
		this.statutPerso = statutPerso;
		this.statutPro = statutPro;
		this.nbreEnfant = nbreEnfant;
		this.orientation = orientation;
	}

	public Situation() {
	}

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getStatutPerso() {
		return statutPerso;
	}

	public void setStatutPerso(String statutPerso) {
		this.statutPerso = statutPerso;
	}

	public String getStatutPro() {
		return statutPro;
	}

	public void setStatutPro(String statutPro) {
		this.statutPro = statutPro;
	}

	public String getNbreEnfant() {
		return nbreEnfant;
	}

	public void setNbreEnfant(String nbreEnfant) {
		this.nbreEnfant = nbreEnfant;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

}
