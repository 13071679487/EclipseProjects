package util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	/**
	 * �ͷ�����
	 * 
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static ComboPooledDataSource dataSource = null;

	static {
		// ֻ������һ��
		dataSource = new ComboPooledDataSource("myc3p0"); // myc3p0
															// һ��Ҫ�������ļ��е�����һ��
	}

	/**
	 * ��������Դ��һ��Connection ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}
}
