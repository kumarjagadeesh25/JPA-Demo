/*this class represents how to
INSERT single record into the table
*/
package com.zoray.performtypes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zonray.Employee;

public class InsertRecords {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Employee employee = new Employee();
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		employee.setEname(name);
		System.out.print("Enter Salary: ");
		double salary = scanner.nextDouble();
		employee.setSalary(salary);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(employee);
			
		System.out.println("Record Inserted successfully..");
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}

}
