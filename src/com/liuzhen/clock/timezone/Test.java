package com.liuzhen.clock.timezone;

import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @class: Test
 * @description: 
 * @author Liuzhen
 */
public class Test {
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
		try {
			Date d = DateUtils.parseDate("2016-11-21", "yyyy-MM-dd");
			System.out.println(d.toGMTString());
			System.out.println(new Date().toGMTString());
			System.out.println(d);
			System.out.println(d.getYear() + 1900 + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日");
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}
}
