package com.yjw.utils.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/*
 * 客户端
 */
public class TestSocketClient {
	public static void main(String[] args) {
		TestSocketClient socketClient = new TestSocketClient();
		socketClient.newSocketClientTest();//测试新建socket客户端
	}
	
	/**
	 * 测试新建socket客户端
	 */
	@Test
	public void newSocketClientTest(){
		try {
			//1、创建客户端Socket,指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			
			//2、获取输出流，向服务器发送消息
			OutputStream os = socket.getOutputStream();//字节输出流
			PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
			pw.write("用户名:admin；密码:123");
			pw.flush();
			//pw.close();//不能关闭输出流，会导致socket也被关闭
			socket.shutdownOutput();//关闭输出流
			
			//3、获取输入流，并读取服务器端的响应信息
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=br.readLine()) != null){
				System.out.println("我是客户端，服务器说:"+info);
			}
			
			//4、关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();//直接关闭socket即可
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 测试新建socket客户端-传递对象
	 */
	@Test
	public void newSocketClientObjectTest(){
		try {
			//1、创建客户端Socket,指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			
			//2、获取输出流，向服务器发送消息
			OutputStream os = socket.getOutputStream();//字节输出流
			//使用objectoutputStream对象序列化流，传递对象
			ObjectOutputStream oos = new ObjectOutputStream(os);
			User user = new User("admin", "123");
			oos.writeObject(user);
			socket.shutdownOutput();//关闭输出流
			
			//3、获取输入流，并读取服务器端的响应信息
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=br.readLine()) != null){
				System.out.println("我是客户端，服务器说:"+info);
			}
			
			//4、关闭资源
			br.close();
			is.close();
			oos.close();
			os.close();
			socket.close();//直接关闭socket即可
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
