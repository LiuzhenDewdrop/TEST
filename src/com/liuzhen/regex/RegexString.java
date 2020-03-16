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
	
	public static void test003() {
		String str = "账户名：266***@**@qq.com ( 手机：155******04 、会员名：淘宝账户名为风**忆 )";
		final String mobileStr = "手机：";
		int mobileIndex = str.indexOf(mobileStr);
		int start = mobileIndex + mobileStr.length();
		String mobile = str.substring(start, start + 11);
		System.out.println(mobile);
		
		Pattern pattern = Pattern.compile("^.*(\\d{3}\\*{6}\\d{2}).*$");
		Matcher matcher = pattern.matcher(str);
		matcher.matches();
//		for(int i=0; i<= matcher.groupCount(); i++) {
//			System.out.println(matcher.group(i));
//		}
		System.out.println(matcher.group(1));
	}
}
