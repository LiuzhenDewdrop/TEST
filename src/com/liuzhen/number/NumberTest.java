package com.liuzhen.number;

import java.math.BigDecimal;
import java.util.Arrays;

/*
 * @class: NumberTest
 * @description: 
 * @author: L.zhen
 * @date: 2018/8/24 10:42
 */
public class NumberTest {
	
	public static void main(String[] args) {
//		test001();
//		test002();
//		test003();
		System.out.println(Arrays.toString(add33(new int[]{7, 1, 1})));
		System.out.println(Arrays.toString(add33(new int[]{9, 6, 7, 1, 1})));
		test004();
	}
	
	
	
	public static void test001() {
		System.out.println(Integer.toBinaryString(-5 >> 2));
		System.out.println(Integer.toBinaryString(-5 >>> 2));
		System.out.println(Integer.reverse(-123));
		System.out.println(reverse(-123));
		System.out.println(123 % 10);
		System.out.println(-123 % 10);
		System.out.println("00" + Integer.toBinaryString(123));
		System.out.println(Integer.toBinaryString(321));
	}
	
	public static int reverse(int i) {
		i = (i & 0x55555555) << 1 | i >>> 1 & 0x55555555;
		i = (i & 0x33333333) << 2 | i >>> 2 & 0x33333333;
		i = (i & 0x0f0f0f0f) << 4 | i >>> 4 & 0x0f0f0f0f;
		i = i << 24 | i & 0xff00 << 8 | i >>> 8 & 0xff00 | i >>>24;
		return i;
	}
	
	private static void test002() {
		Object o = null;
		o = new Integer(1234);
		System.out.println((int) o == 1234);
	}
	
	private static void test003() {
		long a, b;
		b = -1;
		a = 1;
		System.out.println(b = a - b);
		System.out.println((b = a) - b);
		System.out.println("a:" + a + ",b:" + b);
		
		int c = 1;
		System.out.println("第一段:" + - (c -(c = 10)));
		System.out.println("第二段:" + (100 - c));
	}
	
	private static int[] add33(int[] inArr) {
		int[] outArr;
		if (inArr.length < 4) {
			outArr = new int[]{3, 3, 0, 0};
		} else {
			outArr = new int[inArr.length + 1];
			outArr[outArr.length - 3] = 3;
			outArr[outArr.length - 4] = 3;
		}
		for (int i = inArr.length - 1; i >= 0; i--) {
			outArr[i + outArr.length - inArr.length] += inArr[i];
			if (outArr[i + outArr.length - inArr.length] > 9) {
				outArr[i + outArr.length - inArr.length] -= 10;
				outArr[i + outArr.length - inArr.length - 1]++;
			}
		}
		if (outArr[0] == 0) {
			int[] resultArr = new int[inArr.length];
			System.arraycopy(outArr, 1, resultArr, 0, resultArr.length);
			return resultArr;
		}
		return outArr;
	}
	
	private static void test004() {
		System.out.println(new BigDecimal(113.880));
		System.out.println(new BigDecimal(113.880 + ""));
		System.out.println(new BigDecimal(113.880).compareTo(new BigDecimal("113.880")));
		
	}
}
