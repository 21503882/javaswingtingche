package com.parking.Frame;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.parking.bean.BaseClass;
import com.parking.bean.ParkingBank;
import com.parking.bean.ParkingCurrenBank;
import com.parking.thread.carThread;
/**
 * 
* @author:chen.yi 
* @date： 日期：2015-12-15 时间：上午11:54:09
* @version 1.0
* @see 模拟停车场，主要显示停车的一些信息
 */
public class WorkFrame extends BaseClass {
	private static final long serialVersionUID = 1L;
    // 变量声明 - 不进行修改
    private JButton jbtnEnter;
    private JButton jbtnRefrush;
    private JTextArea jtexInfor;
    public int m_areaCount; //停车区个数
//    public int[] m_nos;     //每个停车区的车位数
//    public int[] m_apare;   //每个停车区的空闲车位数
    //  变量声明结束
    public String stop_car_message ;//当前停车场停车的信息
    
    public WorkFrame(InitFrame frm) {
    	this.m_areaCount = WorkFrame.getAreaCount();
        initComponents();
    }
    
    /*
     * 初始化停车场
     */
    private void initComponents() {
    	
        jbtnEnter = new JButton();
        
        jbtnRefrush = new JButton();
        
        jtexInfor = new JTextArea("停车场初始化结果：\n" + getStopStatus());
        
        jtexInfor.setEnabled(false);
       
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setTitle("停车场模拟");
        
        jbtnEnter.setText("进入停车场");
        
        jbtnRefrush.setText("刷新");
        
        jbtnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnEnterActionPerformed(evt);
            }
        });
        
        jbtnRefrush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnRefrushActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jtexInfor)
                .addComponent(jbtnRefrush)
                .addComponent(jbtnEnter)               
                .addGap(128, 128, 128))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(jtexInfor)
                .addComponent(jbtnRefrush)
                .addComponent(jbtnEnter)
                .addGap(73, 73, 73))
        );
        
        pack();
        
    }

    private void jbtnEnterActionPerformed(ActionEvent evt) {
        Thread thr = new carThread(this);
        thr.run();
    }
    
    private void jbtnRefrushActionPerformed(ActionEvent evt) {
    	this.jtexInfor.setText("停车场当前车区车位状况统计：\n" + getStopStatus());        
    }
    
    public String getStopStatus() {
    	String str = "";
    	for (int i = 0; i < m_areaCount; i++) {
    		if (getCurrenAreaCarNum(i+1) > 0) {
    			str += "  " + (i + 1) + " 区总车位：" + WorkFrame.getAreaCarNum(i+1) + "\t当前空闲车位 " + getCurrenAreaCarNum(i+1) + " 个\n";
    		} else {
    			str += "  " + (i + 1) + " 区总车位：" + WorkFrame.getAreaCarNum(i+1) + "\t当前区无空闲车位\n";
    		}   		
    	}
    	return str;
    }
    
    /**
     * 取当前停车区中所剩的空闲车位
     */
    public  static int getCurrenAreaCarNum(int currenArea){
    	ParkingCurrenBank pcb = new ParkingCurrenBank();
    	pcb.setParking_curren_area(currenArea);
    	pcb =  (ParkingCurrenBank) pcbDao.query(pcb);
    	return pcb.getParking_curren_num();
    }
    
    /**
     * 获取每个区中的车位数
     */
    public static int getAreaCarNum(int currenArea){
    	ParkingBank pb = new ParkingBank();
    	pb.setParking_area(currenArea);
    	pb =  (ParkingBank) pbDao.query(pb);
    	return pb.getParking_num();
    }
    /**
     * 获取停车区的个数
     * @param infor
     */
    public static int getAreaCount(){
    	int countAreaNum =  pbDao.queryAll();
    	return countAreaNum;
    }
  
    /**
     * 获取当前停车场的信息
     * @return
     */
    public  String getStopCarMessage(){
    	stop_car_message = "";
    	
    	return stop_car_message;
    }
    
    public void ClickRefrush(){
    	EventQueue queue = Toolkit.getDefaultToolkit().getSystemEventQueue();
    	queue.postEvent(new ActionEvent(jbtnRefrush, ActionEvent.ACTION_PERFORMED, "refrush"));
    }
    
    public void setInfor(String infor) {
    	this.jtexInfor.setText(infor);
    }
    
}
