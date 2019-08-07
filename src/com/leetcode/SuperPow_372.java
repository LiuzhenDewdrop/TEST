package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: SuperPow_372
 * @description: 超级次方
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 示例 1:
 * a = 2
 * b = [3]
 * 结果: 8
 * 示例 2:
 * a = 2
 * b = [1,0]
 * 结果: 1024
 * @author: L.zhen
 * @date: 2018/8/30 17:06
 */
public class SuperPow_372 {
	public int superPow(int a, int[] b) {
		return 0;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test001(2, new int[]{3}), 8);
		LeetCodeUtil.test(test001(2, new int[]{1, 0}), 1024);
		LeetCodeUtil.test(test001(2147483647, new int[]{2, 0, 0}), 1198);
	}
	
	private static int test001(int a, int[] b) {
		if (b.length == 0) {
			return 1;
		}
		int res = 1;
		for (int i = b.length - 1; i >= 0; i--) {
			res = powMod(a, b[i]) * res % 1337;
			a = powMod(a, 10);
		}
		return res;
	}
	
	private static int powMod(int a, int m) {
		a %= 1337;
		int result = 1;
		for (int i = 0; i < m; i++) {
			result = result * a % 1337;
		}
		return result;
	}
}
