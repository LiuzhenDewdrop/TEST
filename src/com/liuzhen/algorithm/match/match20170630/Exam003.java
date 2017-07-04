package com.liuzhen.algorithm.match.match20170630;

import java.util.Scanner;

/**
 * @class: Exam003
 * @description: 
 * @author: Liuzhen
 */
public class Exam003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字");
		int b = sc.nextInt();
		int[] arr = Exam002.input(3);
		int index = findIndex(arr, 0, arr.length - 1, b);
		System.out.println("这个数字是:" + b);
		System.out.println("index:" + index);
	}
	
	private static int findIndex(int[] arr, int start, int end, int value) {
		int mid = (end - start) / 2 + start;
		if (arr[mid] < value) {
			return findIndex(arr, mid == start ? ++mid : mid, end, value);
		} else if (arr[mid] > value) {
			return findIndex(arr, start, mid, value);
		} else {
			return mid;
		}
	}
	
}
