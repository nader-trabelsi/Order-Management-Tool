package com.nader.gestionCommandes.cdc;

import java.util.List;

import com.nader.gestionCommandes.dao.ClientDAO;
import com.nader.gestionCommandes.dao.ClientDAOImp;
import com.nader.gestionCommandes.dao.entites.Client;

public class ClientCdCImp implements ClientCdC{
	
	ClientDAO dao = new ClientDAOImp();

	@Override
	public void add(Client clt) {
		dao.add(clt);
		
	}

	@Override
	public Client edit(Client clt) {
		return dao.edit(clt);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Client> findAll() {
		return dao.findAll();
	}

	@Override
	public Client findByID(Long id) {
		return dao.findByID(id);
	}

}
