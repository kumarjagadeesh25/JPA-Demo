package com.zonray;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpqlWhereClause {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select e.eno,e.ename,e.salary from Employee e where e.salary>=?1 and e.ename=?2 order by e.eno";
		TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
		// typedQuery.setParameter(1, 10000d);
		typedQuery.setParameter(1, Double.valueOf(100000));
		typedQuery.setParameter(2, "Anil");
		List<Object[]> resultList = typedQuery.getResultList();

		System.out.println(resultList.isEmpty());

		System.out.print("---------------------------------------------------------\n");
		System.out.print("|\tNO \t|\t NAME \t|\t SALARY \t|\n");
		System.out.print("---------------------------------------------------------\n");
		if (resultList.isEmpty()) {
			for (Object[] employee : resultList) {
				System.out.println("|\t" + employee[0] + "\t|\t" + employee[1] + "\t|\t" + employee[2] + "\t|");
			}
		} else {
			System.err.println("No Records founded...");
		}

		System.out.print("---------------------------------------------------------\n");
		entityManager.close();
		entityManagerFactory.close();
	}

}
