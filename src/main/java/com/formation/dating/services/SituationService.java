package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Situation;

import com.formation.dating.repositories.SituationRepository;

@Service
public class SituationService {
	private final SituationRepository situationRepository;

	@Autowired
	public SituationService(SituationRepository sr) {
		this.situationRepository = sr;
	}

	// get
	public List<Situation> getAll() {
		return situationRepository.findAll();
	}

	// add
	public void add(Situation s) {
		situationRepository.save(s);
	}

	// delete
	public void delete(Situation s) {
		situationRepository.delete(s);
	}

	// find by Id
	public Situation findById(Long id) {
		if (situationRepository.findById(id).isPresent())
			return situationRepository.findById(id).get();
		return null;
	}

	// update
	public void update(Situation s) {
		Optional<Situation> co = situationRepository.findById(s.getId());
		if (co.isPresent()) {

			situationRepository.save(co.get());
		}

		// delete by Id
	}

	public void deleteById(Long id) {
		situationRepository.deleteById(id);
	}
}