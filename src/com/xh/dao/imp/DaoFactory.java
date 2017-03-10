package com.xh.dao.imp;

import java.util.ResourceBundle;

/**
 * ����DAO��һ��������
 * @author XH
 * @version 1.3
 */
public class DaoFactory 
{
   private static ResourceBundle rs = ResourceBundle.getBundle("dao");
  /**
   * ͨ��DAO������������DAO��ʵ�������
   * @param daoName	DAO����
   * @return	DAOʵ�����һ������
   */
   public static Object getDao(String daoName)
   {
	   Object obj = null;
	   String impclass = rs.getString(daoName);
	   if(null != impclass)
	   {
		   try {
			obj = (Object)Class.forName(impclass).newInstance();
		  } catch (Exception e) {
			System.out.println("��ȡdao�����쳣");
			e.printStackTrace();
		 } 
	   }
	   return obj;
   }
}
