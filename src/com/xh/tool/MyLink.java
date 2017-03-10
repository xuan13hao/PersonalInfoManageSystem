package com.xh.tool;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.xh.ui.GetPwdFrame;
import com.xh.ui.RegisterFrame;

/**
 * �ػ�JLabel����ɳ����ӵ�ʵ��
 * @author XH
 *
 */
public class MyLink extends JLabel implements MouseListener, GetService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isEntered = false; 
	private String title;
	private JFrame jf;

	 public MyLink(String title)   
    { 
    	super(title); 
    	this.title = title;
        this.addMouseListener(this); 
    } 

    public MyLink(String title, JFrame jf)   
    { 
    	super(title); 
    	this.title = title;
    	this.jf = jf;
        this.addMouseListener(this); 
    } 

    protected void paintBorder(Graphics g)   
    {
    	int w = this.getSize().width; 
        int h = this.getSize().height; 
        if(isEntered) 
        	g.drawLine(0, h - 1, w - 1, h - 1); 
        //������ƶ���ʱ����ʾ�»���
    } 

    public void mouseClicked(MouseEvent mouseEvent){ 
    	//���������ʱ����ɵ�Ч��
    	if("ע���˺�".equals(title))
    	{
    		new RegisterFrame(title);	//����ע��ҳ��
    		jf.dispose();				//�رյ�½ҳ��
    	}
    	else if("��������".equals(title))
    	{
    		new GetPwdFrame(title);		//�����ȡ����ҳ��
    		jf.dispose();
    	}
    } 

    public void mousePressed(MouseEvent mouseEvent) { 
    } 

    public void mouseReleased(MouseEvent mouseEvent) { 
    } 

    public void mouseEntered(MouseEvent mouseEvent) { 
    	//����������ʱ����ɵ�Ч��
            isEntered = true; 
            this.repaint(); 
            MyLink.this.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //���õ�����ƶ�����ǰ�����ʱ��ʾ����
            MyLink.this.setForeground(Color.cyan);
            //����������ʱ��ʾ����ɫ
    } 

    public void mouseExited(MouseEvent mouseEvent) { 
    	//��������Ƴ�ʱ��������Ч��
            isEntered = false; 
            MyLink.this.setForeground(Color.gray);
            //��������뿪ʱ��ʾ����ɫ
            this.repaint(); 
    } 
}
