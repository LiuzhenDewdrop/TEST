package com.liuzhen.clock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * @class: ABHSTest
 * @description: 艾宾浩斯
 * @author: L.zhen
 * @date: 2018/5/3 16:53
 */
public class ABHSTest {

	public static void main(String[] args) {
		printList(createList(createInterval(), new Date(), 5));
	}
	
	private static int[] createInterval() {
		return new int[]{1, 2, 4, 7, 15, 30};
	}
	
	private static List<Date[]> createList(int[] interval, Date startDate, int days) {
		List<Date[]> resultList = new ArrayList<>(days);
		Date[] dates = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		for (int i = 0; i < days; i++) {
			resultList.add(getDates(cal.getTime(), interval));
			cal.add(Calendar.DATE, 1);
		}
		return resultList;
	}
	
	private static Date[] getDates(Date first, int[] interval) {
		Date[] result = new Date[interval.length + 1];
		Calendar cal = Calendar.getInstance();
		cal.setTime(first);
		for (int i = 0; i <= interval.length; i++) {
			result[i] = cal.getTime();
			if (i == interval.length) {
				break;
			}
			cal.add(Calendar.DATE, interval[i]);
		}
		return result;
	}
	
	private static void printList(List<Date[]> list) {
		if (list != null && list.size() > 0) {
			String title = "初始学习时间";
			for (int i = 1; i < list.get(0).length; i++) {
				title += "\t第" + i + "次复习时间";
			}
			System.out.println(title);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Date[] dates : list) {
				String content = "";
				for (Date date : dates) {
					content += sdf.format(date) + "\t";
				}
				System.out.println(content);
			}
		}
	}
}
