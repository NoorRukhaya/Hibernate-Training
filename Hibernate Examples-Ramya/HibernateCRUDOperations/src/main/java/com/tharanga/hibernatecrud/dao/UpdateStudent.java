package com.tharanga.hibernatecrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tharanga.hibernatecrud.model.Student;
import com.tharanga.hibernatecrud.utility.HibernateUtil;

public class UpdateStudent {
	public static void main(String[] args) 
	 {
	  //Create session factory object
	  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	  //getting session object from session factory
	  Session session = sessionFactory.openSession();
	  //getting transaction object from session object
	  session.beginTransaction();
	  
	  Student student = (Student)session.get(Student.class, 2);
	  student.setStudentName("Sweety Rajput");
	  System.out.println("Updated Successfully");
	  session.getTransaction().commit();
	  sessionFactory.close();
	 }

}
