package com.GestionBibliotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.GestionBibliotheque.dao.*;
import com.GestionBibliotheque.metier.*;



@SpringBootApplication
public class GestionsBibliothequeApplication {

	public static void main(String[] args) {
		/*SpringApplication.run(GestionBibliothequeApplication.class, args);
		*/ApplicationContext ctx;		
		ctx = SpringApplication.run(GestionsBibliothequeApplication.class, args);
		
		Auteur a1 = new Auteur((long) 1, "Khemakhem Aida");
		Auteur a2 = new Auteur((long) 2, "Gargouri Bilel");
		Auteur a3 = new Auteur((long) 3, "Gargouri Feiza");
		Auteur a4 = new Auteur((long) 4, "Bouaziz Rafik");
		
		Livre l1 = new Livre("IB222", "LMF-ISO-24613", 2015);
		Livre l2 = new Livre("IB3333", "UML-Diagramme de Classe", 2019);
		Livre l3 = new Livre("IB5555", "POO-Avancée", 2017);
		
		
		l1.addAuteur(a1);
		l1.addAuteur(a2);
		
		l2.addAuteur(a3);
		l2.addAuteur(a4);
		
		l3.addAuteur(a1);
		l3.addAuteur(a3);
		
		
		AuteurDao daoA = ctx.getBean(AuteurDao.class);
		LivreDao daoL = ctx.getBean(LivreDao.class);
		
		/*daoA.save(a1);
		daoA.save(a2);
		daoA.save(a3);
		daoA.save(a4);
		
		daoL.save(l1);
		daoL.save(l2);
		daoL.save(l3);
		
		System.out.println("Les livres de l'annee 2019 : " +daoL.findByAnnee(2019));
		System.out.println("Les livres du titre  LMF-ISO-24613 : " +daoL.findByTitre("LMF-ISO-24613"));
		daoL.deleteByAnnee(2019);
		System.out.println("La base apres la suppression" + daoL.findAll());
		/*
		Role r1 = new Role("Admin", "adminsitrateur");
		Personne p1 = new Personne("11152480", "Feki Marwen", LocalDate.of(2001, 2, 26),"11152480", true);
		
		p1.getRoles().add(r1);
		
		RoleDao rd = ctx.getBean(RoleDao.class);
		PersonneDao pd = ctx.getBean(PersonneDao.class);
		
		rd.save(r1);
		pd.save(p1);
		*/
		}
}
