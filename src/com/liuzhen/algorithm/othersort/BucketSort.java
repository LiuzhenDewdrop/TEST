package com.liuzhen.algorithm.othersort;

import java.util.Arrays;

/**
 * @class: BucketSort
 * @description: 
 * @author: Liuzhen
 */
public class BucketSort {
	public static void main(String[] args) {
		int a = 100; // 个数
		int b = 10; // 长度
		int[] arr = create(a, b);
		System.out.println(Arrays.toString(arr));
		int[] result = new int[b + 1];
		bucketSort1(arr, result); // 排序
		print(result);
	}
	
	private static void bucketSort1(int[] arr, int[] result) {
		for (int i = 0; i < arr.length; i++) {
			result[arr[i]] = result[arr[i]] + 1;
		}
	}
	
	private static int[] create(int n, int max) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random()*max + 1);
		}
		return arr;
	}
	
	private static void print(int[] result) {
		for (int i = 0; i < result.length; i++) {
			int num = result[i];
			while (num-- > 0) {
				System.out.println(i);
			}
		}
	}
}
