package com.yjw.utils.jdbc.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yjw.utils.jdbc.demo.dao.IStudentDao;
import com.yjw.utils.jdbc.demo.model.Student;
import com.yjw.utils.jdbc.demo.utils.JDBCUtilsDemo;

/**
 * 
 *@author Orange
 *@date 下午1:18:20,2016年3月4日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public class StudentDao implements IStudentDao{

	public void addStudent(Student stu) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtilsDemo.getConnection();
		String sql = "INSERT INTO student"
				+ "(number,name,age,sex,mobile,education,createTime) "
				+ "VALUES (?, ?, ?, ?, ?, ?,NOW())";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getNumber());
		ps.setString(2, stu.getName());
		ps.setInt(3, stu.getAge());
		ps.setInt(4,stu.getSex());
		ps.setString(5, stu.getMobile());
		ps.setString(6, stu.getEducation());
		ps.execute();
	}

	public void delStudent(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtilsDemo.getConnection();
		String sql = "DELETE FROM student WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}

	public Student getStudent(int id) throws SQLException {
		// TODO Auto-generated method stub
		Student stu = null;
		Connection conn = JDBCUtilsDemo.getConnection();
		String sql = "SELECT id,"
				+ "number,"
				+ "name,"
				+ "age,"
				+ "sex,"
				+ "mobile,"
				+ "education,"
				+ "createTime "
				+ "FROM student "
				+ "WHERE id = ? ";
		PreparedStatement ps  = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			stu = new Student();
			stu.setId(rs.getInt("id"));
			stu.setNumber(rs.getString("number"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			stu.setSex(rs.getInt("sex"));
			stu.setMobile(rs.getString("mobile"));
			stu.setEducation(rs.getString("education"));
			stu.setCreateTime(rs.getDate("createTime"));
		}
		
		return stu;
	}

	public void updateStudent(Student stu) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtilsDemo.getConnection();
		String sql = "UPDATE student SET "
				+ "number=?,"
				+ "name=?,"
				+ "age=?,"
				+ "sex=?,"
				+ "mobile=?,"
				+ "education=?,"
				+ "createTime = NOW() WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getNumber());
		ps.setString(2, stu.getName());
		ps.setInt(3, stu.getAge());
		ps.setInt(4, stu.getSex());
		ps.setString(5, stu.getMobile());
		ps.setString(6, stu.getEducation());
		ps.setInt(7, stu.getId());
		
		ps.execute();
	}
	
	public static void main(String[] args) {
		IStudentDao dao = new StudentDao();
		try {
			//添加一个学生对象
			/*Student stuAdd = new Student();
			stuAdd.setName("yjw");
			stuAdd.setAge(25);
			dao.addStudent(stuAdd);
			
			//删除一个学生对象
			dao.delStudent(7);
			
			//获取一个学生对象
			Student stuGet = dao.getStudent(2);
			System.out.println(stuGet);*/
			
			//更新一个学生对象
			Student stuUpdate = new Student();
			stuUpdate = dao.getStudent(8);
			stuUpdate.setName("Hello");
			dao.updateStudent(stuUpdate);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
