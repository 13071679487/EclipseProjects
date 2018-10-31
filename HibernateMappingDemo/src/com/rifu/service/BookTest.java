package com.rifu.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.LobHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rifu.model.Book;
import com.rifu.util.HibernateUtil;

public class BookTest {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession(); // 生成一个session
		session.beginTransaction(); // 开启事务
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // 提交事务
		session.close(); // 关闭session
	}

	@Test
	public void testAddBook() throws Exception {
		Book book = new Book();
		book.setId(2);
		book.setBookName("java高级实训");
		book.setPrice(49.0f);
		book.setSpecialPrice(true);
		book.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-3-5"));
		book.setAuthor("rifu");
		book.setIntroduction("好书...");

		// 将图片转换成Blob
		LobHelper lobHelper = session.getLobHelper();
		InputStream ins = new FileInputStream("d://background.jpg");
		Blob bookForeground = lobHelper.createBlob(ins, ins.available());
		book.setBookForeground(bookForeground);
		
		session.save(book);
	}

	@Test
	public void testGetAllBook() {
		String hql = "from Book";
		Query query = session.createQuery(hql);
		List<Book> books = query.list();
		for (int i = 0; i < books.size(); i++) {
			System.out.println(books.get(i));
		}
	}

}
