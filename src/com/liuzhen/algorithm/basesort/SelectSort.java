package com.liuzhen.algorithm.basesort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
	
	private void select(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;								// 依次以第一个数值作为标杆index
			for (int j = i; j < a.length - 1; j++) {
				if (a[min] > a[j + 1]) {
					min = j + 1;						// 拿到最小值的index
				}
			}
			if (a[min] != a[i]) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}
	
	private void select1(int[] a) {						// 双向选择
		for (int i = 0; i < a.length/2; i++) {
			int min = i;								// 依次选择最小值标杆index
			int max = a.length - i - 1;					// 依次选择最大值标杆index
			for (int j = i; j < a.length - i - 1; j++) {
				if (a[min] > a[j + 1]) {
					min = j + 1;						// 找到最小值位置
				}
				if (a[max] < a[j]) {
					max = j;							// 找到最大值位置
				}
			}
			if (a[min] != a[i]) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			if (a[max] != a[a.length - i - 1]) {
				int temp = a[a.length - i - 1];
				a[a.length - i - 1] = a[max];
				a[max] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		SelectSort t = new SelectSort();
		//t.select(a);
		System.out.println(Arrays.toString(a));
		t.select1(a);
		System.out.println(Arrays.toString(a));
	}
}
