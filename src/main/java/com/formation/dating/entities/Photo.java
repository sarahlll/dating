package com.formation.dating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)	
	private Long Id;
	private Integer note;
	private String lien;

	public Photo(Long id, Integer note, String lien) {
		super();
		Id = id;
		this.note = note;
		this.lien = lien;
	}

	public Photo() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

}
