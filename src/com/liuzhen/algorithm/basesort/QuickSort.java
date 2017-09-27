package com.liuzhen.algorithm.basesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快速排序
 */
public class QuickSort {

	private void quick(int[] a, int low, int high) {
		if (low < high) {
			int start = low;							// 本次排序的数组头
			int end = high;								// 本次排序的数组尾
			int mid = a[low];							// 参考点
			while (low < high) {
				while (low < high && mid <= a[high]) {	// 右侧比参考点大的不交换
					high--;
				}
				a[low] = a[high];						// 右侧比参考点小的左移
				while (low < high && a[low] <= mid) {	// 左侧比参考点小的不交换
					low++;
				}
				a[high] = a[low];						// 左侧比参考点大的右移
			}
			a[low] = mid;								// 参考点数据安置
			quick(a, start, low - 1);				// 参考点左侧数组排序
			quick(a, low + 1, end);					// 参考点右侧数组排序
		}
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		QuickSort t = new QuickSort();
		t.quick(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(5);
		b.add(6);
		b.add(5);
		b.add(7);
		b.add(4);
		b.add(5);
		b.add(6);
		b.add(5);
		b.add(6);
		b.add(4);
		b.add(4);
		b.add(6);
		b.add(4);
		System.out.println("去重数量:" + t.quickCombine(b, 0, b.size() - 1));
		System.out.println(Arrays.toString(b.toArray()));
	}
	
	/**
	 * @title:  quickCombine
	 * @description: 去重快排
	 * @param list
	 * @param low
	 * @param high
	 * @author: Liuzhen
	 * @date:   2017-5-9 9:44
	 */
	private int quickCombine(List<Integer> list, int low, int high) {
		int decrease = 0;								// 因去重而导致list的减少量
		if (low < high) {
			int start = low;							// 本次排序的数组头
			int end = high;								// 本次排序的数组尾
			int mid = list.get(low);					// 参考点
			while (low < high) {
				while (low < high && mid <= list.get(high)) {	// 右侧比参考点大的不交换
					if (mid == list.get(high)) {
						list.remove(high);
						decrease ++;
					}
					high--;
				}
				list.set(low, list.get(high));					// 右侧比参考点小的左移
				while (low < high && list.get(low) <= mid) {	// 左侧比参考点小的不交换
					if (mid == list.get(low) && low != start) {
						list.remove(low--);
						high --;
						decrease ++;
					}
					low++;
				}
				list.set(high ,list.get(low));					// 左侧比参考点大的右移
			}
			list.set(low, mid);															// 参考点数据安置
			int d1 = quickCombine(list, start, low - 1);							// 参考点左侧数组排序
			decrease += d1;
			decrease += quickCombine(list, low + 1 - d1, end - decrease);		// 参考点右侧数组排序
		}
		return decrease;
	}
}
