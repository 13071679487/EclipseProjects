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
 * @create 2018年8月24日 下午9:48:32
 */
public class GenerateTest {
	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		String persistenceUnitName = "JPADemo";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		
		//2. 创建EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//3. 开启事物
		EntityTransaction ts = entityManager.getTransaction();
		ts.begin();
		
		//4.	进行持久化操作
		Customer customer = new Customer();
		customer.setName("rifu");
		customer.setEmail("13071679487@163.com");
		entityManager.persist(customer);
		
		//5.	提交事物
		ts.commit();
		
		//6.	关闭manager
		entityManager.close();
		
		//7.	关闭entityManagerFactory
		entityManagerFactory.close();
	}
}
