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
* @date： 日期：2015-12-14 时间：下午3:19:20
* @version 1.0
* @see ParkingCurrenBank的dao类
 */
public class ParkingCurrenBankDao  extends CommonDao implements CommonInf {

	public boolean insert(BaseClass bc) {
		try {
			ParkingCurrenBank pcb = new ParkingCurrenBank();
			if(pcb instanceof ParkingCurrenBank){
				pcb = (ParkingCurrenBank) bc;
			}
			conn =  this.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SqlConstans.PARKING_CURREN_BANK_INSERT);
			ps.setInt(1, pcb.getParking_curren_area());
			ps.setInt(2, pcb.getParking_curren_num());
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
			ParkingCurrenBank pcb = new ParkingCurrenBank();
			if(bc instanceof ParkingCurrenBank){
				pcb = (ParkingCurrenBank) bc;
			}
			conn = this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_CURREN_BANK_SELECT);
			ps.setInt(1, pcb.getParking_curren_area());
			rs = ps.executeQuery();
			while(rs.next()){
				pcb.setParking_curren_num(rs.getInt("parking_curren_num"));
			}
			return pcb;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		return null;
	}

	public boolean update(BaseClass bc) {
		try {
			ParkingCurrenBank pcb = new ParkingCurrenBank();
			if(pcb instanceof ParkingCurrenBank){
				pcb = (ParkingCurrenBank) bc;
			}
			conn = this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_CURREN_BANK_UPDATE);
			ps.setInt(1,pcb.getParking_curren_num());
			ps.setInt(2, pcb.getParking_curren_area());
			boolean b = ps.execute();
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		return false;
	}

	public void delete() {
		
		try {
			conn =  this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_CURREN_BANK_DELETE);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		
	}

}
