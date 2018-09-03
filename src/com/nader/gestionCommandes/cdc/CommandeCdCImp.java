package com.nader.gestionCommandes.cdc;

import java.util.List;

import com.nader.gestionCommandes.dao.CommandeDAO;
import com.nader.gestionCommandes.dao.CommandeDAOImp;
import com.nader.gestionCommandes.dao.entites.Commande;

public class CommandeCdCImp implements CommandeCdC{
	
	CommandeDAO dao = new CommandeDAOImp();

	@Override
	public void add(Commande cm) {
		dao.add(cm);
		
	}

	@Override
	public Commande edit(Commande cm) {
		return dao.edit(cm);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Commande> findAll() {
		return dao.findAll();
	}

	@Override
	public Commande findByID(Long id) {
		return dao.findByID(id);
	}
	

}
