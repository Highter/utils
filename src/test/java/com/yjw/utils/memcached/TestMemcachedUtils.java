package com.yjw.utils.memcached;

import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yjw.utils.memcache.MemcachedUtils;

import net.rubyeye.xmemcached.exception.MemcachedException;

/**
 * 0004:memcached缓存工具类的测试类
 * @author Orange
 * @date 下午4:42:02,2016年3月4日
 * @vesion V1.0
 * @see yjwsmileatlife@126.com
 */
public class TestMemcachedUtils {
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
	 * 00040001测试 设置/获取
	 */
	@Test
	public void setMemcached(){
		try {
			MemcachedUtils.memcachedClient.set("test", 20, "Hello,world!");
			Object object = MemcachedUtils.memcachedClient.get("test");
			if(object != null){
//				Assert.assertEquals("Hello,world!", object);
				System.out.println("存放成功:"+object.toString());
			}else{
				System.out.println("存放失败!");
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 00040002测试 获取
	 */
	@Test
	public void getMemcached(){
		try {
			Object object = MemcachedUtils.memcachedClient.get("test");
			System.out.println("存放的内容为："+object);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 00040003测试 替换
	 */
	@Test
	public void replaceMemcached(){
		try {
			MemcachedUtils.memcachedClient.replace("test", 20, "Hello,world!(replace)");
			Object object = MemcachedUtils.memcachedClient.get("test");
			if(object != null){
//				Assert.assertEquals("Hello,world!(replace)", object);
				System.out.println("替换成功:"+object.toString());
			}else{
				System.out.println("替换失败!");
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 00040004测试 删除
	 */
	@Test
	public void deleteMemcached(){
		try {
			MemcachedUtils.memcachedClient.delete("test");
			Object object = MemcachedUtils.memcachedClient.get("test");
			Assert.assertNull(object);
			/*if(object == null){
				System.out.println("删除成功！");
			}*/
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
