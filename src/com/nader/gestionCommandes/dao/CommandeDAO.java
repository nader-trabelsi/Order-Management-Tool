package com.nader.gestionCommandes.dao;

import java.util.List;

import com.nader.gestionCommandes.dao.entites.Commande;


public interface CommandeDAO {
	
	public void add(Commande cm);
	
	public Commande edit(Commande cm);
	
	public void delete(Long id);
	
	public List<Commande> findAll();
	
	public Commande findByID(Long id);

}
