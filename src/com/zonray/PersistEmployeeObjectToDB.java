package com.zonray;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistEmployeeObjectToDB {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		Employee employee = new Employee();

//		this is for inserting PK values from the user
	/*	System.out.print("Enter number: ");
		long eno = scanner.nextLong();
		employee.setEno(eno);
		employee.setEname("Anil");
		employee.setSalary("100000");*/
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		System.out.println("Record Inserted Successfully.......");
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}

}
