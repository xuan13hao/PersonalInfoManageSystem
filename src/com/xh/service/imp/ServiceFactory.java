package com.xh.service.imp;

import java.util.ResourceBundle;

/**
 * ����SERVICE��һ��������
 * @author XH
 * @version 1.3
 */
public class ServiceFactory 
{
   private static ResourceBundle rs = ResourceBundle.getBundle("service");
  /**
   * ͨ��SERVICE������������SERVICE��ʵ�������
   * @param serviceName	SERVICE������
   * @return	SERVICEʵ�����һ������
   */
   public static Object getService(String serviceName)
   {
	   Object obj = null;
	   String impclass = rs.getString(serviceName);
	   if(null != impclass)
	   {
		   try {
			obj = (Object)Class.forName(impclass).newInstance();
		  } catch (Exception e) {
			System.out.println("��ȡservice�����쳣");
			e.printStackTrace();
		 } 
	   }
	   return obj;
   }
}
