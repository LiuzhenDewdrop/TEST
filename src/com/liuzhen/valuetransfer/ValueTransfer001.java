package com.liuzhen.valuetransfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @class: ValueTransfer001
 * @description: 
 * @author: L.zhen
 * @date: 2017/11/21 10:59
 */
public class ValueTransfer001 {
	
	public static void main(String[] args) {
		BigDecimalTest();	// 值不变
		MapTest();
		new ValueTransfer001().testBigDecimal001();
		new ValueTransfer001().testCollection001();
	}
	
	private static void BigDecimalTest() {
		BigDecimal a = new BigDecimal("100");
		System.out.println(a);
		changeValue(a);
		System.out.println(a);
	}
	
	private static void MapTest() {
		Map<String, Object> a = new HashMap<>();
		a.put("a", new BigDecimal("100"));
		System.out.println(a.get("a"));
		changeValue(a);
		System.out.println(a.get("a"));
	}
	
	private static void changeValue(BigDecimal a) {
		a = a.multiply(new BigDecimal("100"));
	}
	
	private static void changeValue(Map<String, Object> a) {
		a.put("a", ((BigDecimal) a.get("a")).multiply(new BigDecimal("100")));
	}
	
	private void testBigDecimal001() {
		BigTest a = new BigTest();
		a.value = BigDecimal.ZERO;
		BigDecimal b = a.value;
		b = b.add(BigDecimal.TEN);
		System.out.println("b:" + b);
		System.out.println("a.value:" + a.value);
	}
	
	private void testCollection001() {
		BigTest a = new BigTest();
		a.value = BigDecimal.ZERO;
		Map<Integer, BigTest> map = new HashMap<>(1);
		map.put(1, a);
		List<BigTest> list = new ArrayList<>(1);
		list.add(a);
		a.value = BigDecimal.TEN;
		System.out.println(map.get(1).value);
		System.out.println(list.get(0).value);
		testCollection002(list);
		System.out.println(list.get(0).value);
		testCollection003(list.get(0));
		System.out.println(list.get(0).value);
	}
	
	private void testCollection002(List<BigTest> list) {
		list.get(0).value = BigDecimal.valueOf(5);
	}
	
	private void testCollection003(BigTest a) {
		a.value = BigDecimal.ONE;
	}
	
	class BigTest {
		BigDecimal value;
	}
}
