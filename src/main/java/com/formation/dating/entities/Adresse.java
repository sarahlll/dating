package com.formation.dating.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@NotBlank
	@Column(name = "codePostale", length = 10)
	private Integer codePostale;
	@NotBlank
	@Column (name = "ville", length = 50)
	private String ville;
	@NotBlank
	@Column (name = "numero", length = 10)
	private Integer numero;
	
	private String complement;
	private String prefixe;
	
	
	//association 
	@OneToMany
	private List<Utilisateur>utilisateur;
	
	
	public Adresse(Long id, Integer codePostale, String ville, Integer numero, String complement, String prefixe) {
		super();
		Id = id;
		this.codePostale = codePostale;
		this.ville = ville;
		this.numero = numero;
		this.complement = complement;
		this.prefixe = prefixe;
	}

	public Adresse() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(Integer codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPrefixe() {
		return prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}
	
	
	
}
