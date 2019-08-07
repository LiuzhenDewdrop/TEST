package com.liuzhen.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import sun.security.util.Password;

/*
 * @class: AreaEncode
 * @description: 
 * @author: L.zhen
 * @date: 2018/6/7 15:35
 */
public class AreaEncode {
	
	public static void main(String[] args) {
		test001();
		test002();
	}
	
	private static void test001() {
		System.out.println(word2Number("的发撒旦发射"));
	}
	
	private static void test002() {
//		String content = FileUtil.getContent("src/com/liuzhen/string/AreaEncode.java");
		URL url = AreaEncode.class.getResource("");
		String content = getContent(url.getPath()  + "AreaEncode.class");
		System.out.println(content);
	}
	
	/**
	 * @title:  word2Number
	 * @description: 
	 * @param word
	 * @return 
	 * @author: 刘振
	 * @date:   2018/6/7 16:04
	 */
	private static String word2Number(String word) {
		String num = "";
		try {
			byte[] bytes = word.getBytes("GB2312");
			for (byte b : bytes) {
				num += (b & 0xFF) - 160 + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return num;
	}
	
	public static String getContent(String path) {
		File f = new File(path);
		InputStreamReader ins = null;
		InputStream is = null;
		Password password = new Password();
		StringBuilder stringBuilder = new StringBuilder();
		try {
			is = new FileInputStream(f);
			ins = new InputStreamReader(is);
			while (true) {
				int r = ins.read();
				if (r == -1) {
					break;
				} else {
					stringBuilder.append((char) r);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stringBuilder.toString();
	}
}
