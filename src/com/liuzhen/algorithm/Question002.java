package com.liuzhen.algorithm;

import java.util.Arrays;

public class Question002 {

	static int count = 0;
	// 不重复的全排列
	private void getSource(int[] a, String[] s, String[] result, int m) {
		if (m == 0) {
			System.out.println(Arrays.toString(result));
			count++;
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					continue;
				}
				result[m - 1] = s[i];
				a[i]--;
				getSource(a, s, result, --m);
				a[i]++;
				m++;
			}
		}
	}
	
	// 不重复的组合
	private void getSource1(int[] a, String[] s, int start, String result) {
		for (int j = 0; j < a[start] + 1; j++) {		// 每种元素出现的可能性
			String temp = "";
			for (int k = 0; k < j; k++) {
				temp = temp.length() == 0 ? s[start] : temp + "," + s[start];
			}
			if (start == a.length - 1) {
				System.out.println(result.length() == 0 ? temp : temp.length() == 0 ? result : result + "," + temp);
			} else {
				getSource1(a, s, start + 1, result.length() == 0 ? temp : temp.length() == 0 ? result : result + "," + temp);
			}
		}
	}
	
	public static void main(String[] args) {
		Question002 q = new Question002();
		int[] a = {2, 2, 1};
		String[] s = {"a", "b", "c"};
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		String[] result = new String[sum];
		q.getSource(a, s, result, sum);
		System.out.println(count);
		
		q.getSource1(a, s, 0, "");
	}
}
