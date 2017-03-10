package com.xh.tool;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import com.xh.bean.User;
import com.xh.ui.MainFrame;

/**
 * ���������õ��������У����в���flag����ǰ��¼�ĳ̶�
 * ��flag=0��ʾ���ڵ�¼��flag=1��ʾ�ѵ�¼�ɹ���flag=-1��ʾ����
 * User��ʾ��ǰ��¼�û�����Ϣ������flag=1ʱ�����û�����
 * @author XH
 *
 */
public class DesktopTool
{
	static SystemTray st = SystemTray.getSystemTray();		//��ȡ�����ϵͳ������
	static TrayIcon ti;
	
	private static User user;
	public static void setUser(User user)
	{
		DesktopTool.user = user;
	}
	
	public static void setDesktop()
	{
		Image image = null;
		PopupMenu pm = new PopupMenu();					//������̬�����˵�
		String str = new String();						//������ʾ��Ϣ
		image = Toolkit.getDefaultToolkit().getImage(DesktopTool.class.getResource("/com./xh/res/icon.jpg"));
		MenuItem miOpen = new MenuItem("��������");
		MenuItem miClose = new MenuItem("�˳�");
	
		pm.add(miOpen);
		pm.addSeparator();		//����
		pm.add(miClose);
		if(SystemTray.isSupported())
		{//�жϵ�ǰ��֧��ϵͳ���̲���
			ti = new TrayIcon(image, str, pm);		//����ϵͳ���̵�����ͼ��
			try
			{
				st.add(ti);
			} catch (AWTException e)
			{
				e.printStackTrace();
			}
		}

		miClose.addActionListener(new ActionListener()
		{//�رյ�ǰ����
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		miOpen.addActionListener(new ActionListener()
		{//��������
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new MainFrame("�����������", user, Calendar.getInstance().get(Calendar.MONTH));
			}
		});
	}
	
	public static void closeDesktop()
	{
		st.remove(ti);
	}
}