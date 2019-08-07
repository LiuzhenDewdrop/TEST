package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: ClimbingStairs70
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author: L.zhen
 * @date: 2018/9/3 17:10
 */
public class ClimbingStairs70 {
	public int climbStairs(int n) {
		return 0;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test001(1), 1);
		LeetCodeUtil.test(test001(2), 2);
		LeetCodeUtil.test(test001(3), 3);
		LeetCodeUtil.test(test001(3), 3);
	}
	
	private static int test001(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
}
