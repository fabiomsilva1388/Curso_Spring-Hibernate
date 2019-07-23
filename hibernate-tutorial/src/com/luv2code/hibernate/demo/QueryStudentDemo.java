package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			
			// query students: lasName: 'Doe
			
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Duck");
			displayStudents(theStudents);
			
			
			// query students: lastNasme='Duck' OR firstName='Daff'
			theStudents = 
					session.createQuery("from Student s where"
							+ " s.lastName='Duck' OR s.firstName='Daff'").getResultList();
			
			
			// display query who have last name of Duck or first name is Daff
			displayStudents(theStudents);
			
			// query studetns where email LIKE %luv2.com
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%luv2.com'").getResultList();
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}