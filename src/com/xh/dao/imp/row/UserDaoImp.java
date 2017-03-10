package com.xh.dao.imp.row;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.User;
import com.xh.dao.UserDao;
import com.xh.dao.imp.BaseDao;
import com.xh.page.PageDiv;
/**
 * ͨ���򵥷�װ��ʵ�ֵ�UserDao
 * @author XH
 *
 */
public class UserDaoImp extends BaseDao implements UserDao {

	JDBCTemplate jt = new JDBCTemplate();
	@Override
	public boolean addUser(User user) {
		sql = "insert into user(username, password, rights) " +
				"values('"+user.getUsername()+"','"+user.getPassword()+"',"+user.getRights()+")";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean deleteUser(int id) {
		sql = "delete from user where id = " + id;
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean deleteUser(String username) {
		sql = "delete from user where username = '" + username + "'";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean updateUser(User user) {
		sql = "update user set password = '" + user.getPassword() + "', rights = " + user.getRights() +
				" where username = '" + user.getUsername() + "'";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("ͨ��һ���װ�޸��û���Ϣ�����쳣");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public User getUser(int id) {
		User user = null;
		sql = "select * from user where id = " + id;
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRights(rs.getInt(4));
			}
		} catch (SQLException e) 
		{
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUser(String username) {
		User user = null;//����Ϊnull���ں����ų�ʼ��
		//�����޷��жϸö���Ϊnullֵ����ͨ��new User����ʵ����֮��user�Ͳ�����Ϊnull��
		//�������޷��жϵ�ǰ�����Ƿ�����ݿ��л�ȡ����Ӧ��ֵ��
		sql = "select * from user where username = '" + username + "'";
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRights(rs.getInt(4));
			}
		} catch (SQLException e) 
		{
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public PageDiv<User> getUserByPd(int pageNo, int pageSize)
	{
		List<User> list = new ArrayList<User>();
		sql = "select * from user limit "+(pageNo-1)*pageSize+","+pageSize;
		sqlCount = "select count(id) from user";
		count = jt.getCount(sqlCount);
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRights(rs.getInt("rights"));
				list.add(user);
			}
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
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRights(rs.getInt(4));
				list.add(user);
			}
		} catch (SQLException e) 
		{
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return list;
	}
}
