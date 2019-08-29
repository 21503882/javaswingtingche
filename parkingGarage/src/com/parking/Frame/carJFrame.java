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
* @date�� ���ڣ�2015-12-15 ʱ�䣺����10:46:47
* @version 1.0
* @see ͣ������
 */
public class carJFrame extends BaseClass {
	private static final long serialVersionUID = 1L;

    // �������� - �������޸�
    private JButton jbtnEnterStop;
    private JButton jbtnLeftArea;
    private JButton jbtnLeftStop;
    private JButton jbtnLookUpArea;
    private JButton jbtnLookupPosition;
    private WorkFrame mainFram;
    private int chooseArea;
    private String parking_id;
    // ������������
    
    
    public carJFrame(WorkFrame frm) {
        initComponents();
        mainFram = frm;
    }
    

    /**
     * ���������Ҫ������ʼ����������ʼ��ͣ�����Ľ��档
     */
    private void initComponents() {
        jbtnEnterStop = new JButton();
        jbtnLookUpArea = new JButton();
        jbtnLookupPosition = new JButton();
        jbtnLeftArea = new JButton();
        jbtnLeftStop = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ͣ��������");
        
        
        jbtnEnterStop.setText("����ͣ����");
        /*
         * ��������ͣ�����Ĳ���
         */
        jbtnEnterStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnEnterStopActionPerformed(evt);
            }
        });

        
        jbtnLookUpArea.setText("Ѱ��ͣ����");
        /*
         * ����Ѱ��ͣ�����Ĳ���
         */
        jbtnLookUpArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLookUpAreaActionPerformed(evt);
            }
        });

        
        jbtnLookupPosition.setText("Ѱ��ͣ��λ");
        /*
         * ����Ѱ��ͣ��λ�Ĳ���
         */
        jbtnLookupPosition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLookupPositionActionPerformed(evt);
            }
        });

        
        jbtnLeftArea.setText("�뿪ͣ����");
        /*
         * �����뿪ͣ�����Ĳ���
         */
        jbtnLeftArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLeftAreaActionPerformed(evt);
            }
        });

        jbtnLeftStop.setText("�뿪ͣ����");
        /*
         * �����뿪ͣ�����Ĳ���
         */
        jbtnLeftStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnLeftStopActionPerformed(evt);
            }
        });
        
        /*
         * �ø�����ť��ʾ�ɼ�״̬
         */
        jbtnEnterStop.setEnabled(true);
        jbtnLookUpArea.setEnabled(false);
        jbtnLookupPosition.setEnabled(false);
        jbtnLeftArea.setEnabled(false);
        jbtnLeftStop.setEnabled(false);
        
        
        addWindowListener(new WindowAdapter() {
        	//�������ڹرղ���
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
        //�뿪ͣ���������泵��
    	this.updateCarLeaveTime(parking_id);
    	JOptionPane.showMessageDialog(null, "ͣ�����ջأ��ټ�!");
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
        //�뿪ͣ����
    	int confirm = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�뿪 " + chooseArea + " ��ͣ����?", "�뿪ͣ����", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {								
			this.updateOutCarNum(chooseArea);
//			mainFram.ClickRefrush();//ˢ��
			jbtnLeftArea.setEnabled(false);
			jbtnLookUpArea.setEnabled(true);
			jbtnLeftStop.setEnabled(true);
		} else if (confirm == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "���ѷ������뿪�ó���!");
			jbtnLookUpArea.setEnabled(true);
		} 
    	   	
    }

    private void jbtnLookupPositionActionPerformed(ActionEvent evt) {
    	if(WorkFrame.getCurrenAreaCarNum(chooseArea)>0){
	        //����ͣ������Ѱ��ͣ��λ
	    	int confirm = JOptionPane.showConfirmDialog(null, "���Ѿ�ѡ����" + chooseArea + " ��ͣ����, " + "ȷ��Ҫ�����ͣ����?", "����ͣ����Ѱ�ҳ�λ", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {	
				//ȷ��ͣ��
				this.updateInCarNum(chooseArea);
				//����ͣ����Ϣ
				this.insertCarMessage(chooseArea,"12345");
	//			mainFram.ClickRefrush();
				jbtnLookUpArea.setEnabled(false);
				jbtnLookupPosition.setEnabled(false);
				jbtnLeftArea.setEnabled(true);
				jbtnLeftStop.setEnabled(false);
			} else if (confirm == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "���ѷ����˽���ó���!");
				jbtnLookUpArea.setEnabled(true);
				jbtnLookupPosition.setEnabled(false);
			} 
		}else{
			JOptionPane.showMessageDialog(null, "�����Ѿ�ͣ���ˣ���Ⱥ�!");
		}
    	
    }

    private void jbtnLookUpAreaActionPerformed(ActionEvent evt) {
        //����ͣ������Ѱ��ͣ����
    	ImageIcon icon = new ImageIcon("test.gif");
		int[] freeArea = getFreeArea();
		Object[] freeAreas = new Object[freeArea.length];
		if(freeAreas.length != 0){
		for (int i = 0; i < freeArea.length; i++) {
			freeAreas[i] = freeArea[i];
		}
		
		Integer choose = (Integer)JOptionPane.showInputDialog(null, "��ǰͣ����״��: \n" + mainFram.getStopStatus() + "\n��ѡ��һ�����г�����", "��ǰ���ȿ��г���: ", JOptionPane.PLAIN_MESSAGE, icon, freeAreas, (Integer)freeAreas[0]);
		
		if (choose != null) {			
			JOptionPane.showMessageDialog(null, "��ѡ���˽���" + choose.intValue() + "����");
			chooseArea = choose.intValue();
			jbtnLookUpArea.setEnabled(false);
			jbtnLookupPosition.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "��û��ѡ����!");
		}   	
		}else{
			JOptionPane.showMessageDialog(null, "�����Ѿ�ͣ���ˣ���Ⱥ�!");
		}
    }

    private void jbtnEnterStopActionPerformed(ActionEvent evt) {
        //�쿨������ͣ����
    	boolean isFull = true;
    	//���ж��Ƿ��п��е�ͣ��λ
    	for (int i = 0; i < WorkFrame.getAreaCount(); i++) {
    		if (WorkFrame.getCurrenAreaCarNum(i+1) > 0) {
    			isFull = false;
    		} 		
    	}
    	if (isFull) {
    		JOptionPane.showMessageDialog(null, "��ǰ�����޿��г��������Ժ�����!");
    	} else {
    		jbtnEnterStop.setEnabled(false);
            jbtnLookUpArea.setEnabled(true);
            jbtnLookupPosition.setEnabled(false);
            jbtnLeftArea.setEnabled(false);
            jbtnLeftStop.setEnabled(false);
            JOptionPane.showMessageDialog(null, "�ɹ���ȡͣ���������ȥ����Ѱ��ͣ����λ!");
    	}
   	
    }
    private void formWindowClosing(WindowEvent evt) {
    	int confirm = JOptionPane.showConfirmDialog(null, "ȷ���˳�?", "�˳�ͣ����", JOptionPane.YES_NO_OPTION);
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
    	//����п��г�λ����������
    	for (int i = 0; i < WorkFrame.getAreaCount(); i++) {
    		if (WorkFrame.getCurrenAreaCarNum(i+1) > 0) {
    			count++;
    		} 		
    	}
    	int[] freeArea = new int[count];
    	
    	//ȡ���ĸ����п��еĳ�λ
    	for (int i = 0, j = 0; i < WorkFrame.getAreaCount(); i++) {
    		if (WorkFrame.getCurrenAreaCarNum(i+1) > 0) {
    			freeArea[j++] = i + 1;
    		} 		
    	}
    	return freeArea;
    }
    
    /**
     * ͣ����ͣ���������¿��г�λ����
     */
    public boolean updateInCarNum(int currenArea){
    	ParkingCurrenBank pcb = new ParkingCurrenBank();
    	pcb.setParking_curren_area(currenArea);
    	//�Ȳ�ѯ����ǰ�����ж��ٿ��еĳ�λ
    	pcb = (ParkingCurrenBank) pcbDao.query(pcb);
    	int curren_car_num = pcb.getParking_curren_num()-1;
    	pcb.setParking_curren_num(curren_car_num);
    	return pcbDao.update(pcb);
    }
    /**
     * ���뿪�����¿��г�λ�Ĳ���
     */
    public boolean updateOutCarNum(int currenArea){
    	ParkingCurrenBank pcb = new ParkingCurrenBank();
    	pcb.setParking_curren_area(currenArea);
    	//�Ȳ�ѯ����ǰ�����ж��ٿ��еĳ�λ
    	pcb = (ParkingCurrenBank) pcbDao.query(pcb);
    	int curren_car_num = pcb.getParking_curren_num()+1;
    	pcb.setParking_curren_num(curren_car_num);
    	return pcbDao.update(pcb);
    }
    /**
     * ����ͣ����Ϣ
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
     * ���³��뿪��ʱ��
     */
    public boolean updateCarLeaveTime(String parking_id){
    	ParkingMessage pm = new ParkingMessage();
    	pm.setParking_id(parking_id);
    	pm.setLeave_time(Dbutil.getFormatedDate());
    	return pmDao.update(pm);
    }
    
    /**
     * ȡparking_id
     */
    public String getParkingId(){
    	//Ϊ�˱����ظ���ȡ��ǰʱ���Ϊpariking_id
    	return String.valueOf(System.currentTimeMillis());
    }
    
    
}
