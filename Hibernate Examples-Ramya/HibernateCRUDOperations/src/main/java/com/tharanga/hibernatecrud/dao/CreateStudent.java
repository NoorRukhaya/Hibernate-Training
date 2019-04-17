package com.tharanga.hibernatecrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tharanga.hibernatecrud.model.Student;
import com.tharanga.hibernatecrud.utility.HibernateUtil;

public class CreateStudent {
	public static void main(String[] args) {
		
		// Create student entity object
		Student student = new Student();
		student.setStudentName("ramya");
		student.setRollNumber(04);
		student.setCourse("BA");

		// Create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		
		// getting transaction object from session object
		session.beginTransaction();

		session.save(student);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
