package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student objects.
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("John", "Doe", "john.doe@gmail.com");
			Student tempStudent2 = new Student("Peter", "Son", "peter.son@gmail.com");
			Student tempStudent3 = new Student("James", "John", "james.john@email.com");
			
			// start a transaction
			session.beginTransaction();
			
			// saving the students.
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		

	}

}
