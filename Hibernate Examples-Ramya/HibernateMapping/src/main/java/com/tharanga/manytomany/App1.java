package com.tharanga.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App1 {
	
	public static void main(String args[])
	{
	Laptop laptop = new Laptop();
	laptop.setLid(4);
	laptop.setLname("Dell");
	
	
	Student student = new Student();
	student.setRollno(50);
	student.setName("Deepu");
	student.setMarks(600);
	student.getLaptops().add(laptop);
	laptop.getStudent().add(student);
	
	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	SessionFactory sf = config.buildSessionFactory(registry);
	Session session = sf.openSession();
	
	session.beginTransaction();
	session.save(laptop);
	session.save(student);
	
	session.getTransaction().commit();

}
}
