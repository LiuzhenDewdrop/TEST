package com.liuzhen.algorithm.basesort;

import java.util.Arrays;

/**
 * 希尔插入排序
 */
public class ShellSort {

	private void shellInsert(int[] a) {
		int d = a.length%2 == 0 ? a.length/2 : a.length/2 + 1;	// 以长度半数作为间隔值d
		while (true) {
			for (int i = 0; i < d; i++) {						// 隔断为d组(如1、4、7...2、5、8...3、6、9...)
				for (int j = i; j < a.length - d; j += d) {		// 对每组分别进行插入排序
					if (a[j] > a[j + d]) {
						int k = j;
						int x = a[j + d];
						a[j + d] = a[j];
						while (x < a[k]) {
							k -= d;
							if (k < 0) {
								break;
							}
							a[k + d] = a[k];
						}
						a[k + d] = x;
					}
				}
			}
			if (d == 1) {										// 程序出口为间隔值为1并跑完一圈后(此时相当于对部分有序的数组进行插入排序)
				break;
			}
			d = d%2 == 0 ? d/2 : d/2 + 1;						// 以间隔值的半数作为新的间隔值
		}
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		ShellSort t = new ShellSort();
		t.shellInsert(a);
		System.out.println(Arrays.toString(a));
	}
}
