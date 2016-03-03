package com.yjw.utils.string;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *0002:字符串工具类StringUtils的测试类
 *@author Orange
 *@date 下午8:16:58,2016年3月3日
 *@vesion V1.0
 *@see yjwsmileatlife@126.com
 */
public class TestStringUtils {
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass:StringUtils");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass:StringUtils");
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
	 * 测试00020001:一次性判断多个或单个对象为空
	 */
	@Test
	public void testIsBlank(){
		String strNull0001 = "nullStr";
		String strNotNull0001 = "notNullStr";
		System.out.println("00020001:"+StringUtils.isBlank(strNull0001,strNotNull0001));
	}
	
	/**
	 * 测试00020002:一次性判断多个或单个对象不为空
	 */
	@Test
	public void testIsNotBlank(){
		String strNull0002 = "nullStr";
		String strNotNull0002 = "notNullStr";
		System.out.println("00020002:"+StringUtils.isNotBlank(strNull0002,strNotNull0002));
	}
	
	/**
	 * 测试 00020003:处理空对象类型返回字符串类型
	 */
	@Test
	public void testCheckNullToConvert(){
		String str0003 = "Hello world";
		System.out.println("00020003:"+StringUtils.checkNullToConvert(str0003));
	}
	
	/**
	 * 测试00020004:判断一个字符串在数组中存在几个
	 */
	@Test
	public void testIndexOf(){
		String[] strings0004 = new String[]{"H","e","l","l","o","w","o","r","l","d"};
		System.out.println("00020004:"+StringUtils.indexOf("l",strings0004));
	}
	
	/**
	 * 测试00020005:替换字符串
	 */
	@Test
	public void testReplaceString(){
		String str0005 = "Hello world";
		String nowStr0005 = "l";
		String replaceStr0005 = "i";
		System.out.println("00020005:"+StringUtils.replaceString(str0005, nowStr0005, replaceStr0005));
	}
	
	/**
	 * 测试00020006:判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null
	 */
	@Test
	public void testIsJSONObject(){
		String arg0006 = "{'userName': 'yjw','password': '123456','email': 'yjwsmileatlife@126.com'}";
		System.out.println("00020006:"+StringUtils.isJSONObject(arg0006));
	}
	
}
