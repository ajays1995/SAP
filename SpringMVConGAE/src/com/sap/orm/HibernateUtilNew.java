package com.sap.orm;

import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;   
import org.hibernate.service.*;
public class HibernateUtilNew {       
	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory configureSessionFactory() {
    	System.out.println("inside configureSessionFactory method in HibernateUtil");
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();

    }

	
	
	}


