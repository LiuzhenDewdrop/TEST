package com.liuzhen.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question001 {
	
	// 1、2、3、4、5这5个数字，输出不同的顺序，其中4不可以排在第三位，3和5不能相邻，请问有多少种组合？
	int[] arr = {1, 2, 3, 4, 5};
	int count = 0;
	public void getSource(int x, int y) {
		if (x == y) {
			String arrString = Arrays.toString(arr);
			if (indexCondition(arr) && sideConditon(arrString, "3", "5", 3)) {
				System.out.println(arrString + ++count);
			}
		} else {
			for (int i = x; i <= y; i++) {
				swap(x, i);                                           
				getSource(x + 1, y);
				swap(x, i);
			}
		}
	}
	
	private boolean indexCondition(int[] a) {
		return a[2] != 4;
	}
	
	private boolean sideConditon(String str,String a,String b, int length) {
		return Math.abs(str.indexOf(a) - str.indexOf(b)) != length;
	}
	
	private void swap(int index1, int index2) {
		if (index1 == index2) {
			return;
		} else {
			int temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		}
	}
	
	public static void main(String[] args) {
		Question001 q = new Question001();
		q.getSource(0, q.arr.length - 1);
		List<Integer> list = q.createList();
		//q.getAllSource(list, "");
		System.out.println(q.count);
	}
	
	public List<Integer> createList() {
		List<Integer> list = new ArrayList<Integer>(5);
		for (int i = 1; i < 6; i++) {
			list.add(i);
		}
		return list;
	}
	
	public void getAllSource(List<Integer> list, String result) {
		if (list.size() == 0 && indexCondition(result) && sideConditon(result, "3", "5", 1)) {
			System.out.println(result);
			count++;
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			List<Integer> temp = new ArrayList<Integer>(list.size());
			temp.addAll(list);
			int t = temp.get(i);
			temp.remove(i);
			getAllSource(temp, result + t);
		}
	}
	
	private boolean indexCondition(String str) {
		return str.indexOf("4") != 2;
	}
}
