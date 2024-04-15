package com.GestionBibliotheque.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionBibliotheque.metier.Auteur;
@Repository
public interface AuteurDao extends JpaRepository<Auteur, Long> {
	
	public ArrayList<Auteur> findAll();
	
	public Auteur findById(long id);
	
	
	

}