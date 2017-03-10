package com.xh.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.xh.bean.User;
import com.xh.tool.GetService;

/**
 * ��ʾ���е��û���Ϣ����
 * @author XH
 *
 */
public class ShowUserFrame extends JFrame implements GetService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane jsp;
	private Box box = Box.createVerticalBox();
	private Box boxTop = Box.createHorizontalBox();
	private Box boxCenter = Box.createHorizontalBox();
	private Box boxBottom = Box.createHorizontalBox();
	private JTable jt;			//����������ݵ�Table
	private JButton jbPre = new JButton("<��һҳ");
	private JButton jbNext = new JButton("��һҳ>");
	private JButton jbAdd = new JButton("����");
	private JButton jbDel = new JButton("ɾ��");
	private JButton jbUpd = new JButton("�޸�");
	private JButton jbCan = new JButton("����");
	private JButton jbExit = new JButton("�˳�");
	private JButton jbLog = new JButton("ע��");
	
	private Vector<String> title = new Vector<String>();
	private Vector<Vector<String>> data = new Vector<Vector<String>>();
	private List<User> list = new ArrayList<User>();//�����洢����
	private int count = 1;		//����
	
	private int pageNo;
	private int pageSize;
	
	public ShowUserFrame(String title, int pageNo, int pageSize)
	{
		super(title);
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		initFrame();
		this.setVisible(true);
	}
	
	public void initFrame()
	{
		this.setSize(600, 300);
		this.setLocation(200, 200);
		this.setResizable(false);
		initData();
		jt = new JTable(data, title);
		jsp = new JScrollPane(jt);
		boxTop.add(jsp);
		
		boxCenter.add(jbPre);
		boxCenter.add(Box.createHorizontalStrut(300));
		boxCenter.add(jbNext);
		
		boxBottom.add(jbAdd);
		boxBottom.add(Box.createHorizontalStrut(20));
		boxBottom.add(jbDel);
		boxBottom.add(Box.createHorizontalStrut(20));
		boxBottom.add(jbUpd);
		boxBottom.add(Box.createHorizontalStrut(20));
		boxBottom.add(jbCan);
		boxBottom.add(Box.createHorizontalStrut(20));
		boxBottom.add(jbExit);
		boxBottom.add(Box.createHorizontalStrut(20));
		boxBottom.add(jbLog);
		
		box.add(boxTop);
		box.add(Box.createVerticalStrut(20));
		box.add(boxCenter);
		box.add(Box.createVerticalStrut(20));
		box.add(boxBottom);
		box.add(Box.createVerticalStrut(20));
		this.add(box);
		addAction();
	}
	
	public void initData()
	{
		title.add("���");
		title.add("�û���");
		title.add("����");
		title.add("Ȩ��");
		list = asi.showUser(1, 5).getList();
		for(User tem:list)
		{
			Vector<String> value = new Vector<String>();
			value.add(String.valueOf(count++));
			value.add(tem.getUsername());
			value.add(tem.getPassword());
			if(tem.getRights()==1)
				value.add("����Ա");
			else
				value.add("һ���û�");
			data.add(value);
		}
	}
	
	public void addAction()
	{
		jbAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowUserFrame.this.dispose();
				new AddUserFrame("����û���Ϣ����");
			}
		});
		
		jbDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				asi.deleteUser((String)jt.getValueAt(jt.getSelectedRow(), 1));
				ShowUserFrame.this.dispose();
				new ShowUserFrame("��ʾ�û���Ϣ����", pageNo, pageSize);
			}
		});
		
		jbUpd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowUserFrame.this.dispose();
				String username = (String)jt.getValueAt(jt.getSelectedRow(), 1);
				new UpdateUserFrame("�޸��û���Ϣ����", username);
			}
		});
		
		jbPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pageNo++;
				ShowUserFrame.this.dispose();
				new ShowUserFrame("��ʾ�û���Ϣ����", pageNo, pageSize);
			}
		});
		
		jbNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pageNo--;
				ShowUserFrame.this.dispose();
				new ShowUserFrame("��ʾ�û���Ϣ����", pageNo, pageSize);
			}
		});
	}
	
	public static void main(String[] args) {
		new ShowUserFrame("��ʾ�û���Ϣ����", 1, 5);
	}
}
