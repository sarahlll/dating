package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Utilisateur;
import com.formation.dating.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	private final UtilisateurRepository ur;
	
	@Autowired
	public UtilisateurService(UtilisateurRepository ur)
	{
		this.ur=ur;
	}
	//get
	public List<Utilisateur> getAll() {
		return ur.findAll();
	}
	//add
	public void add(Utilisateur c) {
		ur.save(c);
	}
	//delete
	public void delete(Utilisateur c) {
		ur.delete(c);
	}
	//find by Id
	public Utilisateur findById(String id) {
		if (ur.findById(id).isPresent())
			return ur.findById(id).get();
		return null;
	}
	//update
	public void update(Utilisateur user) {
		Optional<Utilisateur> co = ur.findById(user.getEmailUtilisateur());		
		if (co.isPresent()) {
			
			ur.save(co.get());
		}
	
	//delete by Id
	}
	public void deleteById(String id)
	{
		ur.deleteById(id);
	}
	public Utilisateur findUtilisateurByEmailUtilisateurAndMotDePasse (String emailUtilisateur, String MotDePasse )
	{
	return	ur.findUtilisateurByEmailUtilisateurAndMotDePasse(emailUtilisateur, MotDePasse);
	}
	public  Utilisateur findUtilisateurByEmail(String emailUtilisateur) {
		
		return 	ur.findUtilisateurByEmailUtilisateur(emailUtilisateur);
	}
}
