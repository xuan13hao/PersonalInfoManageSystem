package com.xh.dao.imp.row;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xh.bean.Info;
import com.xh.dao.InfoDao;
import com.xh.dao.imp.BaseDao;
import com.xh.page.PageDiv;

/**
 * ͨ�����ݿ������з�װʵ�ֵ�InfoDao
 * @author XH
 *
 */
public class InfoDaoImp extends BaseDao implements InfoDao {

	JDBCTemplate jt = new JDBCTemplate();
	@Override
	public boolean addInfo(Info info) {
		sql = "insert into info(userId, startTime, endTime, content, dayTime, isChecked)" +
				" values('" + info.getUserId() + "','" + info.getStartTime() + "','" +
				info.getEndTime() + "','" + info.getContent() + "','" + info.getDayTime() + "','" + 
				info.getIsChecked() + "')";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Info�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean deleteInfo(int id) {
		sql = "delete from info where id = " + id;
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Info�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean deleteInfoByUserId(int userId) {
		sql = "delete from info where userId = " + userId;
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Info�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}

	@Override
	public boolean checkInfo(int id) {
		sql = "update info set isChecked = 1 where id = " + id;
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Info�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}
	

	@Override
	public boolean updateInfo(Info info) {
		sql = "update info set userId = " +info.getUserId() + ", startTime = '" + info.getStartTime() + "', " +
				"endTime = '" + info.getEndTime() + "', content = '" + info.getContent() + "', " +
				"dayTime = '" +info.getDayTime() + "', isChecked = '" + info.getIsChecked() + "'";
		try {
			stat = con.createStatement();
			i = stat.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Info�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return BaseDao.isTrue(i);
	}
	
	@Override
	public boolean hasInfo(Date date, int userId)
	{
		sql = "select * from info where dayTime = '" + date + "' and userId = " + userId;
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			System.out.println("һ���װ����Ƿ���Info���ų����쳣");
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public Info getInfo(int id) {
		Info info = new Info();
		sql = "select * from info where id =" + id;
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				info.setId(rs.getInt("id"));
				info.setUserId(rs.getInt("userId"));
				info.setStartTime(rs.getString("startTime"));
				info.setEndTime(rs.getString("endTime"));
				info.setContent(rs.getString("content"));
				info.setDayTime(rs.getDate("dayTime"));
				info.setIsChecked(rs.getInt("isChecked"));
			}
		} catch (SQLException e) 
		{
			System.out.println("Info��ȡʧ��");
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public Info getInfoByUserId(int userId) {
		Info info = new Info();
		sql = "select * from info where userId =" + userId;
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				info.setId(rs.getInt("id"));
				info.setUserId(rs.getInt("userId"));
				info.setStartTime(rs.getString("startTime"));
				info.setEndTime(rs.getString("endTime"));
				info.setContent(rs.getString("content"));
				info.setDayTime(rs.getDate("dayTime"));
				info.setIsChecked(rs.getInt("isChecked"));
			}
		} catch (SQLException e) 
		{
			System.out.println("Info��ȡʧ��");
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public PageDiv<Info> getInfoByPd(int userId, int pageNo, int pageSize) {
		List<Info> list = new ArrayList<Info>();
		sql = "select * from info limit "+(pageNo-1)*pageSize+","+pageSize;
		sqlCount = "select count(id) from info";
		count = jt.getCount(sqlCount);
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				Info info = new Info();
				info.setId(rs.getInt("id"));
				info.setUserId(rs.getInt("userId"));
				info.setStartTime(rs.getString("startTime"));
				info.setEndTime(rs.getString("endTime"));
				info.setDayTime(rs.getDate("dayTime"));
				info.setContent(rs.getString("content"));
				info.setIsChecked(rs.getInt("isChecked"));
				list.add(info);
			}
		} catch (SQLException e) {
			System.out.println("ͨ��DbUtil��ȡUser��ҳ�����쳣");
			e.printStackTrace();
		}
		return new PageDiv<Info>(pageNo, pageSize, count, list);
	}
	
	@Override
	public PageDiv<Info> getInfoByPdByDay(int userId, int pageNo, int pageSize, Date day) {
		List<Info> list = new ArrayList<Info>();
		sql = "select * from info where userId = " + userId + " and dayTime = '" + day + "'" +
				"limit "+(pageNo-1)*pageSize+","+pageSize;
		sqlCount = "select count(id) from info";
		count = jt.getCount(sqlCount);
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				Info info = new Info();
				info.setId(rs.getInt("id"));
				info.setUserId(rs.getInt("userId"));
				info.setStartTime(rs.getString("startTime"));
				info.setEndTime(rs.getString("endTime"));
				info.setDayTime(rs.getDate("dayTime"));
				info.setContent(rs.getString("content"));
				info.setIsChecked(rs.getInt("isChecked"));
				list.add(info);
			}
		} catch (SQLException e) {
			System.out.println("ͨ��DbUtil��ȡUser��ҳ�����쳣");
			e.printStackTrace();
		}
		return new PageDiv<Info>(pageNo, pageSize, count, list);
	}
	
	@Override
	public List<Info> getAllInfo() {
		List<Info> list = new ArrayList<Info>();
		sql = "select * from info";
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next())
			{
				Info info = new Info();
				info.setId(rs.getInt("id"));
				info.setUserId(rs.getInt("userId"));
				info.setStartTime(rs.getString("startTime"));
				info.setEndTime(rs.getString("endTime"));
				info.setContent(rs.getString("content"));
				info.setDayTime(rs.getDate("dayTime"));
				info.setIsChecked(rs.getInt("isChecked"));
				list.add(info);
			}
		} catch (SQLException e) 
		{
			System.out.println("Info��ȡʧ��");
			e.printStackTrace();
		}
		return list;
	}
}
