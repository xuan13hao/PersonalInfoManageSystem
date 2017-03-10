package com.xh.service;

import com.xh.bean.User;
import com.xh.page.PageDiv;

/**
 * ���ڹ���Ա��˵���ܹ����еĲ�������
 * @author XH
 *
 */
public interface AdminService {
	/**
	 * ����Ա��½
	 * @param user Ҫ��½���û�����
	 * @return ��½�ɹ�����1���û��������ڷ���2���û������ڵ�������󷵻�0
	 */
	public int loginAdmin(User user);
	
	/**
	 * ���һ���û�
	 * @param user Ҫ��ӵ��û�����
	 * @return	��ӳɹ�����true���򷵻�false
	 */
	public boolean addUser(User user);
	
	/**
	 * ͨ���û���ɾ��һ���û�
	 * @param username Ҫɾ���û���Ϣ���û���
	 * @return	Ҫɾ���ɹ�����true���򷵻�false
	 */
	public boolean deleteUser(String username);
	
	/**
	 * �����û���Ϣ
	 * @param user	Ҫ���µ��û�����
	 * @return	���³ɹ�����true���򷵻�false
	 */
	public boolean updateUser(User user);
	
	/**
	 * ͨ���û�������ȡ��ǰ�û�����
	 * @param username	Ҫ��ȡ�û�������û���
	 * @return	��ȡ�ɹ�����User������򷵻�null
	 */
	public User getUser(String username);
	
	/**
	 * ��ʾ���е��û���Ϣ
	 * @param pageNo	��ʾ�û���Ϣ��ҳ��
	 * @param pageSize	ÿҳ��ʾ��Ϣ������
	 * @return PageDiv<User>���϶���
	 */
	public PageDiv<User> showUser(int pageNo, int pageSize);
}
