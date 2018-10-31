package com.rifu.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.Student;
import com.rifu.util.HibernateUtil;

public class StudentTest {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private static Session session;

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void createTable() {
	}

	@Test
	public void testSQLQuery1() {
		String sql = "select * from t_student";
		Query query = session.createSQLQuery(sql).addEntity(Student.class);
		List studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 带条件的查询,查询条件名为数据库里面对应的列名
	 */
	@Test
	public void testSQLQuery2() {
		String sql = "select * from t_student where stuName like :stuName and stuAge=:stuAge";
		Query query = session.createSQLQuery(sql).addEntity(Student.class);
		query.setString("stuName", "ri%");
		query.setInteger("stuAge", 22);
		List studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * HQL为面向对象查询语言
	 */
	@Test
	public void testHQLQuery1() {
		String sql = "from Student";
		Query query = session.createQuery(sql);
		List<Student> studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 带条件的查询，查询条件为对象的属性名
	 */
	@Test
	public void testHQLQuery2() {
		String sql = "from Student where name like :stuName and age=:stuAge";
		Query query = session.createQuery(sql);
		query.setString("stuName", "ri%");
		query.setInteger("stuAge", 22);
		List<Student> studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 使用别名进行查询
	 */
	@Test
	public void testHQLQuery3() {
		String sql = "from Student as s where s.name like :stuName and s.age=:stuAge";
		Query query = session.createQuery(sql);
		query.setString("stuName", "ri%");
		query.setInteger("stuAge", 22);
		List<Student> studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 链式写法
	 */
	@Test
	public void testHQLQuery7() {
		String sql = "from Student as s where s.name like :stuName and s.age=:stuAge";
		Query query = session.createQuery(sql);
		List<Student> studentList = query.setString("stuName", "ri%")
				.setInteger("stuAge", 22)
				.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 对结果进行排序
	 */
	@Test
	public void testHQLQuery4() {
		String sql = "from Student order by age desc";
		Query query = session.createQuery(sql);
		List<Student> studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 进行分页查询
	 */
	@Test
	public void testHQLQuery5() {
		String sql = "from Student";
		Query query = session.createQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(2);
		List<Student> studentList = query.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}

	/**
	 * 查询单个对象
	 */
	@Test
	public void testHQLQuery6() {
		String sql = "from Student";
		Query query = session.createQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Student student = (Student) query.uniqueResult(); // 当你确定结果集肯定为一条时
		System.out.println(student);
	}
	
	@Test
	public void testQBCQuery() {
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> studentList = criteria.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
	/**
	 * 带条件的查询
	 */
	@Test
	public void testQBCQuery1() {
		Criteria criteria = session.createCriteria(Student.class);
		Criterion c1 = Restrictions.like("name", "r%");
		Criterion c2 = Restrictions.eq("age", 22);
		criteria.add(c1);
		criteria.add(c2);
		List<Student> studentList = criteria.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
	
	/**
	 * 对结果进行排序
	 */
	@Test
	public void testQBCQuery2() {
		Criteria criteria = session.createCriteria(Student.class);
		criteria.addOrder(Order.desc("age"));
		List<Student> studentList = criteria.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
	
	/**
	 * 进行分页查询
	 */
	@Test
	public void testQBCQuery3() {
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List<Student> studentList = criteria.list();
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
}
