package com.xh.service;

import java.sql.Date;
import java.util.List;

import com.xh.bean.Info;
import com.xh.bean.User;
import com.xh.page.PageDiv;

/**
 * �ýӿ����ṩ��һЩ�û�������ɵĻ�������
 * �������е��û���˵����������ɵĲ�������
 * @author XH
 *
 */
public interface UserService {
	/**
	 * ע���û�
	 * @param user Ҫע����û�����
	 * @return	ע��ɹ�����true���򷵻�false
	 */
	public boolean registerUser(User user);
	
	/**
	 * �û���¼
	 * @param user 	Ҫ��¼���û�����
	 * @return	��¼�ɹ�����1,�û��������ڷ���2���û������ڵ�������󷵻�0
	 */
	public int loginUser(User user);
	
	/**
	 * �޸��û��ĸ��˻�����Ϣ
	 * @param user	Ҫ�޸���Ϣ���û�����
	 * @return	�޸ĳɹ�����true���򷵻�false
	 */
	public boolean updateUser(User user);
	
	/**
	 * ͨ���û�������ȡUser����
	 * @param username	Ҫ��ȡ�û�������û���
	 * @return ��ȡ�ɹ�����User������򷵻�null
	 */
	public User getUser(String username);
	/* �û�����User����ɵĲ������� */
	
	/**
	 * ���ӹ�����Ϣ
	 * @param info Ҫ���ӵĹ������Ŷ���
	 * @return	��ӳɹ�����true���򷵻�false
	 */
	public boolean addInfo(Info info);
	
	/**
	 * ���ĳ���Ƿ��й�������
	 * @param date	Ҫ��⹤�����ŵ�����
	 * @param user	Ҫ��ȡ��Ϣ���û�
	 * @return	�й������ŷ���true���򷵻�false
	 */
	public boolean hasInfo(Date date, User user);
	
	/**
	 * ͨ��id����˵�ǰ����������Ϣ
	 * @param id Ҫ��˵���Ϣid
	 * @return	��˳ɹ�����true���򷵻�false
	 */
	public boolean checkInfo(int id);
	
	/**
	 * ��ȡ�������еĹ�������
	 * @return List<Info>����
	 */
	public List<Info> getAllInfo();
	
	/**
	 * ͨ����ҳ��ʽ����ʾ�û��Ĺ����������
	 * û��ָ�����ھͱ����ǵ�ǰ�Ĺ�������
	 * @param username	Ҫ��ʾ��Ϣ���û���
	 * @param pageNo	Ҫ��ʾ��Ϣ��ҳ��
	 * @param pageSize	ÿҳ��ʾ��Ϣ������
	 * @return	PageDiv<Info>���϶���
	 */
	public PageDiv<Info> getInfoByPd(String usrename, int pageNo, int pageSize);
	
	/**
	 * ��ȡĳһ��Ĺ���������Ϣ
	 * @param username 	Ҫ��ʾ��Ϣ���û���
	 * @param pageNo	Ҫ��ʾ��Ϣ��ҳ��
	 * @param pageSize	ÿҳ��ʾ��Ϣ������
	 * @param day		Ҫ��ȡ����Ϣ����
	 * @return PageDiv<Info>���϶���
	 */
	public PageDiv<Info> getInfoByPdByDay(String usrename, int pageNo, int pageSize, Date day);
	/* �û�����Info����ɵĲ�������*/
	
	/**
	 * ��ȡע����
	 * @param username Ҫ��ȡ��֤����û���
	 * @return	��ȡ�ɹ�����һ����֤���ַ������з��򷵻�null
	 */
	public String getCoder(String username);
	
	/**
	 * ĳ�û��Ѿ����ע�ᣬ�޸�ע��״̬
	 * @param username	Ҫ�޸�״̬���û���
	 * @return	�޸ĳɹ�����true���򷵻�false
	 */
	public boolean hasRegisted(String username);
	/* �û�����ע����Ϣ�Ĳ�������*/
}
