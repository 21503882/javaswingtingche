package com.parking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.parking.bean.BaseClass;
import com.parking.db.Dbutil;

/**
 * ¹«¹²dao
 * @author chen.yi
 *
 */
public class CommonDao extends BaseClass{
	public  Connection conn ;
	public  PreparedStatement ps;
	public  ResultSet rs;
	
	
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public Connection getConn() {
		conn  = Dbutil.getCon();
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getPs() {
		return ps;
	}
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}
	
	
}
