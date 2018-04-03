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
	private Integer nbreEnfant;
	private String orientation;

	public Situation(long id, String statutPerso, String statutPro, Integer nbreEnfant, String orientation) {
		super();
		Id = id;
		this.statutPerso = statutPerso;
		this.statutPro = statutPro;
		this.nbreEnfant = nbreEnfant;
		this.orientation = orientation;
	}

	public Situation() {
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
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

	public Integer getNbreEnfant() {
		return nbreEnfant;
	}

	public void setNbreEnfant(Integer nbreEnfant) {
		this.nbreEnfant = nbreEnfant;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

}
