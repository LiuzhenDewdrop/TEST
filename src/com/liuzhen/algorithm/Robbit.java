package com.liuzhen.algorithm;

public class Robbit {
	
	private int getRobbits(int m) {
		return (m == 1 || m == 2)? 1 : getRobbits(m - 1) + getRobbits(m - 2);
	}
	
	public static void main(String[] args) {
		Robbit r = new Robbit();
		System.out.println(r.getRobbits(7));
		System.out.println(r.fenjie(7680));
		int a = 12;
		int b = 15;
		int c = r.getMaxAndMin(a, b);
		System.out.println("最大公约数:" + c + ",最小公倍数:" + a * b / c);
	}
	
	private String fenjie(int n) {
		String result = "";
		for (int i = 2; i <= n; i++) {
			while (n%i == 0) {
				n /= i;
				result = result.length() == 0 ? result + i : result + "*" + i;
			}
		}
		return result;
	}
	
	private int getMaxAndMin(int a, int b) {
		while (true) {
			a = a % b;
			if (a == 0) {
				return b;
			}
			b = b % a;
			if (b == 0) {
				return a;
			}
		}
		
	}
}
