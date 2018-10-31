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
		session = sessionFactory.openSession(); // ����һ��session
		session.beginTransaction(); // ��������
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit(); // �ύ����
		session.close(); // �ر�session
	}

	@Test
	public void testAddBook() throws Exception {
		Book book = new Book();
		book.setId(2);
		book.setBookName("java�߼�ʵѵ");
		book.setPrice(49.0f);
		book.setSpecialPrice(true);
		book.setPublishDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-3-5"));
		book.setAuthor("rifu");
		book.setIntroduction("����...");

		// ��ͼƬת����Blob
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
