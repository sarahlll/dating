package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Multimedia;
import com.formation.dating.repositories.MultimediaRepository;

@Service
public class MultimediaService {
	private final MultimediaRepository mr;

	@Autowired
	public MultimediaService(MultimediaRepository mr) {
		this.mr = mr;
	}

	public List<Multimedia> getAll() {
		return mr.findAll();
	}

	public void add(Multimedia c) {
		mr.save(c);
	}

	public void delete(Multimedia c) {
		mr.delete(c);
	}

	public Multimedia findById(Long id) {
		if (mr.findById(id).isPresent())
			return mr.findById(id).get();
		return null;
	}

	public void update(Multimedia c) {
		Optional<Multimedia> co = mr.findById(c.getId());
		if (co.isPresent()) {

			mr.save(co.get());
		}

	}

	public void deleteById(Long id) {
		mr.deleteById(id);
	}
}
