package com.xh.dao;

import java.util.List;

import com.xh.bean.User;
import com.xh.page.PageDiv;

/**
 * �ó����ж����û����ܹ����еĲ���
 * @author XH
 *
 */
public interface UserDao {
	public boolean addUser(User user);
	
	public boolean deleteUser(int id);
	
	public boolean deleteUser(String username);
	
	/**
	 * ͨ���û������޸��û���Ϣ
	 * @param user	Ҫ�޸ĵ��û���Ϣ
	 * @return	�޸ĳɹ�����true���򷵻�false
	 */
	public boolean updateUser(User user);
	
	public User getUser(int id);
	
	public User getUser(String username);
	
	public PageDiv<User> getUserByPd(int pageNo, int pageSize);
	
	public List<User> getAllUser();
}
