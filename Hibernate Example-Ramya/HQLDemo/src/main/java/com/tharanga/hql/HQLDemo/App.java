package com.tharanga.hql.HQLDemo;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String args[]) {
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(registry);
		Session session1 = sf.openSession();
		session1.beginTransaction();
	/*	
		Random r = new Random();
		
		for(int i=0;i<=50;i++)
		{
			Student s = new Student();
			s.setRollno(i);
			s.setName("name "+i);
			s.setMarks(r.nextInt(100));
			session1.save(s);
		}    */
		
	//	Query q = session1.createQuery("from Student");
	//	Query q = session1.createQuery("from Student where marks > 50");
	/*	Query q = session1.createQuery("from Student where rollno=7");
		
		List <Student> students = q.list();
		
		for(Student s:students)
		{
			System.out.println(s);
		}  
		
		//this is fetching unique result
		Query q = session1.createQuery("select rollno, name, marks from Student where rollno=7");
		Object[]student = (Object[]) q.uniqueResult();
		
		System.out.println(student[0]+" : "+student[1]+" : "+student[2]);  
		
		//Fetching all the Records
	//	Query q = session1.createQuery("select rollno, name, marks from Student");
		
		//if have two tables with same name
		Query q = session1.createQuery("select rollno, name, marks from Student s where marks>60");
		List <Object[]> students = (List<Object[]>) q.list();
		
		for(Object[] student:students)
		{
		System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
		
		}  
		
		//Aggregations 
		
		Query q = session1.createQuery("select sum(marks) from Student s where marks>60");
		List students = (List) q.list();
		
		for(Object marks:students)
		{
		System.out.println(marks);
		
		}  
		int b=60;
		
		Query q = session1.createQuery("select sum(marks) from Student s where marks > :b");
		q.setParameter("b", b);
		
		Long marks = (Long) q.uniqueResult();
		
		System.out.println(marks);  
		
		//SQL Queries(Native Queries
		
		SQLQuery query = session1.createSQLQuery("select * from student where marks>60");
		query.addEntity(Student.class);
		List <Student> students = query.list();
		
		for(Student o: students)
		{
			System.out.println(o);
		}   */
		
		
		SQLQuery query = session1.createSQLQuery("select name, marks from student where marks>60");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);  //convert ur query to map
		
		List students = query.list();
		
		for(Object o: students)
		{
			Map m = (Map)o;
			System.out.println(m.get("name")+" : "+m.get("marks"));
		}
		
		session1.getTransaction().commit();
		session1.close();
	}
}
