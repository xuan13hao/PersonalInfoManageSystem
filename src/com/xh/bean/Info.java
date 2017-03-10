package com.xh.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * �û�����Ӧ�Ĺ������Ż���
 * @author XH
 *
 */
public class Info implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;				//Ψһ��ʾid
	
	private int userId;			//����Ӧ���û�
	
	private String startTime;	//���ſ�ʼʱ��
	
	private String endTime;		//���Ž���ʱ��
	
	private String content;		//���ž�������
	
	private Date dayTime;		//���Ź�������
	
	private int isChecked;		//�Ƿ������ˣ����ֶε��������ڶ������ŵĹ�����һ��ȷ��
								//�����ǰ��������������¼Ϊ1�������¼Ϊ0

	public Info()
	{
		
	}
	
	
	public Info(int userId, String startTime,
			String endTime, String content,
			Date dayTime, int isChecked) {
		super();
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
		this.dayTime = dayTime;
		this.isChecked = isChecked;
	}
	
	public Info(int id, int userId, String startTime, String endTime,
			String content, Date dayTime, int isChecked) {
		super();
		this.id = id;
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.content = content;
		this.dayTime = dayTime;
		this.isChecked = isChecked;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDayTime() {
		return dayTime;
	}

	public void setDayTime(Date dayTime) {
		this.dayTime = dayTime;
	}

	public int getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}
}
