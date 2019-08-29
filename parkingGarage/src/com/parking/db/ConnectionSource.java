package com.parking.db;

import java.util.Properties;
import java.sql.*;
import org.apache.commons.dbcp.BasicDataSource;

import com.parking.bean.BaseClass;

/**
 * ���ݿ����ӳض���
 * @author chen.yi
 *
 */
public class ConnectionSource extends BaseClass{
	private static BasicDataSource dataSource;

	
	/**
	 * ��ʼ�����ݿ����ӳض���
	 */
	private static void init() {
		try {
			// ����Properties����
			Properties prop = new Properties();
			// ����
			prop.load(ConnectionSource.class.getClassLoader()
					.getResourceAsStream("com/parking/db/" + "db.properties"));
			// ��ȡ
			// 1����ȡjdbc
			String driver = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			// 2����ȡdataSource
			String initialSize = prop
					.getProperty("dataSource." + "initialSize");
			String maxActive = prop.getProperty("dataSource." + "maxActive");
			String maxIdle = prop.getProperty("dataSource.maxIdle");
			String minIdle = prop.getProperty("dataSource.minIdle");
			String maxWait = prop.getProperty("dataSource.maxWait");
			String minActive = prop.getProperty("dataSource.minActive");
			// ����dataSource����
			dataSource = new BasicDataSource();
			// ΪdataSource����ֵ
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			if (initialSize != null)
				dataSource.setInitialSize(Integer.parseInt(initialSize));
			if (maxActive != null)
				dataSource.setMaxActive(Integer.parseInt(maxActive));
			if (maxIdle != null)
				dataSource.setMaxIdle(Integer.parseInt(maxIdle));
			if (minIdle != null)
				dataSource.setMinIdle(Integer.parseInt(minIdle));
			if (maxWait != null)
				dataSource.setMaxWait(Integer.parseInt(maxWait));
		} catch (Exception e) {
			System.out.println("�������ӳ�ʧ��");
		}
	}

	/**
	 * �����ӳ��л�ȡ���Ӷ���
	 * 
	 * @return
	 */
	public synchronized static Connection getConnection() throws SQLException {
		if (dataSource == null)
			init();
		Connection con = dataSource.getConnection();
		return con;
	}

	/**
	 * �ͷ�������Դ
	 * 
	 * @param con
	 *            �������ӻ������ӳ�
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("�ر���Դ�쳣");
			e.printStackTrace();
		}
	}

}
