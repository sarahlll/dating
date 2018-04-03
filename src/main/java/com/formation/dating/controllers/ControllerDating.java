package com.formation.dating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerDating {
	@GetMapping(value = "/") // arrivé à la racine de mon projet
	public ModelAndView index() { // creer une methode qui nous retourne notre index.html
		return new ModelAndView("index.html");
	}
}
