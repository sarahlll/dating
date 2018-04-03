package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Photo;
import com.formation.dating.repositories.PhotoRepository;

@Service
public class PhotoService {
	private final PhotoRepository photoRepository;

	@Autowired
	public PhotoService(PhotoRepository fr) {
		this.photoRepository = fr;
	}

	// get
	public List<Photo> getAll() {
		return photoRepository.findAll();
	}

	// add
	public void add(Photo f) {
		photoRepository.save(f);
	}

	// delete
	public void delete(Photo f) {
		photoRepository.delete(f);
	}

	// find by Id
	public Photo findById(Long id) {
		if (photoRepository.findById(id).isPresent())
			return photoRepository.findById(id).get();
		return null;
	}

	// update
	public void update(Photo f) {
		Optional<Photo> co = photoRepository.findById(f.getId());
		if (co.isPresent()) {

			photoRepository.save(co.get());
		}

		// delete by Id
	}

	public void deleteById(Long id) {
		photoRepository.deleteById(id);
	}
}