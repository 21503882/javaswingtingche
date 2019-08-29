package com.parking.constant;
/**
 * sql”Ôæ‰
 * @author chen.yi
 *
 */
public class SqlConstans {
		
	
	  public static final String PARKING_BANK_INSERT=  "insert into parking_bank values(?,?)";
	  
	  public static final String PARKING_BANK_QUERYALL = "select count(*) areaCount from parking_bank";
	  
	  public static final String PARKING_BANK_QUERY = "select * from parking_bank where parking_area = ?";
	  
	  public static final String PARKING_BANK_DELETE = "delete from parking_bank";
	  
	  public static final String PARKING_CURREN_BANK_INSERT = "insert into parking_curren_bank values(?,?)";
	  
	  public static final String PARKING_CURREN_BANK_SELECT = "select * from parking_curren_bank where parking_curren_area=?";
	  
	  public static final String PARKING_CURREN_BANK_UPDATE = "update parking_curren_bank set parking_curren_num = ? where parking_curren_area = ? ";
	  
	  public static final String PARKING_CURREN_BANK_DELETE = "delete from parking_curren_bank";
	  
	  public static final String PARKING_MESSAGE_INSERT = "insert into parking_message values(?,?,?,?,?)";
	  
	  public static final String PARKING_MESSAGE_SELECT = "select * from parking_message";
	  
	  public static final String PARKING_MESSAGE_UPDATE = "update parking_message set leave_time = ? where parking_id = ? ";
	  
	  public static final String PARKING_MESSAGE_DELETE = "delete from parking_message";
	  
	
}
