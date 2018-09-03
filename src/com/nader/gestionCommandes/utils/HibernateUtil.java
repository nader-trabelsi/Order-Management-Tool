package com.nader.gestionCommandes.utils;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	public static ServiceRegistry serviceRegistry;

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {

		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			// Création de la SessionFactory à partir de hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();

			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}



	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void close() {
		if(sessionFactory != null) {
			sessionFactory.close();
		}
		sessionFactory=null;
	}
}	