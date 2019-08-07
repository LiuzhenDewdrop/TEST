package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @class: TwoSum_1
 * @description: 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author: L.zhen
 * @date: 2018/8/24 14:38
 */
public class TwoSum_1 {
	public int[] twoSum(int[] nums, int target) {
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] arr = {15, 22, 7, 4, 9, 13, 45, 46, 87, 32, 18, 44, 99, 2, 10};
		int[] result = test001(arr, 13);
		System.out.println(Arrays.toString(result));
		result = test002(arr, 13);
		System.out.println(Arrays.toString(result));
		result = test003(new int[]{50000000,3,2,4,50000000}, 100000000);
		System.out.println(Arrays.toString(result));
		result = test004(new int[]{3, 2, 4}, 6);
		System.out.println(Arrays.toString(result));
		result = test005(arr, 13);
		System.out.println(Arrays.toString(result));
	}
	
	
	/*
	 * @title:  test001
	 * @description:	map(5ms)
	 * @param nums
	 * @param target
	 * @return
	 * @author: L.zhen
	 * @date:   2018/8/24 15:54
	 */
	private static int[] test001(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i< nums.length; i++) {
			int temp = nums[i];
			if (map.containsKey(target - temp)) {
				return new int[]{map.get(target - temp), i};
			}
			map.put(temp, i);
		}
		return null;
	}
	
	/*
	 * @title:  test002
	 * @description: 快排(23ms)
	 * @param nums
	 * @param target
	 * @return
	 * @author: L.zhen
	 * @date:   2018/8/24 15:54
	 */
	private static int[] test002(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] indexArr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			indexArr[i] = i;
		}
		int[] arr = nums.clone();
		quickSort(arr, indexArr, 0, nums.length - 1);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int sum = arr[low] + arr[high];
			if (sum == target) {
				return new int[]{indexArr[low], indexArr[high]};
			} else if (sum > target) {
				high--;
			} else {
				low++;
			}
		}
		return null;
	}
	
	private static void quickSort(int[] arr, int[] index, int low, int high) {
		if (low < high) {
			int start = low;
			int end = high;
			int temp = arr[low];
			int tempIndex = index[low];
			while (low < high) {
				while (low < high && temp <= arr[high]) {
					high--;
				}
				arr[low] = arr[high];
				index[low] = index[high];
				while (low < high && temp >= arr[low]) {
					low++;
				}
				arr[high] = arr[low];
				index[high] = index[low];
			}
			arr[low] = temp;
			index[low] = tempIndex;
			quickSort(arr, index, start, low - 1);
			quickSort(arr, index, low + 1, end);
		}
	}
	
	/*
	 * @title:  test003
	 * @description: 空间(空间溢出)
	 * @param nums
	 * @param target
	 * @return
	 * @author: L.zhen
	 * @date:   2018/8/24 15:54
	 */
	private static int[] test003(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] arr = nums.clone();
		Arrays.sort(arr);
		int min = arr[0];
		int max = arr[arr.length - 1];
		int[] signArr = new int[max - min + 1];
		for (int i = 0; i < nums.length; i++) {
			int minus = target - nums[i];
			if (minus >= min && minus <= max && signArr[minus - min] > 0) {
				return new int[]{signArr[minus - min] - 1, i};
			} else {
				signArr[nums[i] - min] = i + 1;
			}
		}
		return null;
	}
	
	/*
	 * @title:  test004
	 * @description: 字符串(600ms)
	 * @param nums
	 * @param target
	 * @return
	 * @author: L.zhen
	 * @date:   2018/8/24 16:12
	 */
	private static int[] test004(int[] nums, int target) {
		StringBuilder b = new StringBuilder(",");
		for (int i = 0; i< nums.length; i++) {
			b.append(nums[i]);
			b.append(",");
		}
		String str = b.toString();
		for (int i = 0; i < nums.length; i++) {
			if (str.contains("," + (target - nums[i]) + ",")) {
				int a = str.substring(0, str.indexOf("," + (target - nums[i]) + ",")).split(",").length - 1;
				if (a != i) {
					return new int[]{i, a};
				}
			}
		}
		return null;
	}
	
	/*
	 * @title:  test005
	 * @description: 先夹并找数值，然后找位置
	 * @param nums
	 * @param target
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/8/24 16:25
	 */
	private static int[] test005(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] arr = nums.clone();
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int sum = arr[low] + arr[high];
			if (sum > target) {
				high--;
			} else if (sum < target) {
				low++;
			} else  {
				break;
			}
		}
		int[] result = new int[2];
		int two = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == arr[low] || nums[i] == arr[high]) {
				result[two++] = i;
				if (two == 2) {
					return result;
				}
			}
		}
		return null;
	}
}