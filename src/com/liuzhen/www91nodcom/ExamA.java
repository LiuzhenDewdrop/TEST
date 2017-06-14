package com.liuzhen.www91nodcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @class: ExamA
 * @description: 数字1的数量
 * 给定一个十进制正整数N，写下从1开始，到N的所有正数，计算出其中出现所有1的个数。
 * 例如：n = 12，包含了5个1。1,10,12共包含3个1，11包含2个1，总共5个1。
 * 基准时间限制：1 秒 空间限制：131072 KB 分值: 5
 * @author Liuzhen
 */
public class ExamA {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
//		int in = sc.nextInt();
//		System.out.println("INPUT:");
		int in = Integer.parseInt(reader.readLine());
//		countOneOld(in);
//		writer.write(countOne(in) + "\r\n");
//		writer.flush();
//		out.println(countOne(in));
//		out.flush();
		System.out.println(countOne(in));
	}
	
	private static int countOne(int in) {
//		long start = new Date().getTime();
		int out = 0;
		int digit = 10;
		do {
			out += countPiece(in % digit, in / digit, digit / 10);
			digit *= 10;
		} while (in >= digit);
//		System.out.println("结果:" + out);
//		System.out.println("时间:" + (new Date().getTime() - start));
		return out;
	}
	
	private static int countPiece(int low, int high, int digit) {
		int result = high;
		result *= digit;
		if (low >= digit * 2) {
			result += digit;
		} else if (low >= digit) {
			result += low % digit + 1;
		}
		if (high < 10) {
			switch (high) {
				case 1:
					result += low + 1;
					break;
				case 0:
					break;
				default:
					result += digit * 10;
					break;
			}
		}
		return result;
	}
	
//	private static void countOneOld(int in) {
//		long start = new Date().getTime();
//		int out = 0;
//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < in; i++) {
//			String num = i + 1 + "";
//			int count = num.length() - num.replaceAll("1", "").length();
//			if (count > 0) {
//				list.add(i + 1);
//				out += count;
//			}
//		}
//		System.out.println("含有1的个数:" + out);
//		System.out.println(list);
//		System.out.println("时间:" + (new Date().getTime() - start));
//	}
}
