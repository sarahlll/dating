package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Adresse;
import com.formation.dating.repositories.AdresseRepository;

@Service
public class AdresseService {
	private final AdresseRepository ar;

	@Autowired
	public AdresseService(AdresseRepository ar) {
		this.ar = ar;
	}

	public List<Adresse> getAll() {
		return ar.findAll();
	}

	public void add(Adresse a) {
		ar.save(a);
	}

	public void delete(Adresse a) {
		ar.delete(a);
	}

	public Adresse findById(Long id) {
		if (ar.findById(id).isPresent())
			return ar.findById(id).get();
		return null;
	}

	public void update(Adresse a) {
		Optional<Adresse> co = ar.findById(a.getId());
		if (co.isPresent()) {

			ar.save(co.get());
		}

	}

	public void deleteById(Long id) {
		ar.deleteById(id);
	}
}
