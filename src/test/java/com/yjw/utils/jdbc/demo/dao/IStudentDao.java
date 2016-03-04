package com.yjw.utils.jdbc.demo.dao;

import java.sql.SQLException;

import com.yjw.utils.jdbc.demo.model.Student;

/**
 * 
 *@author Orange
 *@date 上午11:58:12,2016年3月4日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public interface IStudentDao {
	
	/**
	 * 添加学生
	 * @param stu
	 * @throws SQLException 
	 */
	public void addStudent(Student stu) throws SQLException;
	
	/**
	 * 删除学生
	 * @param id
	 * @throws SQLException 
	 */
	public void delStudent(int id) throws SQLException;
	
	/**
	 * 获取一个学生对象
	 * @param id
	 * @return 一个学生对象
	 * @throws SQLException 
	 */
	public Student getStudent(int id) throws SQLException;
	
	/**
	 * 更新学生对象
	 * @param stu
	 * @throws SQLException 
	 */
	public void updateStudent(Student stu) throws SQLException;
}
