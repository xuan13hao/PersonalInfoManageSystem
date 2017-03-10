package com.xh.service.imp;

import com.xh.dao.InfoDao;
import com.xh.dao.RegisterDao;
import com.xh.dao.UserDao;
import com.xh.dao.imp.DaoFactory;

/**
 * �����ṩ���в����ײ��ʵ�������
 * ������SERVICEʵ�����е�ʹ��
 * @author XH
 *
 */
public class BaseService {
	public UserDao udi = (UserDao)DaoFactory.getDao("UserDao");
	public InfoDao idi = (InfoDao)DaoFactory.getDao("InfoDao");
	public RegisterDao rdi = (RegisterDao)DaoFactory.getDao("RegisterDao");
}
