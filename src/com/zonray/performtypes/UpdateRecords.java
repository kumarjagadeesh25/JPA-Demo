package com.zoray.performtypes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zonray.Employee;

public class UpdateRecords {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		System.out.println("You are going to update Employee Salary...");
		System.out.print("Employee Number: ");		
		Employee employee = entityManager.find(Employee.class, scanner.nextLong());
		System.out.print("Enter Employee Salary: ");
		employee.setSalary(scanner.nextDouble());
		
		System.out.println("Record Updated successfully...");
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
		
	}

}
