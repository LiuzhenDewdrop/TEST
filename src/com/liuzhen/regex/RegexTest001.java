package com.liuzhen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest001 {

//	public static void main(String[] args){
//		String str = "aaa[bbb[ccc,ddd[eee,fff]],ggg[hhh,iii]]"; 
//		Pattern pattern=Pattern.compile("[a-z]{3}\\[([a-z]{3}\\[[a-z]{3},([a-z]{3}\\[[a-z]{3},[a-z]{3}\\])\\]),([a-z]{3}\\[[a-z]{3},[a-z]{3}\\])\\]");
////		Pattern pattern = Pattern.compile("(\\w+(((?'name'\\[)[\\w,]*)+((?'-name'\\])[\\w,]*)+)*(?(name)(?!)))+?");
//		Matcher matcher=pattern.matcher(str);
//		
//		System.out.println(matcher.matches());
//		for(int i=0; i<= matcher.groupCount(); i++) {
//			System.out.println(matcher.group(i));
//		}
//	}

	public static void main(String[] args) {
//		String a = "aaa[bbb[ccc,ddd[eee,fff]],ggg[hhh,iii]]";
//		findMatcher(a);
//		String str = "123x454 5";
//		System.out.println(str.matches("\\d+[ ,#$-*xX]+\\d+"));
//		String[] arr = str.split("[ ,#$-*xX]+");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		String regex = "^0|([1-9]\\d*).\\d*[1-9]$";//"\\d*.\\d*";
		System.out.println("1.1".matches(regex));
		System.out.println("01.1".matches(regex));
		System.out.println("1.10".matches(regex));
		System.out.println("01.10".matches(regex));
		String test001 = "'?''?'\n";
		String test002 = "asfsadf'1?sfsd'dsfasdf'2?'asdfasdf'3?''?'";
		String[] arr = testZLY(test002);
		System.out.println("猪猪猪猪猪");
		for (String s : arr) {
			System.out.println(s);
		}
		System.exit(0);
	}
	private static final Pattern pa = Pattern.compile("[a-z]+\\[(.+\\])");
	
	private static void findMatcher(String input) {
		Matcher m = pa.matcher(input);
		if(m.find()) {
			String outer = m.group(0);
			String inner = m.group(1);
			System.out.println("match str=>"+outer);
			findMatcher(inner);
		} else {
			return;
		}
	}
	
	private static final Pattern pZLY = Pattern.compile("('[^'?]*\\?[^'?]*')+?");
	private static String[] testZLY(String input) {
		Matcher m = pZLY.matcher(input);
		String[] sarr = new String[999];
		int i = 0;
		while (m.find()) {
			sarr[i] = m.group();
			i ++;
		}
		String[] result = new String[i];
		System.arraycopy(sarr, 0, result, 0, i);
		return result;
	}
}
