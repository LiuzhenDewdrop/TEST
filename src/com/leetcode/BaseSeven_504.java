package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: BaseSeven_504
 * @description: 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 示例 1:
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * @author: L.zhen
 * @date: 2018/9/3 18:00
 */
public class BaseSeven_504 {
	public String convertToBase7(int num) {
		return "";
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test002(100), "202");
		LeetCodeUtil.test(test002(-7), "-10");
	}
	
	/*
	 * @title:  test001
	 * @description: 顺序非递归(18ms)
	 * @param num
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 18:25
	 */
	private static String test001(int num) {
		int[] arr = new int[8];
		int i = 0;
		arr[i++] = 7;
		while (i < 8) {
			arr[i++] = arr[i-2] * 7;
		}
		String ans = "";
		String oper = "";
		if (num < 0) {
			num = -num;
			oper = "-";
		}
		while (i > 0) {
			if (arr[--i] <= num) {
				ans += num / arr[i];
				num %= arr[i];
			} else if (ans.length() > 0) {
				ans += "0";
			}
		}
		return oper + ans + num;
	}
	
	/*
	 * @title:  test002
	 * @description: 递归（18ms）
	 * @param num
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 18:29
	 */
	private static String test002(int num) {
		return num < 0 ? "-" + test002(-num) : num < 7 ? num + "" : test002(num / 7) + num % 7;
	}
}
