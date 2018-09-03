package com.nader.gestionCommandes.dao;

import java.util.List;

import com.nader.gestionCommandes.dao.entites.Client;

public interface ClientDAO {
	
	public void add(Client clt);
	
	public Client edit(Client clt);
	
	public void delete(Long id);
	
	public List<Client> findAll();
	
	public Client findByID(Long id);

}
