package com.xh.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.xh.bean.User;
import com.xh.tool.GetService;
import com.xh.tool.MyJButton;
import com.xh.tool.MyJPanel;
import com.xh.tool.MyLink;
/**
 * ϵͳ��¼�����ʵ��
 * @author XH
 *
 */
public class LoginFrame extends JFrame implements GetService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Box box = Box.createVerticalBox();			//��������������������
	private Box boxTitle = Box.createHorizontalBox();	//��ɽ���ı�����ʾ
	private Box boxTop = Box.createHorizontalBox();		//��ɽ��������ͼƬ��ʾ
	private Box boxCenter = Box.createHorizontalBox();	//�����Ҫ������ʾ
	private Box boxCenImg = Box.createVerticalBox();	//����û�ͷ����ʾ
	private Box boxCenInput = Box.createVerticalBox();	//����û�������Ϣ����ʾ
	private Box boxCenName = Box.createHorizontalBox();	//����û�����Ϣ����ʾ
	private Box boxCenPwd = Box.createHorizontalBox();	//����������Ϣ����ʾ
	private Box boxCh = Box.createHorizontalBox();		//��ɸ�ѡ�����ݵ���ʾ
	private Box boxBut = Box.createHorizontalBox();		//��ɰ�ť����ʾ

	private JLabel jlTitle;				//���ͼ��ͼ��
	private JLabel jlTop;				//�������ͼ��
	private JLabel jlImg;				//�������ͷ��
	private JLabel jlName;				//����û���
	private JLabel jlPwd;				//�������
	private MyLink mlRegist;			//ע���˺�
	private MyLink mlGet;				//��������
	
	private JTextField jtfName;			//�û����ı���
	private JPasswordField jpfPwd;	 	//�����ı���
	
	private MyJButton jbMin;			//��С����ť
	private MyJButton jbClose;			//�رհ�ť
	private Choice chMethod;			//��½��������̨����һ���û�
	private JCheckBox jcbMake;			//��ס����
	private JCheckBox jcbAuto;			//�Զ���½
	private JButton jbLogin;			//��½��ť
	private JButton jbCancel;			//ȡ����ť
	
	private MyJPanel mpBottom;			//�ײ㰴ť�������
	
	private Image image;				//ͼƬ����
	
	private User user = new User();		//�û�����
	public LoginFrame(String title)
	{
		super(title);
		initFrame();
		this.setVisible(true);
	}
	
	public void initFrame()
	{
		this.setUndecorated(true);		//���ô��岻������
		this.setSize(350, 266);			//���ô���Ĵ�С
		this.setLocation(200, 200);		//���ô������ʾλ��
		jlTitle = new JLabel(new ImageIcon("src/com/xh/res/icon_title.jpg"));
		jlTop = new JLabel(new ImageIcon("src/com/xh/res/title.jpg"));
		jbMin = new MyJButton(0);		
		jbClose = new MyJButton(1);		//������½�����ϵ���С���Լ��رղ�����ť
		
		jlImg = new JLabel(new ImageIcon("src/com/xh/img/res_img.png"));
		
		jlName = new JLabel("�û���");
		jlPwd = new JLabel("����");
		jtfName = new JTextField();
		jpfPwd = new JPasswordField();
		jpfPwd.setEchoChar('��');
		mlRegist = new MyLink("ע���˺�", LoginFrame.this);
		mlGet = new MyLink("��������", LoginFrame.this);
		mlRegist.setForeground(Color.gray);
		mlGet.setForeground(Color.gray);	//���ó�����Ĭ�ϵ���ɫΪ��ɫ
		chMethod = new Choice();
		chMethod.add("һ���û�");
		chMethod.add("����Ա");
		jcbMake = new JCheckBox("��ס����");
		jcbAuto = new JCheckBox("�Զ���¼");
		mpBottom = new MyJPanel();
		jbLogin = new JButton("��½");
		jbCancel = new JButton("ȡ��");
		
		boxTitle.add(jlTitle);
		boxTitle.add(jbMin);
		boxTitle.add(jbClose);
		boxTop.add(jlTop);
		
		boxCenImg.add(Box.createVerticalStrut(20));
		boxCenImg.add(jlImg);
		
		boxCenName.add(jlName);
		boxCenName.add(Box.createHorizontalStrut(6));
		boxCenName.add(jtfName);
		boxCenName.add(Box.createHorizontalStrut(6));
		boxCenName.add(mlRegist);
		boxCenName.add(Box.createHorizontalStrut(6));
		boxCenPwd.add(jlPwd);
		boxCenPwd.add(Box.createHorizontalStrut(18));
		boxCenPwd.add(jpfPwd);
		boxCenPwd.add(Box.createHorizontalStrut(6));
		boxCenPwd.add(mlGet);
		boxCenPwd.add(Box.createHorizontalStrut(6));
		
		boxCenInput.add(Box.createVerticalStrut(10));
		boxCenInput.add(boxCenName);
		boxCenInput.add(Box.createVerticalStrut(10));
		boxCenInput.add(boxCenPwd);
		boxCenInput.add(Box.createVerticalStrut(10));
		
		boxCenter.add(Box.createHorizontalStrut(40));
		boxCenter.add(boxCenImg);
		boxCenter.add(Box.createHorizontalStrut(20));
		boxCenter.add(boxCenInput);
		
		boxCh.add(Box.createHorizontalStrut(100));
		boxCh.add(chMethod);
		boxCh.add(Box.createHorizontalStrut(6));
		boxCh.add(jcbMake);
		boxCh.add(Box.createHorizontalStrut(6));
		boxCh.add(jcbAuto);
		boxCh.add(Box.createHorizontalStrut(6));
		
		mpBottom.add(jbCancel);
		mpBottom.add(Box.createHorizontalStrut(150));
		mpBottom.add(jbLogin);
		boxBut.add(mpBottom);
		
		box.add(boxTitle);
		box.add(boxTop);
		box.add(boxCenter);
		box.add(boxCh);
		box.add(Box.createVerticalStrut(2));
		box.add(boxBut);
		this.add(box);
		image = this.getToolkit().getImage(LoginFrame.class.getResource("/com/xh/res/icon.jpg"));
		this.setIconImage(image);
		addListener();			//����¼�������
	}
	
	/**
	 * ��ɶ����е��¼��ļ��������
	 */
	public void addListener()
	{
		FrameAction fa = new FrameAction();
		jbMin.addActionListener(fa);
		jbClose.addActionListener(fa);	//�Դ��ڰ�ť�����¼�������
		
		LoginAction la = new LoginAction();
		jbCancel.addActionListener(la);
		jbLogin.addActionListener(la);	//�û���½�����е��¼�����
		jpfPwd.addActionListener(la);	//�������ı�������ɶ��ڻس��ļ���
	}
	
	class FrameAction implements ActionListener
	{//��С���Լ��رհ�ť���¼�����
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if("0".equals(str))
				LoginFrame.this.setState(1);	//ʹ������С��
			else
				System.exit(0);					//�رյ�ǰ����
		}	
	}
	
	class LoginAction implements ActionListener
	{//ҳ���½ʱ���¼�����������
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if("ȡ��".equals(str))
			{//�����ȡ����ťʱ�����ı�����������
				jtfName.setText("");
				jpfPwd.setText("");
				jtfName.requestFocus(true);
				//�û����ı����ȡ�������ʾ
			}
			else
			{//�������½��ťʱ����֤�û���Ϣ,�����������������س�
				String username = jtfName.getText();
				String password = new String(jpfPwd.getPassword());
				int method = chMethod.getSelectedIndex();
				//String method = chMethod.getSelectedItem();
				boolean flag1 = jcbAuto.isSelected();
				boolean flag2 = jcbMake.isSelected();
				//��ȡ���������ǰѡ�е�״̬����ȡ��ֵ
				int loginState = 2;	//������¼�û���½��״̬
				boolean isAdmin = false;	//������¼��ǰ�û��Ƿ�Ϊ����Ա��½
				//1��ʾ��½�ɹ���2��ʾ�û������ڣ�1��ʾ�������
				user.setId(usi.getUser(username).getId());
				user.setUsername(username);
				user.setPassword(password);
				user.setRights(method);
				//��װ�û�����
				if(flag1)
					System.out.println("�Զ���½");
				if(flag2)
					System.out.println("��ס����");
				if(method == 1)//������Ա��½
				{
					loginState = asi.loginAdmin(user);
					isAdmin = true;
				}
				else//����û���½
					loginState = usi.loginUser(user);
				switch(loginState){
				case 0:
					JOptionPane.showMessageDialog(LoginFrame.this, "�������", "��½����", JOptionPane.ERROR_MESSAGE);
					jtfName.setText(username);
					jpfPwd.setText("");
					jpfPwd.requestFocus(true);
					break;
				case 1:
					LoginFrame.this.dispose();
					if(isAdmin)
						new ShowUserFrame("��ʾ�û���Ϣ", 1, 5);
					else 
						new MainFrame("�����������", user, Calendar.getInstance().get(Calendar.MONTH));
					break;
				case 2:
					JOptionPane.showMessageDialog(LoginFrame.this, "�û�������", "��½����", JOptionPane.ERROR_MESSAGE);
					jtfName.setText("");
					jpfPwd.setText("");
					jtfName.requestFocus(true);
					break;
				}
			}
		}	
	}
	
	public static void main(String[] args) {
		new LoginFrame("��¼����");
	}
}