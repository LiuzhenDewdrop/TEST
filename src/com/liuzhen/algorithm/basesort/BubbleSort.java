package com.liuzhen.algorithm.basesort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
	
	private void bubble(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {			// 大数右移
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	
	private void bubble1(int[] a) {
		int i = a.length - 1;
		while (i > 0) {
			int pos = 0;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					pos = j;					// 记录最后交换的位置
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			i = pos;							// 上次pos之后的数据没有交换过,也就是不需要再比较了
		}
	}
	
	private void bubble2(int[] a) {
		int low = 0;							// 低端,从左开始
		int high = a.length - 1;				// 高端,从右开始
		while (low < high) {
			for (int i = low; i < high; i++) {	// 从左到右,大数右移
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			high--;
			for (int i = high; i > low; i--) {	// 从右到左,小数左移
				if (a[i] < a[i - 1]) {
					int temp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = temp;
				}
			}
			low++;
		}
	}
	
	private void bubble3(int[] a) {
		for (int i = 0; i < a.length/2; i++) {
			for (int j = i; j < a.length - i - 1; j++) {			// 相比于上一个方法,内层1次for循环,同时双向收紧
				if (a[j] > a[j + 1]) {								// 从左到右,大数右移
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
				if (a[a.length - j - 2] > a[a.length - j - 1]) {	// 从右到左,小数左移
					int temp = a[a.length - j - 2];
					a[a.length - j - 2] = a[a.length - j - 1];
					a[a.length - j - 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		BubbleSort t = new BubbleSort();
		t.bubble3(a);
		System.out.println(Arrays.toString(a));
	}
}
