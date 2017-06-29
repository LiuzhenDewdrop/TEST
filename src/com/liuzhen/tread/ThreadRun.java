package com.liuzhen.tread;
/**
 * @class: ThreadRun
 * @description: 
 * @author: Liuzhen
 */
public class ThreadRun {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> System.out.println(123));
		Thread t2 = new Thread(() -> System.out.println(456));
		t1.start();
		t2.run();
	}
}
