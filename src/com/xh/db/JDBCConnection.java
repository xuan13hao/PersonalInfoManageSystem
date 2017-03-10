package com.xh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * ����JDBC�ķ�ʽ��ɶ����ݿ�����Ӳ���
 * @author XH
 *
 */
public class JDBCConnection extends DbManager {
	private ResourceBundle res = ResourceBundle.getBundle("jdbc");
	private Connection con = null;
	
	@Override
	public Connection getRealConnection() {
		String driverClass = res.getString("driverClass");
		String jdbcUrl = res.getString("jdbcUrl");
		String dbName = res.getString("dbName");
		String dbPwd = res.getString("dbPwd");
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(jdbcUrl, dbName, dbPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("JDBC�������ݿ�ʧ��");
			e.printStackTrace();
		}
		return con;
	}
}
