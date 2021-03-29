package com.liuzhen.algorithm;

import java.util.Arrays;

import com.liuzhen.app.util.MathUtils;

/**
 * n个元素中选取m个元素的排列组合
 */
public class Q_MFromN {

	/**
	 * 获取m个元素的组合
	 */
	private static int getC(Object[] a,int start, Object[] b, int m, Object[][] c, int ci) {
		if (m == 0) {
			System.arraycopy(b, 0, c[ci], 0, b.length);
			return ci + 1;
		}
		for (int i = start; i < a.length; i++) {
			b[m - 1] = a[i];
			ci = getC(a, i + 1, b, m - 1, c, ci);
		}
		return ci;
	}
	
	public static Object[][] getC(Object[] a, int m) {
		Object[] b = new Object[m];
		Object[][] c = new Object[MathUtils.combine(a.length, m)][m];
		int ci = 0;
		getC(a, 0, b, m, c, ci);
		return c;
	}
	
	/**
	 * 获取m个元素的排列
	 */
	public static void getA(Object[] a, int start, Object[] b, int m) {
		if (m == 0) {
			System.out.println(Arrays.toString(b));
		} else {
			for (int i = start; i < a.length; i++) {
				b[m - 1] = a[i];
				Object temp = a[i];
				a[i] = a[start];
				a[start] = temp;
				getA(a, start + 1, b , m -1);
				a[start] = a[i];
				a[i] = temp;
			}
		}
	}
	
	/**
	 * 获取全排列
	 */
	public static void getAAll(Object[] a, int start) {
		if (start == a.length) {
			System.out.println(Arrays.toString(a));
		} else {
			for (int i = start; i < a.length; i++) {
				Object temp = a[i];
				a[i] = a[start];
				a[start] = temp;
				getAAll(a, start + 1);
				a[start] = a[i];
				a[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		String[] a = {"a", "b", "c", "d"};
		int m = 3;
		Object[][] c = getC(a, m);
		for (Object[] c1 : c) {
			System.out.println(Arrays.toString(c1));
		}
		Integer[] d = {1, 2, 3, 4, 5};
		getAAll(d, 0);
		Integer[] e = new Integer[m];
		getA(d, 0, e, m);
	}
	
	
}
