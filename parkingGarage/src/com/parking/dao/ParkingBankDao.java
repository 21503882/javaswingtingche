package com.parking.dao;
import java.sql.SQLException;

import com.parking.bean.BaseClass;
import com.parking.bean.ParkingBank;
import com.parking.bean.ParkingCurrenBank;
import com.parking.constant.SqlConstans;
import com.parking.db.Dbutil;
/**
 * 
* @author:chen.yi 
* @date： 日期：2015-12-14 时间：下午3:17:27
* @version 1.0
* @see ParkingBank的dao类
 */
public class ParkingBankDao  extends CommonDao  implements CommonInf{

	public boolean insert(BaseClass bc) {
		try {
			ParkingBank pb = new ParkingBank();
			if(pb instanceof ParkingBank){
				pb = (ParkingBank) bc;
			}
			conn =  this.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SqlConstans.PARKING_BANK_INSERT);
			ps.setInt(1, pb.getParking_area());
			ps.setInt(2, pb.getParking_num());
			boolean b = ps.execute();
			conn.commit();
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		return false;
	}

	public Object query(BaseClass bc) {
		try {
			ParkingBank pb = new ParkingBank();
			if(bc instanceof ParkingBank){
				pb = (ParkingBank) bc;
			}
			conn = this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_BANK_QUERY);
			ps.setInt(1, pb.getParking_area());
			rs = ps.executeQuery();
			while(rs.next()){
				pb.setParking_num(rs.getInt("parking_num"));
			}
			return pb;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		return null;
	}
	
	public int queryAll(){
		try {
			conn =  this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_BANK_QUERYALL);
			rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("areaCount");
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		return 0;
	}

	public boolean update(BaseClass bc) {
		// TODO Auto-generated method stub
		return false;
	}

	public void delete() {
		
		try {
			conn =  this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_BANK_DELETE);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		
	}

}
