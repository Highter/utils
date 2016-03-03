package com.yjw.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *0003:jdbc工具类
 *@author Orange
 *@date 下午7:03:14,2016年3月3日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public class JDBCUtils {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/interview";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		//1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获得数据库连接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		//3.通过数据库的连接操作数据库，实现增删查改
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT name,age FROM student");
		
		while(rs.next()){
			System.out.println(rs.getString("name")+":"+rs.getString("age"));
		}
	}
}
