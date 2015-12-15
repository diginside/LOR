package com.lor.rentalapp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
		// Create the sessionFactory from hibernate.cfg.xml
		try {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
													applySettings(config.getProperties()).
													build();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			
			//the following code had an issue with not applying the settings in the configuration file 
			// - see above applySetting(...)
			//sessionFactory = new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}	
	}

	public static final SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
