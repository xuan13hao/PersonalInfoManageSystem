package com.xh.tool;

import com.xh.service.AdminService;
import com.xh.service.UserService;
import com.xh.service.imp.ServiceFactory;

/**
 * �ýӿڵ�Ŀ�������ṩһ��ͳһ�Ľӿڣ�����ʼ�������Ķ���
 * �������еĲ���serviceDao�Ķ���
 * ͨ���ýӿڣ���ʵ���඼������ɶ�serviceDao�����в���
 * @author XH
 *
 */
public interface GetService {
	UserService usi = (UserService) ServiceFactory.getService("UserService");
	AdminService asi = (AdminService) ServiceFactory.getService("AdminService");
}
