package com.qf.ssm.interceptor;

public class Test {
	
	private static Integer a;
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
		threadLocal.set(10);
		
		new Thread(){
			public void run() {
				threadLocal.set(1000);
				System.out.println("另一个线程：" + threadLocal.get());
			};
		}.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("主线程：" + threadLocal.get());
	}
}
