package com.nader.gestionCommandes.cdc;

import java.util.List;

import com.nader.gestionCommandes.dao.ProduitDAO;
import com.nader.gestionCommandes.dao.ProduitDAOImp;
import com.nader.gestionCommandes.dao.entites.Produit;

public class ProduitCdCImp implements ProduitCdC{
	
	ProduitDAO dao = new ProduitDAOImp();

	@Override
	public void add(Produit pr) {
		dao.add(pr);
		
	}

	@Override
	public Produit edit(Produit pr) {
		return dao.edit(pr);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
		
	}

	@Override
	public List<Produit> findAll() {
		return dao.findAll();
	}

	@Override
	public Produit findByID(Long id) {
		return dao.findByID(id);
	}
	
	@Override
	public boolean updateQT(Long id,Long qt_comm) {
		return dao.updateQT(id, qt_comm);
	}

}
