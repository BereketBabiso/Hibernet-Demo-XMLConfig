package com.hibernat.demo.Hibernate_XML_Demo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernat.demo.domain.Employee;

/**
 * Hello world!
 *
 */
public class App {
	private static SessionFactory sessionFactory;
	public static void setup() {
		
		// Create StandardServiceRegistry(recommended) or BootstrapServiceRegistry.
//		final StandardServiceRegistry registery = new StandardServiceRegistryBuilder()
//				                            .configure("hibernate.cfg.xml").build();
		try {
			// Create the SessionFactory using the ServiceRegistry
			System.out.println("attempting to build session factory...");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("session factory build success");
		} catch(HibernateException hibernateException) {
			System.out.println("error 1 "+hibernateException.getMessage());
		} catch(Exception expception) {
			System.out.println("error 2");
		}		
		
	}

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        setup();
        Session session = sessionFactory.openSession();
        System.out.println("connection statistics : "+sessionFactory.getStatistics());
        session.beginTransaction();
        System.out.println("connection statistics : "+sessionFactory.getStatistics());
        List<Employee> empList = session.createQuery("from Employee").list();
        System.out.println("connection statistics : "+sessionFactory.getStatistics());
        empList.stream().forEach((empl)-> { System.out.println(empl.getName());});
        System.out.println("connection statistics : "+sessionFactory.getStatistics());
        session.getTransaction().commit();
    }
}
