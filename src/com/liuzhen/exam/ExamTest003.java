package com.liuzhen.exam;

import java.util.Date;

/**
 * @class: ExamTest003
 * @description: 自幂数、阿姆斯特朗数ArmstrongNumber
 * @author: L.zhen
 * @date: 2017/9/26 17:59
 */
public class ExamTest003 {

	private static boolean judge(long a) {
		long num = a;
		int length = getLength(a);
		long judge = 0L;
		while (a > 0) {
			long tempOne = a % 10;
			a /= 10;
			long tempSum = 1L;
			for (int i = 0; i < length; i++) {
				tempSum *= tempOne;
			}
			judge += tempSum;
		}
		return judge == num;
	}
	
	private static int getLength(long a) {
		int length = 0;
		while (a > 0) {
			a /= 10;
			length++;
		}
		return length;
	}
	
	public static void main(String[] args) {
		long start = new Date().getTime();
		long max = 40_0000_0000L;
		for (long i = 1L; i < max; i++) {
			if (judge(i)) {
				System.out.println(i);
			}
		}
		System.out.println("总时间：" + (new Date().getTime() - start));
		// 420317
	}
}
