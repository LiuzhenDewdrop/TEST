package com.liuzhen.algorithm.match.match20170630;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @class: Exam004
 * @description: 
 * @author: Liuzhen
 */
public class Exam004 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("璇疯緭鍏ョ涓 涓暟瀛 ");
		int a = sc.nextInt();
		System.out.println("璇疯緭鍏ョ浜屼釜鏁板瓧:");
		int b = sc.nextInt();
		if (a == b) {
			System.out.println(0);
			System.exit(0);
		}
		int[][] arr = input();
		int[] arr1 = new int[arr.length];
//	result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr1[i] = i;
		}
		getAll(arr1, 0, a, b, arr);
		System.out.println(min);
//	System.out.println(Arrays.toString(result));
		System.exit(0);
	}
	
	private static int[][] input() {
		File f = new File("C:\\Users\\Administrator.ZRMX-20151113AO\\Desktop\\题目文件2.txt");
		InputStreamReader ins = null;
		InputStream is = null;
		StringBuffer s = new StringBuffer();
		try {
			is = new FileInputStream(f);
			ins = new InputStreamReader(is);
			while (true) {
				int r = ins.read();
				if (r == -1) {
					break;
				} else {
					s.append((char) r);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String s1 = s.substring(1, s.length() - 1);
		String[] str = s1.split("\\],\\[");
		int[][] arr = new int[str.length][];
		for (int i = 0; i < str.length; i++) {
			String[] strTemp = str[i].split(" *,+ *");
			int[] temp = new int[strTemp.length];
			for (int j = 0; j < strTemp.length; j++) {
				temp[j] = Integer.parseInt(strTemp[j]);
			}
			arr[i] = temp;
		}
		return arr;
	}
	
	static int min = Integer.MAX_VALUE;
//	static int[] result;
	
	private static void getAll(int[] arr, int index, int start, int end, int[][] value) {
		if (index == arr.length) {
			if (arr[0] == start) {
//	System.out.println(Arrays.toString(arr));
				int length = 0;
				for (int i = 0; i < arr.length - 1; i++) {
					if (value[arr[i]][arr[i + 1]] == -1) {
						length = Integer.MAX_VALUE;
						break;
					}
					length += value[arr[i]][arr[i + 1]];
					if (arr[i + 1] == end) {
						break;
					}
				}
//	System.out.println(length);
				if (length < min) {
					min = length;
//	for (int i = 0; i < arr.length; i++) {
//	result[i] = arr[i];
//	}
				}
			}
		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, i, index);
				getAll(arr, index + 1, start, end, value);
				swap(arr, index, i);
			}
		}
	}
	
	private static void swap(int[] arr, int a, int b) {
		if (arr[a] == arr[b]) {
			return;
		}
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
