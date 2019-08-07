package com.liuzhen.clock.calendar;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2016, 2, 31);
		System.out.println(c.getTime());
		c.add(Calendar.MONTH, -1);
		System.out.println(c.getTime());
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1.get(Calendar.YEAR) + " " + (c1.get(Calendar.MONTH) + 1) + " " + c1.get(Calendar.DAY_OF_MONTH) + " " + c1.get(Calendar.HOUR_OF_DAY));
		System.out.println(c1.get(Calendar.DATE));
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));
	}
}
