package com.xh.dao.imp.row;

import java.sql.SQLException;

import com.xh.bean.Register;
import com.xh.dao.RegisterDao;
import com.xh.dao.imp.BaseDao;

public class RegisterDaoImp extends BaseDao implements RegisterDao {

	@Override
	public boolean addRegister(Register register) {
		sql = "insert into register(username, coder, isRegister) " +
				"values('" + register.getUsername() + "', '" + register.getCoder() + "', " + 
				register.getIsRegister() + ")";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Register���ʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public String getCoder(String username) {
		String coder = null;
		sql = "select * from register where username = '" +username +  "' and isRegister = 0";
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
				coder = rs.getString("coder");
		} catch (SQLException e) {
			System.out.println("Register��ȡ��Ϣʧ��");
			e.printStackTrace();
		}
		return coder;
	}
	
	@Override
	public boolean changeStates(String username)
	{
		sql = "update register set isRegister = 1 where username = '" + username + "'";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("һ���װ�޸��û�ע��״̬�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}
}
