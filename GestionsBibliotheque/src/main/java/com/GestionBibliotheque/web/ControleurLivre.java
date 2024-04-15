package com.GestionBibliotheque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GestionBibliotheque.dao.*;
import com.GestionBibliotheque.metier.*;


@Controller
@RequestMapping(value ="/livre")
public class ControleurLivre {
	
	@Autowired
	private LivreDao livDao;
	
	@Autowired
	private AuteurDao autDao;
	
	@GetMapping(value ="/gerer")
	public String gererLivre(Model model) {
		model.addAttribute("livres", livDao.findAll());
		model.addAttribute("auteurs", autDao.findAll());
			return "vueGestionLivre";
	}
	
	@PostMapping(value ="/addlivre")
	public String ajouterLivre(Model model , Livre livre) {
		livDao.save(livre);
		model.addAttribute("livres", livDao.findAll());
			return "vueGestionLivre";
	}
	
	@GetMapping(value ="/affectation")
	public String affectation(Model model) {
		model.addAttribute("livres", livDao.findAll());
		model.addAttribute("auteurs", autDao.findAll());
		return "affecterAuteur";
	}
	
	@RequestMapping(value ="/affecter", method = RequestMethod.GET)
	public String affecterAuteurAuLivre(Model model ,String isbn,Long idAut) {

		if(isbn!=null && idAut!=null) {
			Livre li = livDao.findByIsbn(isbn);
			Auteur au = autDao.findById((long)idAut);
			if(li.getAuteurs().contains(au)==false) {
				li.addAuteur(au);
				autDao.save(au);
				livDao.save(li);
			}
			 else {
				 return "message";
	           }
		model.addAttribute("lesAuteurs",li.getAuteurs());
		}
		else 
		{
			model.addAttribute("lesAuteurs",autDao.findAll());
		}
		model.addAttribute("lesLivres",livDao.findAll());
		
		return "vueGestionLivre";
	}
}
