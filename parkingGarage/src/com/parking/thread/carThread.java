package com.parking.thread;

import com.parking.Frame.WorkFrame;
import com.parking.Frame.carJFrame;

/**
 * 
* @author:chen.yi 
* @date�� ���ڣ�2015-12-15 ʱ�䣺����10:42:40
* @version 1.0
* @see ͣ���߳��࣬��һ����ͣ������ʱ�򣬾ͻ�����һ���߳�
 */
public class carThread extends Thread {
	
	private WorkFrame frm;
	
	public carThread(WorkFrame frm) {
		this.frm = frm;
	}
	
	
	public void run() {
		//�߳������½�һ��carFrame��Ȼ������Ϊ�ɼ���
		new carJFrame(frm).setVisible(true);
	}
	
}
