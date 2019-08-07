package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: StringtoInteger_8
 * @description: 字符串转整数 (atoi)
 * 实现 atoi，将字符串转为整数。
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 * @author: L.zhen
 * @date: 2018/9/3 15:51
 */
public class StringtoInteger_8 {
	public int myAtoi(String str) {
		return 0;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test( test002("3.14159"), 3);
		LeetCodeUtil.test( test002("42"), 42);
		LeetCodeUtil.test(test002("   -42"), -42);
		LeetCodeUtil.test( test002("4193 with words"), 4193);
		LeetCodeUtil.test( test002("words and 987"), 0);
		LeetCodeUtil.test(test002("-91283472332"), -2147483648);
	}
	
	/*
	 * @title:  test001
	 * @description: (47ms)
	 * @param str
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 16:27
	 */
	private static int test001(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		boolean positive = true;
		boolean start = false;
		long num = 0l;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				if (str.charAt(i) == '+') {
					if (start) {
						break;
					}
					start = true;
				} else if (str.charAt(i) == '-') {
					if (start) {
						break;
					}
					start = true;
					positive = false;
				} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					start = true;
					num *= 10;
					num += str.charAt(i) - '0';
					if (positive && num > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					} else if (!positive && (-1 * num) < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				} else if (start) {
					break;
				} else  {
					return 0;
				}
			} else if (start) {
				break;
			}
		}
		return (int) (positive ? num : - num);
	}
	
	/*
	 * @title:  test002
	 * @description: （48ms）
	 * @param str
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 16:41
	 */
	private static int test002(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int start = 0;
		while (start < str.length() && str.charAt(start) == ' ') {
			start++;
		}
		boolean positive = true;
		long num = 0l;
		if (start < str.length() && str.charAt(start) == '+') {
			start++;
		} else if (start < str.length() && str.charAt(start) == '-') {
			positive = false;
			start++;
		}
		while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9' ) {
			num *= 10;
			num += str.charAt(start) - '0';
			if (num > Integer.MAX_VALUE) {
				if (positive) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			start++;
		}
		return (int) (positive ? num : - num);
	}
}
