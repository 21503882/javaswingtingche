package com.parking.Frame;
import javax.swing.*;

import com.parking.bean.BaseClass;
import com.parking.bean.ParkingCurrenBank;
import com.parking.bean.ParkingMessage;
import com.parking.db.Dbutil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
* @author:chen.yi 
* @date： 日期：2015-12-15 时间：上午10:46:47
* @version 1.0
* @see 停车操作
 */
public class carJFrame extends BaseClass {
	private static final long serialVersionUID = 1L;

    // 变量声明 - 不进行修改
    private JButton jbtnEnterStop;
    private JButton jbtnLeftArea;
    private JButton jbtnLeftStop;
    private JButton jbtnLookUpArea;
    private JButton jbtnLookupPosition;
    private WorkFrame mainFram;
    private int chooseArea;
    private String parking_id;
    // 变量声明结束
    
    
    public carJFrame(WorkFrame frm) {
        initComponents();
        mainFram = frm;
    }
    

    /**
     * 这个方法主要是做初始化操作，初始化停车场的界面。
     */
    private void initComponents() {
        jbtnEnterStop = new JButton();
        jbtnLookUpArea = new JButton();
        jbtnLookupPosition = new JButton();
        jbtnLeftArea = new JButton();
        jbtnLeftStop = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("停车场操作");
        
        
        jbtnEnterStop.setText("进入停车场");
        /*
         * 监听进入停车场的操作
         */
        jbtnEnterStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnEnterStopActionPerformed(evt);
            }
        });

        
        jbtnLookUpArea.setText("寻找停车区");
        /*
         * 监听寻找停车区的操作
         */
        jbtnLookUpArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLookUpAreaActionPerformed(evt);
            }
        });

        
        jbtnLookupPosition.setText("寻找停车位");
        /*
         * 监听寻找停车位的操作
         */
        jbtnLookupPosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLookupPositionActionPerformed(evt);
            }
        });

        
        jbtnLeftArea.setText("离开停车区");
        /*
         * 监听离开停车区的操作
         */
        jbtnLeftArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLeftAreaActionPerformed(evt);
            }
        });

        jbtnLeftStop.setText("离开停车场");
        /*
         * 监听离开停车场的操作
         */
        jbtnLeftStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLeftStopActionPerformed(evt);
            }
        });
        
        /*
         * 让各个按钮显示可见状态
         */
        jbtnEnterStop.setEnabled(true);
        jbtnLookUpArea.setEnabled(false);
        jbtnLookupPosition.setEnabled(false);
        jbtnLeftArea.setEnabled(false);
        jbtnLeftStop.setEnabled(false);
        
        
        addWindowListener(new WindowAdapter() {
        	//监听窗口关闭操作
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnLeftStop)
                    .addComponent(jbtnLeftArea)
                    .addComponent(jbtnLookupPosition)
                    .addComponent(jbtnLookUpArea)
                    .addComponent(jbtnEnterStop))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jbtnEnterStop)
                .addGap(20, 20, 20)
                .addComponent(jbtnLookUpArea)
                .addGap(22, 22, 22)
                .addComponent(jbtnLookupPosition)
                .addGap(24, 24, 24)
                .addComponent(jbtnLeftArea)
                .addGap(19, 19, 19)
                .addComponent(jbtnLeftStop)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        
        pack();
        
    }

    private void jbtnLeftStopActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jbtnLeftStopActionPerformed
        //离开停车场，交存车卡
    	this.updateCarLeaveTime(parking_id);
    	JOptionPane.showMessageDialog(null, "停车卡收回，再见!");
/*    	jbtnEnterStop.setEnabled(true);
        jbtnLookUpArea.setEnabled(false);
        jbtnLookupPosition.setEnabled(false);
        jbtnLeftArea.setEnabled(false);
        jbtnLeftStop.setEnabled(false);
*/    	
    	this.setVisible(false);
		this.removeNotify();
		
    }

    private void jbtnLeftAreaActionPerformed(ActionEvent evt) {
        //离开停车区
    	int confirm = JOptionPane.showConfirmDialog(null, "确定要离开 " + chooseArea + " 号停车区?", "离开停车区", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {								
			this.updateOutCarNum(chooseArea);
//			mainFram.ClickRefrush();//刷新
			jbtnLeftArea.setEnabled(false);
			jbtnLookUpArea.setEnabled(true);
			jbtnLeftStop.setEnabled(true);
		} else if (confirm == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "您已放弃了离开该车区!");
			jbtnLookUpArea.setEnabled(true);
		} 
    	   	
    }

    private void jbtnLookupPositionActionPerformed(ActionEvent evt) {
    	if(WorkFrame.getCurrenAreaCarNum(chooseArea)>0){
	        //进入停车区，寻找停车位
	    	int confirm = JOptionPane.showConfirmDialog(null, "您已经选择了" + chooseArea + " 号停车区, " + "确定要进入该停车区?", "进行停车区寻找车位", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {	
				//确定停车
				this.updateInCarNum(chooseArea);
				//更新停车消息
				this.insertCarMessage(chooseArea,"12345");
	//			mainFram.ClickRefrush();
				jbtnLookUpArea.setEnabled(false);
				jbtnLookupPosition.setEnabled(false);
				jbtnLeftArea.setEnabled(true);
				jbtnLeftStop.setEnabled(false);
			} else if (confirm == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "您已放弃了进入该车区!");
				jbtnLookUpArea.setEnabled(true);
				jbtnLookupPosition.setEnabled(false);
			} 
		}else{
			JOptionPane.showMessageDialog(null, "车区已经停满了，请等候!");
		}
    	
    }

    private void jbtnLookUpAreaActionPerformed(ActionEvent evt) {
        //进入停车场，寻找停车区
    	ImageIcon icon = new ImageIcon("test.gif");
		int[] freeArea = getFreeArea();
		Object[] freeAreas = new Object[freeArea.length];
		if(freeAreas.length != 0){
		for (int i = 0; i < freeArea.length; i++) {
			freeAreas[i] = freeArea[i];
		}
		
		Integer choose = (Integer)JOptionPane.showInputDialog(null, "当前停车场状况: \n" + mainFram.getStopStatus() + "\n请选择一个空闲车区：", "当前可先空闲车区: ", JOptionPane.PLAIN_MESSAGE, icon, freeAreas, (Integer)freeAreas[0]);
		
		if (choose != null) {			
			JOptionPane.showMessageDialog(null, "您选择了进入" + choose.intValue() + "车区");
			chooseArea = choose.intValue();
			jbtnLookUpArea.setEnabled(false);
			jbtnLookupPosition.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "您没有选择车区!");
		}   	
		}else{
			JOptionPane.showMessageDialog(null, "车区已经停满了，请等候!");
		}
    }

    private void jbtnEnterStopActionPerformed(ActionEvent evt) {
        //领卡，进入停车场
    	boolean isFull = true;
    	//先判断是否有空闲的停车位
    	for (int i = 0; i < WorkFrame.getAreaCount(); i++) {
    		if (WorkFrame.getCurrenAreaCarNum(i+1) > 0) {
    			isFull = false;
    		} 		
    	}
    	if (isFull) {
    		JOptionPane.showMessageDialog(null, "当前车场无空闲车区，请稍后再试!");
    	} else {
    		jbtnEnterStop.setEnabled(false);
            jbtnLookUpArea.setEnabled(true);
            jbtnLookupPosition.setEnabled(false);
            jbtnLeftArea.setEnabled(false);
            jbtnLeftStop.setEnabled(false);
            JOptionPane.showMessageDialog(null, "成功领取停车卡，请进去车场寻找停车区位!");
    	}
   	
    }
    private void formWindowClosing(WindowEvent evt) {
    	int confirm = JOptionPane.showConfirmDialog(null, "确定退出?", "退出停车区", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			if (chooseArea > 0) {
				this.updateOutCarNum(chooseArea);	
				this.updateCarLeaveTime(parking_id);
			}
			this.setVisible(false);
			this.removeNotify();
		} else {
			this.setVisible(true);
		}
    }
    public int[] getFreeArea() {
    	int count = 0;
    	//查出有空闲车位的区的总数
    	for (int i = 0; i < WorkFrame.getAreaCount(); i++) {
    		if (WorkFrame.getCurrenAreaCarNum(i+1) > 0) {
    			count++;
    		} 		
    	}
    	int[] freeArea = new int[count];
    	
    	//取出哪个区有空闲的车位
    	for (int i = 0, j = 0; i < WorkFrame.getAreaCount(); i++) {
    		if (WorkFrame.getCurrenAreaCarNum(i+1) > 0) {
    			freeArea[j++] = i + 1;
    		} 		
    	}
    	return freeArea;
    }
    
    /**
     * 停车进停车场，更新空闲车位操作
     */
    public boolean updateInCarNum(int currenArea){
    	ParkingCurrenBank pcb = new ParkingCurrenBank();
    	pcb.setParking_curren_area(currenArea);
    	//先查询出当前区，有多少空闲的车位
    	pcb = (ParkingCurrenBank) pcbDao.query(pcb);
    	int curren_car_num = pcb.getParking_curren_num()-1;
    	pcb.setParking_curren_num(curren_car_num);
    	return pcbDao.update(pcb);
    }
    /**
     * 车离开，更新空闲车位的操作
     */
    public boolean updateOutCarNum(int currenArea){
    	ParkingCurrenBank pcb = new ParkingCurrenBank();
    	pcb.setParking_curren_area(currenArea);
    	//先查询出当前区，有多少空闲的车位
    	pcb = (ParkingCurrenBank) pcbDao.query(pcb);
    	int curren_car_num = pcb.getParking_curren_num()+1;
    	pcb.setParking_curren_num(curren_car_num);
    	return pcbDao.update(pcb);
    }
    /**
     * 保存停车消息
     */
    public boolean insertCarMessage(int parking_area ,String car_message){
    	ParkingMessage pm = new ParkingMessage();
    	parking_id = this.getParkingId();
    	pm.setParking_id(parking_id);
    	pm.setParking_area(parking_area);
    	pm.setCar_message(car_message);
    	pm.setParking_time(Dbutil.getFormatedDate());
    	return pmDao.insert(pm);
    }
    /**
     * 更新车离开的时间
     */
    public boolean updateCarLeaveTime(String parking_id){
    	ParkingMessage pm = new ParkingMessage();
    	pm.setParking_id(parking_id);
    	pm.setLeave_time(Dbutil.getFormatedDate());
    	return pmDao.update(pm);
    }
    
    /**
     * 取parking_id
     */
    public String getParkingId(){
    	//为了避免重复，取当前时间戳为pariking_id
    	return String.valueOf(System.currentTimeMillis());
    }
    
    
}
