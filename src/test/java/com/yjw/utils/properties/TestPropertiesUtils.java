package com.yjw.utils.properties;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 0006:properties配置文件工具类配置文件工具类的测试类
 *@author Orage
 *@date 下午2:48:06,2016年7月13日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class TestPropertiesUtils {
	
	public static String fileName = "test.properties";
	public static String keyName = "testUrl";
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass:MemcachedUtils");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass:MemcachedUtils");
	}
	
	@Before
	public void before(){
		System.out.println("@Before:MemcachedUtils");
	}
	
	@After
	public void after(){
		System.out.println("@After:MemcachedUtils");
	}
	
	/**
	 * 测试0006001：获取文件的 Properties 对象（一）
	 */
	@Test
	public void testGetProperty(){
		Properties pro = PropertiesUtils.getProperty(fileName);
		if(pro != null){
			System.out.println("0006001测试结果：Properties对象为"+pro);
		}else{
			System.out.println("0006001测试结果：Properties对象为null");
		}
	}
	
	/**
	 * 测试0006002：获取文件的 Properties 对象（二）
	 */
	@Test
	public void testLoadProperties(){
		Properties pro = PropertiesUtils.loadProperties(fileName);
		if(pro != null){
			System.out.println("0006003测试结果：Properties对象为"+pro);
		}else{
			System.out.println("0006003测试结果：Properties对象为null");
		}
	}
	
	/**
	 * 测试0006003：根据 文件名、key 获取value值
	 */
	@Test
	public void testGetPropertyValue(){
		String result = PropertiesUtils.getPropertyValue(keyName,fileName);
		System.out.println("0006002测试结果：" + result);
	}
	
	public static void main(String[] args) {
		Properties pro = PropertiesUtils.loadProperties(fileName);
		String testUrl = pro.getProperty(keyName);
		System.out.println(keyName+"="+testUrl);
	}
}
