package com.nader.gestionCommandes.dao;

import java.util.List;

import org.hibernate.Session;

import com.nader.gestionCommandes.dao.entites.Produit;
import com.nader.gestionCommandes.utils.HibernateUtil;

public class ProduitDAOImp implements ProduitDAO{

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Produit pr) {
		session.beginTransaction();
		session.saveOrUpdate(pr);
		session.getTransaction().commit();
	}

	@Override
	public Produit edit(Produit pr) {
		session.beginTransaction();
		Produit p = (Produit)session.merge(pr);
		session.getTransaction().commit();
		return p;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Produit p = findByID(id);
		session.delete(p);
		session.getTransaction().commit();
	}

	@Override
	public List<Produit> findAll() {
		return session.createQuery("from produit").list();
	}

	@Override
	public Produit findByID(Long id) {
		return (Produit) session.get(Produit.class,id);
	}

	@Override
	public boolean updateQT(Long id, Long qt_comm) {
		Produit p = findByID(id);
		if (qt_comm<=p.getQt_dispo()) {
			p.setQt_dispo(p.getQt_dispo()- qt_comm);
			edit(p);
			return true;
		} else {
			return false;
		}
	}
}
