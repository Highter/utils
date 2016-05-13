package com.yjw.utils.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 *@author yjw
 *@date 下午4:49:44,2016年5月13日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class ThreadTest implements Runnable{
	
	private final ReentrantLock lock = new ReentrantLock();

	public void run() {
		int i = 0;
		System.out.println("线程开始");
		boolean keeping = true;
		while(keeping){
			lock.lock();
			i++;
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				System.out.println("121231");
				lock.unlock();
			}
		}
		System.out.println("线程结束");
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadTest(),"yjw");
		thread.start();
	}

}
