package com.formation.dating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.formation.dating.entities.Utilisateur;
import com.formation.dating.services.UtilisateurService;

@Controller
public class ControllerDating {
	
	private final UtilisateurService us;
	
	@Autowired
	public ControllerDating(UtilisateurService us) {
		super();
		this.us = us;
	}
	
	@GetMapping(value="/formulaire") //Juste le Root(URL)
	public ModelAndView inscription() {
		ModelAndView mav=new ModelAndView("formulaire.html");//l'html qui sera affichée
		
		mav.addObject("utilisateur", new Utilisateur());
		
		return mav;
		
	}
	
	}
	
	




	/*@GetMapping(value = "/") // arrivé à la racine de mon projet
	public ModelAndView index() { // creer une methode qui nous retourne notre index.html
		return new ModelAndView("index.html");
	}*/

