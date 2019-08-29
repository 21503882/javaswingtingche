package com.parking.bean;
/**
 * 当前停车库中，剩余车位的信息。
 * @author chen.yi
 *
 */
public class ParkingCurrenBank extends BaseClass{
	private int parking_curren_area;
	private int parking_curren_num;
	public int getParking_curren_area() {
		return parking_curren_area;
	}
	public void setParking_curren_area(int parking_curren_area) {
		this.parking_curren_area = parking_curren_area;
	}
	public int getParking_curren_num() {
		return parking_curren_num;
	}
	public void setParking_curren_num(int parking_curren_num) {
		this.parking_curren_num = parking_curren_num;
	}
	
	
}
