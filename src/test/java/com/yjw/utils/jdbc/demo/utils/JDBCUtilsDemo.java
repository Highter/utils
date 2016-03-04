package com.yjw.utils.jdbc.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JDBCUtilsDemo类
 * @author Orange
 * @date 下午1:19:53,2016年3月4日
 * @vesion V1.0
 * @see yjwsmileatlife@126.com
 */
public class JDBCUtilsDemo {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/interview";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static Connection conn;
	
	static{
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的连接
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

}
