package com.liuzhen.algorithm.match.match20170630;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

/**
 * @class: Exam002
 * @description: 
 * @author: Liuzhen
 */
public class Exam002 {
	public static void main(String[] args) {
		int[] arr = input(1);
		if (arr == null) {
			System.out.println("输入错误!");
		}
		int[] count = new int[10000001];
		long start = System.nanoTime();
		sort(arr, count);
		BigDecimal use = new BigDecimal(System.nanoTime() - start).divide(new BigDecimal(1000000000), 6, BigDecimal.ROUND_HALF_UP);
		printArr(count);
		writeArr(count);
		System.out.println("排序耗时" + use + "秒");
	}
	
	public static int[] input(int code) {
		File f = new File("C:\\Users\\Administrator.ZRMX-20151113AO\\Desktop\\题目文件" + code + ".txt");
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
		String[] str = s.toString().split(" *,+ *");
		if (str == null || str.length == 0) {
			return null;
		}
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		return arr;
	}
	
	private static void sort(int[] arr, int[] count) {
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] = count[arr[i]] + 1;
		}
	}
	
	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			while (a-- > 0) {
				System.out.println(i);
			}
		}
	}
	
	private static void writeArr(int[] arr) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			while (a-- > 0) {
				s = s.append(i).append(",");
			}
		}
		char[] c = s.substring(0, s.length() - 1).toCharArray();
		File f = new File("C:\\Users\\Administrator.ZRMX-20151113AO\\Desktop\\题目文件3.txt");
		if (f.exists()) {
			f.delete();
		}
		OutputStreamWriter osw = null;
		OutputStream os = null;
		try {
			os = new FileOutputStream(f);
			osw = new OutputStreamWriter(os);
			for (int i = 0; i< c.length; i++) {
				osw.write(c[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
