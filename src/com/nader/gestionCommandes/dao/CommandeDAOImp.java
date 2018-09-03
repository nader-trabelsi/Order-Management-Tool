package com.nader.gestionCommandes.dao;

import java.util.List;

import org.hibernate.Session;

import com.nader.gestionCommandes.dao.entites.Commande;
import com.nader.gestionCommandes.utils.HibernateUtil;

public class CommandeDAOImp implements CommandeDAO{
	
	Session session = HibernateUtil.openSession();

	@Override
	public void add(Commande cm) {
		session.beginTransaction();
		session.save(cm);
		session.getTransaction().commit();
	}

	@Override
	public Commande edit(Commande cm) {
		session.beginTransaction();
		Commande c = (Commande)session.merge(cm);
		session.getTransaction().commit();
		return c;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Commande c = findByID(id);
		session.delete(c);
		session.getTransaction().commit();
	}

	@Override
	public List<Commande> findAll() {
		return session.createQuery("from commande").list();
	}

	@Override
	public Commande findByID(Long id) {
		return (Commande) session.get(Commande.class,id);
	}
}
