package com.liuzhen.exam;
/**
 * @class: ExamTest001
 * @description: 三角形
 * @author: Liuzhen
 * @date: 2017/9/21 10:00
 */
public class ExamTest001 {
	
	private static void print(int a) {
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		print(10);
	}
}
