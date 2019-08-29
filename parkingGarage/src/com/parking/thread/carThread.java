package com.parking.thread;

import com.parking.Frame.WorkFrame;
import com.parking.Frame.carJFrame;

/**
 * 
* @author:chen.yi 
* @date： 日期：2015-12-15 时间：上午10:42:40
* @version 1.0
* @see 停车线程类，当一辆车停进来的时候，就会启动一个线程
 */
public class carThread extends Thread {
	
	private WorkFrame frm;
	
	public carThread(WorkFrame frm) {
		this.frm = frm;
	}
	
	
	public void run() {
		//线程任务，新建一个carFrame，然后设置为可见。
		new carJFrame(frm).setVisible(true);
	}
	
}
