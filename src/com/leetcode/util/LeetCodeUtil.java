package com.leetcode.util;

/*
 * @class: LeetCodeUtil
 * @description: 工具
 * @author: L.zhen
 * @date: 2018/8/30 14:54
 */
public class LeetCodeUtil {
	
	public static void test(Object o1, Object o2) {
		System.out.println(o1 != null ? o1.equals(o2) : o2 == null);
	}
	
	public static void main(String[] args) {
		test(12321);
		test(12345);
		test(12341);
		test(12324);
	}
	
	private static void test(int x) {
		int a = 10001;
		int b = 1010;
		int c = 100;
		System.out.println(x % a % b);
	}
}
