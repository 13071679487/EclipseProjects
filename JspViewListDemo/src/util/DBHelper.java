package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private final static String ClASSNAME = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/mydb";
	private final static String USER = "root";
	private final static String PASSWORD = "528428";
	private static Connection conn = null;
	static {
		try {
			// 1.������������
			Class.forName(ClASSNAME);
			// 2.������ݿ������
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return conn;
	}
}
