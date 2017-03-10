package com.yjw.utils.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
 * InetAddress类
 */
public class TestInetAddress {

	public static void main(String[] args) {
		getHostMsg();
	}
	
	public static void getHostMsg(){
		try {
			//获取本机的InetAddress实例
			InetAddress address = InetAddress.getLocalHost();
			
			//获取计算机名
			System.out.println("计算机名:"+address.getHostName());
			System.out.println("IP地址:"+address.getHostAddress());
			byte[] bytes = address.getAddress();//获取字节数组形式的IP地址
			System.out.println("字节数组形式的IP:"+Arrays.toString(bytes));//当字节数组需要输出的值在大于127时就会以负数的形式输出，把得到的负数加上256就正常了
			System.out.println("InetAddress对象:"+address);
			
			//根据机器名获取InetAddress实例
			InetAddress address2 = InetAddress.getByName("Hunter-Mac.local");
			//InetAddress address2 = InetAddress.getByName("192.168.210.60");
			System.out.println("计算机名:" + address2.getHostName());
	        System.out.println("IP地址:" + address2.getHostAddress());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
