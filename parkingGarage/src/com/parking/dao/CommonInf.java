package com.parking.dao;

import com.parking.bean.BaseClass;

/**
 * dao�Ĺ����ӿ�,���е�dao�඼��̳иýӿ�
 * @author chen.yi
 *
 */
public interface CommonInf {
	/*
	 * ����
	 */
	public boolean insert(BaseClass bc);
	/*
	 * ��ѯ
	 */
	public Object query(BaseClass bc);
	/*
	 * ����
	 */
	public boolean update(BaseClass bc);
	
	
	public void delete();
	
}
