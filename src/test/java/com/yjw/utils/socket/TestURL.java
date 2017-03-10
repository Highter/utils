package com.yjw.utils.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL常用方法
 */
public class TestURL {
	public static void main(String[] args) {
		//测试URL的常见方法
		testURL();
		
		//使用URL读取页面内容
		getWebMsg();
	}
	
	/**
	 * 测试URL的常见方法
	 */
	public static void testURL(){
		try {
			//创建一个URL实例
			URL imooc=new URL("http://www.imooc.com");
			//?后面表示参数，#后面表示锚点
			URL url=new URL(imooc, "/index.html?username=tom#test");
			System.out.println("协议:"+url.getProtocol());
			System.out.println("主机"+url.getHost());
			//如果未指定端口号，则使用默认的端口，此时getPort()方法放回值为-1
			System.out.println("端口"+url.getPort());
			System.out.println("文件路径"+url.getPath());
			System.out.println("文件名"+url.getFile());
			System.out.println("相对路径"+url.getRef());
			System.out.println("查询字符串"+url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用URL读取页面内容
	 */
	public static void getWebMsg(){
		try {
			//创建一个URL实例
			URL url = new URL("http://www.baidu.com");
			//通过URL的openStream方法获取URL对象所表示的资源的字节输入流
			InputStream is = url.openStream();
			//将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			//为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();//读取数据
			while (data != null) {//循环读取数据
				System.out.println(data);//输出数据
				data = br.readLine();
			}
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
