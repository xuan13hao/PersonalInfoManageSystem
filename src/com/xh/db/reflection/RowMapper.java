package com.xh.db.reflection;

import java.sql.ResultSet;
/**
 * �ṩһ����ڣ�����ʵ�ֽ������ת�������Ӧ������
 * ���ڲ�ͬ������󣬽������������ͬ�����Դ˽�ڱ��뱻ÿһ���������ʵ��
 * @author XH
 *
 * @param <T>
 */
public interface RowMapper<T>
{   
	public T parse(ResultSet rs);
}
