package com.tharanga.HibernatePersistenceLifeCycle;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session1 = sf.openSession();
		session1.beginTransaction();

		Laptop l = new Laptop();  //new object state
		l.setLid(101);
		l.setBrand("Sony");
		l.setPrice(20000);
		
		session1.save(l);   //save or persistent state
		l.setPrice(10000);
		

		session1.getTransaction().commit();
		session1.close();
	}
}
