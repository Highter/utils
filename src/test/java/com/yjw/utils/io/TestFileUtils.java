package com.yjw.utils.io;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 0005:文件流处理类的测试类
 *@author Administrator
 *@date 上午10:44:20,2016年7月13日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class TestFileUtils {
	
	public static String path = "E:\\100bei\\FileUtils.txt";
	public static String writeMsg = "Hello word!";
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("@BeforeClass:TestFileUtils");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("@AfterClass:TestFileUtils");
	}
	
	@Before
	public void before(){
		System.out.println("@Before:TestFileUtils");
	}
	
	@After
	public void after(){
		System.out.println("@After:TestFileUtils");
	}
	
	/**
	 * 00050001测试 往文件写入内容
	 */
	@Test
	public void testWriteFile(){
		boolean writeFlag = FileUtils.writeFile(path, writeMsg);
		if(writeFlag){
			System.out.println("writeFile-写入成功");
		}else{
			System.out.println("writeFile-写入失败");
		}
	}
	
	/**
	 * 00050002测试 往文件写入内容（拼接内容）
	 */
	@Test
	public void testWriteAppendFile(){
		boolean writeFlag = FileUtils.writeAppendFile(path, writeMsg);
		if(writeFlag){
			System.out.println("writeAppendFile（拼接内容）-写入成功");
		}else{
			System.out.println("writeAppendFile（拼接内容）-写入失败");
		}
	}
	
	/**
	 * 00050003测试 读取文件内容
	 */
	@Test
	public void testReadFile(){
		String result = FileUtils.readFile(path);
		System.out.println("读取文件内容："+result);
	}
	
	
	public static void main(String[] args) {
		//写文件
		boolean writeFlag = FileUtils.writeAppendFile(path, writeMsg);
		if(writeFlag){
			System.out.println("文件写入成功");
		}else{
			System.out.println("文件写入失败");
		}
		
		//读文件
		String result = FileUtils.readFile(path);
		System.out.println("读取文件内容："+result);
	}
}
