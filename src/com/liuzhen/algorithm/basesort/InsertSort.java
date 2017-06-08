package com.liuzhen.algorithm.basesort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
	
	private void insert(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				int j = i - 1;
				int temp = a[i];		// 记录较小值
				a[i] = a[i - 1];		// 较大值后移
				while (temp < a[j]) {	// 较小值向前移动
					if (--j == -1) {
						break;
					}
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;		// 小值前移受阻或到达最左端,把较小值插入合理位置
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		InsertSort t = new InsertSort();
		t.insert(a);
		System.out.println(Arrays.toString(a));
	}
}
