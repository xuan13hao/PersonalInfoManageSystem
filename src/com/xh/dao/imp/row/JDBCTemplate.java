package com.xh.dao.imp.row;

import java.sql.SQLException;

import com.xh.dao.imp.BaseDao;

/**
 * ���������������ɶ������ݿ�Ĳ��������а�����ȡ���������ķ���
 * @author XH
 *
 */
public class JDBCTemplate extends BaseDao{
	
	/**
	 * ��ȡ����¼����
	 * @param sql	��ȡ��¼��SQL���
	 * @return	���ؼ�¼����
	 */
	public int getCount(String sql)
	{
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				i = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("��JDBCTemplate�л�ȡStatement�����쳣");
			e.printStackTrace();
		}
		return i;
	}
}
