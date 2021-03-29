package com.liuzhen.app.util;
/**
 * @class: MathUtils
 * @description: 
 * @author: L.zhen
 * @date: 2021/2/17 11:06
 */
public class MathUtils {

	public static int factorial(int n) {
		if (n < 0) {
			System.out.println("n=" + n + "是负数");
			return 0;
		}
		int m = 1;
		while (n > 0) {
			m *= n--;
		}
		return m;
	}
	
	public static int combine(int n, int m) {
		return factorial(n)/factorial(m)/factorial(n-m);
	}
	
	public static String fmtLength(int n, int digit) {
		boolean p = n >= 0;
		if (!p) {
			n = -n;
		}
		String s = n + "";
		while (s.length() < digit) {
			s = "0" + s;
		}
		return p ? s :  ("-" + s);
	}
}
