package com.parking.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.parking.bean.BaseClass;


/**
 * ���ݿ⹤����
 * @author chen.yi
 *
 */
public class Dbutil extends BaseClass{
	
	//�����ӳ��л�ȡһ�����ݿ�
	public static  Connection getCon(){
		try {
			return ConnectionSource.getConnection();
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ������쳣");
		}
		return null;
	}
	
	//�ͷ���Դ
	public static void close(Connection con, Statement stmt, ResultSet rs){
		ConnectionSource.close(con, stmt, rs);
	}
	
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/*
	 * ʱ�乤�߷���
	 */
	 public static String getFormatedDate() {
	        Date date = getCurrentDate();
	        SimpleDateFormat dateFormator = new SimpleDateFormat(DATE_TIME_FORMAT);
	        return dateFormator.format(date);

	    }
	 /*
	  * ��ȡ��ǰʱ��
	  */
	 public static Date getCurrentDate() {
	        return new Date(System.currentTimeMillis());
	    }

	
	
	public static void main(String[] args){
		System.out.println(Dbutil.getCon());
	}
}
