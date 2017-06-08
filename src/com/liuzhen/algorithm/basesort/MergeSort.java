package com.liuzhen.algorithm.basesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归并排序
 */
public class MergeSort {

	private int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int a1 = 0;
		int b1 = 0;
		for (int i = 0; i < c.length; i++) {
			if (a1 == a.length) {
				while (b1 != b.length) {
					c[i++] = b[b1++];
				}
			} else if (b1 == b.length) {
				while (a1 != a.length) {
					c[i++] = a[a1++];
				}
			}else if (a[a1] < b[b1]) {
				c[i] = a[a1++];
			} else {
				c[i] = b[b1++];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 99};
		int[] b = {4, 6, 7, 32, 72, 84, 99, 111, 120};
		MergeSort t = new MergeSort();
		System.out.println(Arrays.toString(t.merge(a, b)));
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i <5 ; i++) {
			list1.add(i * 2 + 10);
		}
		list1.add(23);
		list2.add(3);
		list2.add(8);
		list2.add(11);
		list2.add(13);
		list2.add(15);
		list2.add(19);
		list2.add(20);
		list2.add(21);
		list2.add(24);
		list2.add(25);
		list2.add(26);
		list2.add(27);
		List<Integer> resultList = t.mergeList(list1, list2);
		System.out.println(1);
		System.exit(0);
	}
	
	private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
		if (list1 == null || list1.size() == 0) {
			return list2;
		}
		if (list2 == null || list2.size() == 0) {
			return list1;
		}
		// 结果list
		List<Integer> resultList = new ArrayList<>(list1.size() + list2.size());
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < list1.size() + list2.size(); i++) {
			if (index1 == list1.size()) {
				while (index2 != list2.size()) {
					resultList.add(list2.get(index2++));
				}
				break;
			} else if (index2 == list2.size()) {
				while (index1 != list1.size()) {
					resultList.add(list1.get(index1++));
				}
				break;
			}else if (list2.get(index2) < list1.get(index1)) {
				resultList.add(list2.get(index2++));
			} else {
				resultList.add(list1.get(index1++));
			}
		}
		return resultList;
	}
}
