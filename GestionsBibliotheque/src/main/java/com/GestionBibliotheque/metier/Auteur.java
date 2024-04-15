package com.GestionBibliotheque.metier;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;



@Entity
public class Auteur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String nomPrenom;
    private int nbrPoints;
	public Auteur(Long id, String nomPrenom) {
		super();
		this.id = id;
		this.nomPrenom = nomPrenom;
	}
	
	public Auteur() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	
	
	public int getNbrPoints() {
		return nbrPoints;
	}

	public void setNbrPoints(int nbrPoints) {
		this.nbrPoints = nbrPoints;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auteur other = (Auteur) obj;
		return Objects.equals(id, other.id) && Objects.equals(nomPrenom, other.nomPrenom);
	}
	@Override
	public String toString() {
		return "\nAuteur [id=" + id + ", nomPrenom=" + nomPrenom + "]";
	}
    
	public void addPoints(int p) {
		nbrPoints +=p;
		
	}
}