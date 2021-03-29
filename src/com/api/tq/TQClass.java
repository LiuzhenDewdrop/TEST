package com.api.tq;

import com.liuzhen.algorithm.Q_MFromN;
import com.liuzhen.app.util.StringUtils;

/**
 * @class: TQClass
 * @description: 
 * @author: L.zhen
 * @date: 2021/2/17 10:15
 */
public class TQClass {
	
	public static void main(String[] args) {
//		printTest();
		combine();
	}
	
	private static void printTest() {
		String[] ss  = new String[1024];
		Object[][] c = Q_MFromN.getC(Mastery.values(), 2);
		for (Object[] c1 : c) {
			int a = ((Mastery) c1[0]).getCode() + ((Mastery) c1[1]).getCode();
			String s = ((Mastery) c1[1]).getName() + "+" + ((Mastery) c1[0]).getName();
			ss[a] = s;
		}
		for (int i = 0; i < ss.length; i++) {
			if (StringUtils.isNotBlank(ss[i])) {
				System.out.println(StringUtils.printConLenBinary(i, 9, true) + "\t" + ss[i] + "(" + i + ")");
			}
		}
	}
	
	private static void combine() {
		Mastery[] masteries = new Mastery[10];
		System.arraycopy(Mastery.values(), 0, masteries, 0, masteries.length);
		getAAll(masteries, 0);
		
	}
	
	public static void getAAll(Mastery[] masteries, int start) {
		if (start == masteries.length) {
			for (int i = 0; i < masteries.length; i+=2) {
				if (i > 0) {
					System.out.print(", ");
				}
				Profession p = Profession.get(masteries[i].getCode() + masteries[i + 1].getCode());
				if (p == null) {
					System.out.print(masteries[i].getCode() + "+" + masteries[i + 1].getCode() + "找不到");
				} else {
					System.out.print(p.getName() + "(" + masteries[i].getName() + "+" + masteries[i + 1].getName() + ")");
				}
			}
			System.out.println();
		} else {
			for (int i = start; i < masteries.length; i++) {
				if (start % 2 == 0) {
					getAAll(masteries, start + 1);
					break;
				} else {
					Mastery temp = masteries[i];
					masteries[i] = masteries[start];
					masteries[start] = temp;
					getAAll(masteries, start + 1);
					masteries[start] = masteries[i];
					masteries[i] = temp;
				}
			}
		}
	}
}


