package com.liuzhen.regex;

import java.math.BigDecimal;

/**
 * @class: RegexTest002
 * @description: 
 * @author: L.zhen
 * @date: 2019/8/29 15:34
 */
public class RegexTest002 {
	
	public static void main(String[] args) {
		
		test001("23456789.9876543");
		test001("234567899876543");
	}
	
	
	private static void test001(String str) {
		String regex1 = "(?<=\\.(\\d{3})+)(?=\\d)";
		System.out.println("1:\t" + str.replaceAll(regex1, ","));
		String regex2 = "(?<=\\d)(?=(\\d{3})+(\\.|$))";
		System.out.println("2:\t" + str.replaceAll(regex2, ","));
		System.out.println("3:\t" + str.replaceAll(regex1, ",").replaceAll(regex2, ","));
		
		String regex3 = "(?=\\d)((?<=\\.(\\d{3})+)|(?=(\\d{3})+(\\.|$)))(?<=\\d)";
		System.out.println("4:\t" + str.replaceAll(regex3, ","));
		
		String regex4 = "(?<=\\d)((?=(\\d{3})+\\.)|(?<=(\\.|^)(\\d{3})+))(?=\\d)";
		System.out.println("5:\t" + str.replaceAll(regex4, ","));
	}
	
}
