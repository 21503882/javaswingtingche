package com.parking.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import com.parking.bean.BaseClass;
import com.parking.bean.ParkingBank;
import com.parking.bean.ParkingCurrenBank;

/**
 * 
* @author:chen.yi 
* @date�� ���ڣ�2015-12-15 ʱ�䣺����10:59:30
* @version 1.0
* @see ��ʼ��ͣ��������Ϣ�����ʼ��ͣ�������ͣ��λ��������Ϣ
 */
public class InitFrame extends BaseClass {
	//�������� - �������޸�
	private JButton jButton1;//����ͣ����λ��ť
    private JLabel jLabel1;//ͣ��������
    private JLabel jLabel2;//
    private JLabel jLabel3;//
    private JSpinner jSpinnerStopArea;//
    private JButton jbtnCancel;//ȡ����ť
    private JButton jbtnOK;//ȷ����ť
    public JButton jbtnStopCount;//����ͣ����������ť
    private JTextField jtxtCarCount;//ͣ��������Ŀ
    private JTextField jtxtStopCount;//ͣ������ĸ���
    public int m_Area[];
    public int car_area;//ͣ��������
    SpinnerNumberModel mdl;
    // ������������
    
    
    public InitFrame() {
        initComponents();
        mdl = new SpinnerNumberModel();
        this.jSpinnerStopArea.setModel(mdl);
    }
      
    /**
     * ��ʼ��ͣ��������
     */
    private void initComponents() { 
    	
        jLabel1 = new JLabel();
        jtxtStopCount = new JTextField();
        jbtnStopCount = new JButton();
        jLabel2 = new JLabel();
        jSpinnerStopArea = new JSpinner();
        jLabel3 = new JLabel();
        jtxtCarCount = new JTextField();
        jButton1 = new JButton();
        jbtnOK = new JButton();
        jbtnCancel = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        setTitle("ͣ����ʼ��");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("ͣ���������");

        jbtnStopCount.setText("����ͣ��������");
        /*
         * ��������ͣ���������Ķ���
         */
        jbtnStopCount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnStopCountActionPerformed(evt);
            }
        });

        jLabel2.setText("ͣ������");

        jSpinnerStopArea.setEnabled(false);

        jLabel3.setText("ͣ��λ����");

        jtxtCarCount.setEnabled(false);

        jButton1.setText("����ͣ����λ����");
        /*
         * ��������ͣ����λ��������Ϣ
         */
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtnOK.setText("ȷ��");
        
        jbtnOK.setEnabled(false);
        
        jbtnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnOKActionPerformed(evt);
            }
        });

        jbtnCancel.setText("ȡ��");
        
        jbtnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerStopArea, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jtxtCarCount, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(jtxtStopCount, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jbtnStopCount))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(jbtnOK, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGap(51, 51, 51))
        );
        
        layout.setVerticalGroup( 
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtStopCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnStopCount))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerStopArea, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtCarCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbtnOK)
                    .addComponent(jbtnCancel))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        
        pack();
        
    }

    private void jbtnCancelActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "��û�г�ʼ�����޷�ִ��");
		System.exit(-1);
	}
	private void jbtnOKActionPerformed(ActionEvent evt) {
		this.setVisible(false);
		this.removeNotify();
		this.initParkingDb();
		WorkFrame frm = new WorkFrame(this);
		frm.setVisible(true);
	}

	
	private void formWindowClosing(WindowEvent evt) {
		JOptionPane.showMessageDialog(null, "��û�г�ʼ�����޷�ִ��");
		System.exit(-1);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		boolean b = true;
		int n = ((Integer) mdl.getValue()).intValue() - 1;
		this.m_Area[n] = Integer.parseInt(this.jtxtCarCount.getText());
		//ѭ���������ÿ��ͣ������ͣ���������������Ƿ��Ѿ���ʼ����
		for (int i = 0; i < m_Area.length; i++) {
			if (m_Area[i] <= 0) {
				b = false;
			}
		}
		try {
			mdl.setValue(mdl.getNextValue());
			this.jtxtCarCount.setText("");
			this.jtxtCarCount.setFocusable(true);
		} catch (Exception e) {
		}
		//���ÿ��ͣ��������ʼ���ˣ�����ʾȷ����ť��
		if (b)
			this.jbtnOK.setEnabled(true);
	}

    private void jbtnStopCountActionPerformed(ActionEvent evt) {
        String s = this.jtxtStopCount.getText();
		int i = Integer.parseInt(s);
		this.car_area = i;//����ͣ����������Ϣ
		m_Area = new int[i];
		for (i = 0; i < m_Area.length; i++) {
			this.m_Area[i] = -1;
		}
		this.jSpinnerStopArea.setEnabled(true);
		this.jtxtCarCount.setEnabled(true);//��ʾ
		//��ʼ��ѡ���
		mdl.setMinimum(new Integer(1));
		mdl.setMaximum(new Integer(m_Area.length));
		mdl.setValue(new Integer(1));
    }
    

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitFrame().setVisible(true);
            }
        });       
    }
    
    /**
     * ��ʼ�����ݿ�
     */
    public void initParkingDb(){
    	//��ʼ�����ݿ�֮ǰ,��ɾ��֮ǰ������
    	pmDao.delete();
    	pcbDao.delete();
    	pbDao.delete();
    	ParkingBank pb ;
    	ParkingCurrenBank pcb ;
    	for(int i=0; i<this.m_Area.length;i++){
    		pb = new ParkingBank();
    		pcb = new ParkingCurrenBank();
    		pb.setParking_area(i+1);
    		pcb.setParking_curren_area(i+1);
    		pb.setParking_num(this.m_Area[i]);
    		pcb.setParking_curren_num(this.m_Area[i]);
    		pbDao.insert(pb);
    		pcbDao.insert(pcb);
    	}
    }
    
    
}
