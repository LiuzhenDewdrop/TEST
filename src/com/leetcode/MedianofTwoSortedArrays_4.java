package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: MedianofTwoSortedArrays_4
 * @description: 两个排序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 * @author: L.zhen
 * @date: 2018/9/3 11:41
 */
public class MedianofTwoSortedArrays_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return 0.0;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test001(new int[]{1, 3, 4}, new int[]{2, 5}), 3.0);
		LeetCodeUtil.test(test001(new int[]{1, 3, 4}, null), 3.0);
		LeetCodeUtil.test(test001(new int[]{1, 2}, new int[]{3, 4}), 2.5);
	}
	
	public static double test001(int[] nums1, int[] nums2) {
		int l1 = nums1 != null ? nums1.length : 0;
		int l2 = nums2 != null ? nums2.length : 0;
		int mid = (l1 + l2) >> 1;
		int[] arr = new int[mid + 1];
		int a1 = 0, a2 = 0;
		for (int i = 0; i <= mid; i++) {
			if (a1 == l1) {
				while (a2 < l2 && i<= mid) {
					arr[i++] = nums2[a2++];
				}
			} else if (a2 == l2) {
				while (a1 < l1 && i<= mid) {
					arr[i++] = nums1[a1++];
				}
			} else if (nums1[a1] > nums2[a2]) {
				arr[i] = nums2[a2++];
			} else {
				arr[i] = nums1[a1++];
			}
		}
		double ans = arr[mid];
		if ((l1 + l2) % 2 == 0) {
			ans = (arr[mid - 1] + ans) / 2;
		}
		return ans;
	}
	
}
