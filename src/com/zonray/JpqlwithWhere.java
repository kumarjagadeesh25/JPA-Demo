package com.zonray;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpqlwithWhere {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql="select e from com.zonray.Employee e where e.salary>=?1";
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery(jpql, Employee.class);
		typedQuery.setParameter(1, Double.valueOf(200000));
		List<Employee> empList = typedQuery.getResultList();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		entityManager.close();
		entityManagerFactory.close();
	}

}
