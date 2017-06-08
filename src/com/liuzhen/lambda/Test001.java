package com.liuzhen.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @class: Test001
 * @description: 
 * @author Liuzhen
 */
public class Test001 {
	
	private static List<Integer> ints = Arrays.asList(1, 2, 3, 4);
	
	public static void main(String[] args) {
		new Thread( () -> System.out.println("123") ).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("123");
			}
		}).start();
		
		List<String> nameList = Arrays.asList("panther", "peter", "lucy", "jake");
		Collections.sort(nameList, (a, b) -> b.compareTo(a));
		
		nameList.forEach(e -> System.out.println(e));
		
		List<Integer> ints = Arrays.asList(1, 2, 3, 4);
	}
}
