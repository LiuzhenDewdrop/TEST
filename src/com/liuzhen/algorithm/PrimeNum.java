package com.liuzhen.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PrimeNum {
	public static void main(String[] args) {
		List<Integer> list = getPrimeNums(12);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	private static List<Integer> getPrimeNums(int a) {
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 2; i <= a; i++) {
//			if (isPrimeNum(i)) {
				while (a % i == 0) {
					a = a / i;
					resultList.add(i);
				}
//			}
		}
		return resultList;
	}
	
	private static boolean isPrimeNum(int a) {
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
