package com.parking.bean;

import javax.swing.JFrame;

import com.parking.dao.ParkingBankDao;
import com.parking.dao.ParkingCurrenBankDao;
import com.parking.dao.ParkingMessageDao;

/**
 * ���࣬���������ת��
 * @author chen.yi
 *
 */
public class BaseClass extends JFrame{
	public static final ParkingMessageDao pmDao = new ParkingMessageDao();
	public static final ParkingBankDao pbDao = new ParkingBankDao();
	public static final ParkingCurrenBankDao pcbDao = new ParkingCurrenBankDao();
}

