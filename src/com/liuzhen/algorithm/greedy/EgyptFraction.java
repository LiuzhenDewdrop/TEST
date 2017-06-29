package com.liuzhen.algorithm.greedy;

import java.util.Arrays;

/**
 * @class: EgyptFraction
 * @description: 埃及分数
 * 如把3/7和13/23分别化为三个单位分数的和
 * @author: Liuzhen
 */
public class EgyptFraction {
	
	public static void main(String[] args) {
		int a = 13;
		int b = 23;
//		int[] result = alg1(a, b);
		System.out.println(System.nanoTime());
		System.out.println(Arrays.toString(alg(a, b)));
		System.out.println(System.nanoTime());
		System.out.println(Arrays.toString(alg1(a, b)));
		System.out.println(System.nanoTime());
	}
	
	private static int[] alg(int a, int b) {
		int[] result = new int[10];
		int index = 0;
		do {
			int q = b / a;
			int r = b % a;
			if (r == 0) {
				result[index] = q;
				return result;
			} else {
				result[index++] = q + 1;
			}
			a -= r;
			b *= q + 1;
		} while (a != 1);
		result[index] = b;
		return result;
	}
	
	private static int[] alg1(int a, int b) {
		int[] result = new int[10];
		int index = 0;
		int q = b / a;
		int r = b % a;
		while (r != 0) {
			result[index++] = ++q;
			a -= r;
			b *= q;
			q = b / a;
			r = b % a;
		}
		result[index] = q;
		return result;
	}
}
