package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @class: Q347_TopKFrequentElements
 * @description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * @author: L.zhen
 * @date: 2019/12/26 18:13
 */
public class Q347_TopKFrequentElements {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(test001(new int[]{1,1,1,1,2,2,2,3,3}, 2));
		System.out.println(test002(new int[]{1,1,1,1,2,2,2,3,3,5,5,5,5,5,5,5,5,5,7,7,7,7,88,88,88,88,9,9,9,9,9,9,9,9,9,9,9,9}, 2));
	}
	
	// 先统计，再排序
	private static List<Integer> test001(int[] nums, int k) {
		List<Integer> aggregateList = new ArrayList<>();
		List<Integer> eleList = new ArrayList<>();
		for (int num : nums) {
			int index = eleList.indexOf(num);
			if (index < 0) {
				eleList.add(num);
				aggregateList.add(1);
			} else {
				aggregateList.set(index, aggregateList.get(index) + 1);
			}
		}
		// 排序
		quick(aggregateList, 0, aggregateList.size() - 1, eleList);
		List<Integer> resultList = new ArrayList<>(k);
		for (int i = 0; i < k; i++) {
			resultList.add(eleList.get(i));
		}
		return resultList;
	}
	
	private static void quick(List<Integer> arr, int low, int high, List<Integer> ele) {
		if (low < high) {
			int start = low;
			int end = high;
			int mid = arr.get(low);
			int eleMid = ele.get(low);
			while (low < high) {
				while (low < high && mid >= arr.get(high)) {
					high--;
				}
				arr.set(low, arr.get(high));
				ele.set(low, ele.get(high));
				while (low < high && mid <= arr.get(low)) {
					low++;
				}
				arr.set(high, arr.get(low));
				ele.set(high, ele.get(low));
			}
			arr.set(low, mid);
			ele.set(low, eleMid);
			quick(arr, start, low - 1, ele);
			quick(arr, low + 1, end, ele);
		}
	}
	
	private static List<Integer> test002(int[] nums, int k) {
		HashMap<Integer, Integer> count = new HashMap();
		for (int n: nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}
		
		// init heap 'the less frequent element first'
		PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
		
		// keep k top frequent elements in the heap
		for (int n: count.keySet()) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}
		
		// build output list
		List<Integer> top_k = new LinkedList();
		while (!heap.isEmpty())
			top_k.add(heap.poll());
		Collections.reverse(top_k);
		return top_k;
	}
}
