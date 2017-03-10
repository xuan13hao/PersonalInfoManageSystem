package com.xh.ui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.xh.bean.Info;
import com.xh.bean.User;
import com.xh.tool.DesktopTool;
import com.xh.tool.GetService;
/**
 * ¼�빤��������Ϣ����
 * @author XH
 *
 */
public class EntryInfoFrame extends JFrame implements GetService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private User user;
	private int num;		//��¼ѡ���ʾ��ҳ��
	private TitledBorder tb1;					//���ñ߿�
	private TitledBorder tb2;					//���ñ߿�
	private TitledBorder tb3;					//���ñ߿�
	private Box box = Box.createVerticalBox();	//�����Ϣ��box
	private JPanel jp1 = new JPanel();			//��һ����
	private JPanel jp2 = new JPanel();			//�ڶ�����
	private JPanel jp3 = new JPanel();			//��������
	private JButton jb = new JButton("¼��");
	private JTextField jtf11 = new JTextField(2);
	private JTextField jtf12 = new JTextField(2);
	private JTextField jtf13 = new JTextField(45);
	private JTextField jtf21 = new JTextField(2);
	private JTextField jtf22 = new JTextField(2);
	private JTextField jtf23 = new JTextField(45);
	private JTextField jtf31 = new JTextField(2);
	private JTextField jtf32 = new JTextField(2);
	private JTextField jtf33 = new JTextField(45);
	private JLabel jl1 = new JLabel("~");
	private JLabel jl2 = new JLabel("~");
	private JLabel jl3 = new JLabel("~");
	
	private Image image;
	
	public EntryInfoFrame(String title, Date date, 
			User user, int num)
	{
		super(title);
		this.date = date;
		this.user = user;
		this.num = num;
		initFrame();
	}
	
	private void initFrame()
	{
		tb1 = new TitledBorder(new LineBorder(Color.CYAN), "��һ����");
		tb2 = new TitledBorder(new LineBorder(Color.CYAN), "�ڶ�����");
		tb3 = new TitledBorder(new LineBorder(Color.CYAN), "��������");
		jp1.setBorder(tb1);
		jp2.setBorder(tb2);
		jp3.setBorder(tb3);
		jtf11.setBorder(null);
		jtf12.setBorder(null);
		jtf13.setBorder(null);
		jtf21.setBorder(null);
		jtf22.setBorder(null);
		jtf23.setBorder(null);
		jtf31.setBorder(null);
		jtf32.setBorder(null);			
		jtf33.setBorder(null);			//���ñ߿�Ϊnull
		jp1.add(jtf11);
		jp1.add(jl1);
		jp1.add(jtf12);
		jp1.add(jtf13);
		jp2.add(jtf21);
		jp2.add(jl2);
		jp2.add(jtf22);
		jp2.add(jtf23);
		jp3.add(jtf31);
		jp3.add(jl3);
		jp3.add(jtf32);
		jp3.add(jtf33);
		box.add(Box.createVerticalStrut(20));
		box.add(jp1);
		box.add(Box.createVerticalStrut(10));
		box.add(jp2);
		box.add(Box.createVerticalStrut(10));
		box.add(jp3);
		box.add(Box.createVerticalStrut(10));
		box.add(jb);
		box.add(Box.createVerticalStrut(20));
		this.add(box);
		this.setSize(600, 300);
		this.setLocation(200, 100);
		image = this.getToolkit().getImage("src/com/xh/res/icon.jpg");
		this.setIconImage(image);
		this.setVisible(true);
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EntryInfoFrame.this.dispose();
				DesktopTool.closeDesktop();
				new MainFrame("�����������", user, num);
				String st1 = jtf11.getText();
				String et1 = jtf12.getText();
				String ct1 = jtf13.getText();
				String st2 = jtf21.getText();
				String et2 = jtf22.getText();
				String ct2 = jtf23.getText();
				String st3 = jtf31.getText();
				String et3 = jtf32.getText();
				String ct3 = jtf33.getText();
				if(!st1.equals("")&&!et1.equals("")&&!ct1.equals(""))
				{
					Info info = new Info();
					info.setUserId(user.getId());
					info.setStartTime(st1);
					info.setEndTime(et1);
					info.setDayTime(date);
					info.setIsChecked(0);
					info.setContent(ct1);
					usi.addInfo(info);
				}
				if(!st2.equals("")&&!et2.equals("")&&!ct2.equals(""))
				{
					Info info = new Info();
					info.setUserId(user.getId());
					info.setStartTime(st2);
					info.setEndTime(et2);
					info.setDayTime(date);
					info.setIsChecked(0);
					info.setContent(ct2);
					usi.addInfo(info);
				}
				if(!st3.equals("")&&!et3.equals("")&&!ct3.equals(""))
				{
					Info info = new Info();
					info.setUserId(user.getId());
					info.setStartTime(st2);
					info.setEndTime(et2);
					info.setDayTime(date);
					info.setIsChecked(0);
					info.setContent(ct2);
					usi.addInfo(info);
				}
			}
		});
	}
}
