package com.xh.dao;

import com.xh.bean.Register;
/**
 * �����û���ע���������еĲ���
 * @author XH
 *
 */
public interface RegisterDao {
	public boolean addRegister(Register register);
	
	public String getCoder(String username);
	
	public boolean changeStates(String username);
}
