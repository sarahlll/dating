package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Apparence;
import com.formation.dating.repositories.ApparenceRepository;

@Service
public class ApparenceService {
	private final ApparenceRepository ar;

	@Autowired
	public ApparenceService(ApparenceRepository ar) {
		this.ar = ar;
	}

	public List<Apparence> getAll() {
		return ar.findAll();
	}

	public void add(Apparence a) {
		ar.save(a);
	}

	public void delete(Apparence a) {
		ar.delete(a);
	}

	public Apparence findById(Long id) {
		if (ar.findById(id).isPresent())
			return ar.findById(id).get();
		return null;
	}

	public void update(Apparence a) {
		Optional<Apparence> co = ar.findById(a.getId());
		if (co.isPresent()) {

			ar.save(co.get());
		}

	}

	public void deleteById(Long id) {
		ar.deleteById(id);
	}
}
