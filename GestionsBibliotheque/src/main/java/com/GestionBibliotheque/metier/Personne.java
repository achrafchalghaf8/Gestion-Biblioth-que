package com.GestionBibliotheque.metier;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.*;
@Entity
@Table(name = "Personne")
public class Personne implements  Serializable{
	@Id
	@Column(length = 20)
	private String cin;
	private String nomPrenom;
	private LocalDate dateNais;
	private String password;
	private boolean actived;
	@ManyToMany (fetch = FetchType.EAGER)
	Collection<Role> roles = new ArrayList<Role>();
	
	
	public Personne() {
		super();
	}

	public Personne(String cin, String nomPrenom, LocalDate dateNais, String password, boolean actived,
			Collection<Role> roles) {
		super();
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.dateNais = dateNais;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}

	
	public Personne(String cin, String nomPrenom, LocalDate dateNais, String password, boolean actived) {
		super();
		this.cin = cin;
		this.nomPrenom = nomPrenom;
		this.dateNais = dateNais;
		this.password = password;
		this.actived = actived;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public LocalDate getDateNais() {
		return dateNais;
	}

	public void setDateNais(LocalDate dateNais) {
		this.dateNais = dateNais;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public String getLesRoles() {
		String res="";
		for(Role r: this.roles)
			res=res+" | "+r.getRole();
		return res;
	}

	public void addRole(Role r)
	{
		if(!this.roles.contains(r))
		{
			this.roles.add(r);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return Objects.equals(cin, other.cin);
	}
	@Override
	public String toString() {
		return "Personne [cin=" + cin + ", nomPrenom=" + nomPrenom + ", dateNais=" + dateNais + ", password=" + password
				+ ", actived=" + actived + ", roles=" + roles + "]";
	}
	
	
	public String getNais()
	{
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy");
		String ch = f.format (this.dateNais) ;
		return ch;
	}
	
}
