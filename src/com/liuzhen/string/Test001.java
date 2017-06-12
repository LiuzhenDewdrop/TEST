package com.liuzhen.string;

import java.io.UnsupportedEncodingException;

public class Test001 {

	public static void main(String[] args) {
		String[] arr = ",12".split(",");
		System.out.println(arr.length);
		System.out.println(arr[0] == null);
		System.out.println(arr[0].equals(""));
		String str = "123第三附属";
		String str1;
		try {
//			str1 = new String(str.getBytes("GBK"), "GBK");
			str1 = new String(str.getBytes("UTF-8"), "GBK");
			System.out.println(str1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(Long.parseLong("123456789"));
		String testStr = ",1235,";
		testStr = testStr.substring(1, testStr.length() - 1);
		System.out.println(testStr + ":" + testStr.length());
		System.exit(0);
	}
}
