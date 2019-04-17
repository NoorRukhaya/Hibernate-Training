package com.tharanga.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
	public static void main(String args[])
	{
	Laptop laptop = new Laptop();
	laptop.setLid(101);
	laptop.setLname("Dell");
	
	Student std = new Student();
	std.setRollno(50);
	std.setName("Deepu");
	std.setMarks(600);
	std.setLaptop(laptop);
	
	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	SessionFactory sf = config.buildSessionFactory(registry);
	Session session = sf.openSession();
	
	session.beginTransaction();
	session.save(laptop);
	session.save(std);
	
	session.getTransaction().commit();

}
}
