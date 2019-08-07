package com.liuzhen.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * @class: FileUtil
 * @description: 文件工具类
 * @author: L.zhen
 * @date: 2018/5/29 14:23
 */
public class FileUtil {
	
	/*
	 * @title:  getContent
	 * @description: 获取文件内容
	 * @param path	文件路径
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/5/29 14:25
	 */
	public static String getContent(String path) {
		File f = new File(path);
		InputStreamReader ins = null;
		InputStream is = null;
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
