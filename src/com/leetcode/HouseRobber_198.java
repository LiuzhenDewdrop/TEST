package com.leetcode;
/**
 * @class: HouseRobber_198
 * @description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author: L.zhen
 * @date: 2019/12/25 17:55
 */
public class HouseRobber_198 {
	
	public int rob(int[] nums) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(test002(new int[]{1,2,3,1}));
		System.out.println(test002(new int[]{2,7,9,3,1}));
	}
	
	private static int test001(int[] nums) {
		return getPartial(0, -2, nums);
	}
	
	private static int getPartial(int sum, int i, int[] arr) {
		if (i + 2 > arr.length - 1) {
			return sum;
		}
		int a = arr[i + 2] + getPartial(sum, i + 2, arr);
		if (i + 3 > arr.length - 1) {
			return sum + a;
		}
		int b = arr[i + 3] + getPartial(sum, i + 3, arr);
		return a > b ? sum + a : sum + b;
	}
	
	private static int test002(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] arr = new int[nums.length];
		arr[0] = nums[0];
		arr[1] = nums[1];
		if (nums.length > 2) {
			arr[2] = nums[0] + nums[2];
			for (int i = 3; i < nums.length; i++) {
				int a = getMax(arr[i - 3], arr[i - 2]);
				arr[i] = a + nums[i];
			}
		}
		return getMax(arr[arr.length - 1], arr[arr.length - 2]);
	}
	
	private static int getMax(int a, int b) {
		return a > b ? a : b;
	}
}
