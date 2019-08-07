package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: NumberComplement_476
 * @description: 数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 注意:
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 * @author: L.zhen
 * @date: 2018/8/31 16:50
 */
public class NumberComplement_476 {
	public int findComplement(int num) {
		return 0;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test002(5), 2);
	}
	
	private static int test001(int num) {
		return ~num & (Integer.highestOneBit(num) - 1);
	}
	
	private static int test002(int num) {
		int a = num;
		a |= a >> 1;
		a |= a >> 2;
		a |= a >> 4;
		a |= a >> 8;
		a |= a >> 16;
		return ~num & a >>> 1;
	}
}
