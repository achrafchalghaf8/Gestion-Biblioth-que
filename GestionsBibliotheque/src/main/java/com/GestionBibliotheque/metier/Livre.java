package com.GestionBibliotheque.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;



@Entity
public class Livre implements Serializable
{	@Id
	@Column(length=50)
    private String isbn;
	private String titre;
	private int annee;
	@ManyToMany (fetch=FetchType.EAGER)
	private Collection<Auteur>auteurs =new ArrayList<>() ;
	
	public Livre(String isbn, String titre, int annee) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.annee = annee;
	}

	public Livre() {
		super();
	}


	public Collection<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Collection<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	@Override
	public String toString() {
		return "\nLivre [isbn=" + isbn + ", titre=" + titre + ", annee=" + annee + auteurs +"]";
	}
	
	public void addAuteur(Auteur a) {
		if(!auteurs.contains(a))
			a.addPoints(3);
		auteurs.add(a);
	}

}
