package com.parking.bean;

import com.parking.db.Dbutil;

/**
 * 
 * @author chen.yi
 *
 */
public class ParkingMessage  extends BaseClass{
	private String parking_id  ;//id��Ψһ��ʶ
	private int parking_area;//ͣ������
	private String car_message;//������Ϣ
	private String parking_time;//ͣ��ʱ��
	private String leave_time;//�뿪��ʱ��
	
	
	
	
	public String getParking_id() {
		return parking_id;
	}
	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}
	public int getParking_area() {
		return parking_area;
	}
	public void setParking_area(int parking_area) {
		this.parking_area = parking_area;
	}
	public String getCar_message() {
		return car_message;
	}
	public void setCar_message(String car_message) {
		this.car_message = car_message;
	}
	public String getParking_time() {
//		this.parking_time = Dbutil.getFormatedDate();
		return parking_time;
	}
	public void setParking_time(String parking_time) {
		this.parking_time = parking_time;
	}
	public String getLeave_time() {
//		this.leave_time = Dbutil.getFormatedDate();
		return leave_time;
	}
	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}
	
}
