package com.formation.dating.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.formation.dating.entities.Adresse;
import com.formation.dating.entities.Apparence;
import com.formation.dating.entities.CentreInteret;
import com.formation.dating.entities.Multimedia;
import com.formation.dating.entities.Photo;
import com.formation.dating.entities.Situation;
import com.formation.dating.entities.Utilisateur;
import com.formation.dating.enums.Alcool;
import com.formation.dating.enums.CouleurCheveux;
import com.formation.dating.enums.CouleurYeux;
import com.formation.dating.enums.Fumeur;
import com.formation.dating.enums.Genre;
import com.formation.dating.enums.NbreEnfant;
import com.formation.dating.enums.Orientation;
import com.formation.dating.enums.Origine;
import com.formation.dating.enums.Prefixe;
import com.formation.dating.enums.Sexe;
import com.formation.dating.enums.Sport;
import com.formation.dating.enums.StatutPerso;
import com.formation.dating.enums.StatutPro;
import com.formation.dating.enums.TypeCheveux;
import com.formation.dating.enums.TypeMultimedia;
import com.formation.dating.enums.TypeRue;
import com.formation.dating.services.AdresseService;
import com.formation.dating.services.ApparenceService;
import com.formation.dating.services.CentreInteretService;
import com.formation.dating.services.MultimediaService;
import com.formation.dating.services.PhotoService;
import com.formation.dating.services.SituationService;
import com.formation.dating.services.UtilisateurService;

@Controller
public class ControllerDating {
	// on déclare tout nos service
	private final UtilisateurService us;
	private final SituationService ss;
	private final PhotoService ps;
	private final MultimediaService ms;
	private final CentreInteretService cs;
	private final ApparenceService as;
	private final AdresseService ads;

	@Autowired

	public ControllerDating(UtilisateurService us, SituationService ss, PhotoService ps, MultimediaService ms,
			CentreInteretService cs, ApparenceService as, AdresseService ads) {
		super();
		this.us = us;
		this.ss = ss;
		this.ps = ps;
		this.ms = ms;
		this.cs = cs;
		this.as = as;
		this.ads = ads;

	}

	@GetMapping(value = "/formulaire") // Juste le Root(URL)
	public ModelAndView inscription() {
		ModelAndView mav = new ModelAndView("formulaire.html");// l'html qui sera affichée
		mav.addObject("utilisateur", new Utilisateur());
		
		
		mav.addObject("adresse", new Adresse());
		mav.addObject("situation", new Situation());
		mav.addObject("apparence", new Apparence());
		mav.addObject("photo", new Photo());
		mav.addObject("centreInteret", new CentreInteret());
		mav.addObject("multimedia", new Multimedia());

		// rajout des enums
		mav.addObject("couleurCheveux", CouleurCheveux.values());
		mav.addObject("couleurYeux", CouleurYeux.values());
		mav.addObject("fumeur", Fumeur.values());
		mav.addObject("genre", Genre.values());
		mav.addObject("orientation", Orientation.values());
		mav.addObject("origine", Origine.values());
		mav.addObject("prefixe", Prefixe.values());
		mav.addObject("statutPerso", StatutPerso.values());
		mav.addObject("statutPro", StatutPro.values());
		mav.addObject("typeCheveux", TypeCheveux.values());
		mav.addObject("typeMultimedia", TypeMultimedia.values());
		mav.addObject("typeRue", TypeRue.values());
		mav.addObject("sport", Sport.values());
		mav.addObject("sexe", Sexe.values());
		mav.addObject("nbreEnfant", NbreEnfant.values());
		mav.addObject("alcool", Alcool.values());

		return mav;
	}

	@PostMapping(value = "/formulaire") // url
	public ModelAndView add(@Valid @ModelAttribute(value = "utilisateur") Utilisateur utilisateur,
			BindingResult utilisateurResult, @Valid @ModelAttribute(value = "adresse") Adresse adresse,
			BindingResult adresseResult, @Valid @ModelAttribute(value = "situation") Situation situation,
			BindingResult situationResult, @Valid @ModelAttribute(value = "apparence") Apparence apparence,
			BindingResult apparenceResult, @Valid @ModelAttribute(value = "photo") Photo photo,
			BindingResult photoResult, @Valid @ModelAttribute(value = "multimedia") Multimedia multimedia,
			BindingResult mediaResult, @Valid @ModelAttribute(value = "centreInteret") CentreInteret centreInteret,
			BindingResult ciResult) {
		
		// System.out.println(adresse.toString());
		
		if (utilisateurResult.hasErrors() || adresseResult.hasErrors() || situationResult.hasErrors()
				|| apparenceResult.hasErrors() || photoResult.hasErrors() || mediaResult.hasErrors()
				|| ciResult.hasErrors()) {
			// rajout des enums
			return new ModelAndView("formulaire").addObject("couleurCheveux", CouleurCheveux.values())
					.addObject("couleurYeux", CouleurYeux.values()).addObject("fumeur", Fumeur.values())
					.addObject("genre", Genre.values()).addObject("orientation", Orientation.values())
					.addObject("origine", Origine.values()).addObject("prefixe", Prefixe.values())
					.addObject("statutPerso", StatutPerso.values()).addObject("statutPro", StatutPro.values())
					.addObject("typeCheveux", TypeCheveux.values()).addObject("typeMultimedia", TypeMultimedia.values())
					.addObject("typeRue", TypeRue.values()).addObject("sport", Sport.values())
					.addObject("sexe", Sexe.values()).addObject("nbreEnfant", NbreEnfant.values())
					.addObject("alcool", Alcool.values());
		}

		ads.add(adresse);
		ss.add(situation);
		as.add(apparence);
		ps.add(photo);
		ms.add(multimedia);

		utilisateur.setAdresse(adresse);
		utilisateur.setApparence(apparence);

		List<Multimedia> medias = new ArrayList<Multimedia>();
		medias.add(multimedia);

		centreInteret.setMultimedias(medias);
		cs.add(centreInteret);

		List<Photo> photos = new ArrayList<Photo>();
		photos.add(photo);

		utilisateur.setPhotos(photos);
		us.add(utilisateur); // add dans ma BDD
		return new ModelAndView("connexion.html").addObject("utilisateur", utilisateur);
	}

	
	
	// Mapping
	@GetMapping(value = "/connexion")
	public String afficherConnexion(ModelMap modelmap) {

		modelmap.addAttribute("utilisateur", new Utilisateur());

		return "login";// lorsque on met url "/connexion" on ns retourne "login

	}

	@PostMapping(value = "/connexion")
	public String verifConnexion(@ModelAttribute(value = "utilisateur") Utilisateur utilisateur,
			HttpSession httpsession) {
		System.out.println(utilisateur.getEmailUtilisateur() + utilisateur.getMotDePasse());
		Utilisateur utilisateur2 = us.findUtilisateurByEmailUtilisateurAndMotDePasse(utilisateur.getEmailUtilisateur(),
				utilisateur.getMotDePasse());
		// System.out.println(utilisateur2.getEmailUtilisateur()+utilisateur2.getMotDePasse());

		if (utilisateur2 == null) {
			return "redirect:/connexion";
		} else {
			session(httpsession, utilisateur2);
			return "welcome";
		}

	}

	// ajout session
	public void session(HttpSession httpSession, Utilisateur utilisateur) {
		String sessionKey = "dating";

		Object time = httpSession.getAttribute(sessionKey);
		if (time == null) {
			time = LocalDateTime.now();
			httpSession.setAttribute("sessionKey", time);
		}
		httpSession.setAttribute("email", utilisateur.getEmailUtilisateur());
		httpSession.setAttribute("name", sessionKey);
		httpSession.setAttribute("pseudo", utilisateur.getPseudo());
		httpSession.setMaxInactiveInterval(60 * 30);

	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "index";
	}
}

/*
 * @GetMapping(value = "/") // arrivé à la racine de mon projet public
 * ModelAndView index() { // creer une methode qui nous retourne notre
 * index.html return new ModelAndView("index.html"); }
 */
