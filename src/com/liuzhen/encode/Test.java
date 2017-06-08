package com.liuzhen.encode;

public class Test {

	public static void main(String[] args) {
		Base64 base64 = new Base64();
		System.out.println(base64.encrypt("s134 "));
		String str = "=T%T.#!!";
		System.out.println(base64.decrypt(str));
		System.exit(0);
	}
}
