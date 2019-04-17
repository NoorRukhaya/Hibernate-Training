package com.tharanga.HibernateJpaImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aa");
        EntityManager em = emf.createEntityManager();
        
        Alien a = em.find(Alien.class, 4);
    }
}
 