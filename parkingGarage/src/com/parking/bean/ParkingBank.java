package com.parking.bean;


/**
 * 初始化存储停车库的信息，有区域和每个区域的停车数目信息。
 * @author chen.yi
 *
 */
public class ParkingBank extends BaseClass{
	private int parking_area;
	private int parking_num;
	public int getParking_area() {
		return parking_area;
	}
	public void setParking_area(int parking_area) {
		this.parking_area = parking_area;
	}
	public int getParking_num() {
		return parking_num;
	}
	public void setParking_num(int parking_num) {
		this.parking_num = parking_num;
	}
	
}
