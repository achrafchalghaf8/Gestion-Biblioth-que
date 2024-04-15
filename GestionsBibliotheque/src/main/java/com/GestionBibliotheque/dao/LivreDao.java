package com.GestionBibliotheque.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.GestionBibliotheque.metier.Livre;
import jakarta.transaction.Transactional;

@Repository
public interface LivreDao extends JpaRepository<Livre, String>{
	
	 public ArrayList<Livre> findByAnnee(int annee);
	 
	 public ArrayList<Livre> findAll();
	 
	 public Livre findByIsbn(String isbn);
	 
	 public ArrayList<Livre> findByTitre(String t);
	 
	 @Transactional
	 public void deleteByAnnee(int annee);
	
}
