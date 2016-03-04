package com.yjw.utils.jdbc.demo.model;

import java.util.Date;

/**
 *student表的实体类
 *@author Orange
 *@date 下午1:07:22,2016年3月4日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public class Student {
	
	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 学号
	 */
	private String number;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private int age;
	
	/**
	 * 性别:0表示男，1表示女，默认为0
	 */
	private int sex;
	
	/**
	 * 联系电话
	 */
	private String mobile;
	
	/**
	 * 学历
	 */
	private String education;
	
	/**
	 * 添加时间
	 */
	private Date createTime;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String number, String name, int age, int sex, String mobile, String education,
			Date createTime) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.mobile = mobile;
		this.education = education;
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", mobile=" + mobile + ", education=" + education + ", createTime=" + createTime + "]";
	}
	
}
