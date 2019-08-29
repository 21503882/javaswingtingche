package com.parking.dao;

import java.sql.SQLException;

import com.parking.bean.BaseClass;
import com.parking.bean.ParkingBank;
import com.parking.bean.ParkingCurrenBank;
import com.parking.bean.ParkingMessage;
import com.parking.constant.SqlConstans;
import com.parking.db.Dbutil;
/**
 * 
* @author:chen.yi 
* @date： 日期：2015-12-14 时间：下午3:21:31
* @version 1.0
* @see ParkingMessage的dao类
 */
public class ParkingMessageDao extends CommonDao implements CommonInf {

	public boolean insert(BaseClass bc) {
		try {
			ParkingMessage pm = new ParkingMessage();
			if(pm instanceof ParkingMessage){
				pm = (ParkingMessage) bc;
			}
			conn =  this.getConn();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SqlConstans.PARKING_MESSAGE_INSERT);
			ps.setInt(1, pm.getParking_area());
			ps.setString(2, pm.getCar_message());
			ps.setString(3, pm.getParking_time());
			ps.setString(4, pm.getLeave_time());
			ps.setString(5, pm.getParking_id());
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
			ParkingMessage pm = new ParkingMessage();
			if(pm instanceof ParkingMessage){
				pm = (ParkingMessage) bc;
			}
			conn = this.getConn();
			ps = conn.prepareStatement("");
			rs = ps.executeQuery();
			while(rs.next()){
//				pcb.setNowScore(rs.getString("nowScore"));
//				pcb.setRecordScore(rs.getInt("RecordScore"));
//				pcb.setRecordSeries(rs.getString("RecordSeries"));
//				return pcb;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		return null;
	}

	public boolean update(BaseClass bc) {
		try {
			ParkingMessage pm = new ParkingMessage();
			if(pm instanceof ParkingMessage){
				pm = (ParkingMessage) bc;
			}
			conn = this.getConn();
			ps = conn.prepareStatement(SqlConstans.PARKING_MESSAGE_UPDATE);
			ps.setString(1, pm.getLeave_time());
			ps.setString(2, pm.getParking_id());
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
			ps = conn.prepareStatement(SqlConstans.PARKING_MESSAGE_DELETE);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Dbutil.close(conn, ps, rs);
		}
		
	}

}
