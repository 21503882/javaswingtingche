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
* @date�� ���ڣ�2015-12-15 ʱ�䣺����11:54:09
* @version 1.0
* @see ģ��ͣ��������Ҫ��ʾͣ����һЩ��Ϣ
 */
public class WorkFrame extends BaseClass {
	private static final long serialVersionUID = 1L;
    // �������� - �������޸�
    private JButton jbtnEnter;
    private JButton jbtnRefrush;
    private JTextArea jtexInfor;
    public int m_areaCount; //ͣ��������
//    public int[] m_nos;     //ÿ��ͣ�����ĳ�λ��
//    public int[] m_apare;   //ÿ��ͣ�����Ŀ��г�λ��
    //  ������������
    public String stop_car_message ;//��ǰͣ����ͣ������Ϣ
    
    public WorkFrame(InitFrame frm) {
    	this.m_areaCount = WorkFrame.getAreaCount();
        initComponents();
    }
    
    /*
     * ��ʼ��ͣ����
     */
    private void initComponents() {
    	
        jbtnEnter = new JButton();
        
        jbtnRefrush = new JButton();
        
        jtexInfor = new JTextArea("ͣ������ʼ�������\n" + getStopStatus());
        
        jtexInfor.setEnabled(false);
       
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setTitle("ͣ����ģ��");
        
        jbtnEnter.setText("����ͣ����");
        
        jbtnRefrush.setText("ˢ��");
        
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
    	this.jtexInfor.setText("ͣ������ǰ������λ״��ͳ�ƣ�\n" + getStopStatus());        
    }
    
    public String getStopStatus() {
    	String str = "";
    	for (int i = 0; i < m_areaCount; i++) {
    		if (getCurrenAreaCarNum(i+1) > 0) {
    			str += "  " + (i + 1) + " ���ܳ�λ��" + WorkFrame.getAreaCarNum(i+1) + "\t��ǰ���г�λ " + getCurrenAreaCarNum(i+1) + " ��\n";
    		} else {
    			str += "  " + (i + 1) + " ���ܳ�λ��" + WorkFrame.getAreaCarNum(i+1) + "\t��ǰ���޿��г�λ\n";
    		}   		
    	}
    	return str;
    }
    
    /**
     * ȡ��ǰͣ��������ʣ�Ŀ��г�λ
     */
    public  static int getCurrenAreaCarNum(int currenArea){
    	ParkingCurrenBank pcb = new ParkingCurrenBank();
    	pcb.setParking_curren_area(currenArea);
    	pcb =  (ParkingCurrenBank) pcbDao.query(pcb);
    	return pcb.getParking_curren_num();
    }
    
    /**
     * ��ȡÿ�����еĳ�λ��
     */
    public static int getAreaCarNum(int currenArea){
    	ParkingBank pb = new ParkingBank();
    	pb.setParking_area(currenArea);
    	pb =  (ParkingBank) pbDao.query(pb);
    	return pb.getParking_num();
    }
    /**
     * ��ȡͣ�����ĸ���
     * @param infor
     */
    public static int getAreaCount(){
    	int countAreaNum =  pbDao.queryAll();
    	return countAreaNum;
    }
  
    /**
     * ��ȡ��ǰͣ��������Ϣ
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
