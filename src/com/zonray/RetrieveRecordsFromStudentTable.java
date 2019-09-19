package com.zonray;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetrieveRecordsFromStudentTable {

	public static void main(String[] args) {
	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADemo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
/*		In find method second parameter is primary key of the table, there we should pass the exact data-type of
		that perticular column name(which we declared in Entity class )*/
		
		Student student = entityManager.find(Student.class, 1l);  // 1l means it is a type of long that is why I declared it as 1l...
		System.out.println(student.getSno());
		System.out.println(student.getSname());
		System.out.println(student.getSmarks());
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
