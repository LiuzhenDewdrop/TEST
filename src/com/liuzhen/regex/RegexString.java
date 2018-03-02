package com.liuzhen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexString {

	public static void main(String[] args) {
//		test001();
		test002();
	}
	
	private static void test001() {
		//		String str = "c.cus_dept_name like \"%%\"";
//		String a = "\"";
//		String s = "&quot;";
//		String string = str.replaceAll(a, s);
//		System.out.println(string);
//		System.out.println("asbasdfg".replaceAll("c.cus_dept_name like \"%", s));
		String str1 = "Look buddy, U got work hard and put yourself in your java, Once you learned the heart of the java, I can guarantee that you win.";
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		Matcher matcher=pattern.matcher(str1);
		matcher.matches();
		for(int i=0; i<= matcher.groupCount(); i++) {
			System.out.println(matcher.group(i));
		}
	}
	
	private static void test002() {
		System.out.println(" 34 35 .89% ".replaceAll("[ %]", ""));
	}
}
