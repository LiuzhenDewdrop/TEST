package com.liuzhen.exception;

/*
 * @class: ExceptionTest
 * @description: 
 * @author: L.zhen
 * @date: 2018/8/6 16:01
 */
public class ExceptionTest {
	
	public static void main(String[] args) {
		test002();
	}
	
	private static void test001() {
		try {
//			throw new TestException("throw了一个TestException");
			throw new RuntimeException("throw了一个RuntimeException");
		} catch (TestException e) {
			System.out.println("TestException");
			throw e;
		} catch (RuntimeException e) {
			System.out.println("RuntimeException");
			throw e;
		} catch (Exception e) {
			System.out.println("Exception");
			throw e;
		}
	}
	
	private static void test002() {
		System.out.println(test002_inner());
	}
	
	private static Object test002_inner() {
		int x = 0;
		try {
			System.out.println("try" + x++);
//			int a = 1 / 0;
			return 1 / 0;
//			return "try return" + x++;
		} catch (Exception e) {
			System.out.println("catch" + x++);
//			int b = 1 / 0;
			return "catch return" + x++;
		} finally {
			System.out.println("finally" + x++);
//			return "finally return";
		}
//		return "method return";
	}
}
