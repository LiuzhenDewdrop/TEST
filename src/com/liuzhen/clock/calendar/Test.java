package com.liuzhen.clock.calendar;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(2016, 2, 31);
		System.out.println(c.getTime());
		c.add(Calendar.MONTH, -1);
		System.out.println(c.getTime());
	}
}
