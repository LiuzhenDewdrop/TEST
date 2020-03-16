package com.liuzhen.jsoup;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * @class: HtmlUtil
 * @description: 
 * @author: L.zhen
 * @date: 2018/7/30 17:21
 */
public class HtmlUtil {
	
	public static Document getHtmlDoc(final String url) {
		try {
			return Jsoup.parse(new URL(url), 3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
	
	}
	
	
	
	
}












