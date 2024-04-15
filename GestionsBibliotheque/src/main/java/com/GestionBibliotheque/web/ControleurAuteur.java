package com.GestionBibliotheque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GestionBibliotheque.dao.AuteurDao;
import com.GestionBibliotheque.metier.*;

@Controller
@RequestMapping(value ="/auteur")
public class ControleurAuteur {
	
	@Autowired
	private AuteurDao autDao;
	
	@GetMapping(value ="/menu")
	public String exposeMenu() {
		System.out.println("bonour");
		return "Menu";
	}
	
	@GetMapping(value ="/gerer")
	public String GereAuteur(Model model) {
		
		model.addAttribute("auteurs", autDao.findAll());
		return "vueGestionAuteur";
		
		}
	
	@PostMapping(value ="/add")
	public String ajouterLivre(Model model , Auteur aut) {

		autDao.save(aut);
		model.addAttribute("auteurs", autDao.findAll());
				return "vueGestionAuteur";
	}
}