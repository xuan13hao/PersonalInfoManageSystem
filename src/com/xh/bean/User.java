package com.xh.bean;

import java.io.Serializable;

/**
 * �û���Ϣ����Ӧ�Ļ���
 * @author XH
 *
 */
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;				//Ψһ��ʾid
	
	private String username;	//�û���
	
	private String password;	//����
	
	private int rights;			//�û���Ȩ�ޣ�1��ʾ����Ա��0��ʾһ���û�
	
	public User()
	{
		
	}

	public User(String username, String password, int rights) {
		super();
		this.username = username;
		this.password = password;
		this.rights = rights;
	}

	public User(int id, String username, String password, int rights) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rights = rights;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRights() {
		return rights;
	}

	public void setRights(int rights) {
		this.rights = rights;
	}
}
