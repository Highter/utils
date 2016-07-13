package com.yjw.utils.jdbc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 0003:jdbc工具类的测试类
 * @author Orange
 * @date 下午8:35:29,2016年3月3日
 * @vesion V1.0
 * @see yjwsmileatlife@126.com
 */
public class TestJDBCUtils {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass:JDBCUtils");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass:JDBCUtils");
	}
	
	@Before
	public void before(){
		System.out.println("@Before");
	}
	
	@After
	public void after(){
		System.out.println("@After");
	}
	
	
}
