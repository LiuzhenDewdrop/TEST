package com.liuzhen.tread;
/**
 * @class: Test001
 * @description: 
 * @author Liuzhen
 */
public class Test001 extends Thread {
	
	Thread t1 = new Thread();
	Thread t2 = new Thread();
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				TestEntity t = new TestEntity("1", "aaa");
			}
		});
		t1.start();
	}
}
