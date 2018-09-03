package com.nader.gestionCommandes.dao;

import java.util.List;

import org.hibernate.Session;

import com.nader.gestionCommandes.dao.entites.Client;
import com.nader.gestionCommandes.utils.HibernateUtil;

public class ClientDAOImp implements ClientDAO{

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Client clt) {
		session.beginTransaction();
		session.saveOrUpdate(clt);
		session.getTransaction().commit();
	}

	@Override
	public Client edit(Client clt) {
		session.beginTransaction();
		Client c = (Client)session.merge(clt);
		session.getTransaction().commit();
		return c;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Client c = findByID(id);
		session.delete(c);
		session.getTransaction().commit();
	}

	@Override
	public List<Client> findAll() {
		return session.createQuery("select o from client").list();
	}

	@Override
	public Client findByID(Long id) {
		return (Client) session.get(Client.class,id);
	}
}
