package com.nader.gestionCommandes.cdc;

import java.util.List;

import com.nader.gestionCommandes.dao.entites.Commande;

public interface CommandeCdC {
	
	public void add(Commande cm);
	
	public Commande edit(Commande cm);
	
	public void delete(Long id);
	
	public List<Commande> findAll();
	
	public Commande findByID(Long id);

}
