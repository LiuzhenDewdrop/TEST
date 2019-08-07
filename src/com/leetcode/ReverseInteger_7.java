package com.leetcode;
/*
 * @class: ReverseInteger_7
 * @description: 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * @author: L.zhen
 * @date: 2018/8/24 18:04
 */
public class ReverseInteger_7 {
	public int reverse(int x) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(test001(1000000003));
	}
	
	private static int test001(int x) {
		long l = x % 10;
		while ((x = x / 10) != 0) {
			l = l * 10 + x % 10;
		}
		if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) l;
	}
}
