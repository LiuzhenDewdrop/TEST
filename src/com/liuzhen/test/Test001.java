package com.liuzhen.test;

import java.util.ArrayList;
import java.util.List;

public class Test001 {

	public static void main(String[] args) {
		List<Test002> list = new ArrayList<Test002>();
		list.add(new Test002(1, "001"));
		list.add(new Test002(2, "002"));
		list.add(new Test002(3, "003"));
		for (int i = 0; i < list.size(); i++) {
			Test002 t = list.get(i);
			t.setKey(4);
			t.setValue("004");
		}
		for (Test002 t: list) {
			System.out.println(t.getKey() + "\t" + t.getValue());
		}
		System.out.println("end");
		
		switch (1) {
		case 1:
			System.out.println(1111);
		case 2:
			System.out.println(22222);
			break;
		default:
			break;
		}
		System.exit(0);
	}
}
