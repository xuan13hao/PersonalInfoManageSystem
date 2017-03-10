package com.xh.dao;

import java.sql.Date;
import java.util.List;

import com.xh.bean.Info;
import com.xh.page.PageDiv;

/**
 * �ó����ж��ڹ�����Ϣ���ܹ����еĲ���
 * @author XH
 *
 */
public interface InfoDao {
	/**
	 * ���ӹ�����Ϣ
	 * @param info Ҫ���ӵĹ�����Ϣ����
	 * @return	���ӳɹ�����true���򷵻�false
	 */
	public boolean addInfo(Info info);
	
	/**
	 * ͨ��id��ɾ��������Ϣ
	 * @param id	Ҫɾ���Ĺ�����Ϣid
	 * @return	ɾ���ɹ�����true���򷵻�false
	 */
	public boolean deleteInfo(int id);
	
	/**
	 * ͨ���û�id��ɾ��һ��������Ϣ
	 * @param userId	Ҫɾ��������Ϣ���û�id
	 * @return	ɾ���ɹ�����true���򷵻�false
	 */
	public boolean deleteInfoByUserId(int userId);
	
	/**
	 * �޸ĵ�ǰ�û�������Ϣ
	 * @param info	Ҫ�޸ĵ��û�������Ϣ
	 * @return	�޸ĳɹ�����true���򷵻�false
	 */
	public boolean updateInfo(Info info);
	
	/**
	 * ͨ��id����˵�ǰ����������Ϣ
	 * @param id Ҫ��˵���Ϣid
	 * @return	��˳ɹ�����true���򷵻�false
	 */
	public boolean checkInfo(int id);
	
	/**
	 * �жϵ����Ƿ��й���������Ϣ
	 * @param date		Ҫ�жϹ���������Ϣ��������
	 * @param userId 	Ҫ��õ�ǰ�û��Ĺ���������Ϣ
	 * @return	��������й������ŷ���true���򷵻�false
	 */
	public boolean hasInfo(Date date, int userId);
	
	/**
	 * ͨ��id��ȡ�û���Ϣ
	 * @param id	Ҫ��ȡ���û���Ϣ��id
	 * @return	�û���ϢInfo����
	 */
	public Info getInfo(int id);
	
	/**
	 * ͨ���û�id����ȡ�û���Ϣ
	 * @param userId	Ҫ��ȡ�û���Ϣ���û�id
	 * @return	�û���ϢInfo����
	 */
	public Info getInfoByUserId(int userId);
	
	/**
	 * ��ȡĳһ�û��Ĺ�����Ϣ������ɷ�ҳ
	 * @param userId	Ҫ��ȡ��Ϣ���û�id
	 * @param pageNo	��ǰ��ʾ���ݵ�ҳ��
	 * @param pageSize	ÿҳ��ʾ����������
	 * @return ��ҳ���϶���
	 */
	public PageDiv<Info> getInfoByPd(int userId, int pageNo, int pageSize);
	
	/**
	 * ��ȡĳһ�û���ĳһ��Ĺ�����Ϣ������ɷ�ҳ
	 * @param userId	Ҫ��ȡ��Ϣ���û�id
	 * @param pageNo	��ǰ��ʾ���ݵ�ҳ��
	 * @param pageSize	ÿҳ��ʾ��Ϣ������
	 * @param day		Ҫ��ȡ������Ϣ������
	 * @return	PageDiv<Info>���϶���
	 */
	public PageDiv<Info> getInfoByPdByDay(int userId, int pageNo, int pageSize, Date day);
	
	/**
	 * ��ȡ�����еĹ�����Ϣ
	 * @return	�û���Ϣ�ļ��϶���
	 */
	public List<Info> getAllInfo();
}
