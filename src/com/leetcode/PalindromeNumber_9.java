package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: PalindromeNumber_9
 * @description: 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * @author: L.zhen
 * @date: 2018/9/3 14:26
 */
public class PalindromeNumber_9 {
	public boolean isPalindrome(int x) {
		return false;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test003(0), true);
		LeetCodeUtil.test(test003(5), true);
		LeetCodeUtil.test(test003(10), false);
		LeetCodeUtil.test(test003(1000000001), true);
		LeetCodeUtil.test(test003(21), false);
		LeetCodeUtil.test(test003(100), false);
		LeetCodeUtil.test(test003(-121), false);
		LeetCodeUtil.test(test003(121), true);
		LeetCodeUtil.test(test003(1001), true);
		LeetCodeUtil.test(test003(123454321), true);
		LeetCodeUtil.test(test003(1234554321), true);
		LeetCodeUtil.test(test003(1000000021), false);
	}
	
	/*
	 * @title:  test001
	 * @description: 前后两个方向按位取数判断(192ms)
	 * @param x
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 15:05
	 */
	private static boolean test001(int x) {
		if (x < 0) {
			return false;
		} else if (x < 10) {
			return true;
		}
		int y = 1;
		while (x / y >= 10) {
			y *= 10;
		}
		int z = 0;
		while (y > 1) {
			if ((z = x / y) != x % 10) {
				return false;
			}
			x -= z * y;
			x /= 10;
			y /= 100;
		}
		return x < 10;
	}
	
	/*
	 * @title:  test002
	 * @description: 创造出一个反转的数字(184ms)
	 * @param x
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 15:16
	 */
	private static boolean test002(int x) {
		if (x < 0) {
			return false;
		} else if (x < 10) {
			return true;
		}
		int y = x;
		int z = 0;
		while (y > 0) {
			z *= 10;
			z += y % 10;
			y /= 10;
		}
		return x == z;
	}
	
	/*
	 * @title:  test003
	 * @description: 根据对称的余数特征，寻找适合的数字判断
	 * @param x
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 15:54
	 */
	private static boolean test003(int x) {
		if (x < 0) {
			return false;
		}
		int d = 1;
		int y = x;
		while ((y /= 10) > 0) {
			d++;
		}
		switch (d) {
			case 1:
				return true;
			case 2:
				return x % 11 == 0;
			case 3:
				return x != 100 && x % 101 % 10 == 0;
			case 4:
				return x % 1001 % 110 == 0;
			case 5:
				return x % 10001 % 1010 % 100 == 0;
			case 6:
				return x % 100001 % 10010 % 1100 == 0;
			case 7:
				return x % 1000001 % 100010 % 10100 % 1000 == 0;
			case 8:
				return x % 10000001 % 1000010 % 100100 % 11000 == 0;
			case 9:
				return x % 100000001 % 10000010 % 1000100 % 101000 % 10000 == 0;
			case 10:
				return x % 1000000001 % 100000010 % 10000100 % 1001000 % 110000 == 0;
			default:
				return false;
		}
	}
}
