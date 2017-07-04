package com.liuzhen.algorithm;

import java.util.Arrays;

/**
 * n个元素中选取m个元素的排列组合
 */
public class Q_MFromN {

	/**
	 * 获取m个元素的组合
	 */
	private void getC(String[] a,int start, String[] b, int m) {
		if (m == 0) {
			System.out.println(Arrays.toString(b));
			return;
		}
		for (int i = start; i < a.length; i++) {
			b[m - 1] = a[i];
			getC(a, i + 1, b, m - 1);
		}
	}
	
	/**
	 * 获取m个元素的排列
	 */
	private void getA(int[] a, int start, int[] b, int m) {
		if (m == 0) {
			System.out.println(Arrays.toString(b));
		} else {
			for (int i = start; i < a.length; i++) {
				b[m - 1] = a[i];
				int temp = a[i];
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
	private void getAAll(int[] a, int start) {
		if (start == a.length) {
			System.out.println(Arrays.toString(a));
		} else {
			for (int i = start; i < a.length; i++) {
				int temp = a[i];
				a[i] = a[start];
				a[start] = temp;
				getAAll(a, start + 1);
				a[start] = a[i];
				a[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		Q_MFromN q = new Q_MFromN();
		String[] a = {"a", "b", "c", "d"};
		int m = 3;
		String[] b = new String[m];
		q.getC(a, 0, b, m);
		int[] c = {1, 2, 3, 4, 5};
//		q.getAAll(c, 0);
		int[] d = new int[m];
//		q.getA(c, 0, d, m);
	}
}
