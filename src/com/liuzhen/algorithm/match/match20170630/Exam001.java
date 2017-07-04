package com.liuzhen.algorithm.match.match20170630;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @class: Exam001
 * @description: 
 * @author: Liuzhen
 */
public class Exam001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个数字");
		BigDecimal b = sc.nextBigDecimal();
		List<BigDecimal> arr = getArr(b);
		for (BigDecimal temp: arr) {
			System.out.print(temp + ", ");
		}
	}
	
	private static List<BigDecimal> getArr(BigDecimal b) {
		List<BigDecimal> arr = new ArrayList<BigDecimal>();
		if (b.compareTo(new BigDecimal(1)) < 0) {
			return arr;
		}
		arr.add(new BigDecimal(1));
		arr.add(new BigDecimal(1));
		while (arr.get(arr.size() - 1).add(arr.get(arr.size() - 2)).compareTo(b) < 0) {
			arr.add(arr.get(arr.size() - 1).add(arr.get(arr.size() - 2)));
		}
		return arr;
	}
}
