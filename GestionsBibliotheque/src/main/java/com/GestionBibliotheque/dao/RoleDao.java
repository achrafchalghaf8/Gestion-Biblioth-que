package com.GestionBibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionBibliotheque.metier.Role;

public interface RoleDao extends JpaRepository<Role, String> {

}
