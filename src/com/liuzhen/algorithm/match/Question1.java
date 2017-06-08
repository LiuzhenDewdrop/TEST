package com.liuzhen.algorithm.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {

	private String getAnswer1(String str) {
		String result = "";
		List<Integer> list = getListNum(str);
		List<Integer> resultList = getJiecheng(list);
		for (int i = 0; i < resultList.size(); i++) {
			result = resultList.get(i) == 0 ? "0000" + result : resultList.get(i) + result;
		}
		
		return result;
	}
	
	private List<Integer> getJiecheng(List<Integer> l) {
		List<Integer> resultList = new ArrayList<Integer>();
		resultList.addAll(l);
		while (true) {
			minus(l, 0);								// n-1
			if (isZero(l)) {
				return resultList;
			}
			resultList = times(resultList, l);
		}
	}
	// 判断该数值是否为0
	private boolean isZero(List<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) > 0) {
				return false;
			}
		}
		return true;
	}
	// 两数相加
	private List<Integer> plus(List<Integer> l1, List<Integer> l2) {
		List<Integer> leftList = l1.size() < l2.size() ? l2 : l1;
		int length = l1.size() < l2.size() ? l1.size() : l2.size();
		List<Integer> resultList = new ArrayList<Integer>();
		int left = 0;
		for (int i = 0; i < length; i++) {
			if ((left + l1.get(i) + l2.get(i)) > 9999) {
				resultList.add((left + l1.get(i) + l2.get(i)) % 10000);
				left = (left + l1.get(i) + l2.get(i)) / 10000;
			} else {
				resultList.add(left + l1.get(i) + l2.get(i));
				left = 0;
			}
		}
		for (int i = length; i < leftList.size(); i++) {
			if ((leftList.get(i) + left) > 9999) {
				resultList.add((left + leftList.get(i)) % 10000);
				left = (left + leftList.get(i)) / 10000;
			} else {
				resultList.add(left + leftList.get(i));
				left = 0;
			}
		}
		if (left != 0) {
			resultList.add(left);
		}
		return resultList;
	}
	// 找n-1
	private void minus(List<Integer> l, int index) {
		if (l.get(index) == 0) {
			l.set(index, 9999);
			minus(l, index + 1);
		} else {
			l.set(index, l.get(index) - 1);
		}
		if (index == l.size() - 1) {
			return;
		}
	}
	// 两数相乘
	private List<Integer> times(List<Integer> a, List<Integer> b) {
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			List<Integer> child = times(b, a.get(i), i);
			resultList = plus(resultList, child);
		}
		return resultList;
	}
	// 一个数乘以某一位
	private List<Integer> times(List<Integer> a, int b, int c) {
		List<Integer> resultList = new ArrayList<Integer>();
		int left = 0;
		for (int i = 0; i < c; i++) {
			resultList.add(0);
		}
		for (int i = 0; i < a.size(); i++) {
			if ((a.get(i) * b + left) > 9999) {
				resultList.add((a.get(i) * b + left) % 10000);
				left = (a.get(i) * b + left) / 10000;
			} else {
				resultList.add(a.get(i) * b + left);
				left = 0;
			}
			
		}
		if (left != 0) {
			resultList.add(left);
		}
		return resultList;
	}
	// 把字符串获取成数字
	private List<Integer> getListNum(String str) {
		List<Integer> list = new ArrayList<Integer>();
		if (str.length() > 4) {
			char[] ch = str.toCharArray();
			String result = "";
			for (int i = 0 ; i < 4; i++) {
				result += ch[ch.length + i - 4];
			}
			list.add(Integer.parseInt(result));
			String nextStr = "";
			for (int i = 0; i < ch.length - 4; i++) {
				nextStr += ch[i];
			}
			list.addAll(getListNum(nextStr));
			return list;
		}
		list.add(Integer.parseInt(str));
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t1 = sc.nextLine();
		int num = Integer.parseInt(t1);
		String[] q = new String[num];
		
		for (int i = 0; i < num; i++) {
			q[i] = sc.nextLine();
		}
		Question1 a1 = new Question1();
		for (int i = 0; i < num; i++) {
			System.out.println(a1.getAnswer1(q[i]));
		}
		System.exit(0);
	}
}
