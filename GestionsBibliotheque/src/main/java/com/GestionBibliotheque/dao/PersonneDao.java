package com.GestionBibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionBibliotheque.metier.Personne;
@Repository
public interface PersonneDao extends JpaRepository<Personne, String>{

	
		
}
