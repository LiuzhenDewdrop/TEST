package com.liuzhen.number;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	private final static long multiplier = 0x5DEECE66DL;
	private final static long addend = 0xBL;
	private final static long mask = (1L << 48) - 1;
	
	public static void main(String[] args) {
//		test001();
//		test002();
		test004();
		
		System.exit(0);
	}
	
	private static void test001() {
		double d = 1.234567890123456789;
		System.out.println(d);
		Double dd = Double.valueOf(d);
		System.out.println(dd);
		BigDecimal bd = new BigDecimal(d);
		System.out.println(bd);
		double dou = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(dou);
		bd.divide((new BigDecimal(20)));
		System.out.println("long的max_value:" + Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(new BigDecimal(Double.MAX_VALUE).toString());
		// System.nanoTime()
		System.out.println(System.nanoTime()/1000000000.0/60.0/60.0);
		System.out.println(Long.toBinaryString(multiplier));
		System.out.println(addend);
		System.out.println(Long.toBinaryString(mask));
		System.out.println("toString():" + new BigDecimal(100).toString());
		System.out.println(new BigDecimal(100) + "");
		System.out.println(new BigDecimal(100).divide(new BigDecimal(3), 2, 4).toString());
		double a = 1;
		for (int i = 1; i < 101; i++) {
			a *= i;
		}
		System.out.println(a);
		
		System.out.println(Math.ceil(3/2));
	}
	
	private static void test002() {
		long a = Long.MIN_VALUE;
		System.out.println(a);
		long b = -1;
		long c = a * b;
		System.out.println(c);
		System.out.println(c / a == b);
	}
	
	private static void test003() {
		Map<String, Object> map = new HashMap<>();
		Integer a = 1;
		map.put("a", a);
		Integer b = (Integer) map.get("a");
		System.out.println(b != null && b == 1);
	}
	
	private static void test004() {
		Map<String, Object> map = new HashMap<>();
		map.put("num", new BigDecimal(500.00));
		BigDecimal tempNum = (BigDecimal) map.get("num");
		tempNum = tempNum.add(new BigDecimal(50));
		System.out.println(map.get("num"));
	}
}
