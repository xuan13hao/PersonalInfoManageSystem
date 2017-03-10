package com.xh.tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * ��дJPanel������һ���߿��ʵ��
 * @author XH
 *
 */
public class BorderPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BorderPanel()
	{
		super();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		int width = this.getSize().width;
		int height = this.getSize().height;
		g.setFont(new Font("����", Font.BOLD, 30));
		g.drawString("���û���Ϣ", 100, 50);
		g.setColor(Color.GRAY);
		g.drawRect(10, 10, width - 20, height - 20);
		g.drawLine(10, 70, width - 10, 70);
	}
}
