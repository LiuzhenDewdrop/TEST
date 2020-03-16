package com.liuzhen.jsoup;

import java.util.Calendar;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.liuzhen.app.util.StringUtils;

/**
 * @class: JsoupTest001
 * @description: 
 * @author: L.zhen
 * @date: 2019/9/2 17:18
 */
public class JsoupTest001 {
	
	private static final Scanner sc = new Scanner(System.in);

	private static void start() {
		String url = getInput("域名");
		String path = "http://" + url + "/fsm_cms3/tools/querySameBirthday?birthday=";
		String name = getInput("姓名");
		Calendar c = getDate();
		deal(path, name, c);
	}
	
	private static void deal(String path, String name, Calendar c) {
		while (true) {
			String date = fmtDate(c);
			System.out.println("path:" + path + date);
			Document doc = HtmlUtil.getHtmlDoc(path + date);
			if (doc == null) {
				System.out.println("未找到文件");
				return ;
			}
			if (findFromDoc(doc, name)) {
				c.add(Calendar.DATE, 1);
			} else {
				break;
			}
		}
	}
	
	private static boolean findFromDoc(final Document doc, final String name) {
		if (doc.getElementById("query_sameBirthday") == null) {
			return true;
		}
		Elements elements = doc.getElementById("query_sameBirthday").getElementsByTag("tr");
		if (elements == null) {
			System.out.println("处理失败");
			return true;
		}
		for (Element tr : elements) {
			Elements tds = tr.getElementsByTag("td");
			if (tds.size() == 0) {
				continue;
			}
			if (name.equals(tds.get(1).text())) {
				String result = tds.get(1).text() + "ID:" + tds.get(2).text() + "email:" + tds.get(3).text();
				if (!getConfirm("是否继续查找", "/t" + result)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static String getInput(String content) {
		System.out.println("请输入" + content);
		String value = sc.nextLine();
		if (getConfirm(content, value)) {
			return value;
		} else {
			return getInput(content);
		}
	}
	
	private static boolean getConfirm(String key, String value) {
		System.out.println("请确认" + key + "（Y/N）:" + value);
		String confirm = sc.nextLine();
		return "Y".equalsIgnoreCase(confirm);
	}
	
	private static Calendar getDate() {
		String date = getInput("开始日期yyyyMMdd");
		if (StringUtils.isBlank(date) || date.length() != 8) {
			System.out.println("输入日期格式错误!");
			return getDate();
		}
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1, Integer.parseInt(date.substring(6)));
		return c;
	}
	
	private static String fmtDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		return year + "-" + (month < 10 ? "0" : "") + month + "-" + (date < 10 ? "0" : "") + date;
	}
	
	public static void main(String[] args) {
		start();
	}
}
