package com.liuzhen.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest001 {

	public static void main(String[] args) {
		System.out.println("123" + null + "456");
//		test001();
//		parseTest();
//		printFive();
		
		System.exit(0);
	}
	
	private static void test001() {
		String[] arr = ",12,".split(",");
		System.out.println(arr.length);
		System.out.println(arr[0] == null);
		System.out.println(arr[0].equals(""));
//		System.out.println(arr[2]);
		String[] arr1 = ",".split(",");
		System.out.println(arr1.length);
		System.out.println("split测试结束");
		
		String str = "123第三附属";
		String str1;
		try {
//			str1 = new String(str.getBytes("GBK"), "GBK");
			str1 = new String(str.getBytes("UTF-8"), "GBK");
			System.out.println(str1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(Long.parseLong("123456789"));
		String testStr = ",4564,";
		testStr = testStr.substring(1, testStr.length() - 1);
		System.out.println(testStr + ":" + testStr.length());
		System.out.println("substring(0, 0):" + "123".substring(0, 0));
		System.out.println("∞");
	}
	
	private static void parseTest() {
		String name = "成十一电风扇电风扇的";
		try {
			// UTF-8
			// GBK
			// iso8859-1
			// gb2312
			String[] arr = {"UTF-8", "GBK", "iso8859-1", "gb2312"};
			for (String s : arr) {
				for (String s1 : arr) {
					System.out.println("原值：" + name + "，从" + s + "转为：" + s1 + "：" + new String(name.getBytes(s), s1));
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private static void printFive() {
		String str = "甲子年生海中金命（1924，1984）\n" + "\n" + "　　乙丑年生海中金命（1925，1985）\n" + "\n" + "　　丙寅年生炉中火命（1926，1986）\n" + "\n" + "　　丁卯年生炉中火命（1927，1987）\n" + "\n" + "　　戊辰年生大林木命（1928，1988）\n" + "\n" + "　　己巳年生大林木命（1929，1989）\n" + "\n" + "　　庚午年生路旁土命（1930，1990）\n" + "\n" + "　　辛未年生路旁土命（1931，1991）\n" + "\n" + "　　壬申年生剑锋金命（1932，1992）\n" + "\n" + "　　癸酉年生剑锋金命（1933，1993）\n" + "\n" + "　　甲戌年生山头火命（1934，1994）\n" + "\n" + "　　乙亥年生山头火命（1935，1995）\n" + "\n" + "　　丙子年生涧下水命（1936，1996）丁丑年生涧下水命（1937，1997）\n" + "\n" + "　　戊寅年生城头土命（1938，1998）己卯年生城头土命（1939，1999）\n" + "\n" + "　　庚辰年生白蜡金命（1940，2000）辛巳年生白蜡金命（1941，2001）\n" + "\n" + "　　壬午年生杨柳木命（1942，2002）癸未年生杨柳木命（1943，2003）\n" + "\n" + "　　甲申年生泉中水命（1944，2004）乙酉年生泉中水命（1945，2005）\n" + "\n" + "　　丙戌年生屋上土命（1946，2006）丁亥年生屋上土命（1947，2007）\n" + "\n" + "　　戊子年生霹雳火命（1948，2008）己丑年生霹雳火命（1949，2009）\n" + "\n" + "　　庚寅年生松柏木命（1950，2010）辛卯年生松柏木命（1951，2011）\n" + "\n" + "　　壬辰年生长流水命（1952，2012）癸巳年生长流水命（1953，2013）\n" + "\n" + "　　甲午年生砂石金命（1954，2014）乙未年生砂石金命（1955，2015）\n" + "\n" + "　　丙申年生山下火命（1956，2016）丁酉年生山下火命（1957，2017）\n" + "\n" + "　　戊戌年生平地木命（1958，2018）己亥年生平地木命（1959，2019）\n" + "\n" + "　　庚子年生壁上土命（1960，2020）辛丑年生壁上土命（1961，2021）\n" + "\n" + "　　壬寅年生金薄金命（1962，2022）癸卯年生金薄金命（1963，2023）\n" + "\n" + "　　甲辰年生覆灯火命（1964，2024）乙巳年生覆灯火命（1965，2025）\n" + "\n" + "　　丙午年生天河水命（1966，2026）丁未年生天河水命（1967，2027）\n" + "\n" + "　　戊申年生大驿土命（1968，2028）己酉年生大驿土命（1969，2029）\n" + "\n" + "　　庚戌年生钗环金命（1970，2030）辛亥年生钗环金命（1971，2031）\n" + "\n" + "　　壬子年生桑柘木命（1972，2032）癸丑年生桑柘木命（1973，2033）\n" + "\n" + "　　甲寅年生大溪水命（1974，2034）已卯年生大溪水命（1975，2035）\n" + "\n" + "　　丙辰年生沙中土命（1976，2036）丁巳年生沙中土命（1977，2037）\n" + "\n" + "　　戊午年生天上火命（1978，2038）己未年生天上火命（1979，2039）\n" + "\n" + "　　庚申年生石榴木命（1980，2040）辛酉年生石榴木命（1981，2041）\n" + "\n" + "　　壬戌年生大海水命（1982，2042）癸亥年生大海水命（1983，2043）";
		String[] strings = str.split("\n|）");
		int length = 0;
		for (int i = 0; i < strings.length; i++) {
			strings[i] = strings[i].trim().replace((char) 12288 + "", "");
			if (strings[i].length() > 0) {
				length++;
				System.out.println(strings[i]);
			}
		}
		String[] arr = new String[((length - 1) >> 1) + 1];
		int index = 0;
		boolean flag = true;
		for (String string : strings) {
			if (string.length() > 0) {
				if (flag) {
					arr[index] = string;
				} else {
					arr[index] = getPiece(arr[index++], string);
				}
				flag = !flag;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static String getPiece(String str1, String str2) {
		String[] arr1 = str1.split("(年生)|(命（)|，|）");
		String[] arr2 = str2.split("(年生)|(命（)|，|）");
		String result = arr1[0] + arr2[0] + arr1[1] + "(" + arr1[2] + "," + arr2[2]  + "," + arr1[3] + "," + arr2[3] + ")";
		System.out.println(result);
		return result;
	}
}
