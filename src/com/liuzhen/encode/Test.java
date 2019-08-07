package com.liuzhen.encode;

public class Test {

	public static void main(String[] args) {
		Base64 base64 = new Base64(true);
		System.out.println(base64.encrypt("11"));
		String str = "ZGZzZGYzNDUyMzQyM2dkZmc=";
		System.out.println(base64.decrypt(str));
		System.exit(0);
	}
}
