package com.yjw.utils.log4j;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试通过log4j.properties来写日志
 *@author Higher
 *@date 上午10:59:11,2016年7月14日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class TestLog4j {
	
	static Logger logger = Logger.getLogger(TestSendMail.class);
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass:TestLog4j");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass:TestLog4j");
	}
	
	@Before
	public void before(){
		System.out.println("@Before:TestLog4j");
	}
	
	@After
	public void after(){
		System.out.println("@After:TestLog4j");
	}
	
	
	@Test
	public void testLog4j(){
		//logger.debug("test-debug");
		//logger.info("test-info");
		logger.error("test-error");
	}
}
