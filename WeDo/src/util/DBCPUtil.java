package util;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * DBCP������
 * @author lenovo
 *
 */
public class DBCPUtil {
   /** ����Դ*/
	private static DataSource DS;
	private static final String configFile="/dbcp.properties";
	
	/** ������Դ���һ������*/
	public Connection getConn(){
		Connection con=null;
		if(DS!=null){
			try {
				con=DS.getConnection();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
			try {
				con.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	/** Ĭ�ϵĹ��캯��*/
	public DBCPUtil(){
		initDbcp();
	}
	private void initDbcp() {
		Properties pops=new Properties();
		try {
			pops.load(Object.class.getResourceAsStream(configFile));
			DS=BasicDataSourceFactory.createDataSource(pops);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	/** ���캯�� ��ʼ��DS ָ��  ���ݿ�*/
	public DBCPUtil(String connectURI){
		initDS(connectURI);
	}
	/** ���캯�� ��ʼ��DS ָ��  ���в���*/
	public DBCPUtil(String connectURI,String username,String pswd,
			String driverClass,int initialSize,int maxActive,int maxIdle,
			int maxWait,int minIdle){
		initDS(connectURI,username, pswd,driverClass,initialSize, 
				maxActive, maxIdle,maxWait, minIdle);
	}
	/**
	 * ��������Դ  �������ݿ��� ��ʹ��Ӳ����Ĭ�ϲ���
	 * �ֶ���Ӳ���
	 * @param connectURI
	 * @param username
	 * @param pswd
	 * @param driverClass
	 * @param initialSize
	 * @param maxActive
	 * @param maxIdle
	 * @param maxWait
	 * @param minIdle
	 */
	private void initDS(String connectURI, String username, String pswd,
			String driverClass, int initialSize, int maxtotal, int maxIdle,
			int maxWait, int minIdle) {
		// TODO Auto-generated method stub
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUsername(username);
		ds.setPassword(pswd);
		ds.setUrl(connectURI);
		ds.setInitialSize(initialSize);
		ds.setMaxTotal(maxtotal);
		ds.setMaxIdle(maxIdle);
		ds.setMaxWaitMillis(maxWait);
		ds.setMinIdle(minIdle);
		DS=ds;
		
	}
	private void initDS(String connectURI) {
		// TODO Auto-generated method stub
		
	}
}
