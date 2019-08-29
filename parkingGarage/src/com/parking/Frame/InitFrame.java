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
* @date： 日期：2015-12-15 时间：上午10:59:30
* @version 1.0
* @see 初始化停车场的信息，如初始化停车区域和停车位个数的信息
 */
public class InitFrame extends BaseClass {
	//变量声明 - 不进行修改
	private JButton jButton1;//输入停车车位按钮
    private JLabel jLabel1;//停车区个数
    private JLabel jLabel2;//
    private JLabel jLabel3;//
    private JSpinner jSpinnerStopArea;//
    private JButton jbtnCancel;//取消按钮
    private JButton jbtnOK;//确定按钮
    public JButton jbtnStopCount;//输入停车区个数按钮
    private JTextField jtxtCarCount;//停车场的数目
    private JTextField jtxtStopCount;//停车区域的个数
    public int m_Area[];
    public int car_area;//停车区个数
    SpinnerNumberModel mdl;
    // 变量声明结束
    
    
    public InitFrame() {
        initComponents();
        mdl = new SpinnerNumberModel();
        this.jSpinnerStopArea.setModel(mdl);
    }
      
    /**
     * 初始化停车场界面
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
        
        setTitle("停车初始化");
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("停车区域个数");

        jbtnStopCount.setText("输入停车区个数");
        /*
         * 监听输入停车区个数的动作
         */
        jbtnStopCount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnStopCountActionPerformed(evt);
            }
        });

        jLabel2.setText("停车区号");

        jSpinnerStopArea.setEnabled(false);

        jLabel3.setText("停车位个数");

        jtxtCarCount.setEnabled(false);

        jButton1.setText("输入停车车位个数");
        /*
         * 监听输入停车车位个数的信息
         */
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtnOK.setText("确定");
        
        jbtnOK.setEnabled(false);
        
        jbtnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jbtnOKActionPerformed(evt);
            }
        });

        jbtnCancel.setText("取消");
        
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
		JOptionPane.showMessageDialog(null, "您没有初始化，无法执行");
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
		JOptionPane.showMessageDialog(null, "您没有初始化，无法执行");
		System.exit(-1);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		boolean b = true;
		int n = ((Integer) mdl.getValue()).intValue() - 1;
		this.m_Area[n] = Integer.parseInt(this.jtxtCarCount.getText());
		//循环检查输入每个停车区的停车场个数，看看是否都已经初始化了
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
		//如果每个停车区都初始化了，则显示确定按钮。
		if (b)
			this.jbtnOK.setEnabled(true);
	}

    private void jbtnStopCountActionPerformed(ActionEvent evt) {
        String s = this.jtxtStopCount.getText();
		int i = Integer.parseInt(s);
		this.car_area = i;//保存停车区个数信息
		m_Area = new int[i];
		for (i = 0; i < m_Area.length; i++) {
			this.m_Area[i] = -1;
		}
		this.jSpinnerStopArea.setEnabled(true);
		this.jtxtCarCount.setEnabled(true);//显示
		//初始化选择框
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
     * 初始化数据库
     */
    public void initParkingDb(){
    	//初始化数据库之前,先删除之前的数据
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
