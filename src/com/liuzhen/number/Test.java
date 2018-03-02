package com.liuzhen.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	private final static long multiplier = 0x5DEECE66DL;
	private final static long addend = 0xBL;
	private final static long mask = (1L << 48) - 1;
	
	public static void main(String[] args) {
		test000();
		test001();
		test002();
		test003();
		test004();
		test005();
		System.exit(0);
	}
	
	/**
	 * @title:  test000
	 * @description: 一些常量
	 * @author: Liuzhen
	 * @date:   2017-6-28 15:13
	 */
	public static void test000() {
		System.out.println("test000 start...");
		System.out.println("int的max_value:" + Integer.MAX_VALUE);
		System.out.println("long的max_value:" + Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(new BigDecimal(Double.MAX_VALUE).toString());
		System.out.println(Long.toBinaryString(multiplier));
		System.out.println(addend);
		System.out.println(Long.toBinaryString(mask));
		
	}
	
	/**
	 * @title:  test001
	 * @description: double和BigDecimal
	 * @author: Liuzhen
	 * @date:   2017-6-28 14:53
	 */
	private static void test001() {
		System.out.println("test001 start...");
		double d = 1.234567890123456789;
		System.out.println(d);
		Double dd = Double.valueOf(d);
		System.out.println(dd);
		BigDecimal bd = new BigDecimal(d);
		System.out.println(bd);
		double dou = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(dou);
		bd.divide((new BigDecimal(20)));
		// System.nanoTime()
		System.out.println(System.nanoTime()/1000000000.0/60.0/60.0);
		System.out.println("toString():" + new BigDecimal(100).toString());
		System.out.println(new BigDecimal(100) + "");
		System.out.println(new BigDecimal(100).divide(new BigDecimal(3), 2, RoundingMode.HALF_UP).toString());
	}
	
	/**
	 * @title:  test002
	 * @description: 陷阱，a / b * b 可能不等于a
	 * @author: Liuzhen
	 * @date:   2017-6-28 15:06
	 */
	private static void test002() {
		System.out.println("test002 start...");
		long a = Long.MIN_VALUE;
		System.out.println(a);
		long b = -1;
		long c = a * b;
		System.out.println(c);
		System.out.println(c / a == b);
	}
	
	private static void test003() {
		System.out.println("test003 start...");
		Map<String, Object> map = new HashMap<>();
		map.put("num", new BigDecimal(500.00));
		BigDecimal tempNum = (BigDecimal) map.get("num");
		tempNum = tempNum.add(new BigDecimal(50));
		System.out.println(map.get("num"));
		System.out.println(0x5DEECE66DL);
	}
	
	/**
	 * @title:  test004
	 * @description: RoundingMode
	 * @author: Liuzhen
	 * @date:   2017-6-28 15:15
	 */
	public static void test004() {
		System.out.println("test004 start...");
		BigDecimal[] arr = new BigDecimal[10];
		int index = 0;
		arr[index++] = BigDecimal.valueOf(5.5);
		arr[index++] = BigDecimal.valueOf(2.5);
		arr[index++] = BigDecimal.valueOf(1.6);
		arr[index++] = BigDecimal.valueOf(1.1);
		arr[index++] = BigDecimal.valueOf(1.0);
		arr[index++] = BigDecimal.valueOf(-1.0);
		arr[index++] = BigDecimal.valueOf(-1.1);
		arr[index++] = BigDecimal.valueOf(-1.6);
		arr[index++] = BigDecimal.valueOf(-2.5);
		arr[index++] = BigDecimal.valueOf(-5.5);
		String[] arrStr = {"UP", "DOWN", "CEILING", "FLOOR", "HALF_UP", "HALF_DOWN", "HALF_EVEN", "UNNECESSARY"};
		for (int i = 0; i <8; i++) {
			System.out.println(arrStr[i]);
			for (int j = 0; j < arr.length; j++) {
				System.out.println(arr[j] + "->" +arr[j].setScale(1, i));
			}
		}
	}
	
	/**
	 * @title:  test005
	 * @description: strictfp
	 * trictfp, 即 strict float point (精确浮点)。
	 * strictfp 关键字可应用于类、接口或方法。
	 * 使用 strictfp 关键字声明一个方法时，该方法中所有的float和double表达式都严格遵守FP-strict的限制,符合IEEE-754规范。
	 * 当对一个类或接口使用 strictfp 关键字时，该类中的所有代码，包括嵌套类型中的初始设定值和代码，都将严格地进行计算。
	 * 严格约束意味着所有表达式的结果都必须是 IEEE 754 算法对操作数预期的结果，以单精度和双精度格式表示。
	 * 自己备注：然而事实上这个strictfp关键字会强制执行32bit(单精度)或64bit(双精度)标准，同样不可避免浮点数IEEE754规则所带来的“零头”问题
	 * @author: Liuzhen
	 * @date:   2017-6-29 15:40
	 */
	public static strictfp void test005() {
		System.out.println(255555555f - 255555554f);
		System.out.println(25555555f - 25555554f);
		System.out.println(1.7 - 1.6);
	}
}
