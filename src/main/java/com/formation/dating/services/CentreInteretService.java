package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.CentreInteret;
import com.formation.dating.entities.Multimedia;
import com.formation.dating.repositories.CentreInteretRepository;
import com.formation.dating.repositories.MultimediaRepository;

@Service
public class CentreInteretService {
	private final CentreInteretRepository cir;

	@Autowired
	public CentreInteretService(CentreInteretRepository cir) {
		this.cir = cir;
	}

	public List<CentreInteret> getAll() {
		return cir.findAll();
	}

	public void add(CentreInteret c) {
		cir.save(c);
	}

	public void delete(CentreInteret c) {
		cir.delete(c);
	}

	public CentreInteret findById(Long id) {
		if (cir.findById(id).isPresent())
			return cir.findById(id).get();
		return null;
	}

	public void update(CentreInteret c) {
		Optional<CentreInteret> co = cir.findById(c.getId());
		if (co.isPresent()) {

			cir.save(co.get());
		}

	}

	public void deleteById(Long id) {
		cir.deleteById(id);
	}
}
