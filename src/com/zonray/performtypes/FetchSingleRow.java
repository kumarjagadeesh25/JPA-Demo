/*this class for retrieving SINGLE row data from
	the database

*/
package com.zoray.performtypes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zonray.Employee;

public class FetchSingleRow {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.print("Enter number: ");
		long number = scanner.nextLong();
		Employee employee = entityManager.find(Employee.class, number);
		System.out.println(employee.getEno());
		System.out.println(employee.getEname());
		System.out.println(employee.getSalary());
		entityManager.close();
		entityManagerFactory.close();
		scanner.close();
	}

}
