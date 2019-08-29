package com.parking.db;

import java.util.Properties;
import java.sql.*;
import org.apache.commons.dbcp.BasicDataSource;

import com.parking.bean.BaseClass;

/**
 * 数据库连接池对象
 * @author chen.yi
 *
 */
public class ConnectionSource extends BaseClass{
	private static BasicDataSource dataSource;

	
	/**
	 * 初始化数据库连接池对象
	 */
	private static void init() {
		try {
			// 创建Properties对象
			Properties prop = new Properties();
			// 加载
			prop.load(ConnectionSource.class.getClassLoader()
					.getResourceAsStream("com/parking/db/" + "db.properties"));
			// 读取
			// 1、读取jdbc
			String driver = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			// 2、读取dataSource
			String initialSize = prop
					.getProperty("dataSource." + "initialSize");
			String maxActive = prop.getProperty("dataSource." + "maxActive");
			String maxIdle = prop.getProperty("dataSource.maxIdle");
			String minIdle = prop.getProperty("dataSource.minIdle");
			String maxWait = prop.getProperty("dataSource.maxWait");
			String minActive = prop.getProperty("dataSource.minActive");
			// 创建dataSource对象
			dataSource = new BasicDataSource();
			// 为dataSource设置值
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
			System.out.println("创建连接池失败");
		}
	}

	/**
	 * 从连接池中获取连接对象
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
	 * 释放所有资源
	 * 
	 * @param con
	 *            ：将连接还给连接池
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
			System.out.println("关闭资源异常");
			e.printStackTrace();
		}
	}

}
