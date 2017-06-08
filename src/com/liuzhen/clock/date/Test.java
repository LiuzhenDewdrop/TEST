package com.liuzhen.clock.date;

import java.util.Date;

/**
 * @class: Test
 * @description: 
 * @author Liuzhen
 */
public class Test {
	public static void main(String[] args) {
		Date d = new Date(117, 2, 16, 15, 20, 30);
//		System.out.println(d.getTime());
		testDateValue(d);
		System.out.println("testDateValue out:" + d);
//		testValue();
	}
	
	private static void testValue() {
		Date d = new Date();
		TestDate t1 = new TestDate();
		t1.setD(d);
		d = new Date(117, 4, 1);
		TestDate t2 = new TestDate();
		t2.setD(d);
		System.out.println("testValue:");
		System.out.println(t1.getD());
		System.out.println(t2.getD());
	}
	
	static class TestDate {
		private Date d;
		public Date getD() {
			return d;
		}
		public void setD(Date d) {
			this.d = d;
		}
	}
	
	private static void testDateValue(Date d) {
		Date d1 = new Date(d.getTime());
		d1.setHours(0);
		System.out.println("testDateValue inner:" + d1);
	}
}
