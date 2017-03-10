package com.xh.dao.imp.reflection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.User;
import com.xh.dao.UserDao;
import com.xh.dao.imp.BaseDao;
import com.xh.db.reflection.BaseDbReflectionImp;
import com.xh.page.PageDiv;
/**
 * ͨ�����������ʵ��UserDao
 * @author XH
 *
 */
public class UserDaoRefImp extends BaseDao implements UserDao {
	BaseDbReflectionImp<User> brei = new BaseDbReflectionImp<User>();
	@Override
	public boolean addUser(User user) {
		sql = "insert into user(username, password, rights) values(?,?,?)";
		params = new Object[]{user.getUsername(), user.getPassword(), user.getRights()};
		try {
			i = brei.executeUpdate(sql, params);
		} catch (SQLException e) {
			System.out.println("���÷���������Userʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean deleteUser(int id) {
		sql = "delete from user where id = ?";
		try {
			i = brei.executeUpdate(sql, id);
		} catch (SQLException e) {
			System.out.println("ͨ������ɾ��User�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean deleteUser(String username) {
		sql = "delete from user where username = ?";
		try {
			i = brei.executeUpdate(sql, username);
		} catch (SQLException e) {
			System.out.println("ͨ������ɾ��User�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean updateUser(User user) {
		sql = "update user set password = ?, rights = ? where username = ?";
		params = new Object[]{user.getPassword(), user.getRights(), user.getUsername()};
		try {
			i = brei.executeUpdate(sql, params);
		} catch (SQLException e) {
			System.out.println("ͨ�������޸�User�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public User getUser(int id) {
		User user = new User();
		sql = "select * from user where id = ?";
		try {
			user = brei.executeQueryForBean(sql, User.class, id);
		} catch (SQLException e) {
			System.out.println("ͨ�������ȡUser�����쳣");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUser(String username) {
		User user = new User();
		sql = "select * from user where username = ?";
		try {
			user = brei.executeQueryForBean(sql, User.class, username);
		} catch (SQLException e) {
			System.out.println("ͨ�������ȡUser�����쳣");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public PageDiv<User> getUserByPd(int pageNo, int pageSize)
	{
		List<User> list = new ArrayList<User>();
		sql = "select * from user limit ?,?";
		sqlCount = "select count(id) from user";
		params = new Object[]{(pageNo-1)*pageSize, pageSize};
		try {
			list = brei.executeQuery(sql, User.class, params);
			count = brei.executeQueryForCount(sqlCount);
		} catch (SQLException e) {
			System.out.println("ͨ��DbUtil��ȡUser��ҳ�����쳣");
			e.printStackTrace();
		}
		return new PageDiv<User>(pageNo, pageSize, count, list);
	}
	
	@Override
	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		sql = "select * from user";
		try {
			list = brei.executeQuery(sql, User.class);
		} catch (SQLException e) {
			System.out.println("ͨ�������ȡ���е�User�����쳣");
			e.printStackTrace();
		}
		return list;
	}
}
