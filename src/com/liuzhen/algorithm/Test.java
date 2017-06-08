package com.liuzhen.algorithm;
/**
 * @class: Test
 * @description: 
 * @author Liuzhen
 */
public class Test {
	
	public static void main(String[] args) {
		System.out.println(checkCondition(63, 32));
		System.out.println(checkCondition(63, 16));
		System.out.println(checkCondition(63, 8));
		System.out.println(checkCondition(63, 4));
		System.out.println(checkCondition(63, 2));
		System.out.println(checkCondition(32, 32));
		System.out.println(checkCondition(32, 16));
		System.out.println(checkCondition(32, 8));
		System.out.println(checkCondition(32, 4));
		System.out.println(checkCondition(32, 2));
		System.out.println(checkCondition(32, 1));
		System.out.println(17 & 16);
		System.out.println(Integer.toBinaryString(3));
		System.out.println(Integer.parseInt("100000", 2));
	}
	
	private static boolean checkCondition(int src, int condition) {
		return (src & condition) > 0;
	}
}








