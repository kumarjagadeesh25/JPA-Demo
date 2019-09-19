package com.zonray;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpqlExample {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// This is for retrieving the single column values from the database.

		/*
		 * Employee employee = entityManager.find(Employee.class, 2l);
		 * System.out.println(employee.getEno());
		 * System.out.println(employee.getEname());
		 * System.out.println(employee.getSalary());
		 */

		// This is for retrieving multiple values according to our convenience (with
		// where clause / without where clause)
		// Retrieving ENAME column
		String jpqlename = "select emp.ename from com.zonray.Employee emp";
		TypedQuery<String> names = entityManager.createQuery(jpqlename, String.class);
		List<String> namesList = names.getResultList();
		for (String name : namesList) {
			System.out.println(name);
		}

		// Retrieving SALARY column
		String jpqlsalary = "select emp.salary from com.zonray.Employee emp";
		TypedQuery<Double> salaries = entityManager.createQuery(jpqlsalary, Double.class);
		List<Double> salariesList = salaries.getResultList();
		for (Double salary : salariesList) {
			System.out.println(salary);
		}

		// Retrieving ENAME,SALARY columns
		// here, we can use simple Entity class name(Table name) or fully qualified name
		// of the Entity class.
		String jpqlmul = "select emp.ename,emp.salary from com.zonray.Employee emp";
		TypedQuery<Object[]> objects = entityManager.createQuery(jpqlmul, Object[].class);
		List<Object[]> objectList = objects.getResultList();
		for (Object[] object : objectList) {
			System.out.println(object[0] + " " + object[1]);
		}

		entityManager.close();
		entityManagerFactory.close();
	}

}
