package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			int studentId = 1;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student based on the primary key
			System.out.println("\nGetting Student with id: " + studentId);
			
			//Student myStudent = session.get(Student.class, studentId);
			
			// delete student
			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
			
			// delete student 2
			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			// commit the transaction. 
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
