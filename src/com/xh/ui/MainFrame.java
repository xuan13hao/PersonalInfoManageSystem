package com.xh.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import com.xh.bean.Info;
import com.xh.bean.User;
import com.xh.tool.DayJButton;
import com.xh.tool.DesktopTool;
import com.xh.tool.GetService;
/**
 * �������ʵ��
 * @author XH
 *
 */
public class MainFrame extends JFrame implements GetService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*����MenuBar Menu MenuItem��JMenuBar JMenu JMenuItem֮�������*/
	private MenuBar mb = new MenuBar();			//�˵���
	private Menu m1 = new Menu("ϵͳ");			//ϵͳ�˵�
	private Menu m2 = new Menu("�༭");			//�༭�˵�
	private Menu m3 = new Menu("�鿴");			//�鿴�˵�
	private Menu m4 = new Menu("����");			//���߲˵�
	private Menu m5 = new Menu("����");			//�����˵�
	private MenuItem mi11 = new MenuItem("�½�");//ϵͳ�˵��½��˵���
	private MenuItem mi12 = new MenuItem("ɾ��");//ϵͳ�˵�ɾ���˵���
	private MenuItem mi13 = new MenuItem("�޸�");//ϵͳ�˵��޸Ĳ˵���
	private MenuItem mi14 = new MenuItem("����");//ϵͳ�˵�����˵���
	private MenuItem mi15 = new MenuItem("�˳�");//ϵͳ�˵��˳��˵���
	private MenuItem mi21 = new MenuItem("����");//�༭�˵������˵���
	private MenuItem mi22 = new MenuItem("����");//�༭�˵����в˵���
	private MenuItem mi23 = new MenuItem("����");//�༭�˵����Ʋ˵���
	private MenuItem mi24 = new MenuItem("ճ��");//�༭�˵�ճ���˵���
	private MenuItem mi25 = new MenuItem("ȫѡ");//�༭�˵�ȫѡ�˵���
	private MenuItem mi26 = new MenuItem("��ѡ");//�༭�˵���ѡ�˵���
	
	private JToolBar jtb = new JToolBar();		//������
	private Action atShow;						//�鿴����
	private Action atEntry;						//¼�빤��
	private Action atUpd;						//�޸Ĺ���
	private Action atCheck;						//��˹���
	
	private Box boxLeft = Box.createVerticalBox();
	private JLabel jlPlan = new JLabel("���չ�������");
												//���������ʾ����
	
	private JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);
	 											//�������ģ��
	private JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP);
												//�ö�ѡ�		
	private ResourceBundle res = ResourceBundle.getBundle("days");
												//��ȡ�����ļ�
	
	private Toolkit tk;							//��ȡ���߰�
	private Dimension screenSize;	 			//��Ļ��С
	private Image image;						//ͼƬ����
	
	private User user;
	private int num;
	public MainFrame(String title, User user, int num)
	{
		super(title);
		this.user = user;			//��¼��ǰ��¼���û�
		this.num = num;				//���õ�ǰѡ�ѡ�е�ģ��
		initMenu();					//��ʼ���˵�
		initTool();					//��ʼ��������
		initMain();					//��ʼ��������
		initFrame();				//��ʼ������
		DesktopTool.setUser(user);
		DesktopTool.setDesktop();	//����������ʾ
	}
	
	/**
	 * ��ʼ���˵��������Ӹ��˵�����¼�����
	 */
	private void initMenu()
	{
		m1.add(mi11);
		m1.add(mi12);
		m1.add(mi13);
		m1.addSeparator();		//�ָ���
		m1.add(mi14);
		m1.addSeparator();
		m1.add(mi15);	
		m2.add(mi21);
		m2.addSeparator();
		m2.add(mi22);
		m2.add(mi23);
		m2.add(mi24);
		m2.add(m1);
		m2.addSeparator();
		m2.add(mi25);
		m2.add(mi26);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		this.setMenuBar(mb);
		mi21.setShortcut(new MenuShortcut(KeyEvent.VK_Z));
		mi22.setShortcut(new MenuShortcut(KeyEvent.VK_X));
		mi23.setShortcut(new MenuShortcut(KeyEvent.VK_C));
		mi24.setShortcut(new MenuShortcut(KeyEvent.VK_V));
		mi25.setShortcut(new MenuShortcut(KeyEvent.VK_A));
		//���ÿ�ݼ�
		mi11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�½�");
			}
		});
		mi15.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
			}
		});
		mi21.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
			}
		});
		mi22.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("����");
			}
		});
	}
	
	/**
	 * ��ʼ��������
	 */
	@SuppressWarnings("serial")
	public void initTool()
	{
		atShow = new AbstractAction("�鿴", new ImageIcon("src/com/xh/res/tool_show.png")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				new CheckInfoFrame("��˹�������", new Date(Calendar.getInstance().getTimeInMillis()), user, jtp.getSelectedIndex());
			}
		};
		atEntry = new AbstractAction("¼��", new ImageIcon("src/com/xh/res/tool_entry.png")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				new EntryInfoFrame("¼�빤������", new Date(Calendar.getInstance().getTimeInMillis()), user, jtp.getSelectedIndex());
			}
		};
		atUpd = new AbstractAction("�޸�", new ImageIcon("src/com/xh/res/tool_upd.png")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�޸�");
			}
		};
		atCheck = new AbstractAction("���", new ImageIcon("src/com/xh/res/tool_check.png")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.dispose();
				new CheckInfoFrame("��˹�������", new Date(Calendar.getInstance().getTimeInMillis()), user, jtp.getSelectedIndex());
			}
		};
		jtb.setFloatable(false);	//���ù��������ɸ���
		jtb.add(atShow);
		jtb.addSeparator();
		jtb.add(atEntry);
		jtb.addSeparator();
		jtb.add(atUpd);
		jtb.addSeparator();
		jtb.add(atCheck);
		this.add(jtb, "North");
	}
	
	/**
	 * ��ʼ�������ڣ�
	 * ���а�������ģ�壬ͨ��ѡ��ķ�ʽ����ʾ��������
	 */
	public void initMain()
	{
		jlPlan.setForeground(Color.GREEN);
		jlPlan.setFont(new Font("����", Font.BOLD, 20));
		boxLeft.add(Box.createVerticalStrut(10));
		boxLeft.add(jlPlan);
		boxLeft.add(Box.createVerticalStrut(10));
		List<Info> list = new ArrayList<Info>();
		list = usi.getInfoByPdByDay(user.getUsername(), 1, 10, new Date(new java.util.Date().getTime())).getList();
		for(Info info:list)
		{
			String showInfo = 
					"  ��  " + info.getStartTime() +
					"  ~  " + info.getEndTime() + 
					"    " + info.getContent() + "    ";
			//����Ҫ��ʾ�Ĺ��������ַ�����ʽ
			JLabel jlInfo = new JLabel(showInfo);
			jlInfo.setForeground(Color.RED);
			jlInfo.setFont(new Font("����", Font.ITALIC, 15));
			boxLeft.add(jlInfo);
			boxLeft.add(Box.createVerticalStrut(5));
		}
		for(int i=1; i<=12; i++)
		{							
			JPanel jp = new JPanel();
			jp.setLayout(null);
			int days = Integer.valueOf(res.getString("month" + i));
											//ͨ�������ļ�����ȡ��ǰ�·ݵ�����
			for(int j=0; j<days; j++)
			{
				Date date = Date.valueOf("2012-"+i+"-"+(j+1));//���쵱ǰ����
				JButton jb = new DayJButton(usi.hasInfo(date, user), j+1);
				jb.setBounds(80*(j%7)+100, 80*(j/7)+100, 80, 80);
				//���ð�ť��ʾ��λ��
				jp.add(jb);
				jb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int months = jtp.getSelectedIndex()+1;
						DayJButton mb = (DayJButton)e.getSource();
						Date curDate = Date.valueOf("2012-"+months+"-"+mb.getDays());
						if(mb.isFlag())
							new CheckInfoFrame("��˹�������", curDate, user, jtp.getSelectedIndex());
						else
							new EntryInfoFrame("¼�빤������", curDate, user, jtp.getSelectedIndex());
						MainFrame.this.dispose();
					}
				});
			}											//��̬����JPanel
			JScrollPane jslp = new JScrollPane(jp);		//����JPanel������JSCrollPane
			jtp.add(getMonth(i), jslp);					//������JScrollPane��ӵ�ѡ���
		}		
		jtp.setSelectedIndex(num);			//����ѡ���ʾ��ҳ��
		jsp.setLeftComponent(boxLeft);		//�����ʾ���칤�����ž�����Ϣ
		jsp.setRightComponent(jtp);
		jsp.setOneTouchExpandable(true);
	}
	
	/**
	 * ͨ�����������ض�Ӧ�·ݵ��ַ�����ʾ
	 * @param i	Ҫ��ʾ���·�
	 * @return	String����
	 */
	public String getMonth(int i)
	{
		String re = null;
		switch(i)
		{
		case 1: re = "Ҽ��"; break;
		case 2: re = "����"; break;
		case 3: re = "����"; break;
		case 4: re = "����"; break;
		case 5: re = "����"; break;
		case 6: re = "½��"; break;
		case 7: re = "����"; break;
		case 8: re = "����"; break;
		case 9: re = "����"; break;
		case 10: re = "ʰ��"; break;
		case 11: re = "ʰҼ��"; break;
		case 12: re = "ʰ����"; break;
		}
		return re;
	}
	
	/**
	 * ��ʼ������
	 */
	private void initFrame()
	{
		tk = Toolkit.getDefaultToolkit();
		screenSize = tk.getScreenSize();
		this.setSize(screenSize);
		image = tk.getImage(RegisterFrame.class.getResource("/com/xh/res/icon.jpg"));
		this.setIconImage(image);
		this.add(jsp, "Center");
		this.setVisible(true);
		this.setDefaultCloseOperation(MainFrame.DISPOSE_ON_CLOSE);
	}
}
