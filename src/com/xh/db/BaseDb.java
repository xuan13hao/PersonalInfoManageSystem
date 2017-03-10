package com.xh.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * �ýӿ����ϳ��������ܹ��õ��Ķ������ݿ�ĸ��ֲ���
 * �����������ݿ⡢��ѯ�ȵ�
 * @author XH
 *
 */
public interface BaseDb<T extends Serializable>{
	
	/**
	 * ����������ݿ�Ķ���
	 * @return �������ݿ�Ķ���Connection
	 */
	public Connection getConnection();
	
	/**
     * ��ɶ����ݵĸ��²���������insert��delete��update
     * @param sql Ҫִ�е�sql���
     * @return  ����Ӱ�����ݱ������
     */
    public int executeUpdate(String sql) throws SQLException;
	
    /**
     * ͨ���ɱ��βθ������ݱ�inser update delete
     * ����:insert t_name(aa,aa,ss) values(?,?,?) 
     * @param sql Ҫִ�е�sql���
     * @param params  ����Ĳ����б�
     * @return ����Ӱ�����ݱ������
     */
    public int executeUpdate(String sql,Object...params)throws SQLException;
	
    /**
	 * ���ָ��sql�����ҵļ�¼����  sql����һ��Ҫ��selec count(*)��ʼ
	 * @param sql  sql���select count(id) from user;
	 * @return   ���ؼ�¼������
	 */
    public Integer executeQueryForCount(String sql)throws SQLException;
   
    /**
     * ��ѯһ����¼��������ض�����¼���򷵻ص�һ��
     * @param sql  sql���select * from user where id=12
     * @return  ����һ����¼�Ķ����װ
     */
    public T executeQueryForBean(String sql, Class<T> clazz)throws SQLException;
    
    /**
     * ��ѯһ����¼��������ض�����¼���򷵻ص�һ��
     * @param sql  sql���select * from user where id=?
     * @param params  �������?�Ĳ���
     * @return  ����һ����¼�Ķ����װ
     */
    public T executeQueryForBean(String sql, Class<T> clazz,Object...params)throws SQLException;

    /**
     * ��ѯ���ݱ������תΪһ��List
     * String sql=select * from user;
     * List<User> list=executeQuery(sql,User.class);
     * @param sql   Ҫִ�е�sql�ﹻ��
     * @param clazz  ����list��Ԫ�ص�����
     * @return   �������ݱ�����list��װ
     */
    public List<T> executeQuery(String sql,Class<T> clazz)throws SQLException; 
    
    /**
     * ��ѯ���ݱ������תΪһ��List
     * String sql=select * from user where id=?;
     * List<User> list=executeQuery(sql,User.class);
     * @param sql   Ҫִ�е�sql�ﹻ��
     * @param clazz  ����list��Ԫ�ص�����
     * @param param  Ϊ����Ĳ������������?
     * @return   �������ݱ�����list��װ
     */
    public List<T> executeQuery(String sql,Class<T> clazz,Object...params)throws SQLException;
}
