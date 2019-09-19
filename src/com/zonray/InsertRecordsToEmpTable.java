package com.zonray;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertRecordsToEmpTable {

	public static void main(String[] args) {
		
		StudentSequence2 student = new StudentSequence2();
		student.setSname("dhanu");
		student.setSmarks(BigDecimal.valueOf(2000));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
				entityManager.persist(student);
			entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	
	}

}
