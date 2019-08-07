package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: AddStrings_415
 * @description: 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * @author: L.zhen
 * @date: 2018/8/30 14:48
 */
public class AddStrings_415 {
	public String addStrings(String num1, String num2) {
		return null;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test003("89", "11"), "100");
		LeetCodeUtil.test(test003("9", "99"), "108");
		LeetCodeUtil.test(test003("123", "456"), "579");
		LeetCodeUtil.test(test003("11111", "1"), "11112");
	}
	
	private static String test001(String num1, String num2) {
		char[] arr1;
		char[] arr2;
		if (num1.length() > num2.length()) {
			arr1 = num1.toCharArray();
			arr2 = num2.toCharArray();
		} else {
			arr2 = num1.toCharArray();
			arr1 = num2.toCharArray();
		}
		// 48-57
		int carry = 0;
		int j = arr2.length - 1;
		for (int i = arr1.length - 1; i >= 0; i--) {
			char c = (char) (j < 0 ? arr1[i] + carry : arr1[i] - '0' + arr2[j] + carry);
			if (c > '9') {
				carry = 1;
				c -= 10;
			} else {
				carry = 0;
			}
			arr1[i] = c;
			if (j-- < 0 && carry == 0) {
				break;
			}
		}
		if (carry == 1) {
			return "1" + String.valueOf(arr1);
		}
		return String.valueOf(arr1);
	}
	
	private static String test002(String num1, String num2) {
		if (num1.length() < num2.length()) {
			return test002(num2, num1);
		}
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		int carry = 0;
		int dif = arr1.length - arr2.length;
		for (int i = arr2.length - 1; i >= 0; i--) {
			arr1[dif + i] += arr2[i] + carry - '0';
			if (arr1[dif + i] > '9') {
				arr1[dif + i] -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
		}
		if (dif != 0) {
			for (int i = dif - 1; i >= 0; i--) {
				arr1[i] += carry;
				if (arr1[i] > '9') {
					arr1[i] -= 10;
					carry = 1;
				} else {
					carry = 0;
					break;
				}
			}
		}
		return carry == 1 ? carry + String.valueOf(arr1) : String.valueOf(arr1);
	}
	
	private static String test003(String num1, String num2) {
		if (num1.length() < num2.length()) {
			return test003(num2, num1);
		}
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();
		for (int i = arr2.length - 1; i >= 0; i--) {
			arr1[arr1.length - arr2.length + i] += arr2[i] - '0';
		}
		int carry = 0;
		for (int i = arr1.length - 1; i >= 0; i--) {
			arr1[i] += carry;
			if (arr1[i] > '9') {
				arr1[i] -= 10;
				carry = 1;
			} else {
				carry = 0;
				if (i + arr2.length <= arr1.length) {
					break;
				}
			}
		}
		return carry == 1 ? carry + String.valueOf(arr1) : String.valueOf(arr1);
	}
}
