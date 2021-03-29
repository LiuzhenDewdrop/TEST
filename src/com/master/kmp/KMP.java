package com.master.kmp;

/**
 * @class: KMP
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/26 21:22
 */
public class KMP {
	
	public static void main(String[] args) {
		char[] chars = "ababaaababaa".toCharArray();
		char[] cArr = new char[chars.length + 1];
		System.arraycopy(chars, 0, cArr, 1, chars.length);
		print(buildNext(cArr));
	}
	
	private static int[] buildNext(char[] cArr) {
		int[] next = new int[cArr.length];
		int i = 1;
		int j = 0;
		
		while (i < cArr.length-1) {
			if (j == 0 || cArr[i] == cArr[j]) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	
	private static void print(int[] next) {
		System.out.print("[ " + next[1]);
		for (int i = 2; i < next.length; i++) {
			System.out.print(", " + next[i]);
		}
		System.out.println(" ]");
	}
	
	
}


