package com.xh.tool;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
/**
 * �ػ�JButton
 */
public class MyJButton extends JButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int states;			//ͨ��������������ť
	private String path;		//ͨ��ͼƬ·����������ť

	
	public MyJButton(int states)
	{
		super(String.valueOf(states));
		this.states = states;
	}
	
	public MyJButton(String path)
	{
		this.path = path;
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		BufferedImage bi = null;
		try {
			if(states == 0)
				bi = ImageIO.read(MyJButton.class.getResource("/com/xh/res/title_min.png"));
			else if(states == 1)
				bi = ImageIO.read(MyJButton.class.getResource("/com/xh/res/title_close.png"));
			else if(states == 2)
				bi = ImageIO.read(MyJButton.class.getResource("/com/xh/res/title_max.png"));
			else
				bi = ImageIO.read(MyJButton.class.getResource("/com/xh/res/" + path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(bi, 0, 0, null);
	}
}
