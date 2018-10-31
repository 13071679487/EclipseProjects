package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManagerUtil {
	private final static String ClASSNAME = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf8";
	private final static String USER = "root";
	private final static String PASSWORD = "528428";
	private static Connection conn = null;
	static {
		try {
			// 1.加载驱动程序
			Class.forName(ClASSNAME);
			// 2.获得数据库的链接
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
