package com.parking.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.parking.bean.BaseClass;


/**
 * 数据库工具类
 * @author chen.yi
 *
 */
public class Dbutil extends BaseClass{
	
	//从连接池中获取一个数据库
	public static  Connection getCon(){
		try {
			return ConnectionSource.getConnection();
		} catch (SQLException e) {
			System.out.println("获取数据库连接异常");
		}
		return null;
	}
	
	//释放资源
	public static void close(Connection con, Statement stmt, ResultSet rs){
		ConnectionSource.close(con, stmt, rs);
	}
	
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/*
	 * 时间工具方法
	 */
	 public static String getFormatedDate() {
	        Date date = getCurrentDate();
	        SimpleDateFormat dateFormator = new SimpleDateFormat(DATE_TIME_FORMAT);
	        return dateFormator.format(date);

	    }
	 /*
	  * 获取当前时间
	  */
	 public static Date getCurrentDate() {
	        return new Date(System.currentTimeMillis());
	    }

	
	
	public static void main(String[] args){
		System.out.println(Dbutil.getCon());
	}
}
