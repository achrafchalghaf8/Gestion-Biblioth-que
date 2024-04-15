package com.GestionBibliotheque.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.GestionBibliotheque.dao.*;
import com.GestionBibliotheque.metier.*;

import jakarta.servlet.http.HttpServletResponse;

public class ContollerPersonne {

	@Autowired
	private PersonneDao personneDAO;
	@Autowired
	private RoleDao roleDAO;
	public String cin1=null;
	public String role1=null;

	@Secured(value= {"ROLE_ADMIN"})
	@RequestMapping(value= "/admin",method=RequestMethod.GET)
	public String gererPersonne(Model model)
	{
		model.addAttribute("personnes", personneDAO.findAll());
		model.addAttribute("roles", roleDAO.findAll());
		return "gestionPersonne";
	}
	
	  @Secured(value= {"ROLE_ADMIN"})
	  @RequestMapping(value="/addPersonne", method=RequestMethod.POST) 
	  public String addPersonne(Model model,String cin, String nomPrenom, String dateNais, String password, boolean actived,String role, HttpServletResponse response) 
	  {
		  LocalDate d1=null;
		  if(role!=null && cin!=null)
		  {
			  Personne p1=personneDAO.findById(cin);
			  if(p1==null)
			  {
				  if (dateNais!=null)
				  {
					  DateTimeFormatter f= DateTimeFormatter.ofPattern("yyyy-MM-d");
					  d1=LocalDate.parse(dateNais,f);
				  }
				  Personne p= new Personne(cin,nomPrenom,d1,password,actived);
				  Role r=roleDAO.findById(role);
				  p.addRole(r);
				  //roleDAO.save(r);
				  personneDAO.save(p);
				}
			  else 
			  {
				   cin1 = cin;
				   role1 = role;
				  return "redirect:/personne/attention?message=Personne Actualisee";

			  }
		  }
		  
	  model.addAttribute("personnes", personneDAO.findAll());
	  model.addAttribute("roles", roleDAO.findAll());

	  return "gestionPersonne"; 
	  }
	  

	
	  	@Secured(value= {"ROLE_ADMIN"})
		@RequestMapping(value="/attention", method=RequestMethod.GET)
		public String attention(Model model,String message)
		{
		if(cin1!=null && role1!=null)
		{
			Personne p=personneDAO.findById(cin1);
					Role r=roleDAO.findById(role1);
					
					p.addRole(r);
					personneDAO.save(p);
		}
		model.addAttribute("message",message);
		model.addAttribute("roles",roleDAO.findAll());
		model.addAttribute("personnes",personneDAO.findAll());
			return "attention";
		}
}
