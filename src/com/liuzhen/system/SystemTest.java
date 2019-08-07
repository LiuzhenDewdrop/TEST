package com.liuzhen.system;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemTest {

	public static void main(String[] args) {
		testProperty();
		testArrayCopy();
		getHostIp();
		testAssert();
		System.out.println(123);
	}
	
	private static void testProperty() {
		System.setProperty("liuzhen", "123456");
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.dir"));
	}
	
	private static void getHostIp() {
		InetAddress inetAddress = getInetAddress();
		System.out.println("host ip:" + inetAddress == null? null: inetAddress.getHostAddress());  
	}
	
	private static void testArrayCopy() {
		Object[] a = {1, 2, 3, 4};
		Object[] b = {5, 6};
		// System.arraycopy(a, 0, b, 0, 2); 	// 1,2,3,4		1,2
		System.arraycopy(b, 1, a, 3, 1);		// 1,2,3,6		5,6
		printArrays(a, b);
	}
	
	private static void printArrays(Object[] a, Object[] b) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i == a.length - 1) {
				System.out.println();
			} else {
				System.out.print(",");
			}
		}
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
			if (i == b.length - 1) {
				System.out.println();
			} else {
				System.out.print(",");
			}
		}
	}
	
	private static InetAddress getInetAddress(){
		try{
			return InetAddress.getLocalHost();
		}catch(UnknownHostException e){
			System.out.println("unknown host!");
		}
		return null;
	}
	
	/**
	 * @title:  testAssert
	 * @description: 测试断言(需-ea)
	 * @author: Liuzhen
	 * @date:   2017-5-10 16:28
	 */
	private static void testAssert() {
		assert true : true + "正确的";
		System.out.println(123455);
		assert false : false + "错误的";
		System.out.println(123);
	}
}
