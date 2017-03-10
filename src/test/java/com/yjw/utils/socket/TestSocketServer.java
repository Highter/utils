package com.yjw.utils.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/*
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class TestSocketServer {
	public static void main(String[] args) {
		TestSocketServer socketServer = new TestSocketServer();
		socketServer.newServerSocketTest();//测试新建socket服务端
	}
	
	/**
	 * 测试新建socket服务端
	 */
	@Test
	public void newServerSocketTest(){
		try {
			//1、创建一个服务器Socket，即ServerSocket，指定绑定的端口
			ServerSocket serverSocket=new ServerSocket(8888);
			
			//2、调用accept()方法开始监听，等待客户端的连接
			System.out.println("***服务端即将启动，等待客户端的连接***");
			Socket socket = serverSocket.accept();
			
			//3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();//字节输入流
			InputStreamReader isr = new InputStreamReader(is);//将字节流转换为字符流
			BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
			String info = null;
			while((info=br.readLine())!=null){//循环读取客户端的信息
				System.out.println("我是服务器，客户端说:"+info);
			}
			socket.shutdownInput();//关闭输入流
			
			//4、获取输出流，响应客户端的请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);//包装为打印流
			pw.write("欢迎您!");
			pw.flush();//调用flush()方法将缓冲输出
			
			//5、关闭资源
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试新建socket服务端-传递对象
	 */
	@Test
	public void newServerSocketObjectTest(){
		try {
			//1、创建一个服务器Socket，即ServerSocket，指定绑定的端口
			ServerSocket serverSocket=new ServerSocket(8888);
			
			//2、调用accept()方法开始监听，等待客户端的连接
			System.out.println("***服务端即将启动，等待客户端的连接***");
			Socket socket = serverSocket.accept();
			
			//3、获取输入流，并读取客户端信息
			InputStream is = socket.getInputStream();//字节输入流
			/*InputStreamReader isr = new InputStreamReader(is);//将字节流转换为字符流
			BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
			String info = null;
			while((info=br.readLine())!=null){//循环读取客户端的信息
				System.out.println("我是服务器，客户端说:"+info);
			}*/
			//使用objectoutputStream对象序列化流，传递对象
			ObjectInputStream ois = new ObjectInputStream(is);
			try {
				User user = (User) ois.readObject();
				if(user != null){
					System.out.println("我是服务器，客户端说:"+user.toString());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			socket.shutdownInput();//关闭输入流
			
			//4、获取输出流，响应客户端的请求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);//包装为打印流
			pw.write("欢迎您!");
			pw.flush();//调用flush()方法将缓冲输出
			
			//5、关闭资源
			pw.close();
			os.close();
			ois.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
