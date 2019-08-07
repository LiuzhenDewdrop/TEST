package com.liuzhen.string;

import com.liuzhen.app.util.FileUtil;
import com.liuzhen.app.util.StringUtil;

/*
 * @class: StringReader
 * @description: 
 * @author: L.zhen
 * @date: 2018/5/29 10:32
 */
public class StringReader {
	
	public static void main(String[] args) {
//		test001();
//		test002();
//		test003();
		test004();
	}
	
	private static void printStr(String str) {
		String[] arr = StringUtil.cutByLength(str.split("\n"), 50);
		System.out.println(StringUtil.join(arr, "\n"));
	}
	
	private static void test001() {
		String path = "D:\\Download\\BrowserDownload\\我不喜欢这世界我只喜欢你.txt";
		String content = FileUtil.getContent(path);
		int index = content.indexOf("提问与回答");
		content = content.substring(index);
		content = content.replaceAll("F：", "\nF：")
				.replaceAll("Q：", "\nQ：")
				.replaceAll("。\n", "。")
				.replaceAll("。", "。\n")
				.replaceAll("A：", "\nA：");
		System.out.println(StringUtil.join(StringUtil.cutByLength(content.split("\n"), 50), "\n"));
	}
	
	private static void test002() {
		String str = "";
		printStr(str);
	}
	
	
	private static void test003() {
		String path = "D:\\Download\\BrowserDownload\\log (12).txt";
		String content = FileUtil.getContent(path);
		String[] arr = content.split("\n");
		for (String s : arr) {
			if (s.contains("+调用产品中心导入历史投资接口")) {
//				System.out.println(s);
				String[] arr1 = s.split(",");
				for (String s1 : arr1) {
					if (s1.contains("invest_id")) {
//						System.out.println(s1.replaceAll(" invest_id=", ""));
						System.out.print(s1);
					} else if (s1.contains("repay_amount")) {
						System.out.println(s1);
//						System.out.println(s1.replaceAll(" repay_amount=", ""));
					}
				}
			}
		}
		System.out.println(1);
	}
	
	private static void test004() {
		String path = "D:\\desktop\\Doc\\变现通\\苏瑞\\创建投资2735笔数据.txt";
		String content = FileUtil.getContent(path);
		String[] arr = content.split("\r\n");
		System.out.println(arr.length);
		String strs = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].contains("msg") && arr[i].length() == 107 && i > 14180) {
				String str = arr[i + 3].replace("  \"investNo\" : \"", "").replace("\"", "");
				System.out.println(str);
				strs += str + ",";
			}
		}
		System.out.println(strs);
		String[][] arrs = StringUtil.create(strs, 200);
		StringUtil.print(arrs);
	}
}



