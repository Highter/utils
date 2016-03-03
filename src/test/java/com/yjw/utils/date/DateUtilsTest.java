package com.yjw.utils.date;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *0001:时间工具类DateUtils的测试类
 *@author Orange
 *@date 下午7:42:57,2016年3月3日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public class DateUtilsTest {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass:DateUtils");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass:DateUtils");
	}
	
	@Before
	public void before(){
		System.out.println("@Before");
	}
	
	@After
	public void after(){
		System.out.println("@After");
	}
	
	/**
	 * 测试00010001:Date类型转换成String类型
	 */
	@Test
	public void testGetStringByFormat(){
		Date date0001 = new Date();
		String dateString0001 = DateUtils.getStringByFormat(date0001, DateUtils.dateFormatYMDHMS);
		System.out.println("00010001:"+dateString0001);
	}
	
	/**
	 * 测试00010002:String类型转换成Date类型
	 */
	@Test
	public void testGetDateByFormat(){
		String dateString0002 = "2016-03-02 14:12:12";
		Date date0002 = DateUtils.getDateByFormat(dateString0002, DateUtils.dateFormatYMDHMS);
		System.out.println("00010002:"+date0002);
//		System.out.println( getStringByFormat(date0002, dateFormatYMD));
	}
	
}
