package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;


import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@WebListener
public class DBCPInitListener extends HttpServlet implements ServletContextListener {
     
	// poolConfig �а� JDBC����̹� �ε�, Ŀ�ؼ�Ǯ �ʱ�ȭ
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String poolConfig =
				sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		try {
			prop.load(new StringReader(poolConfig));
		} catch (IOException e) {
			throw new RuntimeException("config load fail", e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}
	

	/*
	 * Properties��ü�� �޾� "jdbcdriver"��� key�� ���� value���� �̸����� �ϴ�
	 * Ŭ����(JDBC����̹�)�� �ε�
	 */
	private void loadJDBCDriver(Properties prop) {
		String driverClass = prop.getProperty("jdbcdriver");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}
	
	
	/*
	 * Properties��ü���޾� DB�ּ�, ����id/pw�� string������ ����
	 * ���� ������ �������� 
	 */
	private void initConnectionPool(Properties prop) {
		try {
			String jdbcUrl = prop.getProperty("jdbcUrl");
			String username = prop.getProperty("dbUser");
			String pw = prop.getProperty("dbPass");
			
			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);
			//�����ͺ��̽� ������ ����
			
			PoolableConnectionFactory poolableConnFactory =
					new PoolableConnectionFactory(connFactory, null);
			//��ü�� ������� ����. �����ϴ� �����ͺ��̽��� ���ٸ� null ���
			//Ű���� ���� ��ü�� �����Ͽ� Ǯ�� ����
			
			String validationQuery = prop.getProperty("validationQuery");
			if (validationQuery != null && !validationQuery.isEmpty()) {
				poolableConnFactory.setValidationQuery(validationQuery);
			}
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRuns(Duration.ofMillis(1000L*60L*5L));
			poolConfig.setTestWhileIdle(true);
			int minIdle = getIntProperty(prop, "minIdle", 5);
			poolConfig.setMinIdle(minIdle);
			int maxTotal = getIntProperty(prop, "maxTotal", 50);
			poolConfig.setMaxTotal(maxTotal);
			//Pool ��  Ŀ�ؼ� ������ ����
			
			GenericObjectPool<PoolableConnection> connectionPool =
					new GenericObjectPool<>(poolableConnFactory,poolConfig);
			//���� ���� �������� Ǯ ����
			poolableConnFactory.setPool(connectionPool);
			//Ŀ�ؼ��� Ǯ�� ����
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)
					DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("poolName");
			driver.registerPool(poolName, connectionPool);
			//Ǯ�� ����̹��� ���
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    private int getIntProperty(Properties prop, String propName, int defaultValue) {
    	String value = prop.getProperty(propName);
    	if (value==null) return defaultValue;
		return Integer.parseInt(value);
	}
    
    
    /*�� Ŭ������ ServletContextListener �������̽��� ������.
     * ServletContextListener�� �����ø����̼��� ���۵ǰų� ����� �� �߻��ϴ� 
     * �̺�Ʈ�� ó���ϴ� �������̽���
     * contextDestroyed�� ServletContextListener���� �������̵��ϴ� �޼����
     * ���ø����̼� ����� ������ ������.
     */
    @Override
	public void contextDestroyed(ServletContextEvent sce)  { 
    }
    

}
