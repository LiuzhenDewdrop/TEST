package com.liuzhen.string;
/**
 * @class: CharSequence
 * @description: 
 * @author: L.zhen
 * @date: 2019/10/29 15:27
 */
public class CharSequence {
	
	public static void main(String[] args) {
		print("123");
		print("1a23");
		print("sdf123");
		print("df123sd");
		print("df654sd");
		print("df980sd");
	}
	
	private static void print(String str) {
		System.out.println(str + ":" + hasSeriesNum(str));
	}
	
	/**
	 * @title:  hasSeriesNum
	 * @description: 是否存在三连增/减的数字
	 * @param str
	 * @return
	 */
	private static boolean hasSeriesNum(String str) {
		for (int i = 0; i < str.length() - 2; i++) {
			byte b = (byte) str.charAt(i);
			if (isNum(b)) {
				byte b1 = (byte) str.charAt(i + 1);
				byte b2 = (byte) str.charAt(i + 2);
				if (isNum(b1) && isNum(b2) && b1 - b == b2 - b1 && abs(b1 - b) == 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean isNum(byte b) {
		return b > 47 && b < 58;
	}
	
	private static int abs(int b) {
		return b > 0 ? b : -b;
	}
}
