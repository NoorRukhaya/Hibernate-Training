package com.tharanga.cache.HibernateCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
	public static void main(String args[])
	{
		Alien a = null;
	Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	SessionFactory sf = config.buildSessionFactory(registry);
	Session session1 = sf.openSession();
	session1.beginTransaction();
/*	
	a =(Alien)session1.get(Alien.class,101);
	System.out.println(a);
	//for same session only we are fetching same data it will hit the database onlky one time
	a =(Alien)session1.get(Alien.class,101);
	System.out.println(a);  */
	
	
	a =(Alien)session1.get(Alien.class,101);
	System.out.println(a);

	session1.getTransaction().commit();
	session1.close();
	
	Session session2 = sf.openSession();
	session2.beginTransaction();
	a =(Alien)session2.get(Alien.class,101);
	System.out.println(a);

	session2.getTransaction().commit();
	session2.close();
}
}

