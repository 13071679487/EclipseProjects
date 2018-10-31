/**
 * 
 */
package com.rifu.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rifu.entity.Customer;

/**
 * @author Lifu
 * @create 2018��8��24�� ����9:48:32
 */
public class GenerateTest {
	public static void main(String[] args) {
		// 1. ����EntityManagerFactory
		String persistenceUnitName = "JPADemo";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		
		//2. ����EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3. ��������
		EntityTransaction ts = entityManager.getTransaction();
		ts.begin();
		
		//4.	���г־û�����
		Customer customer = new Customer();
		customer.setName("rifu");
		customer.setEmail("13071679487@163.com");
		entityManager.persist(customer);
		
		//5.	�ύ����
		ts.commit();
		
		//6.	�ر�manager
		entityManager.close();
		
		//7.	�ر�entityManagerFactory
		entityManagerFactory.close();
	}
}
