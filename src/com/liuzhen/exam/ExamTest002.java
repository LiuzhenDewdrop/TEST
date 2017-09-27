package com.liuzhen.exam;
/**
 * @class: ExamTest002
 * @description: 
 * @author: Liuzhen
 * @date: 2017/9/21 10:09
 */
public class ExamTest002 {
	
	private static void create(int a) {
		int[][] arr = new int[a][a * 2 - 1];
		for (int i = 0; i < a; i++) {
			int[] t = new int[a * 2 - 1];
			t[a - i - 1] = 1;
			if (i > 0) {
				t[a + i - 1] = 1;
				for (int j = a - i ; j < a + i - 1; j++) {
					t[j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
				}
			}
			arr[i] = t;
		}
		print(a, arr);
	}
	
	private static void print(int a, int[][] arr) {
		int[] max = arr[a - 1];
		int half = arr[0].length / 2;
		for (int[] ar : arr) {
			for (int i = 0; i < ar.length; i++) {
				if (i <= half) {
					for (int j = 0; j < getLength(max[i]) - getLength(ar[i]) - 1; j++) {
						System.out.print(" ");
					}
					System.out.print(ar[i] != 0 ? ar[i] : " ");
				} else {
					System.out.print(ar[i] != 0 ? ar[i] : " ");
					for (int j = 0; j < getLength(max[i]) - getLength(ar[i]) - 1; j++) {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	
	private static int getLength(int a) {
		int b = 0;
		while (a > 0) {
			a /= 10;
			b++;
		}
		return b;
	}
	
	public static void main(String[] args) {
		create(10);
	}
}
