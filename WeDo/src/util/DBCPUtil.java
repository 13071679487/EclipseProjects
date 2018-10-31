package util;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * DBCP配置类
 * @author lenovo
 *
 */
public class DBCPUtil {
   /** 数据源*/
	private static DataSource DS;
	private static final String configFile="/dbcp.properties";
	
	/** 从数据源获得一个连接*/
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
	/** 默认的构造函数*/
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
	/** 构造函数 初始化DS 指定  数据库*/
	public DBCPUtil(String connectURI){
		initDS(connectURI);
	}
	/** 构造函数 初始化DS 指定  所有参数*/
	public DBCPUtil(String connectURI,String username,String pswd,
			String driverClass,int initialSize,int maxActive,int maxIdle,
			int maxWait,int minIdle){
		initDS(connectURI,username, pswd,driverClass,initialSize, 
				maxActive, maxIdle,maxWait, minIdle);
	}
	/**
	 * 创建数据源  除了数据库外 都使用硬编码默认参数
	 * 手动添加参数
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
