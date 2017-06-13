package com.liuzhen.www91nodcom;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @class: ExamL
 * @description: 区间的价值
 * 我们定义“区间的价值”为一段区间的最大值*最小值。
 * 一个区间左端点在L，右端点在R，那么该区间的长度为(R-L+1)。
 * 现在聪明的杰西想要知道，对于长度为k的区间，最大价值的区间价值是多少。
 * 当然，由于这个问题过于简单。
 * 我们肯定得加强一下。
 * 我们想要知道的是，对于长度为1~n的区间，最大价值的区间价值分别是多少。
 * 样例解释：
 * 长度为1的最优区间为2-2  答案为6*6
 * 长度为2的最优区间为4-5  答案为4*4
 * 长度为3的最优区间为2-4  答案为2*6
 * 长度为4的最优区间为2-5  答案为2*6
 * 长度为5的最优区间为1-5  答案为1*6
 * Input
 * 单组测试数据
 * 第一行一个数n(1<=n<=100000)。
 * 第二行n个正整数(1<=ai<=10^9)，下标从1开始。
 * 由于某种不可抗力，ai的值将会是1~10^9内随机的一个数。（除了样例）
 * Output
 * 输出共n行，第i行表示区间长度为i的区间中最大的区间价值。
 * Input示例
 * 5
 * 1 6 2 4 4
 * Output示例
 * 36
 * 16
 * 12
 * 12
 * 6
 * 基准时间限制：1 秒 空间限制：131072 KB 分值: 160
 * @author Liuzhen
 */
public class ExamL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("INPUT:");
//		int length = sc.nextInt();
//		int[] arr = createArr(length);
		int[] arr = {0, 2, 4, 6, 8, 10, 12, 14};
		System.out.println("数组:" + Arrays.toString(arr));
		replace(3, 0, arr, arr.length);
		System.out.println("数组:" + Arrays.toString(arr));
		
	}
	
	private static int[] createArr(int length) {
		int[] arr = new int[length];
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			arr[i] = r.nextInt(1000000000) + 1;
		}
		return arr;
	}
	
	private static void calc(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			
		}
	}
	
	private static BigDecimal calcPiece(int[] arr, int length) {
		int[] arr1 = arr.clone();
		quickSort(0, length - 1, arr1);
		BigDecimal result = BigDecimal.valueOf(arr1[0]).multiply(BigDecimal.valueOf(arr1[length]));
		for (int i = 0; i < arr.length - length; i++) {
			replace(arr[length + i], arr[i], arr1, length);
			BigDecimal temp = BigDecimal.valueOf(arr1[0]).multiply(BigDecimal.valueOf(arr1[length]));
			if (temp.compareTo(result) > 0) {
				result = temp;
			}
		}
		return result;
	}
	
	private static void quickSort(int low, int high, int[] arr) {
		if (low < high) {
			int start = low;
			int end = high;
			int mid = arr[low];
			while (low < high) {
				while (low < high && arr[high] >= mid) {
					high--;
				}
				arr[low] = arr[high];
				while (low < high && arr[low] <= mid) {
					low++;
				}
				arr[high] = arr[low];
			}
			arr[low] = mid;
			quickSort(start, low - 1, arr);
			quickSort(low + 1, end, arr);
		}
	}
	
	private static void replace(int in, int out, int[] arr, int length) {
		System.out.println(in + "换" + out + ":");
		int temp = in;
		boolean find = false;
		boolean insert = false;
		for (int i = 0; i < length - 1; i++) {
			if (!insert && arr[i] >= in) {
				insert = true;
				if (find) {
					arr[i - 1] = in;
					return;
				}
			}
			if (arr[i] == out) {
				find = true;
				arr[i] = arr[i + 1];
			}
			if (find && insert) {
				arr[i] = temp;
				return;
			} else if (find && !insert) {
				arr[i] = arr[i + 1];
				if (arr[i] >= in) {
					arr[i] = in;
					insert = true;
					return;
				}
			} else if (!find && insert) {
				int t = temp;
				temp = arr[i];
				arr[i] = t;
			}
		}
		if (!insert || !find) {
			arr[length - 1] = in;
		}
	}
	
	
}
