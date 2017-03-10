package com.xh.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xh.bean.User;
import com.xh.tool.GetService;
import com.xh.tool.MyLink;

/**
 * ע��ҳ���ʵ��
 * @author XH
 *
 */
public class RegisterFrame extends JFrame implements GetService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Box box = Box.createHorizontalBox();		//����boxʵ��
	private Box boxImg = Box.createHorizontalBox();		//���ͼƬ��ʾ
	private Box boxRight = Box.createVerticalBox();		//�Ҳ�������ʾ
	private Box boxName = Box.createHorizontalBox();	//�û���
	private Box boxCoder = Box.createHorizontalBox();	//��֤��
	private Box boxPwd = Box.createHorizontalBox();		//����
	private Box boxRePwd = Box.createHorizontalBox();	//�ظ�����
	private Box boxBut = Box.createHorizontalBox();		//�ύ��ť
	
	private JLabel jlImg;								//���ͼƬ����
	private JLabel jlName = new JLabel("�û���");			//�û�����ǩ
	private JLabel jlCoder = new JLabel("��֤��");		//��֤���ǩ
	private JLabel jlPwd = new JLabel("����");			//�����ǩ
	private JLabel jlRePwd = new JLabel("�ظ�����");		//�ظ������ǩ
	private JTextField jtfName = new JTextField();		//�û����ı���
	private JTextField jtfCoder = new JTextField();		//��֤���ı���
	private JPasswordField jpfPwd = new JPasswordField();//�����ı���
	private JPasswordField jpfRePwd = new JPasswordField();//�ظ������ı���
	private MyLink mlCoder;								//��ȡ��֤��
	private JButton jbSubmit = new JButton("ע��");		//ע�ᰴť
	private JButton jbBack = new JButton("����");		//���ذ�ť
	
	private Image image;								//ͼƬ����
	private Dimension screenSize = tk.getScreenSize();  //��Ļ��С
	private int width = 400;						    //���ڿ��
	private int height = 300;						    //���ڸ߶�
	private int x = 0;
	private int y = 0;
	
	public RegisterFrame(String title)
	{
		super(title);
		initFrame();
		this.setVisible(true);
	}
	
	public void initFrame()
	{
		this.setSize(width, height);
		x = (int)(screenSize.getWidth()-width)/2;
		y = (int)(screenSize.getHeight()-height)/2;
		this.setLocation(x, y);
		jlImg = new JLabel(new ImageIcon("src/com/xh/res/register.png"));
		mlCoder = new MyLink("��ȡ��֤��");
		mlCoder.setForeground(Color.GRAY);
		jpfPwd.setEchoChar('��');
		jpfRePwd.setEchoChar('��');
		boxImg.add(jlImg);
		boxName.add(Box.createHorizontalStrut(20));
		boxName.add(jlName);
		boxName.add(Box.createHorizontalStrut(20));
		boxName.add(jtfName);
		boxName.add(Box.createHorizontalStrut(10));
		
		boxCoder.add(Box.createHorizontalStrut(20));
		boxCoder.add(jlCoder);
		boxCoder.add(Box.createHorizontalStrut(20));
		boxCoder.add(jtfCoder);
		boxCoder.add(Box.createHorizontalStrut(10));
		boxCoder.add(mlCoder);
		boxCoder.add(Box.createHorizontalStrut(10));
		
		boxPwd.add(Box.createHorizontalStrut(23));
		boxPwd.add(jlPwd);
		boxPwd.add(Box.createHorizontalStrut(30));
		boxPwd.add(jpfPwd);
		boxPwd.add(Box.createHorizontalStrut(10));
		
		boxRePwd.add(Box.createHorizontalStrut(10));
		boxRePwd.add(jlRePwd);
		boxRePwd.add(Box.createHorizontalStrut(18));
		boxRePwd.add(jpfRePwd);
		boxRePwd.add(Box.createHorizontalStrut(10));
		
		boxBut.add(jbSubmit);
		boxBut.add(Box.createHorizontalStrut(20));
		boxBut.add(jbBack);
		
		boxRight.add(Box.createVerticalStrut(40));
		boxRight.add(boxName);
		boxRight.add(Box.createVerticalStrut(20));
		boxRight.add(boxCoder);
		boxRight.add(Box.createVerticalStrut(20));
		boxRight.add(boxPwd);
		boxRight.add(Box.createVerticalStrut(20));
		boxRight.add(boxRePwd);
		boxRight.add(Box.createVerticalStrut(20));
		boxRight.add(boxBut);
		boxRight.add(Box.createVerticalStrut(40));
		
		box.add(boxImg);
		box.add(boxRight);
		this.add(box);
		this.getContentPane().setBackground(new Color(0X4781D5));
		this.setResizable(false);//���ô�С���ɱ�
		image = tk.getImage(RegisterFrame.class.getResource("/com/xh/res/icon.jpg"));
		this.setIconImage(image);
		addActionListener();
	}
	
	public void addActionListener()
	{
		RegisterAction rs = new RegisterAction();
		jbBack.addActionListener(rs);
		jbSubmit.addActionListener(rs);
		mlCoder.addMouseListener(new CoderAction());
		jpfRePwd.addActionListener(rs);
	}
	
	class RegisterAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(jbBack.equals(obj))
			{//���ص���½����
				RegisterFrame.this.dispose();
				new LoginFrame("��½����");
			}
			else if(jbSubmit.equals(obj)||jpfRePwd.equals(obj))
			{//����ύ
				String username = jtfName.getText();
				String pwd = new String(jpfPwd.getPassword());
				String repwd = new String(jpfRePwd.getPassword());
				String coder = jtfCoder.getText();
				if(pwd.equals(repwd)&&coder.equals(usi.getCoder(username)))
				{
					User user = new User(username, pwd, 0);
					boolean flag = usi.registerUser(user);
					if(flag)
					{//��ӵ����ݿ�ɹ�
						if(usi.hasRegisted(username))
						{//�����û�ע��״̬�ɹ�
							JOptionPane.showMessageDialog(RegisterFrame.this, "��ϲ����ע��ɹ�������", "ע��ɹ�", JOptionPane.INFORMATION_MESSAGE);
							RegisterFrame.this.dispose();
							new LoginFrame("��½����");
						}
					}
				}
			}	
		}	
	}
	
	class CoderAction extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) {
		//��ȡ��֤��
			String username = jtfName.getText();
			String coder = usi.getCoder(username);
			if(coder==null)
				JOptionPane.showMessageDialog(RegisterFrame.this, "�Բ�����û��Ȩ��ע��", "��֤��", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(RegisterFrame.this, "���˴�ע�����֤���ǣ�\t" + coder, "��֤��", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new RegisterFrame("ע��");
	}
}
