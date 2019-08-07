package com.liuzhen.app.util;

import java.util.Arrays;

import com.liuzhen.app.exception.StringCantCutException;

/*
 * @class: StringUtil
 * @description: String工具类
 * @author: L.zhen
 * @date: 2018/5/29 10:33
 */
public class StringUtil {
	
	/*
	 * @title:  join
	 * @description: 把数组组合成字符串
	 * @param pre		前缀
	 * @param pend		后缀
	 * @param arr		数组
	 * @param joiner	元素之间的分隔符
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/5/29 10:42
	 */
	public static String join(String pre, String pend, String[] arr, String joiner) {
		StringBuilder result = new StringBuilder();
		if (arr != null && arr.length > 0) {
			if (joiner == null) {
				joiner = "";
			}
			for (String s : arr) {
//				if (result.length() > 0) {
//					result.append(joiner);
//				}
//				result.append(s);
				append(result, joiner, s);
			}
		}
		if (pre == null) {
			pre = "";
		}
		if (pend == null) {
			pend = "";
		}
		result.insert(0, pre);
		result.append(pend);
		return result.toString();
	}
	
	/*
	 * @title:  join
	 * @description: 不需要前后缀的数组拼接
	 * @param arr		数组
	 * @param joiner	元素之间的分隔符
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/5/29 10:43
	 */
	public static String join(String[] arr, String joiner) {
		return join(null, null, arr, joiner);
	}
	
	public static String[] cutByLength(String[] arr, int length) {
		if (length <= 0) {
			throw new StringCantCutException();
		}
		if (arr != null && arr.length > 0) {
			StringBuilder index = new StringBuilder();
			final String comma = ",";
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != null && arr[i].length() > length) {
					int amount = arr[i].length() / length;
					if (arr[i].length() % length == 0) {
						amount--;
					}
					for (int j = 0; j < amount; j++) {
						append(index, comma, (i + ""));
					}
				}
			}
			if (index.length() > 0) {
				String[] indexArr = index.toString().split(comma);
				String[] resultArr = new String[arr.length + indexArr.length];
				int startIndex = 0;
				for (int i = 0; i < indexArr.length; i++) {
					int a = Integer.parseInt(indexArr[i]);
					if (startIndex != a) {
						System.arraycopy(arr, startIndex, resultArr, startIndex + i, a - startIndex);
						startIndex = a;
					}
					resultArr[startIndex + i] = arr[a].substring(0, length);
					arr[a] = arr[a].substring(length);
				}
				System.arraycopy(arr, startIndex, resultArr, startIndex + indexArr.length, arr.length - startIndex);
				return resultArr;
			}
		}
		return arr;
	}
	
	private static Appendable append(Appendable s, String joiner, String element) {
		if (s instanceof StringBuilder) {
			if (((StringBuilder) s).length() > 0) {
				return ((StringBuilder) s).append(joiner).append(element);
			} else {
				return ((StringBuilder) s).append(element);
			}
		} else if (s instanceof StringBuffer) {
			if (((StringBuffer) s).length() > 0) {
				return ((StringBuffer) s).append(joiner).append(element);
			} else {
				return ((StringBuffer) s).append(element);
			}
		}
		return s;
	}
	
	public static String[][] create(String str, int length1) {
		String[] arr = str.split(",");
		System.out.println(arr.length);
		int length0 = arr.length / length1;
		if (arr.length % length1 != 0) {
			length0++;
		}
		String[][] arrs = new String[length0][length1];
		for (int i = 0; i < length0; i++) {
			for (int j = 0; j < length1; j++) {
				if (i * length1 + j == arr.length) {
					break;
				}
				arrs[i][j] = arr[i * length1 + j];
			}
		}
		return arrs;
	}
	
	public static void print(String[][] arrs) {
		for (String[] strings : arrs) {
			String temp = "";
			for (String string : strings) {
				if (string == null) {
					break;
				}
				temp += string + ",";
			}
			if (temp.length() > 0) {
				temp = temp.substring(0, temp.length() - 1);
			}
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args) {
		String str = "123";
		String str1 = str.substring(1, 2);
		str = str.substring(0, 1) + str.substring(2);
		System.out.println("str:" + str + ",str1:" + str1);
		String[] arr = {"abc", "ab", "a", "", "abcde", "abcdef", "ab"};
		String[] arr1 = cutByLength(arr, 2);
		System.out.println(Arrays.toString(arr1));
		
	}
}
