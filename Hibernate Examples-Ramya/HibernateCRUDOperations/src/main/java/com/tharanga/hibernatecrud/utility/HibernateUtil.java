package com.tharanga.hibernatecrud.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.tharanga.hibernatecrud.model.Student;


public class HibernateUtil {
	
	
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		return sf;
	}

}

