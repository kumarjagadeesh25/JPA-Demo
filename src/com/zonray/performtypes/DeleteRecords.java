/*this class is describing about how to delete SINGLE row 
from the table
*/
package com.zoray.performtypes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zonray.Employee;

public class DeleteRecords {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Employee employee = new Employee();		
		// REMOVE method
		entityManager.remove(employee);
		employee.setEno(12l);
//		employee.setEno(11l);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
