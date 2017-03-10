package com.xh.tool;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class DayJButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean flag;		//������ʾ��ǰ����ʱ���а�����Ϣ
	private int days;			//Ҫ��ʾ��������
	/**
	 * �ù��췽������������ڵĻ��ƣ���ÿһ����һ����ť����ʾ
	 * @param flag �жϵ�ǰ�������Ƿ��а�����Ϣ
	 * @param i	   Ҫ��ʾ��������
	 */
	public DayJButton(boolean flag, int days)
	{
		this.flag = flag;	
		this.days = days;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage bi = null;
		try {
			if(flag)
				bi = ImageIO.read(MyJButton.class.getResource("/com/xh/res/bt_show.png"));
			else
				bi = ImageIO.read(MyJButton.class.getResource("/com/xh/res/bt_entry.png"));
			} catch (IOException e) {
				System.out.println("DayJButton��ȡͼƬ�����쳣");
				e.printStackTrace();
			}
		g.drawImage(bi, 0, 0, null);
		g.drawString(String.valueOf(days), 40, 40);
	}
}
