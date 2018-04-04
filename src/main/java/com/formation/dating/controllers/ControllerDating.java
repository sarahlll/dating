package com.formation.dating.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.formation.dating.entities.Adresse;
import com.formation.dating.entities.Apparence;
import com.formation.dating.entities.CentreInteret;
import com.formation.dating.entities.Multimedia;
import com.formation.dating.entities.Photo;
import com.formation.dating.entities.Situation;
import com.formation.dating.entities.Utilisateur;
import com.formation.dating.enums.CouleurCheveux;
import com.formation.dating.enums.CouleursYeux;
import com.formation.dating.enums.Fumeur;
import com.formation.dating.enums.Genre;
import com.formation.dating.enums.Orientation;
import com.formation.dating.enums.Origine;
import com.formation.dating.enums.Prefixe;
import com.formation.dating.enums.SituationPro;
import com.formation.dating.enums.TypeCheveux;
import com.formation.dating.enums.TypeMultimedia;
import com.formation.dating.enums.TypeRue;
import com.formation.dating.services.UtilisateurService;

import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget.OriginTypeResolver;

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
		mav.addObject("adresse", new Adresse());
		mav.addObject("situation", new Situation());
		mav.addObject("apparence", new Apparence());
		mav.addObject("photo", new Photo());
		mav.addObject("CentreInterert", new CentreInteret());
		mav.addObject("multimedia", new Multimedia());
		//rajouter les enums
		mav.addObject("couleurCheveux", CouleurCheveux.values());
		mav.addObject("couleursYeux", CouleursYeux.values());
		mav.addObject("fumeur", Fumeur.values());
		mav.addObject("genre", Genre.values());
		mav.addObject("orientation", Orientation.values());
		mav.addObject("origine", Origine.values());
		mav.addObject("prefixe", Prefixe.values());
		mav.addObject("situationPro", SituationPro.values());
		mav.addObject("typeCheveux", TypeCheveux.values());
		mav.addObject("typeMultimedia", TypeMultimedia.values());
		mav.addObject("typeRue", TypeRue.values());
		
		return mav;
		
/*	@PostMapping(value="/formulaire")
	public ModelAndView add(Utilisateur utilisateur) {
		us.add(utilisateur);                                    // us:utilisateurService
		return new ModelAndView("connexion.html".)
	}*/
		
	}

}

/*
 * @GetMapping(value = "/") // arrivé à la racine de mon projet public
 * ModelAndView index() { // creer une methode qui nous retourne notre
 * index.html return new ModelAndView("index.html"); }
 */
