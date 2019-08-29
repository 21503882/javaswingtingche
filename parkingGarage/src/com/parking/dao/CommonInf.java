package com.parking.dao;

import com.parking.bean.BaseClass;

/**
 * dao的公共接口,所有的dao类都会继承该接口
 * @author chen.yi
 *
 */
public interface CommonInf {
	/*
	 * 插入
	 */
	public boolean insert(BaseClass bc);
	/*
	 * 查询
	 */
	public Object query(BaseClass bc);
	/*
	 * 更新
	 */
	public boolean update(BaseClass bc);
	
	
	public void delete();
	
}
