package com.zonray;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPQLRecords {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// for retrieving SINGLE record
		Employee employee = entityManager.find(Employee.class, 2l);
		System.out.println(employee);
		System.out.println(employee.getEno());
		System.out.println(employee.getEname());
		System.out.println(employee.getSalary());

		entityManager.close();
		entityManagerFactory.close();
	}
}
