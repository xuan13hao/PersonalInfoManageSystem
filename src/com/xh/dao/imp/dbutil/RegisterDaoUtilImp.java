package com.xh.dao.imp.dbutil;

import java.sql.SQLException;

import com.xh.bean.Register;
import com.xh.dao.RegisterDao;
import com.xh.dao.imp.BaseDao;
import com.xh.db.dbutil.BaseDbUtilImp;
/**
 * ͨ��dbUtil��ʵ��RegisterDao
 * @author XH
 *
 */
public class RegisterDaoUtilImp extends BaseDao implements RegisterDao {

	BaseDbUtilImp<Register> bdui = new BaseDbUtilImp<Register>();
	@Override
	public boolean addRegister(Register register) {
		sql = "insert into register(username, coder, isRegister) values(?,?,?)";
		params = new Object[]{register.getUsername(), register.getCoder(), register.getIsRegister()};
		try {
			i = bdui.executeUpdate(sql, params);
		} catch (SQLException e) {
			System.out.println("ͨ��DbUtil���Register�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public String getCoder(String username) {
		String coder = null;
		sql = "select * from register where username = ? and isRegister = 0";
		try {
			coder = bdui.executeQueryForBean(coder, Register.class, username).getCoder();
		} catch (SQLException e) {
			System.out.println("ͨ��DbUtil��ȡ��֤������쳣");
			e.printStackTrace();
		}
		return coder;
	}
	
	@Override
	public boolean changeStates(String username)
	{
		sql = "update register set isRegister = 1 where username = '" +username + "'";
		try {
			i = bdui.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("ͨ��DbUtil�޸�ע��״̬�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}
}
