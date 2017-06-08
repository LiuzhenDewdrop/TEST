package com.liuzhen.algorithm.basesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 */
public class RedixSort {
	
	private void redix(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {	// 找到最大值
			if (a[i] > max) {
				max = a[i];
			}
		}
		int time = 0;
		while (max > 0) {						// 根据最大值判断位数
			max /= 10;
			time++;
		}
		
		List<List<Integer>> queue = new ArrayList<List<Integer>>(10);
		for (int i = 0; i < 10; i++) {			// 创建10个空桶
			List<Integer> l = new ArrayList<Integer>();
			queue.add(l);
		}
		
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < a.length; j++) {
				int x = a[j] % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
				List<Integer> list = queue.get(x);
				list.add(a[j]);
				//queue.set(x, list);
			}
			
			int count = 0;
			for (int j = 0; j < 10; j++) {
				while (queue.get(j).size() > 0) {
					List<Integer> list = queue.get(j);
					a[count] = list.get(0);
					list.remove(0);
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RedixSort r = new RedixSort();
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		r.redix(a);
		System.out.println(Arrays.toString(a));
	}
}
