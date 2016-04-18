package com.yjw.utils.thread;
/**
 * 
 *@author Higher
 *@date 11:33:51 PM,Apr 18, 2016
 *@vesion v1.0
 *@see yjwsmileatlife@126.com
 */
public class ThreadDemo extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(getName()+"是一个演员");
		
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning){
			System.out.println(getName()+"登台演出："+(++count));
			if(count == 100){
				keepRunning = false;
			}
			
			if(count % 10 == 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(getName()+"的演出结束了");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		//1、测试extends Thread
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.setName("Mr.Thread");
		threadDemo.start();
		
		//2、测试implements Runnable
		Thread runnableDemo = new Thread(new RunnableDemo(), "Ms.Runnable");
		runnableDemo.start();
		
	}
	
}

class RunnableDemo implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"是一个演员");
		
		int count = 0;
		boolean keepRunning = true;
		while(keepRunning){
			System.out.println(Thread.currentThread().getName()+"登台演出："+(++count));
			if(count == 100){
				keepRunning = false;
			}
			
			if(count % 10 == 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"的演出结束了");
		}
		
		
	}
	
}

