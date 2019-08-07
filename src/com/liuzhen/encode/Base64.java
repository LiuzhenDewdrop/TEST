package com.liuzhen.encode;

import java.util.HashMap;
import java.util.Map;

public class Base64 {

	private static final char[] c = new char[64];
	private static final Map<Character, Integer> m = new HashMap<Character, Integer>();
	
	public Base64(boolean standard) {
		addEncryptDictionary(standard);
		addDecryptDictionary();
	}
	
	/**
	 * 加密字典
	 */
//	private void addEncryptDictionary() {
//		for (int i = 0; i < 26; i++) {
//			c[i] = (char)(i + 65);
//		}
//		for (int i = 26; i < 52; i++) {
//			c[i] = (char)(i + 71);
//		}
//		for (int i = 52; i < 62; i++) {
//			c[i] = (char)(i - 4);
//		}
//		c[62] = '+';
//		c[63] = '/';
//	}
	
	private void addEncryptDictionary(boolean standard) {
		if (standard) {
			for (int i = 0; i < 26; i++) {
				// 0-25位置对应A-Z（65+）
				c[i] = (char)(i + 65);
			}
			for (int i = 26; i < 52; i++) {
				// 26-51位置对应a-z（97+）
				c[i] = (char)(i + 97 - 26);
			}
			for (int i = 52; i < 62; i++) {
				// 52-61位置对应0-9（48+）
				c[i] = (char)(i + 48 - 52);
			}
			// 最后是+ /（43、47）
			c[62] = (char)(43);
			c[63] = (char)(47);
		} else {
			for (int i = 0; i < 64; i++) {
				c[i] = (char)(i + 33);
			}
		}
		
	}
	
	/**
	 * 解密字典
	 */
	private void addDecryptDictionary() {
		for (int i = 0; i < 64; i++) {
			m.put(c[i], i);
		}
	}
	
	/**
	 * 对二进制字符串补全长度
	 * @param s		待操作字符串
	 * @param num	目标长度
	 * @return		长度为num、前面补0的字符串
	 */
	private String addZero(String s, int num) {
		while (s!= null && s.length()< num) {
			s = "0"+ s;
		}
		return s;
	}
	
	/**
	 * 调整被加密对象长度
	 * @param a		待转化char数组
	 * @param num	所需倍数
	 * @return		num倍数个元素的数组
	 */
	private char[] char2Char (char[] a, int num) {
		if (a.length% num == 0) {
			return a;
		} else {
			char[] c = new char[(a.length/num + 1)* num];
			System.arraycopy(a, 0, c, 0, a.length);
			return c;
		}
	}
	
	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public String encrypt(String str) {
//		char[] carr = char2Char(str.toCharArray(), 3);
		if (str == null) {
			return null;
		}
		char[] carr = str.toCharArray();
		String strTemp = "";
		String result = "";
		for (char c: carr) {
			strTemp += addZero(Integer.toBinaryString(c), 8);
			while (strTemp.length() > 5) {
				result += Base64.c[Integer.parseInt(strTemp.substring(0, 6), 2)];
				strTemp = strTemp.substring(6);
			}
		}
		switch (strTemp.length() / 2 % 3) {
			case 0:
				break;
			case 1:
				result += Base64.c[Integer.parseInt(strTemp + "0000", 2)];
				result += "==";
				break;
			case 2:
				result += Base64.c[Integer.parseInt(strTemp + "00", 2)];
				result += "=";
				break;
			default:
				break;
		}
		return result;
	}
	
	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public String decrypt (String str) {
//		char[] carr = char2Char(str.toCharArray(), 4);
		if (str == null) {
			return null;
		}
//		int addLength = str.length();
		str = str.replaceAll("=", "");
//		addLength -= str.length();
		char[] carr = str.toCharArray();
		String strTemp = "";
		String result = "";
		for (char c: carr) {
//			if (c == 0) {
//				c = 33;
//			}
			strTemp += addZero(Integer.toBinaryString(m.get(c)), 6);
			while (strTemp.length() > 7) {
				result += (char)Integer.parseInt(strTemp.substring(0, 8), 2);
				strTemp = strTemp.substring(8);
			}
		}
		return result;
	}
}
