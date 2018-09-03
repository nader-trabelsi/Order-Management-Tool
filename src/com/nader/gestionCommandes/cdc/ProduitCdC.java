package com.nader.gestionCommandes.cdc;

import java.util.List;

import com.nader.gestionCommandes.dao.entites.Produit;

public interface ProduitCdC {
	
	public void add(Produit pr);
	
	public Produit edit(Produit pr);
	
	public void delete(Long id);
	
	public List<Produit> findAll();
	
	public Produit findByID(Long id);
	
	public boolean updateQT(Long id, Long qt_comm);

}
