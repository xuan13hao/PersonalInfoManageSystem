package com.xh.db;

import java.sql.Connection;
import java.util.ResourceBundle;

/**
 * ���ø�����ɶ����ݿ�ķ���
 * �����ṩ���ַ������ݿ�ķ�ʽ��һ��JDBC�ķ�ʽ������C3P0�ķ�ʽ
 * ���ڲ���ʲô���ķ�ʽ����Ҫ����Ա�������ļ�����ɶ��壬
 * ��������Ϊ����ģ�Ŀ�������ṩһ�����󷽷���ʹ�ò�ͬ�������ݿⷽʽ�Ĳ�ͬʵ��
 * ��ͨ���̳и��࣬��������󷽷��Ĳ�ͬʵ�־�ע�����ò�ͬ�ķ�ʽ�������ݿ�
 * @author XH
 *
 */
public abstract class DbManager {
	
	private static String CONNECTIONMANAGER = "connectionManager";
	//ָ����ȡ�����ļ���Key
	private static ResourceBundle jdbc=ResourceBundle.getBundle("jdbc");
	//ָ����ǰ��ȡ�������ļ�
	public Connection getConnection()
	{
		return this.getRealConnection();
	}
	
	/**
	 * �ṩһ�����󷽷����÷�����������ɶ����������ӵķ���
	 * �ڸ÷����в�ͬ��ʵ�־Ͳ����˲�ͬ�����ӷ�ʽ
	 * @return �������ݿ�Ķ���Connection
	 */
	public abstract Connection getRealConnection();
	
	/**
     * �÷���ͨ����ȡ�����ļ���������������ʲô���ķ�ʽ���������ݿ�
     * Ҳ����˵���÷���������һ����������ɶԸ������д
     * @return ��ǰ��DbManager����
     */
    public static DbManager getInstance()
    {
    	DbManager db = null;
    	String connectionManager=jdbc.getString(CONNECTIONMANAGER);
    	if(null == connectionManager)
    	{
    		System.out.println("�Ҳ���connectionManager�����ã�����jdbc.properties��connectionManager");
    	}
    	else
    	{
    		try 
    		{
				db = (DbManager)Class.forName(connectionManager).newInstance();
			} catch (Exception e)
			{
				System.out.println("�Ҳ���connectionManager�����ã�����jdbc.properties��connectionManager");
				e.printStackTrace();
			}	
    	}
    	return db;
    }
}
