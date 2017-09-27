package com.liuzhen.jdk;
/**
 * @class: Test7
 * @description: jdk1.7
 * @author: Liuzhen
 * @date: 2017/8/16 14:19
 */
public class Test7 {
	
	public static void main(String[] args) {
		test001();
	}
	
	private static void test001() {
		int a = 100_100;
		int b = 0b11001110101;
		System.out.println(a);
		System.out.println(b);
	}
}
